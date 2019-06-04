package com.SkyTesters.onlifehealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,30);
	}

	public void goTo() {
		this.driver.get("https://sa.onlifehealth.com/");
		this.wait=new WebDriverWait(driver,30);
		this.driver.manage().window().maximize();
		//this.wait.until(ExpectedConditions.visibilityOf(this.loginBtn));
	}
	
	
	public void enterUserDetails(String userName , String password) {
		this.driver.findElement(By.xpath("//section[@class='hero']/section[@class='member-actions']//form[@action='https://sa-member.onlifehealth.com/Default.aspx']/input[@name='username']")).sendKeys(userName);
		this.driver.findElement(By.xpath("//section[@class='hero']/section[@class='member-actions']//form[@action='https://sa-member.onlifehealth.com/Default.aspx']/input[@name='password']")).sendKeys(password);
	}
	
	public void submit() {
		this.driver.findElement(By.xpath("//FORM/BUTTON[contains(string(),'Login') and @class='btn-secondary btn-login']")).click();
	}
}

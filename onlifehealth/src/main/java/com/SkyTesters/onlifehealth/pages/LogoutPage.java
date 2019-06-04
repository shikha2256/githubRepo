package com.SkyTesters.onlifehealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,30);
	}
	public void clickLogo() throws InterruptedException
	{	Thread.sleep(2000);
		this.driver.findElement(By.xpath("//iv[@id='layout']//div[@class='content-wrapper']//div[@class='col-sm-5']/a[2]")).click();
	}
	public void clickLogoutIcon()
	{
		this.driver.findElement(By.xpath("//A[@id='userActions']/I[@class='icon icon-onlife-chevron-down']")).click();
	}
	public void clickLogout()
	{
		this.driver.findElement(By.xpath("//A[@href='/Logout.aspx']")).click();
	}
	
	
}

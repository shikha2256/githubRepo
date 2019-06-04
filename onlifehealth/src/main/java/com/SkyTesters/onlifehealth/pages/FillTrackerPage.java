package com.SkyTesters.onlifehealth.pages;
//comment
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillTrackerPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public FillTrackerPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}
	public void addRemove() 
	{
		this.driver.findElement(By.xpath("//div[@id='layout']//div[@class='content-wrapper']/div/div[3]/div[@class='row']/div[2]/div[@class='layer olh-actionbar-block']//a[@href='/BioDevices/Management']")).click();
	}
	public void viewAll() 
	{
		this.driver.findElement(By.xpath("//BUTTON[@id='olh-filter-challenge']")).click();
	}
	public void clickNutrition() 
	{
		this.driver.findElement(By.xpath("//div[@id='main-content']/div[@class='row']/div[@class='col-sm-12 push-top-large']//ul[@class='dropdown-menu']/li[3]/a[@role='button']/span")).click();
	}
	public String getFirstItem() 
	{
		String firstItem=this.driver.findElement(By.xpath("//DIV[@class='col-xs-12 push-medium-top text-center']/P[@class='text-center olh-device-tile-name' and contains(string(),'Fitbit')]")).getText();
		return firstItem;
	}
	public String getSecondItem() 
	{
		String secondItem=this.driver.findElement(By.xpath("//DIV[@class='col-xs-12 push-medium-top text-center']/P[@class='text-center olh-device-tile-name' and contains(string(),'MyFitnessPal')]")).getText();
		return secondItem;
	}
	
	
	
		
}

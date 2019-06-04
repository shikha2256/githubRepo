package com.v7.AndroidTest.Page;

import com.skytesters.keywords.AppiumKeywords;
import com.skytesters.keywords.SeleniumKeywords;

public class Page_BuyProduct {

	String currentClassName = "";
	
	public Page_BuyProduct() 
	{
		//AppiumKeywords.setDriver();
		currentClassName = this.getClass().getSimpleName();
	}
	
	private void searchProduct() {
		AppiumKeywords.setText(currentClassName, "SearchBar", "iphone x mobile");
	}
	
	private void clickSearch() {
		AppiumKeywords.tap(currentClassName, "SearchedLink");
	}
	
	
	
	private void selectProduct() {
		try {
		AppiumKeywords.tap(currentClassName, "SearchedProduct");	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*private void moveToProductTab() {
		SeleniumKeywords.switchToTab();
	}
	
	public String getSearchedProductTitle() {
		String text = null;
		text=SeleniumKeywords.GetText(currentClassName, "productTitle");
		return text;
		
	}*/
	
	/*public void addToCart() {
		AppiumKeywords.scrollAndClick(scrollableList, uiSelector, text);(currentClassName, "AddToCart");
	}*/
	
	public void verifyAddToCart() {
		searchProduct();
		clickSearch();
		selectProduct();
		//moveToProductTab();
		
		
	}
}

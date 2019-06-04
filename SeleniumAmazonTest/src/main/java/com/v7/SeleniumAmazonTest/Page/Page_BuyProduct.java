package com.v7.SeleniumAmazonTest.Page;

import com.skytesters.keywords.SeleniumKeywords;

public class Page_BuyProduct {

	String currentClassName = "";
	
	public Page_BuyProduct() 
	{
		try {
			//SeleniumKeywords.setDriver();
			currentClassName = this.getClass().getSimpleName();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void searchProduct() {
		try {
			SeleniumKeywords.setText(currentClassName, "SearchBar", "iphone x mobile");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void clickSearch() {
		try {
		SeleniumKeywords.clickBtn(currentClassName, "SearchButton");
		}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	
	
	private void selectProduct() {
		try {
			SeleniumKeywords.clickBtn(currentClassName, "SearchedProduct");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void moveToProductTab() {
		try {
			SeleniumKeywords.switchToTab();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getSearchedProductTitle() {
		String text = null;
		try {
			System.out.println("we are in try block with searched product");
			text=SeleniumKeywords.GetText(currentClassName, "productTitle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
		
	}
	
	public void addToCart() {
		try {
			SeleniumKeywords.clickBtn(currentClassName, "AddToCart");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyAddToCart() {
		try {
			searchProduct();
			clickSearch();
			selectProduct();
			moveToProductTab();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

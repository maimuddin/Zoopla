package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class Search_page {
	
	@FindBy(how = How.XPATH, using = "//input[@id='search-input-location']")
	public WebElement search_box;
	
	@FindBy(how = How.XPATH, using = "//button[@id='search-submit']")
	public WebElement search_button;
	
	public Search_page() {
		//System.out.println("Hello");
	}
	
}

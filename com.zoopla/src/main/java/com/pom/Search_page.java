package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class Search_page extends TestBase {
	
	@FindBy(xpath = "//input[@id='search-input-location']")
	WebElement search_box;
	
	@FindBy(xpath = "//button[@id='search-submit']")
	WebElement search_button;
	
	public Search_page() {
		PageFactory.initElements(driver,this);
	}
	
	public void searchBox(String search){
		search_box.sendKeys(search);
	}
	
	public void searchButton(){
		search_button.click();
	}
	
}

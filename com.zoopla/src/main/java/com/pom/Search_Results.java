package com.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Search_Results {
	
	public Search_Results(){	
	}
	
	private By getAmount = By.xpath(".//a[contains(@class, 'listing-results-price text-price')]");
	
	private By getAddress = By.xpath(".//a[contains(@class, 'listing-results-address')]");
	
	
	@FindBy(how = How.XPATH, using = "//li[contains(@id, 'listing_')]")
	public List<WebElement> results;
	
	public WebElement getAmountElement(int n){
			return results.get(n-1).findElement(getAmount);	
	}
	public WebElement getAddressElement(int n){
		return results.get(n-1).findElement(getAddress);	
}
}

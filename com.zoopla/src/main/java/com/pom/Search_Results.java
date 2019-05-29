package com.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class Search_Results {
	
	JavascriptExecutor js;
	
	public Search_Results(){
		js = (JavascriptExecutor)TestBase.driver;
	}
	
	private By getAmount = By.xpath(".//a[contains(@class, 'listing-results-price text-price')]");
	
	private By getAddress = By.xpath(".//a[contains(@class, 'listing-results-address')]");
	
	
	@FindBy(how = How.XPATH, using = "//li[contains(@id, 'listing_')]")
	public List<WebElement> results;
	
	/***
	 * Get the total amount of nth entity
	 * @param n integer value of getting nth data
	 * @return WebElement object
	 */
	public WebElement getAmountElement(int n){
			return results.get(n-1).findElement(getAmount);	
	}
	
	/***
	 * Get the total address of nth entity
	 * @param n integer value of getting nth data
	 * @return WebElement object
	 */
	public WebElement getAddressElement(int n){
		return results.get(n-1).findElement(getAddress);	
}
	
	@FindBy(xpath = "//span[@name='page_size']/following::select[1]")
	WebElement page_size;
	
	public void pageSize(String pagesize){
		Select sel = new Select(page_size);
		sel.selectByVisibleText(pagesize);
	}
	
	@FindBy(xpath = "//span[@class = 'listing-results-utils-tooltip']/button[1]")
	private WebElement toolkit;
	
	@FindBy(xpath = "//img[@class =' lazy']")
	WebElement lazy;
	
	public void closeToolkit(){
		if(toolkit.isDisplayed()){
			js.executeScript("arguments[0].click();", toolkit);
		}
	}
	
	public void disableLazyImg(int n){
		if(lazy.isDisplayed()){
			js.executeScript("arguments[0].disabled();", lazy);
		}
	}
}

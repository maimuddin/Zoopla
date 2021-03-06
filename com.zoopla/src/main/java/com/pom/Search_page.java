package com.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/***
 * 
 * @author Maimuddin
 * All the search page webelements should be defined in this class 
 *
 */
public class Search_page {
	
	public Search_page() {
		
	}
	/***
	 * search box WebElement
	 */
	@FindBy(how = How.XPATH, using = "//input[@id='search-input-location']")
	public WebElement search_box;
	
	@FindBy(how = How.XPATH, using = "//button[@id='search-submit']")
	public WebElement search_button;
	
	@FindBy(how = How.XPATH, using = "//button[@class = 'button cookie-banner__button']")
	private WebElement cookie;
	
	@FindBy(tagName = "a")
	private List<WebElement> links;
	

	public List<WebElement> getLinks() {
		List<WebElement> list = new ArrayList<WebElement>();
		for(WebElement el : links) {
			list.add(el);
		}
		return list;
	}
	
	public void acceptCookie() {
		if(cookie.isDisplayed()) {
			cookie.click();
		}
	}
}

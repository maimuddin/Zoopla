package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/***
 * 
 * @author Maimuddin
 *This is the class for WebElements object creations of selected result page 
 */
public class Select_Result {
	
	@FindBy(xpath = "//p[@class='ui-pricing__main-price ui-text-t4']")
	public WebElement amount;
	
	@FindBy(xpath = "//h2[@class='ui-property-summary__address']")
	public WebElement address;
	
	@FindBy(xpath = "//span[contains(text(), 'Back to search results')]")
	public WebElement backToSearch;

}

package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Select_Result {
	
	@FindBy(xpath = "//p[@class='ui-pricing__main-price ui-text-t4']")
	public WebElement amount;
	
	@FindBy(xpath = "//h2[@class='ui-property-summary__address']")
	public WebElement address;

}

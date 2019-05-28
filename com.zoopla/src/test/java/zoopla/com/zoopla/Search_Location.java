package zoopla.com.zoopla;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pom.Search_Results;
import com.pom.Search_page;
import com.pom.Select_Result;

public class Search_Location extends TestBase {
	
	Search_page search;
	Search_Location s;
	Search_Results result;
	Select_Result s_result;
	
	public Search_Location() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		s = new Search_Location();
		initilization();
		search = PageFactory.initElements(driver, Search_page.class);
		result = PageFactory.initElements(driver, Search_Results.class);
		s_result = PageFactory.initElements(driver, Select_Result.class);
		
	}

	@Test
	public void search(){
		search.acceptCookie();
		search.search_box.sendKeys("London");
		search.search_button.click();
		String amount = result.getAmountElement(5).getText();
		String address = result.getAddressElement(5).getText();
		amount = amount.replaceAll("\\D+", "");
		result.getAmountElement(5).click();
		
		//s_result.amount.getText().replaceAll("\\D+", "");
		//s_result.address.getText();
		Assert.assertEquals(s_result.amount.getText().replaceAll("\\D+", ""), amount);
		Assert.assertEquals(s_result.address.getText(), address);		
	}
}

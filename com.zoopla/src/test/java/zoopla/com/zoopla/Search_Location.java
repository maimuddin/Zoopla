package zoopla.com.zoopla;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	WebDriverWait wait;
	
	public Search_Location() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		s = new Search_Location();
		initilization();
		wait = new WebDriverWait(driver, 30);
		search = PageFactory.initElements(driver, Search_page.class);
		result = PageFactory.initElements(driver, Search_Results.class);
		s_result = PageFactory.initElements(driver, Select_Result.class);
		
	}

	@Test
	public void search(){
		search.acceptCookie();
		search.search_box.sendKeys("London");
		search.search_button.click();
		result.pageSize("25");
		result.closeToolkit();
		for(int i=1;i<=25;i++){
			String amount = result.getAmountElement(i).getText();
			String address = result.getAddressElement(i).getText();
			amount = amount.replaceAll("\\D+", "");
			//wait.until(ExpectedConditions.elementToBeClickable(result.getAmountElement(i)));
			//result.closeToolkit();
			result.disableLazyImg(i);
			result.getAmountElement(i).click();
			Assert.assertEquals(s_result.amount.getText().replaceAll("\\D+", ""), amount);
			Assert.assertEquals(s_result.address.getText(), address);
			s_result.backToSearch.click();
			//nevigateBack();
		}
	}
}

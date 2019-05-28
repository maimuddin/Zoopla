package zoopla.com.zoopla;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pom.Search_Results;
import com.pom.Search_page;

public class Search_Location extends TestBase {
	
	Search_page search;
	Search_Location s;
	Search_Results result;
	
	public Search_Location() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		s = new Search_Location();
		initilization();
		search = PageFactory.initElements(driver, Search_page.class);
		result = PageFactory.initElements(driver, Search_Results.class);
		
	}

	@Test
	public void search(){
		search.acceptCookie();
		search.search_box.sendKeys("London");
		search.search_button.click();
		System.out.println(result.getAddressElement(5).getText());
		System.out.println(result.getAmountElement(5).getText());
		
	}
}

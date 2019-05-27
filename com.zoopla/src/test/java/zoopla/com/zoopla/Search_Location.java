package zoopla.com.zoopla;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pom.Search_page;

public class Search_Location extends TestBase {
	
	Search_page search;
	Search_Location s;
	
	public Search_Location() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		s = new Search_Location();
		initilization();
		search = PageFactory.initElements(driver, Search_page.class);
	}

	@Test
	public void search(){
		search.search_box.sendKeys("London");
		search.search_button.click();
		search.acceptCookie();
	}
}

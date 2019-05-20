package zoopla.com.zoopla;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pom.Search_page;

public class Search_Location extends TestBase {
	
	Search_page search;
	
	public Search_Location() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initilization();
		search = new Search_page();
	}

	@Test
	public void search(){
		search.searchBox("London");
		search.searchButton();
	}
}

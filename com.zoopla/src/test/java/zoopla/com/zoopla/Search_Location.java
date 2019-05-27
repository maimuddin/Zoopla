package zoopla.com.zoopla;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pom.Search_page;

public class Search_Location extends TestBase {
	
	Search_page search;
	Search_Location s;
	
	public Search_Location() {
		super();
		System.out.println("Search_Location");
	}
	
	@BeforeMethod
	public void setup(){
		s = new Search_Location();
		search = new Search_page();
		initilization();
	}

	@Test
	public void search(){
		search.searchBox("London");
		search.searchButton();
	}
}

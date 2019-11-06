package zoopla.com.zoopla;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.TestBase;
import com.pom.Search_page;
import com.util.TakeScreenShot;

public class ValidateLinks extends TestBase {
	
	Search_page search;
	ValidateLinks links;
	
	public ValidateLinks() {
		super();
	}
	
	@BeforeMethod
	public void initialization() {
		links = new ValidateLinks();
		super.initilization();
		search = PageFactory.initElements(driver, Search_page.class);
	}
	
	@Test
	public void validateLinks() throws MalformedURLException, IOException {
		List<WebElement> list = new ArrayList<WebElement>();
		search.acceptCookie();
		list = search.getLinks();
		SoftAssert softAssert = new SoftAssert();
		for(WebElement el : list) {
			String url = el.getAttribute("href");
			System.out.println(url);
			if(url == null || url.isEmpty()) {
				softAssert.assertTrue(false, "URL either null or is empty");
			}
			else {
				HttpURLConnection huc = (HttpURLConnection) new URL(url).openConnection();
				int responseCode = huc.getResponseCode();
				System.out.println(responseCode);
				softAssert.assertFalse(responseCode >= 400);
			}
		}
		softAssert.assertAll();
	}
	
	@AfterMethod
		public void tearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			TakeScreenShot.takeScreenShot(Search_Location.class.getName());
		}
	}

}

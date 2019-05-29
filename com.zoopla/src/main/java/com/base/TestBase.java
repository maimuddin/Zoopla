package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/***
 * 
 * @author Maimuddin
 * 
 * This is base class to initialize driver according to browser (Firefox or Chrome only) 
 *
 */

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	private static int pagetimeout;
	private static int impli_timeout;

	/***
	 * Constructor of TestBase which initialize properties object and load the properties file 
	 */
	public TestBase(){
		prop = new Properties();
		try{
			FileInputStream fl = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/config/config.properties");
			prop.load(fl);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/***
	 * This method initialize the driver and open the browser according to mentioned in properties file, Maximize the window, delete all cookies
	 *  and implement page timeout and implicite timeout  
	 */
	public static void initilization() {
		String browser = prop.getProperty("browser");
		pagetimeout = Integer.parseInt(prop.getProperty("pagetimeout"));
		impli_timeout = Integer.parseInt(prop.getProperty("implicite_timeout"));
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("", "");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/com/util/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(pagetimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(impli_timeout, TimeUnit.SECONDS);
		
		
	}
	
	/***
	 * Navigate back from current page
	 */
	public static void nevigateBack(){
		driver.navigate().back();
	}
	
	
}

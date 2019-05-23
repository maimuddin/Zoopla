package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	private static int pagetimeout;
	private static int impli_timeout;
	
	public TestBase(){
		prop = new Properties();
		try{
			FileInputStream fl = new FileInputStream(System.getProperty(("user.dir")+"/com.zoopla/src/main/java/com/config/config.properties"));
			prop.load(fl);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void initilization(){
		String browser = prop.getProperty("browser");
		pagetimeout = Integer.parseInt(prop.getProperty("pagetimeout"));
		impli_timeout = Integer.parseInt(prop.getProperty("implicite_timeout"));
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("", "");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", ("user.dir")+"/com.zoopla/src/main/java/com/util/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(pagetimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(impli_timeout, TimeUnit.SECONDS);
	}
}

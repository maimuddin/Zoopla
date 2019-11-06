package com.util;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import com.base.TestBase;

public class TakeScreenShot extends TestBase {
	public static void takeScreenShot(String name) {
		File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(shot, new File(System.getProperty("user.dir")+"/screenShot/"+name+".png"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

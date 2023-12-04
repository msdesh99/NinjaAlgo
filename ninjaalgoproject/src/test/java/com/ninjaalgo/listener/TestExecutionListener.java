package com.ninjaalgo.listener;

	 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

import io.qameta.allure.Attachment;
	 
	public class TestExecutionListener implements ITestListener {
	 
	   @Attachment(value = "Screenshot of {0}", type = "image/png")
	   public static byte[] saveScreenshot(String name, WebDriver driver) {
	       return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	   }
	   @Attachment(value = "{0}", type="text/plain")
	   public static String saveTextLog(String message) {
		   return message;
	   }
/*	   @Override
	   public void onTestSuccess(ITestResult result) {
	       //saveScreenshot(result.getName(), DriverFactory.getDriver());
	   }
	public static String getTestMethodName(ITestResult result) {
		return result.getMethod().   getConstructorOrMethod().getName();
	}*/
	 
	}



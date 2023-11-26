package com.ninjaalgo.utils;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ninjaalgo.driverfactory.DriverFactory;


//public class ScreenShot extends AllActions{
public class ScreenShot{
	public ScreenShot() {
		super();
	}

	public String TCName = "DataQuestionBug";
	public String dir = System.getProperty("user.dir")+"/src/test/resources/screenshots/";
	//String dir = ".//src/test/resources/screenshots/";

	//Add code to check if directory is exists or not
	public String path="";
	
    public void CatchScreenShot(String stepName, WebDriver driver) throws IOException, HeadlessException, AWTException{
		try {
			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File rawFile = screenShot.getScreenshotAs(OutputType.FILE);
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //timestamp from .sql
			String date = timestamp.toString().replaceAll(":", "_");
			path = dir+TCName +"/screenshot_"+stepName+"_"+date+".jpeg";
	
			File destiFile = new File(path);
			FileUtils.copyFile(rawFile, destiFile);
		
		}catch(Exception e) {
			BufferedImage alertsScreenshot = new Robot().createScreenCapture(
					new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //timestamp from .sql
			String date = timestamp.toString().replaceAll(":", "_");
			path = dir+TCName +"/screenshot_"+stepName+"_"+date+".jpg";
			
			ImageIO.write(alertsScreenshot, "png", new File(path));
		}
 	}

	public static void main(String[] args) throws IOException, HeadlessException, AWTException {
		//WebDriver driver;
        WebDriver driver = DriverFactory.getDriver();
		String url ="https://www.selenium.dev/";
		//String url ="https://www.selenium.dev/documentation/webdriver/interactions/alerts/";
		
		driver = new ChromeDriver();
		driver.get(url);
		//WebElement element = driver.findElement(By.linkText("See an example alert"));
		//ClickElement(element, driver);
		ScreenShot scrshot = new ScreenShot();
		scrshot.CatchScreenShot("seleniumHomePage", driver);
		//driver.quit();
	}
}

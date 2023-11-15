/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/

package com.ninjaalgo.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllActions {
	static JavascriptExecutor js;
	static Actions action;
	static Alert alert;
	static String path;
	
	public static void SendKeysElement(WebDriver driver, WebElement element, String inputString) {
		action = new Actions(driver);
		//action.sendKeys(inputString).perform();
		action.sendKeys(element, inputString).build().perform();
		//action.moveToElement(ele).click().build().perform();	

	//	js = (JavascriptExecutor) driver;
		//js.executeScript("document.getElementById('id_username').setAttribute('value', 'NinjaAlgo')");
	//	js.executeScript("document.getElementByName('element').setAttribute('value', 'inputString')");
	}
	public static void ClickArrElement(WebDriver driver, WebElement[] element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();arguments[1].click();", element[0], element[1]);
	}

	public static boolean ClickElement(WebElement element, WebDriver driver) {
		WebElement ele;
		try {
		ele =  DriverWaitForElement(driver, element);
		if(ele.isDisplayed()) {
			if(ele.isEnabled()) {			 
				try {
					action = new Actions(driver);
					action.moveToElement(ele).click().build().perform();	
					return true;
				} catch (Exception e) {
					js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click()", element);
					return true;					
				}
	
			}else  throw new Exception("Element not enabled"); 				
		}else throw new Exception("Element is not displayed");
			
	  } catch (Exception e) {
		e.printStackTrace();
		return false;
	  }
	}
	public void Quit_Driver(WebDriver driver) {
		driver.quit();
	}
    public static void DriverImpliciteWait(WebDriver driver) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }
    public static void DriverExplicitWait(WebDriver driver, Duration timeInSec) {
        new WebDriverWait(driver, timeInSec);
    }
	public static void DriverWaitForLocatorOrUrl(WebDriver driver, By locator, String url) {
	new WebDriverWait(driver,Duration.ofSeconds(5))
	  .until(ExpectedConditions.or(
			  ExpectedConditions.visibilityOfElementLocated(locator),
			  ExpectedConditions.urlContains(url))) ;
}
	public static WebElement CallDriverWait(WebDriver driver, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(6))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
	public static WebElement FindElementWithLocator(WebDriver driver, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static void DriverWaitForUrl(WebDriver driver, String url) {
		new WebDriverWait(driver, Duration.ofSeconds(3))
		    .until(ExpectedConditions.urlMatches(url));
	}
	public static WebElement DriverWaitForElement(WebDriver driver, WebElement element) {		
		WebElement ele =  new WebDriverWait(driver, Duration.ofSeconds(6))
				.until(ExpectedConditions.visibilityOf(element));
		return ele;
	}
	public static void DriverWaitForTextAndVisible(WebDriver driver, WebElement element, String text) {		
	new WebDriverWait(driver, Duration.ofSeconds(6))
		.until(ExpectedConditions.and(
		ExpectedConditions.textToBePresentInElement(element, text),
		ExpectedConditions.visibilityOf(element)));
}
	public static String WaitAndClickAlert(WebDriver driver) {
			try {
				alert = new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.alertIsPresent());
				String alertText = alert.getText();
				System.out.println(alertText);
				alert.accept();			
				return alertText;
			} catch (Exception e) {
				new Exception("Alert element Not Found: "+e);
				return null;
			}		
	}
	public static void ScrollToElementjs(WebDriver driver, WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

 }

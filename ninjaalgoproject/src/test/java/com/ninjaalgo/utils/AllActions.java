/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/

package com.ninjaalgo.utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllActions {
	static JavascriptExecutor js;
	static Actions action;
	static Alert alert;
	static String path;
	
	public static void SendKeysElement(WebDriver driver, WebElement element, String inputString) {
		action = new Actions(driver);
		action.sendKeys(element, inputString).build().perform();
	}
	public static void ClickArrElement(WebDriver driver, WebElement[] element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();arguments[1].click();", element[0], element[1]);
	}
	public static void ClickRegisterArrElement(WebDriver driver, WebElement[] element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();arguments[1].click();arguments[2].click();", element[0], element[1],element[2]);
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
	new WebDriverWait(driver,Duration.ofSeconds(6))
	  .until(ExpectedConditions.or(
			  ExpectedConditions.visibilityOfElementLocated(locator),
			  ExpectedConditions.urlContains(url))) ;
}
	
	public static WebElement FindElementWithLocator(WebDriver driver, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(7))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static void DriverWaitForUrl(WebDriver driver, String url) {
		new WebDriverWait(driver, Duration.ofSeconds(6))
		    .until(ExpectedConditions.urlMatches(url));
	}
	public static WebElement DriverWaitForElement(WebDriver driver, WebElement element) {		
		WebElement ele =  new WebDriverWait(driver, Duration.ofSeconds(6))
				.until(ExpectedConditions.visibilityOf(element));
		return ele;
	}
	public static void DriverWaitForClickable(WebDriver driver, By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(6))
		.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public static WebElement CallDriverWait(WebDriver driver, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(6))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
	public static void TextIndentation(WebDriver driver, WebElement pythonElement, int row, int space,boolean flag) {
		 action = new Actions(driver);
	       // Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;
		for(int i=1;i<=row;i++) {
		      action.sendKeys(Keys.ARROW_UP).keyUp(Keys.SHIFT).perform();
		       for(int j=1;j<=space;j++) {
	            if(i==1 && flag) action.sendKeys(Keys.BACK_SPACE).perform();
	            else action.sendKeys(Keys.DELETE).perform();
			   }
		}  
	}	
	public static void TextIndentationForPractice(WebDriver driver, WebElement pythonElement) {
		 action = new Actions(driver);
		      action.keyDown(Keys.CONTROL).sendKeys(Keys.chord("a")).keyUp(Keys.CONTROL).perform();
		      //action.sendKeys(Keys.chord(Keys.CONTROL, "a")).perform();
		      action.sendKeys(Keys.DELETE).perform();		      
	}	
	public static String DriverWaitForElementOrAlert(WebDriver driver, WebElement pythonResult) {
		    String output=null;
	         try {
	           alert = new WebDriverWait(driver, Duration.ofSeconds(4))
	            		.until(ExpectedConditions.alertIsPresent());  
	            		     try {
	            		    	 output = driver.switchTo().alert().getText();

							} catch (Exception e) {
	         	            	DriverWaitForElement(driver, pythonResult);
							}
	 	         	        alert.accept();		 
	         } catch (Exception e) {
			 }
	         return output;
	    }
		
    public static void ScreenScrollDown(WebDriver driver) {
    	js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,350)", "");
    }	
    public static void GoToParentWindowHandle(WebDriver driver, String parentWindowHandler) {
		Set<String> s = driver.getWindowHandles();
	
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
		String child_window = I1.next();
		System.out.println("itr parent han: "+parentWindowHandler);
		System.out.println("itr child han: "+child_window);

		if (parentWindowHandler.equals(child_window)) {
		    driver.switchTo().window(parentWindowHandler);
			//return FindElementWithLocator(driver,locator);
		   // element1.click() 
		    break;
		}
	   }
}
	public static WebElement GetCurrentWindowHandle(WebDriver driver, By locator) {
		String parent = driver.getWindowHandle();
		System.out.println("parent han: "+parent);
		//FindElementWithLocator(driver,locator);
		//driver.findElement(By.xpath("//*[@id='answer_form']//*[contains(@class,'CodeMirror')]//textarea")).click();
		Set<String> s = driver.getWindowHandles();
	
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
		String child_window = I1.next();
		System.out.println("itr parent han: "+parent);
		System.out.println("itr child han: "+child_window);

		if (!parent.equals(child_window)) {
		    driver.switchTo().window(child_window);
			return FindElementWithLocator(driver,locator);
		   // element1.click() 
		}
	   }
		return null;	
}
 }

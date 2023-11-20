/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.steps;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.HomePage;
import com.ninjaalgo.pages.LoginPage;
import com.ninjaalgo.pages.StartPage;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;
import com.ninjaalgo.utils.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps{
    String currentUrl;
    static  WebDriver driver;
    public static String parentWindowHandle;
   // ConfigReader configReader;
    StartPage startPage;   
    HomePage homePage;
    LoginPage loginPage;
    
    public CommonSteps() {
		super();
		//ConfigReader configReader = new ConfigReader();
	}
    
	@Then("Verify currentUrl {string} and {string}")
	public void verify_current_url_and(String url, String type) {	
        url = url.replace(" ","-").toLowerCase()+"/";
		    if (type.contentEquals("module"))VerifyURl(url);
		    else if(type.contentEquals("start")) VerifyURl("home");
		    else VerifyURl(url+type);
	}
	            
	@Then("verify {string} in Common")
	public void verify_in_common(String url) {
	     VerifyURl(url);
	}
	@Then("verifyBug {string} {string} in common")
	public void verify_bug_in_common(String actual, String expected) {
		 VerifyURl("register");
	     String bugReport ="Actual :"+actual +"Expected: "+expected;		
		 LoggerLoad.error("<=====Bug Found on Register page: "+ bugReport);	
		 WebDriver driver = DriverFactory.getDriver();
		 //driver.get(ConfigReader.getModuleUrl().toString());
	}	
	@Then("Quit Driver")
	public void QuitDriver() {
		DriverFactory.CloseDriver();
	}
	public void VerifyURl(String url) {
		   WebDriver driver = DriverFactory.getDriver();
			currentUrl =  ConfigReader.getBaseUrl()+"/"+ url;
		    AllActions.DriverWaitForUrl(driver, currentUrl);
			boolean testOutput = currentUrl.contentEquals(driver.getCurrentUrl()) ? true : false;
			Assert.assertEquals(testOutput, true);
			Assert.assertTrue(testOutput);
	}
	public void VerifyPython(String actual, String expected) {
		if(actual.contentEquals(expected)) {
	     String report ="Actual :"+actual +"Expected: "+expected;		
	      LoggerLoad.info("<=====Test For Try here>>>  is Passed. Output is: "+expected);	
		 WebDriver driver = DriverFactory.getDriver();
		 driver.get(ConfigReader.getModuleUrl().toString());
		}	 
	}
		public static String getParentWindowHandler() {
			return parentWindowHandle;		
		}
}


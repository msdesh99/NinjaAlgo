/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.listener.TestExecutionListener;
import com.ninjaalgo.pages.HomePage;
import com.ninjaalgo.pages.LoginPage;
import com.ninjaalgo.pages.PracticeQuestionPage;
import com.ninjaalgo.pages.StartPage;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;
import com.ninjaalgo.utils.LoggerLoad;

import io.cucumber.java.en.Then;

public class CommonSteps{
    static String currentUrl;
    static  WebDriver driver;
    public static String parentWindowHandle;
    StartPage startPage;   
    HomePage homePage;
    LoginPage loginPage;
    String parentUrl="";
    PracticeQuestionPage practiceQuestionPage;
    
    public CommonSteps() {
		super();
		//ConfigReader configReader = new ConfigReader();
	}
    
	@Then("Verify currentUrl {string} and {string}")
	public static void verify_current_url_and(String url, String type) {	
        url = url.replace(" ","-").toLowerCase()+"/";
		    if (type.contentEquals("module"))VerifyURl(url);
		    else if(type.contentEquals("start")) VerifyURl("home");
		    else if(type.contentEquals("headerBug")) VerifyURl("headerBug");
		    else VerifyURl(url+type);
	}
	            
	@Then("verify {string} in Common")
	public static void verify_in_common(String url) {
	     VerifyURl(url);
	}
	@Then("verifyBug {string} {string} {string} in common")
	public static  void verify_bug_in_common(String actual, String expected, String type) {
		if(type.contentEquals("register")) {
			VerifyURl("register");
			type="Register page";}
		else if(type.contentEquals("headerBug")) {
			VerifyURl("headerBug");
			type="Header Link";}

	     String bugReport ="Actual :"+actual +"Expected: "+expected;		
		 LoggerLoad.error("<=====Bug Found on "+type+" : "+ bugReport);	
		 TestExecutionListener.saveScreenshot(bugReport, DriverFactory.getDriver());
		 TestExecutionListener.saveTextLog(bugReport);
	}

	@Then("Quit Driver")
	public static void QuitDriver() {
		DriverFactory.CloseDriver();
	}
	@Then("Select DropDown")
	public void select_drop_down() throws Exception {
        WebDriver driver = DriverFactory.getDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
	    homePage.SelectDropDown();
	}	
	@Then("Click Header")
	public void click_header() {
	     WebDriver driver = DriverFactory.getDriver();
	     homePage = PageFactory.initElements(driver, HomePage.class);
		 homePage.ClickHeader();		
	}
	public static void VerifyURl(String url) {
		   WebDriver driver = DriverFactory.getDriver();
		   if(url.contentEquals("headerBug"))
				currentUrl =  ConfigReader.getBaseUrl()+"/";
		   else	
			currentUrl =  ConfigReader.getBaseUrl()+"/"+ url;
		    AllActions.DriverWaitForUrl(driver, currentUrl);
			boolean testOutput = currentUrl.contentEquals(driver.getCurrentUrl()) ? true : false;
			Assert.assertEquals(testOutput, true);
			Assert.assertTrue(testOutput);
	}
	public void VerifyPython(String actual, String expected, String topic) {
		if(actual.contentEquals(expected)) {
	    // String report ="Actual :"+actual +"Expected: "+expected;		
	      LoggerLoad.info("<=====Test For "+topic +">>> is Passed. Output is: "+expected);	
		 WebDriver driver = DriverFactory.getDriver();
		 driver.get(ConfigReader.getModuleUrl().toString());
		}	 
		
		
	}
}


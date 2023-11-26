/*Code details:
	#Author: Meenakshi Dated: 7-Nov-2023
*/
package com.ninjaalgo.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.DataStructurePage;
import com.ninjaalgo.pages.HomePage;
import com.ninjaalgo.pages.StartPage;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DDataParallelClassStep {

	DataStructurePage dataStructurePage;
	HomePage homePage;
	//CommonSteps commonSteps;
	WebDriver driver;
	StartPage startPage;
	public String currentUrl;
	
	@Given("GetStarted")
	public void get_started() {
		//DriverFactory.getDriver();
		startPage = PageFactory.initElements(DriverFactory.getDriver(), StartPage.class);
		startPage.ClickButton();
	}

	@Then("SignIn")
	public void sign_in() {
	   
	}

	@Given("Login {string} password {string}")
	public void login_password(String string, String string2) {
	   
	}

	@Then("Submit")
	public void submit() {
	    
	}

	@Given("verify {string}")
	public void verify(String string) {
		    WebDriver driver = DriverFactory.getDriver();
			currentUrl =  ConfigReader.getBaseUrl()+"/"+ string;
		    AllActions.DriverWaitForUrl(driver, currentUrl);
			boolean testOutput = currentUrl.contentEquals(driver.getCurrentUrl()) ? true : false;
			Assert.assertEquals(testOutput, true);
			Assert.assertTrue(testOutput);
	}

	@Given("ClickLink {string}")
	public void click_link(String string) {
	  
	}

	@Then("currentUrl {string}")
	public void current_url(String string) {

	}

	/*@Then("ClickLink {string}")
	public void click_link(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
*/
	@Then("ClickSubLink {string}")
	public void click_sub_link(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

/*	@Then("Verify {string}")
	public void verify(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/

	@Then("Verify currentUrlparallel {string}")
	public void verify_current_urlparallel(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


@Then("Verify currentUrlparallel {string} and {string}")
public void verify_current_urlparallel_and(String string, String string2) {
	CommonSteps.verify_current_url_and(string, string2);
}
@Given("verifyparallel {string} in Common")
public void verifyparallel_in_common(String string) {
	CommonSteps.verify_in_common(string);

}

}

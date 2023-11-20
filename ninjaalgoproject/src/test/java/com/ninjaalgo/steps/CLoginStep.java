/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CLoginStep {
    WebDriver driver;
    String url;
    LoginPage loginPage;
    CommonSteps commonSteps;
    
    @Given("Click SignIn")
    public void Click_SignIn() {
		   //WebDriver driver = DriverFactory.getDriver();
			loginPage = PageFactory.initElements(DriverFactory.getDriver(), LoginPage.class);
    	    loginPage.ClickSignIn();
    	
    }
	@Given("Send Login {string} with password {string}")
	public void send_login_with_password(String name, String password) {
		     //WebDriver driver = DriverFactory.getDriver();
			loginPage = PageFactory.initElements(DriverFactory.getDriver(), LoginPage.class);
			loginPage.SetLoginCred(new String[] {name,password});		
	}
	@Then("click Login Password Submit")
	public void click_login_password_submit() throws Exception {
	}
	
	@Given("User Signing Off")
	public void user_signing_off() {
	}
	
	@Then("VerifySignout {string}")
	public void verify(String string) {
		WebDriver driver = DriverFactory.getDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	    String output = loginPage.ClickSignOut();	
	    	boolean testOutput = output.contentEquals(string) ? true : false;
			Assert.assertEquals(testOutput, true);
			Assert.assertTrue(testOutput);
	}
}
	
	




/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CLoginStep {
    WebDriver driver;
    String url;
    LoginPage loginPage;
    //HomePage homePage;
    
    @Given("Click SignIn")
    public void Click_SignIn() {
		for(WebDriver driver: DriverFactory.getMapDrivers().values()) {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
    	    loginPage.ClickSignIn();
    	}
    }
	@Given("Send Login {string} with password {string}")
	public void send_login_with_password(String name, String password) {
		for(WebDriver driver: DriverFactory.getMapDrivers().values()) {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.SetLoginCred(new String[] {name,password});
		}
	}
	@Then("click Login Password Submit")
	public void click_login_password_submit() throws Exception {

	}

}
	
	




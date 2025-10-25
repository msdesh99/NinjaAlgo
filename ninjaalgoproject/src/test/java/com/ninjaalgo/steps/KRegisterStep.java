package com.ninjaalgo.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.LoginPage;
import com.ninjaalgo.pages.RegisterPage;
import com.ninjaalgo.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KRegisterStep {
    WebDriver driver;
    RegisterPage registerPage;

	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		WebDriver driver = DriverFactory.getDriver();
		driver.get(ConfigReader.getBaseUrl().toString()+"/home");
	}

	@Given("Click register")
	public void click_register() {
		WebDriver driver = DriverFactory.getDriver();
	    registerPage = PageFactory.initElements(driver, RegisterPage.class);
 	    registerPage.ClickRegister();
	}
	@Given("Username {string} Password1 {string} Password2 {string}")
	public void username_password1_password2(String register, String pass1, String pass2) {
		WebDriver driver = DriverFactory.getDriver();
	    registerPage = PageFactory.initElements(driver, RegisterPage.class);
 	    registerPage.SetRegisterCred(new String[] {register,pass1,pass2});	   
	}

	@When("Click {string}")
	public void click(String string) {
	}



}

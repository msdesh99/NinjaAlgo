/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.utils.AllActions;

public class LoginPage extends AllActions {
	WebDriver driver;
	JavascriptExecutor js;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[text()='Sign in']")
	WebElement signIn;
	
	@FindBy(xpath = "//*[@name='username']")
	WebElement userElement;

	@FindBy(xpath = "//*[@name='password']")
	WebElement passwordElement;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement submitElement;

	public void ClickSignIn() {
		ClickElement(signIn, driver);
	}
	public void SetLoginCred(String[] loginCred) {
		DriverWaitForElement(driver, userElement);
		userElement.clear();
		userElement.sendKeys(loginCred[0]);
	
		DriverWaitForElement(driver, passwordElement);

		passwordElement.clear();
		passwordElement.sendKeys(loginCred[1]);
		
		ClickArrElement(this.driver, new WebElement[] { userElement, passwordElement });
		
		DriverWaitForElement(driver, submitElement);
		submitElement.submit();

	}
}

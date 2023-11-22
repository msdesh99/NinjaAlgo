/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.utils.AllActions;

public class LoginPage extends AllActions {
	WebDriver driver;
	JavascriptExecutor js;
    By locator;
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[text()='Sign in']")
	WebElement signIn;
	
	//@FindBy(xpath = "//*[@name='username']")
	
	//@FindBy(css="#id_username")
	@FindBy(xpath = "//*[@id='id_username']")
	WebElement userElement;

	@FindBy(xpath = "//*[@name='password']")
	WebElement passwordElement;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement submitElement;

	@FindBy(xpath="//*[text()='Sign out']")
	WebElement signOut;
	
	@FindBy(xpath="//*[@role='alert']")
	WebElement signOutAlert;
	
	public void ClickSignIn() {
		//locator= By.xpath("//*[text()='Sign in']");
		 driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		//ClickElement(CallDriverWait(driver, locator), driver);
		//ClickElement(signIn, driver);
	}
	public String ClickSignOut() {
		ClickElement(signOut, driver);
		//signOut.click();
		By locator = By.xpath("//*[@role='alert']");
		return CallDriverWait(driver,locator).getText();
	}
	public void SetLoginCred(String[] loginCred) {         
		//DriverWaitForElement(driver, userElement);
		// userElement.clear();
		 driver.findElement(
         		By.xpath("//*[@id='id_username']")).sendKeys(loginCred[0]);	
		 //userElement.sendKeys(loginCred[0]);
		 //userElement.click();

  	
		//DriverWaitForElement(driver, passwordElement);
		//passwordElement.clear();
		 driver.findElement(
	         		By.xpath("//*[@name='password']")).sendKeys(loginCred[1]);	
		//passwordElement.sendKeys(loginCred[1]);
		//passwordElement.click();

		
		ClickArrElement(this.driver, new WebElement[] { userElement, passwordElement });
		
		//DriverWaitForElement(driver, submitElement);

		//submitElement.submit();
		submitElement.click();

		By locator = By.xpath("//*[contains(text(),'Invalid Username and Password')]");
		DriverWaitForLocatorOrUrl(driver,locator, "home");
	}
	
}

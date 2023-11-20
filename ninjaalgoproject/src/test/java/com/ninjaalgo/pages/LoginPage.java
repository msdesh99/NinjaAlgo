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
		locator= By.xpath("//*[text()='Sign in']");
		ClickElement(CallDriverWait(driver, locator), driver);
		//ClickElement(signIn, driver);
	}
	public String ClickSignOut() {
		ClickElement(signOut, driver);
		//signOut.click();
		By locator = By.xpath("//*[@role='alert']");
		return CallDriverWait(driver,locator).getText();
	}
	public void SetLoginCred(String[] loginCred) {
 		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
         System.out.println("login: "+driver.getCurrentUrl());
         System.out.println("login: "+driver.getClass());
         System.out.println("login: "+loginCred[0]);

         
		//DriverWaitForElement(driver, userElement);
		userElement.clear();
		userElement.sendKeys(loginCred[0]);

        //SendKeysElement(driver, userElement, loginCred[0]);
        //DriverWaitForTextAndVisible(driver,userElement,loginCred[0]);
		//userElement.click();

		//WebElement elem = driver.findElement(By.xpath("//*[@name='username']"));
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elem);
		//((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('autofocus')", elem);
		//elem.sendKeys(loginCred[0]);
		//userElement.sendKeys(loginCred[0]);
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("document.getElementById('userElement').setAttribute('value', 'NinjaAlgo')");
		//DriverWaitForTextAndVisible(driver, userElement, loginCred[0]);

	
		//DriverWaitForElement(driver, passwordElement);

		passwordElement.clear();
		passwordElement.sendKeys(loginCred[1]);
		//passwordElement.click();

		
		ClickArrElement(this.driver, new WebElement[] { userElement, passwordElement });
		
		//DriverWaitForElement(driver, submitElement);

		//submitElement.submit();
		submitElement.click();

		By locator = By.xpath("//*[contains(text(),'Invalid Username and Password')]");
		DriverWaitForLocatorOrUrl(driver,locator, "home");
	}
	
}

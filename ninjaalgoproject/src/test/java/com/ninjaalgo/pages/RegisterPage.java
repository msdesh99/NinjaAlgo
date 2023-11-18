package com.ninjaalgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.utils.AllActions;

public class RegisterPage extends AllActions{
    WebDriver driver;

	public RegisterPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(xpath="//*[contains(text(),'Register')]")
    WebElement registerElement;
    
	@FindBy(xpath="//*[@name='username']")
	WebElement registerUserElement;
	
	@FindBy(xpath="//*[@name='password1']")
	WebElement password1Element;
	
	@FindBy(xpath="//*[@name='password2']")
	WebElement password2Element;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement registerSubmit;
	
	public void ClickRegister() {
		ClickElement(registerElement, driver);
	}
    
	public void SetRegisterCred(String[] registerCred) {
 		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
     /*    System.out.println("login: "+driver.getCurrentUrl());
         System.out.println("login: "+driver.getClass());
         System.out.println("login: "+registerCred[0]);
*/
         
		DriverWaitForElement(driver, registerUserElement);
		registerUserElement.clear();
		registerUserElement.sendKeys(registerCred[0]);

   
		//DriverWaitForElement(driver, password1Element);

		password1Element.clear();
		password1Element.sendKeys(registerCred[1]);
		password1Element.click();

		//DriverWaitForElement(driver, password2Element);

		password2Element.clear();
		password2Element.sendKeys(registerCred[2]);
		password2Element.click();
		
		ClickRegisterArrElement(this.driver, new WebElement[] { registerUserElement, password1Element, password2Element });
		
		//DriverWaitForElement(driver, submitElement);

		registerSubmit.submit();
		//submitElement.click();

		By locator = By.xpath("//*[@role='alert']");
		DriverWaitForLocatorOrUrl(driver,locator, "login");
	}
}

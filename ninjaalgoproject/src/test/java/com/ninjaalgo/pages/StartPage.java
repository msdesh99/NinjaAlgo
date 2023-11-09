/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.utils.AllActions;

public class StartPage extends AllActions {
	private WebDriver driver;
    private static By buttonXpath = By.xpath("//*[text()='Get Started']");
	
    public StartPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//*[text()='Get Started']")
	WebElement getStarted;

	public void ClickButton() {
		ClickElement(CallDriverWait(driver, buttonXpath), driver);
	}
}

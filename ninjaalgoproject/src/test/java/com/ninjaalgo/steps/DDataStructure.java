/*Code details:
	#Author: Meenakshi Dated: 7-Nov-2023
*/
package com.ninjaalgo.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DDataStructure {
	HomePage homePage;
	@Given("User Loged in and Home page is displayed")
	public void user_loged_in_and_home_page_is_displayed() throws Exception {		  
	}

	@Then("Click {string}")
	public void click(String string) throws Exception {
		  for(WebDriver driver: DriverFactory.getMapDrivers().values())	{
				homePage = PageFactory.initElements(driver, HomePage.class);
				homePage.GetIntoModule(string);
			 }	
	}

}

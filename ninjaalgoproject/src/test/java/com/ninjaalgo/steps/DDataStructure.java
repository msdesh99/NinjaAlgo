/*Code details:
	#Author: Meenakshi Dated: 7-Nov-2023
*/
package com.ninjaalgo.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.DataStructurePage;
import com.ninjaalgo.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DDataStructure {
	DataStructurePage dataStructurePage;
	
	@Then("ClickData {string}")
	public void click(String string) throws Exception {
		  for(WebDriver driver: DriverFactory.getMapDrivers().values())	{
				dataStructurePage = PageFactory.initElements(driver, DataStructurePage.class);
				dataStructurePage.GetIntoModule(string);
			 }	
	}

}

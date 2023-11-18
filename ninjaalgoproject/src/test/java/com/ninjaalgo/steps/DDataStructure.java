/*Code details:
	#Author: Meenakshi Dated: 7-Nov-2023
*/
package com.ninjaalgo.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.DataStructurePage;
import com.ninjaalgo.pages.HomePage;
import com.ninjaalgo.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DDataStructure {
	DataStructurePage dataStructurePage;
	HomePage homePage;
	CommonSteps commonSteps;
	
	@Then("ClickOnDataModule {string}")
	public void clickOnHomePage(String string) throws Exception {
		   WebDriver driver = DriverFactory.getDriver();
			homePage = PageFactory.initElements(driver, HomePage.class);
			homePage.GetIntoModule(string);
		    //parentWindowHandle = driver.getWindowHandle();
	}
	
	@Then("ClickInData {string}")
	public void click_on(String string) {
		        WebDriver driver = DriverFactory.getDriver();
				dataStructurePage = PageFactory.initElements(driver, DataStructurePage.class);
				dataStructurePage.GetTimeComplexity(string);
	}
	@Then("ClickOnDataTopic {string}")
	public void ClickOnDataTopic(String string) {
			    WebDriver driver = DriverFactory.getDriver();
				dataStructurePage = PageFactory.initElements(driver, DataStructurePage.class);
				dataStructurePage.GetTopic(string);				
			
	}
	@Then("Verify datacurrentUrl {string} and {string}")
	public void verify_current_url_and(String url, String type) {	
		commonSteps = new CommonSteps();
		 if(type.contentEquals("module"))commonSteps.VerifyURl(url);
		 else commonSteps.VerifyURl(url+type);
	}
	@Then ("GoTO DataHomePage")
	public void GoTO_DataHomePage() {
	    WebDriver driver = DriverFactory.getDriver();
		driver.get(ConfigReader.getModuleUrl().toString());
	}


}

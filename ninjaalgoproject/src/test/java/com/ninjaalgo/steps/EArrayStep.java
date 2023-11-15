/*Code details:
	#Author: Meenakshi Dated: 7-Nov-2023
*/
package com.ninjaalgo.steps;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.ArrayPage;
import com.ninjaalgo.pages.HomePage;
import com.ninjaalgo.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EArrayStep {
	HomePage homePage;
	ArrayPage arrayPage;
	CommonSteps commonSteps;
/*	@Then("ClickArray {string}")
	public void click(String string) throws Exception {
		System.out.println("in clickarray step: "+string);
		  for(WebDriver driver: DriverFactory.getMapDrivers().values())	{
				homePage = PageFactory.initElements(driver, HomePage.class);
				homePage.GetIntoModule(string);
			 }	
	} */
	@Then("ClickInArray {string}")
	public void click_in_array(String string) {
		System.out.println("in clickarray step: "+string);
		  //for(WebDriver driver: DriverFactory.getMapDrivers().values())	{
		  // for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
		        WebDriver driver = DriverFactory.getDriver();
		       /* commonSteps = new CommonSteps();
		        WebDriver driver =  commonSteps.GetDriver(entry); */
				arrayPage = PageFactory.initElements(driver, ArrayPage.class);
				arrayPage.GetArrayTopic(string);
			 //}	
	} 
	@Then("ClickOnArrayTopic {string}")
	public void ClickOnArrayTopic(String string) {
		  /* for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
		        commonSteps = new CommonSteps();
		        WebDriver driver =  commonSteps.GetDriver(entry);*/
                WebDriver driver = DriverFactory.getDriver();
				arrayPage = PageFactory.initElements(driver, ArrayPage.class);
				arrayPage.GetIntoTopic(string);
			// }	
	}
}

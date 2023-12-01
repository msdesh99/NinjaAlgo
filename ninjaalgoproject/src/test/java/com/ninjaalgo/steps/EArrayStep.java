/*Code details:
	#Author: Meenakshi Dated: 7-Nov-2023
*/
package com.ninjaalgo.steps;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.ArrayPage;
import com.ninjaalgo.pages.HomePage;
import com.ninjaalgo.utils.ConfigReader;
import com.ninjaalgo.utils.LoggerLoad;

import io.cucumber.java.en.Then;

public class EArrayStep {
	HomePage homePage;
	ArrayPage arrayPage;
	String parentUrl="";

	@Then("ClickOnArrayModule {string}")
	public void click(String string) throws Exception {
		      WebDriver driver = DriverFactory.getDriver();
		        homePage = PageFactory.initElements(driver, HomePage.class);
				homePage.GetIntoModule(string);
	} 
	@Then("ClickInArray {string}")
	public void click_in_array(String string) {
		        WebDriver driver = DriverFactory.getDriver();
				arrayPage = PageFactory.initElements(driver, ArrayPage.class);
				arrayPage.GetArrayTopic(string);
	} 
	@Then("ClickOnArrayTopic {string}")
	public void ClickOnArrayTopic(String string) {
	            WebDriver driver = DriverFactory.getDriver();
				arrayPage = PageFactory.initElements(driver, ArrayPage.class);
				arrayPage.GetIntoTopic(string);
	}
	@Then("Add Python code {string} {string}")
	public void add_python_code(String string, String string2) throws Exception {
	    WebDriver driver = DriverFactory.getDriver();
		arrayPage = PageFactory.initElements(driver, ArrayPage.class);
		arrayPage.TryPython();
	}
	@Then("Add Python-CSV code {string} {string}")
	public void add_python_csv_code(String string, String string2) throws Exception {
	    WebDriver driver = DriverFactory.getDriver();
		arrayPage = PageFactory.initElements(driver, ArrayPage.class);
		arrayPage.TryPythonCSV();
	}
	@Then("Add Python-JSON code {string} {string}")
	public void add_python_json_code(String string, String string2) throws IOException, ParseException {
	    WebDriver driver = DriverFactory.getDriver();
		arrayPage = PageFactory.initElements(driver, ArrayPage.class);
		arrayPage.TryPyhtonJson();

	}

	@Then("Verify arraycurrentUrl {string} and {string}")
	public void verify_arraycurrentUrl(String url, String type) {
	    WebDriver driver = DriverFactory.getDriver();
		arrayPage = PageFactory.initElements(driver, ArrayPage.class);
		 if(type.contentEquals("module"))CommonSteps.VerifyURl(url);
		 else CommonSteps.VerifyURl(url+type);
	}
	  
	@Then("GoTO ArrayPage and {string}")
	public void go_to_array_home_page_and(String string) {
		    WebDriver driver = DriverFactory.getDriver();
		    String url = ConfigReader.getBaseUrl().toString()+string;
			driver.get(url);		
	}
	@Then("GoTO ArrayHomePage")
	public void go_to_array_home_page() {
		    WebDriver driver = DriverFactory.getDriver();
			driver.get(ConfigReader.getModuleUrl().toString());
	}
	@Then("GoTo SubMenu Page {string} and {string} and logged status")
	public void go_to_sub_menu_page_and_and_logged_status(String menu, String subMenu) {
		    WebDriver driver = DriverFactory.getDriver();
		    String url = ConfigReader.getBaseUrl().toString()+menu+subMenu;
			driver.get(url);		
			verify_arraycurrentUrl(menu.substring(1), subMenu);
		    LoggerLoad.info("<=====Test For "+ subMenu + " is : Passed");	    
 	}

}

/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps {
    String currentUrl;
    static  WebDriver driver;
    public CommonSteps() {
		super();
	}
    @Given("open url with {string} browser")
	public void open_url_with_browser(String browserType) throws Exception{
		CreateDriver("",browserType);
   }	
    public void CreateDriver(String url, String browserType) throws Exception {
		DriverFactory driverFactory = new DriverFactory();
		driver = driverFactory.SingleDriver(browserType);
		url = ConfigReader.getBaseUrl();
		driver.get(url);
    }	
	@Then("Verify currentUrl {string} and {string}")
	public void verify_current_url_and(String url, String type) {		
		    if (type.contentEquals("module"))
                 url = url.replace(" ","-").toLowerCase()+"/";
		     VerifyURl(url);
	}
	            
	@Then("verify {string} in Common")
	public void verify_in_common(String url) {
	     VerifyURl(url);
	}

	public void VerifyURl(String url) {
		for(WebDriver driver: DriverFactory.getMapDrivers().values()) {			
			currentUrl =  ConfigReader.getBaseUrl()+"/"+ url;
			AllActions.DriverWaitForUrl(driver, currentUrl);
			boolean testOutput = currentUrl.contentEquals(driver.getCurrentUrl()) ? true : false;
			Assert.assertEquals(testOutput, true);
			Assert.assertTrue(testOutput);
		}		
	}
	@Given("On Home page for modules")
	public void On_Home_page_for_modules() throws Exception {	
		  for(WebDriver driver: DriverFactory.getMapDrivers().values())	{
		       driver.get(ConfigReader.getModuleUrl().toString());
		  }
	}

	
	
}


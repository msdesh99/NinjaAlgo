package com.ninjaalgo.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;

import io.cucumber.java.en.Then;

public class CommonSteps {
    String currentUrl;
    public CommonSteps() {
		super();
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

	
	
}


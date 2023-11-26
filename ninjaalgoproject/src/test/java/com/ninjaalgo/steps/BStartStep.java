/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.steps;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.HomePage;
import com.ninjaalgo.pages.StartPage;
import com.ninjaalgo.utils.ConfigReader;
import com.ninjaalgo.steps.CommonSteps;

import io.cucumber.java.en.Given;

public class BStartStep {
    WebDriver driver;
    String url;
    StartPage startPage;   
    HomePage homePage;
    CommonSteps commonSteps;
    
 // moved to commonsteps 
    @Given("open url with {string} browser")
 	public void open_url_with_browser(String browserType) throws Exception{
    	DriverFactory driverFactory = new DriverFactory();
    	commonSteps = new CommonSteps();
		driverFactory.SingleDriver(browserType);
		driver = DriverFactory.getDriver();
		driver.get(ConfigReader.getBaseUrl().toString());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
     }	
    @Given("Click Get Started button")
	public void click_get_started_button() {
		   //WebDriver driver = DriverFactory.getDriver();
			startPage = PageFactory.initElements(DriverFactory.getDriver(), StartPage.class);
			startPage.ClickButton();
		}
	

}
	
	




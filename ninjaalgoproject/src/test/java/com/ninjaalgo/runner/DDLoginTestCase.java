/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.LoginPage;
import com.ninjaalgo.steps.CommonSteps;
import com.ninjaalgo.testdata.GetXLData;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;
import com.ninjaalgo.utils.XLUtility;

public class DDLoginTestCase extends AllActions {

	WebDriver driver;
	XLUtility xlutil;
	LoginPage loginPage;
	CommonSteps commonSteps;
	ConfigReader configReader;
	Properties prop;
	GetXLData getXLData;
    String xmlPath="";
    
	@DataProvider(name = "ds")
	public Object[][] loginData() throws InvalidFormatException {
		/*
		 * return new Object[][] { new Object[]{"NinjaAlgo1", "@Algo123","Valid"},
		 * {"NinjaAlgo", "@Algo123","InValid"} };
		 */
		return getXLData.GetLoginData("LoginCred");
	}

	@Parameters({ "url", "xmlPath", "browserType" })
	@BeforeClass
	public void setup(String url, String xmlPath, String browserType) throws Exception {
		this.xmlPath=xmlPath;
		getXLData = new GetXLData(this.xmlPath);
		configReader = new ConfigReader();
		prop = configReader.initializeProperties();	
		DriverFactory driverFactory = new DriverFactory();
		driverFactory.SingleDriver(browserType);
		DriverFactory.getDriver().get(url);
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		loginPage = PageFactory.initElements(DriverFactory.getDriver(), LoginPage.class);
	}

	@AfterClass
	public void afterClass() {
		DriverFactory.CloseDriver();
	}

	@Test(dataProvider = "ds")
	public void LoginValidity(String name, String password, String status) {
		loginPage.SetLoginCred(new String[] { name, password });
		//commonSteps = new CommonSteps();
		CommonSteps.VerifyURl(status);
	}
}

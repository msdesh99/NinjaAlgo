/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.ArrayPage;
import com.ninjaalgo.pages.LoginPage;
import com.ninjaalgo.steps.CommonSteps;
import com.ninjaalgo.testdata.GetXLData;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;
import com.ninjaalgo.utils.XLUtility;

public class DDPythonArrayTestCase extends AllActions {

WebDriver driver;	
XLUtility xlutil;
LoginPage loginPage;
CommonSteps commonSteps;
ConfigReader configReader;
Properties prop;
ArrayPage arrayPage;
String xmlPath="";
GetXLData getXLData;

@DataProvider(name="ds")
public Object[][] loginData() throws Exception{
	return getXLData.GetPythonData("PythonArray");
}
  @Parameters({"url","xmlPath","browserType"})
  @BeforeClass
  public void setup(String url, String xmlPath, String browserType) throws Exception{	
	    this.xmlPath = xmlPath;
		getXLData = new GetXLData(this.xmlPath);
		
		configReader = new ConfigReader();
		prop = configReader.initializeProperties();	
	
        DriverFactory driverFactory = new DriverFactory();
		driverFactory.SingleDriver(browserType);
		driver = DriverFactory.getDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));		   
		    arrayPage = PageFactory.initElements(driver, ArrayPage.class);
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.SetLoginCred(new String[] {"NinjaAlgo","@Algo123"});
			
			driver.get("https://dsportalapp.herokuapp.com/tryEditor");
	       xmlPath = System.getProperty("user.dir")+xmlPath;
  }
 @AfterClass
  public void afterClass() {
	 DriverFactory.CloseDriver();
  }
@Test(dataProvider = "ds")
  public void LoginValidity(String code, String expected) throws InterruptedException {	
	//System.out.println("code: "+code +" exepect: "+expected);
			arrayPage.TryPythonNegative(code);	        
  }
}

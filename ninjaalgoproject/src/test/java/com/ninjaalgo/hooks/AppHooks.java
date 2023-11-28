/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/

package com.ninjaalgo.hooks;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.LoginPage;
import com.ninjaalgo.pages.StartPage;
import com.ninjaalgo.steps.CommonSteps;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;
import com.ninjaalgo.utils.LoggerLoad;
import com.ninjaalgo.utils.ScreenShot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks extends AllActions{
    public CommonSteps commonSteps;
    StartPage startPage;
    LoginPage loginPage;
    ScreenShot screenShot;
    ConfigReader configReader;
    Properties prop;
    WebDriver driver;

@Before(order=0)
	public void beforeAll(Scenario scenario) throws Exception {
	   configReader = new ConfigReader();
	   prop = configReader.initializeProperties();	
/*	   System.out.println("Current thread name: "+Thread.currentThread().getName());
	   System.out.println("Current thread ID: "+Thread.currentThread().threadId());
	   System.out.println("conf hook: "+ ConfigReader.getBrowserType());	
*/	     
    }
    
//@Before(value = "@data2Parallel or @data1Parallel or @dataParallelSce or @arrayParallelSce or @arrayClass or @dataClass", order=1)
@Before(value = "@dataParallelSce or @arrayParallelSce or @arrayClass or @dataClass", order=1)
	public void beforeParallel(Scenario scenario) throws Exception {
	   DriverFactory driverFactory = new DriverFactory();
	   //commonSteps = new CommonSteps();
	   if(scenario.getName().contentEquals("arrayparallelsce1"))
		     driverFactory.SingleDriver("edge");
	   else
	     driverFactory.SingleDriver("chrome");
	   
	   DriverFactory.getDriver().get(ConfigReader.getBaseUrl().toString());
	   DriverFactory.getDriver().manage().window().maximize();
	   DriverFactory.getDriver().manage().deleteAllCookies();
	   DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); 
	   startPage = PageFactory.initElements(DriverFactory.getDriver(), StartPage.class);
	   startPage.ClickButton();
	   loginPage = PageFactory.initElements(DriverFactory.getDriver(), LoginPage.class);
	   loginPage.ClickSignIn();
	   //loginPage = PageFactory.initElements(driver, LoginPage.class);
	   loginPage.SetLoginCred(new String[] {"NinjaAlgo","@Algo123"});	

    }

//@After(value = "@data2Parallel or @data1Parallel or @dataParallelSce or @arrayParallelSce", order=0)
@After(value = "@dataParallelSce or @arrayParallelSce", order=0)
public void afterParallel(Scenario scenario) throws Exception {
    DriverFactory.CloseDriver();
}

@After("@chrome or @firefox or @edge")  //for TestModules.xml
public void set_up_drivers() throws Exception {
	String url = ConfigReader.getBaseUrl();
	WebDriver driver = DriverFactory.getDriver();

	driver.get(url);
	driver.manage().window().maximize();
 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));  
}	

@Before
	public void before(Scenario scenario) throws Exception {
	   String newUrl="";
	   String moduleName = scenario.getSourceTagNames().iterator().next();
	   if(moduleName.contentEquals("@arraySuite")||
		  moduleName.contentEquals("@dataSuite")) {
			if(moduleName.contentEquals("@dataSuite"))
				moduleName = "@data-structures-introduction";
	            newUrl= GetNewUrl(moduleName);        
	            WebDriver driver = DriverFactory.getDriver();
		 		driver.get(ConfigReader.getBaseUrl().toString()+"/"+newUrl+"/");
	   }
     }
	
public String GetNewUrl(String moduleName) {
	      String newUrl="";
			String moduleArr[] = moduleName.substring(1).split("Suite");
			for(String moduleType: ConfigReader.getModules()) {
				   if(moduleType.contentEquals(moduleArr[0])) { 	
						newUrl = moduleType;
					    break;
					}
			}
	return newUrl;
}
public void SetDrivers() {
           WebDriver driver = DriverFactory.getDriver();
 		   driver.manage().window().maximize();
	 	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
}

/*
//@After (value = "@arraySuite and @arraysUsingListSuite", order =0)
@After ("(@arraySuite and @arraysUsingListSuite) or (@dataSuite and @TimeComplexitySuite)")

public void teardown() {	
    //WebDriver driver = DriverFactory.getDriver();
  //  driver.quit();
  //  Quit_Driver(driver);
} 	*/

@After(order = 0)
       public void after(Scenario scenario) throws HeadlessException, IOException, AWTException{
	      LoggerLoad.info("<=====Test For "+ scenario.getName() + " is : "+ scenario.getStatus());	    
			if(scenario.getName().contentEquals("Introduction")){
			      LoggerLoad.error("<=====Bug Reported on data structure question page. No questions found on the page. Test Case: "+ scenario.getName() + " is : "+ scenario.getStatus());	
				     WebDriver driver = DriverFactory.getDriver();
					 screenShot = new ScreenShot();
					 screenShot.CatchScreenShot(scenario.getName(), driver);
			}		     
		 	  
	/*		if(scenario.getName().contentEquals("Introduction") || 
					scenario.getName().contentEquals("Arrays-Using-List")) {
				
			     WebDriver driver = DriverFactory.getDriver();
			}*/
}

}

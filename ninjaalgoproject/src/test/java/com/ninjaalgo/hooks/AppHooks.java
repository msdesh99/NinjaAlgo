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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
    CommonSteps commonSteps;
    StartPage startPage;
    LoginPage loginPage;
    ScreenShot screenShot;


@After("@chrome or @firefox or @edge")  //for TestModules.xml
public void set_up_drivers() throws Exception {
	String url = ConfigReader.getBaseUrl();
	//System.out.println("create: "+url);
	WebDriver driver = DriverFactory.getDriver();

	driver.get(url);
	driver.manage().window().maximize();
 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));  
}	

@Before
	public void before(Scenario scenario) throws Exception {
	   String newUrl="";
	   //System.out.println("tot sc: "+scenario.getSourceTagNames());
	   String moduleName = scenario.getSourceTagNames().iterator().next();
	   //System.out.println("modulename before: "+moduleName);
	   if(moduleName.contentEquals("@arraySuite")||
		  moduleName.contentEquals("@dataSuite")) {
		   //moduleName = scenario.getSourceTagNames().iterator().next();
			if(moduleName.contentEquals("@dataSuite"))
				moduleName = "@data-structures-introduction";
	            newUrl= GetNewUrl(moduleName);        
	            WebDriver driver = DriverFactory.getDriver();
		 		driver.get(ConfigReader.getBaseUrl().toString()+"/"+newUrl+"/");
	   }
     }
	
public String GetNewUrl(String moduleName) {
	      String newUrl="";
			//System.out.println("module name getnewurl: "+moduleName.substring(1));
			String moduleArr[] = moduleName.substring(1).split("Suite");
            //System.out.println("module: "+ moduleArr[0]);
			for(String moduleType: ConfigReader.getModules()) {
				  // System.out.println(moduleType.split("Suite"));
				   if(moduleType.contentEquals(moduleArr[0])) { 	
						newUrl = moduleType;
						//System.out.println("module: "+moduleArr[0]+"newurl: "+newUrl);
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

//@After (value = "@arraySuite and @arraysUsingListSuite", order =0)
@After ("(@arraySuite and @arraysUsingListSuite) or (@dataSuite and @TimeComplexitySuite)")

public void teardown() {	

    WebDriver driver = DriverFactory.getDriver();
    driver.quit();
  //  Quit_Driver(driver);
} 	
@After(order = 0)
       public void after(Scenario scenario) throws HeadlessException, IOException, AWTException{
	//@array, @arraysUsingList @data, @TimeComplexity @array, @arraysinPython]
		//System.out.println("after scenario : "+ scenario.getSourceTagNames());

	      LoggerLoad.info("<=====Test For "+ scenario.getName() + " is : "+ scenario.getStatus());	    
			if(scenario.getName().contentEquals("Introduction")){
			      LoggerLoad.error("<=====Bug Reported on data structure question page. No questions found on the page. Test Case: "+ scenario.getName() + " is : "+ scenario.getStatus());	
				     WebDriver driver = DriverFactory.getDriver();
					 screenShot = new ScreenShot();
					 screenShot.CatchScreenShot(scenario.getName(), driver);
			}		     
		 	  
			if(scenario.getName().contentEquals("Introduction") || 
					scenario.getName().contentEquals("Arrays-Using-List")) {
				
			     WebDriver driver = DriverFactory.getDriver();
				//Quit_Driver(driver);
				//if(driver.getCurrentUrl().contentEquals(ConfigReader.getBaseUrl().toString()+"/"+newUrl+"/"))
				//Quit_Driver(driver);
			}
			/*if(scenario.getName().contentEquals("RegisterCred")){
			     WebDriver driver = DriverFactory.getDriver();
				 driver.get(ConfigReader.getModuleUrl().toString());
			}*/
}

		public void SwitchToChildWindow() {
	
		}
}

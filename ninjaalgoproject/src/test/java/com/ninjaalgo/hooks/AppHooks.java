/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/

package com.ninjaalgo.hooks;

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

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks extends AllActions{
    CommonSteps commonSteps;
    StartPage startPage;
    LoginPage loginPage;
    String parentWindowHandle, windowHandle;

    
@Before("@data or (@array and @arraysinPython)")
//@Before("@data or @array")
//@Before("@array and @arraysinPython")
	public void set_drivers() throws Exception {
	System.out.println("in set driver apphook");
	     commonSteps = new CommonSteps();
	    // commonSteps.CreateDriver("","chrome");
		 // commonSteps.CreateDriver("","firefox");
		commonSteps.CreateDriver("","edge");
	     
		 //SetDrivers();	
	     //for(WebDriver driver: DriverFactory.getMapDrivers().values()) {
		 // for(int i=0;i<DriverFactory.getMapDrivers().size();i++) {
		  /* for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
		        commonSteps = new CommonSteps();
		        WebDriver driver =  commonSteps.GetDriver(entry); */
	            WebDriver driver = DriverFactory.getDriver();
		        System.out.println("got driv: "+driver.getClass()+ driver.getWindowHandle());
				startPage = PageFactory.initElements(driver, StartPage.class);
				startPage.ClickButton();
				loginPage = PageFactory.initElements(driver, LoginPage.class);
	    	    loginPage.ClickSignIn();
				loginPage.SetLoginCred(new String[] {"NinjaAlgo","@Algo123"});
	     //}		
	 	}		   
@Before
	public void before(Scenario scenario) throws Exception {
	   String newUrl="";
	   System.out.println("tot sc: "+scenario.getSourceTagNames());
	   String moduleName = scenario.getSourceTagNames().iterator().next();
	   System.out.println("modulename before: "+moduleName);
	   if(moduleName.contentEquals("@arraySuite")||
		  moduleName.contentEquals("@dataSuite")) {
		   //moduleName = scenario.getSourceTagNames().iterator().next();
			if(moduleName.contentEquals("@dataSuite"))
				moduleName = "@data-structures-introduction";
	        newUrl= GetNewUrl(moduleName);
	        
		  /* for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
		        commonSteps = new CommonSteps();
		        WebDriver driver =  commonSteps.GetDriver(entry);*/
	            WebDriver driver = DriverFactory.getDriver();
		 		driver.get(ConfigReader.getBaseUrl().toString()+"/"+newUrl+"/");
		   //}     
	   }
     }
	
public String GetNewUrl(String moduleName) {
	      String newUrl="";
			System.out.println("module name getnewurl: "+moduleName.substring(1));
			String moduleArr[] = moduleName.substring(1).split("Suite");
            System.out.println("module: "+ moduleArr[0]);
			for(String moduleType: ConfigReader.getModules()) {
				  // System.out.println(moduleType.split("Suite"));
				   if(moduleType.contentEquals(moduleArr[0])) { 	
						newUrl = moduleType;
						System.out.println("module: "+moduleArr[0]+"newurl: "+newUrl);

					    break;
					}
			}
	return newUrl;
}
public void SetDrivers() {
	  /* for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
	        commonSteps = new CommonSteps();
	        WebDriver driver =  commonSteps.GetDriver(entry);*/
           WebDriver driver = DriverFactory.getDriver();
 		   driver.manage().window().maximize();
	 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	   //}	
}

//@After (value = "@arraySuite and @arraysUsingListSuite", order =0)
@After ("(@arraySuite and @arraysUsingListSuite) or (@dataSuite and @TimeComplexitySuite)")

public void teardown() {	

    WebDriver driver = DriverFactory.getDriver();
    driver.quit();
	 /* for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
	        commonSteps = new CommonSteps();
	        WebDriver driver =  commonSteps.GetDriver(entry);
	        //Quit_Driver(driver);
	       // DriverFactory.setMapDrivers(entry.getKey());
	       // DriverFactory.setMapDrivers(entry.getKey(),driver);
	        Quit_Driver(driver);
	   }*/
} 	
@After(order = 0)
       public void after(Scenario scenario){
	//@array, @arraysUsingList @data, @TimeComplexity @array, @arraysinPython]
		System.out.println("after scenario : "+ scenario.getSourceTagNames());
	      LoggerLoad.info("<=====Test For "+ scenario.getName() + " is : "+ scenario.getStatus());	
      
	      boolean foundModule =false;
	      String newUrl="";
	      String moduleName = scenario.getSourceTagNames().iterator().next();
	  //   if (!(moduleName.contentEquals("@open"))) { // || moduleName != "@chrome") {
			System.out.println("module name before if: "+moduleName.substring(1));
			if(moduleName.contentEquals("@data"))
				moduleName = "@data-structures-introduction";

			for(String moduleType: ConfigReader.getModules()) {
				  //moduleType.replaceAll("\\s","");
					if(moduleName.substring(1).contentEquals(moduleType) ) { //contentEquals(moduleType)) {				
						newUrl =moduleName.substring(1);
						foundModule =true;
					    break;
					}
			}
	     // }
			//if (!(moduleName.contentEquals("@open"))) { // || moduleName != "@chrome") {		
			if (moduleName.contentEquals("@data")|| 
				moduleName.contentEquals("@array")) { // || moduleName != "@chrome") {

				  /* for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
				        commonSteps = new CommonSteps();
				        WebDriver driver =  commonSteps.GetDriver(entry);*/
			WebDriver driver = DriverFactory.getDriver();
	 		driver.get(ConfigReader.getBaseUrl().toString()+"/"+newUrl+"/");
	 		//driver.get(ConfigReader.getBaseUrl()+"/login/");
				   //}
			}
		 	  
			if(scenario.getName().contentEquals("Introduction") || 
					scenario.getName().contentEquals("Arrays-Using-List")) {
			     WebDriver driver = DriverFactory.getDriver();

			/*	   for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
				        commonSteps = new CommonSteps();
				        WebDriver driver =  commonSteps.GetDriver(entry);*/

				System.out.println("in sce: "+driver.getCurrentUrl()+"dirv: "+driver.getClass()
				+"wind: "+driver.getWindowHandle());
				//if(driver.getCurrentUrl().contentEquals(ConfigReader.getBaseUrl().toString()+"/"+newUrl+"/"))
				Quit_Driver(driver);
				//break;
				  // }
			}
	      
}

		public void SwitchToChildWindow() {
	
		}
}

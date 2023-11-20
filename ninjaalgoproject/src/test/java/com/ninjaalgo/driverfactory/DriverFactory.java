/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {
     public WebDriver driver;
    
    public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>(); 
   
 	public void SingleDriver(String selectedBrowser) throws Exception {
 		/*    if(!selectedBrowser. equalsIgnoreCase(ConfigReader.getBrowserType())){
		    	prop.setProperty("browserType", selectedBrowser);
			    prop = configReader.initializeProperties();		
			    // System.out.println("in driver: "+ConfigReader.getBrowserType());
		    }
           */
			if(selectedBrowser.toLowerCase().contentEquals("chrome")) {
			//if(selectedBrowser.equalsIgnoreCase(ConfigReader.getBrowserType().toString())) {
				tDriver.set(new ChromeDriver());
		
			}
			else if(selectedBrowser.toLowerCase().contentEquals("firefox")) {
				tDriver.set(new FirefoxDriver());
			}
			else if(selectedBrowser.toLowerCase().contentEquals("edge")) {
				tDriver.set(new EdgeDriver());
			}
			else throw new Exception("Browser not supported"); 
			//return getDriver();
	}	
	  public static WebDriver getDriver() {
			return tDriver.get();	   
      }	
//newly added while parallel https://community.jaspersoft.com/	  
 public static void CloseDriver() {
	 tDriver.get().quit();
	 tDriver.remove();
 }
}

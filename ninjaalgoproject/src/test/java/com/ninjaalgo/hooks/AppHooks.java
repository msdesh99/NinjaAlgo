/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/

package com.ninjaalgo.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.LoggerLoad;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks extends AllActions{

@Before("@login")
	public void set_drivers() {
		for(WebDriver driver: DriverFactory.getMapDrivers().values()) {
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		} 
	}
	
@After("@DataStructure")
	public void teardown() {
		for(WebDriver driver: DriverFactory.getMapDrivers().values()) 
			Quit_Driver(driver);
	} 	
@After
       public void after(Scenario scenario){
	      LoggerLoad.info("<=====Test For "+ scenario.getName() + " is : "+ scenario.getStatus());	
}
}

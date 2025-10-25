/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

//@RunWith(Cucumber.class)
@Epic("Bugs Found on signIn page")
@Severity(SeverityLevel.MINOR)
@CucumberOptions(
	  //  tags =("@openChrome or @signIn or dropdown"), //for register
	    tags =("@openChrome or @registerBug"), //for register     

	//	features = {"classpath:com/ninjaalgo/features"},
		features = {"src/test/java/com/ninjaalgo/features"},
		glue= {"com/ninjaalgo/steps","com/ninjaalgo/hooks"},
		plugin= {"pretty","summary",
				"timeline: target/cucumber/datachrome",
				"html:target/html/datachrome-output.html",
				"json:target/cucumber/Bugreport.json",
				"junit:target/cucumber/Bugreport.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 	},
		monochrome = true
		) 
public class BugChromeBrowser extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){		
		return super.scenarios();
	}
}



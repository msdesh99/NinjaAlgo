/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
	    tags =("@openChrome or @login or @dataSuite"), //for Data-structure
	//	features = {"classpath:com/ninjaalgo/features"},
	    features = {"src/test/java/com/ninjaalgo/features"},	
	    glue= {"com/ninjaalgo/steps","com/ninjaalgo/hooks"},
		plugin= {"pretty","summary",
				"timeline: target/cucumber/datachrome",
				"json:target/cucumber/DataChrome.json",
				"junit:target/cucumber/DataChrome.xml",
				"html:target/html/datachrome-output.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 	
				},
		monochrome = true
		) 
public class DataChromeBrowser extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){		
		return super.scenarios();
	}
}



/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
	    tags =("@dataClass"), //for Data-structure
	//	features = {"classpath:com/ninjaalgo/features"},
	    features = {"src/test/java/com/ninjaalgo/features"},
	    glue= {"com/ninjaalgo/steps","com/ninjaalgo/hooks"},
		plugin= {"pretty","summary",
				"timeline: target/cucumber/datachrome",
				"html:target/html/datachrome-output.html",
				"json:target/cucumber/DataParallel.json",
				"junit:target/cucumber/DataParallel.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				//"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true
		) 
public class DataparallelClass extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){		
		return super.scenarios();
	}
}



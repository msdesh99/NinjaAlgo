/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
		tags =("@graphmodule"), //for Data-structure
	//  features = {"classpath:src/test/java/com/ninjaalgo/features"},
		features = {"src/test/java/com/ninjaalgo/features"},
		glue= {"com/ninjaalgo/steps","com/ninjaalgo/hooks"},
		plugin= {"pretty","summary",
				"timeline: target/cucumber",
				"html:target/html/test-output.html",
				"json:target/cucumber/Stackreport.json",
				"junit:target/cucumber/Stackreport.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 	
				},
		monochrome = true
		) 
public class TestNGGraph extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){		
		return super.scenarios();
	}
}

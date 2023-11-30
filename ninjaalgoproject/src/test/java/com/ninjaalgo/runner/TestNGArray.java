/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.ninjaalgo.listener.TestExecutionListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		tags =("@array"), //for Data-structure
	//  features = {"classpath:src/test/java/com/ninjaalgo/features"},
		features = {"src/test/java/com/ninjaalgo/features"},
		glue= {"com/ninjaalgo/steps","com/ninjaalgo/hooks"},
		plugin= {"pretty","summary",
				"timeline: target/cucumber",
				"html:target/html/test-output.html",
				"json:target/cucumber/Arrayreport.json",
				"junit:target/cucumber/Arrayreport.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 	
				},
		monochrome = true
		) 
@Listeners(TestExecutionListener.class)
public class TestNGArray extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){		
		return super.scenarios();
	}
}


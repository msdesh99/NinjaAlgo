/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//DataArrayParallelSce.xml
//@RunWith(Cucumber.class)
@CucumberOptions(
	    tags =("@dataarrayParallel"), //for Data-structure		
	//  features = {"classpath:com/ninjaalgo/features"},
	    features = {"src/test/java/com/ninjaalgo/features"}, 
		glue= {"com/ninjaalgo/steps","com/ninjaalgo/hooks"},
		plugin= {"pretty","timeline: target/cucumber/dataarrayparallelsce",
				"html:target/html/dataarrparasce-output.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		monochrome = true
		) 
public class DataArrayparallelSce extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){		
		return super.scenarios();
	}
}



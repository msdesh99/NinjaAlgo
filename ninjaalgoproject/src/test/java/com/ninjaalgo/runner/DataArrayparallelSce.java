/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import org.testng.annotations.DataProvider;

import com.google.common.collect.ImmutableMap;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.Epic;
//DataArrayParallelSce.xml
//@RunWith(Cucumber.class)
@Epic("Scenario Parallel Testing")
@CucumberOptions(
	    tags =("@dataarrayParallel"), //for Data-structure		
	//  features = {"classpath:com/ninjaalgo/features"},
	    features = {"src/test/java/com/ninjaalgo/features"}, 
		glue= {"com/ninjaalgo/steps","com/ninjaalgo/hooks"},
		plugin= {"pretty",
				"timeline: target/cucumber/dataarrayparallelsce",
				"html:target/html/dataarrparasce-output.html",
				"json:target/cucumber/scenariosInParallel.json",
				"junit:target/cucumber/scenariosInParallel.xml",
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



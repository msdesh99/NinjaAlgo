/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
	    //tags =("not @firefox and not @edge"), //for Chrome
	     //tags =("not @firefox and not @chrome"), //for Edge
	     tags =("@open or @loginPage or @module"),  //all browser	
	    //tags =("not @chrome and not @edge"), //for firefox
	     
		features = {"classpath:com/ninjaalgo/features"},
		glue= {"com/ninjaalgo/steps","com/ninjaalgo/hooks"},
		plugin= {"pretty","html:target/html/test-output.html"}, //"timeline: target/cucumber"
		monochrome = true
		) 
public class TestNG extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){		
		return super.scenarios();
	}
}



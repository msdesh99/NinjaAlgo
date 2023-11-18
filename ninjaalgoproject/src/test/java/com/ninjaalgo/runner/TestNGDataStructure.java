/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
	    // tags =("@open or @loginPage"), //for Data-structure
		  tags =("@openChrome or @login or @data"), //for Data-structure
		  //tags =("@array"), //for Data-structure

		 //tags =("@data or @array"), //for Data-structure
	     //tags =("@open or @data or @array"), //for Data-structure

	     //tags =("not @firefox and not @chrome"), //for Edge
	     //tags =("@open or @loginPage or @module"),  //all browser	
	    //tags =("not @chrome and not @edge"), //for firefox
	     
		features = {"classpath:com/ninjaalgo/features"},
		glue= {"com/ninjaalgo/steps","com/ninjaalgo/hooks"},
		plugin= {"pretty","timeline: target/cucumber","html:target/html/test-output.html"},
		monochrome = true
		) 
public class TestNGDataStructure extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){		
		return super.scenarios();
	}
}



/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.steps;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.ArrayPage;
import com.ninjaalgo.pages.PracticeQuestionPage;

import io.cucumber.java.en.Then;

public class PracticeQuestionSteps{
    static String currentUrl;
    static  WebDriver driver;

    PracticeQuestionPage practiceQuestionPage;
    ArrayPage arrayPage;
    
    public PracticeQuestionSteps() {
		super();
	}
    
	@Then("ClickPractice {string}")
	public void click_practice(String string) {
	     WebDriver driver = DriverFactory.getDriver();
	     practiceQuestionPage = PageFactory.initElements(driver, PracticeQuestionPage.class);
	     practiceQuestionPage.ClickPractice();		
	}
	
	@Then("ClickPracticeTopic {string}")
	public void click_practice_topic(String string) {
	     WebDriver driver = DriverFactory.getDriver();
	     practiceQuestionPage = PageFactory.initElements(driver, PracticeQuestionPage.class);
	     practiceQuestionPage.GetPracticeTopic(string);		
	}
	@Then("PracticeTest {string} result {string}")
	public void practice_test_result(String code, String expected) {
		   WebDriver driver = DriverFactory.getDriver();
	        practiceQuestionPage = PageFactory.initElements(driver, PracticeQuestionPage.class);
	        practiceQuestionPage.TryPractice(code,expected);
	}
	@Then("PracticeWithDataTable")
	public void practice_with_data_table(io.cucumber.datatable.DataTable dataTable) {
		   String code="", expected="";
		   WebDriver driver = DriverFactory.getDriver();
	        practiceQuestionPage = PageFactory.initElements(driver, PracticeQuestionPage.class);
	        List<List<String>> codeList = dataTable.cells();
     	       Iterator<List<String>> itr = codeList.iterator();  
	           synchronized (itr) {
	        	   while(itr.hasNext()) {
	        		      List<String> codeExpected = itr.next();
	        		      System.out.println("codeline: "+codeExpected.get(0));
	        		      code =code+codeExpected.get(0)+"\n";
	        		      expected = codeExpected.get(1);
	        		      System.out.println("codeline1: "+expected);
	        	   }				
			   }	         
	        practiceQuestionPage.TryPractice(code,"alert");
	}

}


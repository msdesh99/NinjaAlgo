/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.steps;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.ArrayPage;
import com.ninjaalgo.pages.HomePage;
import com.ninjaalgo.pages.LoginPage;
import com.ninjaalgo.pages.PracticeQuestionPage;
import com.ninjaalgo.pages.StartPage;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;
import com.ninjaalgo.utils.LoggerLoad;

import io.cucumber.java.en.Given;
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
/*	@Then("negativePracticeTest {string}")
	public void negative_practice_test(String code) {
		   WebDriver driver = DriverFactory.getDriver();
	        practiceQuestionPage = PageFactory.initElements(driver, PracticeQuestionPage.class);
	        practiceQuestionPage.TryPracticeNegative(code);}

	@Then("PositivePracticeTest {string} result {string}")
	public void positive_practice_test_result(String code, String expected) {
		   WebDriver driver = DriverFactory.getDriver();
	        practiceQuestionPage = PageFactory.initElements(driver, PracticeQuestionPage.class);
	        practiceQuestionPage.TryPracticePositive(code, expected);}

	}*/


}


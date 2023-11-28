package com.ninjaalgo.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.steps.CommonSteps;
import com.ninjaalgo.testdata.GetXLData;
import com.ninjaalgo.utils.AllActions;

public class PracticeQuestionPage extends AllActions {
   WebDriver driver;
   By locator;
   Actions actions;
   Alert alert;
   GetXLData getXLData;
   String xmlPath;
   CommonSteps commonSteps;
   String expected;
   
   public PracticeQuestionPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
   @FindBy(xpath="//*[@class='list-group']")
   List<WebElement> questionList;
 
   @FindBy(xpath="//*[text()='Practice Questions']")
   WebElement practice;
   

   //@FindBy(xpath="//*[@id='answer_form']//*[contains(@class,'CodeMirror')]//textarea")
   @FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
   WebElement pythonElement;
  
   @FindBy(xpath="//*[@type='button']")
   WebElement runElement;
   
   @FindBy(xpath="//*[@class='container']//*[@id='output']")
   WebElement pythonResult;
   
	public void ClickPractice() {
		practice.click();
	}
	
   public void GetPracticeTopic(String questionTopic) {
	      // ScreenScrollDown(driver);
  	    if(questionTopic.contentEquals("Squares of  a Sorted Array"))
	    	questionTopic = "Squares of a Sorted Array";
	       for(WebElement element: questionList) {
	    	   if(element.getText().contentEquals(questionTopic)) {
	    		    locator = By.xpath("//*[@class='list-group-item' and text()='"+questionTopic+"']");
					ClickElement(CallDriverWait(driver, locator), driver);
					break;
	    	   }
	       }
   }
	public void TryPractice(String code, String expected) {
		TextIndentationForPractice(driver,pythonElement);
	    pythonElement.sendKeys(code);
		runElement.click();
		String actual = DriverWaitForElementOrAlert(driver,pythonResult);
		if(actual==null) 
			actual = pythonResult.getText();
		if(expected.contentEquals("alert"))
		      expected=actual;
			  commonSteps = new CommonSteps();
			  commonSteps.VerifyPython(actual,expected,"Practice");
	}
}

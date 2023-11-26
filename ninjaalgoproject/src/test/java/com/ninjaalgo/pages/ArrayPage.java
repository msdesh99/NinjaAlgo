package com.ninjaalgo.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.steps.CommonSteps;
import com.ninjaalgo.testdata.GetXLData;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;

public class ArrayPage extends AllActions {
   WebDriver driver;
   By locator;
   Actions actions;
   Alert alert;
   GetXLData getXLData;
   String xmlPath;
   CommonSteps commonSteps;
   String expected;
   
   public ArrayPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
   @FindBy(xpath = "//*[@class='list-group-item']")
   List<WebElement> ArraytopicList;

  // @FindBy(xpath = "//*[contains(text(),'Try here')]")
   //WebElement tryHere;
   

   //@FindBy(xpath="//*[@id='answer_form']//*[contains(@class,'CodeMirror')]//textarea")
   @FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
   //@FindBy(xpath="//*[@id='answer_form']/div/div/div[1]")
   WebElement pythonElement;
  
   @FindBy(xpath="//*[@type='button']")
   WebElement runElement;
   
   @FindBy(xpath="//*[@class='container']//*[@id='output']")
   WebElement pythonResult;
   
   public void GetArrayTopic(String topic) {
	       ScreenScrollDown(driver);
	       for(WebElement element: ArraytopicList) {
	    	   if(element.getText().contentEquals(topic)) {
	    		    locator = By.xpath("//*[@class='list-group-item' and text()='"+topic+"']");
					ClickElement(CallDriverWait(driver, locator), driver);
					break;
	    	   }
	       }
   }

	public void GetIntoTopic(String string) {
		locator= By.xpath("//*[contains(text(),'Try here')]");
		ClickElement(CallDriverWait(driver, locator), driver);
	}

	public void TryPython() throws Exception {
		//xmlPath= System.getProperty("user.dir")+"/src/test/resources/TestData/pythonCodeData.xlsx";
		xmlPath= "/src/test/resources/TestData/TestData.xlsx";

		getXLData = new GetXLData(xmlPath);
		String[][] pythonArr = getXLData.GetPythonData("PythonArray");
		expected = pythonArr[0][1].toString();
		
	    //pythonElement.clear();
	    //pythonElement.click();
		String code="";

		for(int i=0;i<pythonArr.length;i++) {
			if(pythonArr[i][0]!=null) {
				code = code+pythonArr[i][0];
				//GetCurrentWindowHandle(driver,locator).sendKeys(pythonArr[i][0].toString());
			}    
		}
		locator =By.xpath("//form[@id='answer_form']/div/div/div/textarea");
		//DriverWaitForClickable(driver,locator);
		//pythonElement.sendKeys(code);

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(
        		By.xpath("//form[@id='answer_form']/div/div/div/textarea"))
        		.sendKeys(code);
		TextIndentation(driver,pythonElement,3,6,true);	
		TextIndentation(driver,pythonElement,1,4,false);	
  
		runElement.click();
		String actual = DriverWaitForElementOrAlert(driver,pythonResult);
		if(actual==null) 
			actual = pythonResult.getText();
			   commonSteps = new CommonSteps();
			   commonSteps.VerifyPython(actual,expected,"Try Here");
	}
	public void TryPythonNegative(String string) throws InterruptedException {
	    //pythonElement.clear();

		if((string!=null)) {
		    pythonElement.sendKeys(string);
		}
		TextIndentation(driver,pythonElement,3,6,true);	
		TextIndentation(driver,pythonElement,1,3,false);	
  		runElement.click();
		String actual = DriverWaitForElementOrAlert(driver,pythonResult);
		if(actual==null) 
			actual = pythonResult.getText();
		   expected = actual;
		   commonSteps = new CommonSteps();
	       commonSteps.VerifyPython(actual,expected,"Try Here>>>");		
	}
/*	public void TryPractice(String code) {
		TextIndentationForPractice(driver,pythonElement);
	    pythonElement.sendKeys(code);
		runElement.click();
		String actual = DriverWaitForElementOrAlert(driver,pythonResult);
		if(actual==null) 
			actual = pythonResult.getText();
			  commonSteps = new CommonSteps();
			  commonSteps.VerifyPython(actual,expected,"Practice");
	}*/

	/*public void TryPracticeNegative(String code, String practice) {
		TextIndentationForPractice(driver,pythonElement);
	    pythonElement.sendKeys(code);
		runElement.click();
		String actual = DriverWaitForElementOrAlert(driver,pythonResult);
		if(actual==null) 
			actual = pythonResult.getText();
			   commonSteps = new CommonSteps();
			   commonSteps.VerifyPython(actual,expected,"Practice");
		}*/

}

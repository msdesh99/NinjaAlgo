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

public class LinkedListPage extends AllActions {
   WebDriver driver;
   By locator;
   Actions actions;
   Alert alert;
   GetXLData getXLData;
   String xmlPath;
   CommonSteps commonSteps;
   String expected;
   String parentWindowHandle;
   
   public LinkedListPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
   @FindBy(xpath = "//*[@class='list-group-item']")
   List<WebElement> LinkedListtopicList;

  // @FindBy(xpath = "//*[contains(text(),'Try here')]")
   //WebElement tryHere;
   

   @FindBy(xpath="//*[@id='answer_form']//*[contains(@class,'CodeMirror')]//textarea")
   //@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
   WebElement pythonElement;
  
   @FindBy(xpath="//*[@type='button']")
   WebElement runElement;
   
   @FindBy(xpath="//*[@class='container']//*[@id='output']")
   WebElement pythonResult;
   
   public void GetLinkedListTopic(String topic) {
	       //ScreenScrollDown(driver);
	       for(WebElement element: LinkedListtopicList) {
	    	   if(element.getText().contentEquals(topic)) {
	    		    locator = By.xpath("//*[@class='list-group-item' and text()='"+topic+"']");
					ClickElement(CallDriverWait(driver, locator), driver);
					break;
	    	   }
	       }	       
   }
}

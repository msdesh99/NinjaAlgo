package com.ninjaalgo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ninjaalgo.utils.AllActions;

public class ArrayPage extends AllActions {
   WebDriver driver;
   By locator;
   public ArrayPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

   @FindBy(xpath = "//*[@class='list-group-item']")
   List<WebElement> ArraytopicList;

  // @FindBy(xpath = "//*[contains(text(),'Try here')]")
   //WebElement tryHere;
   
   public void GetArrayTopic(String topic) {
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



   
}

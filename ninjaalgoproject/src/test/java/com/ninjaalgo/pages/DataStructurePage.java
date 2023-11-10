/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;
import com.ninjaalgo.utils.PagesActivity;

public class DataStructurePage extends AllActions{
	private WebDriver driver;
	static By locator;
    //*[text()=\"Data Structures-Introduction\"]"
	//*[@class='card-body d-flex flex-column']/h5[text()="Data Structures-Introduction"]
	//following::a[@href="data structures-introduction"]
	
	public DataStructurePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//*[@class='card-body d-flex flex-column']/h5") 
	List<WebElement> moduleList;
		
	public void GetIntoModule(String moduleName) throws Exception {
		 for(WebElement element: moduleList) {      
				 if(element.getText().contentEquals(moduleName)) {
					ClickElement(element, driver);
					locator = By.xpath("//*[text()='" +moduleName+"']//following::a[@href = '"+moduleName.replace(" ","-").toLowerCase()+"']");
					ClickElement(CallDriverWait(driver, locator), driver);
					break;
				 }	
		 }		 
	/*	boolean foundModule =false;
		for(String moduleType: ConfigReader.getModules()) {
				if(moduleName.contentEquals(moduleType)) {
					foundModule =true;
				    break;}
		}
		if(foundModule) {		
           for(WebElement element: moduleList) {      
 						 if(element.getText().contentEquals(moduleName)) {
 							ClickElement(element, driver);
 							locator = By.xpath("//*[text()='" +moduleName+"']//following::a[@href = '"+moduleName.replace(" ","-").toLowerCase()+"']");
 							ClickElement(CallDriverWait(driver, locator), driver);
 							foundModule =true;
 							break;
 						 }	
 	 		}
 		}else  System.out.println("module not found"); 	 */

}
}

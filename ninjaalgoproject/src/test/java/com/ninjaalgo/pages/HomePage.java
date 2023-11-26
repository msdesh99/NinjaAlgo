/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ninjaalgo.steps.CommonSteps;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;

public class HomePage extends AllActions{
	private WebDriver driver;
	static By locator;
    //*[text()=\"Data Structures-Introduction\"]"
	//*[@class='card-body d-flex flex-column']/h5[text()="Data Structures-Introduction"]
	//following::a[@href="data structures-introduction"]
	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//*[@class='card-body d-flex flex-column']/h5") 
	List<WebElement> moduleList;
	
	@FindBy(xpath ="//*[@class='nav-item dropdown']/a")
	WebElement dropDown;
	
	
	public void GetIntoModule(String moduleName) throws Exception {
	     //System.out.println("//*[text()='" +moduleName+"']//following::a[@href = '"+moduleName.replace(" ","-").toLowerCase()+"']");
             for(WebElement element: moduleList) {      
 						 if(element.getText().contentEquals(moduleName)) {
 							ClickElement(element, driver);
 							locator = By.xpath("//*[text()='" +moduleName+"']//following::a[@href = '"+moduleName.replace(" ","-").toLowerCase()+"']");
 							ClickElement(CallDriverWait(driver, locator), driver);
 							break;
 						}	
             }		
	}
	public void SelectDropDown() throws Exception {

//	public void SelectDropDown(String dropDownName) throws Exception {
		String[] dropdownMenu = ConfigReader.getDropDown().toString().split(",");
		String rootUrl = driver.getCurrentUrl();

		for(String dropdown: dropdownMenu) {
			String optionName="";	  
			driver.findElement(By.xpath("//*[@class='nav-item dropdown']/a")).click();
			locator = By.xpath("//*[@class='dropdown-menu show']/a");
			List<WebElement> dropDownList = driver.findElements(locator);
		
			for(WebElement option: dropDownList) {
			   optionName = option.getText();
				if(optionName.contentEquals("Arrays"))
					optionName="Array";		   
			  if(option.getText().contentEquals(dropdown)) {
					ClickElement(option, driver);
					CommonSteps.verify_current_url_and(optionName, "module");
					break;					
			  }				 
		    }
			//ClickHeader();
		}
		 driver.get(rootUrl);
	}
	public void ClickHeader() {
		String rootUrl = driver.getCurrentUrl();
		System.out.println("root curr: "+ rootUrl);
        //driver.findElement(By.xpath("//a[text()='NumpyNinja']")).click();
        driver.findElement(By.xpath("//*[@class='navbar-brand']")).click();
        //DriverWaitForUrl(driver, String url)
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://dsportalapp.herokuapp.com/home";
        if(!actualUrl.contentEquals(expectedUrl)) {
        	CommonSteps.verify_bug_in_common(actualUrl, expectedUrl, "headerBug");
        	CommonSteps.verify_current_url_and(actualUrl, "headerBug");
        }
        else {
        	CommonSteps.verify_current_url_and(actualUrl, "start")	;
        }
        
		 driver.get(rootUrl);

		
	}
	

}

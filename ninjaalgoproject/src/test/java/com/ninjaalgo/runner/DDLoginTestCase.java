/*Code details:
	#Author: Meenakshi Dated: 6-Nov-2023
*/
package com.ninjaalgo.runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.LoginPage;
import com.ninjaalgo.steps.CommonSteps;
import com.ninjaalgo.testdata.CreateTestData;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.XLUtility;

public class DDLoginTestCase extends AllActions {

WebDriver driver;	
XLUtility xlutil;
CreateTestData ctd;
LoginPage loginPage;
CommonSteps commonSteps;

@DataProvider(name="ds")
public Object[][] loginData(){
	/*
	 * return new Object[][] { new Object[]{"NinjaAlgo1", "@Algo123","Valid"},
	 * {"NinjaAlgo", "@Algo123","InValid"} };
	 */
	return GetXmlData();
}
  @Parameters({"url","xmlPath","browserType"})
  @BeforeClass
  public void setup(String url, String xmlPath, String browserType) throws Exception{	
	  commonSteps = new CommonSteps();
	  commonSteps.CreateDriver(url,browserType); 

	  for(WebDriver driver: DriverFactory.getMapDrivers().values()) 
			driver.get(url); 

	       xmlPath = System.getProperty("user.dir")+xmlPath;
		try {
			xlutil = new XLUtility(xmlPath);
	    	xlutil.WriteIntoFile();    	
			//ctd = new CreateTestData(xmlPath);
			//SetXmlData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(WebDriver driver: DriverFactory.getMapDrivers().values()) 
		loginPage = PageFactory.initElements(driver, LoginPage.class);
  }
 @AfterClass
  public void afterClass() {
	for(WebDriver driver: DriverFactory.getMapDrivers().values()) 
      driver.quit();
  }
@Test(dataProvider = "ds")
  public void LoginValidity(String name, String password, String status) {
	loginPage.SetLoginCred(new String[] {name,password});
	commonSteps = new CommonSteps();
	commonSteps.VerifyURl(status);
  }
public void SetXmlData() throws IOException {
	  ctd.WriteIntoFile();
}
public Object[][] GetXmlData() {
		try {
			//String path1 = System.getProperty("user.dir")+"/src/test/resources/TestData/loginData.xlsx";
			int totalRows = xlutil.GetLastRow("sheet1");
			int totalCells = xlutil.GetLastCell("sheet1", 1);
	
			String loginData[][] = new String[totalRows][totalCells] ;
			for(int i=0;i<totalRows;i++) {
				for(int j=0; j<totalCells;j++){
					loginData[i][j]= xlutil.GetCellData("sheet1", i+1, j);	
				}
			}
		       return loginData;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}	  
}
}

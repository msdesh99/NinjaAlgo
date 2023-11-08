package com.ninjaalgo.runner;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ninjaalgo.pages.LoginPage;
import com.ninjaalgo.steps.CommonSteps;
import com.ninjaalgo.testdata.CreateTestData;
import com.ninjaalgo.utils.XLUtility;

public class DDLoginTestCase {
	
XLUtility xlutil;
WebDriver driver;
CreateTestData ctd;
LoginPage loginPage;
boolean testOutput=false;

@DataProvider(name="loginDD")
public Object[][] loginData(){
	return GetXmlData();
}
public void SetXmlData() throws IOException {
	  ctd.WriteIntoFile();
}
  public Object[][] GetXmlData() {
		try {
			//String path1 = System.getProperty("user.dir")+"/src/test/resources/TestData/loginData.xlsx";
			int totalRows = xlutil.GetLastRow("sheet1");
			int totalCells = xlutil.GetLastCell("sheet1", 1);
	
			String currencyData[][] = new String[totalRows][totalCells] ;
			for(int i=0;i<totalRows;i++) {
				for(int j=0; j<totalCells;j++){
					currencyData[i][j]= xlutil.GetCellData("sheet1", i+1, j);	
					//System.out.println(currencyData[i][j]);
				}
			}
		       return currencyData;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}	  
}
  
  @Parameters({"url","xmlPath"})
  @BeforeClass
  public void setup(String url, String xmlPath) {
		driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get(url);
		try {
			xlutil = new XLUtility(xmlPath);
			ctd = new CreateTestData(xmlPath);
			SetXmlData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		loginPage = PageFactory.initElements(driver, LoginPage.class);

  }
 @AfterClass
  public void afterClass() {
      driver.quit();
  }
@Test(dataProvider = "loginDD")
  public void LoginValidity(String name, String password,String status) {
	System.out.println("validty: "+name+" "+password+" "+status);
	//loginPage = PageFactory.initElements(driver, LoginPage.class);

	loginPage.SetLoginCred(new String[] {name,password});

	System.out.println("in login validty");
	//new CommonSteps().VerifyURl("home");

  }
}

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
import com.ninjaalgo.pages.HomePage;
import com.ninjaalgo.pages.LoginPage;
import com.ninjaalgo.pages.StartPage;
import com.ninjaalgo.utils.AllActions;
import com.ninjaalgo.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps {
    String currentUrl;
    static  WebDriver driver;
    public static String parentWindowHandle;
    
    StartPage startPage;   
    HomePage homePage;
    LoginPage loginPage;
    //WebDriver driver;
    
    public CommonSteps() {
		super();
	}
    @Given("open url with {string} browser")
	public void open_url_with_browser(String browserType) throws Exception{
		CreateDriver("",browserType);
		

   }	
    public void CreateDriver(String url, String browserType) throws Exception {
		DriverFactory driverFactory = new DriverFactory();
		driver = driverFactory.SingleDriver(browserType);
		url = ConfigReader.getBaseUrl();
		System.out.println("create: "+url);
		driver.get(url);
		driver.manage().window().maximize();
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }	
	@Then("Verify currentUrl {string} and {string}")
	public void verify_current_url_and(String url, String type) {	
        url = url.replace(" ","-").toLowerCase()+"/";
		    if (type.contentEquals("module"))VerifyURl(url);
		    else if(type.contentEquals("start")) VerifyURl("home");
		    else VerifyURl(url+type);
	}
	            
	@Then("verify {string} in Common")
	public void verify_in_common(String url) {
	     VerifyURl(url);
	}

	public void VerifyURl(String url) {
		   WebDriver driver = DriverFactory.getDriver();
			currentUrl =  ConfigReader.getBaseUrl()+"/"+ url;
		    AllActions.DriverWaitForUrl(driver, currentUrl);
			boolean testOutput = currentUrl.contentEquals(driver.getCurrentUrl()) ? true : false;
			Assert.assertEquals(testOutput, true);
			Assert.assertTrue(testOutput);
/*
		   for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
		        WebDriver driver = GetDriver(entry);
				currentUrl =  ConfigReader.getBaseUrl()+"/"+ url;
			    AllActions.DriverWaitForUrl(driver, currentUrl);
				boolean testOutput = currentUrl.contentEquals(driver.getCurrentUrl()) ? true : false;
				Assert.assertEquals(testOutput, true);
				Assert.assertTrue(testOutput);
		   }	*/	
	}
/*	@Given("On Home page for modules")
	public void On_Home_page_for_modules() throws Exception {	
		  for(WebDriver driver: DriverFactory.getMapDrivers().values())	{
		       driver.get(ConfigReader.getModuleUrl().toString());
		  }
	} */
	@Given("Click Get Started button")
	public void click_get_started_button() {
		   WebDriver driver = DriverFactory.getDriver();
			startPage = PageFactory.initElements(driver, StartPage.class);
			startPage.ClickButton();
	/*	for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
		        WebDriver driver = GetDriver(entry);
			startPage = PageFactory.initElements(driver, StartPage.class);
			startPage.ClickButton();
		}*/
	}
	  @Given("Click SignIn")
	    public void Click_SignIn() {
		   WebDriver driver = DriverFactory.getDriver();
		   System.out.println("driver: "+driver.getCurrentUrl());
			loginPage = PageFactory.initElements(driver, LoginPage.class);
   	        loginPage.ClickSignIn();
		/*   for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
		        WebDriver driver = GetDriver(entry);
		        //driver = GetDriver();
		        System.out.println("driver: "+driver.getCurrentUrl());
				loginPage = PageFactory.initElements(driver, LoginPage.class);
	    	    loginPage.ClickSignIn();
		   } */
	    }
	  /*  public WebDriver GetDriver(Map.Entry<String, WebDriver> entry ) {
	    	//for( Map.Entry<String, WebDriver> entry : DriverFactory.getMapDrivers().entrySet()){
		 		  WebDriver driver = entry.getValue();
		 		  String windowHandle = entry.getKey();
				   if(driver.getWindowHandle().contentEquals(windowHandle)) {
						  System.out.println("in getDri: "+entry.getValue().getClass());
					  //break;
				   }
					return driver;
	    	//}
			//return driver;
	   }*/
		@Given("Send Login {string} with password {string}")
		public void send_login_with_password(String name, String password) {
			   WebDriver driver = DriverFactory.getDriver();
			   loginPage = PageFactory.initElements(driver, LoginPage.class);
			   loginPage.SetLoginCred(new String[] {name,password});

			 /*  for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
			        WebDriver driver = GetDriver(entry);
				loginPage = PageFactory.initElements(driver, LoginPage.class);
				loginPage.SetLoginCred(new String[] {name,password});
			}*/
		}
		@Then("click Login Password Submit")
		public void click_login_password_submit() throws Exception {
		}
		@Then("ClickOnHomePage {string}")
		public void clickOnHomePage(String string) throws Exception {
			   WebDriver driver = DriverFactory.getDriver();
				homePage = PageFactory.initElements(driver, HomePage.class);
				homePage.GetIntoModule(string);
			  /* for( Map.Entry<String, WebDriver> entry :DriverFactory.getMapDrivers().entrySet()){
			        WebDriver driver = GetDriver(entry);
					homePage = PageFactory.initElements(driver, HomePage.class);
					homePage.GetIntoModule(string);
					parentWindowHandle = driver.getWindowHandle();
		        } */	
		}
	/*	@Then("Switch to parent window")
		public void switch_to_parent_window() {
			
		}*/

		public static String getParentWindowHandler() {
			return parentWindowHandle;
			
		}
		
}


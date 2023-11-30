package com.ninjaalgo.steps;

import org.openqa.selenium.WebDriver;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.GraphPage;

import io.cucumber.java.en.*;

public class GraphSteps
{
	 WebDriver driver;
     GraphPage gp =new GraphPage(driver);

	
	@When("user click on getstarted graph module")
	public void user_click_on_getstarted_graph_module() {
        WebDriver driver = DriverFactory.getDriver();
		 driver.get("https://dsportalapp.herokuapp.com/home");
	     GraphPage gp =new GraphPage(driver);
	     gp.getstarted();
	}

	@Then("graph page is opened")
	public void graph_page_is_opened() {
        WebDriver driver = DriverFactory.getDriver();
		System.out.println(driver.getCurrentUrl());
	    // driver.get("https://dsportalapp.herokuapp.com/home");
	    // GraphPage gp =new GraphPage(driver);
		//gp.graph();
	   
	}

	@Then("click on graph Topics Covered")
	public void click_on_graph_topics_covered() {
        WebDriver driver = DriverFactory.getDriver();
		 //driver.get("https://dsportalapp.herokuapp.com/home");
		 GraphPage gp =new GraphPage(driver);
	   gp.graph();
	}
	@When("user clickon Tryhere button")
	public void user_clickon_tryhere_button() 
	{
        WebDriver driver = DriverFactory.getDriver();
		// driver.get("https://dsportalapp.herokuapp.com/home");
		 GraphPage gp =new GraphPage(driver);
	    gp.tryherebtn();
	}

	@Then("tryeditor page is displayed")
	public void tryeditor_page_is_displayed() 
	{
        WebDriver driver = DriverFactory.getDriver();
		System.out.println(driver.getCurrentUrl());
	}
	
	@When("user enters the code {string} in the graph page")
	public void user_enters_the_code_in_the_graph_page(String string) 
	{
        WebDriver driver = DriverFactory.getDriver();
		GraphPage gp =new GraphPage(driver);
	    gp.tryEditor(string);
	}
	
	@When("user clicks on Run  on try editor page")
	public void user_clicks_on_run_on_try_editor_page() 
	{
        WebDriver driver = DriverFactory.getDriver();
		GraphPage gp =new GraphPage(driver);
	   gp.runEditor();
	}

	@Then("user see the code output")
	public void user_see_the_code_output() 
	{
        WebDriver driver = DriverFactory.getDriver();
		GraphPage gp =new GraphPage(driver);

	 gp.output();
	}

	@Then("click on graphRepresentations Topics Covered")
	public void click_on_graph_representations_topics_covered() 
	{
        WebDriver driver = DriverFactory.getDriver();
		GraphPage gp =new GraphPage(driver);

	   gp.graphRepresntations(); 
	}
	@Then("click on practice questions link")
	public void click_on_practice_questions_link() 
	{
        WebDriver driver = DriverFactory.getDriver();
		GraphPage gp =new GraphPage(driver);

	    gp.practicequestionslnk();
	}

	@Then("practice page will be displayed")
	public void practice_page_will_be_displayed() 
	{
        WebDriver driver = DriverFactory.getDriver();
		System.out.println(driver.getCurrentUrl());
	}

	


}

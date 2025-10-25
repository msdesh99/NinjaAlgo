package com.ninjaalgo.steps;

import org.openqa.selenium.WebDriver;

import com.ninjaalgo.driverfactory.DriverFactory;
import com.ninjaalgo.pages.Treepage;

import io.cucumber.java.en.*;

public class Treesteps {
	WebDriver driver;
   // WebDriver driver = DriverFactory.getDriver();
	Treepage tp=new Treepage(driver);

	@When("user click on getstarted tree module")
	public void user_click_on_getstarted_tree_module() 
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.get("https://dsportalapp.herokuapp.com/home");
	    Treepage tp =new Treepage(driver);
	     tp.getstarted();
	}
	@Then("tree page is opened")
	public void tree_page_is_opened() 
	{
	    WebDriver driver = DriverFactory.getDriver();
	    //System.out.println(driver.getTitle());
	    Treepage tp =new Treepage(driver);

	    tp.gettitle(); 
	}
	
	@Then("click on overviewofTrees")
	public void click_on_overviewof_trees() 
	{
	    WebDriver driver = DriverFactory.getDriver();
	  System.out.println( driver.getTitle());
	    Treepage tp =new Treepage(driver);

	  tp.OverviewofTree();
	    
	}
	@Then("click on Terminologies")
	public void click_on_terminologies() 
	{	    
		WebDriver driver = DriverFactory.getDriver();
       Treepage tp =new Treepage(driver);
	   tp.Terminologies();
	}
	@Then("click on Types of Trees")
	public void click_on_Types_of_Trees()
	{
	    WebDriver driver = DriverFactory.getDriver();
		System.out.println(driver.getCurrentUrl());
	       Treepage tp =new Treepage(driver);
		
		tp.TypesOfTrees();
	}
	@Then("click on Tree Traversals")
	public void click_on_tree_traversals() 
	{
	    WebDriver driver = DriverFactory.getDriver();
		System.out.println(driver.getCurrentUrl());
	       Treepage tp =new Treepage(driver);
		
		tp.Treetraversals();
	}
	  @Then ("click on traversal illustrations")
	  public void click_on_traversal_illustrations()
	  {
		    WebDriver driver = DriverFactory.getDriver();
			System.out.println(driver.getCurrentUrl());
		       Treepage tp =new Treepage(driver);
			
			tp.Traversalillustration();
	  }
	  @Then("click on binarytrees")
	  public void click_on_binarytrees() 
	  {
		    WebDriver driver = DriverFactory.getDriver();
			System.out.println(driver.getCurrentUrl());
		       Treepage tp =new Treepage(driver);
			
			tp.binarytrees();
	  }
	  @Then("click on types of binary trees")
	  public void click_on_types_of_binary_trees() 
	  {
		    WebDriver driver = DriverFactory.getDriver();
			System.out.println(driver.getCurrentUrl());
		       Treepage tp =new Treepage(driver);
			
			tp.typesofbinaryTrees();
	  }
	  @Then("click on implementationinpython")
	  public void click_on_implementationinpython() 
	  {
		    WebDriver driver = DriverFactory.getDriver();
			System.out.println(driver.getCurrentUrl());
		       Treepage tp =new Treepage(driver);
			
			tp.implementationinpython();
	  }
	  @Then("click on Binary Search Trees")
	  public void click_on_binary_search_trees() 
	  {
		    WebDriver driver = DriverFactory.getDriver();
			System.out.println(driver.getCurrentUrl());
		       Treepage tp =new Treepage(driver);
			
			tp.binarySearchTrees();;
	  }
	  @Then("click on implementationofBST")
	  public void click_on_implementationof_bst() 
	  {
		    WebDriver driver = DriverFactory.getDriver();
		  System.out.println(driver.getTitle());
		  tp.implementationofBST();
	  }
	  @Then("click on practicequestions")
	  public void click_on_practicequestions() 
	  {
		    WebDriver driver = DriverFactory.getDriver();
		  System.out.println(driver.getTitle());
		  tp.practiceQuestions();
	  }
	  

}

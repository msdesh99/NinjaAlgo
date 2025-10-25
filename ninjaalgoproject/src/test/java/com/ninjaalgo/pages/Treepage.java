package com.ninjaalgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ninjaalgo.driverfactory.DriverFactory;


public class Treepage 
{
public WebDriver driver;

	public Treepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void getstarted() 
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[@href='tree']")).click();
	}
	public void OverviewofTree() 
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[@href=\"overview-of-trees\"]")).click();
	}
	public void tryherebtn()
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[contains(text(),'Try here')]")).click();
	}
	public void Terminologies()
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[text()='Terminologies']")).click();
	}
	public void TypesOfTrees()
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[text()='Types of Trees']")).click();
	}
	public void gettitle()
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.getTitle();
	}
	public void Treetraversals()
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[text()='Tree Traversals']")).click();
	}
	public void Traversalillustration()
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[text()='Traversals-Illustration']")).click();
	}
	public void binarytrees()
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[text()='Binary Trees']")).click();
	}
	public void typesofbinaryTrees()
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[text()='Types of Binary Trees']")).click();
	}
	public void implementationinpython()
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[text()='Implementation in Python']")).click();
	}
	public void binarySearchTrees()
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[text()='Binary Search Trees']")).click();
	}
	public void implementationofBST()
	{

	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[text()='Implementation Of BST']")).click();
	}
	public void practiceQuestions()
	{
	    WebDriver driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//a[text()='Practice Questions']")).click();
	}
}

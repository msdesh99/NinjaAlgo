package com.ninjaalgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class GraphPage {
public WebDriver driver;

public GraphPage(WebDriver driver) 
{
    this.driver = driver;
}
//By graphlnk=By.xpath("//a[@href='/graph/graph/']");//topics covered graph

//By tryherebtn=By.xpath("//a[contains(text(),'Try here')]");
By input =  By.xpath("//div[@class='input']");
public void getstarted() 
{
	driver.findElement(By.xpath("//a[@href='graph']")).click();
}

public void graph()
{
	driver.findElement(By.xpath("//a[@href=\"graph\"]")).click();
	
}

public void tryherebtn()
{
	//WebDriver driver = Helper.getDriver();
	driver.findElement(By.xpath("//a[contains(text(),'Try here')]")).click();
}
public void tryEditor(String string)
{
	driver.findElement(input).click();
	 Actions actions = new Actions(driver);
     actions.keyDown(Keys.COMMAND);
     actions.sendKeys(string).perform();
	
}
public void runEditor()
{
	driver.findElement(By.xpath("//button[@type='button']")).click();
}
public void output() 
{
	  System.out.println(driver.findElement(By.id("output")).getText());
}
public void graphRepresntations()
{
	driver.findElement(By.xpath("//a[text()='Graph Representations']")).click();
}
public void practicequestionslnk()
{
	driver.findElement(By.xpath("//a[text()='Practice Questions']")).click();
}
}

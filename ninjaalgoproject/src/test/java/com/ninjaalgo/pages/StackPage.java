package com.ninjaalgo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class StackPage {

    public WebDriver driver;

    String URL = "https://dsportalapp.herokuapp.com/";
    By practicequestnbtn = By.xpath("//a[contains(text(),'Practice Questions')]");
    By tryherebtn = By.xpath("//a[contains(text(),'Try here>>>')]");
    By input =  By.xpath("//div[@class='input']");
    By runbtn = By.xpath("//button[@type='button']");
    By stackImplementation = By.xpath( "//a[contains(text(),'Implementation')]");
    By stackApplication = By.xpath( "//a[contains(text(),'Application')]");
    By dropdown = By.xpath( "//div[@class='nav-item dropdown']");
    By stackbutton = By.xpath( "//a[contains(text(),'Stack')]");
    By stackOperation = By.xpath( "//a[contains(text(),'Operations in Stack')]");
    By signoutbutton = By.xpath( "//a[contains(text(),'Sign out')]");
    By output =  By.id( "output");
    By loggedOutAlert = By.xpath( "//div[@class='alert alert-primary']");
    
    public StackPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToDropDown() {
        driver.findElement(dropdown).click();
    }

    public void clickStackButton() {
        driver.findElement(stackbutton).click();

    }
    public void user_should_redirected_to_stack_page() {

    }


    public void clickImplementationLink() {

        driver.findElement(stackImplementation).click();
    }

    public void clickTryHere() {
        driver.findElement(tryherebtn).click();

    }


    public void user_click_the_try_here_button() {

        driver.findElement(tryherebtn).click();
    }

    public void enterInTheTestPage(String string) {
        driver.findElement(input).click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys(string).perform();

    }

    public void clickRunButton() {

        driver.findElement(runbtn).click();
    }

    public void clickOkButton() throws
            InterruptedException {

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(1000);
        alert.accept();//click ok button
    }

    public void clickPraticeButton(){

        driver.findElement(practicequestnbtn).click();
    }

    public void getOutputText() {

        driver.findElement(output).getText();
    }
//tc005

    public void clickStackApplication() {

        driver.findElement(stackApplication).click();
    }

    //tc006
    public void clickOperationButton() {

        driver.findElement(stackOperation).click();
    }


    public void clickSignOut() {
        driver.findElement(signoutbutton).click();
    }

    public void getLoggedOut() {
        driver.findElement(loggedOutAlert).getText();
    }
}

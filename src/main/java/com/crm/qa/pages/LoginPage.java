package com.crm.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    
    // Page Factory - OR;
    
    @FindBy(id = "userid")
    WebElement email;
    
    @FindBy(id = "signin-continue-btn")
    WebElement continueBtn;
    
    @FindBy(id = "pass")
    WebElement password;
    
    @FindBy(id = "sgnBt")
    WebElement signInBtn;
    
    @FindBy(id = "greeting-msg")
    WebElement helloMsg;
    
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String verifyPageTitle() {
    	return driver.getTitle();
    }
    
    public HomePage login(String un, String pwd) throws IOException, InterruptedException {
        
        email.sendKeys(un);
        continueBtn.click();
        password.sendKeys(pwd);
        signInBtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   
        
        return new HomePage();
    }
    
    public boolean verifyGreetingMsg() {
    	helloMsg.isDisplayed();
    	return true;
    }
}
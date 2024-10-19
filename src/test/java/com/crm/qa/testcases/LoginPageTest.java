package com.crm.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest {
    LoginPage lp;
    HomePage hp;
    TestBase testBase;

    @BeforeMethod
        public void setUp() throws IOException, InterruptedException {
            testBase = new TestBase();
            testBase.initialization();
            lp = new LoginPage(testBase.getDriver()); // Pass the WebDriver instance to the LoginPage constructor
            Thread.sleep(25000);
      }
    
    @Test(priority = 1)
    public void verifyPageTitle() throws InterruptedException {
    	Thread.sleep(10000);
    	String loginPageTitle = lp.verifyPageTitle();
    	Assert.assertEquals(loginPageTitle, "Sign in or Register | eBay");
    	testBase.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    public void loginTest() throws IOException, InterruptedException {
        hp = lp.login(testBase.prop.getProperty("email"), testBase.prop.getProperty("password"));
        testBase.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
    }
    
    @Test(priority = 3)
    public void verifyGreetingMsgTest() throws InterruptedException {
    	Thread.sleep(5000);
    	Assert.assertTrue(lp.verifyGreetingMsg(), "Greeting Message is missing");
    }

    @AfterMethod
    public void tearDown() {
        testBase.getDriver().quit();
    }
}
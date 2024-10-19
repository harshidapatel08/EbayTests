package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HelpAndContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HelpAndContactsPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	TestBase testBase;
	HelpAndContactsPage helpAndContactsPage;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		testBase = new TestBase();
		testBase.initialization();
		lp = new LoginPage(testBase.getDriver());
		Thread.sleep(25000);
		hp = lp.login(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(3000);
		helpAndContactsPage = hp.clickOnHelpAndContactsLink();
		Thread.sleep(8000);
	}
	
	@Test(priority = 1)
	public void verifyebayLogoTest() throws IOException, InterruptedException{
		Assert.assertTrue(helpAndContactsPage.verifyEbayLogo(), "EbayLogo is missing");
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void verifyCustomerServiceTitleTest() {
		Assert.assertTrue(helpAndContactsPage.verifyCustomerServiceTitle(), "Customer Service Title is Missing");
	}
	
	@Test(priority = 3)
	public void verifysrTitleTest() {
		Assert.assertTrue(helpAndContactsPage.verifysrTitle(), "sr Title is missing");
	} 
	
	@Test(priority = 4)
	public void searchBoxAndSearchBtnTest() throws InterruptedException {
		Thread.sleep(20000);
		helpAndContactsPage.writeInSearchBox();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

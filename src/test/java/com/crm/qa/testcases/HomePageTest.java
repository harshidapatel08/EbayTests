package com.crm.qa.testcases;

	import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

	public class HomePageTest extends TestBase{
		LoginPage lp;
		HomePage hp;
		TestBase testBase;
		
		public HomePageTest() {
			super();
		}
		
		@BeforeMethod
		public void setUp() throws IOException, InterruptedException {
			testBase = new TestBase();
			testBase.initialization();
			lp = new LoginPage(testBase.getDriver());
			Thread.sleep(25000);
			hp = lp.login(prop.getProperty("email"), prop.getProperty("password"));
			Thread.sleep(8000);
		}
		
		@Test(priority = 1)
			public void verifyHomePageTitleTest() {
			String homePageTitle = hp.verifyHomePageTitle();
			Assert.assertEquals(homePageTitle, "Electronics, Cars, Fashion, Collectibles & More | eBay","Home page Title not matched");
		}
		
		@Test(priority = 2)
		public void verifyUsernameTest() {
			hp.hoverOnUserId();
			Assert.assertEquals(hp.readUserId(), "harspa-7589");
		}
		
		@Test(priority = 3)
		public void writeInSearchBoxTest() {
			hp.writeinSearchBox();
		}
		
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

	}



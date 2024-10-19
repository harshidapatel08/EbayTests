/* author name: Harshida Patel */


package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HelpAndContactsPage extends TestBase {
	@FindBy(id = "gh-logo")
	WebElement ebayLogo;
	
	@FindBy(id = "gh-title")
	WebElement customerServiceTitle;
	
	@FindBy(id = "srTil")
	WebElement srTitle;
	
	@FindBy(name = "query")
	WebElement searchBox;
	
	@FindBy(id = "sr-action")
	WebElement searchBtn;
	
	//Initializing the page Objects
	public HelpAndContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean  verifyEbayLogo() {
		ebayLogo.isDisplayed();
		return true;
	}
	
	public boolean verifyCustomerServiceTitle() {
		customerServiceTitle.isDisplayed();
		return true;
	}
	
	public boolean verifysrTitle() {
		srTitle.isDisplayed();
		return true;
	}
	
	public void writeInSearchBox() throws InterruptedException {
		searchBox.sendKeys("return");
		searchBtn.click();
	}

}
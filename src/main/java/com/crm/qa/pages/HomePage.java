package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(id = "gh-eb-u")
	WebElement userId;
	
	@FindBy(linkText = "eBay Deals")
	WebElement deals;
	
	@FindBy(linkText = "Help & Contact")
	WebElement helpAndContacts;
	
	@FindBy(linkText = "Current language English")
	WebElement languageLink;
	
	@FindBy(linkText = "Sell")
	WebElement sellLink;
	
	@FindBy(linkText = "My eBay")
	WebElement MyeBayLink;
	
	@FindBy(xpath = "//button[@title='Notifications']")
	WebElement notificationBtn;
	
	@FindBy(xpath = "//a[@aria-label='Your shopping cart']")
	WebElement addToCartBtn;
	
	@FindBy(id = "gh-logo")
	WebElement logo;
	
	@FindBy(id = "gh-shop-a")
	WebElement shopByCategories;
	
	@FindBy(id = "gh-ac")
	WebElement searchBox;
	
	@FindBy(id = "gh-cat")
	WebElement allCategories;
	
	@FindBy(id = "gh-btn")
	WebElement searchBtn;
	
	@FindBy(linkText = "Saved")
	WebElement saved;
	
	@FindBy(linkText = "Motors")
	WebElement motors;
	
	@FindBy(linkText = "Trading Cards")
	WebElement tradingCards;
	
	@FindBy(linkText = "Collectibles")
	WebElement collectibles;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public HomePage hoverOnUserId() {
		Actions builder = new Actions(driver);
		builder.moveToElement(userId).build().perform();
		return new HomePage();
	}
	
	public String readUserId() {
		String actualId = "harspa-7589";
		return actualId;
	}
	
	public HelpAndContactsPage clickOnHelpAndContactsLink() throws IOException {
		helpAndContacts.click();
		return new HelpAndContactsPage();
	}
	
	public HomePage hoverOnlanguageLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(languageLink).build().perform();
		return new HomePage();
	}
	
	public void writeinSearchBox() {
		searchBox.sendKeys("computers");
		searchBtn.click();
	}
		
}

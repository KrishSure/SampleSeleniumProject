package org.selenium.SampleSeleniumProject.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.selenium.SampleSeleniumProject.Util.FunctionLibrary;

public class GmailHomePage {
	
	public FunctionLibrary fl;
	public WebDriver driver;
	
	public GmailHomePage(WebDriver driver) {
		this.driver = driver;
		fl=new FunctionLibrary();
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//a[contains(@href,'SignOutOptions')]") 
	public WebElement profileAccountIconElement;
	
	@FindBy(className="gb_Ob") 
	public WebElement profileAccountNameElement;
	
	@FindBy(linkText="Sign out")
	public WebElement signOutLinkElement;
	
	public void clickProfileAccountIcon() {
		fl.clickOnElement(profileAccountIconElement);
	}
	
	public String getProfileAccountName() {
		return fl.getElementDisplayText(profileAccountNameElement);
	}
	
	public void clickSignOutLink() {
		fl.clickOnElement(signOutLinkElement);
	}
	
	public GmailLogoutPage logout() {
		clickProfileAccountIcon();
		System.out.println("Account Name : "+getProfileAccountName());
		clickSignOutLink();
		return new GmailLogoutPage(driver);
	}
	
	public String getAccountName() {
		clickProfileAccountIcon();
		String name= getProfileAccountName();
		clickProfileAccountIcon();
		return name;
	}
	
}

package org.selenium.SampleSeleniumProject.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.SampleSeleniumProject.Util.FunctionLibrary;

public class GmailLogoutPage {
	
	public FunctionLibrary fl;
	public WebDriver driver;
	
	public GmailLogoutPage(WebDriver driver) {
		this.driver = driver;
		fl= new FunctionLibrary();
		PageFactory.initElements(driver, this);
				
	}

	@FindBy(id="forgotPassword")
	public WebElement forgotPassowordLinkElement;
	
	@FindBy(id="profileIdentifier")
	public WebElement profilesElement;
	
	//@FindBy(xpath="//div[text()='Remove an account']")
	@FindBy(xpath="//div[@class='bUk9Ve']/ul[1]/li[3]/div[1]/div[1]/div[2]")
	//@FindBy(className="BHzsHc")
	public WebElement removeAccountLinkElement;
	
	//@FindBy(xpath="//svg[@xmlns='https://www.w3.org/2000/svg']")
	@FindBy(className="n3x5Fb")
	public WebElement removeIconElement;
	
	@FindBy(xpath="//button[text()='Forgot email?']")
	public WebElement forgotEmailLinkElement;
	
	@FindBy(xpath="//div[@class='U26fgb O0WRkf oG5Srb C0oVfc kHssdc M9Bg4d']//span[text()='Yes, remove']")
	public WebElement removeAccountPopupYesElement;
	
	@FindBy(xpath="//*[text()='Signed out']")
	public WebElement signedOutlinkElement;
	
	public void clickSignedOutLink() {
		fl.clickOnElement(signedOutlinkElement);
	}
	
	
	public void clickRemoveAccountYes()
	{
		fl.clickOnElement(removeAccountPopupYesElement);
	}
	
	public boolean isForGotEmailexist() {
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return fl.isElementInteractable(forgotEmailLinkElement).isDisplayed();
	}
	
	public void clickRemoveAccount() {
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		fl.clickOnElement(removeAccountLinkElement);
	}
	
	public void clickProfiles() {
		fl.clickOnElement(profilesElement);
	}
	
	public boolean isForgotPassowrdExist() {
		return fl.isElementVisible(forgotPassowordLinkElement);
	}
	
	public void clickRemoveIcon() {
		fl.clickOnElement(removeIconElement);
	}
	
	public boolean removeAccount() {
		clickProfiles();
		clickRemoveAccount();
		clickRemoveIcon();
		//clickSignedOutLink();
		clickRemoveAccountYes();
		return isForGotEmailexist();
	}
	
}

package org.selenium.SampleSeleniumProject.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.SampleSeleniumProject.Util.FunctionLibrary;

public class GmailLoginPage {
	
	public FunctionLibrary fl;
	public WebDriver driver;
	
	public GmailLoginPage(WebDriver driver) {
		this.driver = driver;
		fl = new FunctionLibrary();
		PageFactory.initElements(driver, this);
	}

	//WebElement emailElement = driver.findByElement(By.id("identifierId"))
	@FindBy(id="identifierId") public WebElement emailTexFieldElement;
	
	@FindBy(xpath="//span[text()='Next']") public WebElement nextEmailButtonElement;
	
	@FindBy(name="password") public WebElement passwordTexFieldElement;
	
	@FindBy(xpath="//span[text()='Next']") public WebElement nextPasswordButtonElement;
	
	@FindBy(className="GQ8Pzc") public WebElement wrongEmailErrorMessageElement;
	
//	@FindBy(className="GQ8Pzc") public WebElement wrongPasswordErrorMessageElement;
	@FindBy(xpath="//div[@id='password']/div[2]/div/div") public WebElement wrongPasswordErrorMessageElement;
	
	public void setEmailTextField(String value) {
		//emailTexFieldElement.sendKeys(value);
		fl.setValueForElement(emailTexFieldElement, value);
	}
	
	public void setPasswordTextField(String value) {
		//emailTexFieldElement.sendKeys(value);
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		fl.setValueForElement(passwordTexFieldElement, value);
	}
	
	public void clickNextEmailButton() {
		fl.clickOnElement(nextEmailButtonElement);
	}
	
	public void clickNextPasswordButton() {
		fl.clickOnElement(nextPasswordButtonElement);
	}
	
	public String getWrongEmailErrorMessage() {
		return fl.getElementDisplayText(wrongEmailErrorMessageElement);
	}
	public String getWrongPasswordErrorMessage() {
		return fl.getElementDisplayText(wrongPasswordErrorMessageElement);
	}
	public GmailHomePage login(String userName,String password) {
		setEmailTextField(userName);
		clickNextEmailButton();
		setPasswordTextField(password);
		clickNextPasswordButton();	
		return new GmailHomePage(driver);
	}
	
	public boolean login(String userName,String password,boolean verify) {
		setEmailTextField(userName);
		clickNextEmailButton();
		setPasswordTextField(password);
		clickNextPasswordButton();	
		//GmailHomePage ghp = new GmailHomePage(driver);
		
		if(verify)
			return new GmailHomePage(driver).getAccountName().equals(userName);
		else
			return true;
	}
	
	
}

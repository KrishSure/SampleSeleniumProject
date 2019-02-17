package org.selenium.SampleSeleniumProject;

import org.openqa.selenium.WebDriver;
import org.selenium.SampleSeleniumProject.Util.FunctionLibrary;
import org.selenium.SampleSeleniumProject.gmail.pages.GmailHomePage;
import org.selenium.SampleSeleniumProject.gmail.pages.GmailLoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailLoginTest extends GmailBaseTest {
	/*FunctionLibrary fl;
	WebDriver driver;
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
		 fl = new FunctionLibrary();
	}
	
	@BeforeMethod
	public void beforeTestMethod()
	{	 
		driver = fl.launchFireFoxBrowser();
		  
		fl.launchURL("https://www.google.com/gmail");
	}*/
	
  @Test
  public void loginIntoGmail() {  
	 
	  
	  GmailLoginPage gl = new GmailLoginPage(driver);
	  
	  String userName = "tselenium92@gmail.com";
	  
	  GmailHomePage ghp = gl.login(userName,"@testing123");
	  
	  String actualResult = ghp.getAccountName();
	  
	  //userName = "tselenium92";
	  
	  Assert.assertEquals(actualResult, userName,"Expected Result is:"+userName+" Actual Result is :"+actualResult);
	  
	  System.out.println("Test is ended");
	 
  }
  
  @Test
  public void loginIntoGmail_wrongEmail() {  
	 
	  
	  GmailLoginPage gl = new GmailLoginPage(driver);
	  
	  String userName = "tselenium93@gmail.com";
	  
	  gl.setEmailTextField(userName);
	  
	  gl.clickNextEmailButton();
	  
	  Assert.assertEquals(gl.getWrongEmailErrorMessage(), "Couldn't find your Google Account");  
	  
  }	
  
  @Test
  public void loginIntoGmail_wrongPassword() {
		  
	  GmailLoginPage gl = new GmailLoginPage(driver);
	  
	  String userName = "tselenium92@gmail.com";
	  
	  String wrongPassword = "@testing321";
	  
	  gl.setEmailTextField(userName);
	  
	  gl.clickNextEmailButton();
	  
	  gl.setPasswordTextField(wrongPassword);
	  
	  gl.clickNextPasswordButton();
	  
	  Assert.assertEquals(gl.getWrongPasswordErrorMessage(), "Wrong password. Try again or click Forgot password to reset it.");
	  
	  /*GmailHomePage ghp = gl.login(userName,"@testing124");
	  
	  Assert.assertEquals(ghp.getAccountName(), userName);*/
  }	
  
  /*@AfterMethod
  public void afterTestMethod() {
	  driver.close();
  }
  
  @AfterClass
  public void afterClass() {
	  System.out.println("Class is ended");
	  
  }
  
  @AfterTest
  public void aftrTest() {
	  System.out.println("Test is ended");
  }
  
  @AfterSuite
  public void aftrSuite() {
	  System.out.println("Suite is ended");
  }*/
}

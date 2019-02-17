package org.selenium.SampleSeleniumProject;

import org.openqa.selenium.WebDriver;
import org.selenium.SampleSeleniumProject.Util.FunctionLibrary;
import org.selenium.SampleSeleniumProject.gmail.pages.GmailHomePage;
import org.selenium.SampleSeleniumProject.gmail.pages.GmailLoginPage;
import org.selenium.SampleSeleniumProject.gmail.pages.GmailLogoutPage;
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

public class GmailLogoutTest extends GmailBaseTest {
//public class GmailLogoutTest {
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
			 driver = fl.launchFireFoxBrowser();
			 fl.launchURL("https://www.google.com/gmail");
		}
		
		@BeforeMethod
		public void beforeTestMethod()
		{	 
			
			  
			
		}*/
	@Test
	public void GmailLogout() {
		/*FunctionLibrary fl = new FunctionLibrary();

		WebDriver driver = fl.launchFireFoxBrowser();

		fl.launchURL("https://www.google.com/gmail");*/

		GmailLoginPage gl = new GmailLoginPage(driver);

		String userName = "tselenium92@gmail.com";

		GmailHomePage ghp = gl.login(userName,"@testing123");

		String actualResult = ghp.getAccountName();	  

		Assert.assertEquals(actualResult, userName,"Expected Result is:"+userName+" Actual Result is :"+actualResult);

		GmailLogoutPage glp = ghp.logout();

		Assert.assertTrue(glp.isForgotPassowrdExist());  	  

	}
	
	@Test(dependsOnMethods= {"GmailLogout"})
	public void GmailLogout_removeAccount() {
		/*FunctionLibrary fl = new FunctionLibrary();

		WebDriver driver = fl.launchFireFoxBrowser();

		fl.launchURL("https://www.google.com/gmail");*/

		GmailLoginPage gl = new GmailLoginPage(driver);

		String userName = "tselenium92@gmail.com";

		GmailHomePage ghp = gl.login(userName,"@testing123");

		String actualResult = ghp.getAccountName();	  

		Assert.assertEquals(actualResult, userName,"Expected Result is:"+userName+" Actual Result is :"+actualResult);

		GmailLogoutPage glp = ghp.logout();

		Assert.assertTrue(glp.isForgotPassowrdExist()); 
		
		//GmailLogoutPage glp = new GmailLogoutPage(driver);
		//removing and verifying that
		Assert.assertTrue(glp.removeAccount());

	}
	/*@AfterMethod
	  public void afterTestMethod() {
		  
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  driver.close();
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

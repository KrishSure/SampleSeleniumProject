package org.selenium.SampleSeleniumProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.selenium.SampleSeleniumProject.Util.FunctionLibrary;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class GmailBaseTest {
	FunctionLibrary fl;
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
	} 
	
	@AfterMethod
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
	  }

}

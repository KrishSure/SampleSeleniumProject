package org.selenium.SampleSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.SampleSeleniumProject.Util.FunctionLibrary;

public class ComposeMailGmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionLibrary fl = new FunctionLibrary();
		
		WebDriver driver = fl.launchFireFoxBrowser();
		
		fl.launchURL("https://www.google.com/gmail");
		
		String signInEmail = "tselenium92@gmail.com";
		
		fl.setValueForElement(driver.findElement(By.id("identifierId")),signInEmail);
		
		fl.clickOnElement(driver.findElement(By.xpath("//span[text()='Next']")));
		
		fl.setValueForElement(driver.findElement(By.name("password")), "@testing123");
		
		fl.clickOnElement(driver.findElement(By.xpath("//span[text()='Next']")));
		
	}

}

package org.selenium.SampleSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GamilLogin {
	
	public static void setUserName(WebDriver driver,String locator,String emailValue) {
		
		WebElement userName = driver.findElement(By.id(locator));
		userName.clear();
		userName.sendKeys(emailValue);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Setup launch browser
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver_v24.exe");
		//Launching the browser
		WebDriver driver = new FirefoxDriver();

		//1. Open URL https://www.google.com/gmail/
		driver.get("https://www.google.com/gmail");

		//2. Enter user name Username- tselenium92@gmail.com
		String signInEmail = "tselenium92@gmail.com";
		String usernameId = "identifierId";
		/*WebElement userName = driver.findElement(By.id(usernameId));
		userName.clear();
		userName.sendKeys(signInEmail);*/
		setUserName(driver,usernameId, signInEmail);

		//3. Click on next button
		String nextButtonXpath = "//span[text()='Next']";
		driver.findElement(By.xpath(nextButtonXpath)).click();

		//3.1 waiting for password wizard open
		Thread.sleep(1000);

		//4. Enter Password Password- @testing123
		String passwordText = "@testing123";
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(passwordText);

		//5. Click on Next button
		driver.findElement(By.xpath(nextButtonXpath)).click();

		//6. Click on Google account Icon
		driver.findElement(By.xpath("//a[contains(@href,'SignOutOptions')]")).click();

		//7. Get account email or phone on Expanded account details.
		String loggedInEamil = driver.findElement(By.className("gb_Ob")).getText();

		//8. Verify the login and email are same or not
		if(signInEmail.equals(loggedInEamil)) {
			System.out.println("Successfully Logged in");
		}else
		{
			System.out.println("Login Failed");
		}


	}
}

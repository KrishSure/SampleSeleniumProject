package org.selenium.SampleSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailLogout {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// Setup launch browser
				System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver_v24.exe");
				//Launching the browser
				WebDriver driver = new FirefoxDriver();

				//1. Open URL https://www.google.com/gmail/
				driver.get("https://www.google.com/gmail");

				//2. Enter user name Username- tselenium92@gmail.com
				String signInEmail = "tselenium92@gmail.com";
				WebElement userName = driver.findElement(By.id("identifierId"));
				userName.clear();
				userName.sendKeys(signInEmail);

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
				
				
				//9. Click on Sign out
				driver.findElement(By.linkText("Sign out")).click();
				
				Thread.sleep(1000);
				//10. Verifying the Forgot password link is getting displayed
				WebElement forgotPasswordLinkElement = driver.findElement(By.id("forgotPassword"));
				
				if(forgotPasswordLinkElement.isDisplayed()) {
					System.out.println("Successfully Logged out");
				}else
				{
					System.out.println("Logout fialed");
				}
				
				//11. Removing the account from the recent loggedin list
				//11.1 clicking on profile account id.
				
				driver.findElement(By.id("profileIdentifier")).click();
				
				//11.2 Clicking on remove an account link
				Thread.sleep(1000);
				driver.findElement(By.className("BHzsHc")).click();
				
				//11.3 Clicking on recently signedout account
				/*Thread.sleep(1000);
				String xpathForSignedOutAccount = "//div[@data-email='"+signInEmail+"']";
				
				System.out.println(xpathForSignedOutAccount);
				
				//driver.findElement(By.xpath(xpathForSignedOutAccount)).click();
				driver.findElement(By.id("profileIdentifier")).click();
				
				//11.4 Click on Yes, remove on Remove account confirmation popup
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='Yes, remove']")).click();
				*/
				//12 verifying the forgot email link
				Thread.sleep(1000);
				WebElement forgotEmailLink =driver.findElement(By.xpath("//button[text()='Forgot email?']"));
				
				if(forgotEmailLink.isDisplayed()) {
					System.out.println("Account successfully removed from the profile");
				}else
				{
					System.out.println("Account not remvoed properly");
				}
				
				
				
	}

}

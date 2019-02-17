package org.selenium.SampleSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FacebookLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver_v24.exe");

		/*FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("permissions.default.desktop-notification", 1);*/
        FirefoxOptions FfOptions = new FirefoxOptions();
        FfOptions.addPreference("permissions.default.desktop-notification", 1);
        //FfOptions.addPreference("permissions.default.desktop-notification", 1);
        
		
		//Launching the browser
		WebDriver driver = new FirefoxDriver(FfOptions);
		//WebDriver driver = new FirefoxDriver(new FirefoxOptions().addPreference("permissions.default.desktop-notification", 1));

		//Opening the application URL on the browser
		driver.get("https://www.facebook.com/");

		WebElement userName = driver.findElement(By.id("email"));
		
		if(userName.isDisplayed())
			userName.sendKeys("selenium Text");
		else
			System.out.println("Unable to enter the userNmae");
		
		driver.findElement(By.id("pass")).sendKeys("Test@123");
		
		driver.findElement(By.id("loginbutton")).click();
		
		driver.findElement(By.id("userNavigationLabel")).click();
		
		WebElement logOutElement =driver.findElement(By.linkText("Home"));
//				driver.findElement(By.xpath("//a[contains(@data-gt,'logout_menu_click')]"));
		
		if(logOutElement.isDisplayed()) {
			System.out.println("Successfully Logged in");
		}else
		{
			System.out.println("Login Failed we are unable to see logout link");
		}
		
		
	}

}

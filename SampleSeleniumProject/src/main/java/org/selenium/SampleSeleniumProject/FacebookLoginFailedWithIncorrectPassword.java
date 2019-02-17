package org.selenium.SampleSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLoginFailedWithIncorrectPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver_v24.exe");

		//Launching the browser
		WebDriver driver = new FirefoxDriver();

		//Opening the application URL on the browser
		driver.get("https://www.facebook.com/");

		//driver.findElement(By.id("email")).sendKeys("dilipkumarpv8899@gmail.com");
		GamilLogin.setUserName(driver, "email", "dilipkumarpv8899@gmail.com");
		
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("loginbutton")).click();

		String errorMessage = driver.findElement(By.xpath("//div[@class='_4rbf _53ij']")).getText();
		System.out.println(" Error message on application "+errorMessage);
		
		if("The password that you've entered is incorrect. Forgotten password?".equals(errorMessage)) 
			System.out.println("Test is passed");
		else
			System.out.println("Test is failed");
	
}

}

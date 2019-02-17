package org.selenium.SampleSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer_v3.9.0.exe");

		WebDriver driver = new InternetExplorerDriver();

		driver.get("https://www.facebook.com/");

		driver.findElement(By.id("email")).sendKeys("surevkrishna");
		driver.findElement(By.id("pass")).sendKeys("********");
		driver.findElement(By.id("loginbutton")).click();

		driver.close();
	}

}

package org.selenium.SampleSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver_v2.42.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
        
        driver.findElement(By.id("email")).sendKeys("surevkrishna");
        driver.findElement(By.id("pass")).sendKeys("********");
        driver.findElement(By.id("loginbutton")).click();
		
		driver.close(); 
	}

}

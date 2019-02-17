package org.selenium.SampleSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class FirefoxDemo 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //Setting the geckodriver.exe file to the system property for "webdriver.gecko.driver"
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\vsure.ORADEV\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\eclipse-oxyzen-31stJanuary2019\\SampleSeleniumProject\\Drivers\\geckodriver_v24.exe");
        System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver_v24.exe");
        
        //Launching the browser
        WebDriver driver = new FirefoxDriver();
        
        //Opening the application URL on the browser
        driver.get("https://www.facebook.com/");
        
        driver.findElement(By.id("email")).sendKeys("surevkrishna");
        driver.findElement(By.id("pass")).sendKeys("********");
        driver.findElement(By.id("loginbutton")).click();
        
        
        
        
        
        //Finally closing the browser
        //driver.close();
    }
}

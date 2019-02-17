package org.selenium.SampleSeleniumProject.Util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionLibrary {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public WebDriver launchFireFoxBrowser() {
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver_v24.exe");
		//Launching the browser
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 40);
		//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		return driver;
	}
	
	public void launchURL(String URL) {
		driver.get(URL);
	}
	
	public void clickOnElement(final WebElement element) {
		/*if(isElementVisible(element)) 
			element.click();*/
		//ElementClickInterceptedException
		
		try {
			isElementClickable(element).click();
		} catch (Exception e) {
			e.printStackTrace();
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(100))
					.pollingEvery(Duration.ofMillis(500))
					.ignoring(ElementClickInterceptedException.class);
			
			WebElement pollingElement =(WebElement) wait.until(new Function<WebDriver, WebElement>(){
				public WebElement apply(WebDriver driver) {
					return (WebElement) ExpectedConditions.elementToBeClickable(element);
				}
			});
			
			Boolean isClikable = (Boolean) wait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					return	driver.findElement(By.tagName("html")).isEnabled();					 
				}
			});
			
			if(isClikable)
				element.click();
					
			
		}
	}
	
	public void setValueForElement(WebElement element, String value) {
		/*if(isElementVisible(element))
			element.sendKeys(value);*/
		isElementInteractable(element).clear();
		isElementInteractable(element).sendKeys(value);
	}
	
	public boolean isElementVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}
	
	public WebElement isElementClickable(WebElement element) {		
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement isElementInteractable(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String getElementDisplayText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}
}

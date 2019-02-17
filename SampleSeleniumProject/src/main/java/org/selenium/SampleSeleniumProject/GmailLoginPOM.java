package org.selenium.SampleSeleniumProject;

import org.openqa.selenium.WebDriver;
import org.selenium.SampleSeleniumProject.Util.FunctionLibrary;
import org.selenium.SampleSeleniumProject.gmail.pages.GmailHomePage;
import org.selenium.SampleSeleniumProject.gmail.pages.GmailLoginPage;
import org.selenium.SampleSeleniumProject.gmail.pages.GmailLogoutPage;

public class GmailLoginPOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionLibrary fl = new FunctionLibrary();

		WebDriver driver = fl.launchFireFoxBrowser();

		fl.launchURL("https://www.google.com/gmail");

		GmailLoginPage glip= new GmailLoginPage(driver);

		String username="tselenium92@gmail.com";

		glip.login(username, "@testing123");

		GmailHomePage ghp = new GmailHomePage(driver);

		//if(glip.login(username, "@testing123",true))
		if(ghp.getAccountName().equals(username)) {
			System.out.println("Login is successfull");
		}else
		{
			System.out.println("Login is failed");
		}

		ghp.logout();

		GmailLogoutPage glop = new GmailLogoutPage(driver);

		if(glop.isForgotPassowrdExist()){
			System.out.println("Logout is successfull");
		} else
		{
			System.out.println("Logout is failed");
		}

		if(glop.removeAccount())
		{
			System.out.println("remove account  successfull");
		} else
		{
			System.out.println("remove account is failed");
		}


	}

}

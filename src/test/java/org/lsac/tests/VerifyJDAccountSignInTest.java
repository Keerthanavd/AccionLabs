/*
 * Verify to login using JD Account, and if user gets to MyHome page
 */

package org.lsac.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AccountAccessPage;
import pages.HomePage;
import pages.MyHomePage;
import pages.SigninPage;
import utils.ExcelConnect;

public class VerifyJDAccountSignInTest extends BaseTest {

	@Test(dataProvider="Login",dataProviderClass = ExcelConnect.class)
	public void signIn(String username, String password){

		HomePage homePage=new HomePage(driver);
		if(executeIn.equals("chrome")||executeIn.equals("edge"))
		{
			//Click LoginAs in home page and select JD Account
			homePage.clickLoginAs("JD Account");
			logger.info("Clicked login as and selected JD account");

			//Switch to new tab
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
		}

		else if(executeIn.equals("Android")) {
			homePage.clickNavigationMenu();
			homePage.clickLoginAsJDAccount();
		}

		//click login to your account in account access page
		AccountAccessPage accountAccessPage = new AccountAccessPage(driver);
		accountAccessPage.clickLogInToYourAccount();
		logger.info("Clicked login to your account");

		//Enter username and password and click sign-in in sign in page
		SigninPage signinPage = new SigninPage(driver);
		signinPage.signin(username, password);
		logger.info("entered username and password to sign in");

		//Verify if user is logged in
		MyHomePage myHomePage = new MyHomePage(driver);
		myHomePage.verifyIfUserLoggedIn();
		logger.info("user logged in");
	}
}

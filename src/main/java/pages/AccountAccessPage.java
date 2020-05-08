package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccountAccessPage extends BasePage {
	@AndroidFindBy(id = "ctl00_OS2ContentPlaceHolder_LogIn") 
	@FindBy(id = "ctl00_OS2ContentPlaceHolder_LogIn") 
	public RemoteWebElement btn_login;
	

	//constructor to call basepage constructor
	//And to verify if on the right page
	public AccountAccessPage(RemoteWebDriver driver) {
		super(driver);
		Assert.assertTrue(driver.getTitle().contains("Account Access"), "Not in account access page");
	}
	
	public void clickLogInToYourAccount() {
		click(btn_login);
	}
	

}
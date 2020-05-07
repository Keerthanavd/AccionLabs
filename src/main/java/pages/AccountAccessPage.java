package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountAccessPage extends BasePage {

	@FindBy(id = "ctl00_OS2ContentPlaceHolder_LogIn") WebElement btn_login;

	//constructor to call basepage constructor
	//And to verify if on the right page
	public AccountAccessPage(WebDriver driver) {
		super(driver);
		Assert.assertTrue(driver.getTitle().contains("Account Access"), "Not in account access page");
	}
	
	public void clickLogInToYourAccount() {
		click(btn_login);
	}
	

}
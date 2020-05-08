package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class SigninPage extends BasePage{
	@AndroidFindBy(id = "logonIdentifier")
	@FindBy(css = "#logonIdentifier") 
	RemoteWebElement txtfield_username;
	
	@AndroidFindBy(id = "password") 
	@FindBy(css = "#password") 
	RemoteWebElement txtfield_password;
	
	@AndroidFindBy(id = "next")
	@FindBy(css = "#next") 
	RemoteWebElement btn_signin;

	
	
	public SigninPage(RemoteWebDriver driver) {
		super(driver);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Sign In"), "Not in Sign In page");
	}
	
	/*Method to enter username and password to sign in. 
	Data for arguments is taken from excel, testdata.xlx
	present in the project*/
	public void signin(String Username,String Password){
		waitForElementToBeClickable(btn_signin);
		fillUtils(txtfield_username,Username);
		fillUtils(txtfield_password,Password);
		click(btn_signin);
	}

}

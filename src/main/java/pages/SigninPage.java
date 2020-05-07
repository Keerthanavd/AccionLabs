package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SigninPage extends BasePage{

	@FindBy(css = "#logonIdentifier") WebElement txtfield_username;
	@FindBy(css = "#password") WebElement txtfield_password;
	@FindBy(css = "#next") WebElement btn_signin;

	
	
	public SigninPage(WebDriver driver) {
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

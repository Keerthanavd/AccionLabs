package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyHomePage extends BasePage{
	@FindBy(css = "#ctl00_lbLogOff") WebElement link_logout;
	
	public MyHomePage(WebDriver driver) {
		super(driver);
		waitForElementToBeVisible(link_logout);
		Assert.assertTrue(driver.getTitle().contains("My Home"), "Not in My Home page");
	}
	
	public void verifyIfUserLoggedIn() {
		Assert.assertTrue(link_logout.isDisplayed(), "User is not logged in");
	}

}

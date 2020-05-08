package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchPage extends BasePage{
	@FindBy(css = "#edit-search") WebElement txtField_Editsearch;	
	@FindBy(css = "[type='submit']") WebElement btn_search;	

	
	public SearchPage(RemoteWebDriver driver) {
		super(driver);
		waitForElementToBeClickable(btn_search);
		Assert.assertTrue(driver.getTitle().contains("Search"), "Not in Search page");
	}
	
	public void enterSearch(String toSearch) {
		fillUtils(txtField_Editsearch, toSearch);
		waitForElementToBeClickable(btn_search);
		click(btn_search);
	}

	public void countSuggestions() {
		List<WebElement> Suggestions = driver.findElements(By.tagName("article"));
		Assert.assertTrue(Suggestions.size()==10, "Total suggestions count is not 10");
	}
}

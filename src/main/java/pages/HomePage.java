	package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	Actions action; 
	@FindBy(css = ".log-in-menu.menu-about__item > a") WebElement btn_loginAs;
	@FindBy(css = "#block-lsac-aboutlsacmenu>ul>li:nth-child(6)>a") WebElement link_search;	
	
	//constructor to call basepage constructor
	public HomePage(WebDriver driver) {
		super(driver);
		if(btn_AcceptCookie.isDisplayed()) {
			click(btn_AcceptCookie);
		}
	}

	public void clickLoginAs(String AccountType) {
		action = new Actions(driver);
		action.moveToElement(btn_loginAs).build().perform();
		click(driver.findElement(By.linkText(AccountType)));
	}
	
	public void clickSearch() {
		click(link_search);
	}
}

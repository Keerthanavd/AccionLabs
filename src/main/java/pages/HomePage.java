	package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {
	Actions action; 
	@FindBy(css = ".log-in-menu.menu-about__item > a")
	 WebElement btn_loginAs;
	
	@AndroidFindBy(xpath = "//android.view.MenuItem[@index='6']") 
	@FindBy(css = "#block-lsac-aboutlsacmenu>ul>li:nth-child(6)>a") 
	RemoteWebElement link_search;	
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Open navigation menu']") WebElement txt_navigationmenu;
	
	
	@AndroidFindBy(xpath = "//android.view.MenuItem[@index='5']") 
	WebElement drpdwn_loginas;
	
	
	@AndroidFindBy(xpath = "[@text='JD Account']") 
	WebElement drpdwn_JDAccount;

	//constructor to call basepage constructor
	public HomePage(RemoteWebDriver driver) {
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
	
	public void clickNavigationMenu() {
		click(txt_navigationmenu);
		
	}
	public void clickLoginAsJDAccount() {
	click(drpdwn_loginas);
	click(drpdwn_JDAccount);
	}
}

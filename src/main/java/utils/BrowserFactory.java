package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;

public class BrowserFactory {
	static WebDriver driver;
	public static WebDriver chooseBrowser(String BrowserName) {
		if(BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Drivers\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (BrowserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "E:\\Softwares\\Drivers\\Edge\\MicrosoftWebDriver.exe");
			 driver = new EdgeDriver();
		}

		return driver;
	}

}

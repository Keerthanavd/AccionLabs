package utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserFactory {
	static RemoteWebDriver driver;
	//static AndroidDriver<AndroidElement> A_driver;
	public static RemoteWebDriver chooseBrowser(String BrowserName) {
		if(BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Drivers\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (BrowserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "E:\\Softwares\\Drivers\\Edge\\MicrosoftWebDriver.exe");
			 driver = new EdgeDriver();
		}

		
	
		else if (BrowserName.equals("Android")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("deviceName", "Galaxy_Nexus_API_25");
				caps.setCapability("udid", "emulator-5554"); //Give Device ID of your mobile phone
				caps.setCapability("platformName", "Android");
				caps.setCapability("platformVersion", "7.1");
				caps.setCapability("appPackage", "com.android.chrome");
				caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
				try {
					driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

				} catch (MalformedURLException e) {
					System.out.println(e.getMessage());
				}
		}
		
		
		return driver;

	}
}



package org.lsac.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BrowserFactory;
@Listeners(utils.NGListeners.class)

public class BaseTest {
	public RemoteWebDriver driver;
	Logger logger;
	//Android for android phones
	//edge for edge browser
	//chrome for chrome browser
	// configure log4j properties file
	static String executeIn = "Android";
	
	@BeforeMethod
	public void initialSetup(ITestContext context) {
		logger=Logger.getLogger("BaseTest");
		PropertyConfigurator.configure("log4j.properties");

		driver=BrowserFactory.chooseBrowser(executeIn);
		if(executeIn.equals("chrome")||executeIn.equals("edge"))
		{
			driver.manage().window().maximize();
			logger.info("window maximized");
		}
		String url = "http://www.LSAC.org";
		driver.get(url);
		logger.info("URL launched");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		context.setAttribute("webDriver", driver);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

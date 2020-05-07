/*
 * Verify search functionality and count the links
 */

package org.lsac.tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchPage;

public class VerifySearchCountLinks extends BaseTest{
	@Test
	public void verifySearchCountLinks() throws InterruptedException {
	
	//Click search in home page and select search
	HomePage homePage=new HomePage(driver);
	homePage.clickSearch();
	logger.info("search button clicked");
	
	//Enter in search field
	SearchPage searchPage = new SearchPage(driver);
	searchPage.enterSearch("test");
	logger.info("value entered and search button clicked");

	//Get count
	searchPage.countSuggestions();
}
}

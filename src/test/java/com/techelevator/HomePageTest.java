package com.techelevator;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.techelevator.npgeek.pageobject.ParkDetailPage;

public class HomePageTest {


	private static WebDriver webDriver;
	private HomePage homePage;

	@BeforeClass
	public static void createWebDriver(){
		String homeDir = System.getProperty("user.home");
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}

	@Before
	public void goHome(){
		webDriver.get("http://localhost:8080/m3-java-capstone/");
		webDriver.navigate().refresh();
		homePage = new HomePage(webDriver);
	}

	@AfterClass
	public static void closeWebDriver(){
		webDriver.close();
	}

	@Test
	public void test_homePage_info(){
		//		ParkDetailPage detailPage = homePage.clickOnPark("CVNP");
//		ParkDetailPage detailPage = homePage.checkParksOnHomePage("CVNP");
//		Assert.assertNotNull(detailPage.getAcreage());
		//		Assert.assertNotNull(homePage.getAcreage());
		//		ParkDetailPage detailPage = homePage.;
		//		ParkDetailPage detailPage = homePage.clickOnPark("CVNP");
		//		Assert.assertNotNull(detailPage.getYearFounded());
		//		Assert.assertNotNull(detailPage.getParkName());
		//		Assert.assertNotNull(detailPage.getState());
		//		Assert.assertNotNull(detailPage.getMilesOfTrail());
		//		Assert.assertNotNull(detailPage.getAcreage());
		//		Assert.assertNotNull(detailPage.getElevation());
		//		Assert.assertNotNull(detailPage.getClimate());
		//		Assert.assertNotNull(detailPage.getNumberofAnimals());
		//		Assert.assertNotNull(detailPage.getAnnualVisitors());
		//		Assert.assertNotNull(detailPage.getNumberOfCampsites());
	}

}

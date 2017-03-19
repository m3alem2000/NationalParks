package com.techelevator;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.npgeek.pageobject.ParkDetailPage;
import com.techelevator.npgeek.pageobject.SurveyInputPage;
import com.techelevator.npgeek.pageobject.SurveyResultsPage;
import com.techelevator.npgeek.parks.model.Park;
import com.techelevator.npgeek.parks.model.ParkDAO;
import com.techelevator.npgeek.parks.model.Survey;

public class homePageTest {

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
	public void test_park_info(){
		
		ParkDetailPage detailPage = homePage.clickOnPark("CVNP");
		Assert.assertNotNull(detailPage.getYearFounded());
		Assert.assertNotNull(detailPage.getParkName());
		Assert.assertNotNull(detailPage.getState());
		Assert.assertNotNull(detailPage.getMilesOfTrail());
		Assert.assertNotNull(detailPage.getAcreage());
		Assert.assertNotNull(detailPage.getElevation());
		Assert.assertNotNull(detailPage.getClimate());
		Assert.assertNotNull(detailPage.getNumberofAnimals());
		Assert.assertNotNull(detailPage.getAnnualVisitors());
		Assert.assertNotNull(detailPage.getNumberOfCampsites());
	}
	
	@Test
	public void set_Survey(){
		Survey survey = new Survey();
		SurveyInputPage surveyInput = homePage.clickTakeOurSurvey();
		surveyInput.selectPark("Grand Teton National Park");
		surveyInput.selectState("Alabama");
		surveyInput.inputEmailAddress("hiker@yahoo.com");
		SurveyResultsPage result = surveyInput.submit();
		Assert.assertNotNull(survey.getVotes());
	}
}

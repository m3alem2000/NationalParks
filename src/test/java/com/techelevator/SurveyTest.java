package com.techelevator;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.techelevator.npgeek.pageobject.SurveyInputPage;
import com.techelevator.npgeek.pageobject.SurveyResultsPage;
import com.techelevator.npgeek.parks.model.Survey;

public class SurveyTest {

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
			homePage = new HomePage(webDriver);
		}
		
		@AfterClass
		public static void closeWebDriver(){
			webDriver.close();
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

	
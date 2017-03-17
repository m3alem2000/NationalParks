package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.parks.jdbc.JDBCSurveyDAO;
import com.techelevator.npgeek.parks.model.Survey;



public class JDBCSurveyDAOIntegrationTest extends DAOIntegrationTest {
	
	private JDBCSurveyDAO surveyDao;
	
	@Before
	public void setup() {
		surveyDao = new JDBCSurveyDAO(getDataSource());
	}
	
	@Test
	public void getAllSurveysReturnsListSizeGreaterThanZero() {
		List<Survey> testSurveyList= surveyDao.getAllSurveys();
		
		Assert.assertNotEquals(0, testSurveyList.size());
	}
	
	@Test
	public void getAllSurveysSizeIncreasesByOneAfterAddSurvey() {
		int currentSurveyListSize = surveyDao.getAllSurveys().size();
		
		Survey testSurvey = new Survey();
		testSurvey.setParkCode("GNP");
		testSurvey.setEmailAddress("test@bing.com");
		testSurvey.setState("AL");
		testSurvey.setActivityLevel("inactive");
		surveyDao.addSurvey(testSurvey);
		
		Assert.assertEquals(currentSurveyListSize + 1, surveyDao.getAllSurveys().size());
	}
	
	@Test
	public void getTopSurveyParkReturnsNotNull() {
		Survey testSurvey = surveyDao.getTopSurveyPark();
		
		Assert.assertNotNull(testSurvey);
	}
}

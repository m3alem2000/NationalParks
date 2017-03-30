package com.techelevator.npgeek.unittests;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.npgeek.parks.model.Survey;


public class SurveyTest {
	
	@Test
	public void surveyInitializesCorrectly() {
		Survey testSurvey = new Survey();
		testSurvey.setParkCode("GNP");
		testSurvey.setEmailAddress("bigdog@hotmail.com");
		testSurvey.setState("OH");
		testSurvey.setActivityLevel("active");
		
		Assert.assertEquals("GNP", testSurvey.getParkCode());
		Assert.assertEquals("bigdog@hotmail.com", testSurvey.getEmailAddress());
		Assert.assertEquals("OH", testSurvey.getState());
		Assert.assertEquals("active", testSurvey.getActivityLevel());
	}
}

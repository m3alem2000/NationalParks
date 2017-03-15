package com.techelevator.npgeek.parks.model;

import java.util.ArrayList;

public interface SurveyDAO {

	public ArrayList<Survey> getAllSurveys();
	public Survey getTopSurveyPark();
	public void addSurvey(String parkCode, String emailAddress, String state, String activityLevel);
}

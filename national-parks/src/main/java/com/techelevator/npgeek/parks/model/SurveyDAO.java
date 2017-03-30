package com.techelevator.npgeek.parks.model;

import java.util.ArrayList;

public interface SurveyDAO {

	public ArrayList<Survey> getAllSurveys();
	public Survey getTopSurveyPark();
	public void addSurvey(Survey theSurvey);
}

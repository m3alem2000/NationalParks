package parks.model;

import java.util.ArrayList;

public interface SurveyDAO {

	public ArrayList<Survey> getAllSurveys();
	public Survey getTopSurveyPark();
	public Survey addSurvey(String parkCode, String emailAddress, String state, String activityLevel);
}

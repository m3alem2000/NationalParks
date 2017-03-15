package com.techelevator.npgeek.parks.jdbc;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.parks.model.Survey;
import com.techelevator.npgeek.parks.model.SurveyDAO;

public class JDBCSurveyDAO implements SurveyDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public ArrayList<Survey> getAllSurveys() {
		String sqlFindAllSurveyResults = "select * from survey_result order by parkcode";
			ArrayList<Survey> surveyResult = new ArrayList<Survey>();
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllSurveyResults);
			while(results.next()) {
				Survey survey = mapRowToSurvey(results);
				surveyResult.add(survey);
			}
		return surveyResult;
	}

	@Override
	public Survey getTopSurveyPark() {
		
		return null;
	}

	@Override
	public Survey addSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Survey mapRowToSurvey(SqlRowSet results) {
		Survey theSurvey;
		theSurvey = new Survey();
		theSurvey.setSurveyId(results.getInt("surveyid"));
		theSurvey.setParkCode(results.getString("parkcode"));
		theSurvey.setEmailAddress(results.getString("emailaddress"));
		theSurvey.setState(results.getString("state"));
		theSurvey.setActivityLevel(results.getString("activitylevel"));
		
		return theSurvey;
	}

}

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
		Survey theSurvey = null;
		String sqlFindTopSurveyResults = "select count(parkcode) as votes, parkcode from survey_result" +
										"group by parkcode order by parkcode desc limit 1";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindTopSurveyResults);
		if(results.next()) {
			theSurvey = mapRowToSurvey(results);
		
		}
	return theSurvey;

	}

	@Override
	public void addSurvey(String parkCode, String emailAddress, String state, String activityLevel) {
		String sqlSurvey = "insert into survey_result (parkcode, emailaddress, state, activitylevel) " +
							"values (?,?,?,?)";
		jdbcTemplate.update(sqlSurvey, parkCode, emailAddress, state, activityLevel);
		
	}
	
	private Survey mapRowToSurvey(SqlRowSet results) {
		Survey theSurvey;
		theSurvey = new Survey();
		theSurvey.setSurveyId(results.getInt("surveyid"));
		theSurvey.setParkCode(results.getString("parkcode"));
		theSurvey.setEmailAddress(results.getString("emailaddress"));
		theSurvey.setState(results.getString("state"));
		theSurvey.setActivityLevel(results.getString("activitylevel"));
		theSurvey.setVotes(results.getInt("votes"));
		
		return theSurvey;
	}

}

package com.techelevator.npgeek.parks.jdbc;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.parks.model.Park;
import com.techelevator.npgeek.parks.model.Survey;
import com.techelevator.npgeek.parks.model.SurveyDAO;

@Component
public class JDBCSurveyDAO implements SurveyDAO {
	
	private JdbcTemplate jdbcTemplate;
	Park thePark = null;
	private JDBCParkDAO jdbcParkDao;
	@Autowired
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
		String sqlFindTopSurveyResults = "select count(parkcode) as votes, parkcode from survey_result group by parkcode order by parkcode limit 1";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindTopSurveyResults);
		if(results.next()) {
			theSurvey = mapRowToSurveyCount(results);
//			thePark = jdbcParkDao.getParkByParkCode(theSurvey.getParkCode());
		}
	return theSurvey;

	}

	@Override
	public void addSurvey(Survey theSurvey) {
		String sqlSurvey = "insert into survey_result (parkcode, emailaddress, state, activitylevel) " +
							"values (?,?,?,?)";
		jdbcTemplate.update(sqlSurvey, theSurvey.getParkCode(), theSurvey.getEmailAddress(), theSurvey.getState(), theSurvey.getActivityLevel());
		
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
	
	private Survey mapRowToSurveyCount(SqlRowSet results) {
		Survey theSurvey;
		theSurvey = new Survey();
		theSurvey.setParkCode(results.getString("parkcode"));
		theSurvey.setVotes(results.getInt("votes"));
		
		return theSurvey;
	}
}
package parks.jdbc;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import parks.model.Survey;
import parks.model.SurveyDAO;

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
		String sqlFindTopSurveyResults = "select * from survey_result order by parkcode";
		ArrayList<Survey> surveyResult = new ArrayList<Survey>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllSurveyResults);
		while(results.next()) {
			Survey survey = mapRowToSurvey(results);
			surveyResult.add(survey);
		}
	return surveyResult;

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
		
		return theSurvey;
	}

}

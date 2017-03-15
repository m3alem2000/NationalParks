package com.techelevator.npgeek.parks.jdbc;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.parks.model.Park;
import com.techelevator.npgeek.parks.model.ParkDAO;

@Component
public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public ArrayList<Park> getAllParks() {
		String sqlFindAllParks = "select * from park order by parkname";
		ArrayList<Park> parksList = new ArrayList<Park>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllParks);
		while(results.next()) {
			Park park = mapRowToParks(results);
			parksList.add(park);
		}
		return parksList;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		Park park = null;
		String sqlFindParkByParkCode = "select * from park where parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindParkByParkCode, parkCode);
		if(results.next()){
			park = mapRowToParks(results);
		}
		return park;
	}


	private Park mapRowToParks(SqlRowSet results) {
		Park thePark;
		thePark = new Park();
		thePark.setParkCode(results.getString("parkcode"));
		thePark.setParkName(results.getString("parkname"));
		thePark.setState(results.getString("state"));
		thePark.setAcreage(results.getInt("acreage"));
		thePark.setElevation(results.getInt("elevationinfeet"));
		thePark.setMileOfTrail(results.getFloat("milesoftrail"));
		thePark.setNumberOfCampSites(results.getInt("numberofcampsites"));
		thePark.setClimate(results.getString("climate"));
		thePark.setYearFounded(results.getInt("yearfounded"));
		thePark.setAnnualVisitors(results.getInt("annualvisitorcount"));
		thePark.setInspirationalQuote(results.getString("inspirationalquote"));
		thePark.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		thePark.setDescription(results.getString("parkdescription"));
		thePark.setEntryFee(results.getInt("entryfee"));
		thePark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));

		return thePark;
	}

}

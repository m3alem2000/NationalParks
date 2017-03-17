package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.parks.jdbc.JDBCWeatherDAO;
import com.techelevator.npgeek.parks.model.Weather;


public class JDBCWeatherDAOIntegrationTest extends DAOIntegrationTest {
	private JDBCWeatherDAO weatherDao;
	
	@Before
	public void setup() {
		weatherDao = new JDBCWeatherDAO(getDataSource());
	}
	
	@Test
	public void passingGNPToGetWeatherByParkCodeReturns5WeatherObjects() {
		List<Weather> testWeatherList = weatherDao.getWeatherByParkCode("GNP");
		
		Assert.assertEquals(5, testWeatherList.size());
	}
}

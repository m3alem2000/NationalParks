package com.techelevator.npgeek.parks.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.parks.model.Weather;
import com.techelevator.npgeek.parks.model.WeatherDAO;

public class JDBCWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getWeatherByParkCode(String parkCode) {

		String sqlFindWeatherByFiveDayForecast = "select * from weather where parkcode = ? order by fivedayforecastvalue";
		List<Weather> fiveDayWeather = new ArrayList<Weather>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindWeatherByFiveDayForecast, parkCode);
		while(results.next()) {
			Weather weatherForecast = mapRowToWeather(results);
			fiveDayWeather.add(weatherForecast);
		}
		return fiveDayWeather;
	}

	private Weather mapRowToWeather(SqlRowSet results) {
		Weather theWeather;
		theWeather = new Weather();
		theWeather.setParkCode(results.getString("parkcode"));
		theWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		theWeather.setLowF(results.getInt("low"));
		theWeather.setHighF(results.getInt("high"));
		theWeather.setLowC((results.getInt("low")-32)*5/9);
		theWeather.setHighC((results.getInt("high")-32)*5/9);
		theWeather.setForecast(results.getString("forecast"));
		return theWeather;
	}

}

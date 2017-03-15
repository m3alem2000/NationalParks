package parks.jdbc;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import parks.model.Park;
import parks.model.Weather;
import parks.model.WeatherDAO;

public class JDBCWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public ArrayList<Weather> getWeatherByParkCode() {

		String sqlFindWeatherByFiveDayForecast = "select * from weather order by fivedayforecastvalue";
		ArrayList<Weather> fiveDayWeather = new ArrayList<Weather>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindWeatherByFiveDayForecast);
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
		theWeather.setLow(results.getInt("low"));
		theWeather.setHigh(results.getInt("high"));
		theWeather.setForecast(results.getString("forecast"));

		return theWeather;
	}

}

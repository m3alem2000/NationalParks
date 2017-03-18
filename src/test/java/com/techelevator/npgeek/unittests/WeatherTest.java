package com.techelevator.npgeek.unittests;

import org.junit.Test;

import com.techelevator.npgeek.parks.model.Weather;

public class WeatherTest {
	
	@Test
	public void weatherObjectInitializesCorrectly() {
		Weather testWeather = new Weather();
		testWeather.setParkCode("GNP");
		testWeather.setFiveDayForecastValue(1);
		testWeather.setLowF(27);
		testWeather.setHighF(40);
		testWeather.setLowC(lowC);
		testWeather.setHighC(highC);
		testWeather.setForecast(forecast);
		
	}

}

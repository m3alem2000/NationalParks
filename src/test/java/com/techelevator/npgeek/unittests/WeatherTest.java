package com.techelevator.npgeek.unittests;

import org.junit.Assert;
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
		// TODO: didn't set highC, lowC because logic currently in DAO, probably should be moved to model
		testWeather.setForecast("cloudy");
		
		Assert.assertEquals("GNP", testWeather.getParkCode());
		Assert.assertEquals(1, testWeather.getFiveDayForecastValue());
		Assert.assertEquals(27, testWeather.getLowF());
		Assert.assertEquals(40, testWeather.getHighF());
		Assert.assertEquals("cloudy", testWeather.getForecast());
	}
	
	@Test
	public void givenForecastEqualsPartlyCloudyGetForecastPngStringReturnsCorrectString() {
		Weather testWeather = new Weather();
		testWeather.setForecast("partly cloudy");
		
		Assert.assertEquals("partlyCloudy", testWeather.getForecastPngString());
	}
	
	@Test
	public void givenForecastEqualsSnowIsExtremeWeatherReturnsTrue() {
		Weather testWeather = new Weather();
		testWeather.setForecast("snow");
		
		Assert.assertTrue(testWeather.isExtremeWeather());
	}
	
	@Test
	public void givenForecastEqualsCloudyIsExtremeWeatherReturnsFalse() {
		Weather testWeather = new Weather();
		testWeather.setForecast("cloudy");
		
		Assert.assertFalse(testWeather.isExtremeWeather());
	}
	
	@Test
	public void givenForecastEqualsSnowGetExtremeWeatherAdvisoryReturnsCorrectString() {
		Weather testWeather = new Weather();
		testWeather.setForecast("snow");
		
		Assert.assertEquals("Be sure to pack snowshoes!", testWeather.getExtremeWeatherAdvisory());
	}
	
	@Test
	public void givenForecastEqualsRainGetExtremeWeatherAdvisoryReturnsCorrectString() {
		Weather testWeather = new Weather();
		testWeather.setForecast("rain");
		
		Assert.assertEquals("Be sure to pack rain gear and wear waterproof shoes!", testWeather.getExtremeWeatherAdvisory());
	}
	
	@Test
	public void givenHighF60AndLowF39IsTempDiffGreaterThan20FahrReturnsTrue() {
		Weather testWeather = new Weather();
		testWeather.setHighF(60);
		testWeather.setLowF(39);
		
		Assert.assertTrue(testWeather.isTempDiffGreaterThan20Fahr());
	}
	
	@Test
	public void givenHighF60AndLowF50IsTempDiffGreaterThan20FahrReturnsFalse() {
		Weather testWeather = new Weather();
		testWeather.setHighF(60);
		testWeather.setLowF(50);
		
		Assert.assertFalse(testWeather.isTempDiffGreaterThan20Fahr());
	}
	
	@Test
	public void givenLowF19HighF25IsTempBelow20FahrReturnsTrue() {
		Weather testWeather = new Weather();
		testWeather.setHighF(25);
		testWeather.setLowF(19);
		
		Assert.assertTrue(testWeather.isTempBelow20Fahr());
	}
	
	@Test
	public void givenHighF19LowF19IsTempBelow20FahrReturnsTrue() {
		Weather testWeather = new Weather();
		testWeather.setHighF(19);
		testWeather.setLowF(19);
		
		Assert.assertTrue(testWeather.isTempBelow20Fahr());
	}
	
	@Test
	public void givenHighF60LowF21IsTempBelow20FahrReturnsFalse() {
		Weather testWeather = new Weather();
		testWeather.setHighF(60);
		testWeather.setLowF(21);
		
		Assert.assertFalse(testWeather.isTempBelow20Fahr());
	}
	

}

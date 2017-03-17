package com.techelevator.npgeek.parks.model;

public class Weather {
	private String parkCode;
	private int fiveDayForecastValue;
	private int lowF;
	private int highF;
	private int lowC;
	private int highC;
	private String forecast;

	public int getLowC() {
		return lowC;
	}
	public void setLowC(int lowC) {
		this.lowC = lowC;
	}
	public int getHighC() {
		return highC;
	}
	public void setHighC(int highC) {
		this.highC = highC;
	}

	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLowF() {
		return lowF;
	}
	public void setLowF(int lowF) {
		this.lowF = lowF;
	}
	public int getHighF() {
		return highF;
	}
	public void setHighF(int highF) {
		this.highF = highF;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	public String getForecastPngString() {
		if (forecast.equals("partly cloudy")) {
			return "partlyCloudy";
		} else {
			return forecast;
		}
	}
		
	public boolean isExtremeWeather() {
		return (forecast.equals("snow") || 
				forecast.equals("sunny") || 
				forecast.equals("thunderstorms") || 
				forecast.equals("rain"));
	}
	
	public String getExtremeWeatherAdvisory() {
		if (forecast.equals("snow")) {
			return "Be sure to pack snowshoes!";
		} else if (forecast.equals("sunny")) {
			return "Be sure to pack sunblock!";
		} else if (forecast.equals("thunderstorms")) {
			return "Seek shelter, and avoid hiking on exposed ridges!";
		} else {
			return "Be sure to pack rain gear and wear waterproof shoes!";
		}
	}
	
	public boolean isTempDiffGreaterThan20Fahr() {
		return highF - lowF > 20;
	}
	
	public String getTempDiffAdvisory() {
		return "Be sure to wear breathable layers!";
	}
	
	public boolean isTempBelow20Fahr() {
		return highF < 20 || lowF < 20;
	}
	
	public String getTempBelow20FahrAdvisory() {
		return "Beware of exposure to frigid temperatures!";
	}
	
}

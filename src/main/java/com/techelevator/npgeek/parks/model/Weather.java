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

}

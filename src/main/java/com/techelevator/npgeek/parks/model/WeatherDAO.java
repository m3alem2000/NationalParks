package com.techelevator.npgeek.parks.model;

import java.util.ArrayList;

public interface WeatherDAO {

	public ArrayList<Weather> getWeatherByParkCode();
}

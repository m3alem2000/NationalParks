package com.techelevator.npgeek.parks.model;

import java.util.ArrayList;
import java.util.List;

public interface WeatherDAO {

	public List<Weather> getWeatherByParkCode(String parkCode);
}

package com.techelevator.npgeek.parks.model;

import java.util.ArrayList;
import java.util.List;

public interface ParkDAO {
	
	public List<Park> getAllParks();
	public Park getParkByParkCode(String parkCode);
}

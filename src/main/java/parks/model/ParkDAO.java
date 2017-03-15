package parks.model;

import java.util.ArrayList;

public interface ParkDAO {
	
	public ArrayList<Park> getAllParks();
	public Park getParkByParkCode(String parkCode);
}

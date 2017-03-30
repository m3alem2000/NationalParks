package com.techelevator.npgeek.integrationtests;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.npgeek.parks.jdbc.JDBCParkDAO;
import com.techelevator.npgeek.parks.model.Park;

public class JDBCParkDAOIntegrationTest extends DAOIntegrationTest{
	
	@Autowired
	private JDBCParkDAO parkDao;
	
	@Before
	public void setup() {
		parkDao = new JDBCParkDAO(getDataSource());
	}
	
	@Test
	public void getAllParksReturnsListGreaterThanZero() {
		List<Park> testList = parkDao.getAllParks();
		
		Assert.assertNotEquals(0, testList.size());
	}
	
	@Test
	public void getParkByParkCodeReturnsNullWhenPassedInvalidParkCode() {
		Park testPark = parkDao.getParkByParkCode("Not a park code");
		
		Assert.assertNull(testPark);
	}
	
	@Test
	public void passingGNPToGetParkByParkCodeReturnsCorrectParkInfo() {
		Park testPark = parkDao.getParkByParkCode("GNP");
		
		Assert.assertEquals("Glacier National Park", testPark.getParkName());
		Assert.assertEquals("Montana", testPark.getState());
		Assert.assertEquals(1013322, testPark.getAcreage());
		Assert.assertEquals(6646, testPark.getElevation());
		Assert.assertEquals(745.6, testPark.getMileOfTrail(), 0.009);
		Assert.assertEquals(923, testPark.getNumberOfCampSites());
		Assert.assertEquals("Temperate", testPark.getClimate());
		Assert.assertEquals(1910, testPark.getYearFounded());
		Assert.assertEquals(2338528, testPark.getAnnualVisitors());
		Assert.assertEquals("Far away in northwestern Montana, hidden from view by clustering mountain peaks, lies an unmapped corner—the Crown of the Continent.", testPark.getInspirationalQuote());
		Assert.assertEquals("George Bird Grinnell", testPark.getInspirationalQuoteSource());
		Assert.assertEquals("Glacier might very well be the most beautiful of America\'s national parks. John Muir called it \"the best care-killing scenery on the continent.\" The mountains are steep, snowcapped, and punctuated by stunning mountain lakes and creeks. Much of the land remains wild and pristine, a result of its remote location and the lack of visitation in the 19th century.  ", testPark.getDescription());
		Assert.assertEquals(12, testPark.getEntryFee());
		Assert.assertEquals(300, testPark.getNumberOfAnimalSpecies());
	}

}

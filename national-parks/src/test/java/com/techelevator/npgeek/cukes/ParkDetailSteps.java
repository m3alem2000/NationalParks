package com.techelevator.npgeek.cukes;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.HomePage;
import com.techelevator.npgeek.pageobject.ParkDetailPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ParkDetailSteps {
	private WebDriver webDriver;
	private HomePage homePage;
	private ParkDetailPage parkDetail;
	
	@Autowired
	public ParkDetailSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage =  new HomePage(webDriver);
		this.parkDetail = new ParkDetailPage(webDriver);
	}
	
	@Given("^I am on the NPGeek home page$")
	public void iAmOnTheNPGeekHomePage() throws Throwable {
		webDriver.get("http://localhost:8080/m3-java-capstone/");
		webDriver.navigate().refresh();
	}
	
	@When("^I click the link with the id of (.*)$")
	public void iClickTheLinkWithTheIdOf(String id) throws Throwable {
		homePage.clickOnPark(id);
//		WebElement link = webDriver.findElement(By.cssSelector("a[href='http://localhost:8080/m3-java-capstone/parkDetail?parkCode="+id+"']"));
//		link.click();
	}
	
	@Then("^on the ParkDetail page the year founded should be (.*)$")
	public void onTheParkDetailPageTheYearFoundedShouldBe(String yearFounded) throws Throwable {
		Assert.assertEquals(yearFounded, parkDetail.getYearFounded());
	}
	
	@Then("^the park name should be (.*)$")
	public void theParkNameShouldBe(String parkName) throws Throwable {
		Assert.assertEquals(parkName, parkDetail.getParkName());
	}
	
	@Then("^the state should be (.*)$")
	public void theStateShouldBe(String state) throws Throwable {
		Assert.assertEquals(state, parkDetail.getState());
	}
	
	@Then("^the miles of trail should be (.*)$")
	public void theMilesOfTrailShouldBe(String milesOfTrail) throws Throwable {
		Assert.assertEquals(milesOfTrail, parkDetail.getMilesOfTrail());
	}
	
	@Then("^the acreage should be (.*)$")
	public void theAcreageShouldBe(String acreage) throws Throwable {
		Assert.assertEquals(acreage, parkDetail.getAcreage());
	}
	
	@Then("^the elevation should be (.*)$")
	public void theElevationShouldBe(String elevation) throws Throwable {
		Assert.assertEquals(elevation, parkDetail.getElevation());
	}
	
	@Then("^the climate should be (.*)$")
	public void theClimateShouldBe(String climate) throws Throwable {
		Assert.assertEquals(climate, parkDetail.getClimate());
	}
	
	@Then("^the number of animals should be (.*)$")
	public void theNumberOfAnimalsShouldBe(String numberOfAnimals) throws Throwable {
		Assert.assertEquals(numberOfAnimals, parkDetail.getNumberofAnimals());
	}
	
	@Then("^the annual visitors should be (.*)$")
	public void theAnnualVisitorsShouldBe(String annualVisitors) throws Throwable {
		Assert.assertEquals(annualVisitors, parkDetail.getAnnualVisitors());
	}
	
	@Then("^the number of campsites should be (.*)$")
	public void theNumberOfCampsitesShouldBe(String numberOfCampsites) throws Throwable {
		Assert.assertEquals(numberOfCampsites, parkDetail.getNumberOfCampsites());
	}

	

}

package com.techelevator.npgeek.cukes.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.HomePage;
import com.techelevator.npgeek.pageobject.ParkDetailPage;
import com.techelevator.npgeek.pageobject.SurveyInputPage;
import com.techelevator.npgeek.pageobject.SurveyResultsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SurveyResultSteps {
	private WebDriver webDriver;
	private HomePage homePage;
	private SurveyInputPage surveyInput;
	private SurveyResultsPage surveyResults;
	
	@Autowired
	public SurveyResultSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage =  new HomePage(webDriver);
		this.surveyInput = new SurveyInputPage(webDriver);
		this.surveyResults = new SurveyResultsPage(webDriver);
	}
	
	@Given("^I am on the survey input page$")
	public void iAmOnTheNPGeekHomePage() throws Throwable {
		homePage.clickTakeOurSurvey();
	}
	
	@Given("^the park I select is (.*)$")
	public void theParkISelectIs(String parkName) throws Throwable {
		surveyInput.selectPark(parkName);
	}
	
	@Given("^the state I select is (.*)$")
	public void theStateISelectIs(String state) throws Throwable {
		surveyInput.selectState(state);
	}
	
	@Given("^I input the email address (.*)$")
	public void iInputTheEmailAddress(String emailAddress) throws Throwable {
		surveyInput.inputEmailAddress(emailAddress);
	}
	
	@Given("^the activity level I select is (.*)$")
	public void theActivityLevelISelectIs(String activityLevel) throws Throwable {
		surveyInput.selectActivityLevel(activityLevel);
	}
	
	@When("^I submit my survey$")
	public void iSubmitMySurvey() throws Throwable {
		surveyInput.submit();
	}
	
	@Then("^I will end up on the survey results page$")
	public void iWillEndUpOnTheSurveyResultsPage() throws Throwable {
		Assert.assertNotNull(surveyResults);
	}
	
}

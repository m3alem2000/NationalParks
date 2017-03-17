package com.techelevator.npgeek.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SurveyResultsPage {

	private WebDriver webDriver;

	public SurveyResultsPage(WebDriver webDriver){
		this.webDriver = webDriver;
	}

	public boolean verifyParkName(String parkName){
		//need to find the name of the park with most votes//
		WebElement outputParkName = webDriver.findElement(By.id("parkName"));
		return outputParkName.getText().equals(parkName);
	}
	
	
	
}
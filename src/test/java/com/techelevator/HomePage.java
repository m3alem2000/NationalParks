package com.techelevator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.techelevator.npgeek.pageobject.ParkDetailPage;
import com.techelevator.npgeek.pageobject.SurveyInputPage;

public class HomePage {
	private WebDriver webDriver;
	
	public HomePage(WebDriver webDriver){
		this.webDriver = webDriver;
	}
	

	public SurveyInputPage clickTakeOurSurvey(){
		WebElement link = webDriver.findElement(By.id("survey-link-text"));
		link.click();
		return new SurveyInputPage(webDriver);
		}
	
	public ParkDetailPage clickOnPark(String parkCode){
		webDriver.navigate().refresh();
		WebElement link = webDriver.findElement(By.id(parkCode));
		link.click();
		return new ParkDetailPage(webDriver);
		}
	
	public ParkDetailPage checkParksOnHomePage(String parkCode){
		webDriver.navigate().refresh();
		return new ParkDetailPage(webDriver);
	}
}


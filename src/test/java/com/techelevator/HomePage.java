package com.techelevator;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}


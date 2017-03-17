package com.techelevator.npgeek.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SurveyInputPage {
	private WebDriver webDriver;

	public SurveyInputPage(WebDriver webDriver){
	this.webDriver = webDriver;
}

	public void selectPark(String parkName){
		WebElement selectElement = webDriver.findElement(By.id("parkName"));
		Select select = new Select(selectElement);
		select.selectByVisibleText(parkName);
	}
	
	public void selectState(String state){
		WebElement selectElement = webDriver.findElement(By.id("state"));
		Select select = new Select(selectElement);
		select.selectByVisibleText(state);
	}
	
	public void inputEmailAddress(String emailAddress){
		WebElement emailAddressInput = webDriver.findElement(By.name("emailAddress")); 
		emailAddressInput.sendKeys(emailAddress);
	}
	
	public void selectActivityLevel(String activityLevel){
		WebElement selectElement = webDriver.findElement(By.id("activityLevel"));
		Select select = new Select(selectElement);
		select.selectByVisibleText(activityLevel);
	}
	
	public SurveyResultsPage submit(){
		WebElement submitButton = webDriver.findElement(By.id("formSubmitButton"));
				submitButton.submit();
		return new SurveyResultsPage(webDriver);
	}
}
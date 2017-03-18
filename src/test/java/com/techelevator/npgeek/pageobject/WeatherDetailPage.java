package com.techelevator.npgeek.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeatherDetailPage {

	private WebDriver webDriver;

	public WeatherDetailPage(WebDriver webDriver){
		this.webDriver = webDriver;
	}
	
	public boolean getWeatherDetail(String parkName){//need to find id
		WebElement outputWeatherDetail = webDriver.findElement(By.id(""));
		return outputWeatherDetail.isDisplayed(); 
	}
	
}

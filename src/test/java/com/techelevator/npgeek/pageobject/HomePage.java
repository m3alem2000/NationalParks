package com.techelevator.npgeek.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver webDriver;
	
	public HomePage(WebDriver webDriver){
		this.webDriver = webDriver;
	}
	
	public StoreDetailInputPage selectPark(String parkCode){
		WebElement link1 = webDriver.findElement(ById.id(parkCode));
		link1.click();
		return new StoreDetailInputPage(webDriver);
	}
//	
//	public StoreDetailInputPage clickSecondProductQuantity(){
//		WebElement link = webDriver.findElement(By.linkText("Space Store"));
//		link.click();
//		WebElement link1 = webDriver.findElement(ById.id("img2"));
//		link1.click();
//		return new StoreDetailInputPage(webDriver);
//	}

	public SurveyInputPage clickTakeOurSurvey(){
		WebElement link = webDriver.findElement(By.linkText("Take Our Survey!"));
		link.click();
		return new SurveyInputPage(webDriver);
	}
}

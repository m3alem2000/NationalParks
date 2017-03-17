
package com.techelevator.npgeek.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ParkDetailPage {


	private WebDriver webDriver;

	public ParkDetailPage(WebDriver webDriver){
	this.webDriver = webDriver;
}
	
	public String getYearFounded(){
		WebElement outputParkName= webDriver.findElement(By.id("year-founded"));
		return outputParkName.getText();
	}
	
	public String getParkName(){
		WebElement outputParkName= webDriver.findElement(By.id("park-name"));
		return outputParkName.getText();
	}

	public String getState(){
		WebElement outputParkName= webDriver.findElement(By.id("state"));
		return outputParkName.getText();
	}
	
	public String getMilesOfTrail(){
		WebElement outputParkName= webDriver.findElement(By.id("mile-of-trail"));
		return outputParkName.getText();
	}
	
	public String getAcreage(){
		WebElement outputParkName= webDriver.findElement(By.id("acreage"));
		return outputParkName.getText();
	}
	
	public String getElevation(){
		WebElement outputParkName= webDriver.findElement(By.id("elevation"));
		return outputParkName.getText();
	}
	
	public String getClimate(){
		WebElement outputParkName= webDriver.findElement(By.id("climate"));
		return outputParkName.getText();
	}
	
	public String getNumberofAnimals(){
		WebElement outputParkName= webDriver.findElement(By.id("number-of-animals"));
		return outputParkName.getText();
	}
	
	public String getAnnualVisitors(){
		WebElement outputParkName= webDriver.findElement(By.id("annual-visitors"));
		return outputParkName.getText();
	}
	
	public  String getNumberOfCampsites(){
		WebElement outputParkName= webDriver.findElement(By.id("number-of-campsites"));
		return outputParkName.getText();
	}
	
}

package com.techelevator;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver webDriver;
	
	public HomePage(WebDriver webDriver){
		this.webDriver = webDriver;
	}
	
	public void selectSpaceStoreLink(){
		WebElement link = webDriver.findElement(By.linkText("Space Store"));
		link.click();
	}
	public StoreDetailInputPage selectProduct(String product){
		WebElement link1 = webDriver.findElement(ById.id(product));
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

	public SpaceForumInputPage clickSpaceForum(){
		WebElement link = webDriver.findElement(By.linkText("Space Forum"));
		link.click();
		WebElement link1 = webDriver.findElement(By.linkText("Post a Message"));
		link1.click();
		return new SpaceForumInputPage(webDriver);
	}
}


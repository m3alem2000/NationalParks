package com.techelevator.ssg;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.techelevator.ssg.pageobject.AgeCalculatorInputPage;
import com.techelevator.ssg.pageobject.AgeCalculatorResultsPage;
import com.techelevator.ssg.pageobject.DriveTimeCalculatorInputPage;
import com.techelevator.ssg.pageobject.DriveTimeCalculatorResultsPage;
import com.techelevator.ssg.pageobject.HomePage;
import com.techelevator.ssg.pageobject.SpaceForumInputPage;
import com.techelevator.ssg.pageobject.SpaceForumResultsPage;
import com.techelevator.ssg.pageobject.StoreDetailInputPage;
import com.techelevator.ssg.pageobject.StoreDetailResultsPage;
import com.techelevator.ssg.pageobject.WeightCalculatorInputPage;
import com.techelevator.ssg.pageobject.WeightCalculatorResultsPage;

public class HomePageTest {
	
		private static WebDriver webDriver;
		private HomePage homePage;
		
		@BeforeClass
		public static void createWebDriver(){
			String homeDir = System.getProperty("user.home");
			System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
			webDriver = new ChromeDriver();
		}
		
		@Before
		public void goHome(){
			webDriver.get("http://localhost:8080/team6-m3-capstone/");
			homePage = new HomePage(webDriver);
		}
		
		@AfterClass
		public static void closeWebDriver(){
			webDriver.close();
		}

		@Test
		public void set_Weight_Calculator(){
			WeightCalculatorInputPage weightInput = homePage.clickWeightCalculatorLink();
			weightInput.selectPlanet("Mercury");
			weightInput.inputWeight("100");
			WeightCalculatorResultsPage result = weightInput.submit();
			Assert.assertTrue(result.verifyWeight("37"));
		}
		
		@Test
		public void set_Age_Calculator(){
			AgeCalculatorInputPage ageInput = homePage.clickAgeCalculatorLink();
			ageInput.selectPlanet("Jupiter");
			ageInput.inputAge("30");
			AgeCalculatorResultsPage result = ageInput.submit();
			Assert.assertTrue(result.verifyAge("923"));
		}
		
		@Test
		public void set_Drive_Time_Calculator(){
			DriveTimeCalculatorInputPage driveTimeInput = homePage.clickDriveTimeCalculatorLink();
			driveTimeInput.selectPlanet("Jupiter");
			driveTimeInput.inputTransMode("Car");
			driveTimeInput.inputAge("30");
			DriveTimeCalculatorResultsPage result = driveTimeInput.submit();
			Assert.assertTrue(result.verifyAge("475.0"));
		}
		
		@Test
		public void set_ProductDetailPage_Id(){
			
//			StoreDetailInputPage firstProduct = homePage.selectProduct("img1");
			homePage.selectSpaceStoreLink();
			
			StoreDetailInputPage firstProduct = homePage.selectProduct("img1");
			firstProduct.inputQuantity("2");
			StoreDetailResultsPage result1 = firstProduct.submit();
			
			homePage.selectSpaceStoreLink();
			StoreDetailInputPage secondProduct = homePage.selectProduct("img2");
			secondProduct.inputQuantity("2");
			secondProduct.submit();
			
			Assert.assertTrue(result1.verifyQuantity("2"));
			Assert.assertTrue(result1.verifyPrice("$9.99"));
			Assert.assertTrue(result1.verifySubtotal("$19.98"));
			Assert.assertTrue(result1.verifyTotal("$79.88"));
		}
		
		@Test
		public void set_Form_Message(){
			SpaceForumInputPage SpaceForumInput = homePage.clickSpaceForum();
			SpaceForumInput.inputUsername("Mohammad");
			SpaceForumInput.inputSubject("Test");
			SpaceForumInput.inputMessage("This is a test");
			
			SpaceForumResultsPage result = SpaceForumInput.submit();
//			Assert.assertTrue(result.verifyUserName("Mohammad"));
//			Assert.assertTrue(result.verifySubject("Test"));
//			webDriver.getPageSource().contains("Mohammad");
//			Assert.assertTrue(result.verifyMessage("This is a test"));
			Assert.assertTrue(webDriver.getPageSource().contains("Mohammad"));
			Assert.assertTrue(webDriver.getPageSource().contains("Test"));
			Assert.assertTrue(webDriver.getPageSource().contains("This is a test"));
		}
}

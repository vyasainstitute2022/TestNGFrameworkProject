package com.vyasa.testng.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

	public static WebDriver driver;
	
	@BeforeMethod
	public void browserSetup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProgramming\\TestNgFramework\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	
	
	@Test(dataProvider="login-data")
	public void loginFlipkart(String tcDescp,String userName,String Pass) {
		
		//Operation with data received 
		driver.findElement(By.xpath("//form/div[1]/input[@type='text']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Pass);
		driver.findElement(By.xpath("//button/span")).click();
		
		//validation
		if(tcDescp.equalsIgnoreCase("successLogon")){
			boolean isDis=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/a/div[2]")).isDisplayed();
			Assert.assertTrue(isDis);
		}else if(tcDescp.equalsIgnoreCase("blankpass"))
		{
			String actualError=driver.findElement(By.xpath("//span[contains(text(),\"Please enter Password\")]")).getText();
			Assert.assertEquals(actualError, "Please enter Password");			
		}else if(tcDescp.equalsIgnoreCase("blankuser"))
		{
			String actualError=driver.findElement(By.xpath("//span[contains(text(),'Please enter valid Email ID/Mobile number')]")).getText();
			Assert.assertEquals(actualError, "Please enter valid Email ID/Mobile number");	
		}
		
	/*	driver.findElement(By.xpath("//form/div[1]/input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).clear();*/
	}
	
	@DataProvider(name="login-data")
	public Object[][] loginData()
	{
		return new Object[][]{
			{"blankpass","8660242427",""},
			{"blankuser","","Pass@12345"},
			{"successLogon","8660242427","Pass@12345"}
		};
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}

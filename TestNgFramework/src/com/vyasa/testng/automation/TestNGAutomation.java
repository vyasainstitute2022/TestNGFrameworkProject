package com.vyasa.testng.automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGAutomation {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void browserSetup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\JavaProgramming\\TestNgFramework\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
		String expectedTitle="Automation Practice Site";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=2,groups= {"sanity"})
	public void verifyNewArrivalsDisplayed()
	{
		boolean actualValue=driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-1-1-0\"]/h2")).isDisplayed();
		Assert.assertTrue(actualValue);
		System.out.println("sanity executed");
	}
	
	@Test(priority=3,groups={"sanity","Regression"})
	public void verifySliderHasThreeBooks()
	{
		int sliderSize=driver.findElements(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div/div/img")).size();
		Assert.assertEquals(sliderSize, 3);
	}
		

	@Test(priority=4)
	public void verifyNewArrivalHasThreeBooks()
	{
		int bookSize=driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div")).size();
		Assert.assertEquals(bookSize, 3);
	}
		
	@Test(priority=5,groups="Regression")
	public void verifyTitleOfNewArrivalBooks()
	{
		List<WebElement> bookElements=driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]//following::h3"));
		
		ArrayList<String>	titleList=new ArrayList<>();
		
			for(WebElement ele:bookElements)
			{
				titleList.add(ele.getText());
			}
		Assert.assertEquals(titleList.contains("Selenium Ruby"),true);
		Assert.assertEquals(titleList.contains("Thinking in HTML"),true);
		Assert.assertEquals(titleList.contains("Mastering JavaScript"),true);
	}
	
	
	@AfterClass
	public void browserClose()
	{
		driver.quit();
	}
	
}

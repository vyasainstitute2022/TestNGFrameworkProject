package com.vyasa.testng.dataprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.microsoft.edge.seleniumtools.EdgeDriver;

public class CrossBrowserTesting {
	
public WebDriver driver;
		
	  @Parameters("browser")//edge
	  @BeforeClass
	  public void browserLaunch(String browser) {//edge

		  if(browser.equalsIgnoreCase("firefox")) 
		  {
			  System.setProperty("webdriver.gecko.driver", "D:\\JavaProgramming\\TestNgFramework\\drivers\\geckodriver.exe");
			  driver = new FirefoxDriver();	 
			  System.out.println("firefox opened succesfully");
		  }
		   else if (browser.equalsIgnoreCase("chrome"))
		      { 
			  System.setProperty("webdriver.chrome.driver", "D:\\JavaProgramming\\TestNgFramework\\drivers\\chromedriver.exe");
			  driver = new ChromeDriver();
			  System.out.println("chrome opened succesfully");
		      }
		   else if(browser.equalsIgnoreCase("edge")) 
		     {
			   System.setProperty("webdriver.edge.driver", "");
			   driver = new EdgeDriver();
			   System.out.println("edge opened succesfully");
		     }
		  
		  driver.get("https://facebook.com"); 
		  driver.manage().window().maximize();
		  
      }
	 
	 @Parameters({"username","password"})
	 @Test 
	  public void verifyUserLogon(String username,String password)
	  {
		System.out.println(username);	  
		System.out.println(password);	
		//logon
		//verfiy success
	   }
	  
	   
	  @AfterClass
	  public void closeBrowser()
	  {
		  driver.quit();
	  }
	  

}

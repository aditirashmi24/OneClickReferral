package com.ocr.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public static WebDriver driver; 
	public static Properties prop;

	//CREATE TESTBASE METHOD WHERE SET THE PROPERTIES
	public TestBase(){

		try{
			prop = new Properties(); 
			FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"//properties");
			prop.load(inputStream); 
		}
		catch(FileNotFoundException e){
			e.printStackTrace();	
		}
		catch(IOException e){

			e.printStackTrace();
		}
	}


	//CREATE INITIALIZATION METHOD WHERE INITIALIZE THE BROWSER DRIVER 

	public static void initialization() throws InterruptedException{


		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//chromedriver.exe");
		driver = new ChromeDriver();	 
		System.out.println("--***CHROME-BROWSER***--");
		//Maximize
		driver.manage().window().maximize();

		//Delete all cookies 
		driver.manage().deleteAllCookies();

		//PageTimeouts 
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); 

		//Launch url 
		driver.get(prop.getProperty("url"));
        Thread.sleep(7000);   
		
	}
	
	
	public static void closeBrowser() {
		
		driver.quit();
		
		
	}  




}








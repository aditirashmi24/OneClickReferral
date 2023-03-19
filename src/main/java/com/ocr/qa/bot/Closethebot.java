package com.ocr.qa.bot;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;

public class Closethebot extends TestBase {

	public void Closing_the_bot() throws InterruptedException {
		
		
		try {
		WebDriverWait wait1 = new WebDriverWait(driver,60);
	    System.out.println("Waiting for frame");
	    wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@style,'border') and contains(@class,'drift-widget-slider')]")));
	    System.out.println("Frame Found and Switched"); 
	    Actions act = new Actions(driver); 
	    act.moveToElement(driver.findElement(By.xpath("//button[@id='widgetButton']"))).perform();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@id='widgetButton']")).click();
	    System.out.println("Open Chat Box"); 
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"widgetCloseButton\"]")).click();
	    System.out.println("Closing the bot");
		}    
		
	
		catch(Exception ex) {
			
			System.out.println("Exception"+ex);
		}  
		
		finally {
	    driver.switchTo().parentFrame();
		}
		
	
	}
	
	
	
}

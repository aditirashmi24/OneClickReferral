package com.ocr.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.base.TestBase;
import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Dashboardpage;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.Patientspage;
import com.ocr.qa.pages.SelectWhoAreYou;

import junit.framework.Assert;

public class DashboardpageTest extends TestBase { 
    Loginpage loginpage;
    Dashboardpage dashb;
    SelectWhoAreYou Swatpage;
    Closethebot bot;
    String usernam = prop.getProperty("username");
	//Create Constructor 
	
	public DashboardpageTest(){
		
		 super();
	}
	
	@BeforeMethod
	public void DashboardPage_SetupMethod() throws InterruptedException{
		
		
		initialization();
	    
		
		Swatpage= new SelectWhoAreYou();
		loginpage = new Loginpage();
		//CLOSE THE CHAT BOT 
		bot= new Closethebot();
	    bot.Closing_the_bot();
	    Thread.sleep(3000);
		loginpage =	Swatpage.loginbtn();
		Thread.sleep(15000);
	    //CLOSE THE BOT 
	    bot.Closing_the_bot();
	    dashb= new Dashboardpage() ;
		dashb = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	
		try{
		    WebDriverWait wait=new WebDriverWait(driver, 30);

		       wait.until(ExpectedConditions.visibilityOfElementLocated(
		          
		    		By.cssSelector("#top-section > div > div > div.col-sm-4.logo-sec > li > a > img"))   
		       ).click();

		    }
		    catch(Throwable t){
		        System.out.println("The execption is: " + t);
		    }
		    finally {
		        System.out.println("If no exception tell me now");
		    }
		
	
	    Thread.sleep(6000);
	}

    @AfterMethod 
    public void TestCase_QuitMethod(){
    	
    	driver.quit();
    	
    	
    }
	
	// TEST CASES
	
			
	@Test(priority=1)
	public void OCRImageLogoAppearsOnTheHeader_OfDashboardPage(){
		
	    boolean img =dashb.validatepagelogo();
		Assert.assertTrue("PAGE LOGO NOT APPEARING ON THE PAGE", img);
		
	}
	
	@Test(priority=2)
	public void UsernameAppearsOnTheHeader_OfDashboardPage(){
		
		String label = driver.findElement(By.xpath("//span[contains(text(),'"+usernam+"')]//parent::a[@class='dropdown-toggle']")).getText();
		//boolean label = dashb.validateusername();
	    //  Assert.assertTrue("USERNAME NOT APPEARING ON THE DASHBOARD PAGE", label);
		Assert.assertEquals("USERNAME NOT APPEARING ON THE DASHBOARD PAGE",usernam, label);
	} 
	
	@Test(priority=3)
    public void CorrectPatientsTabNameAppearsOnTheHeader_OfDashboardPage() { 
   	
   	     Assert.assertTrue("PATIENTS LEVEL NOT APPEARING OR MISAMATCHING ON DASHBOARD PAGE",dashb.verifypatientsLabel());
   	
    }  
	
	@Test(priority=4)
    public void CorrectReferralsTabNameAppearsOnTheHeader_OfDashboardPage() { 
   	
   	     Assert.assertTrue("REFERRALS LEVEL NOT APPEARING OR MISAMATCHING ON DASHBOARD PAGE",dashb.verifyreferralsLabel());
   	
    }  
	
	@Test(priority=5)
    public void CorrectColleaguesTabNameAppearsOnTheHeader_OfDashboardPage() { 
   	
   	     Assert.assertTrue("COLLEAGUES LEVEL NOT APPEARING OR MISAMATCHING ON DASHBOARD PAGE",dashb.verifycolleaguesLabel());
   	
    }  
	
	
	
	
}

package com.ocr.qa.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.base.TestBase;
import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Dashboardpage;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.ReferalFormPage;
import com.ocr.qa.pages.Referralspage;
import com.ocr.qa.pages.SecuritySettingsPage;
import com.ocr.qa.pages.SelectWhoAreYou;
import com.ocr.qa.pages.SendReferralpage;
import com.ocr.qa.pages.TeamMembersPage;

import junit.framework.Assert;

public class ReferalFormPageTest extends TestBase {
    
	ReferalFormPage referalformpage;
	SecuritySettingsPage securitysettingspage;
	
	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Referralspage refpage;
	SendReferralpage sendreff;
	Closethebot bot;
	
	//CREATE A CONSTRUCTOR
	public ReferalFormPageTest(){
			
		super();
			
	} 
	
	
	//ALL TEST CASES SEPREATED AND INDEPENDENT EACH OTHER 
    //BEFORE METHOD
	@BeforeMethod
	public void ReferalFormPage_SetupMethod() throws InterruptedException{
		
	        	initialization();
	        	Thread.sleep(2000);  
	        	securitysettingspage = new SecuritySettingsPage();
	        	referalformpage = new ReferalFormPage();
	        	refpage = new Referralspage(); 
	        	sendreff = new SendReferralpage();
	        	Swatpage= new SelectWhoAreYou();
	    		loginpage = new Loginpage();
	    		loginpage =	Swatpage.loginbtn();
	    		
	    		Thread.sleep(15000);
	    	    //CLOSE THE BOT 
	    		bot= new Closethebot();
	    	    bot.Closing_the_bot();
	    	    dashb= new Dashboardpage() ;
				dashb = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
				Thread.sleep(17000);
				//CLOSE THE CHAT BOT 
			    bot.Closing_the_bot(); 
			    Thread.sleep(1000);
		 		securitysettingspage = dashb.clickonsettingbtn();
		 		Thread.sleep(5000);
				referalformpage = dashb.clickonsettingandReferalFormbtn();
				Thread.sleep(7000);
				
	    }
	  
	  /*
	 //AFTER METHOD 
		@AfterMethod
		public void TestCase_Quit(){
				
			driver.quit();
		}
	
	
     //--------------TEST CASE---------------------------
	    
      @Test(priority=1) 
      public void ReferralFormPageOpensUp_OnClickingReferralFormSubTab() throws InterruptedException{
    	  
    	Thread.sleep(2000);
  		String Title = driver.getTitle();
  		System.out.println(Title);
  		Assert.assertEquals("PageTitleMismatch","Referral Form",Title);
    	  
    	  
      }
      
      
	  @Test(priority=2)
	  public void DisableAllNonMandatoryToggle_ButtonsOnReferralFormPage() throws InterruptedException{
		  
	         Thread.sleep(3000);  
		  
	//--1.-----CHECK DATE OF BIRTH NON-MANDATORY FIELD-------------------------------------------------------------
	         
		  WebElement switchElement = driver.findElement(By.xpath("//*[@id='isDOBSelected']/following::span[1]"));
		  
		    System.out.println(Color.fromString(switchElement.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement);
		        Thread.sleep(2000);
		        System.out.println("DOB Switch is OFF now with updated color"+ Color.fromString(switchElement.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("DOB Switch  is already off");   
	
		    
	 //--2.----CHECK LAST NAME NON-MANDATORY FIELD------------------------------------------------------------------	  
	  
	      
		  //CLOSE THE BOT 
    		bot= new Closethebot();
    	    bot.Closing_the_bot();
		    
		   WebElement switchElement1 = driver.findElement(By.xpath("//*[@id='isLastNameSelected']/following::span[1]"));
		  
		    System.out.println(Color.fromString(switchElement1.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement1.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement1);
		        Thread.sleep(2000);
		        System.out.println("LASTNAME Switch is OFF now with updated color"+ Color.fromString(switchElement.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("LASTNAME Switch  is already off");   
	
      //--3.----EMAIL ID NON-MANDATORY FIELD-------------------------------------------------------------------------   
		    
		    WebElement switchElement2 = driver.findElement(By.xpath("//*[@id='isEmailSelected']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement2.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement2.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

		    	((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement2);
		        Thread.sleep(2000);
		        System.out.println("Email Switch is OFF now with updated color"+ Color.fromString(switchElement2.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("Email Switch  is already off");   
		    
		    
	  //-----LOCATIONS SECTION  
	 //--4,----DISPLAY LOCATIONS--------------------------------------------------------------------------------------	    
		    
		    WebElement switchElement3 = driver.findElement(By.xpath("//*[@id='isLocationSelected']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement3.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement3.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement3);
		        Thread.sleep(3000);
		        System.out.println("DisplayLocation Switch is OFF now with updated color"+ Color.fromString(switchElement3.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("DisplayLocation Switch  is already off");   
		    
		//---SERVICES   
	   //--5,---ORAL SURGERY 	    
		    
		    
		    WebElement switchElement4 = driver.findElement(By.xpath("//*[@id='isSelected_OralSurgery']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement4.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement4.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement4);
		        Thread.sleep(2000);
		        System.out.println("ORALSURGERY Switch is OFF now with updated color"+ Color.fromString(switchElement4.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("ORALSURGERY Switch  is already off");  
		    
       //--6,---PERIODONTICS	    
		    
		  //CLOSE THE BOT 
    		bot= new Closethebot();
    	    bot.Closing_the_bot();
		    
		    
		    WebElement switchElement5 = driver.findElement(By.xpath("//*[@id='isSelected_Periodontics']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement5.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement5.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement5);
		        Thread.sleep(2000);
		        System.out.println("PERIODONTICS Switch is OFF now with updated color"+ Color.fromString(switchElement5.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("PERIODONTICS Switch  is already off");  
		  
		  //--7,---PROSTHODONTICS   
		    
		    WebElement switchElement6 = driver.findElement(By.xpath("//*[@id='isSelected_Prosthodontics']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement6.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement6.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement6);
		        Thread.sleep(3000);
		        System.out.println("PROSTHODONTICS Switch is OFF now with updated color"+ Color.fromString(switchElement6.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("PROSTHODONTICS Switch  is already off"); 
		    
		    //--8,--ENDODONTICS  
		    
		    WebElement switchElement7 = driver.findElement(By.xpath("//*[@id='isSelected_Endodontics']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement7.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement7.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement7);
		        Thread.sleep(3000);
		        System.out.println("ENDODONTICS Switch is OFF now with updated color"+ Color.fromString(switchElement7.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("ENDODONTICS Switch  is already off"); 
		    
		    //--9,--ORTHODONTICS  
		    
		    WebElement switchElement8 = driver.findElement(By.xpath("//*[@id='isSelected_Orthodontics']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement8.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement8.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

		       ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement8);
		        Thread.sleep(2000);
		        System.out.println("ORTHODONTICS Switch is OFF now with updated color"+ Color.fromString(switchElement8.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("ORTHODONTICS Switch  is already off");    
		    
		    //--10,--PEDIATRICS  
		    
		    WebElement switchElement9 = driver.findElement(By.xpath("//*[@id='isSelected_Pediatrics']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement9.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement9.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement9);
		        Thread.sleep(2000);
		        System.out.println("PEDIATRICS Switch is OFF now with updated color"+ Color.fromString(switchElement9.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("PEDIATRICS Switch  is already off");
		    
		     //--11,--IMPLANTS 
		    
		    WebElement switchElement10 = driver.findElement(By.xpath("//*[@id='isSelected_Implants']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement10.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement10.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

		  
		    	((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement10);
		        Thread.sleep(2000);
		        System.out.println("IMPLANTS Switch is OFF now with updated color"+ Color.fromString(switchElement10.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("IMPLANTS Switch  is already off");
		    
		 //--12,--PERSONAL INFORMATION ------- 
		    
		    WebElement switchElement11 = driver.findElement(By.xpath("//*[@id='isSelected_PersonalInformation']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement11.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement11.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement11);
		        Thread.sleep(2000);
		        System.out.println("PERSONAL INFORMATION Switch is OFF now with updated color"+ Color.fromString(switchElement11.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("PERSONAL INFORMATION Switch  is already off");
		    
		    
		  Thread.sleep(4000);
		 //--13,--INSURANCE COVERAGE  
		    
		    WebElement switchElement12 = driver.findElement(By.xpath("//*[@id='isSelected_InsuranceCoverage']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement12.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement12.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {
   
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement12);
		        Thread.sleep(3000);
		        System.out.println("INSURANCE COVERAGE Switch is OFF now with updated color"+ Color.fromString(switchElement12.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("INSURANCE COVERAGE Switch  is already off");
		  
		  Thread.sleep(3000);  
		 //--14,--MEDICAL HISTORY   
		    
		    WebElement switchElement13 = driver.findElement(By.xpath("//*[@id='isSelected_MedicalHistory']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement13.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement13.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

		    	((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement13);
		        Thread.sleep(3000);
		        System.out.println("MEDICAL HISTORY Switch is OFF now with updated color"+ Color.fromString(switchElement13.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("MEDICAL HISTORY Switch  is already off");
		  
		 Thread.sleep(3000);   
		 //--15,--DENTAL HISTORY 
		    
		    WebElement switchElement14 = driver.findElement(By.xpath("//*[@id='isSelected_DentalHistory']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement14.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement14.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {
     
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement14);
		        Thread.sleep(2000);
		        System.out.println("DENTAL HISTORY Switch is OFF now with updated color"+ Color.fromString(switchElement14.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("DENTAL HISTORY Switch  is already off");
		 

		    
	  }
	  
	  
	  
	  @Test(priority=3)
	  public void NonMandatoryFieldsShouldNotAppearUnderSendReferralPage_WhenAllToggleButtonsAreDisabledOnReferralFormSettingspage(){
		  
		  //
		  
		  
		  
		  
		  
		   
	  }
	  
	  */
	  
	  @Test(priority=4)
	  public void UserIsAbleToEnableAll_ToggleButtonsOnReferralFormPage() throws InterruptedException{
		  
		  
		  
		Thread.sleep(3000);  
		  
	//--1.-----CHECK DATE OF BIRTH NON-MANDATORY FIELD-------------------------------------------------------------
	         
		  WebElement switchElement = driver.findElement(By.xpath("//*[@id='isDOBSelected']/following::span[1]"));
		  
		    System.out.println(Color.fromString(switchElement.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement);
		        Thread.sleep(2000);
		        System.out.println("DOB Switch is ON now with updated color"+ Color.fromString(switchElement.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("DOB Switch  is already ON");   
	
		    
	 //--2.----CHECK LAST NAME NON-MANDATORY FIELD------------------------------------------------------------------	  
	  
	      
		  //CLOSE THE BOT 
    		bot= new Closethebot();
    	    bot.Closing_the_bot();
		    
		   WebElement switchElement1 = driver.findElement(By.xpath("//*[@id='isLastNameSelected']/following::span[1]"));
		  
		    System.out.println(Color.fromString(switchElement1.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement1.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement1);
		        Thread.sleep(2000);
		        System.out.println("LASTNAME Switch is ON now with updated color"+ Color.fromString(switchElement.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("LASTNAME Switch  is already ON");   
	
      //--3.----EMAIL ID NON-MANDATORY FIELD-------------------------------------------------------------------------   
		    
		    WebElement switchElement2 = driver.findElement(By.xpath("//*[@id='isEmailSelected']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement2.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement2.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

		    	((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement2);
		        Thread.sleep(2000);
		        System.out.println("Email Switch is ON now with updated color"+ Color.fromString(switchElement2.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("Email Switch  is already ON");   
		    
		    
	  //-----LOCATIONS SECTION  
	 //--4,----DISPLAY LOCATIONS--------------------------------------------------------------------------------------	    
		    
		    WebElement switchElement3 = driver.findElement(By.xpath("//*[@id='isLocationSelected']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement3.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement3.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement3);
		        Thread.sleep(3000);
		        System.out.println("DisplayLocation Switch is ON now with updated color"+ Color.fromString(switchElement3.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("DisplayLocation Switch  is already ON");   
		    
		//---SERVICES   
	   //--5,---ORAL SURGERY 	    
		    
		    
		    WebElement switchElement4 = driver.findElement(By.xpath("//*[@id='isSelected_OralSurgery']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement4.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement4.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement4);
		        Thread.sleep(2000);
		        System.out.println("ORALSURGERY Switch is ON now with updated color"+ Color.fromString(switchElement4.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("ORALSURGERY Switch  is already ON");  
		    
       //--6,---PERIODONTICS	    
		    
		  //CLOSE THE BOT 
    		bot= new Closethebot();
    	    bot.Closing_the_bot();
		    
		    
		    WebElement switchElement5 = driver.findElement(By.xpath("//*[@id='isSelected_Periodontics']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement5.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement5.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement5);
		        Thread.sleep(2000);
		        System.out.println("PERIODONTICS Switch is ON now with updated color"+ Color.fromString(switchElement5.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("PERIODONTICS Switch  is already ON");  
		  
		  //--7,---PROSTHODONTICS   
		    
		    WebElement switchElement6 = driver.findElement(By.xpath("//*[@id='isSelected_Prosthodontics']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement6.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement6.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement6);
		        Thread.sleep(3000);
		        System.out.println("PROSTHODONTICS Switch is ON now with updated color"+ Color.fromString(switchElement6.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("PROSTHODONTICS Switch  is already ON"); 
		    
		    //--8,--ENDODONTICS  
		    
		    WebElement switchElement7 = driver.findElement(By.xpath("//*[@id='isSelected_Endodontics']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement7.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement7.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement7);
		        Thread.sleep(3000);
		        System.out.println("ENDODONTICS Switch is ON now with updated color"+ Color.fromString(switchElement7.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("ENDODONTICS Switch  is already ON"); 
		    
		    //--9,--ORTHODONTICS  
		    
		    WebElement switchElement8 = driver.findElement(By.xpath("//*[@id='isSelected_Orthodontics']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement8.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement8.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

		       ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement8);
		        Thread.sleep(2000);
		        System.out.println("ORTHODONTICS Switch is ON now with updated color"+ Color.fromString(switchElement8.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("ORTHODONTICS Switch  is already ON");    
		    
		    //--10,--PEDIATRICS  
		    
		    WebElement switchElement9 = driver.findElement(By.xpath("//*[@id='isSelected_Pediatrics']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement9.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement9.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement9);
		        Thread.sleep(2000);
		        System.out.println("PEDIATRICS Switch is ON now with updated color"+ Color.fromString(switchElement9.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("PEDIATRICS Switch  is already ON");
		    
		     //--11,--IMPLANTS 
		    
		    WebElement switchElement10 = driver.findElement(By.xpath("//*[@id='isSelected_Implants']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement10.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement10.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

		  
		    	((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement10);
		        Thread.sleep(2000);
		        System.out.println("IMPLANTS Switch is ON now with updated color"+ Color.fromString(switchElement10.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("IMPLANTS Switch  is already ON");
		    
		 //--12,--PERSONAL INFORMATION ------- 
		    
		    WebElement switchElement11 = driver.findElement(By.xpath("//*[@id='isSelected_PersonalInformation']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement11.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement11.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement11);
		        Thread.sleep(2000);
		        System.out.println("PERSONAL INFORMATION Switch is ON now with updated color"+ Color.fromString(switchElement11.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("PERSONAL INFORMATION Switch  is already ON");
		    
		    
		  Thread.sleep(4000);
		 //--13,--INSURANCE COVERAGE  
		    
		    WebElement switchElement12 = driver.findElement(By.xpath("//*[@id='isSelected_InsuranceCoverage']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement12.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement12.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {
   
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement12);
		        Thread.sleep(3000);
		        System.out.println("INSURANCE COVERAGE Switch is ON now with updated color"+ Color.fromString(switchElement12.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("INSURANCE COVERAGE Switch  is already ON");
		  
		  Thread.sleep(3000);  
		 //--14,--MEDICAL HISTORY   
		    
		    WebElement switchElement13 = driver.findElement(By.xpath("//*[@id='isSelected_MedicalHistory']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement13.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement13.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

		    	((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement13);
		        Thread.sleep(3000);
		        System.out.println("MEDICAL HISTORY Switch is ON now with updated color"+ Color.fromString(switchElement13.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("MEDICAL HISTORY Switch  is already ON");
		  
		 Thread.sleep(3000);   
		 //--15,--DENTAL HISTORY 
		    
		    WebElement switchElement14 = driver.findElement(By.xpath("//*[@id='isSelected_DentalHistory']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement14.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement14.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {
     
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click()",switchElement14);
		        Thread.sleep(2000);
		        System.out.println("DENTAL HISTORY Switch is ON now with updated color"+ Color.fromString(switchElement14.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("DENTAL HISTORY Switch  is already ON");
		 

				    
				    
			    
	  
	  }
	  /*
	  @Test(priority=5)
	  public void AllFieldsAppearUnderSendReferralPageWhen_AllToggleButtonsAreEnabled(){
		  
		  
		  
		  
	  }
	  
	  
	  
	  @Test(priority=6)
	  public void UserIsNotAbleToDisableMandatoryFields_ToggleButtonsOnReferralFormPage() throws InterruptedException{
		  
		Thread.sleep(2000);  
		//FIRST NAME TOGGLE BUTTON UNDER INFORMATION SECTION   
		Boolean result =  driver.findElement(By.xpath("//*[@id='isFirstNameSelected']/following::span[1]")).isEnabled();
		Assert.assertTrue(result);  
		System.out.println(result);    
		    
		//PHONE NUMBER TOGGLE BUTTON UNDER INFORMATION SECTION 
		Boolean result1 =  driver.findElement(By.xpath("//*[@id='isPhoneSelected']/following::span[1]")).isEnabled();
		Assert.assertTrue(result1);  
		System.out.println(result1);
		
		
		
	  }
	  
	  
	  */
	  
	 
	  
	  
	  
	  
	  
}


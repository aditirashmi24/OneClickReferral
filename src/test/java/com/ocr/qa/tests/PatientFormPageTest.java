package com.ocr.qa.tests;

import org.openqa.selenium.By;
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
import com.ocr.qa.pages.PatientFormPage;
import com.ocr.qa.pages.ReferalFormPage;
import com.ocr.qa.pages.Referralspage;
import com.ocr.qa.pages.SecuritySettingsPage;
import com.ocr.qa.pages.SelectWhoAreYou;
import com.ocr.qa.pages.SendReferralpage;

import junit.framework.Assert;

public class PatientFormPageTest extends TestBase {

	PatientFormPage patientformpage;
	SecuritySettingsPage securitysettingspage;
	
	
	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Referralspage refpage;
	SendReferralpage sendreff;
	Closethebot bot;
	
	//CREATE A CONSTRUCTOR
	public PatientFormPageTest(){
			
		super();
			
	} 
	
	//ALL TEST CASES SEPREATED AND INDEPENDENT EACH OTHER 
    //BEFORE METHOD
	@BeforeMethod
	public void PatientFormPage_SetupMethod() throws InterruptedException{
		
		initialization();
    	Thread.sleep(2000);  
    	securitysettingspage = new SecuritySettingsPage();
    	patientformpage = new PatientFormPage();
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
		Thread.sleep(7000);
		//CLOSE THE CHAT BOT 
	    bot.Closing_the_bot(); 
	    Thread.sleep(3000);
 		securitysettingspage = dashb.clickonsettingbtn();
 		Thread.sleep(5000);
 		patientformpage = dashb.clickonsettingandPatientFormbtn();
		Thread.sleep(7000);
				
				
	    }
	   
	   
	   //AFTER METHOD 
		@AfterMethod
		public void TestCase_Quit(){
				
			driver.quit();
		}
	  
	
		@Test(priority=1) 
	      public void PatientFormPageOpensUp_OnClickingPatientFormSubTab() throws InterruptedException{
	    	  
	    	Thread.sleep(2000);
	  		String Title = driver.getTitle();
	  		System.out.println(Title);
	  		Assert.assertEquals("PageTitleMismatch","Patient Referral Form Settings",Title);
	    	  
	    	  
	      }
		
		
		@Test(priority=2)
		 public void DisableAllNonMandatory_ToggleButtonsOnPatientFormPage() throws InterruptedException{
			
	 //--PERSONAL INFORMATION SECTION----------------- 
		//--GENDER FIELD--------------------------  
			WebElement switchElement = driver.findElement(By.xpath("//*[@id='P_isSelected_5']/following::span[1]"));
			  
		    System.out.println(Color.fromString(switchElement.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

		    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

                Actions action = new Actions (driver);
				
			    action.moveToElement(switchElement).perform();
			    Thread.sleep(3000);
			    action.click(switchElement).perform();
		        
		        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("Switch  is already off");     
		    
		  Thread.sleep(5000);  
		//--LAST NAME FIELD------------------------- 
		    WebElement switchElement1 = driver.findElement(By.xpath("//*[@id='P_isSelected_2']/following::span[1]"));
		    
		    System.out.println(Color.fromString(switchElement1.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement1.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

		    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

                Actions action = new Actions (driver);
				
			    action.moveToElement(switchElement1).perform();
			    Thread.sleep(3000);
			    action.click(switchElement1).perform();
		        
		        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement1.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("Switch  is already off");     
		   
		  Thread.sleep(5000);  
		//--EMAIL ADDRESS FIELD  
		    
           WebElement switchElement2 = driver.findElement(By.xpath("//*[@id='P_isSelected_3']/following::span[1]"));
		    
		    System.out.println(Color.fromString(switchElement2.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement2.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

		    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

                Actions action = new Actions (driver);
				
			    action.moveToElement(switchElement2).perform();
			    Thread.sleep(3000);
			    action.click(switchElement2).perform();
		        
		        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement1.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("Switch  is already off");  
		    
		  //CLOSE THE BOT 
    		bot= new Closethebot();
    	    bot.Closing_the_bot();
		 //--ADDRESS FIELD   
		   Thread.sleep(3000); 
    	    
            WebElement switchElement3 = driver.findElement(By.xpath("//*[@id='P_isSelected_6']/following::span[1]"));
		    
		    System.out.println(Color.fromString(switchElement3.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement3.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

		    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

                Actions action = new Actions (driver);
				
			    action.moveToElement(switchElement3).perform();
			    Thread.sleep(3000);
			    action.click(switchElement3).perform();
		        
		        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement1.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("Switch  is already off");  
		  
		 Thread.sleep(5000);   
		 //--DATE OF BIRTH----------------------   
		    
          WebElement switchElement4 = driver.findElement(By.xpath("//*[@id='P_isSelected_4']/following::span[1]"));
		    
		    System.out.println(Color.fromString(switchElement4.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement4.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

		    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

                Actions action = new Actions (driver);
				
			    action.moveToElement(switchElement4).perform();
			    Thread.sleep(3000);
			    action.click(switchElement4).perform();
		        
		        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement4.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("Switch  is already off");  
         
		 Thread.sleep(5000);   
		//--CITY------------------------- 
		    
           WebElement switchElement5 = driver.findElement(By.xpath("//*[@id='P_isSelected_7']/following::span[1]"));
		    
		    System.out.println(Color.fromString(switchElement5.getCssValue("background-color")).asHex()+": Switch Color");
		    // Check its on, if its on then switch it off
		    if (Color.fromString(switchElement5.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

		    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

                Actions action = new Actions (driver);
				
			    action.moveToElement(switchElement5).perform();
			    Thread.sleep(3000);
			    action.click(switchElement5).perform();
		        
		        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement5.getCssValue("background-color")));

		    } else
		    	
		        System.out.println("Switch  is already off");  
 
		    
		    //CLOSE THE BOT 
    	    bot.Closing_the_bot();
	//------INSURANCE COVERAGE SECTION------------------- 
		      
	           WebElement switchElement6 = driver.findElement(By.xpath("//*[@id='P_isSelected_InsuranceCoverage']/following::span[1]"));
			    
			    System.out.println(Color.fromString(switchElement6.getCssValue("background-color")).asHex()+": Switch Color");
			    // Check its on, if its on then switch it off
			    if (Color.fromString(switchElement6.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

	                Actions action = new Actions (driver);
					
				    action.moveToElement(switchElement6).perform();
				    Thread.sleep(3000);
				    action.click(switchElement6).perform();
			        
			        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement6.getCssValue("background-color")));

			    } else
			    	
			        System.out.println("Switch  is already off");   
		    
            Thread.sleep(5000);
	//------MEDICAL HISTORY SECTION-------------------   
			    
             WebElement switchElement7 = driver.findElement(By.xpath("//*[@id='P_isSelected_MedicalHistory']/following::span[1]"));
			    
			    System.out.println(Color.fromString(switchElement7.getCssValue("background-color")).asHex()+": Switch Color");
			    // Check its on, if its on then switch it off
			    if (Color.fromString(switchElement7.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

	                Actions action = new Actions (driver);
					
				    action.moveToElement(switchElement7).perform();
				    Thread.sleep(3000);
				    action.click(switchElement7).perform();
			        
			        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement7.getCssValue("background-color")));

			    } else
			    	
			        System.out.println("Switch  is already off");     
			    
		
	   Thread.sleep(5000);		    
	//-------DENTAL HISTORY SECTION-----------------
		    
             WebElement switchElement8 = driver.findElement(By.xpath("//*[@id='P_isSelected_DentalHistory']/following::span[1]"));
			    
			    System.out.println(Color.fromString(switchElement8.getCssValue("background-color")).asHex()+": Switch Color");
			    // Check its on, if its on then switch it off
			    if (Color.fromString(switchElement8.getCssValue("background-color")).asHex().equalsIgnoreCase("#C3E3F7")) {

			    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

	                Actions action = new Actions (driver);
					
				    action.moveToElement(switchElement8).perform();
				    Thread.sleep(3000);
				    action.click(switchElement8).perform();
			        
			        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement8.getCssValue("background-color")));

			    } else
			    	
			        System.out.println("Switch  is already off");    
			    
		
		 } 
		
		//
		
		
		
		
	
	    @Test(priority=3)
	    public void EnableAllToggleButtons_OnPatientFormpage() throws InterruptedException{
	    	
	    	//--PERSONAL INFORMATION SECTION----------------- 
			//--GENDER FIELD--------------------------  
				WebElement switchElement = driver.findElement(By.xpath("//*[@id='P_isSelected_5']/following::span[1]"));
				  
			    System.out.println(Color.fromString(switchElement.getCssValue("background-color")).asHex()+": Switch Color");
			    // Check its on, if its on then switch it off
			    if (Color.fromString(switchElement.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

			    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

	                Actions action = new Actions (driver);
					
				    action.moveToElement(switchElement).perform();
				    Thread.sleep(3000);
				    action.click(switchElement).perform();
			        
			        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement.getCssValue("background-color")));

			    } else
			    	
			        System.out.println("Switch  is already ON");    
			    
			//--LASTNAME FIELD--------------------------      
			    
			  //CLOSE THE BOT 
	    		bot= new Closethebot();
	    	    bot.Closing_the_bot();
			    Thread.sleep(3000);
				    WebElement switchElement1 = driver.findElement(By.xpath("//*[@id='P_isSelected_2']/following::span[1]"));
				    
				    System.out.println(Color.fromString(switchElement1.getCssValue("background-color")).asHex()+": Switch Color");
				    // Check its on, if its on then switch it off
				    if (Color.fromString(switchElement1.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

				    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

		                Actions action = new Actions (driver);
						
					    action.moveToElement(switchElement1).perform();
					    Thread.sleep(3000);
					    action.click(switchElement1).perform();
				        
				        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement1.getCssValue("background-color")));

				    } else
				    	
				        System.out.println("Switch  is already ON");     
				    
	             //--EMAIL ADDRESS FIELD------------------------------------  
				    
			           WebElement switchElement2 = driver.findElement(By.xpath("//*[@id='P_isSelected_3']/following::span[1]"));
					    
					    System.out.println(Color.fromString(switchElement2.getCssValue("background-color")).asHex()+": Switch Color");
					    // Check its on, if its on then switch it off
					    if (Color.fromString(switchElement2.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

					    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

			                Actions action = new Actions (driver);
							
						    action.moveToElement(switchElement2).perform();
						    Thread.sleep(3000);
						    action.click(switchElement2).perform();
					        
					        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement1.getCssValue("background-color")));

					    } else
					    	
					        System.out.println("Switch  is already ON");  
		       
				  //--ADDRESS FIELD   
					   Thread.sleep(3000); 
				    	    
				       WebElement switchElement3 = driver.findElement(By.xpath("//*[@id='P_isSelected_6']/following::span[1]"));
						    
				       System.out.println(Color.fromString(switchElement3.getCssValue("background-color")).asHex()+": Switch Color");
					   // Check its on, if its on then switch it off
					   if (Color.fromString(switchElement3.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

					   //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

				           Actions action = new Actions (driver);
								
				           action.moveToElement(switchElement3).perform();
						    Thread.sleep(3000);
		     			    action.click(switchElement3).perform();
		 			        
					        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement1.getCssValue("background-color")));

					    } else
						    	
				        System.out.println("Switch  is already ON");  		    
				    
			    //--DATE OF BIRTH----------------------   
					    
				      WebElement switchElement4 = driver.findElement(By.xpath("//*[@id='P_isSelected_4']/following::span[1]"));
						    
					  System.out.println(Color.fromString(switchElement4.getCssValue("background-color")).asHex()+": Switch Color");
					   // Check its on, if its on then switch it off
						   if (Color.fromString(switchElement4.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

					    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

				            Actions action = new Actions (driver);
								
				    	    action.moveToElement(switchElement4).perform();
						    Thread.sleep(3000);
						    action.click(switchElement4).perform();
						        
					        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement4.getCssValue("background-color")));

						    } else
						    	
						        System.out.println("Switch  is already ON");  
				         
						 Thread.sleep(5000);   	   
					    
			//--CITY------------------------- 
							    
			      WebElement switchElement5 = driver.findElement(By.xpath("//*[@id='P_isSelected_7']/following::span[1]"));
							    
				    System.out.println(Color.fromString(switchElement5.getCssValue("background-color")).asHex()+": Switch Color");
							    // Check its on, if its on then switch it off
				    if (Color.fromString(switchElement5.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

						    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

			             Actions action = new Actions (driver);
									
					     action.moveToElement(switchElement5).perform();
					    Thread.sleep(3000);
					    action.click(switchElement5).perform();
							        
				        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement5.getCssValue("background-color")));

					 } else
							    	
				     System.out.println("Switch  is already ON");  
					 
							    
	          //CLOSE THE BOT 
				    bot.Closing_the_bot();	   
                     Thread.sleep(3000);
			 //------INSURANCE COVERAGE SECTION------------------- 
					      
			           WebElement switchElement6 = driver.findElement(By.xpath("//*[@id='P_isSelected_InsuranceCoverage']/following::span[1]"));
					    
					    System.out.println(Color.fromString(switchElement6.getCssValue("background-color")).asHex()+": Switch Color");
					    // Check its on, if its on then switch it off
					    if (Color.fromString(switchElement6.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

					    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

			                Actions action = new Actions (driver);
							
						    action.moveToElement(switchElement6).perform();
						    Thread.sleep(3000);
						    action.click(switchElement6).perform();
					        
					        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement6.getCssValue("background-color")));

					    } else
					    	
					        System.out.println("Switch  is already ON");   
				    
		            Thread.sleep(7000);
			//------MEDICAL HISTORY SECTION-------------------   
					    
		             WebElement switchElement7 = driver.findElement(By.xpath("//*[@id='P_isSelected_MedicalHistory']/following::span[1]"));
					    
					    System.out.println(Color.fromString(switchElement7.getCssValue("background-color")).asHex()+": Switch Color");
					    // Check its on, if its on then switch it off
					    if (Color.fromString(switchElement7.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

					    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

			                Actions action = new Actions (driver);
							
						    action.moveToElement(switchElement7).perform();
						    Thread.sleep(3000);
						    action.click(switchElement7);
					        
					        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement7.getCssValue("background-color")));

					    } else
					    	
					        System.out.println("Switch  is already ON");     
					    
				
			   Thread.sleep(7000);		    
			//-------DENTAL HISTORY SECTION-----------------
				    
		             WebElement switchElement8 = driver.findElement(By.xpath("//*[@id='P_isSelected_DentalHistory']/following::span[1]"));
					    
					    System.out.println(Color.fromString(switchElement8.getCssValue("background-color")).asHex()+": Switch Color");
					    // Check its on, if its on then switch it off
					    if (Color.fromString(switchElement8.getCssValue("background-color")).asHex().equalsIgnoreCase("#ACB4BA")) {

					    //    switchElement.findElement(By.xpath("//*[@id=\"DetailId\"]/div[2]/label/span")).click();    

			                Actions action = new Actions (driver);
							
						    action.moveToElement(switchElement8).perform();
						    Thread.sleep(3000);
						    action.click(switchElement8);
					        
					        System.out.println("Switch is ON now with updated color"+ Color.fromString(switchElement8.getCssValue("background-color")));

					    } else
					    	
					        System.out.println("Switch  is already ON");    
					    
						   
					   
	    }
	   
	    
	    @Test(priority=4)
	    public void UserIsNotAbleToDisableMandatoryFieldsToggleButtonsOnPatientFormPage() throws InterruptedException{
	    	
	    	Thread.sleep(2000);  
			//FIRST NAME TOGGLE BUTTON UNDER INFORMATION SECTION   
			Boolean result =  driver.findElement(By.xpath("//*[@id='P_isSelected_1']/following::span[1]")).isEnabled();
			Assert.assertTrue(result);  
			System.out.println(result);    
			    
			//PHONE NUMBER TOGGLE BUTTON UNDER INFORMATION SECTION 
			Boolean result1 =  driver.findElement(By.xpath("//*[@id='P_isSelected_10']/following::span[1]")).isEnabled();
			Assert.assertTrue(result1);  
			System.out.println(result1);
	    	
	    	
	    }
	
	
	
	
}

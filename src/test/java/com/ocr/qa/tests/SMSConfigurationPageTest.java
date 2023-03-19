package com.ocr.qa.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.base.TestBase;
import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Dashboardpage;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.ReferalFormPage;
import com.ocr.qa.pages.Referralspage;
import com.ocr.qa.pages.SMSConfigurationPage;
import com.ocr.qa.pages.SecuritySettingsPage;
import com.ocr.qa.pages.SelectWhoAreYou;
import com.ocr.qa.pages.SendReferralpage;
import com.ocr.qa.pages.TeamMembersPage;

import junit.framework.Assert;

public class SMSConfigurationPageTest extends TestBase {

	  
		SMSConfigurationPage smsconfigurationpage;
		SecuritySettingsPage securitysettingspage;
		
		Loginpage loginpage;
		Dashboardpage dashb;
		SelectWhoAreYou Swatpage;
		Referralspage refpage;
		SendReferralpage sendreff;
		Closethebot bot;
		
	
		//CREATE A CONSTRUCTOR
		public SMSConfigurationPageTest(){
					
			super();
					
		}
	
	     
		//ALL TEST CASES SEPREATED AND INDEPENDENT EACH OTHER 
	    //BEFORE METHOD
		@BeforeMethod
		public void SMSConfigurationPageTest_SetupMethod() throws InterruptedException{
			
			 initialization(); 
	         
			    smsconfigurationpage = new SMSConfigurationPage();
		        securitysettingspage = new SecuritySettingsPage();
		        
		        refpage = new Referralspage();
				sendreff = new SendReferralpage(); 
				Swatpage = new SelectWhoAreYou() ;
				loginpage = new Loginpage();
				
				//CLOSE THE CHAT BOT 
				bot= new Closethebot();
			    bot.Closing_the_bot();
			    Thread.sleep(3000);
				loginpage =	Swatpage.loginbtn();
				Thread.sleep(15000);
				
				//CLOSE THE CHAT BOT 
				bot.Closing_the_bot();
				Thread.sleep(2000);
				
				dashb = new Dashboardpage() ;
				dashb = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
				Thread.sleep(17000);
				//CLOSE THE CHAT BOT 
			    bot.Closing_the_bot();
			    Thread.sleep(1000);
				
		 		securitysettingspage = dashb.clickonsettingbtn();
				Thread.sleep(5000);
				
				smsconfigurationpage = dashb.clickonSMSConfigurationTab();
				Thread.sleep(7000);
				
					
		    }
	
		//AFTER METHOD 
				@AfterMethod
				public void TestCase_Quit(){
						
					driver.quit();
				}
	
				 //--------------TEST CASE---------------------------
			    
	   @Test(priority=1) 
	   public void VerifyThatSMSConfigurationPageOpensUpOnClickingSMSConfigurationSubTTab(){
		   
		  String title = driver.getTitle();  
		  System.out.println(title); 
		  Assert.assertEquals("SMS Configuration", title);
		   
	   }
	   
	   
	   @Test(priority=2)
	   public void ZipwhipSignUpPopupOpensUpOnClickingAddButtonUnderSMSConfigurationpage() throws InterruptedException{
		   
		   Thread.sleep(3000);
		   loginpage.ExplicitWait(smsconfigurationpage.Addbutton());
		   Thread.sleep(3000);
		   
		   String title = loginpage.ExplicitWaitGetText(smsconfigurationpage.ZipwhipSignUpPopupTitle()) ;
		   Assert.assertEquals("TITLE MISMATCHED", "Zipwhip Sign Up", title);
		   
	   }
	    
	  
	   @Test(priority=3)
	   public void ValidationMessageAppearsOnLeavingMandatoryFieldsBlankUnderZipwhipSignUpPopup() throws InterruptedException{
		   
		   Thread.sleep(3000);
		   loginpage.ExplicitWait(smsconfigurationpage.Addbutton());
		   Thread.sleep(3000); 
		   
		   loginpage.ExplicitWaitClear(smsconfigurationpage.acountnametextfield());
		   Thread.sleep(3000);
		   loginpage.ExplicitWait(smsconfigurationpage.CreateAcountButtonOnZipwhipSignUpPopupTitle());
		   
		   Thread.sleep(2000);
		   String text =  loginpage.ExplicitWaitGetText(smsconfigurationpage.ValidationMessagePlesaeEnterAccountName()); 
		   Assert.assertEquals("VALIDATION MESSAGE NOT APPEARS","Please enter the account name.",text);
		   
		   
		   
		   
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	
	
}

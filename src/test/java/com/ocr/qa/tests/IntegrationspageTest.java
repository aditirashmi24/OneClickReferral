package com.ocr.qa.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.base.TestBase;
import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Dashboardpage;
import com.ocr.qa.pages.Integrationspage;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.Referralspage;
import com.ocr.qa.pages.SecuritySettingsPage;
import com.ocr.qa.pages.SelectWhoAreYou;
import com.ocr.qa.pages.SendReferralpage;

public class IntegrationspageTest extends TestBase {
    
	Integrationspage integrationspage;
	SecuritySettingsPage securitysettingspage;
	
	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Referralspage refpage;
	SendReferralpage sendreff;
	Closethebot bot;
	
	
	  //CREATE A CONSTRUCTOR
		public IntegrationspageTest(){
			
			super();
			
		}
	 
		//ALL TEST CASES SEPREATED AND INDEPENDENT EACH OTHER 
		//BEFORE METHOD	
		@BeforeMethod
		public void IntegrationspageTest_SetupMethod() throws InterruptedException{
			
		        	initialization();
		        	Thread.sleep(2000);  
		        	securitysettingspage = new SecuritySettingsPage();
		        	integrationspage = new Integrationspage();
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
			 	//	integrationspage = dashb.clickonsettingandIntegrationspagebtn();
				//	Thread.sleep(7000);
					
		    }
	
		
		 //AFTER METHOD 
			@AfterMethod
			public void TestCase_Quit(){
					
				driver.quit();
			}
	     
		//--------------TEST CASE---------------------------	
	   
		@Test(priority=1) 
		
		public void IntegrationsPageOpensUpOn_ClickingIntegrationsSubTab(){
			
			
			
			
			
		}
		
        @Test(priority=2) 
		
		public void UserIsAbleToEnableAll_ToggleButtonsOnIntegrationsPage(){
			
			
			
			
			
		}
		
        @Test(priority=3) 
		
		public void ConfirmationMessageAppearsWhen_UserDisableAnyToggleButtonOnIntegrationsPage(){
			
			
			
			
			
		}
	    
        @Test(priority=4)
        
        public void UserIsAbleToDisableAllToggle_ButtonsOnIntegrationsPage(){
        	
        	
        	
        	
        	
        	
        }
        
        @Test(priority=5) 
        
        public void VerifyThatPMSIntegrationKeyIsAutoGenerateFor_AddedLocationOnClickingAddAccountButtonOnIntegrationsPage(){
        	
        	
        	
        	
        	
        	
        }
        
        @Test(priority=6) 
        
        public void VerifyThatUserIsAbleToDeleteAutoGeneratedPMSIntegrationKeyOnClickingDeleteIconOnIntegrationsPage(){
        	
        	
        	
        	
        	
        	
        }
        
        @Test(priority=7) 
        
        public void ConfirmationMessageAppearsWhenUserDisablePMSIntegrationKeyToggleButtonUnderIntegrationsPage(){
        	
        	
        	
        	
        	
        }
        
        @Test(priority=8) 
        
        public void UserIsAbleToDisablePMSIntegrationKeyToggleButtonOnClickingYesButtonUnderConfirmationMessageOnIntegrationsPage(){
        	
        	
        	
        	
        	
        }
        
        @Test(priority=9) 
        
        public void UserIsAbleToEnablePMSIntegrationKeyToggleButtonUnderIntegrationsPage(){
        	
        	
        	
        	
        	
        }
        
        @Test(priority=10)
        
        public void RecordLincSyncSetupGuidePageOpensUpOnClickingInstructionsForSettingUpIntegrationButtonUnderIntegrationsPage(){
        	
        	
        	
        	
        		
        }
        
        @Test(priority=11)
        
        public void UserIsAbleToDownloadRecordlincSyncrOnClickingDownloadPracticeManagementSyncButtonUnderIntegrationsPage(){
        	
        	
        	
        	
        	
        }
        
        @Test(priority=12)
        
        public void  URLOpensUpOnClickingDownloadDentrixButtonUnderIntegrationsPage(){
        	
        	
        	
        	
        }
        
        @Test(priority=13)
        
        public void ButtonsAndLinksArefunctionalUnderDentrixButtonPage(){
        	
        	
        	
        	
        }
        
        @Test(priority=14) 
        
        public void IntegrationSetupPageOpensUpOnClickingScheduleYourIntegrationButtonUnderIntegrationsPage(){
        	
        	
        	
        	
        	
        }
        
        @Test(priority=15) 
        
        public void OpenPickAnAppPopupOpensUpOnClickingCallSupportNumberUnderIntegrationsPage(){
        	
        	
        	
        	
        	
        }
        
        
        
        
	
}

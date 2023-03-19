package com.ocr.qa.tests;






import javax.swing.text.Document;
import javax.swing.text.Element;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
import org.openqa.selenium.JavascriptExecutor;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.Profilepage;
import com.ocr.qa.pages.Referralspage;
import com.ocr.qa.pages.SecuritySettingsPage;
import com.ocr.qa.pages.SelectWhoAreYou;
import com.ocr.qa.pages.SendReferralpage;

import junit.framework.Assert;

public class SecuritySettingsPageTest extends TestBase {
     
	
	
	
    SecuritySettingsPage securitysettingspage;
     
	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Referralspage refpage;
	SendReferralpage sendreff;
	Closethebot bot; 
	
	
	//CREATE A CONSTRUCTOR 
	public SecuritySettingsPageTest(){
		
		 super();
		
	}
	
		//ALL TEST CASES SEPREATED AND INDEPENDENT EACH OTHER 
		//BEFORE METHOD
		@BeforeMethod
		public void SecuritySettingsPage_SetupMethod() throws InterruptedException{
			
			
			initialization();
			
			securitysettingspage = new SecuritySettingsPage();
			sendreff = new SendReferralpage();
			refpage = new Referralspage();
			
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
		    Thread.sleep(2000);
			
		    securitysettingspage = dashb.clickonsettingbtn();
		   	Thread.sleep(2000);
		    
		}
	    
		
		//AFTER METHOD 
		@AfterMethod
		public void TestCase_Quit(){
			
			
			driver.quit();
			
		}
         
		
	    //VALIDATE SECURITY SETTINGS PAGE TITLE 
		@Test(priority=1)
		public void SecuritySettingsPageOpensUp_OnClickingSecuritySettingsSubTab() throws InterruptedException{
			
			Thread.sleep(1000);
			  //Validate on title
			  String title = driver.getTitle();
			  System.out.println(title);
			  Assert.assertEquals(title,"Security Settings");
			
		}
	     
	    @Test(priority=2)
	    public void ValidationMsgAppearsOnLeavingMandatory_FieldsBlankUnderSecuritySettingsPage() throws InterruptedException{
	    	 
	    	Thread.sleep(1000);
	    	loginpage.ExplicitWaitClear(securitysettingspage.Username());
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWaitClear(securitysettingspage.PrimaryEmailField());
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWait(securitysettingspage.SubmitButton());
	    	
	    	//VALIDATION MESSAGE APPEARS ON LEAVING MANDATORY FIELDS 
	    	String valdmsg = driver.findElement(By.className("message")).getText();
	    	Assert.assertEquals("Username field is required!",valdmsg);
	    	
	    	
	    }
	    
	    
	    @Test(priority=3)
	    public void  ValidationMsgAppearsOnEnteringPreExistingUserNameIn_UserNameTextfieldOnSecuritySettingsPage() throws InterruptedException{
	    	
	    	
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWaitClear(securitysettingspage.Username());
	    	Thread.sleep(1000);
	    	loginpage.ExplicitWaitSendKeys(securitysettingspage.Username(),"Levis");
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWaitClear(securitysettingspage.PrimaryEmailField());
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWaitSendKeys(securitysettingspage.PrimaryEmailField(),"bha.variance@gmail.com");
	    	Thread.sleep(5000);
	    	loginpage.ExplicitWait(securitysettingspage.SubmitButton());
	        
	    	Thread.sleep(2000);
	    	//VALIDATION MESSAGE APPEARS ON LEAVING MANDATORY FIELDS 
	    	WebElement msg = driver.findElement(By.className("message"));
	    	String valdmsg =  loginpage.ExplicitWaitGetText(msg);
	    	System.out.println(valdmsg);
	    	Assert.assertEquals("User Name already exists in system.",valdmsg);

	    	
	    }
	    
	     
	    @Test(priority=4)
	    public void VerifyThatUserIsAbleToUpdateThe_UserNameOnSecuritySettingsPage() throws InterruptedException{
	    	
	    	loginpage.ExplicitWaitClear(securitysettingspage.Username());
	    	Thread.sleep(1000);
	    	loginpage.ExplicitWaitSendKeys(securitysettingspage.Username(),"levin");
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWaitClear(securitysettingspage.PrimaryEmailField());
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWaitSendKeys(securitysettingspage.PrimaryEmailField(),"levin@yopmail.com");
	        Thread.sleep(2000);
	     	loginpage.ExplicitWait(securitysettingspage.SubmitButton());
	    	
	     	Thread.sleep(2000);
	    	//VALIDATION MESSAGE APPEARS ON LEAVING MANDATORY FIELDS 
	    // 	WebElement msg = driver.findElement(By.className("message"));
	   // 	String valdmsg =  loginpage.ExplicitWaitGetText(msg);
	   // 	System.out.println(valdmsg);
	    //	Assert.assertEquals("Security settings updated successfully.",valdmsg);
           	
	    }
	    
		
	   @Test(priority=5)
	    public void ValidationMsgAppearsOnEnteringPreExistingPrimaryEmailIn_PrimaryEmailTextfieldOnSecuritySettingsPage() throws InterruptedException{
		  
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWaitClear(securitysettingspage.PrimaryEmailField());
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWaitSendKeys(securitysettingspage.PrimaryEmailField(),"tjerry@yopmail.com");
	    	Thread.sleep(5000);
	    	loginpage.ExplicitWait(securitysettingspage.SubmitButton());
	        Thread.sleep(2000);
	    	//VALIDATION MESSAGE APPEARS ON LEAVING MANDATORY FIELDS 
	    	WebElement msg = driver.findElement(By.className("message"));
	    	String valdmsg =  loginpage.ExplicitWaitGetText(msg);
	    	System.out.println(valdmsg);
	    	Assert.assertEquals("This primary email address is already in use.",valdmsg);
		    
	   }
	   
	  
	   @Test(priority=6)
	    public void ValidationMsgAppearsOnEnteringInvalidEmailAddress_InPrimaryEmailtextfieldOnSecuritySettingsPage() throws InterruptedException{
		   
		   Thread.sleep(2000);
		   Thread.sleep(2000);
	    	loginpage.ExplicitWaitClear(securitysettingspage.PrimaryEmailField());
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWaitSendKeys(securitysettingspage.PrimaryEmailField(),"tjerry@.com");
	    	Thread.sleep(5000);
	    	loginpage.ExplicitWait(securitysettingspage.SubmitButton());
	   
	    	//VALIDATION MESSAGE APPEARS ON LEAVING MANDATORY FIELDS 
	    	String valdmsg = driver.findElement(By.className("message")).getText();
	    	System.out.println(valdmsg);
	    	Assert.assertEquals("Please enter valid primary email",valdmsg);
		   
		   
	   }
	   
	   @Test(priority=7)
	    public void UserIsAbleToShowHideEnteredPasswordOn_ClickingShowHideIconUnderSecuritySettingsPage() throws InterruptedException{
		          
		      Thread.sleep(2000);
		      loginpage.ExplicitWaitSendKeys(securitysettingspage.Password(),"Hell1234567");
		        
	    	  Thread.sleep(2000);    
		      WebElement Showhideicon = driver.findElement(By.xpath("//i[@class='fa fa-eye']"));
		      Showhideicon.click();
		      Thread.sleep(3000);
		      
		      
		      if(Showhideicon.isEnabled() == true){
		    	  
			     String PasswordShow=  driver.findElement(By.xpath("//*[@id=\"NewPassword\"]")).getAttribute("type");
			     Assert.assertEquals("text",PasswordShow);
			     
			   }else{
				  String PasswordHide=  driver.findElement(By.xpath("//*[@id=\"NewPassword\"]")).getAttribute("type");
				  Assert.assertEquals("password",PasswordHide);
			   }
		      
	    }
	   
	   
	   @Test(priority=8)
	     public void EnteredPasswordDoesNotMeetThePasswordCriteria_ThenMismatchedCriteriaAppearsHighlightedInRedColorInThePopup() throws InterruptedException{
		   
		   Thread.sleep(2000);
		   loginpage.ExplicitWaitSendKeys(securitysettingspage.Password(),"Hello123");  
		    
		 //VALID SMALL LETTER
		   String letter = driver.findElement(By.xpath("//li[@id='letter']")).getAttribute("class");
		   System.out.println("THIS SMALL LETTER IS :-"+letter);
		   Assert.assertEquals("INVALID SMALL LETTER","valid",letter);
		   
		   //VALID CAPITAL LETTER
		   String Capitalletter = driver.findElement(By.xpath("//li[@id='capital']")).getAttribute("class");
		   System.out.println("THIS CAPITAL LETTER IS :-"+Capitalletter);
		   Assert.assertEquals("INVALID CAPITAL LETTER","valid",Capitalletter);
		   
		  //VALID ATLEAST ONE NUMBER
		   String Number = driver.findElement(By.xpath("//li[@id='number']")).getAttribute("class");
		   System.out.println("THIS NUMBER IS :-"+Number);
		   Assert.assertEquals("INVALID ATLEST ONE NUMBER","valid",Number);
		   
		 //VALID ATLEAST ONE SPECIAL SYMBOL
		   String Special = driver.findElement(By.xpath("//li[@id='special']")).getAttribute("class");
		   System.out.println("THIS SPECIAL SYMBOL IS :-"+Special);
		   Assert.assertEquals("INVALID SPECIAL SYMBOL","invalid",Special);
		   
		 //VALID ATLEAST EIGHT CHARACTER 
		   String length = driver.findElement(By.xpath("//li[@id='length']")).getAttribute("class");
		   System.out.println("THIS 8 NUMBER CHARACTER LENGTH IS :-"+length);
		   Assert.assertEquals("INVALID 8 NUMBER LETTER","valid",length);
		   
		
	   }
	   
	   
	   @Test(priority=9)
	   public void EnteredPasswordInPasswordFieldMeetsThePasswordCriteria_ThenTheMatchedCriteriaAppearsHighlightedInGreenColorInThePopup() throws InterruptedException{
		   
		   Thread.sleep(2000);
		   loginpage.ExplicitWaitSendKeys(securitysettingspage.Password(),"Hello@123");
		   
		   //VALID SMALL LETTER
		   String letter = driver.findElement(By.xpath("//li[@id='letter']")).getAttribute("class");
		   System.out.println("THIS SMALL LETTER IS :-"+letter);
		   Assert.assertEquals("INVALID SMALL LETTER","valid",letter);
		   
		   //VALID CAPITAL LETTER
		   String Capitalletter = driver.findElement(By.xpath("//li[@id='capital']")).getAttribute("class");
		   System.out.println("THIS CAPITAL LETTER IS :-"+Capitalletter);
		   Assert.assertEquals("INVALID CAPITAL LETTER","valid",Capitalletter);
		   
		  //VALID ATLEAST ONE NUMBER
		   String Number = driver.findElement(By.xpath("//li[@id='number']")).getAttribute("class");
		   System.out.println("THIS NUMBER IS :-"+Number);
		   Assert.assertEquals("INVALID ATLEST ONE NUMBER","valid",Number);
		   
		 //VALID ATLEAST ONE SPECIAL SYMBOL
		   String Special = driver.findElement(By.xpath("//li[@id='special']")).getAttribute("class");
		   System.out.println("THIS SPECIAL SYMBOL IS :-"+Special);
		   Assert.assertEquals("INVALID SPECIAL SYMBOL","valid",Special);
		   
		 //VALID ATLEAST EIGHT CHARACTER 
		   String length = driver.findElement(By.xpath("//li[@id='length']")).getAttribute("class");
		   System.out.println("THIS 8 NUMBER CHARACTER LENGTH IS :-"+length);
		   Assert.assertEquals("INVALID 8 NUMBER LETTER","valid",length);
		   
		     
		   
	   }
	  
	   
	   @Test(priority=10)
	   public void UserIsAbleToSaveDetailsOnClicking_SubmitButtonUnderSecuritySettingsPage() throws InterruptedException{
		   
		   loginpage.ExplicitWaitClear(securitysettingspage.Username());
	    	Thread.sleep(1000);
	    	loginpage.ExplicitWaitSendKeys(securitysettingspage.Username(),"levin");
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWaitClear(securitysettingspage.PrimaryEmailField());
	    	Thread.sleep(2000);
	    	loginpage.ExplicitWaitSendKeys(securitysettingspage.PrimaryEmailField(),"levin@yopmail.com");
	        Thread.sleep(2000);
	     	loginpage.ExplicitWait(securitysettingspage.SubmitButton());
	    	
	    	Thread.sleep(1000);
	    	//VALIDATION MESSAGE APPEARS ON LEAVING MANDATORY FIELDS 
	     	WebElement msg = driver.findElement(By.className("message"));
	    	String valdmsg =  loginpage.ExplicitWaitGetText(msg);
	    	System.out.println(valdmsg);
	    	Assert.assertEquals("Security settings updated successfully.",valdmsg);
		   
		   
		   
	   }
	   
	   
	  
	    
	   
	    
	    
}

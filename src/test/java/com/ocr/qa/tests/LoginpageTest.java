package com.ocr.qa.tests;

import java.util.Set;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.base.TestBase;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.SelectWhoAreYou;

import junit.framework.Assert;

public class LoginpageTest extends TestBase{
	SelectWhoAreYou Swatpage;
	Loginpage loginpage;
	
   //CREATE A CONSTRUCTOR
	public LoginpageTest(){	
		super();
	}
    
   //TEST CASES SHOULD BE INDEPENDENT OR SEPERATED WITH EACH OTHER
	
   //CREATE SETUP METHOD 
	@BeforeMethod
	public void LoginPage_SetupMethod() throws Exception{
		
		System.out.println("abnks");
		
		initialization();
		Swatpage = new SelectWhoAreYou();
		loginpage = new Loginpage();
	    loginpage =	Swatpage.loginbtn();
	  
	       
	}
	
	//CREATE QUIT METHOD
	   @AfterMethod 
	   public void TestCase_QuitMethod(){
		  
		  driver.quit();

	   } 
	
   //VALIDATE LOGIN-PAGE TITLE
   @Test(priority=1) 
   public void SignInToOneClickReferral_TitleAppearsOnLoginPage() throws InterruptedException{
	  Thread.sleep(1000);
	  //Validate on title
	  String title = loginpage.validatepagetitle();
	  Assert.assertEquals(title, "Sign in to OneClick");
   } 
  
   //VALIDATE ON PAGE-LOGO IMAGE
   @Test(priority=2) 
   public void OCRLogoAppears_OnLoginPage(){
	 
	  Boolean img = loginpage.validateimglogo();
	  Assert.assertTrue(img);
   } 
   
   //CALL LOGIN METHOD ENTER USERNAME & PASSWORD
   @Test(priority=3)	   
   public void LoginAfterEnteringValidCredentials_OnLoginPage() throws InterruptedException{
	  //login in the page
	 loginpage.login(prop.getProperty("username"), prop.getProperty("password"));   
	 
   } 
   @Test(priority=4)
   public void RecordlincForgotPasswordPageOpensUp_OnClickingForgotPasswordLinkOnLoginPage() throws InterruptedException{
	   
	  loginpage.forgetpassword();
	  
	  Thread.sleep(5000); 
	     
	  String parenthandler= driver.getWindowHandle();
		
	     Set<String>allwindowhandles = driver.getWindowHandles();
	    
	     for(String currenthandle :allwindowhandles){
	    	 
	    	 System.out.println("Current window handle is"+currenthandle);
	    	 if(!currenthandle.equalsIgnoreCase(parenthandler)){
	    		 
	    		 driver.switchTo().window(currenthandle); 
	    		 System.out.println("Title of child window is"+driver.getTitle());
	    		// driver.close();
	    	 }
	     }
	    		
   }
   
   
  
  
  
}

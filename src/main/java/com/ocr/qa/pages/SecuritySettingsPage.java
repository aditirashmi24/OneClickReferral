package com.ocr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ocr.qa.base.TestBase;

public class SecuritySettingsPage extends TestBase {
  
	//***** P A G E - F A C T O R Y *****
	
	 //USERNAAME FIELD IN SECURITY SETTINGS PAGE
		@FindBy(how=How.XPATH,using="//*[@id=\"Username\"]")
		@CacheLookup 
		WebElement Username;
	 
	 //PRIMARY EMAIL FIELD IN SECURITY SETTINGS PAGE 
		@FindBy(how=How.XPATH,using="//*[@id=\"PrimaryEmail\"]")
		@CacheLookup 
		WebElement PrimaryEmail;
	
		
	//PASSWORD FIELD IN SECURITY SETTINGS PAGE 
		@FindBy(how=How.XPATH,using="//*[@id=\"NewPassword\"]")
		@CacheLookup 
		WebElement Password;
		
		
	  //SUBMIT BUTTON IN SECURITY SETTINGS PAGE 	
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Submit') and @class='btn btn-default btn2']")
		@CacheLookup 
		WebElement SubmitButton;
	
	  //SHOW/HIDE ICON UNDER SECURITY SETTINGS PAGE 
		@FindBy(how=How.XPATH,using="//i[@class='fa fa-eye']")
		@CacheLookup 
		WebElement ShowHideIcon;
	   
		
	
	//INITIALIZE ALL OBJECTS------------------------------ 
		public SecuritySettingsPage(){
				
			PageFactory.initElements(driver,this);
				
		}
			
    //CREATE A METHODS  
	    
	  //USERNAME FIELD IN SECURITY SETTINGS PAGE 
		public WebElement Username(){
			
			return Username ;
			
		}
		
	  //PRIMARY EMAIL FIELD IN SECURITY SETTINGS PAGE 	
		public WebElement PrimaryEmailField(){
			
			return PrimaryEmail;
		}
		
	  //PRIMARY EMAIL FIELD IN SECURITY SETTINGS PAGE 	
		public WebElement Password(){
					
				return Password;
		}	
		
	  //PRIMARY EMAIL FIELD IN SECURITY SETTINGS PAGE 	
		public WebElement SubmitButton(){
					
			return SubmitButton;
		}	
	
}

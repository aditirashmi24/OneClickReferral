package com.ocr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ocr.qa.base.TestBase;

public class SMSConfigurationPage extends TestBase{

	
//*************Page-Factory****************
	
    //Page All Elements
	//ADD BUTTON ON SMS CONFIGRATION PAGE  
	
		@FindBy(how=How.LINK_TEXT,using="Add Zipwhip")
		@CacheLookup
	    WebElement addbutton ;	
	
	//ZIP WHIP POPUP TITLE  
		
		@FindBy(how=How.XPATH,using="//h3[contains(text(),'Zipwhip Sign Up')]")
		@CacheLookup  
		WebElement zipwhippopuptitle ;
		
	//ACOUNT NAME TEXT-FIELD  
		
		@FindBy(how=How.XPATH,using="//*[@id=\"txtaccountname\"]")
		@CacheLookup  
		WebElement acountnametextfield ;
		
    //CREATE ACOUNT BUTTON UNDER ZIP WHIP POPUP TITLE 
		
		@FindBy(how=How.XPATH,using="//*[@id=\"btncreateaccount\"]")
		@CacheLookup  
		WebElement CreateacountButton ;
	
	//VALIDATION MESSAGE PLEASE ENTER ACOUNT NAME  
		
		@FindBy(how=How.XPATH,using="//p[@class='mr-0 alert-danger']")
		@CacheLookup  
		WebElement PleaseEnterAcountName ;
		
		
		
		
	
	//INITIALIZE ALL OBJECTS------------------------------ 
	
	public SMSConfigurationPage(){
		
		
		PageFactory.initElements(driver,this);
		
	}
	
	//ACTIONS----------------------------------------------	
	
	//ADD BUTTON ON SMS CONFIGRATION PAGE  
	
	public WebElement Addbutton(){
		
		return addbutton;
		
	}
	
    //ZIPWHIP SIGN UP POPUP TITLE	
	
	public WebElement ZipwhipSignUpPopupTitle (){
		
		return zipwhippopuptitle  ;
		 
	}
	
	
	//ACOUNT NAME TEXTFIELD ON ZIPWHIPPOPUP TITLE 
	
	public WebElement acountnametextfield (){
		
		
		return acountnametextfield ;
		
	}
	
	//CREATE ACOUNT BUTTON ON ZIPWHIP SIGNUP POPUP 
	
	public WebElement CreateAcountButtonOnZipwhipSignUpPopupTitle (){
		
		
		return CreateacountButton;
		
	}
	
	//VALIDATION MESSSAGE OF PLEASE ENTER ACOOUNT NAME  
	
	public WebElement ValidationMessagePlesaeEnterAccountName (){ 
		
		
		return PleaseEnterAcountName;
	
		
	}
	
	
}

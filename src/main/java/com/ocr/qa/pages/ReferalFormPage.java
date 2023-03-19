package com.ocr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ocr.qa.base.TestBase;

public class ReferalFormPage extends TestBase {

	
	//************P A G E F A C T R O Y*****************
	
	//NON-MANDATORY FIELDS UNDER INFORMATION SECTION ON REFERAL FORM PAGE 
	
	//DATE-OF-BIRTH
		@FindBy(how=How.XPATH,using="//*[@id=\"DetailId\"]/div[2]/label")
		@CacheLookup
		WebElement NmDateOfBirth;   
	
		
		
		

	//INITIALZATION OF ALL OBJECTS--------
	
		public ReferalFormPage(){
			
			PageFactory.initElements(driver, this);
			
		}
		
    //ACTION------  
	
	//NON-MANDATORY FIELDS UNDER INFORMATION SECTION ON REFERAL FORM PAGE  
		
	public WebElement NmDateOfBirthUnderInformationSection(){
		
		    
	 return	NmDateOfBirth ;
		
	}
		
		
	
}

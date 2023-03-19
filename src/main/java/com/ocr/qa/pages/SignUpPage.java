package com.ocr.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ocr.qa.base.TestBase;

public class SignUpPage extends TestBase{

	//***** P A G E - F A C T O R Y *****
	//PAGE TITLE
	@FindBy(how=How.XPATH,using="//h1[contains(@class,'mb-2')]")
	@CacheLookup
	WebElement pagetitle;


	//SELECTWHOAREYOU-LOGO-IMAGE
	  @FindBy(how=How.XPATH,using="//img[@src='/Content/Dashboard/images/logo.png']//parent::a[@class='mb-3']")
	  @CacheLookup
	  WebElement ocrimglogo;

	  //VALIDATION MSG ON FIRST NAME TEXTFIELD
	  @FindBy(how=How.XPATH,using="(//span[@class='text-danger'])[1]")
	  @CacheLookup
	  WebElement valdmsgfirstname;
	       
	 // FIRST NAME TEXTFIELD
	  @FindBy(how=How.XPATH,using="//*[@id=\"txtFirstName\"]")
	  @CacheLookup
	  WebElement firstnametextfield;
	 
	  //VALIDATION MSG ON LAST NAME TEXTFIELD
	  @FindBy(how=How.XPATH,using="(//span[@class='text-danger'])[2]")
	  @CacheLookup
	  WebElement valdmsglastname;
	 
	 // LAST NAME TEXTFIELD
	  @FindBy(how=How.XPATH,using="//*[@id=\"txtLastName\"]")
	  @CacheLookup
	  WebElement lastnametextfield;
	 
	 
	  //VALIDATION MSG ON WORK PHONE TEXTFIELD
	  @FindBy(how=How.XPATH,using="(//span[@class='text-danger'])[3]")
	  @CacheLookup
	  WebElement valdmsgworkphone;
	 
	// WORK PHONE TEXTFIELD
	  @FindBy(how=How.XPATH,using="//*[@id=\"txtWorkPhone\"]")
	  @CacheLookup
	  WebElement workphonetextfield;
	 
	 
	  //VALIDATION MSG ON EMAIL TEXTFIELD
	  @FindBy(how=How.XPATH,using="(//span[@class='text-danger'])[4]")
	  @CacheLookup
	  WebElement valdmsgemail;
	 
	// EMAIL TEXTFIELD
	  @FindBy(how=How.XPATH,using="//*[@id=\"txtEmail\"]")
	  @CacheLookup
	  WebElement emailtextfield;
	   
	 
	//VALIDATION MSG ON PASSWORD TEXTFIELD
	  @FindBy(how=How.XPATH,using="(//span[@class='text-danger'])[5]")
	  @CacheLookup
	  WebElement valdmsgpassword;
	 
	// PASSWORD TEXTFIELD
	  @FindBy(how=How.XPATH,using="//*[@id=\"txtPassword\"]")
	  @CacheLookup
	  WebElement passwordtextfield;
	 
	 
	//NEXT BUTTON ON SIGNUP PAGE
	  @FindBy(how=How.XPATH,using="//span[contains(text(),'Next')]")
	  @CacheLookup
	  WebElement Nextbuttton;
	 
	//SPECIALITY PAGE
	   //PREVIOUS BUTTON  
	  @FindBy(how=How.XPATH,using="//a[contains(text(),'Previous')]")
	  @CacheLookup
	  WebElement Spreviousbuttton;
	 
	    //FINISH BUTTON
	  @FindBy(how=How.XPATH,using="//span[contains(text(),'Finish')]")
	  @CacheLookup
	  WebElement Sfinsihbuttton;
	 
	//VALIDATION MSG ON SELECT A SPECIALTY TEXTFIELD
	  @FindBy(how=How.XPATH,using="(//span[@class='text-danger'])[1]")
	  @CacheLookup
	  WebElement ValdSelectspecialtyTextfield;  

	//SELECT A SPECIALTY TEXTFIELD  
	  @FindBy(how=How.XPATH,using="//select[@class='form-control custom-select ddlSpecialities select2-hidden-accessible' or @id='ddlSpecialities']")
	  @CacheLookup
	  WebElement SelectspecialtyTextfield;

	//PRACTICE NAME TEXTFIELD
	  @FindBy(how=How.XPATH,using="//div//input[@type='text' and @id='txtPracticeName']")
	  @CacheLookup
	  WebElement PracticenameTextfield;

	//TERMS AND CONDITIONS CHECKBOX
	  @FindBy(how=How.XPATH,using="//div//input[@type='checkbox' and @name='TermsConditions']")
	  @CacheLookup
	  WebElement TermsConditionsCheckbox;
	 
	//VALIDATION MSG ON TERMS AND CONDITIONS CHECKBOX  
	  @FindBy(how=How.XPATH,using="//div//p[@id='errorMessage']")
	  @CacheLookup
	  WebElement ValdTermsConditionsCheckbox;
	 
	 

	//INITIALIZING THE OBJECTS -------
	public SignUpPage(){

	PageFactory.initElements(driver,this);
	}


	//VALIDATION ON LOGO IMAGE
	  public boolean validatepageimglogo(){
	 
	    return ocrimglogo.isDisplayed();
	  }


	 //VALIDATION ON FIRST NAME TEXT FIELD
	 
	 public WebElement valdmsgfirstname(){
	 
	 
	 return valdmsgfirstname;
	 
	 }
	 
	     //FIRST NAME TEXT FIELD
	 
	 public WebElement firstnametextfield(){
	 
	 
	 return firstnametextfield;
	 
	 }
	 
	 
	 //VALIDATION MSG ON LAST NAME TEXTFIELD
	 public WebElement valdmsglastname(){
	 
	   
	 return valdmsglastname;
	 }
	 
	     //LAST NAME TEXT FIELD
	 
	 public WebElement lastnametextfield(){
	 
	 
	 return lastnametextfield;
	 
	 }
	 

	 //VALIDATION MSG ON WORK PHONE TEXTFIELD          
	 public WebElement valdmsgworkphone(){
	 
	 return valdmsgworkphone;
	 
	 }
	 
	      //WORK PHONE TEXTFIELD
	 
	 public WebElement workphonetextfield(){
	 
	 
	 return workphonetextfield;
	 
	 }
	 
	 
	      //VALIDATION MSG ON EMAIL TEXTFIELD
	      public WebElement valdmsgemail(){
	     
	    return valdmsgemail;
	     
	      }
	     
	     //EMAIL TEXTFIELD
	      public WebElement emailtextfield(){
	     
	    return emailtextfield;
	     
	      }
	     
	      //VALIDATION MSG ON PASSWORD TEXTFIELD
	      public WebElement valdmsgpassword(){
	     
	     return valdmsgpassword;
	     
	      }
	     
	    //PASSWORD TEXTFIELD
	      public WebElement passwordtextfield(){
	     
	     return passwordtextfield;
	     
	      }
	     
	     
	      //NEXT BUTTON ON SIGNUP PAGE  
	      public void NextButton(){
	     
	     ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
	     driver.findElement(By.xpath("//span[contains(text(),'Next')]")));
	     
	      }

	      //SPECIALITY PAGE
	      //PREVIOUS BUTTON
	      public WebElement Spreviousbuttton(){
	     
	     return Spreviousbuttton;
	     
	      }

	    //SPECIALITY PAGE
	      //FINISH BUTTON
	      public WebElement Sfinsihbuttton(){
	     
	     return Sfinsihbuttton;
	     
	      }
	     
	     
	    //VALIDATION MSG ON SELECT A SPECIALTY TEXTFIELD
	      public WebElement ValdSelectspecialtyTextfield(){
	     
	     return ValdSelectspecialtyTextfield;
	     
	     
	      }
	     
	    //PRACTICE NAME TEXTFIELD
	     public WebElement PracticeNameTextfield(){
	     
	     return PracticenameTextfield;
	       
	      }
	     
	    //TERMS AND CONDITIONS CHECKBOX  
	     public WebElement TermsConditionsCheckbox(){
	     
	     return TermsConditionsCheckbox;
	       
	     }
	     
	     //VALIDATION MSG ON TERMS AND CONDITIONS CHECKBOX  
	     public WebElement ValdTermsConditionsCheckbox(){
	       
	       return ValdTermsConditionsCheckbox;
	         
	      }
	   
	   
	   
	   
	   
	   
	   






	
	
}

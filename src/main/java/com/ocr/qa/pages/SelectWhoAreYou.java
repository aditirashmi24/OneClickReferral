package com.ocr.qa.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;


public class SelectWhoAreYou extends TestBase {
	
   //*****P A G E - F A C T O R Y*****
	
	  //SELECTWHOAREYOU-LOGO-IMAGE 
	    @FindBy(how=How.XPATH,using="//img[@src='/Content/Dashboard/images/logo.png']//parent::a[@class='navbar-brand']")
	    @CacheLookup 
	    WebElement ocrimglogo;
 
	  //SEARCH-FIELD
	    @FindBy(id="SearchText")
	    @CacheLookup
	    WebElement searchfield;
	  
	  //SEARCH-BUTTON 
	    @FindBy(how=How.XPATH,using="//a[@class='search-btn']")
	    @CacheLookup 
	    WebElement srchbtn;
	    
	  //PAGE TITLE 
		@FindBy(how=How.XPATH,using="//h1[contains(text(),'Select Who You Are')]")
		@CacheLookup
		WebElement Select;
		
	 //AFTER SEARCHING DENTIST NAME APPEARS
		@FindBy(how=How.XPATH,using="//h4[contains(text(),'')]//preceding::input[1]")
		@CacheLookup
		WebElement dentn;
	 
     //AFTER SEARCHING INVALID DENTIST NAME VALIDATION MESSAGE  
		@FindBy(how=How.XPATH,using="//p[contains(@id,'notfound')]")
		@CacheLookup 
		WebElement message; 
		
     //AFTER SEARCHING VALID DENTIST NAME APPEARS 
		
		@FindBy(how=How.CSS,using=".detail-box > h4:nth-child(1)")
		@CacheLookup
		WebElement vden;
		
	 //SIGNUP-LINKTAB 
		
		@FindBy(how=How.CSS,using="#Signup")
		@CacheLookup 
		WebElement signuplink;  
		
     //OCR PAGE LOGO AFTER CLICK ON SIGNUP LINK 
		
		//@FindBy(how=How.XPATH,using="//h2[contains(text(),'Try It For FREE')]")
		//@FindBy(how=How.CSS,using="h2.elementor-size-default")
		//@FindBy(how=How.CSS,using=".elementor-element-a295629 > div:nth-child(1)")
		@FindBy(how=How.XPATH,using="//h2[text()='Try It For FREE' and @class='elementor-heading-title elementor-size-default']")
		@CacheLookup 
		WebElement ocrtext;   
		
	 //LOGIN-BUTTON
		@FindBy(how=How.XPATH,using="//*[@id=\"logIn\"]")
		@CacheLookup
		WebElement login;  
		
		
   //INITIALIZING THE PAGE OBJECTS------------
		
		public SelectWhoAreYou(){
			
		PageFactory.initElements(driver,this);
				
		}
    //ACTION---------
		
		//VALIDATION ON PAGE TITLE
		public String validateselectwhoPageTitle(){
			
			return driver.getTitle();	
		}  
		
		//VALIDATION ON LOGO IMAGE
	    public boolean validatepageimglogo(){
	    	
	      return ocrimglogo.isDisplayed();
	    }  
	    
	    //ENTER INVALID DENTIST DETAILS ON SEARCH-FIELD
        public void invaliddentist(String invalid) throws InterruptedException{
			
			searchfield.sendKeys(invalid);
			Thread.sleep(2000);
			searchfield.clear();
		}
        
        //ENTER VALID DENTIST DETAILS ON SEARCH-FIELD
	    public void validentist(String valid) throws InterruptedException{
	    	
	    	searchfield.sendKeys(valid);
	    	Thread.sleep(3000); 
	    	srchbtn.click();
	    }
		
	    public String validateinvalid(){
	    	
	    	return message.getText();
	    } 
	    
	    public String validatevalid(){
	    	
	    	return vden.getText();
	    	
	    } 
	    
	    //---SIGNUP PAGE OPEN UP ON CLICKING SIGN UP LINK TAB
	    
	    public void signuplinktab() throws InterruptedException{
	    	
	    	Thread.sleep(2000);
	    	signuplink.click();
	    	
	    } 
	    
	   //---OCR PAGE OPENS UP AFTER CLICKING  SIGN UP LINK TAB
	      
        public String ocrsignup(){
        	
        	return ocrtext.getText();
        	
        }
	    
       //---RECORDLINC SIGNUP PAGE 
        public String rcordlincsignup(){
        	
        	
        	return driver.getTitle();
        }
        
	    //CLICK ON LOGIN BUTTTON
		public Loginpage loginbtn() throws InterruptedException{
			
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
		    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(login))
			.click();
			
		    
			return new Loginpage();
		}
		
		//CLICK ON SIGNUP BUTTTON
		   public SignUpPage Signupbtn() throws InterruptedException{

		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		   wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(signuplink))
		.click();

		   
		return new SignUpPage();
		}

	
		
		//PUBLIC VOID lOGIN BTN 
		public void loginbtnn() throws InterruptedException{
			
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
		    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(login))
			.click();
			
			
		}
		
		
		
		
		
}

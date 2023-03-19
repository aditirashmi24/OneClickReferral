package com.ocr.qa.pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;


import junit.framework.Assert;

public class Patienthistorypage extends TestBase  {
    
	String APname = prop.getProperty("AppearPatientNameinPatientHistorypage") ;
	String PatientFirstName = prop.getProperty("FirstnameinPatientforms");
	String APname2 = "Carrymanati" ;
	String addrs = "SYDNEYSTREET121";
	String Patientrefpopuptitele = "Patient referral from";
	
	//Patient Page
	//VERTICAL ELIPSE ICON ON PATIENTS PAGE 
		@FindBy(how=How.CSS,using=".fa-ellipsis-v")
		@CacheLookup 
		WebElement verellbtn;
    //ADD PATIENT BUTTON 
		
		@FindBy(how=How.CSS,using="a.btn")
		@CacheLookup 
		WebElement addbtn;
		//FirstName in SearchField on Add-patient page 
		
		@FindBy(how=How.XPATH,using="//input[contains(@name,'FirstName')]")
		@CacheLookup 
		WebElement ENTRFIRSTNAME;
		
		//LastName in SearchField on Add-patient page
		
		@FindBy(how=How.XPATH,using="//input[contains(@name,'LastName')]")
		@CacheLookup 
		WebElement ENTRLASTNAME;
		
		//Gender in SelectField on Add-patient page
		
	   // @FindBy(how=How.XPATH,using="//input[contains(@name,'LastName')]")
	    //@FindBy(how=How.XPATH,using="//option[contains(text(),'Select Gender')]")
	    @FindBy(how=How.CSS,using="#Gender")
		@CacheLookup 
	    WebElement SELECTGENDER;
		
	   //Click on 'Save' button on Add-patient page
		
	    @FindBy(how=How.XPATH,using="//a[contains(text(),'Save')]")
		@CacheLookup 
	    WebElement Savebutton;
		
	   //Success message after adding patient 
	    
	 //   @FindBy(how=How.XPATH,using="//span[contains(text(),'Patient added successfully')]")
	    @FindBy(how=How.CLASS_NAME,using="message")
		@CacheLookup 
	    WebElement Successmessage;
	    
	   //Added Patent name appears   
	   // @FindBy(how=How.XPATH,using="//*[@id=\"main\"]/div/div/div[2]/div/div[1]/div/div/h2/a") 
	    @FindBy(how=How.XPATH,using="//a[contains(text(),'David')]") 
		@CacheLookup 
	    WebElement addedpatientname;
	    
	   //Search field on patient page     
	    
	  //SEARCH PATIENTS SEARCHFIELD 
		@FindBy(how=How.CSS,using="#txtSearchPatients")
		@CacheLookup 
		WebElement  searchfield; 
		
		//SEARCH ICON ON SEARCHFIELD 
		@FindBy(how=How.CLASS_NAME,using="icon-search")
		@CacheLookup 
		WebElement Searchicon;
	    
		//PATIENT FIRST NAME 
		@FindBy(how=How.XPATH,using="//a[contains(text(),'David')]") 
		@CacheLookup 
	    WebElement PatFistName;
	    
	    
		
		
		
//----------PATIENT HISTORY TITLE 
	@FindBy(how=How.XPATH,using="//h1[@class='inline' and text()='Patient History']")
	@CacheLookup
	WebElement title;  
	
	//PATIENT NAME APPEARS ON PAGE 
	@FindBy(how=How.CSS,using="#main > div > div > div:nth-child(2) > div > div.row > div > div > h2 > span")
	@CacheLookup
	WebElement patientname; 
	
	//CLICK ON IMAGE ICON 
//	@FindBy(how=How.CSS,using="#main > div > div > div:nth-child(2) > div > div.user > a > img")
	@FindBy(how=How.XPATH,using="//a[@href='#addLogo']") 
	@CacheLookup 
	WebElement imageicon;
	
	//UPLOAD PROFILE PICTURE POPUP 
	@FindBy(how=How.XPATH,using="//h3[contains(text(),'Upload Profile Picture')]")
	@CacheLookup 
	WebElement popuptitle;
	
	//CHOOSE FILE BUTTON
	@FindBy(how=How.XPATH,using="//*[@id=\"frmPatientProfileImage\"]/div[1]/div[2]/div/ul/li")
	//@FindBy(how=How.ID,using="fuImage")
	//@FindBy(how=How.CSS,using="#fuImage")
	@CacheLookup 
	WebElement Choosefilebtn;
	
	//SCROLL IMAGE 
	@FindBy(how=How.XPATH,using="//*[@id=\"cropDisplay\"]/div/div[1]/div[2]/div[11]")
	@CacheLookup 
	WebElement Cropimg;
	
	//UPLOADED IMAGE SAVE BUTTON 
	@FindBy(how=How.XPATH,using="//*[@id=\"btnSave\"]")
	@CacheLookup 
	WebElement Uploadimgsavebtn;
	
	//VALIDATION MESSAGE AFTER UPLOADING IMAGE 
//	@FindBy(how=How.XPATH,using="//span[contains(text(),'Image uploaded successfully.')]")
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup
	WebElement valduplodmessage;
	
	
	//CLICK ON  EMAIL ID  
	@FindBy(how=How.CSS,using="#phEmailID")
	@CacheLookup 
	WebElement emailid;
	
	//UPDATE EMAIL ID 
	@FindBy(how=How.CSS,using="#update_emailId")
	@CacheLookup 
	WebElement updateid; 
	
	//REFER PATIENT ICON   
	@FindBy(how=How.LINK_TEXT,using="Refer Patient")
	@CacheLookup 
	WebElement referpatienticon;
	
	//SEND REFFERAL PAGE TITLE 
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Send Referral')]") 
	@CacheLookup  
	WebElement pagetitle;  
	
	//PATIENT FORM ICON   
	@FindBy(how=How.LINK_TEXT,using="Patient Forms") 
	@CacheLookup  
	WebElement patientformsicon;  
	
	//PATIENT FORM SECTION TITLE
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Patient Forms')]") 
	@CacheLookup  
	WebElement patfortitle; 
	
	//SEARCH FIELD ON COMMUNICATION SECTION  
	@FindBy(how=How.CSS,using=".ico-form-patient") 
	@CacheLookup  
	WebElement serchfieldcom;  
	
	//SEND BUTTON UNDER MESSAGE SECTION 
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Send')])[3]")
	//@FindBy(how=How.CSS,using=".ico-send1")
	//@FindBy(how=How.CLASS_NAME,using="ico-send1")
	//@FindBy(how=How.XPATH,using="//div/a[contains(text(),'Send')]")
	//@FindBy(how=How.XPATH,using="//*[@id=\"ComposeSection\"]/div[3]/div/form/div/div/div/div[2]/a")
	@CacheLookup
	WebElement send;
	
	//SuccessMessageAfterSendMessage 
  //@FindBy(how=How.XPATH,using="//span[contains(text(),'Message sent successfully')]")
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup
	WebElement comsuccessmessage;
	
	
	//PRINT ALL BUTTON ON COMUNICATION SECTION 
	@FindBy(how=How.CSS,using="#_printCommunication") 
	@CacheLookup  
	WebElement printallbtn;  
	
	// SEARCHFIELD UNDER COMUNICATION SYSTEM  
    @FindBy(how=How.XPATH,using="//input[@class='select2-search__field']")
	@CacheLookup 
	WebElement comserchfield;  
	
    
	//After search name appears
	//@FindBy(how=How.XPATH,using="(//li[@class=\"select2-results__option select2-results__option--highlighted\"])[1]")
	@FindBy(how=How.CSS,using="#select2-selectTeam-results > li")
	@CacheLookup 
	WebElement list; 
	
	
	//ENTER MESSAGE FIELD UNDER COMUNICATION SYSTEM 
	@FindBy(how=How.XPATH,using="//textarea[@class='form-control' and @id='txtMessageFromPatientHistory']")
	@CacheLookup 
	WebElement entermsgcom;
	
	//REFERRAL TYPE UNDER COMUNICATION HISTORY SECTION 
	@FindBy(how=How.LINK_TEXT,using="Referral")
	@CacheLookup 
	WebElement Referraltype;
	
	
	//AFTER CLICK ON REFERRAL TYPE TEXT APPEARS REFERRED BY 
	@FindBy(how=How.XPATH,using="//dt[text()='Referred by:']")
	@CacheLookup
	WebElement ReferredBy;
	
	
	//MESSAGE TYPE UNDER COMUNICATION HISTORY SECTION  
//	@FindBy(how=How.LINK_TEXT,using="Message")
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Message')])[1]")
	@CacheLookup 
	WebElement Messagetype;
	
	//AFTER CLICK ON Message TYPE TEXT APPEARS MEssages 
	@FindBy(how=How.XPATH,using="//h3[@class='modal-title white' and text()='Messages']")
    @CacheLookup
    WebElement meesagestext;
    
	//[PRINT] LINK INSIDE ACTIONS UNDER COMUNICATION HISTORY SECTION  
	@FindBy(how=How.LINK_TEXT,using="[Print]")
	@CacheLookup 
	WebElement Actionlink;
	
	//EXPORT FILE BUTTON UNDER PATIENT FILES SECTION  
	@FindBy(how=How.CSS,using="#_downloadZip > div:nth-child(1) > a:nth-child(1)")
	@CacheLookup 
	WebElement exportbtn;
	
	//ATTACH FILE BUTTON UNDER PATIENT FILES SECTION  
	@FindBy(how=How.CSS,using="#upfile")
	@CacheLookup 
	WebElement attachfilesbtn;
	
	//UPLOADING INVALID FORMATE FILE UNDER PATIENTS FILES SECTION
//	@FindBy(how=How.XPATH,using="//span[contains(text(),'Invalid file type.')]")
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup
	WebElement Invalidfiletype;
	
	
	//DOWNLOAD FILE BUTTON ON ATTACHED FILE
	@FindBy(how=How.CSS,using=".aDownload")
	@CacheLookup 
	WebElement Downloadbtn;
	
	
	//DELETE BUTTON FOR ATTACHED FILE
	@FindBy(how=How.CSS,using=".fa-trash")
	@CacheLookup 
	WebElement Deletebtn;
	
	//PERSONAL INFO SUB TAB UNDER PATIENT FORMS SECTION  
	@FindBy(how=How.CSS,using="#PatientInfo")
	@CacheLookup 
	WebElement personalinfo;
	
	//PATIENT  INFORMATION TEXT APPEARS UNDER PERSONAL INFO SECTION
	@FindBy(how=How.XPATH,using="//p[contains(text(),'Patient Information')]")
	@CacheLookup
	WebElement patientinformationtext;
	
	
	//*FIRST NAME SEARCHFIELD IN PERSONAL INFO SUBTAB
	@FindBy(how=How.CSS,using="#FirstName")
	@CacheLookup 
	WebElement firstname;
		
	//VALIDATION MESSAGE ON MANDATORY FIELD/FIRST NAME
  //@FindBy(how=How.XPATH,using="//span[contains(text(),'Please enter First Name.')]")
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement valdfstn;
	
	//*LAST NAME SEARCHFIELD IN PERSONAL INFO SUBTAB
    @FindBy(how=How.CSS,using="#LastName")
	@CacheLookup 
	WebElement lastname;	
		
	//VALIDATION MESSAGE ON MANDATORY FIELD/LAST NAME 
  //@FindBy(how=How.XPATH,using="//span[contains(text(),'Please enter Last Name.')]")
    @FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement valdlstn;
	
	//SUBMIT BUTTON UNDER PATENT INFORMATION   
    @FindBy(how=How.CSS,using="div.btn-group:nth-child(10) > a:nth-child(1)")
	@CacheLookup 
	WebElement submitbtn;
		
    //SUCCESS MESSAGE AFTER ENTERING VALID DETAILS
  //@FindBy(how=How.XPATH,using="//span[contains(text(),'Details updated successfully')]")
    @FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement successmeassage;
    
    
    
	//DENTAL INSURANCE SUB-SECTION TAB  
    
    @FindBy(how=How.XPATH,using="//a[contains(text(),'Dental Insurance ')]")
	@CacheLookup 
	WebElement Dentalinsurance;
			
	//PRIMARY DENTAL INSURANCE  
    //INSURANCE COMPANY  
    @FindBy(how=How.CSS,using="#PrimaryInsuranceCompany")
   	@CacheLookup 
   	WebElement PInsurancecomp;
		
    // NAME OF INSURED 
    @FindBy(how=How.CSS,using="#PrimaryNameOfInsured")
   	@CacheLookup 
   	WebElement Nameofinsured;	
	
    //INSURANCE SUBMIT BUTTON 
   // @FindBy(how=How.CLASS_NAME,using="btn btn-default btn2")
   @FindBy(how=How.CSS,using="div.btn-group:nth-child(9) > a:nth-child(1)")
   	@CacheLookup 
   	WebElement InsSubmitbtn;
    
    //SUCCESS MESSAGE AFTER INSURANCE SUBMIT BUTTON  
   // @FindBy(how=How.XPATH,using="//span[contains(text(),'Details updated successfully')]")
         @FindBy(how=How.CLASS_NAME,using="message")
	     @CacheLookup 
	     WebElement sucmsgins;
	
  //enter ADDRESS FIELD 
  		//@FindBy(how=How.XPATH,using="//*[@id=\"update_dobId\"]")  
  	//	@FindBy(how=How.XPATH,using="//span[contains(text(),'Please enter address')]")
  		@FindBy(how=How.XPATH,using="//span[@id='phAddressId' and @class='ctrl-edit-label']")
  		@CacheLookup 
  	    WebElement enterAddrsfield; 
  	//Address field  
  		
  		@FindBy(how=How.XPATH,using="//input[@class='form-control' and @id='update_addressId']")  
  		@CacheLookup 
  		WebElement addressfield; 
  //enter Phone number 
  		//@FindBy(how=How.XPATH,using="//span[contains(text(),'Please enter phone number')]")
  		@FindBy(how=How.XPATH,using="//span[@id='phPhoneID' and @class='ctrl-edit-label']")
  		@CacheLookup 
  	    WebElement pleaseenterphonenumber; 
  		
   //phone number 
  		
  		@FindBy(how=How.XPATH,using="//input[@class='form-control' and @id='update_phoneId']")  
  		@CacheLookup 
  		WebElement phonenumber;  
  	
  	
   
  		
    //INITIALIZE ALL OBJECTS  
    public Patienthistorypage(){
    	
    	PageFactory.initElements(driver,this);
    	
    	
    }
    
    //Verify that user is able to add patient   
   
    public void addPatient () throws InterruptedException{
    	   
    	  
		   try{
			    WebDriverWait wait=new WebDriverWait(driver, 60);

			       wait.until(ExpectedConditions.visibilityOfElementLocated(
			    		By.linkText("Add Patient")) 
			       ).click();

			    }
			    catch(Throwable t){
			        System.out.println("The execption is: " + t);
			    }
			    finally {
			        System.out.println("If no exception tell me now");
			    } 
		   Thread.sleep(3000);
    	   ENTRFIRSTNAME.sendKeys("David");
    	   Thread.sleep(2000);
		   ENTRLASTNAME.sendKeys("Miller"); 
		   Thread.sleep(2000);
		   Select sel = new Select(SELECTGENDER); 
		   Thread.sleep(2000);
		   sel.selectByVisibleText("Male");  
		   Thread.sleep(2000);
		   Actions actions = new Actions(driver);
		   actions.moveToElement(Savebutton).perform();
		   
		//   Savebutton.click();
		  
		   try{
			    WebDriverWait wait=new WebDriverWait(driver, 30);

			       wait.until(ExpectedConditions.visibilityOfElementLocated(
			    		By.xpath("//a[contains(text(),'Save')]"))   
			       ).click();

			    }
			    catch(Throwable t){
			        System.out.println("The execption is: " + t);
			    }
			    finally {
			        System.out.println("If no exception tell me now");
			    } 
   
    }
    
    public WebElement succesmsg(){
    	
    	return Successmessage;
    	
    }
    
    
    
    //Upload profile picture popup icon open up on clicking imge icon 
    
    public String profilepicticon() throws InterruptedException{
    	
    	imageicon.click();
    	Thread.sleep(2000);
        return popuptitle.getText();
    	
    	
    }
    
    public WebElement  addedpatientnameappears(){
    	
      WebElement detail =  driver.findElement(By.linkText(APname));
      return detail; 
      
    }
    
    
   public void searchpatient() throws InterruptedException{
	   
	   searchfield.sendKeys(APname);
	   Thread.sleep(2000);
	   Searchicon.click();
	 
	   Thread.sleep(7000);
	  //PatFirstName 
	   WebElement patfirstname = driver.findElement(By.xpath("//a[contains(text(),'"+PatientFirstName+"')]"));
	   patfirstname.click();
	    
	 //  PatFistName.click();  
	   Thread.sleep(15000);
	  // enterAddrsfield.
	  Actions actions = new Actions(driver);
      actions.doubleClick(enterAddrsfield).perform();
	  Thread.sleep(1000);
	  addressfield.sendKeys(Keys.BACK_SPACE);
	  Thread.sleep(1000);
	  addressfield.sendKeys("SYDNEYSTREET121");  
	   
	 Thread.sleep(2000);
	//  pleaseenterphonenumber.click();  
	//  Actions actions1 = new Actions(driver);
	  actions.doubleClick(pleaseenterphonenumber).perform();
	  Thread.sleep(1000);  
	  phonenumber.sendKeys(Keys.BACK_SPACE);
	  Thread.sleep(1000);
	  phonenumber.sendKeys("2231213343");  
	  Thread.sleep(2000);
	  title.click();
	
   }
   
   public void referpatienticon() throws InterruptedException{
	   searchfield.sendKeys(APname);
	   Thread.sleep(3000);
	   
	   try{
		    WebDriverWait wait=new WebDriverWait(driver, 60);
            //SearchIcon       
		    
		       wait.until(ExpectedConditions.visibilityOfElementLocated(
		    		By.className("icon-search"))).click();

		    }
		    catch(Throwable t){
		        System.out.println("The execption is: " + t);
		    }
		    finally {
		        System.out.println("If no exception tell me now");
		    } 
	   
	 //  Searchicon.click();
	 
	           Thread.sleep(7000);
	  //PatFirstName 
	           driver.findElement(By.xpath("//a[contains(text(),'"+PatientFirstName+"')]")).click();
	 //  PatFistName.click();  
	   
           //SearchIcon       
		    	//	By.linkText("Refer Patient")) 
		    	//	   By.className("ico-add-plan refer-patient"))
		    Thread.sleep(2000);	
		    WebElement elm =  driver.findElement(By.xpath("//a[@class='btn-default btn-cases']"));
		    WebDriverWait wait = new WebDriverWait(driver, 60);
		    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elm))
		    .click();
			
			
          
		      

		   
	//   referpatienticon.click();
	   
	   
   }
    public String sendreferralpagetitle(){
    	
    	return pagetitle.getText(); 
    	
    }
	
    public void patientformicon() throws InterruptedException{
       searchfield.sendKeys(APname);
 	   Thread.sleep(2000);
 	   Searchicon.click();
 	  // list.click();
 	     
 	   
 	   
 	  try{
		    WebDriverWait wait=new WebDriverWait(driver, 30);
		  //PatFirstName 
		       wait.until(ExpectedConditions.visibilityOfElementLocated(
		    		By.xpath("//a[contains(text(),'"+PatientFirstName+"')]")) 
		       ).click();

		    }
		    catch(Throwable t){
		        System.out.println("The execption is: " + t);
		    }
		    finally {
		        System.out.println("If no exception tell me now");
		    } 
 	   
 	  //PatFirstName 
 	 // driver.findElement(By.xpath("//a[contains(text(),'"+PatientFirstName+"')]")).click();
 	 //  PatFistName.click();  
    	
 	 try{
		    WebDriverWait wait=new WebDriverWait(driver, 30);
		  //PatientFormIcon 
		       wait.until(ExpectedConditions.visibilityOfElementLocated(
		    		By.linkText("Patient Forms")) 
		       ).click();

		    }
		    catch(Throwable t){
		        System.out.println("The execption is: " + t);
		    }
		    finally {
		        System.out.println("If no exception tell me now");
		    } 
 	    //	patientformsicon.click();
    	
    	
    }
    
    public String verifypatientformsection(){
    	
    	
    	return patfortitle.getText();
    	
    }
    
   public void verifyprintallbuttonotfuctional() throws InterruptedException{
	   
	   addbtn.click();
	   Thread.sleep(3000);
	   ENTRFIRSTNAME.sendKeys("David");
	   Thread.sleep(3000);
	   ENTRLASTNAME.sendKeys("kilt"); 
	   Thread.sleep(3000);
	   Select sel = new Select(SELECTGENDER); 
	   Thread.sleep(2000);
	   sel.selectByVisibleText("Male");  
	   Thread.sleep(2000);
	   Actions actions = new Actions(driver);
	   actions.moveToElement(Savebutton).perform();
	   Savebutton.click();
	   Thread.sleep(5000);
	   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
   }
  public WebElement printallbtn(){
	  
      return printallbtn ;
	  
  }   
  
  public boolean printallbtncliclickableornot(){
	  
	  
	return  printallbtn.isEnabled();
	  
  }
  
  
  
  
  public void AddedColleaguesnameonEnteringCharacter(String name) throws InterruptedException{
	  
	   WebDriverWait wait = new WebDriverWait(driver, 60);
	   wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(searchfield))
	   .sendKeys(APname);
	  
	   Thread.sleep(5000);
	   
	   //SEARCH ICON
	   WebDriverWait wait1 = new WebDriverWait(driver, 60);
	   wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Searchicon))
	   .click();
	   
	   Thread.sleep(10000);
	  //PatFirstName 
	   driver.findElement(By.xpath("//a[contains(text(),'"+PatientFirstName+"')]")).click();
	   JavascriptExecutor js =(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,200)");
	   
	   WebDriverWait wait2 = new WebDriverWait(driver, 60);
	   wait2.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(comserchfield))
	   .sendKeys(name);
	   
	   Thread.sleep(5000);
	   
	   WebDriverWait wait3 = new WebDriverWait(driver, 60);
	   wait3.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(list))
	   .click();
	   
	  
  }    
  
  public void AddedColleaguesnameonEnteringCharacter2(String name) throws InterruptedException{
	  
	   WebDriverWait wait = new WebDriverWait(driver, 60);
	   wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(searchfield))
	   .sendKeys(APname2);
	  
	   Thread.sleep(10000);
	 //SEARCH ICON
	   WebDriverWait wait1 = new WebDriverWait(driver, 60);
	   wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Searchicon))
	   .click();
	   
	  //PatFirstName 
	   Thread.sleep(12000);
	 //  driver.findElement(By.xpath("//a[contains(text(),APname2)]")).click();
	  WebElement nam = driver.findElement(By.linkText(APname2));
	  WebDriverWait wait4 = new WebDriverWait(driver, 60);
	  wait4.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(nam))
	  .click();
	  
	  
	   JavascriptExecutor js =(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,200)");
	  
	  WebDriverWait wait2 = new WebDriverWait(driver, 60);
	  wait2.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(comserchfield))
	  .sendKeys(name);
	  
	  Thread.sleep(2000);
	  WebDriverWait wait3 = new WebDriverWait(driver, 60);
	   wait3.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(list))
	   .click();
	  
  }    
  public void MoreAddedColleaguesnameonEnteringCharacter(String name) throws InterruptedException{
	  
	  //comserchfield.sendKeys(name+Keys.ENTER);

	   WebDriverWait wait2 = new WebDriverWait(driver, 60);
	   wait2.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(comserchfield))
	  .sendKeys(name);
	  Thread.sleep(3000);
	  comserchfield.sendKeys(name+Keys.ENTER);
	  Thread.sleep(2000);
	  
  }
  
  
  
  
  public void entermsgundercomunicationsection() throws InterruptedException{
	  
	  
	  entermsgcom.sendKeys("this is a message section under communication system");
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  
	    JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,100)");
	  
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(send))
		.click();
	  
	  
	 
	  
  }
  
  public String successmessageaftersendmessage(){
	  
	  return comsuccessmessage.getText();
	  
  }
  
  public void Referral_Type(){
	  
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Referraltype))
	  .click();
	  
  }
  
  public String PatientReferralPopupTitle (){
	  
	  
	  return driver.findElement(By.xpath("//h3[contains(text(),'Patient referral from"+" "+prop.getProperty("Fullname")+"')]")).getText();
	 // return driver.findElement(By.xpath("//h3[contains(text(),'Patient referral from Levin Q ')]")).getText();
  }
  
  
  
  public void Message_Type(){
	  
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Messagetype))
	  .click();
	     
  }
  
  public String messagestext(){
	  
	 return meesagestext.getText();
	  
  }
  
  public void printlinkmessagetype(){
	  
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Actionlink))
	  .click();
	  
  }
  
  public boolean assertomnprintlinkmessagetype(){
	  
	return  Actionlink.isEnabled();
	  
	  
  }
  
  public void Exportfilebutton(){
	  
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(exportbtn))
	  .click();
  }
  
  public void Attachfilesbutton() throws InterruptedException{
	  
	//  attachfilesbtn.click();
	  
	  
	  
	  Actions act = new Actions(driver);
	  act.moveToElement(driver.findElement(By.xpath("//a[@class='reply-btn' and @id='upfile']"))).perform();
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector("#upfile")).click();
	  
	  /*
	  try{
		    WebDriverWait wait=new WebDriverWait(driver, 30);

		       wait.until(ExpectedConditions.visibilityOfElementLocated(
		    		By.cssSelector("#upfile"))   
		       ).click();
		       
		    }
		    catch(Throwable t){
		        System.out.println("The execption is: " + t);
		    }
		    finally {
		        System.out.println("If no exception tell me now");
		    }     
	  */
  }
  
  public Boolean AssertAttachfilesbutton(){
	  
	  return attachfilesbtn.isEnabled();
	  
  }
  
  public WebElement ValidationMessageOnInvalidFile(){
	  
	  
	   return  Invalidfiletype;
	  
  }
  
  
  
  public void Downloadicon(){
	  
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Downloadbtn))
	  .click();
	  
  }
  
  public boolean Downloadiconisclickable(){
	  
	  
	return  Downloadbtn.isEnabled();
	  
  }
   
  public boolean Downloadiconisdisplayed(){
	  
	  
	  return Downloadbtn.isDisplayed();
	  
  }
  public WebElement Deleteicon(){
	  
	  
	  WebElement Deletebtn = driver.findElement(By.cssSelector(".fa-trash"));
	  
	  return Deletebtn ;
	 
  }
  
  public boolean Deleteiconisclickable(){
	  
	  
	  return Deletebtn.isEnabled();
	  
  }
  
  
  
  public void perosnalinfosectionunderPatientsForms(){
	  
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(personalinfo))
	  .click();
	  
  }
  
  public String patientinformationtextappears(){
	  
	  
	 return  patientinformationtext.getText();
	  
  }
  
  public void LastName(){
	  
	  lastname.clear();
	    
  }
  
  public void FirstName(){
	  
	  firstname.clear();
	  
  }
  
  public void FirstName1(){
	  
	  firstname.sendKeys(prop.getProperty("FirstnameinPatientforms"));
	  
  }
  
  
  public void submitbutton(){
	  
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(submitbtn))
	  .click();
  }
  
  public String validationOnmessageAfterblankFirstNameMandField(){
	  
	  return valdfstn.getText();
	  
	  
  }
  
  
  public String validationmessageafterblankmandatoryfield(){
	  
	 return valdlstn.getText();
	  
  } 
 public void LastNamedata(){
	 
	 WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(lastname))
	  .sendKeys("BAKHAM");
	 
 }
  public WebElement successmessageafterEnteringvaliddetailsinmandatoryfields(){
	 
	   return successmeassage;
	 
 }
 
  public void DentalInsurance(){
	 
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Dentalinsurance))
	  .click();
	  
  }
  
  public void InsuranceCompanyName(){
	  
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(PInsurancecomp))
	  .clear();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 60);
	  wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(PInsurancecomp))
	  .sendKeys("ICCC");
	  
	  
  }
  public void NameOfInsured(){
	  
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Nameofinsured))
	  .clear();
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 60);
	  wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(PInsurancecomp))
	  .sendKeys("Mark");
	  
	  
  }
  public void InsuranceSubmitbtn(){
	  
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(InsSubmitbtn))
	  .click();
  }
  
  public String InsSuccesMessage(){
	  
	  
	  return sucmsgins.getText();
	  
  }
  
  public void choosefilebutton (){
	  
	// Choosefilebtn.click();
	// driver.findElement(By.cssSelector("#fuImage")).click();  
	   Actions actions = new Actions(driver);
	   actions.moveToElement(Choosefilebtn).perform();
	   Choosefilebtn.click();
	 
	 
	 
  }
  public void uploadimgsavebtn(){
	  
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Uploadimgsavebtn))
	  .click();
	  
  }   
  
  public String ValidationMessageAfterUploadingSavbtn(){
	  
	  
	return valduplodmessage.getText();
	
	
  }
  
  
  public void draganddrop(){
	  
	  
	  Actions crop = new Actions(driver);
	crop.dragAndDropBy(Cropimg,30,220).perform();  
  }   
  
  
  public String addressfieldtext(){
	  
	  return enterAddrsfield.getText();
	//  return addressfield.getText();
	 // return driver.findElement(By.xpath("//input[contains(text(),'"+addrs+"')]")).getText();
	 // return	driver.findElement(By.xpath("//a[contains(text(),'"+prop.getProperty("Anycolleageemail")+"')]")).getText();
		
  }
  
  public String phonenumbertext(){
	  
	  return phonenumber.getText();
	  
	  
  }
 //Colleagues appears after search colleagues by character
  
  public String colleaguesappearaftersearchbycharacter(){
	  
	  return driver.findElement(By.xpath("(//li[contains(text(),'"+prop.getProperty("AddedcolleagenameinPatientHistorypage")+"')])[1]")).getText();
	  
  }
  
  public String colleaguesappearaftersearchbycharacter2(){
	  
	  return driver.findElement(By.xpath("//li[contains(text(),'"+prop.getProperty("AddedcolleagenameinPatientHistorypage1")+"')]")).getText();
	//return driver.findElement(By.xpath("//li[contains(text(),'"+prop.getProperty("Addedcolleagename4")+"')]")).getText();
	  
  }
  
  //First Name Autofill in Patient Information section under Personal Info (PATIENT FORMS)
  
  public String firstnameunderprsonalinfoinPatientForms(){
	  
	  
	//  return driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).getText();
	//  return driver.findElement(By.xpath("//input[@id='FirstName' and @value='"+prop.getProperty("firstnameinPatientinformationunderpatinetforms")+"']")).getText();
	//  return driver.findElement(By.cssSelector("#FirstName")).getText();  
	 // return driver.findElement(By.xpath("//input[@value='David' and @id='FirstName']")).getText();  
	  
	//  WebElement firstName = 
		return	  driver.findElement(By.xpath("//input[@name='FirstName']")).getAttribute("value");
	 // String value = firstName.getText();
	 // System.out.println(value);
	//return value;
	  
  }
  
  public String lastnameunderprsonalinfoinPatientForms(){
	  
	  
	  return driver.findElement(By.xpath("//input[@name='LastName']")).getAttribute("value");
	  
	  
  }
  
//VALIDATE LATEST FILE DOWNLOADED ON THE PAGE 
  
public File getLatestFilefromDir(String dirpath){
	
	File dir = new File(dirpath);
    File[] files = dir.listFiles();
    if (files == null || files.length == 0) {
        return null;
    }

    File lastModifiedFile = files[0];
    for (int i = 1; i < files.length; i++) {
       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
           lastModifiedFile = files[i];
       }
    }
    return lastModifiedFile;
	
	

}
  
}

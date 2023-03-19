package com.ocr.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.base.TestBase;
import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Dashboardpage;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.Patientspage;
import com.ocr.qa.pages.SelectWhoAreYou;


public class PatientspageTest extends TestBase {
	
	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Patientspage patpage;
	Closethebot bot;


	//CREATE A CONSTRUCTOR
	
	public  PatientspageTest(){
		
		super();
		
	}
	
    //ALL THE TEST CASES SEPRATED AND INDEPENDENT TO EACH OTHER
	
	//CREATE SETUP METHOD 
	@BeforeMethod
	public void PatientPage_SetupMethod() throws InterruptedException{
		
		
		initialization();
		
		patpage = new Patientspage();
		Swatpage= new SelectWhoAreYou();
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
	  	
	  	dashb= new Dashboardpage() ;
	    dashb = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	    Thread.sleep(17000);
	    //CLOSE THE CHAT BOT 
	    
	    bot.Closing_the_bot();
	    Thread.sleep(2000);
		patpage =  dashb.clickonpatientslink();
		Thread.sleep(5000);
	}
	
	//QUIT METHOD FOR QUIT TEST CASES 
	@AfterMethod 
	public void TestCase_QuitMethod(){
		
		driver.quit();
		
	}   
	
    @Test(priority=1)
    public void PatientsPageOpensUpOnClicking_PatientsLinkOnTheHeader() throws InterruptedException{
    	//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
    	Thread.sleep(2000);
    	String firstname = patpage.verifypatientspage();
    	System.out.println(firstname);
    	Assert.assertEquals(firstname,"Patients","Title Mismatched");
    		
    } 
    
    
    @Test(priority=2)  
	public void DentistIsAbleToSortTheRecordsOnClicking_FirstNameLastNameSortingIconsOnPatientPage()throws InterruptedException{
    	//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
    	Thread.sleep(2000);
        patpage.verticalelipseandaddbtn();
    	
    	Thread.sleep(3000);
    	patpage.AddPatientFirstNameOnSortingOrder(); 
    	
    	Thread.sleep(10000);
    	
    	loginpage.ExplicitWait(patpage.FirstNameClick());
	    Thread.sleep(5000);
		String ss = loginpage.ExplicitWaitGetText(patpage.FirstNamesortingBy1());
	    System.out.println(ss);
		Assert.assertEquals(ss, "1","SORTING VALUE MISMATCHED");
		Thread.sleep(4000);
		String last1= loginpage.ExplicitWaitGetText(patpage.LastNameByInt());
		System.out.println("Last name is"+last1);
		Thread.sleep(5000);
		Assert.assertEquals(last1, "1","SORTING VALUE MISMATCHED");
		
        Thread.sleep(5000);
        
   
        WebElement btn= driver.findElement(By.linkText("Add Patient"));
        loginpage.ExplicitWait(btn);
         
    	Thread.sleep(3000);
   	
		patpage.AlphabeticallytAddPatientFirstNameOnSortingOrder();
        Thread.sleep(10000);
    	
	    WebElement lastname = driver.findElement(By.xpath("//span[contains(text(),'Last Name')]"));
	    loginpage.ExplicitWait(lastname);
        
	    Thread.sleep(4000);
	    String last =   loginpage.ExplicitWaitGetText(patpage.LastNamesortingByZ());
		Assert.assertEquals(last, "Zzzz","SORTING VALUE MISMATCHED"); 
		System.out.println(last);
	    Thread.sleep(4000);
	    String ss1= loginpage.ExplicitWaitGetText(patpage.FirstNamesortingByZ());
	    System.out.println(ss1);
		Assert.assertEquals(ss1, "Zzzz","SORTING VALUE MISMATCHED");     
		
	}  
    
  
   @Test(priority=3) 
    public void PatientDetailsAppearOnEnteringExisting_DetailsInSearchFieldOnPatientPage() throws InterruptedException{
    	
	 //CLOSE THE BOT 
     	bot= new Closethebot();
    	bot.Closing_the_bot();
    	Thread.sleep(2000);
    	patpage.existingpatientdetails(prop.getProperty("Patientfirstname"));
    	Thread.sleep(3000);
    	String Pat = loginpage.ExplicitWaitGetText(patpage.verifyafterexistingpatientdetails());
    	Assert.assertEquals(Pat,prop.getProperty("AppearPatientname"));
    	
    }  
    
   
    @Test(priority=4)
    public void PatientHistoryPageOpensUpOnClicking_AnyPatientNameOnPatientsPage() throws InterruptedException{
    	
    	//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
    	Thread.sleep(2000);
    	patpage.existingpatientdetails(prop.getProperty("Patientfirstname"));
    	Thread.sleep(3000);
    	patpage.patientfirstnameappears(prop.getProperty("AppearPatientname"));
        String title =  loginpage.ExplicitWaitGetText(patpage.verifypatienthistorytitle());
    	Assert.assertEquals(title, "Patient History", "PATIENT HISTORY TITLE MISMATCHED");
       
       
    } 
    
    @Test(priority=5)
    public void PatientsPageOpensUpOnClicking_BackButtonUnderPatientHistoryPage() throws InterruptedException{
    	
    	//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
    	Thread.sleep(2000);
    	patpage.existingpatientdetails(prop.getProperty("Patientfirstname"));
    	Thread.sleep(3000);
    	patpage.patientfirstnameappears(prop.getProperty("AppearPatientname"));
    	
    	Thread.sleep(2000);
    	loginpage.ExplicitWait(patpage.verifypatientspagebutton());
  
    	String title = patpage.verifypatientspage();
    	Assert.assertEquals(title,"Patients" ,"TITLE MISMATCHED");
    	
    	
    } 
    
   @Test(priority=6)
    public void InsuranceNotVerifiedIcon_IsNotFunctionalOnPatientsPage() throws InterruptedException{
    	
	 //CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
   	   Thread.sleep(2000);
        Assert.assertTrue(patpage.verifythainviconnotclickable(), "INSURANCE ICON IS CLICKABLE");
    
    }  
    
    
    @Test(priority=7)
    public void SendPatientFormOnClickingSendPatientForm_OptnUnderSelectActionDropDown() throws InterruptedException{
    	
    	//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
   	    Thread.sleep(5000);
    	patpage.selectpatientformoptn();
        String mess = loginpage.ExplicitWaitGetText(patpage.verifysuccessmessage());
    	Assert.assertEquals(mess,"Patient Form sent successfully.", "NO SUCCESS MESSAGE APPEARS");
    	System.out.println(mess);
    	
    }  
    
    @Test(priority=8)
    public void ConfirmationMsgAppearsOnClickingDelete_OptionUnderSelectActionDropDown() throws InterruptedException{
    	
    	//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
   	    Thread.sleep(5000);
    	patpage.selectdeleteoption();
        String mess = loginpage.ExplicitWaitGetText(patpage.verifyconfirmationmessage());
    	Assert.assertEquals(mess,"Are you sure you want to Delete Patient?", "NO CONFIRMATION MESSAGE APPEARS");
    	System.out.println(mess);
    	
    }   
   
    
    @Test(priority=9) 
    
    public void DeletePatientOnClickingYesButton_UnderConfirmationMessage() throws InterruptedException{
    	
    	//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
   	    Thread.sleep(2000);
    	patpage.verticalelipseandaddbtn();
    	
    	Thread.sleep(3000);
        patpage.fillmandatoryfields();
        Thread.sleep(2000);
    	patpage.existingpatientdetails("David");
    	Thread.sleep(5000);
    	patpage.newcusselectdeleteoption();
        Thread.sleep(2000);
    	loginpage.ExplicitWait(patpage.yesbutton());
    	
    	Thread.sleep(3000);
    	String aftrdel =  loginpage.ExplicitWaitGetText(patpage.deletesuccesmessage());
    //	String aftrde1 =   driver.switchTo().alert().getText();
    	Assert.assertEquals(aftrdel,"Patient removed successfully", "Invalid confirametion msg");
    	loginpage.ExplicitWait(patpage.okbtn());
    	
    	
    }  
    
    
    @Test(priority=10) 
    
     public void ValidationMessageAppears_OnDeletingReferredByPatient() throws InterruptedException{
    	
    	//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
   	    Thread.sleep(5000);
    	patpage.selectdeleteoption();
    	Thread.sleep(2000);
    	loginpage.ExplicitWait(patpage.yesbutton());
    	String valref = loginpage.ExplicitWaitGetText(patpage.validreferredpatientmsg());
    	Assert.assertEquals(valref,"This patient is associated with another dentist.", "Invalid confirametion msg");
    	
    } 
    
    
    @Test(priority=11)  
    
    public void EditPatientPageOpensUpOnClickingEditPatient_OptnInSelectActionDropdown() throws InterruptedException{
    	//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
   	    Thread.sleep(5000);
    	patpage.selecteditoption();
    	Thread.sleep(3000);
    	
    	String editpagetitle = loginpage.ExplicitWaitGetText(patpage.editpatientpagetitle());
    	Assert.assertEquals(editpagetitle,"Edit Patient", "TITLE MISMATCHED");
    	
    	
    } 
    
    @Test(priority=12)
    public void PatientsPageOpensUpOnClicking_BackBtnUnderEditPatientPage() throws InterruptedException{
    	//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
   	    Thread.sleep(5000);
    	patpage.backbtnoneditpage();
    	Thread.sleep(3000);
    	
    	String patientslevelonpage = loginpage.ExplicitWaitGetText(patpage.patentpagelevel());
    	Assert.assertEquals(patientslevelonpage,"Patients", "TITLE MISMATCHED");
    }  
   
   
    @Test(priority=13)
    public void AddPatientPageOpensUpOnClickingAddPatient_OptnOnPatientsPage() throws InterruptedException {
    	//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
   	    Thread.sleep(2000);
    	   patpage.verticalelipseandaddbtn(); 
    	   Thread.sleep(2000);
    	
    	   String addpatientpage = loginpage.ExplicitWaitGetText(patpage.addpatientpagetitle());
    	   Assert.assertEquals(addpatientpage,"Add Patient", "TITLE MISMATCHED");
    	
    }   
    
    
   
    
    
    
    
    
}

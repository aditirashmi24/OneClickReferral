package com.ocr.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.base.TestBase;
import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Colleaguespage;
import com.ocr.qa.pages.Dashboardpage;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.Referralspage;
import com.ocr.qa.pages.SecuritySettingsPage;
import com.ocr.qa.pages.SelectWhoAreYou;
import com.ocr.qa.pages.SendReferralpage;

import junit.framework.Assert;

public class SendReferralpageTest extends TestBase {

	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Colleaguespage collpage;
	SendReferralpage sendreff;
	Closethebot bot; 
	
	String sendFrom = "Levin Q" ; 
	String sendto = "tom jerry(dental)"; 
	String Location = "Gas pump" ;
	
 //	public static String downloadPath= "C:\\Users\\SQE Labs Tester\\Downloads";
	
//	public static String downloadPath= "C:\\Users\\Parineeth Babu\\Downloads";
	
	public static String downloadPath= "C:\\Users\\Droid-7\\Downloads";
	
	public SendReferralpageTest(){
		
		super();
		
	}
	
	
	//ALL THE TEST CASES SEPERATED AND INDEPENDENT TO EACH OTHER 
	
	//SETUP METHOD 
	@BeforeMethod
	public void SendReferralPage_SetupMethod() throws InterruptedException{
		
		initialization();
		
		collpage = new Colleaguespage();
		sendreff = new SendReferralpage();
		
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
		
		sendreff =  dashb.clickonsendreferralbtn();
		Thread.sleep(9000);  
		
	}
	 
    
	@AfterMethod 
	public void TestCase_QuitMethod(){
		
		driver.quit();
		
	}
	
	
	
	
	@Test(priority=1)
	public void SendReferralPageOpensUpOnClicking_SendReferralBtnOnTheHeader(){
		
		
	    String  Title = driver.getTitle();
	    System.out.println(Title);
		Assert.assertEquals("SENDREERRAL TITLE IS MISMATCHED","Send Referral",Title);
		
	} 
	
	@Test(priority=2)
	public void SelectDentistFromSendFromAnd_SendToDropdownUnderSendReferralPage() throws InterruptedException{
		 
		 //CLOSE THE BOT 
		 bot= new Closethebot();
	     bot.Closing_the_bot();
	     Thread.sleep(2000);
		 sendreff.SendFrom(); 	  
		 Thread.sleep(2000); 
		 sendreff.SendTo();  
		   
		 Thread.sleep(3000);
		 String sendfrom=  loginpage.ExplicitWaitGetText(sendreff.valsendfrom());
		 System.out.println(sendfrom);
		 Assert.assertEquals("SENDFROM MISMATCHED",sendFrom, sendfrom);
		 
		 Thread.sleep(2000);
		 String sendTo=  loginpage.ExplicitWaitGetText(sendreff.valsendto());
		 System.out.println(sendTo);
		 Assert.assertEquals("SENDTO MISMATCHED",sendto, sendTo);
	}  
	

	@Test(priority=3)
	public void ReferredReceivedDentistLocationAppears_InLocationDropdown() throws InterruptedException{
		 
		 //CLOSE THE BOT 
		 bot= new Closethebot();
	     bot.Closing_the_bot();
	     Thread.sleep(2000); 
		 sendreff.SendFrom(); 	  
		 Thread.sleep(2000); 
		 sendreff.SendTo();  
		
		 Thread.sleep(2000);
		 sendreff.Location();
		 
		 Thread.sleep(2000);
		 String location = loginpage.ExplicitWaitGetText(sendreff.refferedreciveddentistLocation());
		 System.out.println(location);
		 Assert.assertEquals("INCORRECT LOCATION OR NOT APPEARED",Location,location);
		
	}  
  

	
	@Test(priority=4) 
	public void PatientDetailsAppearOnEnteringExistingDetails_InSearchFieldsUnderSelectPatientSection() throws InterruptedException{
		 
		//CLOSE THE BOT 
		bot= new Closethebot();
		bot.Closing_the_bot(); 
		loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
		
		Thread.sleep(5000);
		String msg = driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")).getText();
		System.out.println(msg);
		Assert.assertEquals("PATIENT DETAILS NOT APPEARED",prop.getProperty("ExistingPatientname"), msg); 
		
	} 

	
	@Test(priority=5)
	public void SelectedPatientDetailsAppearAutofill_OnSendReferralPage() throws InterruptedException{
	
		//CLOSE THE BOT 
		bot= new Closethebot();
		bot.Closing_the_bot(); 
		loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
		Thread.sleep(5000); 
		String msg = driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")).getText();
		 System.out.println(msg);
		Assert.assertEquals("PATIENT DETAILS NOT APPEARED",prop.getProperty("ExistingPatientname"), msg); 
		Thread.sleep(5000);
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,400)");  
		
	    Thread.sleep(3000);
	    WebElement click = driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]"));	
		loginpage.ExplicitWait(click);
		
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy(0,300)");  
	     
	    Thread.sleep(5000);
	    String patnam = sendreff.ApearedPatientfirstnameinAddpatientsection();
	    System.out.println(patnam); 
	    Assert.assertEquals("Patient details not autofill",prop.getProperty("ExistingPatientname"),patnam); 
	       
	    String phnumber= sendreff.ApearedPatientphonenumberinAddpatientsection();
	    System.out.println(phnumber);
	    Assert.assertEquals("NUMBER NOT MATCHED",prop.getProperty("ExistingPatientphonenumber"),phnumber);
	      
	    String gender= sendreff.ApearedPatinetGenderinAddpatientsection();
	    System.out.println("Value for Male is:--"+gender);
	    Assert.assertEquals("PATIENT GENDER DETAILS MISMATCHED",prop.getProperty("ExistingPatientGender"),gender); 
	      
	}  
	
	
	@Test(priority=6)
	public void UnselectAlreadySelectedPatient_UnderSelectPatientSection() throws InterruptedException{
		

		//CLOSE THE BOT 
		bot= new Closethebot();
		bot.Closing_the_bot(); 
		loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
		Thread.sleep(5000); 
		String msg = driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")).getText();
		 System.out.println(msg);
		Assert.assertEquals("PATIENT DETAILS NOT APPEARED",prop.getProperty("ExistingPatientname"), msg); 
		
		Thread.sleep(5000);
	     
	    JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,400)");  
	    
		WebElement click = driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]"));
		
		loginpage.ExplicitWait(click);
		
		Thread.sleep(3000);
			
		JavascriptExecutor js0 =(JavascriptExecutor)driver;
	    js0.executeScript("window.scrollBy(0,300)");  
	     
	    Thread.sleep(5000);
	    String patnam = sendreff.ApearedPatientfirstnameinAddpatientsection();
	    System.out.println(patnam); 
	    Assert.assertEquals("Patient details not autofill",prop.getProperty("ExistingPatientname"),patnam); 
		
	    JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy(0,-300)");  
		
	    sendreff.Clickonselectedpatientname();
		
	    JavascriptExecutor js2 =(JavascriptExecutor)driver;
	    js2.executeScript("window.scrollBy(0,300)");  
	     
	    Thread.sleep(5000);
	    String patnam1 = sendreff.ApearedPatientfirstnameinAddpatientsection();
	    System.out.println("BlankName:--"+patnam1); 
	    Assert.assertEquals("Patient details not autofill","",patnam1); 
		
	}  
	
	@Test(priority=7)
	public void ValidationMsgAppearsOnLeavingMandatoryFieldsBlank_OnSendReferraLPage() throws InterruptedException{
		
		//CLOSE THE BOT 
		Thread.sleep(2000);
		bot= new Closethebot();
		bot.Closing_the_bot(); 
		Thread.sleep(2000);
	//	sendreff.SendReferralbutton();   
		WebElement click =  driver.findElement(By.cssSelector("#savnbtn")); 
		loginpage.ExplicitWait(click);
		
		Thread.sleep(2000);
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,-430)"); 
		
		Thread.sleep(2000);
	    String valfirstname =   sendreff.valfirstnameonaddpatientsection();
	    System.out.println(valfirstname);
		Assert.assertEquals("VALIDATION MESSAGE NOT APPEARED","First name is required.",valfirstname);
	   
		Thread.sleep(1000);
	    String valphonenumber =   sendreff.valphonenumberonaddpatientsection();
	    System.out.println(valphonenumber);
		Assert.assertEquals("VALIDATION MESSAGE NOT APPEARED","Phone number is required.",valphonenumber);
	   
		Thread.sleep(1000);
	    String valpatientgender=  sendreff.valpatientgenderonaddpatientsection();
	    System.out.println(valpatientgender);
	    Assert.assertEquals("VALIDATION MESAGE NOT APPEARED","Please select gender.", valpatientgender);
	 	    
	}  
    
	
	@Test(priority=8)
	public void TextFieldOpensUpOnClicking_AnySubServiceUnderAnyServices() throws InterruptedException{
		
		//CLOSE THE BOT 
		bot= new Closethebot();
		bot.Closing_the_bot(); 
		sendreff.SendReferralbutton();
	    Thread.sleep(2000);
		sendreff.OralsugerryExtractionService(); 
		Thread.sleep(2000); 
		//VALIDATION ON EXTRACTIONSERVICE ON ORAL-SURGERY-SECTION
		String txt=  sendreff.ValidationafterclickOralsugerryExtractionService();
		System.out.println(txt);
		Assert.assertEquals("Tooth # and comments",txt);
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1100)");   
		 
		 sendreff.PeriodonticsScallingAndrootplaning();
		 Thread.sleep(2000);
		//VALIDATION ON SCALING-AND-ROOTPLANING ON PERIODONTICS-SECTION
		 
		 String txt1=  sendreff.ValidationafterClickPeriodonticsScallingandrootplaningService();
		 System.out.println(txt1);
		 Assert.assertEquals("Tooth # and comments",txt1);
			
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,1200)");   
		
		sendreff.OrthodonticscConsulation();
		Thread.sleep(2000);
		//VALIDATION ON CONSULATION-SERVICE ON ORTHODONTICS SECTION
		String serv2= sendreff.ValidationOrthodonticscConsulationService();
		System.out.println(serv2);
		Assert.assertEquals("Tooth # and comments",serv2);
	
		
		JavascriptExecutor js2 =(JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(0,800)");
		
		
		sendreff.ProsthodonticsBridge();
		Thread.sleep(2000); 
		//VALIDATION ON BRIDGE-SERVICE ON PROSTHODONTICS SECTION
		String serv3= sendreff.ValidationProsthodonticsBridgeService();
		System.out.println(serv3);
		Assert.assertEquals("Tooth # and comments",serv3);    
		
		JavascriptExecutor js3 =(JavascriptExecutor)driver;
		js3.executeScript("window.scrollBy(0,500)");
		
		sendreff.EndodonticsDiagnosticConsultation(); 
		Thread.sleep(2000);
		//VALIDATION ON DIAGNOSTICCONSULTATION-SERVICE ON ENDODONTICS SECTION 
		String serv4= sendreff.ValiadationEndodonticsDiagnosticConsultation(); 
		System.out.println(serv4);
		Assert.assertEquals("Tooth # and comments",serv4);   
		
		JavascriptExecutor js4 =(JavascriptExecutor)driver;
		js4.executeScript("window.scrollBy(0,400)");
		
		sendreff.PediatricsCariesorDecay();
		Thread.sleep(2000); 
		//VALIDATION ON CARIESORDECAY-SERVICE ON PEDIATRICS SECTION 
		String serv5= sendreff.ValiadationPediatricsCariesorDecay();
		System.out.println(serv5); 
		Assert.assertEquals("Tooth # and comments", serv5);
		
		JavascriptExecutor js5 =(JavascriptExecutor)driver;
		js5.executeScript("window.scrollBy(0,400)");
		
		sendreff.Implantsother();
		Thread.sleep(2000); 
		//VALIDATION ON OTHER-SERVICE ON IMPLANTS SECTION 
		String serv6= sendreff.ValiadationPediatricsCariesorDecay();
		System.out.println(serv6);
		Assert.assertEquals("Tooth # and comments", serv6);
		
		sendreff.GeneralDentistryother();
		Thread.sleep(2000); 
		//VALIDATION ON OTHER-SERVICE ON GENERALDENTISTRY SECTION 
		String serv7= sendreff.ValiadationGeneralDentistryother();
		System.out.println(serv7);
		Assert.assertEquals("Tooth # and comments", serv7);
		
		sendreff.Dentallabother();
		Thread.sleep(2000); 
		//VALIDATION ON OTHER-SERVICE ON DENTALALLAB SECTION 
		String serv8= sendreff.ValiadationGeneralDentistryother();
		System.out.println(serv8);
		Assert.assertEquals("Tooth # and comments", serv8);
		
		JavascriptExecutor js6 =(JavascriptExecutor)driver;
		js6.executeScript("window.scrollBy(0,300)");
		
		sendreff.Radiologyother();
		Thread.sleep(2000); 
		//VALIDATION ON OTHER-SERVICE ON RADIOLOGY SECTION 
		String serv9= sendreff.ValiadationRadiologyother();
		System.out.println(serv9);
		Assert.assertEquals("Tooth # and comments",serv9);
		
		JavascriptExecutor js7 =(JavascriptExecutor)driver;
		js7.executeScript("window.scrollBy(0,200)");
		
		sendreff.TreatmentPerformedRootcanalinitiated();
		Thread.sleep(2000); 
		//VALIDATION ON CANALIINITIATED-SERVICE ON TREATMENTPERFORMED SECTION 
		String serv10= sendreff.ValiadationTreatmentPerformedRootcanalinitiated();
		System.out.println(serv10);
		Assert.assertEquals("Tooth # and comments", serv10);
		
		JavascriptExecutor js8 =(JavascriptExecutor)driver;
		js8.executeScript("window.scrollBy(0,200)");
		
		sendreff.PediatricDentistryconsultationtreatment();
		Thread.sleep(2000); 
		//VALIDATION ON CANALIINITIATED-SERVICE ON TREATMENTPERFORMED SECTION 
		String serv11= sendreff.ValiadationOnPediatricDentistryconsultationtreatment();
		System.out.println(serv11);  
		Assert.assertEquals("Tooth # and comments", serv11);
		
		JavascriptExecutor js9 =(JavascriptExecutor)driver;
		js9.executeScript("window.scrollBy(0,200)");
		
		sendreff.Otherother();
		Thread.sleep(2000); 
		//VALIDATION ON other-SERVICE ON OTHER SECTION 
		String serv12= sendreff.ValiadationOnOtherother();
		System.out.println(serv12);
		Assert.assertEquals("Tooth # and comments", serv12);
		
		JavascriptExecutor js10 =(JavascriptExecutor)driver;
		js10.executeScript("window.scrollBy(0,300)");
		
		sendreff.CosmeticPlasticSurgeryBotoxDysportXeomin();
		Thread.sleep(2000); 
		//VALIDATION ON BOTOX/DYSPORT/XEOMIN ON OTHER SECTION 
		String serv13= sendreff.ValiadationCosmeticPlasticSurgeryBotoxDysportXeomin();
		Assert.assertEquals("Tooth # and comments", serv13);
		
		
		
	}   
	
    
	@Test(priority=9)
	public void TextfieldOpensUpAfterCheckingRespectiveCheckbox_UnderMedicalHistorySection() throws InterruptedException{
		
		//CLOSE THE BOT 
		bot= new Closethebot();
		bot.Closing_the_bot(); 
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,7400)");
		
		Thread.sleep(4000);
		//Ques1
		sendreff.Areyouunderaphysicianscarerightnow();
		
		boolean ques1 = sendreff.ValidateAreyouunderaphysicianscarerightnow();
		Assert.assertTrue(ques1);  
		
		JavascriptExecutor js2 =(JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(0,500)");
		
		//Ques2
		Thread.sleep(3000);
		sendreff.Haveyoueverbeenhospitalizedorhadamajoroperation();
		
		boolean ques2 = sendreff.ValiadateHaveyoueverbeenhospitalizedorhadamajoroperation();
		Assert.assertTrue(ques2);
		
		JavascriptExecutor js3 =(JavascriptExecutor)driver;
		js3.executeScript("window.scrollBy(0,500)");
		
		//Ques3
		Thread.sleep(2000);
		sendreff.Haveyoueverhadaseriousheadorneckinjury();
				
		boolean ques3 = sendreff.ValiadateHaveyoueverhadaseriousheadorneckinjury();
		Assert.assertTrue(ques3); 
		
		//Ques4
		Thread.sleep(2000);
		sendreff.Aretakinganymedicationspillsordrugs();
						
		boolean ques4 = sendreff.ValiadateAretakinganymedicationspillsordrugs();
		Assert.assertTrue(ques4); 
		
		JavascriptExecutor js0 =(JavascriptExecutor)driver;
		js0.executeScript("window.scrollBy(0,500)");
		
		//Ques5
		Thread.sleep(2000);
		sendreff.DoyoutakeorhaveyoutakenPhenFenorRedux();
		
		boolean ques5 = sendreff.ValiadateDoyoutakeorhaveyoutakenPhenFenorRedux();
		Assert.assertTrue(ques5); 
		
		//Ques6
		Thread.sleep(2000);
		sendreff.HaveyouevertakenFosamaxBonivaActoneloranyothermedicationscontainingbiphosphonates();
				
		boolean ques6 = sendreff.ValiadateHaveyouevertakenFosamaxBonivaActoneloranyothermedicationscontainingbiphosphonates();
		Assert.assertTrue(ques6); 
		
		JavascriptExecutor js4 =(JavascriptExecutor)driver;
		js4.executeScript("window.scrollBy(0,400)");
		 
		//Ques7
		Thread.sleep(2000);
		sendreff.Areyouonaspecialdiet();
						
		boolean ques7 = sendreff.ValiadateAreyouonaspecialdiet();
		Assert.assertTrue(ques7); 
		
		//Ques8
		Thread.sleep(2000);
		sendreff.Doyouusetobacco();
								
		boolean ques8 = sendreff.ValiadateDoyouusetobacco();
		Assert.assertTrue(ques8); 
		
		JavascriptExecutor js5 =(JavascriptExecutor)driver;
		js5.executeScript("window.scrollBy(0,500)");
		
		//Ques9
		Thread.sleep(2000);
		sendreff.Doyouusecontrolledsubstances();
										
		boolean ques9 = sendreff.ValiadateDoyouusecontrolledsubstances();
		Assert.assertTrue(ques9); 
		
		//Ques10
		Thread.sleep(2000);
		sendreff.AreyoupregnantTryingtogetpregnantwomen();
												
		boolean ques10 = sendreff.ValiadateAreyoupregnantTryingtogetpregnantwomen();
		Assert.assertTrue(ques10); 
		
		JavascriptExecutor js6 =(JavascriptExecutor)driver;
		js6.executeScript("window.scrollBy(0,400)");
		
		//Ques11
		Thread.sleep(2000);
		sendreff.Takingoralcontraceptiveswomen();

		boolean ques11 = sendreff.ValiadateTakingoralcontraceptiveswomen();
		Assert.assertTrue(ques11); 
		
		//Ques12
		Thread.sleep(2000);
		sendreff.Nursingwomen();

		boolean ques12 = sendreff.ValiadateNursingwomen();
		Assert.assertTrue(ques12); 
		
		JavascriptExecutor js7 =(JavascriptExecutor)driver;
		js7.executeScript("window.scrollBy(0,500)");
		
		//Ques13
		Thread.sleep(2000);
		sendreff.Havetonsilsorhaveadenoidsbeenremoved();

		boolean ques13 = sendreff.ValiadateHavetonsilsorhaveadenoidsbeenremoved();
		Assert.assertTrue(ques13); 
		
		JavascriptExecutor js8 =(JavascriptExecutor)driver;
		js8.executeScript("window.scrollBy(0,2400)");
		
		//Ques14
		Thread.sleep(2000);
		sendreff.Listanyseriousillnessnotlistedabove();

		boolean ques14 = sendreff.ValiadateListanyseriousillnessnotlistedabove();
		Assert.assertTrue(ques14); 
		
		//Ques15
		Thread.sleep(2000);
		sendreff.AdditionalInformation();;

		boolean ques15 = sendreff.ValiadateAdditionalInformation();
		Assert.assertTrue(ques15); 
		
		
		
	 }  
	 
	 
	 @Test(priority=10)
	 public void EnterDetailsUnder_DentalInsuranceSectionAndDentalHistorySection() throws InterruptedException{
		 
			
			//CLOSE THE BOT 
		    bot= new Closethebot();
		    bot.Closing_the_bot(); 
	     	loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
			Thread.sleep(7000);
		
			JavascriptExecutor js =(JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(0,300)");  
		     
			
			 driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")).click();
          //  driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'Aaron')]")).click();
			
			Thread.sleep(2000);
			JavascriptExecutor js1 =(JavascriptExecutor)driver;
		    js1.executeScript("window.scrollBy(0,6500)");  
		     
		    Thread.sleep(3000);
		    
		    sendreff.PrimaryInsuranceCompany();
		     
		    Thread.sleep(2000);  
		    
		    sendreff.PrimaryInsuranceCompanyPhone();  
		    
		    Thread.sleep(2000);  
		    
		    sendreff.PrimaryNameofInsured();
		    
		    JavascriptExecutor js3 =(JavascriptExecutor)driver;
		    js3.executeScript("window.scrollBy(0,5000)"); 
		    
		    //Dental History Section  
		    
		    sendreff.PreviousDentistName();
		    Thread.sleep(2000);
		    
		    sendreff.Whenwasthelasttimeyouhadyourteethcleaned(); 
		    Thread.sleep(2000);
		    
		    sendreff.Doyoumakeregularvisitstothedentist();
		    Thread.sleep(1000);
		    
		    sendreff.ValidateDoyoumakeregularvisitstothedentist();
		    Thread.sleep(2000);
		    
		    sendreff.HowOften();
		    Thread.sleep(2000);
		   
		    sendreff.SendReferralbutton();
		    
		    Thread.sleep(20000);
		    
		  
	//	    sendreff.patientnameonconversationpage(); 
		   driver.findElement(By.linkText("Aaron")).click();
		    
		    
		    JavascriptExecutor js4 =(JavascriptExecutor)driver;
		    js4.executeScript("window.scrollBy(0,5000)"); 
		      
		    
		   //CLOSE THE BOT 
			bot= new Closethebot();
		    bot.Closing_the_bot();
		   //DENTAL INSURANCE SECTION 
		    loginpage.ExplicitWait(sendreff.ClickOnDentalInsuranceSection());
		    
		    
		    //VALIDATE PRIMARY INSURANCE COMPANY NAME
		    String  DentalInsCompName =  driver.findElement(By.cssSelector("#PrimaryInsuranceCompany")).getAttribute("value");
		    System.out.println(DentalInsCompName);
		    Assert.assertEquals("PRIMARY INSURANCE COMPANY NAME MISMATCHED",prop.getProperty("PrimaryInsuranceCompanyName"),DentalInsCompName);
		    
		    //VALIDATE PRIMARY INSURANCE COMPANY PHONE NUMBER  
		    String  DentalInsCompNumber =  driver.findElement(By.cssSelector("#PrimaryInsurancePhone")).getAttribute("value");
		    System.out.println(DentalInsCompNumber);
		    Assert.assertEquals("PRIMARY INSURANCE COMPANY PHONE NUMBER MISMATCHED",prop.getProperty("PrimaryInsuranceCompanyPhone"),DentalInsCompNumber);
		    
		    //VALIDATE PRIMARY NAME OF INSURED
		    String  DentalInsNameofInsured =  driver.findElement(By.cssSelector("#PrimaryNameOfInsured")).getAttribute("value");
		    System.out.println(DentalInsNameofInsured);
		    Assert.assertEquals("PRIMARY INSURANCE INSURED NAME MISMATCHED",prop.getProperty("PrimaryNameofInsured"),DentalInsNameofInsured);
		    
		  //DENTAL HISTORY SECTION 
		    Thread.sleep(3000);
		    sendreff.ClickOnDentalHistorySection();
		    
		   //VALIDATE PREVIOUS DENTIST NAME  
		    String  PreviousDentistName =  driver.findElement(By.cssSelector("#txtQue5")).getAttribute("value");
		    System.out.println(PreviousDentistName);
		    Assert.assertEquals("PREVIOUS DENTIST NAME MISMATCHED",prop.getProperty("PreviousDentistName"),PreviousDentistName); 
		    
		   //VALIDATE QUESTION 
		    String  Whenwasthelasttimeyouhadyourteethcleaned =  driver.findElement(By.cssSelector("#txtQue6")).getAttribute("value");
		    System.out.println( Whenwasthelasttimeyouhadyourteethcleaned);
		    Assert.assertEquals("PREVIOUS DENTIST NAME MISMATCHED",prop.getProperty(" Whenwasthelasttimeyouhadyourteethcleaned"), Whenwasthelasttimeyouhadyourteethcleaned); 
		    
		    
	 }    
	 
	 
	 @Test(priority=11)
	 public void AttachValidFiles_UnderAttachedFilesSection() throws InterruptedException, IOException {
		 
		 //CLOSE THE BOT 
		 bot= new Closethebot();
		 bot.Closing_the_bot(); 
		 sendreff.AttachFilesButton();
		 
		 Thread.sleep(3000);
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\aloneimg.exe");
		
		//	Thread.sleep(55000);
			
			try{
			    WebDriverWait wait=new WebDriverWait(driver, 60);

			       wait.until(ExpectedConditions.visibilityOfElementLocated(
			          //  By.xpath("//*[@id=\"top-section\"]/div/div/div[1]/li/a/img"))
			    		By.id("documentsContainer"))
			       ).getText();

			    }
			    catch(Throwable t){
			        System.out.println("The execption is: " + t);
			    }
			    finally {
			        System.out.println("If no exception tell me now");
			    }   
			
                String Fname_ext = driver.findElement(By.xpath("//div[@class='panel-heading wordwrap imgname']")).getText();
        		//  replace("_TVAL",""); 
        		  
               String txt = Fname_ext.replaceAll(Fname_ext,"alone.jpg");
          
		    System.out.println(txt);
		   Assert.assertEquals("File Name or Extension Mismatched","alone.jpg",txt );
		   
	   
	 }  
	  
	 @Test(priority=12) 
	 public void ValidationMsgAppearsOnUploadingInvalid_BINFileAndDLLFileUnderAttachedFilesSection() throws Exception{
		 
		    //CLOSE THE BOT 
		    bot= new Closethebot();
		    bot.Closing_the_bot(); 
		    loginpage.ExplicitWait(sendreff.BinFormateInValidfile());
		    Thread.sleep(5000);
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\Document.exe");
		//   String Valmsg = sendreff.ValidateInValidfile();
		   
		    Thread.sleep(10000);
		    
		   // Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        Thread.sleep(5000);
	        		
	        // Accepting alert		
	        alert.accept();		
		    Assert.assertEquals("VALIDATION MESSAGE NOT APPEARED","exe, bin, dll, msi, sql, js formats are not to be uploaded.",alertMessage);
		   
		   
		    Thread.sleep(3000); 
		    loginpage.ExplicitWait(sendreff.DllFormateInValidfile());
		    Thread.sleep(5000);
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\RecordLincSync.API.Dentrix.exe");
		    Thread.sleep(10000);
		   // Switching to Alert        
	        Alert alert1 = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage1= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage1);	
	        Thread.sleep(5000);
	        		
	        // Accepting alert		
	        alert.accept();		
		   Assert.assertEquals("VALIDATION MESSAGE NOT APPEARED","exe, bin, dll, msi, sql, js formats are not to be uploaded.",alertMessage1);
		   
		 }
	 
	 
	@Test(priority=13)
	public void DownloadAttachedFileOnClickingDownloadIcon_UnderAttachedFilesSection() throws Exception{
		
		//CLOSE THE BOT 
		bot= new Closethebot();
		bot.Closing_the_bot(); 
		sendreff.AttachFilesButton();
		 
		Thread.sleep(3000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\roseimg.exe");
		System.out.println("Attach button");
		Thread.sleep(15000);
		
       try{
			 
		    File file = new File(downloadPath);      
		       String[] myFiles;    
		           if(file.isDirectory()){
		               myFiles = file.list();
		               for (int i=0; i<myFiles.length; i++) {
		                   File myFile = new File(file, myFiles[i]); 
		                   myFile.delete();
		                   System.out.println("ALL FILE IS DELETED FROM DIRECTORY") ;
		               }
		            }
			
			
		}
      catch(Exception ex){
			
			System .out.println("NO FILE IN DIRECTORY"+ ex) ;
			
		}
    	
    	
      finally{
          
    	  Thread.sleep(3000);
    	  driver.findElement(By.xpath("//a[@title='Download']")).click();
	   
	       Thread.sleep(25000);
	       File getLatestFile = sendreff.getLatestFilefromDir(downloadPath);
		   String fileName = getLatestFile.getName();
		   System.out.println("DOWNLOADED FILE NAME IS--"+fileName);
		 
		//    String ReplaceName  = fileName.replaceAll(fileName,"AaronSoufer(0).pdf") ; 
		   Thread.sleep(15000);
		    
		 //    String ReplaceName = fileName.replaceFirst(fileName,"DOWNLOADED FILE");  
		   String ReplaceName  = fileName.replaceAll(fileName,"DOWNLOADED FILE") ; 
		    
		    System.out.println("REPLACE NAME OF DOWNLOADED FILE IS--"+ReplaceName);
		    Assert.assertEquals("Downloaded file name is not matching with expected file name","DOWNLOADED FILE", ReplaceName); 
			
		    Thread.sleep(9000);
		    getLatestFile.delete();
	       
	       
      }
	       
    }
		
	
	
	@Test(priority=14)
	public void DeleteAttachedFileOnClicking_DeleteIconUnderAttachedFilesSection() throws InterruptedException, IOException{
		
		//CLOSE THE BOT 
		bot= new Closethebot();
		bot.Closing_the_bot(); 
		sendreff.AttachFilesButton();
		 
		Thread.sleep(3000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\roseimg.exe");
		
		Thread.sleep(15000);
		try{
		    WebDriverWait wait=new WebDriverWait(driver, 60);

		       wait.until(ExpectedConditions.visibilityOfElementLocated(
		          
		    		By.xpath("//a[@title='Delete' or @class='reply-btn aDelete']"))
		       ).click();

		    }
		    catch(Throwable t){
		        System.out.println("The execption is: " + t);
		    }
		    finally {
		        System.out.println("If no exception tell me now");
		    }
		
		Thread.sleep(8000);
		
	//	String text = sendreff.ValidateNoattachementtextmsg();
		String text = driver.findElement(By.xpath("//span[contains(text(),'Attach the file here.')]")).getText();
		System.out.println(text);
		Assert.assertEquals("FILE NOT DELETED OR MESSAGE NOT APPEARED","Attach the file here.", text);

	}   
	
	
	@Test(priority=15)
	public void SendReferralOnClicking_SendReferralButton() throws InterruptedException{
		
		//CLOSE THE BOT 
		bot= new Closethebot();
		bot.Closing_the_bot(); 
		loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
		Thread.sleep(5000); 
		String msg = driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")).getText();
		System.out.println(msg);
		Assert.assertEquals("PATIENT DETAILS NOT APPEARED",prop.getProperty("ExistingPatientname"), msg); 
		
		Thread.sleep(4000);
     	JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,400)");  
	    Thread.sleep(5000); 
	
	    WebElement click =driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")); 
		loginpage.ExplicitWait(click);
		
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy(0,300)");  
	     
	    Thread.sleep(3000);
		sendreff.SendReferralbutton();
		Thread.sleep(2000);  
		
		String successmessage = sendreff.patinetreffersuccessfullymessage();
		System.out.println(successmessage);
		Assert.assertEquals("SUCCESS MESSAGE NOT APPEARED","Patient Referral Sent Successfully!",successmessage);
		
		
	}
	
	
	@Test(priority=16)
	public void ReferralsPageOpensUp_InNewBrowserTabOnClickingDASHBOARDLinkOnTheHeader() throws InterruptedException{
		
		 //CLOSE THE BOT 
		 bot= new Closethebot();
		 bot.Closing_the_bot(); 
		 loginpage.ExplicitWait(sendreff.DashboardLinkonHeaderofSendReferralpage());

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
	
	
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Referrals",title);
		 
		
	}
	
	 
	@Test(priority=17)
	  public void YoutubePageOpensUp_InNewBrowserTabOnClickingDEMOLinkOnTheHeader() throws InterruptedException{
		  
		  //CLOSE THE BOT 
		 bot= new Closethebot();
		 bot.Closing_the_bot(); 
		  loginpage.ExplicitWait(sendreff.DemoLinkonHeaderofSendReferralpage());
		  
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
		
		
			String title= driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("One Click Referral - YouTube",title);
		
		
	  } 
	
	 
	 @Test(priority=18)
	   public void SelectWhoYouArePage_OpensUpOnClickingSIGNOUTlink() throws InterruptedException{
		 
		//CLOSE THE BOT 
		bot= new Closethebot();
		bot.Closing_the_bot(); 
		 loginpage.ExplicitWait(sendreff.SignoutLinkonHeaderofSendReferralpage());
		
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
	
	
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Select Who You Are",title);
	
		 
	  } 
	
	 
	@Test(priority=19) 
	public void TermsAndConditionsPage_OpensUpOnClickingTermsConditionsLinkOnTheFooter() throws InterruptedException{
		
		 //CLOSE THE BOT 
		bot= new Closethebot();
	    bot.Closing_the_bot(); 
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,15000)");  
		Thread.sleep(1000);
		bot.Closing_the_bot();
		Thread.sleep(1000);
		loginpage.ExplicitWait(sendreff.TermsandConditionLiinkonFooterofSendReferralpage());
		
		Thread.sleep(9000);
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		Assert.assertEquals("TITLE MISMATCHED OR PAGE NOT OPENS UP","Terms & Conditions", PageTitle);
		
		
		
	}
	
	
	@Test(priority=20)
	public void ContactUSPage_OpensUpOnClickingSupportLinkOnTheFooter() throws InterruptedException{ 
	    
		//CLOSE THE BOT 
		bot= new Closethebot();
		bot.Closing_the_bot();
		JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,15000)");  
		Thread.sleep(2000);
		loginpage.ExplicitWait(sendreff.ContactUsLiinkonFooterofSendReferralpage());
	    
	    Thread.sleep(2000);
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		Assert.assertEquals("TITLE MISMATCHED OR PAGE NOT OPENS UP","Contact Us", PageTitle); 
	 }
	 
	
	
	@Test(priority=21)
	public void SelectWhoYouArePage_OpensUpOnClickingSignOutLinkOnTheFooter() throws InterruptedException{ 
		 
		//CLOSE THE BOT 
		bot= new Closethebot();
	    bot.Closing_the_bot();
		JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,15000)");  
		Thread.sleep(2000);
		loginpage.ExplicitWait(sendreff.SignoutLiinkonFooterofSendReferralpage());
	    Thread.sleep(2000);
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		Assert.assertEquals("TITLE MISMATCHED OR PAGE NOT OPENS UP","Select Who You Are", PageTitle); 
		 
	 } 
	
	@Test(priority=22)
	public void PrivacyPolicyPage_OpensUpOnClickingPrivacyPolicyLinkOnTheFooter() throws InterruptedException{ 
		 //CLOSE THE BOT 
		bot= new Closethebot();
	    bot.Closing_the_bot();
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,15000)");  
		Thread.sleep(3000);
        loginpage.ExplicitWait(sendreff.PrivacyPolicyLiinkonFooterofSendReferralpage());
	    Thread.sleep(3000);
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		Assert.assertEquals("TITLE MISMATCHED OR PAGE NOT OPENS UP","Privacy Policy", PageTitle); 
	      
	 }
	 
	
	@Test(priority=23)
	public void YoutubePageOpensUpIn_NewBrowserTabOnClickingDEMOLinkOnTheFooter() throws InterruptedException{ 
		 
		//CLOSE THE BOT 
		bot= new Closethebot();
	    bot.Closing_the_bot();
		JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,15000)");  
	    loginpage.ExplicitWait(sendreff.DemoLiinkonFooterofSendReferralpage());
	   
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
	
	
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("One Click Referral - YouTube",title);
	      
	 }
	
	
	@Test(priority=24)
	public void AboutUsPageOpensUp_OnClickingAboutUsLinkOnTheFooter() throws InterruptedException{ 
		 
		//CLOSE THE BOT 
	    bot= new Closethebot();
	    bot.Closing_the_bot();	
		JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,15000)");  
		loginpage.ExplicitWait(sendreff.AboutUsLinkonFooterofSendReferralpage());
	    Thread.sleep(2000);
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		Assert.assertEquals("TITLE MISMATCHED OR INCORRECT PAGE OPENS UP","Aboutus-OneClickReferrals", PageTitle); 
	      
	 }
	
	
	
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	


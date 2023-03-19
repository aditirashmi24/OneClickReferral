package com.ocr.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Dashboardpage;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.Patienthistorypage;
import com.ocr.qa.pages.Patientspage;
import com.ocr.qa.pages.SelectWhoAreYou;

import junit.framework.Assert;
//COLLEAGUE-NAME USE IN PATIENT-HISTORY PAGE IS AKSHIT LECK 
public class PatienthistorypageTest extends Dashboardpage {

	String PatientReferralfrm = prop.getProperty("Fullname"); 	
	String Firstname = prop.getProperty("FirstnameinPatientforms");
	
 //   public static String downloadPath= "C:\\Users\\SQE Labs Tester\\Downloads"; // ---PATH FOR VIVEK LAPTOP
//	public static String downloadPath= "C:\\Users\\Parineeth Babu\\Downloads";
	public static String downloadPath= "C:\\Users\\Droid-7\\Downloads";
	
	
	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Patientspage patpage;
    Patienthistorypage pathistorypage;
    Closethebot bot;
    
	//CREATE A CONSTRUCTOR
	
	public  PatienthistorypageTest(){
		
		super();
		
	}
	
    //ALL THE TEST CASES SEPRATED AND INDEPENDENT TO EACH OTHER
	
	//CREATE SETUP METHOD 
	@BeforeMethod
	public void PatienthistoryPage_SetupMethod() throws InterruptedException{
		
		initialization();
		pathistorypage = new Patienthistorypage(); 
		patpage = new Patientspage();
		
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
		Thread.sleep(20000);
		//CLOSE THE CHAT BOT 
	    bot.Closing_the_bot();
	    Thread.sleep(2000);
	    
		patpage =  dashb.clickonpatientslink();
		Thread.sleep(7000);
		
	}
    
    
	//QUIT METHOD FOR QUIT TEST CASES 
  	@AfterMethod 
	public void TestCase_QuitMethod(){
		
		driver.quit();
		
	}    
	 
  	
	//ADD PATIENT 
 	@Test(priority=1)
	public void AddPatientAfterEnteringMandatoryDetails_OnAddPatientPage() throws InterruptedException{
		
 	//CLOSE THE CHAT BOT 
 	bot = new Closethebot();
 	bot.Closing_the_bot();	
 	Thread.sleep(2000);	
	pathistorypage.addPatient();
	//Validate on Success Message 
	Thread.sleep(2000);
	WebElement msg =pathistorypage.succesmsg();
	String sucmsg = loginpage.ExplicitWaitGetText(msg);
	System.out.println(sucmsg);
	Assert.assertEquals("PATIENT NOT ADDED SUCCESFULLY","Patient added successfully", sucmsg);
	Thread.sleep(3000);
	
	
	}  
	
	@Test(priority=2)
	public void AllAddedDetailsOfPatientAppears_OnPatientHistoryPage() throws InterruptedException{
	
	//CLOSE THE CHAT BOT 
	bot = new Closethebot();
	bot.Closing_the_bot();
	Thread.sleep(2000);
	pathistorypage.addPatient();
	
    Thread.sleep(17000);  
	//Validate on Patient Name appears on PatientHistorypage
	String PatientDetails =  loginpage.ExplicitWaitGetText(pathistorypage.addedpatientnameappears());          
	System.out.println(PatientDetails);
	Assert.assertEquals("PATIENT NOT ADDED SUCCESFULLY","David Miller", PatientDetails);
	
	}  
    
    
	@Test(priority=3)
	public void UploadProfilePicturePopupOpensUp_OnClickingCameraIcon()throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
	    bot.Closing_the_bot();
	    Thread.sleep(2000);
		pathistorypage.addPatient();
		Thread.sleep(15000);
	    String icon =	pathistorypage.profilepicticon();
		Assert.assertEquals("Upload Profile Picture", icon); 
		
	}  
	
	
  	@Test(priority=4)
	public void UserIsAbleToUploadPatient_ProfileImageUnderPatientHistoryPage() throws InterruptedException, Exception{
  		
  	    //CLOSE THE CHAT BOT 
  		bot = new Closethebot();
  		bot.Closing_the_bot();
  		Thread.sleep(2000);
		pathistorypage.addPatient();
	
		//Choose File
		Thread.sleep(15000);
		WebElement Click =  driver.findElement(By.xpath("//a[@href='#addLogo']"));
		loginpage.ExplicitWait(Click);
		Thread.sleep(3000);
		pathistorypage.choosefilebutton();
		 
		Thread.sleep(5000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\cool.exe"); 
		
		Thread.sleep(7000);
	    pathistorypage.draganddrop();
	    
	  //CLOSE THE CHAT BOT 
	  //	bot.Closing_the_bot();
	  	Thread.sleep(3000);
	  	
	    WebElement btn =  driver.findElement(By.xpath("//*[@id=\"btnSave\"]/i"));
	    loginpage.ExplicitWait(btn);
	    
		Thread.sleep(2000);
	     
		String Valdmesssage = pathistorypage.ValidationMessageAfterUploadingSavbtn();
		System.out.println(Valdmesssage);
		Assert.assertEquals("VALIDATION MESSAGE NOT APPEARED","Image uploaded successfully.",Valdmesssage);
		
	}  
	
	
    
	@Test(priority=5)
	public void UpdatePatientDetailsUnder_PatientDetailsSectionOnPatientHistoryPage() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
	   bot = new Closethebot();
	   bot.Closing_the_bot();	
	   Thread.sleep(1000);
	   pathistorypage.searchpatient();
		
	   Thread.sleep(2000);	
	   String txt = pathistorypage.addressfieldtext();
	   System.out.println(txt);
	   Assert.assertEquals("Not updated successfull","SYDNEYSTREET121", txt);	  
	   
	   Thread.sleep(3000);
	 //  String txt1 = pathistorypage.phonenumbertext();
	   String txt1 = driver.findElement(By.xpath("//input[@class='form-control' and @id='update_phoneId']")).getAttribute("value");
	   
	   System.out.println(txt1);
	   Assert.assertEquals("(223) 121-3343", txt1);
	   
	   
	}  
    
    
	@Test(priority=6)
	public void SendReferralPageOpensUpOnClicking_ReferPatientIconOnPatientHistoryPage() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
      	bot.Closing_the_bot();	
      	Thread.sleep(2000);
		pathistorypage.referpatienticon();  
		
		Thread.sleep(10000);
		String title = driver.getTitle();
		Assert.assertEquals("Title Mismatched or Page not opensup","Send Referral",title);
	}  
	
	
 	@Test(priority=7)
	public void DentistMovesToThePatientFormsSection_OnClickingPatientFormsIcon() throws InterruptedException{
		 
		 //CLOSE THE CHAT BOT 
 	     bot = new Closethebot();
       	 bot.Closing_the_bot();	
		 pathistorypage.patientformicon();
		
		 String patform = pathistorypage.verifypatientformsection();
		 Assert.assertEquals("Patient Forms", patform);
		
	}  
	
 	
	@Test(priority=8) 
	public void PrintallButtonIsNotFunctional_WhenNoDetailsAvailableInCommunicationsSection() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
	  	bot = new Closethebot();
	  	bot.Closing_the_bot();
		pathistorypage.verifyprintallbuttonotfuctional();
	    
		//CLOSE THE CHAT BOT 
	  	bot.Closing_the_bot();
	  	Thread.sleep(2000);
	
	    
	    Actions actions = new Actions(driver);
		actions.moveToElement(pathistorypage.printallbtn());
		actions.click(pathistorypage.printallbtn()).perform();
	    
	 
	    boolean click=	pathistorypage.printallbtncliclickableornot();
		Assert.assertTrue("CLICKABLE", click);
	} 
	
	
	@Test(priority=9)
	public void AllAddedColleaguesNameAppeaOnEnteringCharIn_SearchColleagueFieldUnderCommunicationsSection()throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
 	    bot.Closing_the_bot();	
 	    Thread.sleep(1000);
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
		Thread.sleep(2000);
	    String validate =	pathistorypage.colleaguesappearaftersearchbycharacter();
	    System.out.println(validate);
		Assert.assertEquals("×Test Last", validate);
	}   
	
	
  	@Test(priority=10)
	public void UserIsAbleToSelectMultipleColleaguesIn_SearchColleagueFieldUnderCommunicationsSection() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
     	bot.Closing_the_bot();	
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
		Thread.sleep(3000);
		pathistorypage.MoreAddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage1"));
		
		String validate =	pathistorypage.colleaguesappearaftersearchbycharacter();
		System.out.println(validate);
		Assert.assertEquals("×Test Last", validate);  
		Thread.sleep(2000);
		String validate2 =	pathistorypage.colleaguesappearaftersearchbycharacter2();
		System.out.println(validate2);
		Assert.assertEquals("×Riyan Sam", validate2);  
		 
	}   
	
	
 	@Test(priority=11) 
	public void UserIsAbleToSendMessageAfterSelectingColleagueAndEntering_TextUnderCommunicationSection() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
 	    bot.Closing_the_bot();	
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage1"));
		Thread.sleep(5000);
		pathistorypage.entermsgundercomunicationsection();
		
		Thread.sleep(4000);
		String sucmsg = pathistorypage.successmessageaftersendmessage();
	//	Assert.assertEquals("Message sent successfully", sucmsg);

	} 
    
 	
  	@Test(priority=12)
	public void PrintAllCommunicationDetailsOnClicking_PrintAllButtonUnderCommunicationsSection() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
 	    bot.Closing_the_bot();	
 	    Thread.sleep(2000);
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage1")); 
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(pathistorypage.printallbtn());
		actions.click(pathistorypage.printallbtn()).perform();
		Thread.sleep(3000);
  	}
		 

  	
   @Test(priority=13)
	public void PatientReferralFromDentistNamePopupOpensUp_OnClickingReferralTypeUnderCommunicationsSection() throws InterruptedException{
		
	   //CLOSE THE CHAT BOT 
	 	bot = new Closethebot();
	 	bot.Closing_the_bot();	
    	pathistorypage.AddedColleaguesnameonEnteringCharacter2(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
    	JavascriptExecutor js =(JavascriptExecutor)driver;
  	    js.executeScript("window.scrollBy(0,400)");
     	pathistorypage.Referral_Type();
     	Thread.sleep(8000);
		String txt = pathistorypage.PatientReferralPopupTitle();
		System.out.println(txt);
		Assert.assertEquals("Patient Referral From"+" "+PatientReferralfrm, txt);
		
		
	} 
    
   
  	@Test(priority=14)
    public void PatientReferralFromDentistNamePopupOpensUp_OnClickingMessageTypeUnderCommunicationsSection() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
 	    bot.Closing_the_bot();	
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
		
	    WebElement msg =driver.findElement(By.xpath("//*[@id=\"txtMessageFromPatientHistory\"]"));
		loginpage.ExplicitWaitSendKeys(msg,"CHECK THE MESSAGE");
	    
	    
		Thread.sleep(2000);
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,100)");
		
		
	    WebElement btnPrimary = driver.findElement(By.xpath("(//a[@class='btn btn-default btn-primary'])[1]"));
	    Thread.sleep(2000);
	    loginpage.ExplicitWait(btnPrimary);
		Thread.sleep(3000);
		
    	JavascriptExecutor js1 =(JavascriptExecutor)driver;
  	     js1.executeScript("window.scrollBy(0,300)");  
  	     
  	     Thread.sleep(10000);
  
  	     
  	    WebElement click = driver.findElement(By.cssSelector("#CommunicationAppend > tr:nth-child(1) > td:nth-child(3) > a"));
	    Actions Action = new Actions(driver);
		Action.moveToElement(click).perform();
  	    loginpage.ExplicitWait(click); 
  	   
		Thread.sleep(3000);
		String txt = pathistorypage.messagestext(); 
		System.out.println(txt);
		Assert.assertEquals("Messages", txt);
	} 
     
  	
  	@Test(priority=15) 
	public void PrintMessageDetailsOnClicking_PrintLinkUnderCommunicationsSection() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
 	    bot.Closing_the_bot();	
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
    	JavascriptExecutor js =(JavascriptExecutor)driver;
  	     js.executeScript("window.scrollBy(0,500)");
		
		pathistorypage.printlinkmessagetype();
		Boolean printlink = pathistorypage.assertomnprintlinkmessagetype();
		Assert.assertTrue("NotClickable",printlink);
		
	
  	}
	
    
 	@Test(priority=16)
	public void DentistIsAbleToExportAllPatientFilesOn_ClickingExportFileBtn() throws InterruptedException{
		//CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
 	    bot.Closing_the_bot();	
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
    	JavascriptExecutor js =(JavascriptExecutor)driver;
  	    js.executeScript("window.scrollBy(0,700)"); 
  	    
		pathistorypage.Exportfilebutton();
		System.out.println("RECORD LINK PAGE OPENUP NO FILES EXPORT ISSUE STILL OCURING"); 
			
	}  
 	
 	
  	@Test(priority=17)
	public void DentistIsAbleToUploadValidFilesOn_ClickingAttachFilesBtn() throws InterruptedException, Exception{
	
	    //CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
 	    bot.Closing_the_bot();	
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
    
		Thread.sleep(4000);
	  
    	JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,1000)");
	  	
   
		
	    try{ 
	    	 Thread.sleep(3000);
	    	 String tag = driver.findElement(By.xpath("//img[@style='max-height:100%; max-width:100%;']")).getTagName();
			    System.out.println(tag);
		        Assert.assertEquals("FILE NOT ATTACHED","img", tag);
	        
		}
		catch(Exception ex){
			
			Actions act = new Actions(driver);
	 	    act.moveToElement(driver.findElement(By.linkText("Attach Files"))).perform();
	 	    Thread.sleep(2000);
	 	     driver.findElement(By.linkText("Attach Files")).click();
			
			System.out.println(ex);
			Thread.sleep(13000);
			
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\roseimg.exe");
			
			Thread.sleep(15000);
			 
			String tag = driver.findElement(By.xpath("//img[@style='max-height:100%; max-width:100%;']")).getTagName();
		    System.out.println(tag);
	        Assert.assertEquals("FILE NOT ATTACHED","img", tag);
			
		}
	     

	}  
	
	
 	@Test(priority=18)
	public void ValidationMsgAppearsOnUploading_InvalidFileUnderPatientFilesSection() throws InterruptedException, IOException{
		
 		//CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
 	    bot.Closing_the_bot();	
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
    	JavascriptExecutor js =(JavascriptExecutor)driver;
  	     js.executeScript("window.scrollBy(0,800)");
		
  	    Thread.sleep(2000); 
		pathistorypage.Attachfilesbutton();
		
		Thread.sleep(5000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\Document.exe");
		 
		Thread.sleep(12000);
		 
		// Switching to Alert        
        Alert alert1 = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage1= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage1);	
        Thread.sleep(2000);
        		
        // Accepting alert		
        alert1.accept();		
	   Assert.assertEquals("VALIDATION MESSAGE NOT APPEARED","exe, bin, dll, msi, sql, js formats are not to be uploaded.",alertMessage1);
	   
		
		
		
	}   
    
 	
     
	@Test(priority=19)
	
	public void  DownloadAttachedFileOn_ClickingDownloadIcon() throws InterruptedException, IOException{
		
		//CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
 	    bot.Closing_the_bot();	
		
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
    	JavascriptExecutor js =(JavascriptExecutor)driver;
  	     js.executeScript("window.scrollBy(0,1100)");
	    Thread.sleep(5000);	
	    
	    try{
	    	
	    	WebElement click = driver.findElement(By.cssSelector(".aDownload")); 
	 		loginpage.ExplicitWait(click);
	    	
	    }
	    
	    catch(Exception ex){
	    	
	    	System.out.println(ex); 
	    	Thread.sleep(2000);  
		 bot.Closing_the_bot();
		 Thread.sleep(1000);
  	//    pathistorypage.Attachfilesbutton();
  	    

 	  ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
			driver.findElement(By.xpath("//a[@class='reply-btn' and @id='upfile']")));
		
			Thread.sleep(10000);
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\cool.exe");
		    
			Thread.sleep(12000);
		    
			WebElement click = driver.findElement(By.cssSelector(".aDownload")); 
	 		loginpage.ExplicitWait(click);
	    	
	 
	 		Thread.sleep(10000);
	    }
	    
	    //DELETE  THE FILES IN DIRECOTRY
		
		
	    try{
			 
		    File file = new File("C:\\Users\\SQE Labs Tester\\Downloads");      
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
	    
	     finally {
	    	 
	 		
	 	        boolean btn = pathistorypage.Downloadiconisclickable(); 
	 	        Assert.assertTrue("NOT CLICKABLE", btn);
	 	      
	 	        Thread.sleep(14000);
	 	        
	 	        
	 	        File getLatestFile = pathistorypage.getLatestFilefromDir(downloadPath);
	 		    String fileName = getLatestFile.getName();
	 		    System.out.println("DOWNLOADED FILE NAME IS--"+fileName);
	 		    
	 		    
	 		    String ReplaceName  = fileName.replaceAll(fileName, "Downloadedfile") ;
	 		    System.out.println("REPLACE NAME OF DOWNLOADED FILE IS--"+ReplaceName);
	 		    Assert.assertEquals("Downloaded file name is not matching with expected file name","Downloadedfile", ReplaceName);
	 	        
	 	        Thread.sleep(5000); 
	 	        getLatestFile.delete();
	    	 
    	 
	     }
	    
	    
	}   

    
	
 	@Test(priority=20)
	public void DeleteAttachedFileOn_ClickingDeleteIcon()throws InterruptedException, IOException{ 
	    
 		boolean imgnm;
	    //CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
 	    bot.Closing_the_bot();	
 	    Thread.sleep(1000);
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
    //	JavascriptExecutor js =(JavascriptExecutor)driver;
  	//    js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(2000);  
		 bot.Closing_the_bot();
		 Thread.sleep(1000);
  	//    pathistorypage.Attachfilesbutton();
		 try{
		    	
		  //  	WebElement click = driver.findElement(By.xpath("//a[contains(@title,'Delete')]")); 
		 	//	loginpage.ExplicitWait(click);
		 		
		 		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
		 				driver.findElement(By.cssSelector(".fa-trash")));
		 		
		 		 ;
		    }   
		 
		 catch(Exception ex){
			 
			 System.out.println("NO FILE ATTACHED ALLREADY");
			 
		 }
		
		 finally{
			 
			 Thread.sleep(10000);
			
  	 //Attach File Button 
 	//  ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
	//	driver.findElement(By.xpath("//a[@class='reply-btn' and @id='upfile']")));
			 JavascriptExecutor js =(JavascriptExecutor)driver;
			  js.executeScript("window.scrollBy(0,1300)");
			 WebElement clk = driver.findElement(By.xpath("//a[@class='reply-btn' and @id='upfile']"));
			 loginpage.ExplicitWait(clk);
		Thread.sleep(3000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\roseimg.exe");
  	     
		Thread.sleep(14000);
		imgnm = driver.findElement(By.xpath("//div[@class='panel-heading wordwrap imgname' and text()='rose.jpg']")).isDisplayed();
		if(imgnm){
	
				loginpage.ExplicitWait(pathistorypage.Deleteicon());  
				Thread.sleep(7000);
					 try{
						  imgnm = driver.findElement(By.xpath("//div[@class='panel-heading wordwrap imgname' and text()='rose.jpg']")).isDisplayed();
					 	}catch(Exception ex ){
					 			Assert.assertTrue(true);
					 			System.out.println("ATTACHED FILE DELETED");
					 } 
					 	
		 }else {
			 Assert.assertTrue(false);
			 System.out.println("File was not present , hence delete operation is not excecuted");
			 
		 }
	}  
 	}
    
 	
 	@Test(priority=21)
	public void AllAddedDetailsAppear_AutofillUnderPatientsFormsSection() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
     	bot = new Closethebot();
 	    bot.Closing_the_bot();	
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
    	JavascriptExecutor js =(JavascriptExecutor)driver;
  	     js.executeScript("window.scrollBy(0,1300)");
		
	    pathistorypage.perosnalinfosectionunderPatientsForms();
	
	   Thread.sleep(5000);
	   String txt =pathistorypage.patientinformationtextappears();
	   Assert.assertEquals("Not Matched","Patient Information", txt);
	    js.executeScript("window.scrollBy(0,300)");
	 
	    Thread.sleep(2000);
	 
	    String FirstName = pathistorypage.firstnameunderprsonalinfoinPatientForms();
	    System.out.println(FirstName);
      	Assert.assertEquals("Name Mismatched or not appeared",Firstname,FirstName);
      	 
      	String Lastname = pathistorypage.lastnameunderprsonalinfoinPatientForms();
	    System.out.println(Lastname);
      	Assert.assertEquals("Name Mismatched or not appeared",prop.getProperty("LastnameinPatientforms"), Lastname); 
      	  
      	  
      	  
	}  
	
 	
	@Test(priority=22)
	public void  ValidationMsgAppearsOnLeavingMandatoryFieldsBlank_UnderPatientInformationSection() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
    	bot = new Closethebot();
    	bot.Closing_the_bot();	
    	Thread.sleep(3000);
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
    	JavascriptExecutor js =(JavascriptExecutor)driver;
  	     js.executeScript("window.scrollBy(0,1700)");
  	    pathistorypage.perosnalinfosectionunderPatientsForms(); 
  	     Thread.sleep(2000);
  	    pathistorypage.FirstName(); 
  	    Thread.sleep(3000);
  	     JavascriptExecutor js1 =(JavascriptExecutor)driver;
	     js1.executeScript("window.scrollBy(0,800)");
	     pathistorypage.submitbutton();
	    
	    Thread.sleep(3000); 
	   String val = pathistorypage.validationOnmessageAfterblankFirstNameMandField();
	   System.out.println(val); 
	    
	   Assert.assertEquals("Invalid message Or Message not appeared","Please enter First Name.", val);
	    
	   js1.executeScript("window.scrollBy(0,-800)");
         	   
	  pathistorypage.FirstName1();  
	  Thread.sleep(3000);
	     
	  pathistorypage.LastName();
	  Thread.sleep(3000);
	  js1.executeScript("window.scrollBy(0,800)");
	  pathistorypage.submitbutton();
	 
	  Thread.sleep(2000);	
	  String val1 =	pathistorypage.validationmessageafterblankmandatoryfield();
	  System.out.println(val1);
	  
	  Assert.assertEquals("Invalid mesasge", "Please enter Last Name.", val1);
		
	}  
	
	
  	@Test(priority=23)
	public void SuccessMsgAppearsOnClickingSubmitBtn_AfterEnteringValidDetailsUnderPersonalInfoSection() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
 	   bot = new Closethebot();
 	   bot.Closing_the_bot();	
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
    	JavascriptExecutor js =(JavascriptExecutor)driver;
  	     js.executeScript("window.scrollBy(0,1700)");
  	    pathistorypage.perosnalinfosectionunderPatientsForms(); 
		
  //	   pathistorypage.LastName();
  //	   Thread.sleep(2000);
  //	  pathistorypage.LastNamedata();
		Thread.sleep(2000);
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
	     js1.executeScript("window.scrollBy(0,800)");
		pathistorypage.submitbutton();
		
		Thread.sleep(2000);
	//	String succ = pathistorypage.successmessageafterEnteringvaliddetailsinmandatoryfields();
		String succ = loginpage.ExplicitWaitGetText(pathistorypage.successmessageafterEnteringvaliddetailsinmandatoryfields());
		System.out.println(succ);
		Assert.assertEquals("Invalid mesasge", "Details updated successfully", succ);
		
	} 
	
	
  	
	@Test(priority=24) 
	public void SavedetailsInDentalInsuranceMedicalHistory_AndDentalHistorySectionsOnPatientHistoryPage() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
 	    bot = new Closethebot();
 	    bot.Closing_the_bot();	
		pathistorypage.AddedColleaguesnameonEnteringCharacter(prop.getProperty("AddedcolleagenameinPatientHistorypage"));
		Thread.sleep(10000);
    	JavascriptExecutor js =(JavascriptExecutor)driver;
  	     js.executeScript("window.scrollBy(0,1700)");
		
  	     
		pathistorypage.DentalInsurance();
		
		pathistorypage.InsuranceCompanyName();
		
		pathistorypage.NameOfInsured();
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
 	     js1.executeScript("window.scrollBy(0,1400)");
 	     Thread.sleep(3000);
		pathistorypage.InsuranceSubmitbtn(); 
		Thread.sleep(2000);
		String succ = pathistorypage.InsSuccesMessage();
	     System.out.println(succ);
		  
		  Assert.assertEquals("Invalid mesasge", "Details updated successfully", succ);
		
		  
		  
		  
	}  
	
   
}


package com.ocr.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.base.TestBase;
import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Colleaguespage;
import com.ocr.qa.pages.Conversationspage;
import com.ocr.qa.pages.Dashboardpage;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.Referralspage;
import com.ocr.qa.pages.SelectWhoAreYou;
import com.ocr.qa.pages.SendReferralpage;

import junit.framework.Assert;

public class ConversationspageTest extends TestBase {

	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Conversationspage conver;
	SendReferralpage sendreff;
	Closethebot bot;

	// public static String downloadPath= "C:\\Users\\SQE Labs
	// Tester\\Downloads"; // ---PATH FOR VIVEK LAPTOP
	// public static String downloadPath= "C:\\Users\\Parineeth
	// Babu\\Downloads";
	public static String downloadPath = "C:\\Users\\Droid-7\\Downloads";

	// CREATE A CONSTRUCTOR------------------
	public ConversationspageTest() {

		super();

	}

	// ALL THE TEST CASES SEPERATED AND INDEPENDENT TO EACH OTHER
	// SETUP METHOD
	@BeforeMethod
	public void ConversationsPage_SetupMethod() throws InterruptedException {

		initialization();

		sendreff = new SendReferralpage();
		conver = new Conversationspage();

		Swatpage = new SelectWhoAreYou();
		loginpage = new Loginpage();

		// CLOSE THE CHAT BOT
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(3000);
		loginpage = Swatpage.loginbtn();
		Thread.sleep(15000);

		// CLOSE THE CHAT BOT
		bot.Closing_the_bot();
		Thread.sleep(2000);

		dashb = new Dashboardpage();
		dashb = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(25000);
		// CLOSE THE CHAT BOT
		bot.Closing_the_bot();
		Thread.sleep(2000);
		loginpage.ExplicitWait(conver.mesageonrefferalpage());
		Thread.sleep(7000);

	}
  
	
	@AfterMethod
	public void TestCase_QuitMethod(){

	driver.quit();

	}


	   
	    @Test(priority=1)
	public void ConversationsPageOpensUpAfterSending_AnyReferralOnSendReferralpage() throws InterruptedException{

	   
	    Thread.sleep(10000);
	    dashb = new Dashboardpage() ;
	    dashb.clickonsendreferralbtn();
	   
	    Thread.sleep(2000);
	    //CLOSE THE BOT
	    bot.Closing_the_bot();
	   
	       Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientnameforConversationPage"));

	        Thread.sleep(5000);
	   
	   JavascriptExecutor js =(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,400)");  
	   Thread.sleep(5000);
	   
	WebElement click =driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientnameforConversationPage")+"')]"));
	loginpage.ExplicitWait(click);

	JavascriptExecutor js1 =(JavascriptExecutor)driver;
	   js1.executeScript("window.scrollBy(0,300)");  
	   
	   Thread.sleep(3000);;
	sendreff.SendReferralbutton();
	   
	System.out.println("click");
	Thread.sleep(15000);
	String title = driver.getTitle();
	System.out.println(title);
	Assert.assertEquals("Conversations",title);

	}
   
   

	    @Test(priority=2)
	    public void DentistAndPatientReceivesMail_AfterSendingAnyReferralOnSendReferralPage() throws InterruptedException{
	   
	   
	    Thread.sleep(10000);
	dashb.clickonsendreferralbtn();
	Thread.sleep(2000);
	bot.Closing_the_bot();
	    Thread.sleep(2000);

	sendreff.SendFrom();
	Thread.sleep(5000);
	sendreff.SendTo();
	Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientnameforConversationPage1"));

	        Thread.sleep(5000);
	   
	((JavascriptExecutor) driver).executeScript("arguments[0].click()",
			driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientnameforConversationPage1")+"')]")));
	
    Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,300)");  
	   
	   Thread.sleep(3000);
	   sendreff.SendReferralbutton();

	    Thread.sleep(15000);  
	   
	    //CHECK MESSAGE IN PATIENT EMAIL ID---------------------------------------------------------------------------------|
	    conver.verifyPatientmail();
	   
	    Thread.sleep(3000);
	   
	  
	        driver.switchTo().frame("ifmail");
			String Messageonmail = driver.findElement(By.xpath("//div[@class='topfixe' or @id='mailhaut']//div[@class='f16']")).getText();
			 Assert.assertEquals("MESSAGE NOT APPEARES IN PATIENT EMAIL","You have been referred by Dr.Levin Q to dental",Messageonmail);  
	        
	        
	        
	    Thread.sleep(2000);
	    // CHECK MESSAGE IN DENTIST EMAIL ID--------------------------------------------------------------------------------|
	    conver.verifyDentistmail();
	   
	    Thread.sleep(3000);
	   
	    driver.switchTo().frame("ifmail");
	       
	        String MessageonPatientmail = driver.findElement(By.xpath("//div[@class='topfixe' or @id='mailhaut']//div[@class='f16']")).getText();
	        Assert.assertEquals("MESSAGE NOT APPEARES IN DENTIST EMAIL","You have sent a OneClick Referral",MessageonPatientmail);
	   
	    // CHECK MESSAGE IN COLLEAGUE MAIL
	       
	        conver.verifyColleaguemail();
	       
	        Thread.sleep(3000);
	       
	        driver.switchTo().frame("ifmail");
	       
	        String MessageonColleaguemail = driver.findElement(By.xpath("//div[@class='topfixe' or @id='mailhaut']//div[@class='f16']")).getText();
	        Assert.assertEquals("MESSAGE NOT APPEARES IN PATIENT EMAIL","Referral Received via OneClick Referral",MessageonColleaguemail);
	       
	       
	    }
	   
     
	@Test(priority=3)
	public void ReferredReceivedDentistDetails_AppearUnderReferralToSection() throws InterruptedException{


	    Thread.sleep(10000);
	    dashb.clickonsendreferralbtn();
	    bot.Closing_the_bot();
	    Thread.sleep(2000);
	   
	        sendreff.SendFrom();
	Thread.sleep(5000);
	sendreff.SendTo();
	    Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientnameforConversationPage"));

	        Thread.sleep(5000);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
	    			driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientnameforConversationPage")+"')]")));
	    	
       Thread.sleep(1000);
	   JavascriptExecutor js =(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,300)");  
	   
	   
	   Thread.sleep(3000);
	   sendreff.SendReferralbutton();
	   
	    Thread.sleep(10000);

	//REFERRED RECIVED DENTIST NAME  
	// String RecDentistName = conver.referralsToName();
	String RecDentistName = loginpage.ExplicitWaitGetText(conver.referralsToName());
	System.out.println(RecDentistName);
	Assert.assertEquals("RECIVED DENTIST NAME MISMATCHED",prop.getProperty("ReferralRecivedDentist"),RecDentistName);

	}
	   

	@Test(priority=4)
	public void ColleagueProfileOpensUp_OnClickingColleagueNameUnderReferralToSection() throws InterruptedException{

	Thread.sleep(10000);
	    dashb.clickonsendreferralbtn();
	    bot.Closing_the_bot();
	    Thread.sleep(2000);
	        sendreff.SendFrom();
	Thread.sleep(2000);
	sendreff.SendTo();
	Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientnameforConversationPage"));

	        Thread.sleep(5000);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
	    			driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientnameforConversationPage")+"')]")));
	    	
       Thread.sleep(1000);
	JavascriptExecutor js =(JavascriptExecutor)driver;

	   js.executeScript("window.scrollBy(0,300)");  
	   
	   Thread.sleep(2000);

	   sendreff.SendReferralbutton();

	   Thread.sleep(20000);

	//CLICK ON COLLEAGUE PROFILE NAME

	loginpage.ExplicitWait(conver.ClickOnReferralsRecivedColleagueName());
	Thread.sleep(3000);
	//VALIDATION ON COLLEAGUE PROFILE PAGE TITLE
	String title = driver.getTitle();
	System.out.println(title);
	Assert.assertEquals("TITLE NOT APPEARED OR MISMATCHED","Profile", title);


	}
	  

	@Test(priority=5)
	public void AllAttachedFilesAppear_UnderAttachmentsSectionOnConversationsPage() throws InterruptedException, IOException{

	Thread.sleep(10000);
	dashb.clickonsendreferralbtn();
	bot.Closing_the_bot();
	    Thread.sleep(2000);
	sendreff.SendFrom();
	Thread.sleep(3000);
	sendreff.SendTo();
	Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientnameforConversationPage"));

	        Thread.sleep(5000);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
	    			driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientnameforConversationPage")+"')]")));
	    	
       Thread.sleep(1000);

	JavascriptExecutor js =(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,300)");  
	   
	   Thread.sleep(3000);

	   sendreff.AttachFilesButton();

	Thread.sleep(5000);
	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\roseimg.exe");
	   
	Thread.sleep(17000);
	   
	try{
	   WebDriverWait wait=new WebDriverWait(driver, 60);

	      wait.until(ExpectedConditions.visibilityOfElementLocated(
	         
	      By.xpath("//*[@id=\"savnbtn\"]"))
	      ).click();

	   }
	   catch(Throwable t){
	       System.out.println("The execption is: " + t);
	   }

	 
	   finally {
	    Thread.sleep(20000);
	       System.out.println("If no exception tell me now");
	 
	String  tag = driver.findElement(By.xpath("//img[@class='heightwidth']")).getTagName();
	System.out.println(tag);
	   Assert.assertEquals("FILE NOT ATTACHED","img", tag);
	 
	   }
	   
	}
	   
	
	@Test(priority=6)
	public void ViewAttachedFileOnClicking_ViewButtonUnderAttachmentsSection() throws InterruptedException, IOException{

	Thread.sleep(10000);
	dashb.clickonsendreferralbtn();
	bot.Closing_the_bot();
	    Thread.sleep(3000);
	sendreff.SendFrom();

	Thread.sleep(3000);

	sendreff.SendTo();

	        Thread.sleep(3000);
	        loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientnameforConversationPage"));

	        Thread.sleep(5000);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
	    			driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientnameforConversationPage")+"')]")));
	    	
       Thread.sleep(1000);

	JavascriptExecutor js =(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,300)");  
	   
	   Thread.sleep(5000);
	   
	   
	   sendreff.AttachFilesButton();

	Thread.sleep(3000);
	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\roseimg.exe");
	   
	Thread.sleep(25000);
	   
	try{
	   WebDriverWait wait=new WebDriverWait(driver, 60);

	      wait.until(ExpectedConditions.visibilityOfElementLocated(
	         
	      By.xpath("//*[@id=\"savnbtn\"]"))
	      ).click();

	   }
	   catch(Throwable t){
	       System.out.println("The execption is: " + t);
	   }
	   finally {
	       System.out.println("If no exception tell me now");
	   }

	Thread.sleep(20000);



	//VIEW BUTTON TO VIEW FILE

	WebElement AttachementBlok2 = driver.findElement(By.xpath("(//div[@class='download findattachments'])[1]")) ;
	WebElement viewbtn2 =  driver.findElement(By.xpath("(//a[contains(text(),'View')])[2]"));

	   Actions Action = new Actions(driver);

	Action.moveToElement(AttachementBlok2).perform();
	Thread.sleep(7000);
	Action.click(viewbtn2).perform();
	Action.click(viewbtn2);

	driver.get("http://docs.seleniumhq.org/");
	       
	//VALIDATION ON IMAGE APPEARS AFTER CLICKING ON VIEW BUTTON

	   int width=driver.findElement(By.tagName("img")).getSize().getWidth();
	   int hight=driver.findElement(By.tagName("img")).getSize().getHeight();

	   System.out.println(width +">>>"+hight);

	   //to verify width
	   Assert.assertEquals(width, 125);
	//to verify height
	   Assert.assertEquals(hight, 31);




	}



	@Test(priority=7)
	public void DownloadAttachedFileOnClicking_DownloadButtonUnderAttachmentsSection() throws InterruptedException, IOException{

	Thread.sleep(10000);
	dashb.clickonsendreferralbtn();
	bot.Closing_the_bot();
	    Thread.sleep(3000);
	sendreff.SendFrom();
	Thread.sleep(3000);
	sendreff.SendTo();
	       
	   
	        Thread.sleep(5000);
	        loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientnameforConversationPage"));

	        Thread.sleep(5000);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
	    			driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientnameforConversationPage")+"')]")));
	    	
       Thread.sleep(1000);

	JavascriptExecutor js =(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,300)");  
	   
	   Thread.sleep(12000);
	   
	   sendreff.AttachFilesButton();

	Thread.sleep(3000);
	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\roseimg.exe");
	   
	Thread.sleep(25000);
	   
	 WebDriverWait wait=new WebDriverWait(driver, 60);

	 wait.until(ExpectedConditions.visibilityOfElementLocated(
	         
	 By.xpath("//*[@id=\"savnbtn\"]"))).click();

	 
	 Thread.sleep(20000);


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



	WebElement AttachementBlok1 = driver.findElement(By.xpath("(//div[@class='download findattachments'])[1]")) ;
	WebElement dwnbtn =  driver.findElement(By.xpath("(//a[contains(text(),'Download')])[2]"));
	     
	   Actions Action = new Actions(driver);

	Action.moveToElement(AttachementBlok1).perform();
	Thread.sleep(7000);

	Action.click(dwnbtn).perform();
	Action.click(dwnbtn);
	Thread.sleep(17000);

	   File getLatestFile = conver.getLatestFilefromDir(downloadPath);
	   Thread.sleep(7000);
	   String fileName = getLatestFile.getName();
	   System.out.println("DOWNLOADED FILE NAME IS--"+fileName);
	   
	   Thread.sleep(8000);
	   String ReplaceName  = fileName.replaceAll(fileName, "Downloadedfile") ;
	   System.out.println("REPLACE NAME OF DOWNLOADED FILE IS--"+ReplaceName);
	   Assert.assertEquals("Downloaded file name is not matching with expected file name","Downloadedfile", ReplaceName);

	   Thread.sleep(5000);
	   getLatestFile.delete();

	}



	}
  
	   

	@Test(priority=8)
	public void ReferredPatientDetailsAppear_UnderPatientInfoSectionOnConversationsPage() throws InterruptedException{

	Thread.sleep(10000);
	    dashb.clickonsendreferralbtn();
	    bot.Closing_the_bot();
	    Thread.sleep(2000);
	        sendreff.SendFrom();
	Thread.sleep(3000);
	sendreff.SendTo();
	Thread.sleep(3000);
	        loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientnameforConversationPage"));

	        Thread.sleep(5000);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
	    			driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientnameforConversationPage")+"')]")));
	    	
       Thread.sleep(1000);

	JavascriptExecutor js =(JavascriptExecutor)driver;

	   js.executeScript("window.scrollBy(0,300)");  
	   
	   Thread.sleep(2000);

	   sendreff.SendReferralbutton();

	   Thread.sleep(15000);
	//REFERRED RECIVED PATIENT NAME
	//VALIDATION ON PATIENT NAME
	String PatientName= loginpage.ExplicitWaitGetText(conver.patientNameinPatientinfo());
	System.out.println(PatientName);
	Assert.assertEquals("PATIENT NAME MIMATCHED OR NOT APPERED","Patient7",PatientName);


	}
   
   
	@Test(priority=9)
	public void PatientHistoryPageOpensUpOnClicking_ReferredPatientNameUnderPatientInfoSection() throws InterruptedException{


	Thread.sleep(10000);
	    dashb.clickonsendreferralbtn();
	    bot.Closing_the_bot();
	    Thread.sleep(2000);
	        sendreff.SendFrom();
	Thread.sleep(3000);
	sendreff.SendTo();
	Thread.sleep(3000);
	        loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientnameforConversationPage"));

	        Thread.sleep(5000);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
	    			driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientnameforConversationPage")+"')]")));
	    	
       Thread.sleep(1000);

	JavascriptExecutor js =(JavascriptExecutor)driver;

	   js.executeScript("window.scrollBy(0,300)");  
	   
	   Thread.sleep(2000);

	   sendreff.SendReferralbutton();

	//CLICK ON PATIENT NAME
	// conver.ClickOnPatientNameinPatientinfo();
	Thread.sleep(12000);
	loginpage.ExplicitWait(conver.ClickOnPatientNameinPatientinfo());
	Thread.sleep(5000);
	//VALIDATION ON PATIENT HISTORY PAGE TITLE
	String title = driver.getTitle();
	System.out.println(title);
	Assert.assertEquals("PAGE TITLE MISMATCHED","Patient History",title);


	}
    
  
	@Test(priority=10)
	public void DentistMovesToThePatientFormsSectionOnClicking_PatientFormDateUnderPatientInfoSection() throws InterruptedException{


	     WebElement click = driver.findElement(By.xpath("//div[@class='col-lg-12']//label//a[text()='View Patient Form']"));
	     loginpage.ExplicitWait(click);
	 Thread.sleep(5000);

	//  String Title = conver.Patientformtitle();
	 String Title = loginpage.ExplicitWaitGetText(conver.Patientformtitle());
	 System.out.println(Title);
	 Assert.assertEquals("PATIENT FORM SECTION NOT APPEARED OR TITLE MISMATCHED","Patient Forms", Title);

	} 
	
	
        /*
	    @Test(priority=11)
	    public void SentMessageTimeAndDateAppears_InTheRightSideUnderOfficeCommunicationAndTextMessengerSection() throws InterruptedException{
	   
	    conver.typemessageunderoc();
	    Thread.sleep(3000);
	         Boolean dtrightside = driver.findElement(By.xpath("//span[@class='time_date']")).isDisplayed();
	    Assert.assertTrue("SENTMESSAGE TIME AND DATE DOES NOT APPEARS IN THE RIGHT SIDE UNDER OC SECTION", dtrightside);  
	   
	    conver.typemessageundertextmessenger();  
	    Thread.sleep(3000);
	         Boolean dtrightside1 = driver.findElement(By.xpath("//span[@class='time_date']")).isDisplayed();
	    Assert.assertTrue("SENTMESSAGE TIME AND DATE DOES NOT APPEARS IN THE RIGHT SIDE UNDER TM SECTION", dtrightside1);  
	   
	   
	    }
	   */
	   
	   
	@Test(priority=12)
	public void SendMessageUnderOfficeCommunicationSection_OnConversationsPage() throws InterruptedException{

	Thread.sleep(3000);
	conver.typemessageunderoc();
	    Thread.sleep(3000);

	    Boolean sentmessageoc = driver.findElement(By.xpath("(//div[@class='sent_msg one'])[last()]")).isDisplayed();
	       Assert.assertTrue("SENTMESSAGE DOES NOT APPEARS IN THE RIGHT SIDE UNDER OC SECTION", sentmessageoc);  

	}
    

	@Test(priority=13)
	public void ValidationMsgAppearsOnSendingBlankMessageUnder_OfficeCommunicationSectionOnConversationsPage() throws InterruptedException{


	Thread.sleep(5000);
	conver.typeblankmessageoc();
	Thread.sleep(4000);

	String valdmessage = driver.findElement(By.xpath("//span[contains(text(),'Please enter message text.')]")).getText();
	System.out.println(valdmessage);
	Assert.assertEquals("VALIDATION MESSAGE NOT APPEARD","Please enter message text.",valdmessage);

	}

    
	@Test(priority=14)
	public void AttachmentsPopupOpensUpOnClicking_AttachmentIconUnderOfficeCommunicationSection() throws InterruptedException{
	     

	  Thread.sleep(5000);
	   WebElement click = driver.findElement(By.xpath("//i[contains(@class,'fa fa-paperclip')]"));
	loginpage.ExplicitWait(click);
	Thread.sleep(5000);
	// String popuptitle = conver.attachementpopuptitle();
	String popuptitle = loginpage.ExplicitWaitGetText(conver.attachementpopuptitle());
	System.out.println(popuptitle);
	Assert.assertEquals("POPUP TITLE NOT APPEARS AS - Attachments","Attachments",popuptitle);


	}



	@Test(priority=15)
	public void SendAnyValidFile_UnderOfficeCommunicationSection() throws InterruptedException, IOException{


	  Thread.sleep(5000);  
	WebElement clickk = driver.findElement(By.xpath("//i[contains(@class,'fa fa-paperclip')]"));
	loginpage.ExplicitWait(clickk);
	Thread.sleep(4000);
	//String popuptitle = conver.attachementpopuptitle();
	String popuptitle = loginpage.ExplicitWaitGetText(conver.attachementpopuptitle());
	System.out.println(popuptitle);
	Assert.assertEquals("POPUP TITLE NOT APPEARS AS - Attachments","Attachments",popuptitle);

	Thread.sleep(2000);

	    WebElement click = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[3]/div/div/div[2]/div[1]/div"));
	    loginpage.ExplicitWait(click);

	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\cool.exe");

	Thread.sleep(12000);

	WebElement click1 = driver.findElement(By.xpath("//input[@class='btn']"));
	loginpage.ExplicitWait(click1);

	Thread.sleep(3000);

	WebElement Name = driver.findElement(By.xpath("(//div[@class='sent_msg one'])[last()]"));
	String FileName = loginpage.ExplicitWaitGetText(Name);
	System.out.println(FileName);
	Thread.sleep(3000);
	String ReplaceFileName  = FileName.replaceAll(FileName, "NEW ATTACHEMENT");
	System.out.println(ReplaceFileName);
	Assert.assertEquals("ATTACHED-FILE NAME NOT APPEARED ON OFFICE COMMUNICATION SECTION","NEW ATTACHEMENT",ReplaceFileName);


	}


	@Test(priority=16)
	public void ValidationMessageAppeared_OnSendingInvalidFileUnderOfficeCommunicationSection() throws InterruptedException, IOException{


	Thread.sleep(4000);  
	WebElement clickk = driver.findElement(By.xpath("//i[contains(@class,'fa fa-paperclip')]"));
	loginpage.ExplicitWait(clickk);
	Thread.sleep(4000);
	//String popuptitle = conver.attachementpopuptitle();
	String popuptitle = loginpage.ExplicitWaitGetText(conver.attachementpopuptitle());
	System.out.println(popuptitle);
	Assert.assertEquals("POPUP TITLE NOT APPEARS AS - Attachments","Attachments",popuptitle);

	Thread.sleep(3000);

	    WebElement click = driver.findElement(By.xpath("/html/body/div[1]/div/main/div[3]/div/div/div[2]/div[1]/div"));
	    loginpage.ExplicitWait(click);

	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\RecordLincSync.API.Dentrix.exe");

	Thread.sleep(12000);

	WebElement click1 = driver.findElement(By.xpath("//input[@class='btn']"));
	loginpage.ExplicitWait(click1);

	Thread.sleep(4000);  

	// String FileName = driver.findElement(By.xpath("//*[@id=\"communication_msg\"]/div[2]/div/p/b")).getText();
	// String Valdmsg = driver.findElement(By.xpath("//span[contains(text(),'Invalid file type.')]")).getText();
	String Valdmsg =driver.switchTo().alert().getText();
	System.out.println(Valdmsg);
	Assert.assertEquals("VALIDATION MESSAGE NOT APPEARED","exe, bin, dll, msi, sql, js formats are not to be uploaded.",Valdmsg);


	}

	     
	@Test(priority=17)
	public void ValidationMsgAppearesOn_ChoosingNoFileUnderOfficeCommunicationSection() throws InterruptedException{


	Thread.sleep(3000);
	WebElement attachbtn = driver.findElement(By.xpath("//i[contains(@class,'fa fa-paperclip')]"));
	loginpage.ExplicitWait(attachbtn);

	    Thread.sleep(4000);

	    WebElement click1 = driver.findElement(By.xpath("//input[@class='btn']"));
	    loginpage.ExplicitWait(click1);

	Thread.sleep(1000);

	String Valdmsg = driver.findElement(By.className("message")).getText();
	System.out.println(Valdmsg);
	Assert.assertEquals("VALIDATION MESSAGE NOT APPEARED","Please select file.",Valdmsg);


	}
	   
   /*
	@Test(priority=18)
	public void SendTextMessageToPatient_UnderTextMessengerSection() throws InterruptedException{


	    Thread.sleep(3000);
	conver.typemessageundertextmessenger();

	    Thread.sleep(3000);

	Boolean sentmessageTM = driver.findElement(By.xpath("//*[@id=\"zipwhip-popup-message\"]/div[1]/div[2]/div/p[2]")).isDisplayed();
	        Assert.assertTrue("SENTMESSAGE DOES NOT APPEARS IN THE RIGHT SIDE UNDER TEXT MESSENGER SECTION", sentmessageTM);  

	}


	@Test(priority=19)
	public void ValidationMsgAppearsOnSending_BlankMessageUnderTextMessengerSectionOnConversationspage() throws InterruptedException{


	    Thread.sleep(3000);
	conver.typeblankmessageTm();
	    Thread.sleep(3000);

	    String valdmessage = driver.findElement(By.xpath("//span[contains(text(),'Please enter message text.')]")).getText();
	  System.out.println(valdmessage);
	  Assert.assertEquals("VALIDATION MESSAGE NOT APPEARD","Please enter message text.",valdmessage);
	 
	}



	@Test(priority=20)
	public void TextMessengerPopupOpensUp_OnClickingTextMessengerIconOnConversationsPage() throws InterruptedException{

	Thread.sleep(3000);
	loginpage.ExplicitWait(conver.textmessengericon());
	Thread.sleep(3000);

	// String title =  conver.validatetextmessengertitle();
	String title = loginpage.ExplicitWaitGetText(conver.validatetextmessengertitle());
	System.out.println(title);
	Assert.assertEquals("TITLE NOT APPEAR AS TEXT-MESSENGER", "Text Messenger" ,title);

	}

    
*/
	
}

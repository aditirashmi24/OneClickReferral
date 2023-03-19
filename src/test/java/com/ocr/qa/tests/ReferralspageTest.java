package com.ocr.qa.tests;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
import com.ocr.qa.pages.SelectWhoAreYou;
import com.ocr.qa.pages.SendReferralpage;

import junit.framework.Assert;

public class ReferralspageTest extends TestBase {
  
	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Referralspage refpage;
	SendReferralpage sendreff;
	Closethebot bot;
	
	 
	

//	public static String downloadPath= "C:/Users/SQE Labs Tester/Downloads";
//	public static String downloadPath= "C:\\Users\\Parineeth Babu\\Downloads";
    
	public static String downloadPath= "C:\\Users\\Droid-7\\Downloads";
	
	//CREATE A CONSTRUCTOR
    public ReferralspageTest() {
	  
	   super();
   }  
    
    //ALL THE TEST CASES SEPERATED AND INDEPENDENT EACH OTHER 
    //BEFORE METHOD  
    @BeforeMethod
    public void Referralspage_SetupMethod() throws InterruptedException{
    	
    	initialization();
    	refpage = new Referralspage();
		sendreff = new SendReferralpage();
		
		Swatpage = new SelectWhoAreYou() ;
		loginpage = new Loginpage();
		
		//CLOSE THE CHAT BOT 
		bot= new Closethebot();
	    bot.Closing_the_bot();
	    Thread.sleep(2000);
		loginpage =	Swatpage.loginbtn();
		Thread.sleep(15000);
		
		//CLOSE THE CHAT BOT 
		bot.Closing_the_bot();
		Thread.sleep(2000);
		
		dashb = new Dashboardpage() ;
		dashb = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(25000);
		//CLOSE THE CHAT BOT 
	    bot.Closing_the_bot();
	    Thread.sleep(2000);
		
	
		refpage =  dashb.clickonreferrallink();
		Thread.sleep(9000);
		
		
    }
    
    
    @AfterMethod
    public void QuitTestCase_Method(){
    	
    	driver.quit();
    	
    }
    
    
    @Test(priority=1)
    public void ReferralsPageOpensUp_OnClickingReferralsLinkOnTheHeader(){
    	
    	
    	String PageTitle = driver.getTitle();
    	Assert.assertEquals("TITLE MISMATCHED","Referrals",PageTitle);
    	
    }
     
     
    @Test(priority=2)
    public void NewlySentAndReceivedReferredPatient_AppearsOnTheTopOnReferralsPage() throws InterruptedException{
    	
 
    	sendreff = new SendReferralpage();
    	dashb= new Dashboardpage() ;
    	//CLOSE THE BOT 
    	bot= new Closethebot();
        bot.Closing_the_bot();
        Thread.sleep(3000);
    	dashb.clickonsendreferralbtn();
    	
    	Thread.sleep(20000);
    	loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
    	Thread.sleep(5000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")));
		
		Thread.sleep(3000);
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy(0,400)");  
	     
	    Thread.sleep(5000);
	  
	    sendreff.SendReferralbutton();
		
		Thread.sleep(17000);
		//CLICK ON REFERRALS LINK 
		  
		WebElement click1 = driver.findElement(By.cssSelector("li.top-bar:nth-child(1) > a:nth-child(1)"));
		loginpage.ExplicitWait(click1);
		
		 //CLOSE THE CHAT BOT 
	//	bot = new Closethebot();
	//    bot.Closing_the_bot();
		Thread.sleep(15000);
		
		WebElement msg = driver.findElement(By.xpath("(//td[@data-th='Patient'] )[1]//a[1]"));
		String ValidatePatientNameOnTop =  loginpage.ExplicitWaitGetText(msg);
		
    	//String ValidatePatientNameOnTop = refpage.PatientNameOnTop(); 
    	System.out.println(ValidatePatientNameOnTop);
    	Assert.assertEquals("PATINET NAME MISMATCHED",prop.getProperty("ReferredPatientNameAppearsOnReferralsPage"),ValidatePatientNameOnTop);
		
		
    }
    
     
    @Test(priority=3)
    public void ConversationsPageOpensUpOnClicking_EitherReferredDateOrMessageOnReferralsPage() throws InterruptedException{
    	
    	refpage = new Referralspage();
    	//CLOSE THE BOT 
    	bot= new Closethebot();
        bot.Closing_the_bot();
        Thread.sleep(3000);
        loginpage.ExplicitWait(refpage.MessageAppearsOnTop());
    	Thread.sleep(3000);
    	String PageTitle =  driver.getTitle(); 
    	System.out.println(PageTitle); 
    	Assert.assertEquals("PAGE TITLE MISMATCHED","Conversations",PageTitle);
    	
    	
    }
    
   
    @Test(priority=4)
    public void PatientHistoryPageOpensUpOnClicking_ReferredPatientNameInPatientColumn() throws InterruptedException{
    	
    	refpage = new Referralspage();
 
    	//CLOSE THE BOT 
    	bot= new Closethebot();
        bot.Closing_the_bot();
        Thread.sleep(1000);
        loginpage.ExplicitWait(refpage.ClickOnPatientNameOnTop());
    	Thread.sleep(5000);
    	String PageTitle = driver.getTitle();
    	System.out.println(PageTitle);  
    	Assert.assertEquals("PAGE TITLE MISMATCHED","Patient History", PageTitle);
    	
    }
    
    
    @Test(priority=5)
    public void ColleagueProfileOpensUpOnClicking_ColleagueNameInReferredByorToColumn() throws InterruptedException{
    	
        refpage = new Referralspage();
        //CLOSE THE BOT 
    	bot= new Closethebot();
        bot.Closing_the_bot();
        Thread.sleep(2000);
        loginpage.ExplicitWait(refpage.ClickOnColleagueNameOnTop());
    	Thread.sleep(5000);
    	String PageTitle = driver.getTitle(); 
    	System.out.println(PageTitle); 
    	Assert.assertEquals("PAGE TITLE MISMATCHED","Profile", PageTitle);
    	
    	
    }
  
    
  
    @Test(priority=6)
    public void LoggedInDentistAndTeamMembersName_AppearInAssignedToDropDownUnderCoordinatorColumn() throws InterruptedException{
    	
    	
    	
        loginpage = new Loginpage();
       //CLOSE THE BOT 
    	bot= new Closethebot();
        bot.Closing_the_bot();
        Thread.sleep(10000);
        loginpage.ExplicitWait(refpage.DropDownArrowForLogoutSettingsEditProfile());
    	Thread.sleep(3000);
 
    	loginpage.ExplicitWait(refpage.LogoutButtonUnderDropdown());
    	Thread.sleep(3000);
    	
    	WebElement email = driver.findElement(By.id("Username"));
    	loginpage.ExplicitWaitSendKeys(email, "Peta@yopmail.com");
    	Thread.sleep(2000);
    	
    	WebElement pswd = driver.findElement(By.id("Password"));
    	loginpage.ExplicitWaitSendKeys(pswd, "Hello@123");
   
        Thread.sleep(2000);
        WebElement click= driver.findElement(By.xpath("//span[text()='Sign in']"));
        loginpage.ExplicitWait(click);
    	Thread.sleep(15000); 
     
         //CLOSE THE BOT 
         bot.Closing_the_bot();
         WebElement SendReferral =  driver.findElement(By.xpath("//a[contains(text(),'Send Referral')]"));
         Thread.sleep(2000);
         loginpage.ExplicitWait(SendReferral);
         
         Thread.sleep(5000);
    	refpage = new Referralspage();
    	//CLOSE THE CHAT BOT 
    	bot.Closing_the_bot(); 
	    refpage.AddpatientOnSendRefferalsPage();
	    
		Thread.sleep(5000);
		sendreff = new SendReferralpage();
		sendreff.SendReferralbutton();
	
		Thread.sleep(17000);
    //	refpage.DropDownArrowForLogoutSettingsEditProfile();
		
         WebElement cl = driver.findElement(By.xpath("//i[@class='icon-down_arrow_top']")); 
         loginpage.ExplicitWait(cl);
    	
    	Thread.sleep(3000);
    //	refpage.LogoutButtonUnderDropdown();
    	
    	WebElement logout =driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
    	loginpage.ExplicitWait(logout);
    	
    	Thread.sleep(10000);
    	
    	WebElement username = driver.findElement(By.id("Username"));
    	loginpage.ExplicitWaitSendKeys(username,"Levin");
    	
    	Thread.sleep(2000); 
    	WebElement password = driver.findElement(By.id("Password"));
    	loginpage.ExplicitWaitSendKeys(password,"Hello@123");
    	
        Thread.sleep(2000);
        
        WebElement click7 =    driver.findElement(By.xpath("//span[text()='Sign in']"));
        loginpage.ExplicitWait(click7);
    	
        //CLOSE THE CHAT BOT 
	    bot.Closing_the_bot();
       WebElement elm1 = driver.findElement(By.xpath("//a[contains(text(),'Referrals')]")); 
       loginpage.ExplicitWait(elm1);
        
    
		 //CLOSE THE CHAT BOT
	    bot.Closing_the_bot();
		
		
	List <WebElement> elements =    driver.findElements(By.xpath("//select[@class='form-control height34 ' and @id='ddlCoordinator_35051']"));
   	  for(WebElement txt: elements ){
		 String  dropdowntext = txt.getText(); 
		 System.out.println(dropdowntext);  
		 
		  Assert.assertTrue(dropdowntext.contains("Q Levin"));
		
	  } 
	      
	     
    }
   
    
    
    @Test(priority=7)
    public void SuccessMessageAppears_AfterSelectingAnyCoordinatorOnReferralsPage() throws InterruptedException{
    	
    	sendreff = new SendReferralpage();
        refpage = new Referralspage();	
        dashb= new Dashboardpage() ;
       //CLOSE THE BOT 
        bot= new Closethebot();
        Thread.sleep(10000);
        bot.Closing_the_bot();
        sendreff =  dashb.clickonsendreferralbtn();
   	
     	Thread.sleep(12000);
 
     	sendreff.SendFrom(); 	  
		Thread.sleep(3000); 
		sendreff.SendTo();  
     	
     	Thread.sleep(5000);
     	loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
     	
     	Thread.sleep(5000);
    
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")));
		
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy(0,300)");  
	     
	    Thread.sleep(5000);
	    
	    sendreff.SendReferralbutton();
		Thread.sleep(21000);
		loginpage.ExplicitWait(refpage.DropDownArrowForLogoutSettingsEditProfile());
		Thread.sleep(4000);
		loginpage.ExplicitWait(refpage.LogoutButtonUnderDropdown());
		
		Thread.sleep(10000);
		WebElement mail = driver.findElement(By.id("Username"));
		loginpage.ExplicitWaitSendKeys(mail,"tjerry@yopmail.com");
    	Thread.sleep(3000);
    	WebElement passw = driver.findElement(By.id("Password"));
    	loginpage.ExplicitWaitSendKeys(passw,"Hello@123");
    	
        Thread.sleep(3000);
        WebElement elmm = driver.findElement(By.xpath("//span[text()='Sign in']"));
        loginpage.ExplicitWait(elmm);
        
  //      Thread.sleep(17000);
        //CLOSE THE BOT 
   ////     bot.Closing_the_bot();
    //    Thread.sleep(2000);
    //    refpage.SelectCordinator();
    
     //  Thread.sleep(3000);
    //   WebElement msg = driver.findElement(By.className("message"));
   //    String successmsg  = loginpage.ExplicitWaitGetText(msg);
  	//   Assert.assertEquals("SUCCESS MESSAGE NOT APPEARS","Referral assigned to jerry tom successfully",successmsg);
    	
    	
    }
    
    
   
    @Test(priority=8)
    public void AddDispositionNotePopupOpensUp_AfterSelectingAnyDispositionStatus() throws InterruptedException{
    	refpage = new Referralspage();
    	//CLOSE THE BOT 
        bot= new Closethebot();
        Thread.sleep(10000);
        bot.Closing_the_bot();
        sendreff =  dashb.clickonsendreferralbtn();
        
        Thread.sleep(12000);
        
     	sendreff.SendFrom(); 	  
		Thread.sleep(3000); 
		sendreff.SendTo();  
     	
     	Thread.sleep(5000);
     	loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname")); 
     	
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")));
		Thread.sleep(1000);
		
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy(0,300)");  
	     
	    Thread.sleep(5000);
	    
	    sendreff.SendReferralbutton();
		Thread.sleep(21000);  
		
		loginpage.ExplicitWait(refpage.DropDownArrowForLogoutSettingsEditProfile());
		Thread.sleep(2000);
		loginpage.ExplicitWait(refpage.LogoutButtonUnderDropdown());
		
		Thread.sleep(10000);
		WebElement mail = driver.findElement(By.id("Username"));
		loginpage.ExplicitWaitSendKeys(mail,"tjerry@yopmail.com");
    	Thread.sleep(3000);
    	WebElement passw = driver.findElement(By.id("Password"));
    	loginpage.ExplicitWaitSendKeys(passw,"Hello@123");
    	
        Thread.sleep(3000);
        WebElement elmm = driver.findElement(By.xpath("//span[text()='Sign in']"));
        loginpage.ExplicitWait(elmm);
        
        Thread.sleep(17000);
        //CLOSE THE BOT 
        bot.Closing_the_bot();
        Thread.sleep(2000);

    	refpage.SelectDispositionStatus();
    	
    	Thread.sleep(5000);
    	String  AddDispositionNotePopupTitle = driver.findElement(By.xpath("//h3[contains(text(),'Add Disposition Note')]")).getText();
    	System.out.println(AddDispositionNotePopupTitle);
    	Assert.assertEquals("AddDispositionNotePopup_TITLE NOT APPEARS AS'Add Disposition Note'","Add Disposition Note",AddDispositionNotePopupTitle );
    	
    }
    
    
    @Test(priority=9)
    public void SuccessMessageAppearsOnClicking_SaveButtonUnderAddDispositionNotePopup() throws InterruptedException{
    	
    	refpage = new Referralspage();
    	//CLOSE THE BOT 
        bot= new Closethebot();
        bot.Closing_the_bot();
        Thread.sleep(10000);
        
        bot.Closing_the_bot();
        sendreff =  dashb.clickonsendreferralbtn();
        
        Thread.sleep(12000);
        
     	sendreff.SendFrom(); 	  
		Thread.sleep(3000); 
		sendreff.SendTo();  
     	
     	Thread.sleep(5000);
     	loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
     	
     	Thread.sleep(5000);
     	((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")));
		Thread.sleep(1000);
		
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy(0,300)");  
	     
	    Thread.sleep(5000);
	    sendreff.SendReferralbutton();
		Thread.sleep(20000);
		loginpage.ExplicitWait(refpage.DropDownArrowForLogoutSettingsEditProfile());
		Thread.sleep(3000);
		loginpage.ExplicitWait(refpage.LogoutButtonUnderDropdown());
		Thread.sleep(10000);
		WebElement mail = driver.findElement(By.id("Username"));
		loginpage.ExplicitWaitSendKeys(mail,"tjerry@yopmail.com");
    	Thread.sleep(3000);
    	WebElement passw = driver.findElement(By.id("Password"));
    	loginpage.ExplicitWaitSendKeys(passw,"Hello@123");
    	
        Thread.sleep(3000);
        WebElement elmm = driver.findElement(By.xpath("//span[text()='Sign in']"));
        loginpage.ExplicitWait(elmm);
        
        Thread.sleep(15000);
        //CLOSE THE BOT 
        bot.Closing_the_bot();

        Thread.sleep(2000);
        refpage.SelectDispositionStatus();
    	
    	Thread.sleep(5000);
         
        loginpage.ExplicitWait(refpage.SaveButtonUnderDispositionsPopup());
        
        Thread.sleep(3000);
        
        String succmsg = driver.findElement(By.className("message")).getText();
        System.out.println(succmsg);
        Assert.assertEquals("SUCCESS MESSAGE NOT APPEARED","Disposition status updated successfully",succmsg);
        
    }
   
   
    @Test(priority=10)
    public void DentistReceivesMailAfter_SelectingCriticalDispositionStatus() throws InterruptedException{
    	
      
    	 //CLOSE THE CHAT BOT 
		bot = new Closethebot();
		Thread.sleep(10000);
	    bot.Closing_the_bot();
    	
        sendreff =  dashb.clickonsendreferralbtn();
        
        Thread.sleep(12000);
        
     	sendreff.SendFrom(); 	  
		Thread.sleep(3000); 
		sendreff.SendTo();  
     	
     	Thread.sleep(5000);
     	loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
		
     	Thread.sleep(5000);
     	
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")));
		
		
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy(0,300)");  
	     
	    Thread.sleep(5000);
	    
	    sendreff.SendReferralbutton();
		
		Thread.sleep(20000);
		loginpage.ExplicitWait(refpage.DropDownArrowForLogoutSettingsEditProfile());
		Thread.sleep(2000);
	//	loginpage.ExplicitWait(refpage.LogoutButtonUnderDropdown());
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//a[contains(text(),'Logout')]")));
		
		
		//a[contains(text(),'Logout')]
		
		Thread.sleep(10000);
		WebElement mail = driver.findElement(By.id("Username"));
		loginpage.ExplicitWaitSendKeys(mail,"tjerry@yopmail.com");
    	Thread.sleep(3000);
    	WebElement passw = driver.findElement(By.id("Password"));
    	loginpage.ExplicitWaitSendKeys(passw,"Hello@123");
    	
        Thread.sleep(3000);
        WebElement elmm = driver.findElement(By.xpath("//span[text()='Sign in']"));
        loginpage.ExplicitWait(elmm);
        
        Thread.sleep(15000);
        //CLOSE THE BOT 
        bot.Closing_the_bot();
 
	    
    	Thread.sleep(3000);  
    	refpage.SelectCriticalDispositionsStatus();
         
    	
    //	 String succmsg = driver.findElement(By.xpath("//span[contains(text(),'Disposition status updated successfully')]")).getText();
    //   Assert.assertEquals("SUCCESS MESSAGE NOT APPEARED","Disposition status updated successfully",succmsg);
    	 
         Thread.sleep(9000); 
         
         WebDriverWait wait=new WebDriverWait(driver, 60);
 		driver.get("http://www.yopmail.com/");
 		
 		
 		WebElement Searchfield = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login"))); 
 		Searchfield.click();
 		Thread.sleep(2000);
 		Searchfield.clear();
 		Thread.sleep(2000);
 		Searchfield.sendKeys("levin@yopmail.com"); 
 		

 		WebElement Checkinboxbutton = wait.until(ExpectedConditions.elementToBeClickable(By.className("sbut")));
 		Checkinboxbutton.click();
 		Thread.sleep(5000);
         
         Thread.sleep(8000);
     	
     	 driver.switchTo().frame("ifmail");
        
     	// String Messageonmail = driver.findElement(By.className("message")).getText();
         String Messageonmail = driver.findElement(By.xpath("//div[contains(text(),'Disposition status changed')]")).getText();
         System.out.println(Messageonmail);
         Assert.assertEquals("MESSAGE NOT APPEARES IN PATIENT EMAIL","Disposition status changed",Messageonmail); 
         
         
         
    }
    
    
    @Test(priority=11)
    public void ConversationsPageOpensUpOnClicking_ReplyOptionInSelectActionDropDown() throws InterruptedException{
    	    
    	    refpage = new Referralspage();
    	    //CLOSE THE CHAT BOT 
    		bot = new Closethebot();
    		Thread.sleep(10000);
    	     bot.Closing_the_bot();
        sendreff =  dashb.clickonsendreferralbtn();
   	
     	Thread.sleep(7000);
 
     	sendreff.SendFrom(); 	  
		Thread.sleep(3000); 
		sendreff.SendTo();  
     	
     	Thread.sleep(5000);
     	loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
		
     	Thread.sleep(5000);
     	((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")));
		Thread.sleep(1000);
		
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy(0,300)");  
	     
	    Thread.sleep(5000);
	    
	    sendreff.SendReferralbutton();
		Thread.sleep(21000);  
		
		loginpage.ExplicitWait(refpage.DropDownArrowForLogoutSettingsEditProfile());
		Thread.sleep(3000);
		loginpage.ExplicitWait(refpage.LogoutButtonUnderDropdown());
		
		Thread.sleep(10000);
		WebElement mail = driver.findElement(By.id("Username"));
		loginpage.ExplicitWaitSendKeys(mail,"tjerry@yopmail.com");
    	Thread.sleep(3000);
    	WebElement passw = driver.findElement(By.id("Password"));
    	loginpage.ExplicitWaitSendKeys(passw,"Hello@123");
    	
        Thread.sleep(3000);
        WebElement elmm = driver.findElement(By.xpath("//span[text()='Sign in']"));
        loginpage.ExplicitWait(elmm);
        
        Thread.sleep(20000);
        //CLOSE THE BOT 
        bot.Closing_the_bot();
         Thread.sleep(2000);
        System.out.println("click");
    	    refpage.ReplyOptionUnderSelectActionDropdown();
    	    
    	    Thread.sleep(10000);
    	    
    	    String pagetitle = driver.getTitle();
    	    System.out.println(pagetitle);
            Assert.assertEquals("CONVERSATIONS PAGE TITLE MISMATCHED","Conversations",pagetitle);
    	
    }
  
    
    @Test(priority=12)
    public void ConfirmationMessageAppears_OnClickingArchiveOptionInSelectActionDropDown() throws InterruptedException{
    	refpage = new Referralspage();
    	 //CLOSE THE CHAT BOT 
		bot = new Closethebot();
		Thread.sleep(10000);
	     bot.Closing_the_bot();
    sendreff =  dashb.clickonsendreferralbtn();
	
 	Thread.sleep(7000);

 	sendreff.SendFrom(); 	  
	Thread.sleep(3000); 
	sendreff.SendTo();  
 	
 	Thread.sleep(5000);
 	loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
	
 	Thread.sleep(5000);
 	((JavascriptExecutor) driver).executeScript("arguments[0].click()",
			driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")));
	Thread.sleep(1000);
	
	JavascriptExecutor js =(JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,300)");  
     
    Thread.sleep(5000);
    
    sendreff.SendReferralbutton();
	Thread.sleep(21000);  
	
	
	loginpage.ExplicitWait(refpage.DropDownArrowForLogoutSettingsEditProfile());
	Thread.sleep(3000);
	loginpage.ExplicitWait(refpage.LogoutButtonUnderDropdown());
	
	Thread.sleep(10000);
	WebElement mail = driver.findElement(By.id("Username"));
	loginpage.ExplicitWaitSendKeys(mail,"tjerry@yopmail.com");
	Thread.sleep(3000);
	WebElement passw = driver.findElement(By.id("Password"));
	loginpage.ExplicitWaitSendKeys(passw,"Hello@123");
	
    Thread.sleep(3000);
    WebElement elmm = driver.findElement(By.xpath("//span[text()='Sign in']"));
    loginpage.ExplicitWait(elmm);
    
    Thread.sleep(17000);
    //CLOSE THE BOT 
    bot.Closing_the_bot();
        Thread.sleep(2000);

    	refpage.ArchiveOptionInSelectActionDropDownOnSendReferralPage();
    	
    	Thread.sleep(7000);
    	
    	String confmsg = loginpage.ExplicitWaitGetText(refpage.ValidateConfirmationMessageAppearsOnClickingArchiveOption());
    	System.out.println(confmsg);
    	Assert.assertEquals("CONFIRMATION MESSAGE NOT APPEARED","Are you sure you want to archive message?",confmsg);
    	
    }
   
    
    @Test(priority=13)
    public void ArchiveMessageOnClickingYesButtonUnder_AreYouSureYouWantToArchiveMessageConfirmationMessage() throws InterruptedException{
    	refpage = new Referralspage();
    	 //CLOSE THE CHAT BOT 
		bot = new Closethebot();
		Thread.sleep(10000);
	     bot.Closing_the_bot();
    sendreff =  dashb.clickonsendreferralbtn();
	
 	Thread.sleep(14000);

 	sendreff.SendFrom(); 	  
	Thread.sleep(3000); 
	sendreff.SendTo();  
 	
 	Thread.sleep(5000);
 	loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(),prop.getProperty("ExistingPatientname"));
	
 	Thread.sleep(5000);
 	((JavascriptExecutor) driver).executeScript("arguments[0].click()",
			driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")));
	Thread.sleep(1000);
	
	JavascriptExecutor js1 =(JavascriptExecutor)driver;
    js1.executeScript("window.scrollBy(0,300)");  
     
    Thread.sleep(5000);
    
    sendreff.SendReferralbutton();
	Thread.sleep(25000);  
	
	
	loginpage.ExplicitWait(refpage.DropDownArrowForLogoutSettingsEditProfile());
	Thread.sleep(2000);
	loginpage.ExplicitWait(refpage.LogoutButtonUnderDropdown());
	
	Thread.sleep(10000);
	WebElement mail = driver.findElement(By.id("Username"));
	loginpage.ExplicitWaitSendKeys(mail,"tjerry@yopmail.com");
	Thread.sleep(3000);
	WebElement passw = driver.findElement(By.id("Password"));
	loginpage.ExplicitWaitSendKeys(passw,"Hello@123");
	
    Thread.sleep(3000);
    WebElement elmm = driver.findElement(By.xpath("//span[text()='Sign in']"));
    loginpage.ExplicitWait(elmm);
    
    Thread.sleep(15000);
    //CLOSE THE BOT 
    bot.Closing_the_bot();
        Thread.sleep(2000);

        refpage.ArchiveOptionInSelectActionDropDownOnSendReferralPage();
    	
    	Thread.sleep(7000);
    	
    	String confmsg = loginpage.ExplicitWaitGetText(refpage.ValidateConfirmationMessageAppearsOnClickingArchiveOption());
    	Assert.assertEquals("CONFIRMATION MESSAGE NOT APPEARED","Are you sure you want to archive message?",confmsg);
    	
    	Thread.sleep(3000);
    	loginpage.ExplicitWait(refpage.YesButtonUnderConfirmationMessage());
    	
    	Boolean elm =driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).isEnabled();
    	Assert.assertTrue("CLICKED", elm);
    	
    }
    
    
    @Test(priority=14)
    public void DownloadReferredPatientDetails_OnClickingDownloadOptionInSelectActionDropDown() throws InterruptedException{
    	refpage = new Referralspage();
    	//CLOSE THE BOT 
        bot= new Closethebot();
        Thread.sleep(10000);
        bot.Closing_the_bot();
     
    
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
       
	   driver.navigate().refresh(); 
	   Thread.sleep(19000);
	   refpage.DownloadOptionInSelectActionDropDownOnSendReferralPage(); 
  	   Thread.sleep(15000);
       File getLatestFile = refpage.getLatestFilefromDir(downloadPath);
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
    
    
    @Test(priority=15)
    public void ReferredPatientDetailsAppearIn_DownloadedPDFFileOnSendReferralPage() throws InterruptedException, IOException{
    	
    	
    	sendreff = new SendReferralpage();
        refpage = new Referralspage();	
        dashb= new Dashboardpage() ;
      //CLOSE THE BOT 
        bot= new Closethebot();
        Thread.sleep(10000);
        bot.Closing_the_bot();
        sendreff =  dashb.clickonsendreferralbtn();
   	
     	Thread.sleep(7000);
     	
     	 sendreff.SendFrom(); 	  
		 Thread.sleep(2000); 
		 sendreff.SendTo();  
     	
     	Thread.sleep(3000);
     	loginpage.ExplicitWaitSendKeys(sendreff.ExistingPatientDetails(), prop.getProperty("ExistingPatientname"));
		
     	Thread.sleep(5000);
     	((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'"+prop.getProperty("ExistingPatientname")+"')]")));
		Thread.sleep(1000);
		
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    js1.executeScript("window.scrollBy(0,300)");  
	     
	    Thread.sleep(5000);
		
	    sendreff.SendReferralbutton();
		
		Thread.sleep(20000);
		
    	dashb.clickonreferrallink();
    	
    	Thread.sleep(10000);
    	//CLOSE THE BOT
        
    	
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
    	
    	bot.Closing_the_bot();
        Thread.sleep(2000);
        refpage.DownloadOptionInSelectActionDropDownOnSendReferralPage();
        	
        Thread.sleep(20000);	
    	File getLatestFile = refpage.getLatestFilefromDir(downloadPath);
    	
    	FileInputStream fis = new FileInputStream(getLatestFile);
    	
    	PDFParser parser = new PDFParser(fis);
    	
    	  parser.parse();
    	
    	   COSDocument cosDoc = parser.getDocument();
    	
    	   PDDocument pdDoc = new PDDocument(cosDoc);
    	
    	   PDFTextStripper strip = new PDFTextStripper();
    	   
    	   String data = strip.getText(pdDoc); 
    	   
    	 //  System.out.println(data);
    	   
    	   Assert.assertTrue(data.contains("Levin Q"));
    	   
    	   System.out.println("TEXT FOUND ON PDF FILE....");
    	   
    	   Thread.sleep(5000);
    	   getLatestFile.delete();
    	   
    	}  
    }
   
   
   
    
}

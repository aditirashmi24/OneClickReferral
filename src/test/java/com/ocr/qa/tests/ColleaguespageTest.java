package com.ocr.qa.tests;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.base.TestBase;
import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Colleaguespage;
import com.ocr.qa.pages.Dashboardpage;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.SelectWhoAreYou;

import junit.framework.Assert;

public class ColleaguespageTest extends TestBase {

	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Colleaguespage collpage;
	Closethebot bot;
	
	//CREATE A CONSTRUCTOR
	public ColleaguespageTest(){
		
		super();
		
	} 
	//ALL THE TEST CASES SEPERATED AND INDEPENDENT TO EACH OTHER 
	
	//SETUP METHOD 
	@BeforeMethod
	public void ColleaguePage_SetupMethod() throws InterruptedException{
		
		initialization();
		collpage = new Colleaguespage(); 
		
		
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
		collpage =  dashb.clickoncolleagueslink();
		Thread.sleep(7000);
	}
	
	
	//QUIT METHOD 
	@AfterMethod 
	public void TestCase_QuitMethod(){
		
		driver.quit();
		
		
	}
	
	
 	@Test(priority=1)
	public void ColleaguesPageOpensUpOnClicking_ColleaguesLinkOnTheHeader() throws InterruptedException{
		
 		//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
    	Thread.sleep(2000);
		String title= collpage.pagetitle();
		System.out.println(title);  
	//VALIDATION ON "COLLEAGUES" PAGE TITLE
		Assert.assertEquals("Colleagues", title); 
		System.out.println(title);
	}  
	
	
 	@Test(priority=2)
	public void ColleagueProfileOpensUpOnClicking_AnyAddedColleagueName() throws InterruptedException{
		
 		//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
    	Thread.sleep(2000);
    	
   	try {
    		
    	collpage.searchfieldcolleagues();  
    		Thread.sleep(9000);
    		
   		WebElement colleagueName = driver.findElement(By.linkText("Five, Two"));
    	loginpage.ExplicitWait(colleagueName);
    		
    	//VALIDATION ON "Collegue Profile" TITLE
         String title =  driver.getTitle();
         System.out.println(title);	
    		Assert.assertEquals("Profile",title);
    		
    	}  
    	
   	 catch(Exception ex) {
    		
    	 Thread.sleep(2000);	
   		 loginpage.ExplicitWait(collpage.addcolleaguesbtn());
   		 Thread.sleep(3000);
   		 loginpage.ExplicitWaitSendKeys(collpage.namefieldonsearchcolleaguespage(),prop.getProperty("Addedcolleagename4"));
		 Thread.sleep(4000);
		 loginpage.ExplicitWait(collpage.submitbutton());
		JavascriptExecutor js =(JavascriptExecutor)driver;
	 	  js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		loginpage.ExplicitWait(collpage.addcolleaguesbtnaftersearchcolleagues());
		bot.Closing_the_bot();
	    
	    Thread.sleep(2000);
	    WebElement click =   driver.findElement(By.xpath("(//a[contains(text(),' Colleagues')])[3]"));
	    loginpage.ExplicitWait(click);
		Thread.sleep(5000);
		collpage.searchfieldcolleagues1();
        Thread.sleep(3000);
		
		WebElement colleagueName = driver.findElement(By.linkText("Five, Two"));
		loginpage.ExplicitWait(colleagueName);   
		
		//VALIDATION ON "Collegue Profile" TITLE
	    String title =  driver.getTitle();
	    System.out.println(title);
		Assert.assertEquals("Profile",title);
		
   	}
    
		
	} 
 	
 	
	@Test(priority=3) 
	public void SendReferralPageOpensUpOnClickingSendReferralOptn_InSelectActionDropDown() throws InterruptedException{
		
		//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
    	Thread.sleep(2000);
    	
    	
    	try {
    		collpage.searchfieldcolleagues();
    		
    		Thread.sleep(5000);
    		//VALIDATION ON "Send Referral" PAGE TITLE.
    		collpage.selectoption();
    		String title =  loginpage.ExplicitWaitGetText(collpage.sendreferralpagetitle());
    		Assert.assertEquals("TITLE MISSMATCHED ","Send Referral", title); 
    	}
		
		catch(Exception ex) {
			 Thread.sleep(2000);	
	   		 loginpage.ExplicitWait(collpage.addcolleaguesbtn());
	   		 Thread.sleep(3000);
	   		 loginpage.ExplicitWaitSendKeys(collpage.namefieldonsearchcolleaguespage(),prop.getProperty("Addedcolleagename4"));
			 Thread.sleep(4000);
			 loginpage.ExplicitWait(collpage.submitbutton());
			JavascriptExecutor js =(JavascriptExecutor)driver;
		 	  js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(3000);
			loginpage.ExplicitWait(collpage.addcolleaguesbtnaftersearchcolleagues());
			bot.Closing_the_bot();
		    
		    Thread.sleep(2000);
		    WebElement click =   driver.findElement(By.xpath("(//a[contains(text(),' Colleagues')])[3]"));
		    loginpage.ExplicitWait(click);
			Thread.sleep(5000);
			collpage.searchfieldcolleagues1();
			
			Thread.sleep(4000);
    		//VALIDATION ON "Send Referral" PAGE TITLE.
    		collpage.selectoption();
    		String title =  loginpage.ExplicitWaitGetText(collpage.sendreferralpagetitle());
    		Assert.assertEquals("TITLE MISSMATCHED ","Send Referral", title); 
			
		}
		
	} 
	
	
	
  	@Test(priority=4)
	public void ConfirmationMsgAppearsOnClickingDeleteOptn_UnderSelectActionDropDown() throws InterruptedException{
  		 
  	   //CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
    	Thread.sleep(2000);
    	
    	try {
    		
    		collpage.searchfieldcolleagues();  
   		 
   		 Thread.sleep(8000);
   		  collpage.selectdeleteoption();
   		     Thread.sleep(2000);
   		    String Popuptext =  loginpage.ExplicitWaitGetText(collpage.areyousureyouwanttoremove());
   		   //VALIDATION ON "Are you sure you want to remove?" CONFIRMATION MESSAGE. 
   		   Assert.assertEquals("POPPUP TITLE MISMATCHED","Are you sure you want to remove?",Popuptext);
    		
    	}
    	
    	catch(Exception ex) {
			 Thread.sleep(2000);	
	   		 loginpage.ExplicitWait(collpage.addcolleaguesbtn());
	   		 Thread.sleep(3000);
	   		 loginpage.ExplicitWaitSendKeys(collpage.namefieldonsearchcolleaguespage(),prop.getProperty("Addedcolleagename4"));
			 Thread.sleep(4000);
			 loginpage.ExplicitWait(collpage.submitbutton());
			JavascriptExecutor js =(JavascriptExecutor)driver;
		 	  js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(3000);
			loginpage.ExplicitWait(collpage.addcolleaguesbtnaftersearchcolleagues());
			bot.Closing_the_bot();
		    
		    Thread.sleep(2000);
		    WebElement click =   driver.findElement(By.xpath("(//a[contains(text(),' Colleagues')])[3]"));
		    loginpage.ExplicitWait(click);
			Thread.sleep(5000);
			collpage.searchfieldcolleagues1();
			
			Thread.sleep(8000);
	   		 collpage.selectdeleteoption();
	   		    Thread.sleep(2000);
	   		 String Popuptext =  loginpage.ExplicitWaitGetText(collpage.areyousureyouwanttoremove());
	   		 //VALIDATION ON "Are you sure you want to remove?" CONFIRMATION MESSAGE. 
	   		  Assert.assertEquals("POPPUP TITLE MISMATCHED","Are you sure you want to remove?",Popuptext);
			
		}
		
	}  

	
 	@Test(priority=5)
	public void DeleteAddedColleagueOnClickingYesBtn_UnderConfirmationMsg() throws InterruptedException{
 		
 		//CLOSE THE BOT 
    	bot= new Closethebot();
    	bot.Closing_the_bot();
    	Thread.sleep(2000);
	   	 
	   	try {
	   		
	   		collpage.searchfieldcolleagues();
	   		Thread.sleep(8000);
			collpage.selectdeleteoption();
		    Thread.sleep(3000);
		    loginpage.ExplicitWait(collpage.yesbutton());
			Thread.sleep(3000); 
			
			//VALIDATION ON "Colleague removed successfully" SUCCESS MESSAGE.
		//	String succmsg = collpage.colleaguesremovedsuccesfullyafterclickonyesbutton();
			WebElement msg = driver.findElement(By.className("message"));
			String succmsg =  loginpage.ExplicitWaitGetText(msg);
			System.out.println(succmsg);
		    Assert.assertEquals("TITLE MISMATCHED","Colleague removed successfully.",succmsg);
			
		
			
	   	}
	   	
	   	catch(Exception ex) {
			 Thread.sleep(5000);	
	   		 loginpage.ExplicitWait(collpage.addcolleaguesbtn());
	   		 Thread.sleep(3000);
	   		 loginpage.ExplicitWaitSendKeys(collpage.namefieldonsearchcolleaguespage(),prop.getProperty("Addedcolleagename4"));
			 Thread.sleep(4000);
			 loginpage.ExplicitWait(collpage.submitbutton());
			JavascriptExecutor js =(JavascriptExecutor)driver;
		 	  js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(3000);
			loginpage.ExplicitWait(collpage.addcolleaguesbtnaftersearchcolleagues());
			bot.Closing_the_bot();
		    
		    Thread.sleep(2000);
		    WebElement click =   driver.findElement(By.xpath("(//a[contains(text(),' Colleagues')])[3]"));
		    loginpage.ExplicitWait(click);
			Thread.sleep(5000);
			collpage.searchfieldcolleagues1();
			
			Thread.sleep(8000);
			collpage.selectdeleteoption();
		    Thread.sleep(3000);
		    loginpage.ExplicitWait(collpage.yesbutton());
			Thread.sleep(3000); 
			
			//VALIDATION ON "Colleague removed successfully" SUCCESS MESSAGE.
		//	String succmsg = collpage.colleaguesremovedsuccesfullyafterclickonyesbutton();
			WebElement msg = driver.findElement(By.className("message"));
			String succmsg =  loginpage.ExplicitWaitGetText(msg);
			System.out.println(succmsg);
		    Assert.assertEquals("TITLE MISMATCHED","Colleague removed successfully.",succmsg);
			
			
		}
	   	
			
	
      }  
 	  
 	   
       @Test(priority=6)
       public void ColleagueDetailsAppearOnEntering_ExistingDetailsInSearchFieldOnColleaguesPage() throws InterruptedException{
        	
    	 //CLOSE THE BOT 
         	bot= new Closethebot();
         	bot.Closing_the_bot();
        	Thread.sleep(2000);
        	
        	
        	try {
        		
        		collpage.searchfieldcolleagues();
        		//VALIDATION ON APPEARED COLLEAGUE NAME
        	 	String collname = loginpage.ExplicitWaitGetText(collpage.validateaddedcolleaguename());
        		System.out.println(collname);
        		Assert.assertEquals("INCORRECT OR COLLEAGUES NAME MISMATCHED",prop.getProperty("ValidateAddedColleaguesName"), collname);
        		
        		
        	}
        	
        	catch(Exception ex) {
   			 Thread.sleep(2000);	
   	   		 loginpage.ExplicitWait(collpage.addcolleaguesbtn());
   	   		 Thread.sleep(3000);
   	   		 loginpage.ExplicitWaitSendKeys(collpage.namefieldonsearchcolleaguespage(),prop.getProperty("Addedcolleagename4"));
   			 Thread.sleep(4000);
   			 loginpage.ExplicitWait(collpage.submitbutton());
   			JavascriptExecutor js =(JavascriptExecutor)driver;
   		 	  js.executeScript("window.scrollBy(0,500)");
   			Thread.sleep(3000);
   			loginpage.ExplicitWait(collpage.addcolleaguesbtnaftersearchcolleagues());
   			bot.Closing_the_bot();
   		    
   		    Thread.sleep(2000);
   		    WebElement click =   driver.findElement(By.xpath("(//a[contains(text(),' Colleagues')])[3]"));
   		    loginpage.ExplicitWait(click);
   			Thread.sleep(5000);
   			collpage.searchfieldcolleagues1();
   			
   		   //VALIDATION ON APPEARED COLLEAGUE NAME
    	 	String collname = loginpage.ExplicitWaitGetText(collpage.validateaddedcolleaguename());
    		System.out.println(collname);
    		Assert.assertEquals("INCORRECT OR COLLEAGUES NAME MISMATCHED",prop.getProperty("ValidateAddedColleaguesName"), collname);
   			
   		}
        	
        	
    		
      } 
	  
       
       
  	   @Test(priority=7) 
	   public void InformationMsgAppearsOnEntering_NonexistingColleagueNameInSearchColleaguesSearchField() throws InterruptedException{
  		 //CLOSE THE BOT 
        bot= new Closethebot();
        bot.Closing_the_bot();
       	Thread.sleep(2000);
		collpage.NoexistingcolleaguesSearchfield();
		
		Thread.sleep(3000);
		//VALIDATION ON 'No record found' INFORMATION MESSAGE.
		String msg = loginpage.ExplicitWaitGetText(collpage.NoRecordFoundInformationMessage());
		System.out.println(msg);
	    Assert.assertEquals("INFORMATION MESSAGE NOT APPEARS","No record found! Click here to Add Colleague",msg);
		
	 }  
      
  	   
 	   @Test(priority=8)
	   public void SearchColleaguesPageOpensUp_OnClickingAddColleaguesOptnOnColleaguesPage() throws InterruptedException{
 		 //CLOSE THE BOT 
 	     bot= new Closethebot();
 	     bot.Closing_the_bot();
 	     Thread.sleep(2000);
		 loginpage.ExplicitWait(collpage.addcolleaguesbtn());
		 Thread.sleep(3000);
		//VALIDATE WITH SEARCH COLLEAGUES PAGE TITLE
		String title =  loginpage.ExplicitWaitGetText(collpage.searchcolleagues()) ;
		Assert.assertEquals("PAGE TITLE NAME MISMATCHED","Search Colleagues",title); 
		
		
	 }
	 
	 
  	  @Test(priority=9)
	  public void ColleagueProfileOpensUp_OnClickingAnyColleagueNameUnderSearchColleaguesPage() throws InterruptedException{
  		  
  	  //CLOSE THE BOT 
  	    bot= new Closethebot();
  	    bot.Closing_the_bot();
  	    Thread.sleep(2000); 
		loginpage.ExplicitWait(collpage.addcolleaguesbtn());
		Thread.sleep(3000);
		//VALIDATE WITH SEARCH COLLEAGUES PAGE TITLE
		String title = loginpage.ExplicitWaitGetText( collpage.searchcolleagues());
		Assert.assertEquals("PAGE TITLE NAME MISMATCHED","Search Colleagues",title); 
		loginpage.ExplicitWaitSendKeys(collpage.namefieldonsearchcolleaguespage1(),prop.getProperty("ColleaguesPageColleagueName"));
		Thread.sleep(4000);
		loginpage.ExplicitWait(collpage.submitbutton1());
		Thread.sleep(4000);
		collpage.clickoncolleaguesname(); 
		 
		 //VALIDATION ON "Collegue Profile" TITLE.
		 String title2 = loginpage.ExplicitWaitGetText(collpage.colleagueprofiletitle());
		 Assert.assertEquals("TITLE MISMATCHED","Colleague Profile", title2); 
		 
	}  
	
  	 
 	@Test(priority=10)
	public void RecordsGetDisplayedAccToThefilterUsed_AfterClickingOnSubmitBtn_OnSearchColleaguesPage() throws InterruptedException{
		
 		//CLOSE THE BOT 
  	    bot= new Closethebot();
  	    bot.Closing_the_bot();
  	    Thread.sleep(2000); 
		loginpage.ExplicitWait(collpage.addcolleaguesbtn());
		Thread.sleep(3000);
		String title = loginpage.ExplicitWaitGetText(collpage.searchcolleagues()) ;
		//VALIADTE WITH SEARCH COLLEAGUES PAGE TITLE
		Assert.assertEquals("PAGE TITLE NAME MISMATCHED","Search Colleagues",title); 

		loginpage.ExplicitWaitSendKeys(collpage.emailfieldonsearchcolleaguespage(),prop.getProperty("ColleaguesPageColleagueEmailId"));
		Thread.sleep(4000);
		loginpage.ExplicitWait(collpage.submitbutton());
		Thread.sleep(5000);
		
		//VALIDATE WITH EMAIL-ID OF COLLEAGUES APPEARS AFTER CLICKING ON SUBMIT BUTTON
		String Appearingemailid = loginpage.ExplicitWaitGetText( collpage.emailidappearsafterclickingonsubmitbutton());
		System.out.println(Appearingemailid);
		Assert.assertEquals("EXISTING EMAILID MISMATCHED", prop.getProperty("ColleaguesPageColleagueEmailId"),Appearingemailid );
		
	}   
    
 	
	@Test(priority=11)  
	public void EnteredTextInAllTheSearchFieldsGetClearedAfter_ClickingOnCancelBtnOnSrchColleaguesPage() throws InterruptedException{
		
		//CLOSE THE BOT 
  	    bot= new Closethebot();
  	    bot.Closing_the_bot();
  	    Thread.sleep(2000); 
		loginpage.ExplicitWait(collpage.addcolleaguesbtn());
		Thread.sleep(3000);
		//VALIDATE WITH SEARCH COLLEAGUES PAGE TITLE
		String title = loginpage.ExplicitWaitGetText(collpage.searchcolleagues()) ;
		Assert.assertEquals("PAGE TITLE NAME MISMATCHED","Search Colleagues",title); 
		
		loginpage.ExplicitWaitSendKeys(collpage.namefieldonsearchcolleaguespage(),prop.getProperty("Addedcolleagename4"));
		Thread.sleep(1000);
		loginpage.ExplicitWaitSendKeys(collpage.emailfieldonsearchcolleaguespage(),prop.getProperty("ColleaguesPageColleagueEmailId"));
	    
		Thread.sleep(3000);
		loginpage.ExplicitWait(collpage.cancelbuttononsearchcolleaguespage());
	    Thread.sleep(2000); 
		
	    //VALIDATION ON NAME TEXT-FIELD PLACEHOLDER OR DEFAULT TEXT
	    Boolean res = collpage.validatenamefieldonsearchcolleaguespage();
	    Assert.assertFalse(res);
	    
	    //VALIDATION ON EMAIL TEXT-FIELD PLACEHOLDER OR DEFAULT TEXT
	    Boolean res1 = collpage.validateemailfieldonsearchcolleaguespage();
	    Assert.assertFalse(res1); 
	    
	}   
	
	
	
	@Test(priority=12)
	public void ColleagueGetsAddedAndAppearsOnColleaguePageAfterClicking_OnAddColleagueBtnOnSrchColleaguesPage() throws InterruptedException { 
		
		//CLOSE THE BOT 
  	    bot= new Closethebot();
  	    bot.Closing_the_bot();
  	    Thread.sleep(2000); 
		
		
		try {
			
			collpage.searchfieldcolleagues(); 
			
			
			Thread.sleep(9000);
			loginpage.ExplicitWait(collpage.colleaguespagelink());
			Thread.sleep(5000);
			collpage.searchfieldcolleagues1(); 
			
			Thread.sleep(5000);
		//VALIDATION ON APPEARED COLLEAGUE NAME
			String collname = loginpage.ExplicitWaitGetText(collpage.validateaddedcolleaguename()) ;
			System.out.println(collname);
			Assert.assertEquals("INCORRECT OR COLLEAGUES NAME MISMATCHED",prop.getProperty("ValidateAddedColleaguesName"), collname); 
		}
		
		catch(Exception ex) {
			 Thread.sleep(2000);	
	   		 loginpage.ExplicitWait(collpage.addcolleaguesbtn());
	   		 Thread.sleep(3000);
	   		 loginpage.ExplicitWaitSendKeys(collpage.namefieldonsearchcolleaguespage(),prop.getProperty("Addedcolleagename4"));
			 Thread.sleep(4000);
			 loginpage.ExplicitWait(collpage.submitbutton());
			JavascriptExecutor js =(JavascriptExecutor)driver;
		 	  js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(3000);
			loginpage.ExplicitWait(collpage.addcolleaguesbtnaftersearchcolleagues());
			bot.Closing_the_bot();
		    
		    Thread.sleep(2000);
		    WebElement click =   driver.findElement(By.xpath("(//a[contains(text(),' Colleagues')])[3]"));
		    loginpage.ExplicitWait(click);
			Thread.sleep(5000);
			collpage.searchfieldcolleagues1();
			
			
			
		//VALIDATION ON APPEARED COLLEAGUE NAME
			String collname = loginpage.ExplicitWaitGetText(collpage.validateaddedcolleaguename()) ;
			System.out.println(collname);
			Assert.assertEquals("INCORRECT OR COLLEAGUES NAME MISMATCHED",prop.getProperty("ValidateAddedColleaguesName"), collname);
			
		}
		
		
	}
	
	
	@Test(priority=13)
	public void InviteColleaguePageOpensUpOnClicking_InviteByEmailbtnOnAddColleaguesPage() throws InterruptedException{
		
		//CLOSE THE BOT 
  	    bot= new Closethebot();
  	    bot.Closing_the_bot();
  	    Thread.sleep(2000); 
		loginpage.ExplicitWait(collpage.addcolleaguesbtn());
		Thread.sleep(3000);
		
		//VALIDATE SEARCH COLLEAGUE PAGE TITLE
		String title = loginpage.ExplicitWaitGetText(collpage.searchcolleagues());
		Assert.assertEquals("PAGE TITLE NAME MISMATCHED","Search Colleagues",title); 
		Thread.sleep(3000);
	
		loginpage.ExplicitWait(collpage.invitebyemailButton());
		
		//VALIDATE INVITE COLLEAGUE PAGE TITLE
		String pagetitle = loginpage.ExplicitWaitGetText(collpage.invitecolleaguespagetitle()); 
		Assert.assertEquals("Title Mismatched","Invite Colleague", pagetitle);
		
	}  
	
   
    
	
	
}

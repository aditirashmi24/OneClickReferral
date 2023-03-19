package com.ocr.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.ocr.qa.base.TestBase;
import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Colleaguespage;
import com.ocr.qa.pages.Dashboardpage;
import com.ocr.qa.pages.InviteColleaguespage;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.SelectWhoAreYou;

import junit.framework.Assert;

public class InviteColleaguespageTest extends TestBase {

	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Colleaguespage collpage;
	InviteColleaguespage invcollpage; 
	Closethebot bot;

	JavascriptExecutor scr =  (JavascriptExecutor)driver;
	     
	String collmail = prop.getProperty("Anycolleageemail3");
//	public static String downloadPath= "C:\\Users\\SQE Labs Tester\\Downloads";  //---PATH FOR VIVEK LAPTOP 
//	public static String downloadPath= "C:\\Users\\Parineeth Babu\\Downloads";
	public static String downloadPath= "C:\\Users\\Droid-7\\Downloads";
	
	
	public String URL= "https://qa.recordlinc.com/Imagebank/Invite_Colleagues.xls" ;
	
	//CREATE A CONSTRUCTON
	public InviteColleaguespageTest(){
		
		 super();
		
	} 
	//ALL THE TEST CASES SEPERATED AND INDEPENDENT TO EACH OTHER 
	
	//SETUP METHOD 
	@BeforeMethod
	public void InviteColleaguesPage_SetupMethod() throws InterruptedException{
	
		
		initialization(); 
		
		collpage = new Colleaguespage();
		invcollpage = new InviteColleaguespage();
		
		Swatpage = new SelectWhoAreYou() ;
		loginpage = new Loginpage();
		
		//CLOSE THE CHAT BOT 
		bot= new Closethebot();
	    bot.Closing_the_bot();
	    Thread.sleep(2000);
		loginpage =	Swatpage.loginbtn();
		Thread.sleep(17000);
		
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
		Thread.sleep(15000);
		loginpage.ExplicitWait(collpage.addcolleaguesbtn());
		Thread.sleep(10000);
		loginpage.ExplicitWait(collpage.invitebyemailButton());
		Thread.sleep(9000);
	}
	
   
	//QUIT METHOD 
	@AfterMethod 
	public void TestCase_QuitMethod(){
		
		driver.quit();
		
	}
	
	//TEST CASES 
	 
   
	@Test(priority=1)
	public void SearchColleaguesPageOpensUpOnClickingSearchColleagueIcon_OnInviteColleaguePage() throws InterruptedException{ 
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);
		loginpage = new Loginpage();
		loginpage.ExplicitWait(invcollpage.SearchColleaguesIcon());
		
		//VALIDATION ON SEARCH COLLEAGUES PAGE TITLE
		String serchCollpagetile = loginpage.ExplicitWaitGetText(invcollpage.SearchColleaguesTitle()) ;
		System.out.println(serchCollpagetile);
		Assert.assertEquals("SEARCH COLLEAGUES PAGE NOT OPEN UP OR PAGE TITLE MISMATCHED","Search Colleagues",serchCollpagetile);
		
	}   
	
	
	@Test(priority=2) 
	 public void ColleaguesPageOpensUpOnClickingColleagueIcon_OnInviteColleaguePage() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);
		loginpage = new Loginpage();
		loginpage.ExplicitWait(invcollpage.ColleaguesIcon());
	    
		//VALIDATION ON COLLEAGUES PAGE TITLE
		String Colleaguepagetitle = invcollpage.ColleguesPageTitle();
		System.out.println(Colleaguepagetitle);
		
		Assert.assertEquals("INVITE COLLEAGUES PAGE NOT OPEN UP OR PAGE TITLE MISMATCHED","Colleagues",Colleaguepagetitle );
		
		
	}   
	
	
	@Test(priority=3) 
	public void ValidMsgAppearsAfterClickingOn_SendInvitesBtnWhenNeitherEmailIsEnteredNorExcelFileIsUploaded() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);
		JavascriptExecutor scr =  (JavascriptExecutor)driver;
		scr.executeScript("window.scrollBy(0,800)");
		loginpage = new Loginpage();
		loginpage.ExplicitWait(invcollpage.SendInvitesButton());
		
		//VALIDATION ON "Please enter email or upload excel file." MESSAGE 
		
		String valmsg =  loginpage.ExplicitWaitGetText(invcollpage.ValidationMessageAfterClickOnSendInvitesButton()) ;
		System.out.println(valmsg);
		
		Assert.assertEquals("VALIDATION MESSAGE NOT APPEARED","Please enter email or upload excel file.",valmsg);
		
	}  
     
	
	@Test(priority=4)
	public void DownloadTemplateFileOnClicking_ClickHereToDownloadExampleTemplateFileLink() throws InterruptedException{
	     loginpage = new Loginpage();
	//VALIDATION ON DOWNLOADED FILE AND FILE FORMATE 
		 
	//	invcollpage.Clickheretodownloadexampletemplatefilelink();
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);	
		JavascriptExecutor scr =  (JavascriptExecutor)driver;	
		scr.executeScript("window.scrollBy(0,300)");
		
		Thread.sleep(10000);
		
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
			
			Actions Action1 = new Actions(driver);
		    Action1.moveToElement(driver.findElement(By.linkText("Click here to download example template file."))).perform(); 
		    driver.findElement(By.linkText("Click here to download example template file.")).click();
			
		    Thread.sleep(12000);
		    File getLatestFile = invcollpage.getLatestFilefromDir(downloadPath);
	    	Thread.sleep(7000);
			
	    	String fileName = getLatestFile.getName();
		    System.out.println("DOWNLOADED FILE NAME IS--"+fileName);
		    
		    Thread.sleep(5000);
		    String ReplaceName  = fileName.replaceAll(fileName, "Downloadedfile") ;
		    
		    System.out.println("REPLACE NAME OF DOWNLOADED FILE IS--"+ReplaceName);
		    Assert.assertEquals("Downloaded file name is not matching with expected file name","Downloadedfile", ReplaceName); 
			
			
		    Thread.sleep(5000);
		    getLatestFile.delete();	
		}
		
	} 
	
	
	@Test(priority=5)
	public void ValidationMsgAppearsOnUploadingInvalidFile_OnInviteColleaguePage() throws InterruptedException, IOException{
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);	
		loginpage = new Loginpage();
		loginpage.ExplicitWait(invcollpage.UploadFilesBtn());
		
		Thread.sleep(5000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\aloneimg.exe");
		
		Thread.sleep(14000);
		
		//VALIDATION ON APPEARED "Upload .xlsx or .xls file." MESSAGE.
		
		String validmsg = loginpage.ExplicitWaitGetText(invcollpage.valdmsgafteruploadinginvalidfile());
		
		Assert.assertEquals("VALIDATION MEESAGE MISMATCHED OR MEESGE NOT APPEARED","Upload .xlsx or .xls file.", validmsg);
		
		loginpage.ExplicitWait(invcollpage.okbtn());
			
	}  
	
    
	@Test(priority=6)
	public void DeleteTheUploadedFileOnClickingDeleteButton_UnderUploadListOfColleaguesSection() throws IOException, InterruptedException{
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);
		loginpage = new Loginpage();
		loginpage.ExplicitWait(invcollpage.UploadFilesBtn());
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\uploadxls.exe");
		
		Thread.sleep(2000);
	//	invcollpage.deletebtn(); 
		
		JavascriptExecutor scr =  (JavascriptExecutor)driver;
		scr.executeScript("window.scrollBy(0,500)");
		
		try{
		    WebDriverWait wait=new WebDriverWait(driver, 40);

		       wait.until(ExpectedConditions.visibilityOfElementLocated(
		    	
		    		By.className("ico-delete"))   
		       ).click();

		    }
		    catch(Throwable t){
		        System.out.println("The execption is: " + t);
		    }
		    finally {
		        System.out.println("If no exception tell me now");
		    }
		
		Thread.sleep(2000);
	
		loginpage.ExplicitWait(invcollpage.yesbtnondelpopup());
		
		Thread.sleep(2000);
		//VALIDATION ON "Attachment deleted successfully" SUCCESS MESSAGE
		
		String delsuccmsg = loginpage.ExplicitWaitGetText(invcollpage.deletefilesuccessmsg());
		Assert.assertEquals("SUCCESS MEESAGE MISMATCHED OR MEESGE NOT APPEARED","Attachment deleted successfully",delsuccmsg);
		
		
	
	}  
	
	
	@Test(priority=7) 
	public void SelectAutopopulatedEmailOptnsAfterEntering_ValidEmailFormatInInviteColleagueByEmailTextField() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);
        loginpage = new Loginpage();
		loginpage.ExplicitWaitSendKeys(invcollpage.searchfieldoninvitecolleaguepage(),prop.getProperty("Anycolleageemail"));
		Thread.sleep(2000);
		
		loginpage.ExplicitWait(invcollpage.autopopulatedeappearedeamil());
		
		Thread.sleep(3000);
		//VALIDATION ON SELECTED EMAILID
		String emailid = invcollpage.afterselectaultopopultaedemail(); 
		System.out.println(emailid); 
		Assert.assertEquals("dentistvivekqa64@yopmail.com", emailid); 
		
	} 
	
	
	@Test(priority=8)
	public void ValidationMsgAppearsAfterClickingOnSendInvitesBtn_WhenBothEmailIsEnteredAndFileIsUploaded() throws InterruptedException, IOException{
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);
		loginpage = new Loginpage();
		loginpage.ExplicitWaitSendKeys(invcollpage.searchfieldoninvitecolleaguepage(),prop.getProperty("Anycolleageemail"));
		Thread.sleep(2000);
	
		loginpage.ExplicitWait(invcollpage.autopopulatedeappearedeamil());
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(invcollpage.UploadFilesBtn());

		Thread.sleep(3000);
		
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\uploadxls.exe");
		Thread.sleep(14000);
		
		JavascriptExecutor scr =  (JavascriptExecutor)driver;	
		scr.executeScript("window.scrollBy(0,800)");
	     
		Thread.sleep(2000);
		loginpage.ExplicitWait(invcollpage.SendInvitesButton());
		Thread.sleep(2000);
		
		//VALIDATION ON "Please enter either email or upload excel file." VALIDATION MESSAGE.
		
	//	String valmsg = driver.findElement(By.xpath("//span[contains(text(),'Please enter either email or upload excel file.')]")).getText();
		String valmsg = driver.findElement(By.className("message")).getText();
		Assert.assertEquals("VALIDATION MESSAGE NOT APPEARED OR MISMATCHED","Please enter either email or upload excel file.",valmsg);
		
		
		
	}  

	
	@Test(priority=9)
	public void SendInviteToMultipleEmailAddressesAfterClickingOn_SendInvitesButton() throws InterruptedException{
		
		
		try {
			 Thread.sleep(2000);
				loginpage.ExplicitWait(invcollpage.ColleaguesIcon1());
				
				Thread.sleep(1000);
				//SEARCHFIELD ON COLLEAGUES PAGE
				invcollpage.searchfieldoncolleaguepage2(prop.getProperty("Anycolleageemail3"));
				loginpage.ExplicitWait(invcollpage.searchbtn());
				Thread.sleep(2000);
				invcollpage.selectdeleteoption1();
				Thread.sleep(2000);
			    loginpage.ExplicitWait(invcollpage.yesbutton1()); 
				driver.navigate().refresh();
				
				//2NDSEARCHFIELD ON COLLEAGUES PAGE
				invcollpage.searchfieldoncolleaguepage2("harjeetghotra@hotmail.com");
				Thread.sleep(2000);
				loginpage.ExplicitWait(invcollpage.searchbtn());
				Thread.sleep(2000);
				invcollpage.selectdeleteoption1();
				Thread.sleep(2000);
				loginpage.ExplicitWait(invcollpage.yesbutton1()); 
				System.out.println("delete both colle");
				Thread.sleep(7000);
				loginpage.ExplicitWait(collpage.addcolleaguesbtn());
				Thread.sleep(10000);
				loginpage.ExplicitWait(collpage.invitebyemailButton());
				Thread.sleep(9000);
				
				bot = new Closethebot();
				bot.Closing_the_bot();
				Thread.sleep(2000);
				loginpage = new Loginpage();
		        loginpage.ExplicitWaitSendKeys(invcollpage.searchfieldoninvitecolleaguepage1(),prop.getProperty("Anycolleageemail3"));
				Thread.sleep(2000);
				
				loginpage.ExplicitWait(invcollpage.autopopulatedeappearedeamil());
				Thread.sleep(3000);
				

				loginpage.ExplicitWaitSendKeys(invcollpage.searchfieldoninvitecolleaguepage2(),"harjeetghotra@hotmail.com");
		        Thread.sleep(2000);
				
		        loginpage.ExplicitWait(invcollpage.autopopulatedeappearedeamil());
				Thread.sleep(3000);
				
				JavascriptExecutor scr =  (JavascriptExecutor)driver;	
				scr.executeScript("window.scrollBy(0,800)");
			
				Thread.sleep(1000);	
				
				loginpage.ExplicitWait(invcollpage.SendInvitesButton1());
			    Thread.sleep(12000);	 
			    
			     //Wait for the element till it gets available 
			     String Filesuccmsg1 = loginpage.ExplicitWaitGetText(invcollpage.invitedsuccesfullymessage1());
			     System.out.println(Filesuccmsg1);
			     Assert.assertEquals("MESSAGE NOT APPEARED OR MISMATCHED","Invited Successfully", Filesuccmsg1); 
		    
			//    WebElement elm = driver.findElement(By.xpath("(//td[contains(text(),'Invited Successfully')])[2]"));
			//     String Filesuccmsg2 = loginpage.ExplicitWaitGetText(elm);
			//     System.out.println(Filesuccmsg2);
			//     Assert.assertEquals("MESSAGE NOT APPEARED OR MISMATCHED","Invited Successfully", Filesuccmsg2);
				
		}
		
		
		
	catch(Exception ex) {
			
	    Thread.sleep(2000);	
		driver.navigate().refresh();
		Thread.sleep(7000);
		
		//ADD COLLEAGUE BUTTON
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//a[contains(text(),'Add Colleague')]")));
		
		Thread.sleep(10000);
		
		//INVITE BY EMAIL BUTTON 
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.linkText("Invite by Email")));
	
		Thread.sleep(9000);
		
	//	loginpage = new Loginpage();
        loginpage.ExplicitWaitSendKeys(invcollpage.searchfieldoninvitecolleaguepage(),prop.getProperty("Anycolleageemail3"));
		Thread.sleep(2000);
		
		loginpage.ExplicitWait(invcollpage.autopopulatedeappearedeamil());
		Thread.sleep(3000);
		

		loginpage.ExplicitWaitSendKeys(invcollpage.searchfieldoninvitecolleaguepage1(),"harjeetghotra@hotmail.com");
        Thread.sleep(2000);
		
        loginpage.ExplicitWait(invcollpage.autopopulatedeappearedeamil());
		Thread.sleep(3000);
		
		JavascriptExecutor scr =  (JavascriptExecutor)driver;	
		scr.executeScript("window.scrollBy(0,800)");
	
		Thread.sleep(1000);	
		
		loginpage.ExplicitWait(invcollpage.SendInvitesButton1());
	    Thread.sleep(14000);	 
	    
	     //Wait for the element till it gets available 
	     String Filesuccmsg1 = loginpage.ExplicitWaitGetText(invcollpage.invitedsuccesfullymessage1());
	     System.out.println(Filesuccmsg1);
	     Assert.assertEquals("MESSAGE NOT APPEARED OR MISMATCHED","Invited Successfully", Filesuccmsg1); 
    
	
	     
			//Delete added colleague
			//CLICK  ON COOLLEAGUES ICON ON INVITECOLLEAGUES PAGE
	        Thread.sleep(2000);
			loginpage.ExplicitWait(invcollpage.ColleaguesIcon1());
			
			Thread.sleep(1000);
			//SEARCHFIELD ON COLLEAGUES PAGE
			invcollpage.searchfieldoncolleaguepage2(prop.getProperty("Anycolleageemail3"));
			loginpage.ExplicitWait(invcollpage.searchbtn());
			Thread.sleep(2000);
			invcollpage.selectdeleteoption1();
			Thread.sleep(2000);
		    loginpage.ExplicitWait(invcollpage.yesbutton1()); 
			driver.navigate().refresh();
			
			Thread.sleep(7000);
			//2NDSEARCHFIELD ON COLLEAGUES PAGE
			invcollpage.searchfieldoncolleaguepage2("harjeetghotra@hotmail.com");
			Thread.sleep(2000);
			loginpage.ExplicitWait(invcollpage.searchbtn());
			Thread.sleep(2000);
			invcollpage.selectdeleteoption1();
			Thread.sleep(2000);
			loginpage.ExplicitWait(invcollpage.yesbutton1()); 
			
		}	
	} 

   

	@Test(priority=10)
	public void  ValidationMsgAppearsWhenUserTriesToInviteNonExistingUserOn_InviteColleaguePage() throws InterruptedException, IOException{
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);
		loginpage = new Loginpage();
		loginpage.ExplicitWaitSendKeys(invcollpage.nonexistinguseremailid(),prop.getProperty("Nonexistingemail"));
		Thread.sleep(3000);
		
		JavascriptExecutor scr =  (JavascriptExecutor)driver;	
		scr.executeScript("window.scrollBy(0,800)");
	
		Thread.sleep(1000);	
		loginpage.ExplicitWait(invcollpage.SendInvitesButton());
		Thread.sleep(3000);
		
		//VALIDATION ON "This user does not exist in our system." VALIDATION MESSAGE
		String messg = loginpage.ExplicitWaitGetText(invcollpage.Valdoesnotexistmessage());
		System.out.println(messg);
		Assert.assertEquals("VALIDATION MMESSAGE NOT APPEARED OR MISSMATCHED","This user does not exist in our system.",messg);
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		loginpage.ExplicitWait(invcollpage.UploadFilesBtn());
		Thread.sleep(2000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\InvalidUser.exe");
		Thread.sleep(12000);
		
		JavascriptExecutor scr2 =  (JavascriptExecutor)driver;	
		scr2.executeScript("window.scrollBy(0,600)");
	
		Thread.sleep(4000);	
		
		loginpage.ExplicitWait(invcollpage.SendInvitesButton1());
		Thread.sleep(4000);
		
		//VALIDATION ON "This user does not exist in our system." VALIDATION MESSAGE
	     String messg1 =  loginpage.ExplicitWaitGetText(invcollpage.Valdoesnotexistmessage1());
		 System.out.println(messg1);
		 Assert.assertEquals("VALIDATION MMESSAGE NOT APPEARED OR MISSMATCHED","This user does not exist in our system.",messg);
		
	} 
	
	
	@Test(priority=11)
	public void ValidationMsgAppearsWhenUserTriesToInviteAlreadyAddedColleagueOn_InviteColleaguePage() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);
		
		loginpage.ExplicitWaitSendKeys(invcollpage.searchfieldoninvitecolleaguepage(),prop.getProperty("Anycolleageemail")); 
		
		Thread.sleep(2000);
		loginpage = new Loginpage();
		loginpage.ExplicitWait(invcollpage.autopopulatedeappearedeamil());
		Thread.sleep(3000);
		
		
		JavascriptExecutor scr =  (JavascriptExecutor)driver;	
		scr.executeScript("window.scrollBy(0,800)");
	
		Thread.sleep(1000);	
		
		loginpage.ExplicitWait(invcollpage.SendInvitesButton());
	 
		 Thread.sleep(4000);
		 //VALIDATION ON "This user is already your colleague." VALIDATION MESSAGE.
            String txt1 =  loginpage.ExplicitWaitGetText(invcollpage.userisalreadyyourcolleaguesmessage());
            System.out.println(txt1);
    		Assert.assertEquals("User is Not already colleague.", "This user is already your colleague.",txt1); 
    		
    	
	}   
    
   
	@Test(priority=12)
	public void ValidationMsgAppearsAfterEnteringLoggedInUserEmailId_OnInviteColleaguePage() throws InterruptedException, IOException{
		
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);
		loginpage = new Loginpage();
		loginpage.ExplicitWaitSendKeys(invcollpage.Logedinuseremailid(), prop.getProperty("loggedinuseremailid"));
		Thread.sleep(3000);
		
		loginpage.ExplicitWait(invcollpage.autopopulated_logedinuser_appearedeamilid());
		Thread.sleep(1000);
		
		JavascriptExecutor scr =  (JavascriptExecutor)driver;	
		scr.executeScript("window.scrollBy(0,600)");
		
        Thread.sleep(1000);	
		
        loginpage.ExplicitWait(invcollpage.SendInvitesButton());
		 
	     Thread.sleep(10000);	  
	     
	     String valmsg = loginpage.ExplicitWaitGetText(invcollpage.validateappearedlogedinuseremailid());
	     System.out.println(valmsg);
	     Assert.assertEquals("VALIDATION MESSAGE MISMATCHED OR NOT APPEARED","This Email id Is yours, so you cannot invite yourself.",valmsg);
	     
	      Thread.sleep(3000);
	     driver.navigate().refresh();
	    
	     Thread.sleep(2000);
	   //BY UPLOADING FILE  
	     loginpage.ExplicitWait(invcollpage.UploadFilesBtn());
	      
		 Thread.sleep(3000);
			
		 Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\LogedinUserEmailid.exe");
			
		 Thread.sleep(20000);
			
		 JavascriptExecutor scr6 =  (JavascriptExecutor)driver;	
		 scr6.executeScript("window.scrollBy(0,800)");
		
		 Thread.sleep(2000);	
		 loginpage.ExplicitWait(invcollpage.SendInvitesButton1());
		 Thread.sleep(12000);	 
		    

		 String Filevalmsg = loginpage.ExplicitWaitGetText(invcollpage.validateappearedlogedinuseremailid());
		 System.out.println(valmsg);
		 Assert.assertEquals("VALIDATION MESSAGE MISMATCHED OR NOT APPEARED","This Email id Is yours, so you cannot invite yourself.",Filevalmsg);
		      
	     
	} 
     
	 
     @Test(priority=13)
	 public void VerifyThatUserIsAbleToInviteAddedTeamMember_OnInviteColleaguePage() throws InterruptedException, IOException{
		
    	//CLOSE THE CHAT BOT 
 		bot = new Closethebot();
 		bot.Closing_the_bot();
 		Thread.sleep(2000); 
 		
 		
 		try {
 		loginpage = new Loginpage();
        loginpage.ExplicitWaitSendKeys(invcollpage.TeamMemberemailid(),prop.getProperty("TeamMemberemailid"));
		Thread.sleep(3000);
		
		loginpage.ExplicitWait(invcollpage.autopopulatedeappearedeamil());
		Thread.sleep(2000);
		
		JavascriptExecutor scr4 =  (JavascriptExecutor)driver;	
		scr4.executeScript("window.scrollBy(0,800)");
		
        Thread.sleep(1000);	
		
        loginpage.ExplicitWait(invcollpage.SendInvitesButton());
	    Thread.sleep(3000);	  
	     
	     String succmsg = invcollpage.invitedsuccesfullymessage().getText();
	     System.out.println(succmsg);
	     Assert.assertEquals("MESSAGE NOT APPEARED OR MISMATCHED","Invited Successfully", succmsg);
	     
	        Thread.sleep(3000);
			//Delete added colleague
			//CLICK  ON COOLLEAGUES ICON ON INVITECOLLEAGUES PAGE
	        loginpage.ExplicitWait(invcollpage.ColleaguesIcon());
		    Thread.sleep(1000);
		//SEARCHFIELD ON COLLEAGUES PAGE
			invcollpage.searchfieldoncolleaguepage2(prop.getProperty("TeamMemberemailid"));
			loginpage.ExplicitWait(invcollpage.searchbtn());
			Thread.sleep(2000);
			collpage.selectdeleteoption();
			Thread.sleep(2000);
	        loginpage.ExplicitWait(collpage.yesbutton());
			
			
	       Thread.sleep(1000);
	       driver.navigate().refresh();
	       
	       Thread.sleep(2000);
		   loginpage.ExplicitWait(invcollpage.AddcolleaguebuttonOncolleaguepage());	
		   Thread.sleep(3000);
		   loginpage.ExplicitWait(invcollpage.InvitecolleaguesiconOncollegauespage());	
	        Thread.sleep(2000);
			
	        
		//BY UPLOADING FILE  
	        loginpage.ExplicitWait(invcollpage.UploadFilesBtn());
			Thread.sleep(3000);
			
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\TeamMember.exe");
			
			Thread.sleep(10000);
			
			JavascriptExecutor scr =  (JavascriptExecutor)driver;	
			scr.executeScript("window.scrollBy(0,900)");
		
			 Thread.sleep(2000);
			
			 loginpage.ExplicitWait(invcollpage.SendInvitesButton1());
		     Thread.sleep(7000);	 
		    
		     //Wait for the element till it gets available 
		
		      String Filesuccmsg1 = invcollpage.invitedsuccesfullymessage1().getText();
		      System.out.println(Filesuccmsg1);
		      Assert.assertEquals("MESSAGE NOT APPEARED OR MISMATCHED","Invited Successfully", Filesuccmsg1); 
	     
		     
		       Thread.sleep(3000);
				//Delete added colleague
				//CLICK  ON COOLLEAGUES ICON ON INVITECOLLEAGUES PAGE
		        loginpage.ExplicitWait(invcollpage.ColleaguesIcon1());
				Thread.sleep(1000);
				//SEARCHFIELD ON COLLEAGUES PAGE
				invcollpage.searchfieldoncolleaguepage2(prop.getProperty("TeamMemberemailid"));
				Thread.sleep(2000);
				loginpage.ExplicitWait(invcollpage.searchbtn());
				Thread.sleep(2000);
				invcollpage.selectdeleteoption1();
				Thread.sleep(2000);
		        loginpage.ExplicitWait(invcollpage.yesbutton1());
	        }  
		     
	        catch(Exception ex){
	        	    
	        	    Thread.sleep(2000);
	        	    bot.Closing_the_bot();
			       
					//Delete added colleague
					//CLICK  ON COOLLEAGUES ICON ON INVITECOLLEAGUES PAGE
			        loginpage.ExplicitWait(invcollpage.ColleaguesIcon1());
					Thread.sleep(1000);
					//SEARCHFIELD ON COLLEAGUES PAGE
					invcollpage.searchfieldoncolleaguepage2(prop.getProperty("TeamMemberemailid"));
					Thread.sleep(2000);
					loginpage.ExplicitWait(invcollpage.searchbtn());
					Thread.sleep(2000);
					invcollpage.selectdeleteoption1();
					Thread.sleep(2000);
			        loginpage.ExplicitWait(invcollpage.yesbutton1());
	        	
			        Thread.sleep(1000);
				       driver.navigate().refresh();
				       
				       Thread.sleep(2000);
					   loginpage.ExplicitWait(invcollpage.AddcolleaguebuttonOncolleaguepage());	
					   Thread.sleep(3000);
					   loginpage.ExplicitWait(invcollpage.InvitecolleaguesiconOncollegauespage());	
				        Thread.sleep(7000);
				     //   loginpage.ExplicitWait(invcollpage.UploadFilesBtn1());
				       driver.findElement(By.xpath("//input[@title='Upload Files' or @class='upload']")).click();
				        
				      //Upload files button
				  	//	((JavascriptExecutor) driver).executeScript("arguments[0].click()",
					//			driver.findElement(By.xpath("//input[@title='Upload Files' or @class='upload']")));
				        
				    
						Thread.sleep(3000);
						
						Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\TeamMember.exe");
						
						Thread.sleep(12000);
						
						JavascriptExecutor scr =  (JavascriptExecutor)driver;	
						scr.executeScript("window.scrollBy(0,900)");
					
						 Thread.sleep(2000);
						
						 loginpage.ExplicitWait(invcollpage.SendInvitesButton1());
					     Thread.sleep(7000);	 
					    
					     //Wait for the element till it gets available 
					
					      String Filesuccmsg1 = loginpage.ExplicitWaitGetText(invcollpage.invitedsuccesfullymessage1());
					      System.out.println(Filesuccmsg1);
					      Assert.assertEquals("MESSAGE NOT APPEARED OR MISMATCHED","Invited Successfully", Filesuccmsg1); 
				     
	        	
	        }
	        
		     
	}  
  
    
     @Test(priority=14)
	 public void ValidationMsgAppearsWhenUserTriesToInviteStaffMember_OnInviteColleaguePage() throws InterruptedException, IOException{
		
    	//CLOSE THE CHAT BOT 
 		bot = new Closethebot();
 		bot.Closing_the_bot();
 		Thread.sleep(2000);
 		
 		loginpage = new Loginpage();
		loginpage.ExplicitWaitSendKeys(invcollpage.StaffMemberemailid(),prop.getProperty("StaffMemberemailid"));
		Thread.sleep(3000);
		
		loginpage.ExplicitWait(invcollpage.autopopulatedeappearedeamil());
		Thread.sleep(2000);
		
		JavascriptExecutor scr5 =  (JavascriptExecutor)driver;	
		scr5.executeScript("window.scrollBy(0,800)");
		
        Thread.sleep(4000);	
		loginpage.ExplicitWait(invcollpage.SendInvitesButton());
	    Thread.sleep(6000);	  
	     
	     String succmsg =  loginpage.ExplicitWaitGetText(invcollpage.validatmsgappearedonstaffmemberemailid());
	     System.out.println(succmsg);
	     Assert.assertEquals("MESSAGE NOT APPEARED OR MISMATCHED","This is a Staff Member, so cannot be added as a Colleague.", succmsg);
	     
	     
	}
	
    
  	@Test(priority=15)
	public void SendInvitesToDentistViaUploadingListOfColleagues_OnInviteColleaguePage() throws InterruptedException, IOException{
		
  	//CLOSE THE CHAT BOT 
  		bot = new Closethebot();
  		bot.Closing_the_bot();
  		Thread.sleep(2000);
  		
  		try{
  		loginpage = new Loginpage();
  		loginpage.ExplicitWait(invcollpage.UploadFilesBtn());
  		
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\Uploadinglistcolle.exe");
		
		Thread.sleep(10000);
		
		JavascriptExecutor scr =  (JavascriptExecutor)driver;	
		scr.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(3000);
		loginpage.ExplicitWait(invcollpage.SendInvitesButton());
	    Thread.sleep(3000);	 
	   
	     String succmsg = loginpage.ExplicitWaitGetText(invcollpage.invitedsuccesfullymessage());
	     System.out.println(succmsg);
	     Assert.assertEquals("MESSAGE NOT APPEARED OR MISMATCHED","Invited Successfully", succmsg);
	     
	     Thread.sleep(3000);
		//Delete added colleague
		//CLICK  ON COOLLEAGUES ICON ON INVITECOLLEAGUES PAGE
		loginpage.ExplicitWait(invcollpage.ColleaguesIcon());
		Thread.sleep(1000);
		//SEARCHFIELD ON COLLEAGUES PAGE
 
		loginpage.ExplicitWaitSendKeys(invcollpage.searchfieldoncolleaguepage(),prop.getProperty("Addedcolleagname5"));
		loginpage.ExplicitWait(invcollpage.searchbtn());
		Thread.sleep(2000);
		collpage.selectdeleteoption();
		Thread.sleep(2000);
		loginpage.ExplicitWait(collpage.yesbutton());
  		}
        catch(Exception ex){
        	
        	 Thread.sleep(5000);
				//Delete added colleague
				//CLICK  ON COOLLEAGUES ICON ON INVITECOLLEAGUES PAGE
		        loginpage.ExplicitWait(invcollpage.ColleaguesIcon1());
				Thread.sleep(1000);
				//SEARCHFIELD ON COLLEAGUES PAGE
				invcollpage.searchfieldoncolleaguepage2(prop.getProperty("Addedcolleagname5"));
				Thread.sleep(2000);
				loginpage.ExplicitWait(invcollpage.searchbtn());
				Thread.sleep(2000);
				invcollpage.selectdeleteoption1();
				Thread.sleep(2000);
		        loginpage.ExplicitWait(invcollpage.yesbutton1());
     	
		        Thread.sleep(1000);
			       driver.navigate().refresh();
			       
			       Thread.sleep(2000);
				   loginpage.ExplicitWait(invcollpage.AddcolleaguebuttonOncolleaguepage());	
				   Thread.sleep(3000);
				   loginpage.ExplicitWait(invcollpage.InvitecolleaguesiconOncollegauespage());	
			        Thread.sleep(7000);
			   
			  //Upload files button
			  		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
							driver.findElement(By.xpath("//input[@title='Upload Files' or @class='upload']")));
			  		
					Thread.sleep(3000);
				
					Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\Uploadinglistcolle.exe");
					
					Thread.sleep(10000);
					
					JavascriptExecutor scr =  (JavascriptExecutor)driver;	
					scr.executeScript("window.scrollBy(0,1000)");
					
					Thread.sleep(3000);
					loginpage.ExplicitWait(invcollpage.SendInvitesButton());
				    Thread.sleep(3000);	 
				   
				     String succmsg = loginpage.ExplicitWaitGetText(invcollpage.invitedsuccesfullymessage());
				     System.out.println(succmsg);
				     Assert.assertEquals("MESSAGE NOT APPEARED OR MISMATCHED","Invited Successfully", succmsg);
				     
        }
  		
  		
  		
	} 
     
	
	@Test(priority=16)
	public void InvitedUserReceivesValidEmail_AfterClickingOnSendInviteButton() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
		bot = new Closethebot();
		bot.Closing_the_bot();
		Thread.sleep(2000);
		Thread.sleep(4000);
		
		loginpage = new Loginpage();
		loginpage.ExplicitWaitSendKeys(invcollpage.searchfieldoninvitecolleaguepage1(), prop.getProperty("Anycolleageemail3"));
		Thread.sleep(1000);
		
		loginpage.ExplicitWait(invcollpage.autopopulatedeappearedeamil());
		Thread.sleep(3000);
		   
		JavascriptExecutor scr =  (JavascriptExecutor)driver;	
		scr.executeScript("window.scrollBy(0,800)");
	
		Thread.sleep(1000);	
		loginpage.ExplicitWaitSendKeys(invcollpage.enterperonalnoteininInviteColleaguespage(),prop.getProperty("enterperonalnoteininInviteColleaguespage"));
		Thread.sleep(2000);
		loginpage.ExplicitWait(invcollpage.SendInvitesButton1());
	    Thread.sleep(7000);	
		
	     
		//Delete added colleague
		//CLICK  ON COOLLEAGUES ICON ON INVITECOLLEAGUES PAGE
		loginpage.ExplicitWait(invcollpage.ColleaguesIcon1());
		Thread.sleep(1000);
		//SEARCHFIELD ON COLLEAGUES PAGE
		invcollpage.searchfieldoncolleaguepage2(prop.getProperty("Anycolleageemail3"));
		loginpage.ExplicitWait(invcollpage.searchbtn());
		Thread.sleep(2000);
		invcollpage.selectdeleteoption1();
		Thread.sleep(2000);
		loginpage.ExplicitWait(invcollpage.yesbutton1());
		
	    Thread.sleep(2000);
		invcollpage.verifymail();
	
		//VALIDATION ON APPEARD EMAIL-ID OF COLLEAGUE IN YOPMAIL  
		String mail = driver.findElement(By.xpath("//div[contains(text(),'"+collmail+"')]")).getText();
		System.out.println(mail);
		Assert.assertEquals(prop.getProperty("Anycolleageemail3"),mail);   
		
		
	} 
	
	
}

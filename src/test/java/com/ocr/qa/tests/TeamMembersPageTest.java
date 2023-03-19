package com.ocr.qa.tests;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.Referralspage;
import com.ocr.qa.pages.SMSConfigurationPage;
import com.ocr.qa.pages.SecuritySettingsPage;
import com.ocr.qa.pages.SelectWhoAreYou;
import com.ocr.qa.pages.SendReferralpage;
import com.ocr.qa.pages.TeamMembersPage;

import junit.framework.Assert;

public class TeamMembersPageTest extends TestBase {
     
	
	TeamMembersPage teammemberspage;
	SecuritySettingsPage securitysettingspage;
	
	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Referralspage refpage;
	SendReferralpage sendreff;
	Closethebot bot; 
	
	//CREATE A CONSTRUCTOR 
	public TeamMembersPageTest(){
		
		super();
		
		
	}
	
	//ALL TEST CASES SEPREATED AND INDEPENDENT EACH OTHER 
    //BEFORE METHOD
	@BeforeMethod
	public void TeamMembersPage_SetupMethod() throws InterruptedException{
		
		        initialization(); 
		         
		        teammemberspage = new TeamMembersPage();
		        securitysettingspage = new SecuritySettingsPage();
		        
		        refpage = new Referralspage();
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
				Thread.sleep(22000);
				//CLOSE THE CHAT BOT 
			     bot.Closing_the_bot();
		 		securitysettingspage = dashb.clickonsettingbtn();
				Thread.sleep(5000);
				
				teammemberspage = dashb.clickonsettingandTeamMembersbtn();
				Thread.sleep(7000);
				
	    }
	
	//AFTER METHOD 
	
		@AfterMethod
		public void TestCase_Quit(){
				
			driver.quit();
		}
	 
	 
    //--------------TEST CASE---------------------------	 
	
	@Test(priority=1)
	public void TeamMembersPagOpensUpOnClicking_TeamMembersSubTab() throws InterruptedException{
		
		Thread.sleep(2000);
		String Title = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals("PageTitleMismatch","TeamMember",Title);
		
	}
	
	@Test(priority=2)
	public void AddTeamStaffMemberPopupOpensUpOnClicking_AddMemberOptionUnderTeamMembersPage() throws InterruptedException{
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		
	    String popuptitle = loginpage.ExplicitWaitGetText(teammemberspage.AddTeamStaffMemberTitle()); 
	    System.out.println(popuptitle);
	    Assert.assertEquals("POPUP TITLE MISMATCHED","Add team/staff member", popuptitle);
	    
		
	}
	

	@Test(priority=3)
	public void ValidationMessageAppearsOnLeavingMandatoryFieldsBlankUnderAddTeamStaffMemberPopup() throws InterruptedException{
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
		
		
		//VALIDATION MESSAGE APPEARS ON LEAVING MANDATORY FIELDS 
    	String valdmsg = driver.findElement(By.className("message")).getText();
    	System.out.println(valdmsg);
    	Assert.assertEquals("Please enter First Name!",valdmsg);
	    
	    
	}
	 
	 
	@Test(priority=4)
	public void ValidationMessageAppearsOnEnteringNumbersOrSpecial_CharactersInFirstNameOrLastNameTextfield() throws InterruptedException{
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"1234&@");
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
		
	
		//VALIDATION MESSAGE APPEARS ON EnteringNumbersOrSpecial_Characters
    	String valdmsg = driver.findElement(By.className("message")).getText();
    	System.out.println(valdmsg);
    	Assert.assertEquals("Please enter only character in First Name",valdmsg);  
    	
    	Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
    	
		
	//LAST NAME TEXTFIELD	
	
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"Kevin");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"1234&@");
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
		
		//VALIDATION MESSAGE APPEARS ON EnteringNumbersOrSpecial_Characters
    	String valdmsg1 = driver.findElement(By.className("message")).getText();
    	System.out.println(valdmsg1);
    	Assert.assertEquals("Please enter only character in Last Name",valdmsg1);
		
    		
	}
	
	
	@Test(priority=5)
	public void ValidationMessageAppearsOnEnteringMoreThan_20CharactersInFirstNameOrLastNameTextfield() throws InterruptedException{
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"ABCDEFGHIJKLMNHUJDISHDDJHDSDSDJYUH");
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
		
	
		//VALIDATION MESSAGE APPEARS ON EnteringNumbersOrSpecial_Characters
    	String valdmsg = driver.findElement(By.className("message")).getText();
    	System.out.println(valdmsg);
    	Assert.assertEquals("First Name allow maximum 20 characters only.",valdmsg);  
    	
    	Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
    	
		
	   //LAST NAME TEXTFIELD	
	
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"Kevin");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"ABCDEFGHIJKLMNHUJDISHDDJHDSDSDJYU");
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
		
		//VALIDATION MESSAGE APPEARS ON EnteringNumbersOrSpecial_Characters
    	String valdmsg1 = driver.findElement(By.className("message")).getText();
    	System.out.println(valdmsg1);
    	Assert.assertEquals("Last Name allow maximum 20 characters only.",valdmsg1);
	
		
	
	}
	  
	
	@Test(priority=6)
	public void ValidationMessageAppearsOnEnteringInvalidEmail_InEmailTextfieldUnderAddTeamStaffMemberPopup() throws InterruptedException{
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"Kevin");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"Crues");
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),"123@mail");
		
		
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
	
		//VALIDATION MESSAGE APPEARS ON ENTERING INVALID EMAIL
    	String valdmsg1 = driver.findElement(By.className("message")).getText();
    	System.out.println(valdmsg1);
    	Assert.assertEquals("Please enter a valid Email Address.",valdmsg1);
		
		
		
		
	}
	
	
	@Test(priority=7)
	public void ValdMsgAppearsOnEnteringPreExistingEmailAddress_InEmailTextfieldUnderAddTeamStaffMemberPopup() throws InterruptedException{
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"Kevin");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"Crues");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),"123@mail");
		
		
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
	
		//VALIDATION MESSAGE APPEARS ON ENTERING INVALID EMAIL
    	String valdmsg1 = driver.findElement(By.className("message")).getText();
    	System.out.println(valdmsg1);
    	Assert.assertEquals("Please enter a valid Email Address.",valdmsg1);      
    	
    		
	}
	
	
	@Test(priority=8)
	public void SaveTeamMemberDetailsOnClicking_SaveButtonUnderAddTeamStaffMemberPopup() throws InterruptedException{
		
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"Kevin");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"Crues");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
	//	loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),"Kevin@yopmail.com");
		
		Date date = new Date (); 
		long time =   date.getTime();
		System.out.println(time);
	  
		loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),+time+"@yopmail.com");
		Thread.sleep(3000);
		System.out.println(+time+'@'+"yopmail.com");
		
		Thread.sleep(3000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
	   
		
		//SUCCESS MESSAGE APPEARS ON ADDING TEAM MEMBER
	//	Thread.sleep(3000);
    //	WebElement msg = driver.findElement(By.className("message"));
    //	String valdmsg1 = driver.findElement(By.className("message")).getText();
    //	String valdmsg1 = loginpage.ExplicitWaitGetText(msg);
    //	System.out.println(valdmsg1);
    //	Assert.assertEquals("Team Member added successfully.",valdmsg1);
		
    	
	}
	
	
	@Test(priority=9)
	public void SaveMemberAsStaffMemberAfterChecking_StaffMemberCheckboxUnderAddTeamStaffMemberPopup() throws InterruptedException{
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"Kevin");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"Crues");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		 Date date = new Date (); 
		  long time =   date.getTime();
		  System.out.println(time);
		
		
		loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),+time+"@yopmail.com");
		Thread.sleep(3000);
		System.out.println(+time+'@'+"yopmail.com");
   	//	loginpage.ExplicitWait(teammemberspage.StaffMemberCheckboxUnderAddTeamStaffMemberPopup());
		driver.findElement(By.xpath("//*[@id=\"chkProviderStaff\"]")).click();
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
	
		//VALIDATION MESSAGE APPEARS ON ADDING STAFF MEMBER
		Thread.sleep(5000);
    	WebElement msg = driver.findElement(By.className("message"));
    	String valdmsg1 = loginpage.ExplicitWaitGetText(msg);
    	System.out.println(valdmsg1);
    	Assert.assertEquals("Staff Member added successfully.",valdmsg1);
		
    	Thread.sleep(4000);
		loginpage.ExplicitWait(teammemberspage.DeleteIconUnderTeamMembersPage());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"btnyes\"]")).click(); 
    	
    
	}
	
    
	@Test(priority=10)
	public void EditTeamStaffMemberPopupOpensUp_OnClickingEditIconUnderTeamMembersPage() throws InterruptedException{
		
		Thread.sleep(5000);
		loginpage.ExplicitWait(teammemberspage.EditIconUnderTeamMembersPage());
		Thread.sleep(2000);
		
		String popuptitle = loginpage.ExplicitWaitGetText(teammemberspage.editteamstaffmemberpopuptitle()); 
		System.out.println(popuptitle);
		Assert.assertEquals("POPUP TITLE NAME MISMATCHED","Edit team/staff member",popuptitle);
		
	} 
	
	
	@Test(priority=11)
	public void VerifyThatAddedMemberEmailIs_NonEditableUnderEditTeamStaffMemberPopup() throws InterruptedException{
	 
		Thread.sleep(3000);
		loginpage.ExplicitWait(teammemberspage.EditIconUnderTeamMembersPage());
		Thread.sleep(2000);
		
	  //EMAIL IS NONEDITABLE UNDER EDIT TEAMSTAFFMEMBER POPUP 	
	     Boolean Result = teammemberspage.EmailIsNonEditableUnderEditTeamStaffMemberPopup();
	     System.out.println(Result);
		 Assert.assertFalse("EmailIsNonEditableUnderEditTeamStaffMemberPopup",Result);
		 
	}  
	
	@Test(priority=12)
	public void ValidationMessageAppearsOnLeavingMandatoryFieldsBlankUnderEditTeamStaffMemberPopup() throws InterruptedException{
		
		Thread.sleep(3000);
		loginpage.ExplicitWait(teammemberspage.EditIconUnderTeamMembersPage());
		Thread.sleep(2000);
		
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderEditTeamStaffMemberPopup()); 
		Thread.sleep(2000);
		
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderEditTeamStaffMemberPopup());
		

		//VALIDATION MESSAGE APPEARS ON LEAVING MANDATORY FIELDS 
    	String valdmsg = driver.findElement(By.className("message")).getText();
    	System.out.println(valdmsg);
    	Assert.assertEquals("Please enter First Name!",valdmsg);
	
	}
     
	@Test(priority=13)
	public void VerifyThatUserIsAbleToUpdateAddedMemberDetails_OnClickingSaveButtonUnderEditTeamStaffMemberPopup() throws InterruptedException{
		
		Thread.sleep(3000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"Aacd");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"Aaues");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		 Date date = new Date (); 
		  long time =   date.getTime();
		  System.out.println(time);
		
		
		loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),+time+"@yopmail.com");
		Thread.sleep(3000);
		System.out.println(+time+'@'+"yopmail.com");
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
	    
		//CLOSE THE BOT 
		bot= new Closethebot();
		bot.Closing_the_bot(); 
		Thread.sleep(5000);
		loginpage.ExplicitWait(teammemberspage.EditIconUnderTeamMembersPage());
		Thread.sleep(3000);
	      
		WebElement sv = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		Actions actions = new Actions(driver);
	    actions.moveToElement(sv);
	    actions.perform();
		
	     sv.click();

		//VALIDATION MESSAGE APPEARS ON LEAVING MANDATORY FIELDS 
	    Thread.sleep(4000); 
    	WebElement msg = driver.findElement(By.className("message"));
    	String valdmsg = loginpage.ExplicitWaitGetText(msg);
    	System.out.println(valdmsg);
    	Assert.assertEquals("Team Member updated successfully.",valdmsg);
		
    	Thread.sleep(5000);
		loginpage.ExplicitWait(teammemberspage.DeleteIconUnderTeamMembersPage());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"btnyes\"]")).click();    
		
	}
	
	
	@Test(priority=14)
	public void VerifyThatConfirmationMessageAppears_OnClickingDeleteIconOnTeamMembersPage() throws InterruptedException{
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.DeleteIconUnderTeamMembersPage());
		Thread.sleep(2000);
		
		
		//CONFIRMATION MESSAGE APPEARS ON LEAVING MANDATORY FIELDS 
    	String valdmsg = driver.findElement(By.xpath("//p[contains(text(),'Are you sure you want to remove?')]")).getText();
    	System.out.println(valdmsg);
    	Assert.assertEquals("Are you sure you want to remove?",valdmsg);
	}


	@Test(priority=15)
	public void VerifyThatUserIsAbleToDeleteMember_OnClickingYesButtonUnderConfirmationMessage() throws InterruptedException{
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.DeleteIconUnderTeamMembersPage());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"btnyes\"]")).click();
		
		//SUCCESS MESSAGE APPEARS ON LEAVING MANDATORY FIELDS 	
		Thread.sleep(4000);
    	WebElement msg = driver.findElement(By.className("message"));
    	String valdmsg = loginpage.ExplicitWaitGetText(msg);
    	System.out.println(valdmsg);
    	Assert.assertEquals("Member removed successfully.",valdmsg);
				
	}
	
	
	@Test(priority=16)
	public void VerifyThatDentistIsAbleToSortTheRecords_OnClickingSortingIconsUnderTeamMembersPage() throws InterruptedException{
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"ZZZZ");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"ZZZZ");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		Date date = new Date (); 
		long time =   date.getTime();
		System.out.println(time);
	//	loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),"ZZZZ@yopmail.com"); 
		loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),+time+"@yopmail.com");
		Thread.sleep(3000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
	    
		Thread.sleep(30000);
        
		//LAST NAME TITLE CLICK ON IT FOR SORTING   
		loginpage.ExplicitWait(teammemberspage.LastNameTittleOnTeamMembersPage());
		Thread.sleep(3000);
		
		//VALIDATE LAST NAME TEXT FIELD NAME ACCORDING TO SHORTING ORDER 
		String lastname = driver.findElement(By.xpath("(//td[@data-th='Last Name'])[1]")).getText();
		System.out.println(lastname);
		Assert.assertEquals("LAST NAME NOT APPEARED AS SHORTING ORDER","ZZZZ",lastname); 
		
		//VALIDATE FIRST NAME TEXT FIELD NAME ACCORDING TO SHORTING ORDER 
		String firstname = driver.findElement(By.xpath("(//td[@data-th='First Name'])[1]")).getText();
		System.out.println(firstname);
		Assert.assertEquals("FIRST NAME NOT APPEARED AS SHORTING ORDER","ZZZZ",firstname); 
		
		Thread.sleep(3000);
		loginpage.ExplicitWait(teammemberspage.DeleteIconUnderTeamMembersPage());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"btnyes\"]")).click();
		
		}
	
	
	@Test(priority=17)
	public void VerifyThaTeamMemberDetailsAppearOnEnteringExistingDetailsInSearchField() throws InterruptedException{
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"Tmember");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"Z");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		Date date = new Date (); 
		long time =   date.getTime();
		System.out.println(time);
	//	loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),"Tmembe@yopmail.com");
		loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),+time+"@yopmail.com");
		Thread.sleep(2000);   
		
		
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
		
		//loginpage.ExplicitWaitSendKeys(teammemberspage.SearchFieldOnTeamMemberspage(),"Tmember");
	      
		Thread.sleep(34000);
		WebElement tmember = driver.findElement(By.cssSelector("#txtSearchTeam"));
		loginpage.ExplicitWaitSendKeys(tmember,"Tmember");
		
		
		Thread.sleep(2000);
		WebElement SerchIcon = driver.findElement(By.xpath("//i[@class='icon-search']"));
		//driver.findElement(By.xpath("//i[@class='icon-search']")).click(); 
		loginpage.ExplicitWait(SerchIcon);
		
		Thread.sleep(4000);
		
		String txt = driver.findElement(By.xpath("//td[@data-th='First Name']")).getText();
		System.out.println(txt);
		Assert.assertEquals("TEAM MEMBER DETAILS NOT APPEAR","Tmember",txt);
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.DeleteIconUnderTeamMembersPage());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"btnyes\"]")).click();
		
		
	}
	
	
	@Test(priority=18)
	public void VerifyThatCorrectInformationMessageAppearsOnEnteringNonExistingDetailsInSearchField() throws InterruptedException{
		
		driver.findElement(By.cssSelector("#txtSearchTeam")).sendKeys("kx");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='icon-search']")).click();
		
		Thread.sleep(3000);
		//Validation message  
		String vald = driver.findElement(By.xpath("//*[@id=\"nomore\"]")).getText();
		System.out.println(vald);
		Assert.assertEquals("No record found!",vald);
		
	}
	
	@Test(priority=19)
	public void VerifyThatLoggedInDentistAllLocationsAppearInLocationDropdown() throws InterruptedException{
		
		Thread.sleep(3000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"Kevin");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"Crues");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		Date date = new Date (); 
		long time =   date.getTime();
		System.out.println(time);
		
		
		loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),+time+"@yopmail.com");
		Thread.sleep(3000);
		System.out.println(+time+'@'+"yopmail.com");
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
	    
	    
		Thread.sleep(30000);
		
		String txt = driver.findElement(By.xpath("(//td[@data-th='Location'])[1]")).getText();
		System.out.println(txt);
		Assert.assertEquals("Primary",txt);
		Thread.sleep(5000);
		loginpage.ExplicitWait(teammemberspage.DeleteIconUnderTeamMembersPage());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"btnyes\"]")).click(); 
		
	}

	
	@Test(priority=20)
	public void VerifyThatRecordsAppearAccordingTo_SelectedLocationUnderTeamMembersPage() throws InterruptedException{
		
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"Rec");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"nm");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
	//	loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),"record@yopmail.com");  
		Date date = new Date (); 
		long time =   date.getTime();
		System.out.println(time);
		
		loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),+time+"@yopmail.com");
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
		
		
		Thread.sleep(30000);
		Select sc = new Select(driver.findElement(By.xpath("//*[@id=\"LocationBy\"]")));
		sc.selectByVisibleText("Primary"); 
		
		Thread.sleep(5000);
		String txt = driver.findElement(By.xpath("(//td[@data-th='Location'])[1]")).getText();
		System.out.println(txt);
		Assert.assertEquals("Primary",txt);
		
		Thread.sleep(2000);
		//CLOSE THE BOT 
				bot= new Closethebot();
				bot.Closing_the_bot(); 
				Thread.sleep(1000);
		loginpage.ExplicitWait(teammemberspage.DeleteIconUnderTeamMembersPage());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"btnyes\"]")).click(); 
		
	}
	
	
	@Test(priority=21)
	public void VerifyThatRecordsAppearAccordingToSelectedOptionInMemberDropdownOnTeamMembersPage() throws InterruptedException{
		
		Thread.sleep(3000);
		loginpage.ExplicitWait(teammemberspage.VerticalElipseButton());
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.AddMemberButton());
	    Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.FirstNameTextFieldUnderAddTeamStaffMemberPopup(),"Kevin");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(teammemberspage.LastNameTextFieldUnderAddTeamStaffMemberPopup(),"Crues");
		Thread.sleep(2000);
		loginpage.ExplicitWaitClear(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup());
		Thread.sleep(2000);
		Date date = new Date (); 
		long time =   date.getTime();
		System.out.println(time);
		
		
		loginpage.ExplicitWaitSendKeys(teammemberspage.EmailTextFieldUnderAddTeamStaffMemberPopup(),+time+"@yopmail.com");
		Thread.sleep(3000);
		System.out.println(+time+'@'+"yopmail.com");
		Thread.sleep(2000);
		loginpage.ExplicitWait(teammemberspage.SaveButtonUnderAddTeamStaffMemberPopup());
	    
		
		Thread.sleep(30000);
		Select sc = new Select(driver.findElement(By.xpath("//*[@id=\"ddlProviderfilter\"]")));
		sc.selectByVisibleText("Only Team Member"); 
		
		Thread.sleep(5000);
		String txt = driver.findElement(By.xpath("(//td[@data-th='Last Name'])[1]")).getText();
		System.out.println(txt);
		Assert.assertEquals("Crues",txt);
		Thread.sleep(3000);
		loginpage.ExplicitWait(teammemberspage.DeleteIconUnderTeamMembersPage());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"btnyes\"]")).click(); 
		
	}
	
   
	
	
	
    }

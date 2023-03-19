package com.ocr.qa.tests;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.ocr.qa.base.TestBase;
import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Dashboardpage;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.Profilepage;
import com.ocr.qa.pages.Referralspage;
import com.ocr.qa.pages.SelectWhoAreYou;
import com.ocr.qa.pages.SendReferralpage;

import junit.framework.Assert;

public class ProfilepageTest extends TestBase {
    
	Profilepage profilepage = new Profilepage();
	
	Loginpage loginpage;
	Dashboardpage dashb;
	SelectWhoAreYou Swatpage;
	Referralspage refpage;
	SendReferralpage sendreff;
	Closethebot bot;
	
	//CREATE A CONSTRUCTOR
	public ProfilepageTest(){
		
		super();
		
	}
	
	
	//ALL TEST CASES SEPREATED AND INDEPENDENT EACH OTHER 
	//BEFORE METHOD
	@BeforeMethod
	public void ProfilePage_SetupMethod() throws InterruptedException{
		
		
		initialization();
		
		sendreff = new SendReferralpage();
		refpage = new Referralspage();
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
		Thread.sleep(21000);
		//CLOSE THE CHAT BOT 
	    bot.Closing_the_bot();
        Thread.sleep(1000);
	    profilepage = dashb.clickoneditprofilebtn();
	    Thread.sleep(7000);
	
		
	}
    
	//AFTER METHOD 
	
	@AfterMethod
	public void TestCase_Quit(){
		
		driver.quit();
		
	}

	 
	@Test(priority=1)
	public void ProfilePageOpensUpOnClicking_EditProfileOptionInUserDropDownOnTheHeader() throws InterruptedException{
		
	//VALIDATION ON PAGE TITLE  
	  Thread.sleep(2000);
	  
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		Assert.assertEquals("PAGE TITLE MISMATCHED","Profile",PageTitle);
			
	}
	
	@Test(priority=2)
	public void UplodProfilePicturePopupOpensUp_OnClickingAddImageIconOnTheProfilePage() throws Exception{
		
	    Thread.sleep(2000);
		 
       WebElement imageicon =	driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/div[1]/div[2]/a/img"));
	   WebElement  icon = driver.findElement(By.xpath("//img[@class='hover']"));
		
	    Actions action = new Actions (driver);
		
	    action.moveToElement(imageicon).perform();
	    Thread.sleep(3000);
	    action.click(icon).perform();
	    
	    Thread.sleep(3000);
	    
	    String popuptitle =  loginpage.ExplicitWaitGetText(profilepage.Uploadprofilepicturetitle());
	    System.out.println(popuptitle);
	    Assert.assertEquals("POPUP TITLE MISMATCHED","Upload Profile Picture",popuptitle);
	    
	    
	}
	
	
	@Test(priority=3)
	public void ValidationMsgAppearsOnClickingSaveButton_WithoutSelectingFileUnderUploadProfilePicturePopup() throws InterruptedException{
		
		    Thread.sleep(2000);
		 
	        WebElement imageicon =	driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/div[1]/div[2]/a/img"));
		    WebElement  icon = driver.findElement(By.xpath("//img[@class='hover']"));
		
		    Actions action = new Actions (driver);
			
		    action.moveToElement(imageicon).perform();
		    Thread.sleep(3000);
		    action.click(icon).perform();
		    
		    Thread.sleep(3000);
		    //SAVE BUTTON
		    loginpage.ExplicitWait(profilepage.savebutton());
		   
		    //VALIDATION WITH POPUP TITLE
		    String valdmsg = loginpage.ExplicitWaitGetText(profilepage.validmsg());
		    Assert.assertEquals("VALIDATION MESSAGE NOT APPEARED","Please choose an appropriate image.",valdmsg);
		
	}
	
	
	@Test(priority=4)
	public void ValidationMsgAppears_OnUploadingInvalidFileUnderUploadProfilePicturePopup() throws InterruptedException, IOException{
		
		Thread.sleep(3000);
		 
        WebElement imageicon =	driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/div[1]/div[2]/a/img"));
	    WebElement  icon = driver.findElement(By.xpath("//img[@class='hover']"));
		
       
	    Actions action = new Actions (driver);
		
	    action.moveToElement(imageicon).perform();
	    Thread.sleep(3000);
	    action.click(icon).perform();
		
		Thread.sleep(2000);
		//CHOOSE FILE BUTTON
		loginpage.ExplicitWait(profilepage.choosefilebtn());
	
		Thread.sleep(5000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\Document.exe");
		
		Thread.sleep(14000);
		//SAVE BUTTTON 
		loginpage.ExplicitWait(profilepage.savebutton());
		
		Thread.sleep(1000);
		//VALIDATION MESSAGE
	//	String ValidationMsg = loginpage.ExplicitWaitGetText(profilepage.valdoninvalidfile());
	//	Assert.assertEquals("VALIDATION MESSSAGE NOT APPEARED","Please upload valid file.",ValidationMsg);
		
	}
	
	
	@Test(priority=5)
	public void UploadValidFileAfterClicking_OnSaveButtonUnderUploadProfilePicturePopup() throws InterruptedException, IOException{
		
		Thread.sleep(3000);
		 
        WebElement imageicon =	driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/div[1]/div[2]/a/img"));
	    WebElement  icon = driver.findElement(By.xpath("//img[@class='hover']"));
		
       
	    Actions action = new Actions (driver);
		
	    action.moveToElement(imageicon).perform();
	    Thread.sleep(3000);
	    action.click(icon).perform();
		
		Thread.sleep(3000);
		
		//CHOOSE FILE BUTTON 
		loginpage.ExplicitWait(profilepage.choosefilebtn());
		Thread.sleep(3000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\roseimg.exe");
		Thread.sleep(14000);
		
		WebElement From = driver.findElement(By.xpath("//*[@id=\"cropDisplay\"]/div/div[2]"));
		action.dragAndDropBy(From,135, 40).build().perform();
	  	Thread.sleep(3000);
		//SAVE BUTTON
		loginpage.ExplicitWait(profilepage.savebutton());
		
		Thread.sleep(1000);
		//SUCCESS MESSAGE
		String SuccessMsg = loginpage.ExplicitWaitGetText(profilepage.successmsgvalidfile());
		Assert.assertEquals("SUCCESS MESSSAGE NOT APPEARED","Profile updated successfully",SuccessMsg);
		
		
	}
	
	
	@Test(priority=6)
	public void ConfirmationMsgAppearsOnClicking_RemoveButtonUnderUploadProfilePicturePopup() throws InterruptedException, IOException{
		
		Thread.sleep(3000);
		 
       WebElement imageicon =	driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/div[1]/div[2]/a/img"));
       
         WebElement  icon = driver.findElement(By.xpath("//img[@class='hover']"));
		
		
	    Actions action = new Actions (driver);
		
	    action.moveToElement(imageicon).perform();
	    Thread.sleep(3000);
	    action.click(icon).perform();
		
		Thread.sleep(3000);
		
		//CHOOSE FILE BUTTON 
		loginpage.ExplicitWait(profilepage.choosefilebtn());
		Thread.sleep(3000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\roseimg.exe");
		Thread.sleep(14000);
		
		//REMOVE BUTTON 
		loginpage.ExplicitWait(profilepage.removebtn());
		Thread.sleep(1000);
		
		//CONFIRMATION MESSAGE
		String Confirmationmsg = loginpage.ExplicitWaitGetText(profilepage.RconfiramtionMessage());
		System.out.println(Confirmationmsg);
		Assert.assertEquals("CONFIRMATION MESSSAGE NOT APPEARS","Are you sure you want to remove?", Confirmationmsg);
		
	}
	
	
	@Test(priority=7)
	public void DeleteUploadedProfileImageOnClicking_YesButtonUnderConfirmationMessage() throws InterruptedException, IOException{
		
		Thread.sleep(3000);
		 
        WebElement imageicon =	driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/div[1]/div[2]/a/img"));
	    WebElement  icon = driver.findElement(By.xpath("//img[@class='hover']"));
		
	    Actions action = new Actions (driver);
		
	    action.moveToElement(imageicon).perform();
	    Thread.sleep(3000);
	    action.click(icon).perform();
	    
	    Thread.sleep(4000);
	    //CHOOSE FILE BUTTON
		loginpage.ExplicitWait(profilepage.choosefilebtn());
		
		Thread.sleep(5000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Testdata\\roseimg.exe");
		
		Thread.sleep(14000);
		//SAVE BUTTON
		loginpage.ExplicitWait(profilepage.savebutton());
	    
		Thread.sleep(18000);  
		
		WebElement imageicon1 =	driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/div[1]/div[2]/a/img"));
	    WebElement icon1 = driver.findElement(By.xpath("//*[@id=\"wizard\"]/div[2]/div[1]/div[2]/a/div/img"));
		
		action.moveToElement(imageicon1).perform();
	    Thread.sleep(3000);
	    action.click(icon1).perform();
		
		Thread.sleep(2000);
		//REMOVE BUTTON 
	    loginpage.ExplicitWait(profilepage.removebtn());
		Thread.sleep(3000);

		loginpage.ExplicitWait(profilepage.Yesbutton());
		
		Thread.sleep(1000);
		String succmsg = loginpage.ExplicitWaitGetText(profilepage.Successmessageafterremovefile());
		Assert.assertEquals("SUCCESS MESSAGE NOT APPEARS","Profile picture removed successfully", succmsg);
		
		
	}
	
	
	@Test(priority=8)
	public void EditPersonalInformationPopup_OpensUpOnClickingEditButtonOnTheProfilePage() throws InterruptedException{
		
		Thread.sleep(4000);
		loginpage.ExplicitWait(profilepage.Editbutton());
	
		Thread.sleep(3000);
		String title = loginpage.ExplicitWaitGetText(profilepage.EditpersonalinformationPopupTitle());
		System.out.println(title);
		Assert.assertEquals("POPUP TITLE NOT APPEARS AS Edit Personal Information","Edit Personal Information",title);
		
	}
	
    
	@Test(priority=9)
	public void ValidationMsgAppearsOnLeavingMandatoryFields_BlankUnderEditPersonalInformationPopup() throws InterruptedException{
		
		Thread.sleep(4000);
		//EDIT BUTTON 
		loginpage.ExplicitWait(profilepage.Editbutton());
		Thread.sleep(3000);
		//CLEAR FIRST NAME 
		loginpage.ExplicitWaitClear(profilepage.FirstNameOnEditpopup());
		Thread.sleep(3000);
		//SAVE BUTTON
		loginpage.ExplicitWait(profilepage.SavebtnUnderEditPersonalInfPopup());
		
		Thread.sleep(1000);
		//VALIDATION MESSAGE 
		String valdmsg = loginpage.ExplicitWaitGetText(profilepage.ValidMessageOnFirstName());
		System.out.println(valdmsg);
		Assert.assertEquals("VALIDATION MESSAGE NOT APEEARS","Please enter First Name.",valdmsg);		
		
		
	}
	
	
	@Test(priority=10)
	public void ValidationMsgAppearsOnEntering_IncorrectDetailsUnderEditPersonalInformationPopup() throws InterruptedException{
		
		Thread.sleep(2000);
		//EDIT BUTTON 
		loginpage.ExplicitWait(profilepage.Editbutton());
		
		Thread.sleep(2000);
		//CLEAR FIRST NAME 
		loginpage.ExplicitWaitClear(profilepage.FirstNameOnEditpopup());
		Thread.sleep(2000);
		
		//ENTER FIRST NAME 
		loginpage.ExplicitWaitSendKeys(profilepage.EnterFirstNameWithCharacterAndNumber(),"jon12345");
		Thread.sleep(3000);
		loginpage.ExplicitWait(profilepage.SavebtnUnderEditPersonalInfPopup());
		
		Thread.sleep(1000);
	//VALIDATION MESSAGE
	    String valdmsg1 = driver.findElement(By.xpath("//span[contains(text(),'First name allow characters only.')]")).getText();
	    Assert.assertEquals("VALIDATION MESSAGE NOT APEEARS","First name allow characters only.",valdmsg1);
	    
		
		
	}
	
	
	
	@Test(priority=11)
	public void UpdatePersonalInformationDetailsOnClicking_SaveButtonUnderEditPersonalInformationPopup() throws InterruptedException{
		
		Thread.sleep(2000);
		//EDIT BUTTON 
		loginpage.ExplicitWait(profilepage.Editbutton());
		
		Thread.sleep(3000);
		//CLEAR FIRST NAME 
		loginpage.ExplicitWaitClear(profilepage.FirstNameOnEditpopup());
		Thread.sleep(3000); 
		
		//ENTER FIRST NAME 
		loginpage.ExplicitWaitSendKeys(profilepage.EnterFirstName(),"Levin");
		Thread.sleep(3000);
		
		//CLEAR LAST NAME 
		loginpage.ExplicitWaitClear(profilepage.ClearLastName());
		Thread.sleep(3000);
		
		//ENTER LAST NAME 
		loginpage.ExplicitWaitSendKeys(profilepage.EnterLastName(),"Q");
	
		Thread.sleep(3000);
		//SAVE BUTTON
		loginpage.ExplicitWait(profilepage.SavebtnUnderEditPersonalInfPopup());
		
		Thread.sleep(1000);
		//SUCCESS MESSAGE 
		String SuccMsg = loginpage.ExplicitWaitGetText(profilepage.valdmsgafterupdatepersonalinfo());
		Assert.assertEquals("SUCCESS MESSAGE NOT APEEARS","Profile updated successfully!",SuccMsg);
		
	}
	
	
	@Test(priority=12)
	public void AddAdditionalAddressPopupOpensUp_OnClickingAddButtonUnderLocationsSectionOnTheProfilepage() throws InterruptedException{
		
		Thread.sleep(2000);
		//ADD BUTTON
		loginpage.ExplicitWait(profilepage.addbuttonunderlocation());
		Thread.sleep(5000);
		
		//POPUP TITLE
		String title = loginpage.ExplicitWaitGetText(profilepage.addadditionaladdresspopuptitle());
		Assert.assertEquals("POPUP TITLE NOT APPEARS AS Add Additional Address","Add Additional Address",title);
		
	}
	
	@Test(priority=13)
	public void ValidationMsgAppearsOnLeavingMandatoryFields_BlankUnderAddAdditionalAddressPopup() throws InterruptedException{
		
		Thread.sleep(2000);
		//ADD BUTTON
		loginpage.ExplicitWait(profilepage.addbuttonunderlocation());
		Thread.sleep(2000);
		//CLEAR LOCATION FIELD
		loginpage.ExplicitWaitClear(profilepage.Clearlocationfieldunderaddaditionaladdresspopup());
		Thread.sleep(2000);
		//SAVE BUTTON 
		loginpage.ExplicitWait(profilepage.savebuttonunderaddaditionaladdresspopup());
		
		Thread.sleep(1000);
	    //VALIDATION MESSAGE 
		String valdmsg =loginpage.ExplicitWaitGetText(profilepage.validationmessageafterleavingmandatoryfieldblank());
		System.out.println(valdmsg);
		Assert.assertEquals("Please enter Location.", valdmsg);
		
		
	}
	
	@Test(priority=14)
	public void ValidationMsgAppearsOnEnteringIncorrect_DetailsUnderAddAdditionalAddressPopup() throws InterruptedException{
		
		Thread.sleep(2000);
		//ADD BUTON UNDER LOCATION 
		loginpage.ExplicitWait(profilepage.addbuttonunderlocation());
		Thread.sleep(3000);
		//ENTER LOCATION UNDER ADD ADDITIONAL ADDRESS POPUP
		loginpage.ExplicitWaitSendKeys(profilepage.enterlocationunderaddadditionaladdresspopup(),"Denamrk");
		Thread.sleep(3000);
		//ENTER STREET ADDRESS UNDER ADD ADDITIONAL ADDRESS POPUP
		loginpage.ExplicitWaitSendKeys(profilepage.enterstreetAddressunderaddadditionaladdresspopup(),"Street-121");
		Thread.sleep(3000);
		//ENTER CITY ADDRESS UNDER ADD ADDITIONAL ADDRESS POPUP 
		loginpage.ExplicitWaitSendKeys(profilepage.entercityAddressunderaddadditionaladdresspopup(),"Denmark");
		Thread.sleep(3000);
		//SELECT COUNTRY UNDER ADD ADDITIONAL ADDRESS POPUP  
		profilepage.selectcountryunderaddadditionaladdresspopup();
		Thread.sleep(3000);
		//ENTER ZIPE CODE UNDER ADD ADDITIONAL ADDRESS POPUP 
		loginpage.ExplicitWaitSendKeys(profilepage.Zipcodeunderaddadditionaladdresspopup(),"123");
	    Thread.sleep(3000);
		//ENTER EMAIL UNDER ADD ADDITIONAL ADDRESS POPUP 
		loginpage.ExplicitWaitSendKeys(profilepage.Emailunderaddadditionaladdresspopup(),"rock@mail.com");
		
		Thread.sleep(3000);
		//SELECT TIME ZONE UNDER ADD ADDITIONAL ADDRESS POPUP 
		profilepage.SelectTimezoneunderaddadditionaladdresspopup();
		Thread.sleep(3000);
		//SAVE BUTTON UNDER ADD ADDITIONAL ADDRESS POPUP 
		loginpage.ExplicitWait(profilepage.SaveButtonunderaddadditionaladdresspopup()); 
		
		Thread.sleep(1000);
		//VALIDATION MESSAGE 
		 String valdmsg = loginpage.ExplicitWaitGetText(profilepage.validationmessageoninvalidZIPcode()); 
		 Assert.assertEquals("VALIDATION MESSAGE NOT APPEARS","Please enter a valid Zip Code.",valdmsg);
		
	}
	
	
	@Test(priority=15)
	public void MakeTheAddressAsPrimaryAddressByChecking_MakePrimaryAddressCheckboxUnderAddAdditionalAddressPopup() throws InterruptedException{
		
		//ADD BUTON UNDER LOCATION 
		loginpage.ExplicitWait(profilepage.addbuttonunderlocation());
		Thread.sleep(3000);		
		//ENTER LOCATION UNDER ADD ADDITIONAL ADDRESS POPUP
		loginpage.ExplicitWaitSendKeys(profilepage.enterlocationunderaddadditionaladdresspopup(),"Primary");
		Thread.sleep(3000);		
		//ENTER STREET ADDRESS UNDER ADD ADDITIONAL ADDRESS POPUP
		loginpage.ExplicitWaitSendKeys(profilepage.enterstreetAddressunderaddadditionaladdresspopup(),"Street-127");
		Thread.sleep(3000);
		//ENTER CITY ADDRESS UNDER ADD ADDITIONAL ADDRESS POPUP 
		loginpage.ExplicitWaitSendKeys(profilepage.entercityAddressunderaddadditionaladdresspopup(),"Sydney");
		Thread.sleep(3000);		
		//SELECT COUNTRY UNDER ADD ADDITIONAL ADDRESS POPUP  
		profilepage.selectcountryunderaddadditionaladdresspopup();
		Thread.sleep(3000);		
		//ENTER ZIPE CODE UNDER ADD ADDITIONAL ADDRESS POPUP 
		loginpage.ExplicitWaitSendKeys(profilepage.Zipcodeunderaddadditionaladdresspopup(),"54321");
		Thread.sleep(3000);	
		//ENTER EMAIL UNDER ADD ADDITIONAL ADDRESS POPUP 
		loginpage.ExplicitWaitSendKeys(profilepage.Emailunderaddadditionaladdresspopup(),"primary@mail.com");
				
		//SELECT TIME ZONE UNDER ADD ADDITIONAL ADDRESS POPUP 
	//	profilepage.SelectTimezoneunderaddadditionaladdresspopup();
		
		Thread.sleep(3000);
		//CHECKBOX MAKE PRIMARY ADDRESS 
		loginpage.ExplicitWait(profilepage.primaryaddress());
		Thread.sleep(3000);
		//SAVE BUTTON UNDER ADD ADDITIONAL ADDRESS POPUP 
		loginpage.ExplicitWait(profilepage.SaveButtonunderaddadditionaladdresspopup()); 
		
		Thread.sleep(8000);
		String PrimaryLocation = driver.findElement(By.xpath("//em[contains(text(),'Primary ')]")).getText();
		System.out.println(PrimaryLocation); 
		Assert.assertEquals("PRIMARY LOCATION NOT APPEARS AS PRIMARY","Primary",PrimaryLocation);
		
	}
	
	
	@Test(priority=16)
	public void VerifyThatUserIsAbleToAddAddressDetailsOn_ClickingSaveButtonUnderAddAdditionalAddressPopup() throws InterruptedException{
		
		//ADD BUTON UNDER LOCATION 
				loginpage.ExplicitWait(profilepage.addbuttonunderlocation());
				Thread.sleep(3000);
				//ENTER LOCATION UNDER ADD ADDITIONAL ADDRESS POPUP
				loginpage.ExplicitWaitSendKeys(profilepage.enterlocationunderaddadditionaladdresspopup(),"Denamrk");
				Thread.sleep(3000);
				//ENTER STREET ADDRESS UNDER ADD ADDITIONAL ADDRESS POPUP
				loginpage.ExplicitWaitSendKeys(profilepage.enterstreetAddressunderaddadditionaladdresspopup(),"Street-121");
				Thread.sleep(3000);
				//ENTER CITY ADDRESS UNDER ADD ADDITIONAL ADDRESS POPUP 
				loginpage.ExplicitWaitSendKeys(profilepage.entercityAddressunderaddadditionaladdresspopup(),"Denmark");
				Thread.sleep(3000);
				//SELECT COUNTRY UNDER ADD ADDITIONAL ADDRESS POPUP  
				profilepage.selectcountryunderaddadditionaladdresspopup();
				Thread.sleep(3000);
				//ENTER ZIPE CODE UNDER ADD ADDITIONAL ADDRESS POPUP 
				loginpage.ExplicitWaitSendKeys(profilepage.Zipcodeunderaddadditionaladdresspopup(),"12345");
			    Thread.sleep(3000);
				//ENTER EMAIL UNDER ADD ADDITIONAL ADDRESS POPUP 
				loginpage.ExplicitWaitSendKeys(profilepage.Emailunderaddadditionaladdresspopup(),"rock@mail.com");
				Thread.sleep(3000);
				//SELECT TIME ZONE UNDER ADD ADDITIONAL ADDRESS POPUP 
				profilepage.SelectTimezoneunderaddadditionaladdresspopup();
				
				Thread.sleep(3000);
				//SAVE BUTTON UNDER ADD ADDITIONAL ADDRESS POPUP 
				loginpage.ExplicitWait(profilepage.SaveButtonunderaddadditionaladdresspopup()); 
		          
		    Thread.sleep(1000);
		//	String succmsg = driver.findElement(By.className("message")).getText();	
		//	System.out.println(succmsg);
		//	Assert.assertEquals("SUCCESS MESSAGE NOT APEEARS","Address details added successfully.",succmsg);
				
	  }
	
	
	@Test(priority=17) 
	public void VerifyThatEditPrimaryAddressPopupOpensUpOnClicking_EditIconUnderLocationsSectionOnTheProfilePage() throws InterruptedException{
		
		Thread.sleep(2000);
		//EDIT ICON UNDER LOCATION 
		loginpage.ExplicitWait(profilepage.editiconunderlocation());
		
		//VALIDATE EDIT PRIMARY ADDRESS POPUP TITLE 
		Thread.sleep(3000);
		String title = loginpage.ExplicitWaitGetText(profilepage.editprimaryaddresspopuptitle());
		System.out.println(title);
		Assert.assertEquals("POPUP TITLE NOT APPEARS AS EDIT PRIMARY ADDRESS","Edit Primary Address",title);
		
	}
	
	
	@Test(priority=18)
	public void ValidationMsgAppearsOnClickingRemoveButtonWhenA_TeamMemberIsUsingThatLocationUnderEditPrimaryAddressPopup() throws InterruptedException{
		
		Thread.sleep(2000);
		//EDIT ICON UNDER LOCATION 
		loginpage.ExplicitWait(profilepage.editiconunderlocation());
				
		//VALIDATE EDIT PRIMARY ADDRESS POPUP TITLE 
		Thread.sleep(3000);
		String title = loginpage.ExplicitWaitGetText(profilepage.editprimaryaddresspopuptitle());
		System.out.println(title);
		Assert.assertEquals("POPUP TITLE NOT APPEARS AS EDIT PRIMARY ADDRESS","Edit Primary Address",title);
		//REMOVE BUTTON
		Thread.sleep(3000);
		loginpage.ExplicitWait(profilepage.Removebuttonundereditprimaryaddresspopup());
		   
		Thread.sleep(3000);
		//YES BUTTON ON CONFIRMATION MESSAGE  
		loginpage.ExplicitWait(profilepage.YesBtnonconfirmationmessage());
		 
		 Thread.sleep(1000);
		//VALIDATION MESSAGE  
	    String Vald = driver.findElement(By.className("message")).getText();
	    System.out.println(Vald);
		Assert.assertEquals("VALIDATION MESSAGE NOT APPEARS","Priamry address can't be deleted, mark other address to primary to delete this.",Vald);
		
		
	}
	
	
	@Test(priority=19)
	public void DeleteTheLocationAfterClickingOn_RemoveButtonOnEditSecondaryAddressPopup() throws InterruptedException{
		
        
		Thread.sleep(2000);
		//EDIT ICON UNDER LOCATION 
		//CLOSE THE CHAT BOT 
	    bot= new Closethebot();
	    bot.Closing_the_bot();
		loginpage.ExplicitWait(profilepage.editiconunderSECONDARYlocation());
		
		Thread.sleep(3000);
		//EDIT LOCATION 
    //   WebElement cler =   driver.findElement(By.xpath("(//button[contains(text(),'Remove')])[1]")) ; 
        
 	//   Actions actions = new Actions(driver);
 	//   actions.moveToElement(cler);
 	//   actions.click(cler).perform();
        
       ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("(//button[contains(text(),'Remove')])[1]")));
       
       
	//	Thread.sleep(3000);
		//REMOVE BUTTON
	 //   loginpage.ExplicitWait(profilepage.Removebuttonundereditprimaryaddresspopup());
		
	    Thread.sleep(3000);
	  //YES BUTTON ON CONFIRMATION MESSAGE  
		loginpage.ExplicitWait(profilepage.YesBtnonconfirmationmessage());
	   
	//	Thread.sleep(2000);
	//    String valdmsg = driver.findElement(By.className("message")).getText();
	//	Assert.assertEquals("VALIDATION MESSAGE NOT APPEARES","Address Details deleted successfully",valdmsg); 
		
	}
    
	
	@Test(priority=20) 
	public void ValidationMessageAppearsOnLeavingMandatory_FieldsBlankUnderEditPrimaryAddressPopup() throws InterruptedException{
		 
		Thread.sleep(2000);
		//EDIT ICON UNDER PRIMARY LOCATION 
		loginpage.ExplicitWait(profilepage.editiconunderlocation());
		Thread.sleep(3000);        
		//EDIT LOCATION 
		loginpage.ExplicitWaitClear(profilepage.enterlocationunderaddadditionaladdresspopup());
		Thread.sleep(3000);
		 //SAVE BUTTON 
		loginpage.ExplicitWait(profilepage.SaveButtonunderaddadditionaladdresspopup());
		
		Thread.sleep(1000);
		 //VALIDATION ON LEAVING MANDATORY FIELDS      
		String valdmsg = driver.findElement(By.className("message")).getText();
		Assert.assertEquals("VALIDATION MESSAGE NOT APPEARES","Please enter Location.",valdmsg);
		        
	}
   
	
	@Test(priority=21)
	public void ValidationMsgAppearsOnLeavingMandatory_FieldsBlankUnderEditSecondaryAddressPopup() throws InterruptedException{
		
		//CLOSE THE CHAT BOT 
				bot= new Closethebot();
			    bot.Closing_the_bot();
			    Thread.sleep(1000);
		//EDIT ICON UNDER SECONDARY LOCATION
		       loginpage.ExplicitWait(profilepage.editiconunderSECONDARYlocation());
		       Thread.sleep(3000);
		//EDIT LOCATION 
		        loginpage.ExplicitWaitClear(profilepage.enterlocationunderaddadditionaladdresspopup());
		           
		//SAVE BUTTON 
		        Thread.sleep(3000);
		        loginpage.ExplicitWait(profilepage.SaveButtonunderaddadditionaladdresspopup());
		
		        Thread.sleep(3000);
		//VALIDATION ON LEAVING MANDATORY FIELDS 
		String valdmsg = driver.findElement(By.className("message")).getText();       
	//	String valdmsg = driver.findElement(By.xpath("//span[contains(text(),'Please enter Location.')]")).getText();
		Assert.assertEquals("VALIDATION MESSAGE NOT APPEARES","Please enter Location.",valdmsg);
				                
		                
	}
    
	
	@Test(priority=22)
	public void UpdateAddressDetailsOnClicking_SaveButtonUnderEditPrimaryAddressPopup() throws InterruptedException{
		 
		 Thread.sleep(3000);
		//EDIT ICON UNDER PRIMARY LOCATION 
		loginpage.ExplicitWait(profilepage.editiconunderlocation());
		
		Thread.sleep(3000);
		//SAVE BUTTON 
		loginpage.ExplicitWait(profilepage.SaveButtonunderaddadditionaladdresspopup()); 
		
		Thread.sleep(2000);
		//VALIDATION ON LEAVING MANDATORY FIELDS 
	//	String valdmsg = driver.findElement(By.className("message")).getText();
	//	Assert.assertEquals("VALIDATION MESSAGE NOT APPEARES","Address details updated successfully.",valdmsg);
				                
		
	}   
	
	
	@Test(priority=23)
	public void UserIsAbleToUpdateAddressDetails_OnClickingSaveButtonUnderEditSecondaryAddressPopup() throws InterruptedException{
		
	
		       
		      Thread.sleep(3000);
		    //CLOSE THE CHAT BOT 
				bot= new Closethebot();
			    bot.Closing_the_bot();
		//EDIT ICON UNDER SECONDARY LOCATION
		      loginpage.ExplicitWait(profilepage.editiconunderSECONDARYlocation());   
		       Thread.sleep(3000);
		//SAVE BUTTON 
		       loginpage.ExplicitWait(profilepage.SaveButtonunderaddadditionaladdresspopup()); 
		
		  Thread.sleep(2000);
		//VALIDATION ON LEAVING MANDATORY FIELDS    
		String valdmsg = driver.findElement(By.className("message")).getText();
		Assert.assertEquals("VALIDATION MESSAGE NOT APPEARES","Address details updated successfully.",valdmsg);
				                
		
	}
	
	
	@Test(priority=24)
	public void InsertWebsitePopupOpensUp_OnClickingAddButtonUnderWebsiteSection() throws InterruptedException{
		       
		     Thread.sleep(3000);
		    //ADD BUTTON UNDER WEBSITE POPUP 
		     loginpage.ExplicitWait(profilepage.addbuttonunderWebsitepopup());
		
		     Thread.sleep(3000);
		   //VALIDATE INSERT WEBSITE POPUP 
		    String txt = driver.findElement(By.xpath("//h3[contains(text(),'Insert Website')]")).getText();
		    Assert.assertEquals("INSERT WEBSITE POPUP MISMATCHED","Insert Website",txt); 
	}
	
	@Test(priority=25)
	public void ValidationMsgAppearsOnLeavingTextField_BlankUnderInsertWebsitePopup() throws InterruptedException{
		
		     Thread.sleep(3000);
		//ADD BUTTON UNDER WEBSITE POPUP 
		     loginpage.ExplicitWait(profilepage.addbuttonunderWebsitepopup());
		     Thread.sleep(3000);
		//SAVE BUTTON 
		     loginpage.ExplicitWait(profilepage.SaveButtonunderWEBSITEPOPUP());
		      
		     Thread.sleep(1000);
		//VALIDATION MESSAGE 
		      String valdmsg = driver.findElement(By.className("message")).getText();
			  Assert.assertEquals("INSERT WEBSITE POPUP MISMATCHED","Please enter Website URL.",valdmsg);      
	}
	
	@Test(priority=26)
	public void ValidationMsgAppearsOnEnteringInvalidURLIn_TextFieldUnderInsertWebsitePopup() throws InterruptedException{
		
		  Thread.sleep(3000);
		//ADD BUTTON UNDER WEBSITE POPUP 
		  loginpage.ExplicitWait(profilepage.addbuttonunderWebsitepopup());
		  Thread.sleep(3000);
		  
		//SEND URL UNDER WEBSITE POPUP 
		  loginpage.ExplicitWaitSendKeys(profilepage.SendUrlunderwebsitesection(),"htttp//google");
		  Thread.sleep(3000); 
		  
		//SAVE BUTTON 
	      loginpage.ExplicitWait(profilepage.SaveButtonunderWEBSITEPOPUP()); 
		  
	      Thread.sleep(1000);
	    //VALIDATION MESSAGE 
	      String valdmsg = driver.findElement(By.className("message")).getText();
		  Assert.assertEquals("INSERT WEBSITE POPUP MISMATCHED","Please enter valid Website URL.",valdmsg);  
	      
	}
	
	
	@Test(priority=27)
	public void UserIsAbleToSaveTheWebsite_OnClickingSaveButtonUnderInsertWebsitePopup() throws InterruptedException{
		  
		  Thread.sleep(3000);
		//ADD BUTTON UNDER WEBSITE POPUP 
		  loginpage.ExplicitWait(profilepage.addbuttonunderWebsitepopup());
		
		  Thread.sleep(3000);
		//SEND URL UNDER WEBSITE POPUP
		  
		  Date date = new Date (); 
			long time =   date.getTime();
			System.out.println(time);
		
		//SEND URL UNDER WEBSITE POPUP 
		  loginpage.ExplicitWaitSendKeys(profilepage.SendUrlunderwebsitesection(),"www."+time+"recordlinc.com");
		  
		  Thread.sleep(3000);
		//SAVE BUTTON 
	      loginpage.ExplicitWait(profilepage.SaveButtonunderWEBSITEPOPUP()); 
		   
	     Thread.sleep(2000);
	    //SUCCESSFULLY MESSAGE 
	      String valdmsg = driver.findElement(By.className("message")).getText();
		  Assert.assertEquals("SUCCESS MESSAGE NOT APEEARS","Website added successfully",valdmsg);  
		   
		  Thread.sleep(3000);
		  
		//CLICK ON EDIT WEBSITE URL ICON 
		  loginpage.ExplicitWait(profilepage.EditIconUnderWebsiteSection());
		  
		  Thread.sleep(3000);
		//CLICK ON REMOVE BUTTON UNDER EDIT SECONDARY WEBSITE URL POPUP 
		  loginpage.ExplicitWait(profilepage.RemoveBtnUndrSecWebURL());
		   
		  Thread.sleep(3000);
		//YES BUTTON AFTER CLICK ON REMOVE BUTTON UNDER EDIT SECONDARY WEBSITE URL POPUP 
		  loginpage.ExplicitWait(profilepage.YesBtnUndrRemoveBtnUndrSecWebURL());
		  
		  Thread.sleep(1000);
		 
		  
		  
	}
	
	
	@Test(priority=28)
	public void ValidationMsgAppearsOnEnteringAlreadyAddedWebsite_URLInInsertWebsiteTextfieldUnderInsertWebsitePopup() throws InterruptedException{
		
		
		  Thread.sleep(3000);
		//ADD BUTTON UNDER WEBSITE POPUP 
		  loginpage.ExplicitWait(profilepage.addbuttonunderWebsitepopup());
		
		  Thread.sleep(3000);
		//SEND URL UNDER WEBSITE POPUP 
		  loginpage.ExplicitWaitSendKeys(profilepage.SendUrlunderwebsitesection(),"https://www.recordlinc12.com");
		  
		  Thread.sleep(3000);
		//SAVE BUTTON 
	      loginpage.ExplicitWait(profilepage.SaveButtonunderWEBSITEPOPUP()); 
		  
	      Thread.sleep(2000);
	    //VALIDATION MESSAGE 
	      String valdmsg = driver.findElement(By.className("message")).getText();
		  Assert.assertEquals("VALIDATION MESSAGE NOT APEEARS","Website already exists!",valdmsg); 
		
	}
	
	
	@Test(priority=29)
	public void EditPrimaryWebsiteURLPopupOpensUpOn_ClickingEditIconUnderWebsiteSectionOnProfilePage() throws InterruptedException{
		   Thread.sleep(2000);
		   
		  //PRIMARY WEBSITE URL ICON 
		   loginpage.ExplicitWait(profilepage.PrimaryWebsiteURL_EditIcon());
		    
		   Thread.sleep(3000);
		  //VALIDATION MESSAGE 
		   String valdmsg = driver.findElement(By.xpath("//h3[contains(text(),'Edit Primary Website URL')]")).getText();
		   Assert.assertEquals("POPUP NOT APPEARS","Edit Primary Website URL",valdmsg);
		
	}
	
	@Test(priority=30)
	public void EditSecondaryWebsiteURLPopupOpensUpOn_ClickingEditIconUnderWebsiteSectionOnProfilePage() throws InterruptedException{
		   Thread.sleep(2000);
		   
		  //SECONDARY WEBSITE URL ICON 
		   loginpage.ExplicitWait(profilepage.EditIconUnderWebsiteSection());
		    
		   Thread.sleep(3000);
		  //VALIDATION MESSAGE 
		   String valdmsg = driver.findElement(By.xpath("//h3[contains(text(),'Edit Secondary Website URL')]")).getText();
	       Assert.assertEquals("POPUP NOT APPEARS","Edit Secondary Website URL",valdmsg);
		
	}
    
	
	@Test(priority=31)
	public void ConfirmationMessageAppearsOnClickingRemoveButton_UnderEditPrimaryWebsiteURLPopupOnProfilePage() throws InterruptedException{
		
		Thread.sleep(3000);
		//PRIMARY WEBSITE URL ICON 
	    loginpage.ExplicitWait(profilepage.PrimaryWebsiteURL_EditIcon());
		
	    Thread.sleep(3000);
	    //REMOVE BUTTON  
	    loginpage.ExplicitWait(profilepage.RemoveBtnUndrSecWebURL());
		  
	    Thread.sleep(3000);
	  //CONFIRMATION MESSAGE 
	      String valdmsg = driver.findElement(By.xpath("//p[contains(text(),'Are you sure you want to remove?')]")).getText();
	      System.out.println(valdmsg);
		  Assert.assertEquals("POPUP NOT APPEARS","Are you sure you want to remove?",valdmsg);
	}    
	
	@Test(priority=32)
	public void ConfirmationMessageAppearsOnClickingRemoveButton_UnderEditSecondaryWebsiteURLPopupOnProfilePage() throws InterruptedException{
		
		Thread.sleep(3000);
		//SECONDARY WEBSITE URL ICON 
	    loginpage.ExplicitWait(profilepage.EditIconUnderWebsiteSection());
		
	    Thread.sleep(3000);
	    //REMOVE BUTTON  
	    loginpage.ExplicitWait(profilepage.RemoveBtnUndrSecWebURL());
		  
	    Thread.sleep(3000);
	  //CONFIRMATION MESSAGE 
	      String valdmsg = driver.findElement(By.xpath("//p[contains(text(),'Are you sure you want to remove?')]")).getText();
	      System.out.println(valdmsg);
		  Assert.assertEquals("POPUP NOT APPEARS","Are you sure you want to remove?",valdmsg);
	}  
	
	
	@Test(priority=33)
	public void RemoveTheAddedWebsiteOnClickingYesButton_UnderConfirmationMessageOnProfilePage() throws InterruptedException{
		   
		  Thread.sleep(3000);
		//ADD BUTTON UNDER WEBSITE POPUP 
		  loginpage.ExplicitWait(profilepage.addbuttonunderWebsitepopup());
		  
		  Thread.sleep(3000);
		  Date date = new Date (); 
			long time =   date.getTime();
			System.out.println(time);
		
		//SEND URL UNDER WEBSITE POPUP 
		  loginpage.ExplicitWaitSendKeys(profilepage.SendUrlunderwebsitesection(),"www."+time+"recordlinc.com");
		  
		  Thread.sleep(3000);
		//SAVE BUTTON 
	      loginpage.ExplicitWait(profilepage.SaveButtonunderWEBSITEPOPUP()); 
		  
		  Thread.sleep(4000);
		  
		//CLICK ON EDIT WEBSITE URL ICON 
	//	  loginpage.ExplicitWait(profilepage.EditIconUnderWebsiteSection());
		  
		  ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
					driver.findElement(By.xpath("(//i[@class='ico-edit']//preceding::a[@href='#edit-primary-website-url' ])[last()]")));
		  
		  
		  Thread.sleep(3000);
		//CLICK ON REMOVE BUTTON UNDER EDIT SECONDARY WEBSITE URL POPUP 
		  loginpage.ExplicitWait(profilepage.RemoveBtnUndrSecWebURL());
		  
		  Thread.sleep(3000);
		//YES BUTTON AFTER CLICK ON REMOVE BUTTON UNDER EDIT SECONDARY WEBSITE URL POPUP 
		  loginpage.ExplicitWait(profilepage.YesBtnUndrRemoveBtnUndrSecWebURL());
		  
		  Thread.sleep(2000);
		 //SUCCESS MESSAGE AFTER REMOVE WEBSITE URL 
		  String valdmsg1 = driver.findElement(By.className("message")).getText();
		  Assert.assertEquals("SUCCESS MESSAGE NOT APEEARS","Secondary Website removed successfully.",valdmsg1);
	
		
	}
	
	
	@Test(priority=34)
	public void EditSocialInformationPopupOpensUpOnClicking_EditButtonUnderSocialMediaSectionOnProfilePage() throws InterruptedException{
		  
	   	 Thread.sleep(3000);
		 //EDIT ICON IN SOCIAL MEDIA SECTION 
	    loginpage.ExplicitWait(profilepage.SocialMediaSection_EditIcon());  
		  
		 Thread.sleep(3000);
		 //EDIT SOCIAL INFORMATION POPUP 
		String valdmsg = driver.findElement(By.xpath("//h3[contains(text(),'Edit Social Information')]")).getText();
		System.out.println(valdmsg);
	    Assert.assertEquals("POPUP TITLE NOT APPEARS","Edit Social Information",valdmsg);  
		
	}
	
	@Test(priority=35)
	public void ValidationMsgAppearsOnleavingAllFields_BlankUnderEditSocialInformationPopup() throws InterruptedException{
		
		Thread.sleep(3000);
		//EDIT ICON IN SOCIAL MEDIA SECTION 
		loginpage.ExplicitWait(profilepage.SocialMediaSection_EditIcon()); 
		
		Thread.sleep(3000);
		//FACEBOOK TEXT FIELD UNDER SOCIAL MEDIA SECTION  
		loginpage.ExplicitWaitClear(profilepage.FbUrlFieldSocialMediaSection()); 
		
		Thread.sleep(3000);
		//TWITTER TEXT FIELD UNDER SOCIAL MEDIA SECTION  
		loginpage.ExplicitWaitClear(profilepage.TwitterUrlFieldSocialMediaSection());
		
		Thread.sleep(3000);
		//INSTAGRAM TEXT FIELD UNDER SOCIAL MEDIA SECTION 
		loginpage.ExplicitWaitClear(profilepage.InstagramUrlFieldSocialMediaSection());
		
		Thread.sleep(3000);
		//LINKED IN TEXT FIELD UNDER SOCIAL MEDIA SECTION  
		loginpage.ExplicitWaitClear(profilepage.LinkedINUrlFieldSocialMediaSection());
		
		Thread.sleep(3000);
		//GOOGLE PLUS TEXT FIELD UNDER SOCIAL MEDIA SECTION  
		loginpage.ExplicitWaitClear(profilepage.GooglePlusUrlFieldSocialMediaSection());
		
		Thread.sleep(3000);
		//PINTEREST PLUS TEXT FIELD UNDER SOCIAL MEDIA SECTION
		loginpage.ExplicitWaitClear(profilepage.PinterestUrlFieldSocialMediaSection());  
		
		Thread.sleep(3000);
		//YOUTUBE TEXT FIELD UNDER SOCIAL MEDIA SECTION  
		loginpage.ExplicitWaitClear(profilepage.YoutubeUrlFieldSocialMediaSection());
		
		Thread.sleep(3000);
		//BLOG TEXT FIELD UNDER SOCIAL MEDIA SECTION  
	    loginpage.ExplicitWaitClear(profilepage.BlogUrlFieldSocialMediaSection()); 
	    
	    Thread.sleep(3000);
	    //YELP TEXT FIELD UNDER SOCIAL MEDIA SECTION  
	    loginpage.ExplicitWaitClear(profilepage.YelpUrlFieldSocialMediaSection()); 
	    
	    Thread.sleep(3000);
	    //SAVE BUTTON UNDER SOCIAL MEDIA SECTION 
	    loginpage.ExplicitWait(profilepage.SaveButtonUnderSocialMediaSection()); 
	    
	    Thread.sleep(1000);
	  //VALIDATION MESSAGE Appears_OnleavingAllFieldsBlank_ 
		 String valdmsg1 = driver.findElement(By.className("message")).getText();
		 Assert.assertEquals("VALIDATION MESSAGE NOT APEEARS","Please enter atleast one Social Media Detail.",valdmsg1);
	    
	}
	
	@Test(priority=36)
	public void ValidationMsgAppearsOnEnteringInvalid_URLInAnyFieldUnderEditSocialInformationPopup() throws InterruptedException{
		
		Thread.sleep(3000);
		//EDIT ICON IN SOCIAL MEDIA SECTION 
		    loginpage.ExplicitWait(profilepage.SocialMediaSection_EditIcon()); 
		     
		    Thread.sleep(3000);
		//FACEBOOK TEXT FIELD UNDER SOCIAL MEDIA SECTION  
		    loginpage.ExplicitWaitClear(profilepage.FbUrlFieldSocialMediaSection()); 
	        
		    Thread.sleep(3000);
		//ENTER INVALID URL IN FACEBOOK TEXT FIELD UNDER SOCIAL MEDIA SECTION   
		    loginpage.ExplicitWaitSendKeys(profilepage.FbUrlFieldSocialMediaSection(),"google.com");
		     
		    Thread.sleep(3000);
		//SAVE BUTTON UNDER SOCIAL MEDIA SECTION 
		    loginpage.ExplicitWait(profilepage.SaveButtonUnderSocialMediaSection()); 
		     
		    Thread.sleep(1000);
		//VALIDATION MESSAGE Appears_OnEnteringInvalidURL
			 String valdmsg1 = driver.findElement(By.className("message")).getText();
			 Assert.assertEquals("VALIDATION MESSAGE NOT APEEARS","Please enter a valid Facebook URL.",valdmsg1);
		    
	}
	
	
	@Test(priority=37)
	public void SaveSocialMediaDetailsOnClicking_SaveButtonUnderEditSocialInformationPopup() throws InterruptedException{
		
		Thread.sleep(3000);
		//EDIT ICON IN SOCIAL MEDIA SECTION 
		loginpage.ExplicitWait(profilepage.SocialMediaSection_EditIcon()); 
		        Thread.sleep(3000);
		       //FACEBOOK TEXT FIELD UNDER SOCIAL MEDIA SECTION  
				loginpage.ExplicitWaitClear(profilepage.FbUrlFieldSocialMediaSection()); 
				
				Thread.sleep(3000);
				//ENTER URL IN FB FIELD
				loginpage.ExplicitWaitSendKeys(profilepage.FbUrlFieldSocialMediaSection(),"https://www.facebook.com/"); 
				
				Thread.sleep(3000);
		//-------------------------------------------------------------		
				//TWITTER TEXT FIELD UNDER SOCIAL MEDIA SECTION  
				loginpage.ExplicitWaitClear(profilepage.TwitterUrlFieldSocialMediaSection()); 
				
				Thread.sleep(3000);
				//ENTER TWITTER URL IN TEXT FIELD 
				loginpage.ExplicitWaitSendKeys(profilepage.TwitterUrlFieldSocialMediaSection(),"https://twitter.com/login"); 
				
				Thread.sleep(3000);
		//-------------------------------------------------------------		
				//INSTAGRAM TEXT FIELD UNDER SOCIAL MEDIA SECTION 
				loginpage.ExplicitWaitClear(profilepage.InstagramUrlFieldSocialMediaSection()); 
				
				Thread.sleep(3000);
				//ENTER INSTAGRAM URL IN TEXT FIELD 
				loginpage.ExplicitWaitSendKeys(profilepage.InstagramUrlFieldSocialMediaSection(),"https://www.instagram.com/accounts//email");
				
				Thread.sleep(3000);
		//-------------------------------------------------------------		
				//LINKED IN TEXT FIELD UNDER SOCIAL MEDIA SECTION  
				loginpage.ExplicitWaitClear(profilepage.LinkedINUrlFieldSocialMediaSection()); 
				
				Thread.sleep(3000);
				//ENTER LINKED IN TEXT FIELD UNDER SOCIAL MEDIA SECTION 
				loginpage.ExplicitWaitSendKeys(profilepage.LinkedINUrlFieldSocialMediaSection(),"https://www.linkedin.com/"); 
				
				Thread.sleep(3000);
		//-------------------------------------------------------------		
				//GOOGLE PLUS TEXT FIELD UNDER SOCIAL MEDIA SECTION  
				loginpage.ExplicitWaitClear(profilepage.GooglePlusUrlFieldSocialMediaSection());  
				
				Thread.sleep(3000);
				//ENTER GOOGLE PLUS TEXT FIELD UNDER SOCIAL MEDIA SECTION 
			//	loginpage.ExplicitWaitSendKeys(profilepage.GooglePlusUrlFieldSocialMediaSection(),"https://www.googleplus.com/");
		//--------------------------------------------------------------		
				//PINTEREST PLUS TEXT FIELD UNDER SOCIAL MEDIA SECTION
				loginpage.ExplicitWaitClear(profilepage.PinterestUrlFieldSocialMediaSection());  
				
				Thread.sleep(3000);
				//ENTER PINTEREST PLUS TEXT FIELD UNDER SOCIAL MEDIA SECTION 
				loginpage.ExplicitWaitSendKeys(profilepage.PinterestUrlFieldSocialMediaSection(),"https://www.pinterest.com/sdf"); 
				
				Thread.sleep(3000);
		//--------------------------------------------------------------		
				//YOUTUBE TEXT FIELD UNDER SOCIAL MEDIA SECTION  
				loginpage.ExplicitWaitClear(profilepage.YoutubeUrlFieldSocialMediaSection()); 
				
				Thread.sleep(3000);
				//ENTER YOUTUBE TEXT FIELD UNDER SOCIAL MEDIA SECTION 
				loginpage.ExplicitWaitSendKeys(profilepage.YoutubeUrlFieldSocialMediaSection(),"https://www.youtube.com/test");
				
				Thread.sleep(3000);
		//---------------------------------------------------------------		
				//BLOG TEXT FIELD UNDER SOCIAL MEDIA SECTION  
			    loginpage.ExplicitWaitClear(profilepage.BlogUrlFieldSocialMediaSection());  
			    
			    Thread.sleep(3000);
			    //ENTER BLOG TEXT FIELD UNDER SOCIAL MEDIA SECTION 
			    loginpage.ExplicitWaitSendKeys(profilepage.BlogUrlFieldSocialMediaSection(),"https://wordpress.com/create-blog/?utm_source=adwords&utm_medium=cpc&keyword=blog&creative=329696951453&campaignid=683204350&adgroupid=60978443880&matchtype=e&device=c&network=g&&sgmt=gb&utm_source=adwords&utm_campaign=Google_WPcom_Search_Non_Desktop_IN_en&utm_medium=cpc&keyword=blog&creative=329696951453&campaignid=683204350&adgroupid=60978443880&matchtype=e&device=c&network=g&targetid=kwd-21745101&locationid=9050511&gclid=EAIaIQobChMInLmjyZTg4AIVxY6PCh0s4gdPEAAYASACEgLRBvD_BwE");
	    //----------------------------------------------------------------		 
			    Thread.sleep(3000);
			    //YELP TEXT FIELD UNDER SOCIAL MEDIA SECTION  
			    loginpage.ExplicitWaitClear(profilepage.YelpUrlFieldSocialMediaSection()); 
			    
			    Thread.sleep(3000);
		        //ENTER YELP TEXT FIELD UNDER SOCIAL MEDIA SECTION   
		        loginpage.ExplicitWaitSendKeys(profilepage.YelpUrlFieldSocialMediaSection(),"https://www.yelp.com/");
		//----------------------------------------------------------------
		        Thread.sleep(3000); 
		      //SAVE BUTTON UNDER SOCIAL MEDIA SECTION 
			    loginpage.ExplicitWait(profilepage.SaveButtonUnderSocialMediaSection());  
			     
			    Thread.sleep(2000);
			  //SUCCESS MESSAGE APPEARS ON ENTERING INVALID URL
				 String valdmsg1 = driver.findElement(By.className("message")).getText();
				 Assert.assertEquals("SUCCESS MESSAGE NOT APEEARS","Social Media Details updated successfully.",valdmsg1);    
			    
	}  
	
	
	@Test(priority=38)
	public void CorrectPageOpensUpOnClickingAnyAdded_SocialMediaIconUnderSocialMediaSection() throws InterruptedException{
		
		Thread.sleep(3000);
		 //FACEBOOK ICON UNDER SOCIAL MEDIA SECTION  
		loginpage.ExplicitWait(profilepage.FacebookIconUnderSocialMediaSection());
		
		Thread.sleep(3000);
		//VALIDATION FACEBOOK APEG TITLE  
		String parenthandler= driver.getWindowHandle();
		
		 Set<String>allwindowhandles = driver.getWindowHandles();
		    
		   for(String currenthandle :allwindowhandles){
		    	 
		   	 System.out.println("Current window handle is"+currenthandle);
		    	 if(!currenthandle.equalsIgnoreCase(parenthandler)){
		    		 
		    	 driver.switchTo().window(currenthandle); 
		    	 String PageTitle = driver.getTitle();
		    	 System.out.println("Title of child window is "+":-"+PageTitle); 
			     Assert.assertEquals("Facebook – log in or sign up",PageTitle);	
		    		// driver.close();
		    	 }
		   }
	    
	}
	
	@Test(priority=39)
	public void DescriptionPopupOpensUpOnClicking_AddButtonUnderDescriptionSection() throws InterruptedException{
		
		Thread.sleep(3000);
		//EDIT BUTTON UNDER DESCRIPTION SECTION   
		loginpage.ExplicitWait(profilepage.EditButtonUnderDescriptionSection());
		
		Thread.sleep(3000);
		//DESCRIPTION POPUP OPENS UP  
		String PopupTitle = driver.findElement(By.xpath("//h3[text()='Description']")).getText();
		System.out.println(PopupTitle);
		Assert.assertEquals("Description",PopupTitle);
		
		
	}
	
	@Test(priority=40)
	public void ValidationMsgAppearsOnLeavingDescription_TextFieldBlankUnderDescriptionPopup() throws InterruptedException{
		 
		 Thread.sleep(3000);
		//EDIT BUTTON UNDER DESCRIPTION SECTION   
		  loginpage.ExplicitWait(profilepage.EditButtonUnderDescriptionSection());
		 Thread.sleep(3000);
		 
		//CLEAR TEXT FIELD UNDER DESCRIPTION SECTION  
		 loginpage.ExplicitWaitClear(profilepage.TextFieldUnderDescriptionSection());
		 
		 Thread.sleep(3000);
		//SAVE BUTTON UNDER DESCRIPTION POPUP 
		 loginpage.ExplicitWait(profilepage.SaveButtonUnderDescriptionSection());
		  
		 Thread.sleep(1000);
		 //VALIDATION MESSAGE Appears_OnLeavingDescriptionTextField_Blank
		 String valdmsg1 = driver.findElement(By.className("message")).getText();
		 System.out.println(valdmsg1);
		 Assert.assertEquals("VALIDATION MESSAGE NOT APEEARS","Please enter Description.",valdmsg1);     
		 
	}
    
  
  @Test(priority=41)
  public void CountOfCharactersRemainingForTheDescriptionTextfield_GetsUpdatedWhileEnteringTextInDescriptionTextfieldUnderDescriptionPopup() throws InterruptedException{
		
		//EDIT BUTTON UNDER DESCRIPTION SECTION 
	     Thread.sleep(3000);
		 loginpage.ExplicitWait(profilepage.EditButtonUnderDescriptionSection());
		 Thread.sleep(3000);
		 
		//CLEAR TEXT FIELD UNDER DESCRIPTION SECTION  
		 loginpage.ExplicitWaitClear(profilepage.TextFieldUnderDescriptionSection());
		 
		 Thread.sleep(3000);
		//ENTER IN TEXT FIELD UNDER DESCRIPTION SECTION   
		 loginpage.ExplicitWaitSendKeys(profilepage.TextFieldUnderDescriptionSection(),"Hello");
		 
		 Thread.sleep(3000);
		//COUNT OF CHARACTER REMANING 
		 String Count = driver.findElement(By.xpath("//*[@id=\"txtdescriptionlength\"]")).getAttribute("value");
		 System.out.println(Count);
		 Assert.assertEquals("2843", Count);
		
	}
	
	
	@Test(priority=42)
	public void UserIsAbleToSaveDescriptionOn_ClickingSaveButtonUnderDescriptionPopup() throws InterruptedException{
		
		
		 Thread.sleep(3000);
		 //CLOSE THE CHAT BOT 
		bot= new Closethebot();
	  	bot.Closing_the_bot();
		//EDIT BUTTON UNDER DESCRIPTION SECTION   
		  loginpage.ExplicitWait(profilepage.EditButtonUnderDescriptionSection());
		 Thread.sleep(3000);
		 
		//CLEAR TEXT FIELD UNDER DESCRIPTION SECTION  
		 loginpage.ExplicitWaitClear(profilepage.TextFieldUnderDescriptionSection());
		 
		 Thread.sleep(3000);
		//ENTER IN TEXT FIELD UNDER DESCRIPTION SECTION   
		 loginpage.ExplicitWaitSendKeys(profilepage.TextFieldUnderDescriptionSection(),"Hello");
		
		 Thread.sleep(3000);
		 //SAVE BUTTON UNDER DESCRIPTION POPUP 
		 loginpage.ExplicitWait(profilepage.SaveButtonUnderDescriptionSection());
		 
		 Thread.sleep(5000);
		
		//EDIT BUTTON UNDER DESCRIPTION SECTION   
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
					driver.findElement(By.xpath("//*[@id=\"descriptionAddEdit\"]")));
		 
		 Thread.sleep(3000);
		//REMOVE BUTTON UNDER DESCRIPTION SECTION 
		  loginpage.ExplicitWait(profilepage.RemoveButtonUnderDescriptionSection()); 
		
		  Thread.sleep(3000);
		 //YES BUTTON AFTER CLICKING ON REMOVE BUTTON 
		  loginpage.ExplicitWait(profilepage.YesButtonappearsafterclickingonRemoveUnderDescriptionSection());
		  
		
		 Thread.sleep(3000);
		 //CLOSE THE CHAT BOT 
		bot= new Closethebot();
	  	bot.Closing_the_bot();
		//ADD BUTTON UNDER DESCRIPTION 
		  ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
					driver.findElement(By.xpath("//*[@id=\"descriptionAddEdit\"]")));
		  
		  
		 Thread.sleep(3000);
		//ENTER IN TEXT FIELD UNDER DESCRIPTION SECTION   
		
	
		 driver.findElement(By.xpath("//*[@id=\"txtdescription\"]")).sendKeys("Hello");
		 
		 
		 Thread.sleep(3000);
		//SAVE BUTTON UNDER DESCRIPTION POPUP 
	//	 loginpage.ExplicitWait(profilepage.SaveButtonUnderDescriptionSection());
		
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
					driver.findElement(By.xpath("//*[@id=\"btn-description\"]")));
		 
		 
		 Thread.sleep(2000);
		//SUCESS MESSAGE AFTER USER IS ABLE TO SAVE DESCRIPTION 
		 String valdmsg1 = driver.findElement(By.className("message")).getText();
		 System.out.println(valdmsg1);
		 Assert.assertEquals("SUCCESS MESSAGE NOT APEEARS","Description added successfully",valdmsg1);     
		  
	}
    
     
	@Test(priority=43)
	public void UserIsAbleToRemoveAddedDescription_OnClickingRemoveButtonUnderDescriptionPopup() throws InterruptedException{
		  
         Thread.sleep(3000);
         //CLOSE THE CHAT BOT 
		bot= new Closethebot();
	  	bot.Closing_the_bot();
		//EDIT BUTTON UNDER DESCRIPTION SECTION   
		  loginpage.ExplicitWait(profilepage.EditButtonUnderDescriptionSection());
		 Thread.sleep(3000);
		 
		//CLEAR TEXT FIELD UNDER DESCRIPTION SECTION  
		 loginpage.ExplicitWaitClear(profilepage.TextFieldUnderDescriptionSection());
		 
		 Thread.sleep(3000);
		//ENTER IN TEXT FIELD UNDER DESCRIPTION SECTION   
		 loginpage.ExplicitWaitSendKeys(profilepage.TextFieldUnderDescriptionSection(),"Hello");
		
		 Thread.sleep(3000);
		 //SAVE BUTTON UNDER DESCRIPTION POPUP 
		 loginpage.ExplicitWait(profilepage.SaveButtonUnderDescriptionSection());
		 
		 Thread.sleep(5000);
		
		//EDIT BUTTON UNDER DESCRIPTION SECTION   
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click()",
					driver.findElement(By.xpath("//*[@id=\"descriptionAddEdit\"]")));
		 
		 Thread.sleep(3000);
		//REMOVE BUTTON UNDER DESCRIPTION SECTION 
		  loginpage.ExplicitWait(profilepage.RemoveButtonUnderDescriptionSection()); 
		
		  Thread.sleep(3000);
		 //YES BUTTON AFTER CLICKING ON REMOVE BUTTON 
		  loginpage.ExplicitWait(profilepage.YesButtonappearsafterclickingonRemoveUnderDescriptionSection());
		  
		  Thread.sleep(1000);
		//SUCESS MESSAGE AFTER USER IS ABLE TO REMOVE DESCRIPTION 
	//	  String valdmsg1 = driver.findElement(By.className("message")).getText();
		//  System.out.println(valdmsg1);
	//	  Assert.assertEquals("SUCCESS MESSAGE NOT APEEARS","Description clear successfully",valdmsg1);    
		  
		  
	}
     
    
	@Test(priority=44)
	public void AddEducationTrainingInformationPopupOpensUp_OnClickingAddButtonUnderEducationAndTrainingSection() throws InterruptedException{
		
		Thread.sleep(3000);
		//CLOSE THE CHAT BOT 
		bot= new Closethebot();
	  	bot.Closing_the_bot();
		//ADD BUTTON UNDER EDUCATION AND TRANING SECTION 
		loginpage.ExplicitWait(profilepage.AddButtonUnderEducationAndTrainingSection());
		
		 Thread.sleep(4000);
		//EDUCATION AND TRANING POPUP OPENS UP  
		 String PopupTitle = driver.findElement(By.xpath("//h3[text()='Add Education/Training Information']")).getText();
		 System.out.println(PopupTitle);
		 Assert.assertEquals("Add Education/Training Information",PopupTitle);
		
		
	}
    
	@Test(priority=45)
	public void ValidationMsgAppearsOnLeavingInstitutionAttended_TextFieldBlankUnderAddEducationTrainingInformationPopup() throws InterruptedException{
		
		Thread.sleep(3000);
		//CLOSE THE CHAT BOT 
		bot= new Closethebot();
	  	bot.Closing_the_bot();
		//ADD BUTTON UNDER EDUCATION AND TRANING SECTION 
		loginpage.ExplicitWait(profilepage.AddButtonUnderEducationAndTrainingSection());
		
		Thread.sleep(2000);
		//SAVE BUTTON UNDER EDUCATION AND TRANING SECTION 
	    loginpage.ExplicitWait(profilepage.SaveButtonUnderAddEducationTraningInforationSection());
		
	    Thread.sleep(1000);
	  //VALIDATION MESSAGE Appears_OnLeavingDescriptionTextField_Blank
	//	 String valdmsg1 = driver.findElement(By.className("message")).getText();
	//	 System.out.println(valdmsg1);
	//	 Assert.assertEquals("VALIDATION MESSAGE NOT APEEARS","Please enter Institution Attended.",valdmsg1); 
	    
	}
    
	@Test(priority=46)
	public void SelectAutopopulatedInstitutionsNamesAfterEntering_CharInInstitutionAttendedTextfieldUnderAddEducationTrainingInfoPopup() throws InterruptedException{
		
		//ADD BUTTON UNDER EDUCATION AND TRANING SECTION 
		Thread.sleep(3000); 
		//CLOSE THE CHAT BOT 
		bot= new Closethebot();
	  	bot.Closing_the_bot();
		loginpage.ExplicitWait(profilepage.AddButtonUnderEducationAndTrainingSection());
		Thread.sleep(3000);
		
		loginpage.ExplicitWait(profilepage.ClickOnInstitutionAttendedTextFieldUnderEducationAndTrainingSection());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(profilepage.EnterCharacterinInstitutionAttendedSearchFieldUnderEducationAndTrainingSection(),"J&K University");
		Thread.sleep(3000);
  	    String AppearedName=loginpage.ExplicitWaitGetText(profilepage.ClickOnAppearedNameinInstitutionAttendedSearchFieldUnderEducationAndTrainingSection());
  	    System.out.println(AppearedName);
		Assert.assertEquals("J&K University",AppearedName);
		
	}
	

	@Test(priority=47)
	public void UserIsAbleToSaveEducationAndTrainingDetailsOnClicking_SaveButtonUnderAddEducationTrainingInformationPopup() throws InterruptedException{
		
		Thread.sleep(3000);
		//ADD BUTTON UNDER EDUCATION AND TRANING SECTION    
		//CLOSE THE CHAT BOT 
		bot= new Closethebot();
	  	bot.Closing_the_bot();
		loginpage.ExplicitWait(profilepage.AddButtonUnderEducationAndTrainingSection());
		Thread.sleep(3000);
		
		loginpage.ExplicitWait(profilepage.ClickOnInstitutionAttendedTextFieldUnderEducationAndTrainingSection());
		Thread.sleep(2000);
		loginpage.ExplicitWaitSendKeys(profilepage.EnterCharacterinInstitutionAttendedSearchFieldUnderEducationAndTrainingSection(),"J");
		Thread.sleep(2000);
		loginpage.ExplicitWait(profilepage.ClickOnAppearedNameinInstitutionAttendedSearchFieldUnderEducationAndTrainingSection());
		Thread.sleep(2000);
		//SAVE BUTTON UNDER EDUCATION AND TRANING SECTION 
	    loginpage.ExplicitWait(profilepage.SaveButtonUnderAddEducationTraningInforationSection());
		
	     Thread.sleep(1000);
	   //SUCCESS MESSAGE 
	//	 String valdmsg1 = driver.findElement(By.className("message")).getText();
	//	 System.out.println(valdmsg1);
	//	 Assert.assertEquals("SUCCESS MESSAGE NOT APEEARS","Education and Training added successfully.",valdmsg1); 
	    	
	}
    
	@Test(priority=48)
	public void EditEducationTrainingInformationPopupOpensUp_OnClickingEditIconUnderEducationAndTrainingSection() throws InterruptedException{
		  
		 Thread.sleep(3000);
		 //EDIT ICON UNDER ADDED EDUCATION AND TRANING SECTION 
		   //CLOSE THE CHAT BOT 
		bot= new Closethebot();
	  	bot.Closing_the_bot(); 
		 loginpage.ExplicitWait(profilepage.AddedNameUnderAddEducationTraningInforationSection());
		 
		  Thread.sleep(3000);
		//Edit Education/Training Information  
		 String PopupTitle = driver.findElement(By.xpath("//h3[text()='Edit Education/Training Information']")).getText();
		 System.out.println(PopupTitle);
		 Assert.assertEquals("Edit Education/Training Information",PopupTitle);
		
	}
    
	
	@Test(priority=49)
	public void ConfirmationMsgAppearsOnClickingRemoveButton_UnderEditEducationTrainingInformationPopup() throws InterruptedException{
		
		Thread.sleep(3000);
		//EDIT ICON UNDER ADDED EDUCATION AND TRANING SECTION   
		 //CLOSE THE CHAT BOT 
		bot= new Closethebot();
	  	bot.Closing_the_bot();
		loginpage.ExplicitWait(profilepage.AddedNameUnderAddEducationTraningInforationSection());
		
		Thread.sleep(3000);
	    
		//REMOVE BUTTON UNDER UNDER ADDED EDUCATION AND TRANING SECTION  
	   loginpage.ExplicitWait(profilepage.RemoveButtonUnderEditEducationTraningInforationSectionPopup());
 		
 	   Thread.sleep(3000);
 	   //CONFIRMATION MESSAGE
 	    String Confmsg = driver.findElement(By.xpath("//p[text()='Are you sure you want to remove?']")).getText();
		System.out.println(Confmsg);
	    Assert.assertEquals("Are you sure you want to remove?",Confmsg);
		
 	   
	}
    
	
	@Test(priority=50)
	public void RemoveTheAddedEducationAndTrainingDetailOnClicking_RemoveButtonUnderEditEducationTrainingInformationPopup() throws InterruptedException{
		
		Thread.sleep(3000);
		//EDIT ICON UNDER ADDED EDUCATION AND TRANING SECTION  
		 //CLOSE THE CHAT BOT 
		bot= new Closethebot();
	  	bot.Closing_the_bot();
		loginpage.ExplicitWait(profilepage.AddedNameUnderAddEducationTraningInforationSection());
		
		Thread.sleep(3000);
	    
		//REMOVE BUTTON UNDER UNDER ADDED EDUCATION AND TRANING SECTION  
	  	loginpage.ExplicitWait(profilepage.RemoveButtonUnderEditEducationTraningInforationSectionPopup());
	
		
 	    Thread.sleep(3000);
 	   
		//YES BUTTON APPEARS AFTERS REMOVE BUTTON UNDER UNDER ADDED EDUCATION AND TRANING SECTION   
 	    WebElement click1 = driver.findElement(By.cssSelector("#btnyes")); 
 	    loginpage.ExplicitWait(click1);
	     
	     Thread.sleep(1000);
	    //SUCCESS MESSAGE APPEARS
	//	 String succmsg = driver.findElement(By.className("message")).getText();
	//	 System.out.println(succmsg);
	//	 Assert.assertEquals("SUCCESS MESSAGE NOT APEEARS","Education and Training removed successfully.",succmsg);  
		
	}
   
   
	@Test(priority=51)
	public void UpdateEducationAndTrainingDetailsOnClicking_SaveButtonUnderEditEducationTrainingInformationPopup() throws InterruptedException{
		
		
		Thread.sleep(3000);
		//EDIT ICON UNDER ADDED EDUCATION AND TRANING SECTION  
		 //CLOSE THE CHAT BOT 
		bot= new Closethebot();
	  	bot.Closing_the_bot();
		loginpage.ExplicitWait(profilepage.AddedNameUnderAddEducationTraningInforationSection());
		
		Thread.sleep(3000);
		
		//SAVE BUTTON UNDER ADDED EDUCATION AND TRANING SECTION
		WebElement click = driver.findElement(By.cssSelector("#btn-saveEducation")); 
		loginpage.ExplicitWait(click);
		  
		Thread.sleep(1000);
		//SUCCESS MESSAGE APPEARS
		// String succmsg = driver.findElement(By.className("message")).getText();
	//	 System.out.println(succmsg);
	//	 Assert.assertEquals("SUCCESS MESSAGE NOT APEEARS","Education and Training updated successfully",succmsg);  
		
				
	}
    
    
}
	
	


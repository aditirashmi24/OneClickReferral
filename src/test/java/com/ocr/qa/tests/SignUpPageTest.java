package com.ocr.qa.tests;


import java.awt.Robot;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.base.TestBase;
import com.ocr.qa.bot.Closethebot;
import com.ocr.qa.pages.Loginpage;
import com.ocr.qa.pages.SelectWhoAreYou;
import com.ocr.qa.pages.SignUpPage;

import junit.framework.Assert;


public class SignUpPageTest extends TestBase{

	Loginpage loginpage= new Loginpage();
	SelectWhoAreYou Swatpage;
	SignUpPage Signuppage ;
	Closethebot bot= new Closethebot();
    
	Screen screen = new Screen();

	//CREATE A CONSTRUCTOR
	public SignUpPageTest(){

	super();

	}


	//CREATE SETUP METHOD
	@BeforeMethod
	public void SignUpPage_SetupMethod() throws Exception{

	System.out.println("abnks");

	initialization();
	Swatpage = new SelectWhoAreYou();
	Signuppage = new SignUpPage();
	Signuppage = Swatpage.Signupbtn();
	  Thread.sleep(7000);
	   
	  String parenthandler= driver.getWindowHandle();

	   Set<String>allwindowhandles = driver.getWindowHandles();
	 
	   for(String currenthandle :allwindowhandles){
	 
	   System.out.println("Current window handle is"+currenthandle);
	   if(!currenthandle.equalsIgnoreCase(parenthandler)){
	 
	   driver.switchTo().window(currenthandle);
	    Thread.sleep(3000);
	 
	   }  
	   }
	 
	 
	}
     
	//CREATE QUIT METHOD
	 @AfterMethod
	 public void TestCase_QuitMethod(){

	driver.quit();

	 }


       

	  //VALIDATE LOGIN-PAGE TITLE
	   @Test(priority=1)
	   public void SignUpPageOpensUp_OnClickingSIGNUPlink() throws InterruptedException{
	   Thread.sleep(10000);

	   String Pagetitle = driver.getTitle();
	   System.out.println("Title of child window is"+driver.getTitle());
	   Assert.assertEquals("TITLE MISMATCH","Sign Up",Pagetitle);
	 

	   }

	    @Test(priority=2)
	    public void OCRLogoAppears_OnSignUpPage(){
	   
	    Boolean img = Signuppage.validatepageimglogo() ;
	    Assert.assertTrue(img);
	   
	   
	    }
	         
	         
	    @Test(priority=3)
	    public void ValidationMessageAppearsOnLeaving_MandatoryFieldsBlankUnderSignUpPage() throws InterruptedException{
	         
	    Thread.sleep(2000);
	    //CLOSE THE CHAT BOT
	   bot= new Closethebot();
	   bot.Closing_the_bot();
	   Thread.sleep(1000);
	    JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,500)");
	    Signuppage.NextButton();
	   
	    Thread.sleep(2000);
	   
	       String ValdFirstName =  loginpage.ExplicitWaitGetText(Signuppage.valdmsgfirstname());
	     //VALIDATION MSG ON FIRST NAME TEXTFIELD
	       Assert.assertEquals("VALIDATION MESSAGE NOT APPEARS","First Name is required.",ValdFirstName);    
	       Thread.sleep(1000);
	         
	       String ValdLastName =  loginpage.ExplicitWaitGetText(Signuppage.valdmsglastname());
	       //VALIDATION MSG ON LAST NAME TEXTFIELD
	        Assert.assertEquals("VALIDATION MESSAGE NOT APPEARS","Last Name is required.",ValdLastName);    
	        Thread.sleep(1000);
	   
	       String valdmsgworkphone =  loginpage.ExplicitWaitGetText(Signuppage.valdmsgworkphone());
	        //VALIDATION MSG ON WORK PHONE TEXTFIELD
	        Assert.assertEquals("VALIDATION MESSAGE NOT APPEARS","Work Phone is required.",valdmsgworkphone);    
	        Thread.sleep(1000);
	   
	      String  valdmsgemail =  loginpage.ExplicitWaitGetText(Signuppage.valdmsgemail());
	    //VALIDATION MSG ON EMAIL TEXTFIELD
	        Assert.assertEquals("VALIDATION MESSAGE NOT APPEARS","Email is required.",valdmsgemail);    
	        Thread.sleep(1000);
	   
	     String  valdmsgpassword =  loginpage.ExplicitWaitGetText(Signuppage.valdmsgpassword());
	   //VALIDATION MSG ON PASSWORD TEXTFIELD
	        Assert.assertEquals("VALIDATION MESSAGE NOT APPEARS","Password is required.",valdmsgpassword);    
	        Thread.sleep(1000);
	   
	    }
	         
	   
	    @Test(priority=4)
	    public void ValidationMessageAppearsOnEnteringLess_Than10DigitInWorkPhoneMandatoryFieldsBlankUnderSignUpPage() throws InterruptedException{
	   
	         Thread.sleep(2000);
	         loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(), "12345678");
	         Thread.sleep(2000);
	         Signuppage.NextButton();
	         Thread.sleep(1000);
	         String valdmsgworkphone =  loginpage.ExplicitWaitGetText( Signuppage.valdmsgworkphone());
	     //VALIDATION MSG ON WORK PHONE TEXTFIELD
	      Assert.assertEquals("VALIDATION MESSAGE NOT APPEARS","Enter a valid Work Phone.",valdmsgworkphone);    


	    }
	         
	    @Test(priority=5)
	    public void ValidationMessageAppearsOnEnteringMore_Than10DigitInWorkPhoneMandatoryFieldsBlankUnderSignUpPage() throws InterruptedException {
	       
	         Thread.sleep(2000);
	         loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(), "12345678912");
	         Thread.sleep(2000);
	         Signuppage.NextButton();
	         Thread.sleep(1000);
	         String valdmsgworkphone =  loginpage.ExplicitWaitGetText( Signuppage.valdmsgworkphone());
	   //VALIDATION MSG ON WORK PHONE TEXTFIELD
	         Assert.assertEquals("VALIDATION MESSAGE NOT APPEARES","Enter a valid Work Phone.",valdmsgworkphone);  
	   
	    }
	   
	   
	    @Test(priority=6)
	    public void ValidationMessageAppearsOnEntering_InvalidEmailAddressInEmailTextfieldOnSignUpPage() throws InterruptedException{
	   
	         Thread.sleep(2000);
	         loginpage.ExplicitWaitSendKeys(Signuppage.emailtextfield(), "vshmr.com");
	         Thread.sleep(2000);
	         Signuppage.NextButton();
	         JavascriptExecutor js =(JavascriptExecutor)driver;
	         js.executeScript("window.scrollBy(0,500)");
	         Thread.sleep(1000);
	         String  valdmsgemail =  loginpage.ExplicitWaitGetText( Signuppage.valdmsgemail());
	 //VALIDATION MSG ON EMAIL TEXTFIELD
	         Assert.assertEquals("VALIDATION MESSAGE NOT APPEARES","Please enter a valid Email Address.",valdmsgemail);    
	         
	    }
	   
	   
	    @Test(priority=7)
	    public void ValidationMessageAppearsOnEnteringAlready_RegisteredEmailAddressInEmailTextfieldOnSignUpPage() throws InterruptedException{
	   

	    Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.firstnametextfield(),"FirstName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.lastnametextfield(),"LastName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(),"7777712345");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.emailtextfield(),"levin@yopmail.com");
	        JavascriptExecutor js =(JavascriptExecutor)driver;
	        js.executeScript("window.scrollBy(0,200)");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.passwordtextfield(),"Hello@123");
	        Thread.sleep(2000);
	        Signuppage.NextButton();
	        Thread.sleep(2000);
	        String valdmsg = driver.findElement(By.xpath("//p[@id='emailResponse']")).getText();
	      //VALIDATION MSG ON EnteringAlready_RegisteredEmailAddress in EMAIL TEXTFIELD
	        Assert.assertEquals("VALIDATION MESSAGE NOT APPEARES","You are already registered with this email.",valdmsg);  
	       
	   
	    }
	   
	   
	    @Test(priority=8)
	    public void ValidationMessageAppearsIfTheEnteredPassword_InPasswordFieldDoesNotMeetThePasswordCriteriaOnSignUpPage() throws InterruptedException{
	   
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.passwordtextfield(),"1234567");
	        Thread.sleep(2000);
	        JavascriptExecutor js =(JavascriptExecutor)driver;
	        js.executeScript("window.scrollBy(0,500)");
	        Signuppage.NextButton();
	   
	        String  valdmsgpassword =  loginpage.ExplicitWaitGetText( Signuppage.valdmsgpassword());
	//VALIDATION MSG ON PASSWORD TEXTFIELD
	        Assert.assertEquals("VALIDATION MESSAGE NOT APPEARES","Password must be a minimum of 8 characters long and contain an upper and lower case letter, a number, and a symbol.",valdmsgpassword);    

	   
	    }
	   
	   
	    @Test(priority=9)
	    public void VerifyThatSpecialtyPageOpensUp_OnClickingNEXTButtonUnderSignUpPage() throws InterruptedException{
	   
	    Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.firstnametextfield(),"FirstName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.lastnametextfield(),"LastName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(),"7777712345");
	        Thread.sleep(2000);
	        Date date = new Date ();
	        long time =   date.getTime();
	        System.out.println(time);
	        loginpage.ExplicitWaitSendKeys(Signuppage.emailtextfield(),+time+"@yopmail.com");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.passwordtextfield(),"Hello@123");
	        Thread.sleep(2000);
	        Signuppage.NextButton();
	       
	        Thread.sleep(5000);
	        String title = driver.getTitle();
	        Assert.assertEquals("Sign Up",title);
	       
	    }
	   
	   
	    @Test(priority=10)
	    public void VerifyThatUserIsAbleToSelectASpecialty_OnClickingSelectASpecialityDropdownOnSpecialtyPage() throws InterruptedException{
	         
	    Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.firstnametextfield(),"FirstName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.lastnametextfield(),"LastName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(),"7777712345");
	        Thread.sleep(2000);
	        Date date = new Date ();
         	long time =   date.getTime();
        	System.out.println(time);
	        loginpage.ExplicitWaitSendKeys(Signuppage.emailtextfield(),+time+"@yopmail.com");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.passwordtextfield(),"Hello@123");
	        Thread.sleep(2000);
	        Signuppage.NextButton();
	       
	        Thread.sleep(5000);
	        Select sc = new Select(driver.findElement(By.xpath("//select[@class='form-control custom-select ddlSpecialities select2-hidden-accessible' or @id='ddlSpecialities']")));
        	sc.selectByVisibleText("Aesthetic Dentist");  
	       
	        Thread.sleep(5000);
	        String txt = driver.findElement(By.xpath("(//ul//li[@class='select2-selection__choice'])[1]")).getText();
	        System.out.println(txt);
	        Assert.assertEquals("×Aesthetic Dentist",txt);
	   
	   
	    }
	   
	   
	    @Test(priority=11)
	    public void VerifyThatUserIsAbleToSelectAMultipleSpecialty_OnClickingSelectASpecialityDropdownOnSpecialtyPage() throws InterruptedException{
	   
	    Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.firstnametextfield(),"FirstName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.lastnametextfield(),"LastName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(),"7777712345");
	        Thread.sleep(2000);
	        Date date = new Date ();
	        long time =   date.getTime();
	        System.out.println(time);
	        loginpage.ExplicitWaitSendKeys(Signuppage.emailtextfield(),+time+"@yopmail.com");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.passwordtextfield(),"Hello@123");
	        Thread.sleep(2000);
	        Signuppage.NextButton();
	       
	        Thread.sleep(5000);
	        Select sc = new Select(driver.findElement(By.xpath("//select[@class='form-control custom-select ddlSpecialities select2-hidden-accessible' or @id='ddlSpecialities']")));
         	sc.selectByVisibleText("Aesthetic Dentist");  
        	Thread.sleep(2000);
	        sc.selectByVisibleText("Cosmetic Dentist");


         	Thread.sleep(5000);
        	String txt = driver.findElement(By.xpath("(//ul//li[@class='select2-selection__choice'])[1]")).getText();
	        System.out.println(txt);
	        Assert.assertEquals("×Aesthetic Dentist",txt);
	        Thread.sleep(1000);
	        String txt1 = driver.findElement(By.xpath("(//ul//li[@class='select2-selection__choice'])[2]")).getText();
	        System.out.println(txt1);
	        Assert.assertEquals("×Cosmetic Dentist",txt1);
	   
	    }
	    
	     
	    @Test(priority=12)
	    public void ValidationMessageAppearsOnLeavingSelectA_SpecialtyMandatoryFieldBlankUnderSpecialtyPage() throws InterruptedException{
	          
	    	    Thread.sleep(2000);
		        loginpage.ExplicitWaitSendKeys(Signuppage.firstnametextfield(),"FirstName");
		        Thread.sleep(2000);
		        loginpage.ExplicitWaitSendKeys(Signuppage.lastnametextfield(),"LastName");
		        Thread.sleep(2000);
		        loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(),"7777712345");
		        Thread.sleep(2000);
		        Date date = new Date ();
	         	long time =   date.getTime();
		        System.out.println(time);
		        loginpage.ExplicitWaitSendKeys(Signuppage.emailtextfield(),+time+"@yopmail.com");
		        Thread.sleep(2000);
		        loginpage.ExplicitWaitSendKeys(Signuppage.passwordtextfield(),"Hello@123");
		        Thread.sleep(2000);
		        Signuppage.NextButton();
	            Thread.sleep(2000);
	            loginpage.ExplicitWait(Signuppage.Sfinsihbuttton());
	           Thread.sleep(1000);  
	           String Valdmsg =  loginpage.ExplicitWaitGetText(Signuppage.ValdSelectspecialtyTextfield());
	       //VALIDATION MSG ON LeavingSelectA_SpecialtyMandatoryFieldBlank
	           Assert.assertEquals("VALIDATION MESSAGE NOT APPEARS","Select at least one specialty.",Valdmsg);    
	           Thread.sleep(1000);
	    }
	   
	    /*
	    @Test(priority=13)
	    public void ValidationMessageAppearsOnClickingFINISHButtonWithout_CheckingTermsANDConditionsCheckboxMandatoryFieldUnderSpecialtyPage() throws InterruptedException{
	   
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.firstnametextfield(),"FirstName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.lastnametextfield(),"LastName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(),"7777712345");
	        Thread.sleep(2000);
	        Date date = new Date ();
         	long time =   date.getTime();
	        System.out.println(time);
	        loginpage.ExplicitWaitSendKeys(Signuppage.emailtextfield(),+time+"@yopmail.com");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.passwordtextfield(),"Hello@123");
	        Thread.sleep(2000);
	        Signuppage.NextButton();
	       
	        Thread.sleep(5000);
	        Select sc = new Select(driver.findElement(By.xpath("//select[@class='form-control custom-select ddlSpecialities select2-hidden-accessible' or @id='ddlSpecialities']")));
	        sc.selectByVisibleText("Aesthetic Dentist");  
	       
	        Thread.sleep(1000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.PracticeNameTextfield(),"PracticeName");
	     
	         Thread.sleep(2000);
	         loginpage.ExplicitWait(Signuppage.Sfinsihbuttton());
	         Thread.sleep(1000);  
	         String Valdmsg =  loginpage.ExplicitWaitGetText(Signuppage.ValdTermsConditionsCheckbox());
	         
	     //VALIDATION MSG ON Without_CheckingTermsANDConditionsCheckbox
	         Assert.assertEquals("VALIDATION MESSAGE NOT APPEARS","Please accept Terms & Conditions.",Valdmsg);    
	         Thread.sleep(1000);
	   
	   
	    }
	    */
	   
	   
	    @Test(priority=14)
	    public void VerifyThatSignUpPageOpensUpOnClicking_PREVIOUSButtonUnderSpecialtyPage() throws InterruptedException{
	       
	    Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.firstnametextfield(),"FirstName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.lastnametextfield(),"LastName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(),"7777712345");
	        Thread.sleep(2000);
	        Date date = new Date ();
	        long time =   date.getTime();
	        System.out.println(time);
	        loginpage.ExplicitWaitSendKeys(Signuppage.emailtextfield(),+time+"@yopmail.com");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.passwordtextfield(),"Hello@123");
	        Thread.sleep(2000);
	        Signuppage.NextButton();
	        Thread.sleep(5000);
	        loginpage.ExplicitWait(Signuppage.Spreviousbuttton());
	        Thread.sleep(7000);
	         String Pagetitle = driver.getTitle();
	        System.out.println("Title of child window is"+driver.getTitle());
	        Assert.assertEquals("TITLE MISMATCH","Sign Up",Pagetitle);
	   
	   
	    }
	   
	   
	    @Test(priority=15)
	    public void VerifyThatSelectedSpecialtyStillAppears_OnSpecialtyPageAfterClickingNEXTButtonUnderSignUppage() throws InterruptedException{
	   
	    Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.firstnametextfield(),"FirstName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.lastnametextfield(),"LastName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(),"7777712345");
	        Thread.sleep(2000);
	        Date date = new Date ();
	        long time =   date.getTime();
	        System.out.println(time);
	        loginpage.ExplicitWaitSendKeys(Signuppage.emailtextfield(),+time+"@yopmail.com");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.passwordtextfield(),"Hello@123");
	        Thread.sleep(2000);
	        Signuppage.NextButton();
	       
	        Thread.sleep(5000);
	        Select sc = new Select(driver.findElement(By.xpath("//select[@class='form-control custom-select ddlSpecialities select2-hidden-accessible' or @id='ddlSpecialities']")));
	        sc.selectByVisibleText("Aesthetic Dentist");  
	       
	        Thread.sleep(5000);

	        loginpage.ExplicitWait(Signuppage.Spreviousbuttton());
	        Thread.sleep(5000);
	        Signuppage.NextButton();
	        Thread.sleep(3000);
	        String txt = driver.findElement(By.xpath("(//ul//li[@class='select2-selection__choice'])[1]")).getText();
	        System.out.println(txt);
	        Assert.assertEquals("×Aesthetic Dentist",txt);

	   
	    }
	   
	   
	    @Test(priority=16)
	    public void VerifyThatUserIsAbleToEnterPractice_NameInPracticeNameTextfieldOnSpecialtyPage() throws Exception{
	   
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.firstnametextfield(),"FirstName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.lastnametextfield(),"LastName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(),"7777712345");
	        Thread.sleep(2000);
	        Date date = new Date ();
	        long time =   date.getTime();
	        System.out.println(time);
	        loginpage.ExplicitWaitSendKeys(Signuppage.emailtextfield(),+time+"@yopmail.com");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.passwordtextfield(),"Hello@123");
	        Thread.sleep(2000);
	        Signuppage.NextButton();
	       
	        Thread.sleep(5000);
	        Select sc = new Select(driver.findElement(By.xpath("//select[@class='form-control custom-select ddlSpecialities select2-hidden-accessible' or @id='ddlSpecialities']")));
	        sc.selectByVisibleText("Aesthetic Dentist");  
	       
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.PracticeNameTextfield(), "TestPracticeName");
	        Thread.sleep(2000);
	    //    loginpage.ExplicitWait(Signuppage.Sfinsihbuttton());
	        driver.findElement(By.xpath("//div//p[@class='ml-2']")).click();
	       Thread.sleep(3000);
        // 	String Pname = Signuppage.PracticeNameTextfield().getText(); 
	       
	    //    Pattern patt = new Pattern("D:\\Vivek_Workspace\\OncClickReferral\\ImgDirectory\\PracticeName.jpg"); 
	       loginpage.ExplicitWait(Signuppage.PracticeNameTextfield());
	       
	      
	      driver.findElement(By.xpath("//div//input[@type='text' and @id='txtPracticeName']")).sendKeys(Keys.CONTROL,"a");
	      Thread.sleep(12000);
	      driver.findElement(By.xpath("//div//input[@type='text' and @id='txtPracticeName']")).sendKeys(Keys.CONTROL,"c");
	      

	        String str=(String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
	        Thread.sleep(2000);
	        Assert.assertEquals("TestPracticeName",str);

	        System.out.println("Copied content is :"+str);
	        screen.type(str);
	        
	        
	        
	    }
	   
	   
	    @Test(priority=17)
	    public void VerifyThatUserIsAbleToSubmitSignUp_DetailsOnClickingFINISHButtonUnderSpecialtyPage() throws InterruptedException{
	   
	       Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.firstnametextfield(),"FirstName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.lastnametextfield(),"LastName");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.workphonetextfield(),"7777712345");
	        Thread.sleep(2000);
	        Date date = new Date ();
	        long time =   date.getTime();
	        System.out.println(time);
	        loginpage.ExplicitWaitSendKeys(Signuppage.emailtextfield(),+time+"@yopmail.com");
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.passwordtextfield(),"Hello@123");
	        Thread.sleep(2000);
	        Signuppage.NextButton();
	       
	        Thread.sleep(5000);
	        Select sc = new Select(driver.findElement(By.xpath("//select[@class='form-control custom-select ddlSpecialities select2-hidden-accessible' or @id='ddlSpecialities']")));
	        sc.selectByVisibleText("Aesthetic Dentist");  
	       
	        Thread.sleep(2000);
	        loginpage.ExplicitWaitSendKeys(Signuppage.PracticeNameTextfield(), "PracticeName");
	        Thread.sleep(2000);
	 
	         loginpage.ExplicitWait(Signuppage.Sfinsihbuttton());
	       
	        Thread.sleep(1000);
	        String Pagetitle = driver.getTitle();
	        System.out.println("Title"+driver.getTitle());
	        Assert.assertEquals("TITLE MISMATCH","Sign Up",Pagetitle);
	   
	    }
	     
	     
	     
	 

	}

package com.ocr.qa.tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ocr.qa.base.TestBase;
import com.ocr.qa.pages.SelectWhoAreYou;
import junit.framework.Assert;

public class SelectWhoAreYouPageTest extends TestBase {
	SelectWhoAreYou Swaytpage ;

	//CREATE CONSTRUCTOR 
	public SelectWhoAreYouPageTest(){   

		super();  

	} 

	//TESE CASES SHOULD BE INDEPENDENT OR SEPERATED WITH EACH OTHER 

	//CREATE SETUP METHOD AND CALL INITIALIZATION METHOD
	@BeforeMethod
	public  void SelectWhoAreYouPage_SetupMethod() throws InterruptedException {
		Thread.sleep(2000);  
		initialization();

		Swaytpage = new SelectWhoAreYou() ;  
	}

	//CREATE QUIT METHOD
	@AfterMethod 
	public void TestCase_QuitMethod(){

		driver.quit();

	} 

	//VALIDATE PAGE TITLE
	@Test(priority=1)
	public void SelectWhoYouAre_PageOpensUpOnOpenningURL(){

		String title =  Swaytpage.validateselectwhoPageTitle();
		Assert.assertEquals(title, "Select Who You Are" ); 


	}

	//VALIDATE PAGE LOGO-IMAGE
	@Test(priority=2) 
	public void OneClickReferral_ImageLogoAppersOnSelectWhoYouArePage(){

		Boolean img = Swaytpage.validatepageimglogo() ; 
		Assert.assertTrue(img); 
	}

	//VALIDATE INVALID-DENTIST DETAILS
	@Test(priority=3)
	public void CorrectInformationMessageAppears_OnEnteringNonExistingDetailsInSearchField() throws InterruptedException{

		Swaytpage.invaliddentist(prop.getProperty("inv")); 
		String mess = Swaytpage.validateinvalid();
		System.out.println("Information Message Appears as:---"+mess);
		Assert.assertEquals(mess, "If you don't find your profile CLICK HERE");
	}

	//VALIDATE VALID-DENTIST DETAILS 
	@Test(priority=4)
	public void DentistNameAppears_OnEnteringExistingDetailsInSearchField() throws InterruptedException{

		Swaytpage.validentist(prop.getProperty("Fullname")); 
		// Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String vd = Swaytpage.validatevalid(); 
		System.out.println(vd);
		Assert.assertEquals(vd, prop.getProperty("Fullname"));
	} 

	//VALIDATE AFTER CLICKING ON SIGNUP LINK TAB OCR PAGE OPENS UP
	@Test(priority=5)
	public void PricingOneClickSignUpPage_OpensUpOnClickingSignUplink() throws InterruptedException{

		Swaytpage.signuplinktab();
		Thread.sleep(5000); 

		String parenthandler= driver.getWindowHandle();

		Set<String>allwindowhandles = driver.getWindowHandles();

		for(String currenthandle :allwindowhandles){

			System.out.println("Current window handle is"+currenthandle);
			if(!currenthandle.equalsIgnoreCase(parenthandler)){

				driver.switchTo().window(currenthandle); 
				String Pagetitle = driver.getTitle();
				System.out.println("Title of child window is"+driver.getTitle()); 
				Assert.assertEquals("TITLE MISMATCH","Sign Up",Pagetitle);

				driver.close();
			}  
		}	 

	} 

	@Test(priority=6) 
	public void LoginPageOpensUp_OnClickingLoginlink() throws InterruptedException{

		Swaytpage.loginbtnn();

		String pagetitle = driver.getTitle();
		System.out.println("Title of Login page is"+driver.getTitle()); 
		Assert.assertEquals("TITLE MISMATCH","Login",pagetitle);

	}






}

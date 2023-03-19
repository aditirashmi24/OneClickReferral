package com.ocr.qa.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;

import junit.framework.Assert;

public class Referralspage extends TestBase {

	//*************Page-Factory****************
	
	//Page All Elements
	
	//PATIENT NAME APPEARS ON THE TOP OF THE PAGE
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Aaron Soufer')])[1]")
	@CacheLookup 
	WebElement patientnameontop ; 
	
	//MESSAGE APPEARS ON THE TOP OF THE PAGE 
//	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Referral sent to Yen Wang')])[1]")
	//@FindBy(how=How.XPATH,using="/html/body/div[1]/div/main/div[2]/div/div/div/form/div/div/table/tbody/tr[1]/td[4]/a")
	@FindBy(how=How.XPATH,using="(//td[@data-th='Message'])[1]")
	@CacheLookup
	WebElement messageontop;
	
	//DATE APPEARS ON THE TOP OF THE PAGE 
	@FindBy(how=How.XPATH,using="(//td[contains(@data-th,'Date')])[1]")
	@CacheLookup
	WebElement dateontop;
	
	//REFERRED BY/TO APPEARS ON THE TOP OF THE PAGE 
	@FindBy(how=How.XPATH,using="(//td[contains(@data-th,'Referred By')])[1]")
	@CacheLookup
	WebElement referredby_to;
	
	
	//CLICK ON COLLEAGUE NAME ON THE TOP OF THE PAGE 
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/main/div[2]/div/div/div/form/div/div/table/tbody/tr[1]/td[3]/a")
	@CacheLookup
	WebElement colleagueName;
	
	
	//DROP DOWN ON SETTING LOGOUT EDITPROFILE PAGE 
	@FindBy(how=How.XPATH,using="//i[@class='icon-down_arrow_top']")
	@CacheLookup 
	WebElement dropdown;
	
	//LOGOUT BUTTON UNDER DROPDOWN 
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logoutbtn;
	
   //YES BUTTON ON CONFIRMATION MESSAGE APPEARS ON CLICKING ARCHIVE OPTION
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Yes')]")
	@CacheLookup
	WebElement yesbtn;
	
	//INITIALIZE ALL OBJECTS------------------------------ 
	public Referralspage(){
		
		PageFactory.initElements(driver,this);
		
	}
	
   //ACTIONS----------------------------------------------	
	
	//PATIENT NAME APPEARS ON TOP OF THE PAGE 
	
	public WebElement PatientNameOnTop(){
		
		//patientnameontop.getText()
		return patientnameontop;
		
	}
	
	//MESSAGE APPEARS ON THE TOP OF THE PAGE 
	
	public WebElement MessageAppearsOnTop(){
		
		
		return messageontop;
		
	
	}
	
	//CLICK ON PATIENT NAME APPEARS ON THE TOP OF THE PAGE 
	
	public WebElement ClickOnPatientNameOnTop(){
	
	WebElement click  =	driver.findElement(By.xpath("/html/body/div[1]/div/main/div[2]/div/div/div/form/div/div/table/tbody/tr[1]/td[2]/a[1]"));
		return click;
		
	}
	
	//CLICK ON COLLEAGUE NAME ON THHE TOP OF THE PAGE 
	
	public WebElement ClickOnColleagueNameOnTop(){
		
		return colleagueName;
	}
	
	//DROP DOWN ARROW FOR LOGOUT/SETTINGS/EDITPROFILE
	
   public WebElement DropDownArrowForLogoutSettingsEditProfile(){
	    
	  return dropdown;
	   
   }
	
   //LOGOUT BUTTON UNDER DROP DOWN 
   
   public WebElement LogoutButtonUnderDropdown(){
	   
	//   logoutbtn.click(); 
	   return logoutbtn ;
	   
   }
	
   //SELECT CORDINATOR 
   
   public void SelectCordinator() throws InterruptedException {
	   
	/*   Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control height34 ']")));
	   drop.selectByVisibleText("Patel Rahul");
	   Thread.sleep(3000);  */
	   Select drop1 = new Select(driver.findElement(By.xpath("//select[@class='form-control height34 ']")));
	   drop1.selectByVisibleText("jerry tom");
	   
	  
	
   }
	
   //SELECT DISPOSITION STATUS
   
   public void SelectDispositionStatus() throws InterruptedException {
	   
	   
	   
	   Select drop2 = new Select(driver.findElement(By.xpath("//select[@class='form-control height34 isDisable']")));
	   drop2.selectByVisibleText("No Status Given");	
		
		Thread.sleep(3000); 
	   
	   Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control height34 isDisable']")));
	   drop.selectByVisibleText("Scheduled");
	  
   }
    
   //CRITICAL DISPOSITION STATUS 
   
   public void SelectCriticalDispositionsStatus() throws InterruptedException{
	   
	   Select drop2 = new Select(driver.findElement(By.xpath("//select[@class='form-control height34 isDisable']")));
	   drop2.selectByVisibleText("Scheduled");	
		
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//i[@class='ico-save']")).click();
	   
	   Thread.sleep(20000); 
	   
	   Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control height34 isDisable']")));
	   drop.selectByVisibleText("Cancelled");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//i[@class='ico-save']")).click();

   }
   
  
   //SAVE BUTTON UNDER DISPOSITION STATUS 
   
   public WebElement SaveButtonUnderDispositionsPopup(){
	   
	  WebElement click = driver.findElement(By.xpath("//i[@class='ico-save']")); 
	  return click;
	   
   }
   
   
   //
   public void verifyDentistRecivemail() throws InterruptedException{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.get("http://www.yopmail.com/");
		
		
		WebElement Searchfield = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login"))); 
		Searchfield.click();
		
		Searchfield.clear();
		Thread.sleep(2000);
		Searchfield.sendKeys(prop.getProperty("EmailIdOfPatient")); 
		

		WebElement Checkinboxbutton = wait.until(ExpectedConditions.elementToBeClickable(By.className("sbut")));
		Checkinboxbutton.click();
		Thread.sleep(5000);
		

	}
   
   // REPLY OPTION UNDER ACTION SELECT SECTION DROPDOWN 
   
   public void ReplyOptionUnderSelectActionDropdown(){
	   
	   Select optn = new Select(driver.findElement(By.xpath("(//select[@class='form-control height34'])[2]"))); 
	    //   optn.selectByVisibleText("Reply");
	   optn.selectByValue("1");
	   
   }
   
  // ARCHIVE OPTION UNDER ACTION SELECT SECTION DROPDOWN 
   
   public void ArchiveOptionInSelectActionDropDownOnSendReferralPage(){
	   
	   
	   Select ArcOptn = new Select(driver.findElement(By.xpath("(//div//select[@class='form-control height34'])[2]")));
	   ArcOptn.selectByVisibleText("Archive");
	   
	   
   }
   
  //VALIDATE CONFIRMATION MESSAGE APPEARS ON CLICKING ARCHIVE OPTION   
   
   public WebElement ValidateConfirmationMessageAppearsOnClickingArchiveOption() {
	   
	   //driver.findElement(By.xpath("//p[@id='desc_message']")).getText();
	   return driver.findElement(By.xpath("//div//p[@id='desc_message']"));
	   
   }
   
   //YES BUTTON ON CONFIRMATION MESSAGE APPEARS ON CLICKING ARCHIVE OPTION
   
   public WebElement YesButtonUnderConfirmationMessage (){
	   
	 //  yesbtn.click();
	   return yesbtn;
   }
   
   //DOWNLOAD OPTION UNDER ACTION 
   
   public void DownloadOptionInSelectActionDropDownOnSendReferralPage() throws InterruptedException {
	   
	   Select ArcOptn = new Select(driver.findElement(By.xpath("(//select[@class='form-control height34'])[2]"))); 
       ArcOptn.selectByVisibleText("Download");
	   
   }
   
   //RETURN LATEST DOWNLOADED FILE
   
   public File getLatestFilefromDir(String dirpath){
		
		File dir = new File(dirpath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
		
		

	}
   
   //ADD PATIENT ON REFERRAL APGE 
   
   public void AddpatientOnSendRefferalsPage() throws InterruptedException{
	   
	   //FirstNameOfPatient  
	   driver.findElement(By.cssSelector("#txtFirstName")).sendKeys("Mark");
	   Thread.sleep(3000);
	   
	   //PhoneNumberOfPatient
	   driver.findElement(By.cssSelector("#phone")).sendKeys("1111111111");
	   Thread.sleep(3000); 
	   JavascriptExecutor js =(JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,300)");  
	   
	    Thread.sleep(2000);
	   //SelectGender 
	//   driver.findElement(By.xpath("//select[@class='select_item' and @id='Gender']"));
	   
	   Select Gend = new Select(driver.findElement(By.xpath("//select[@class='select_item' and @id='Gender']")));
	   Gend.selectByVisibleText("Male");  
	   
	   
   }
   
   
   
   
   
   
   
   
   
	
}

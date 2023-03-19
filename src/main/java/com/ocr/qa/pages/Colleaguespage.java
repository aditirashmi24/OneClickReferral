package com.ocr.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;

public class Colleaguespage extends TestBase {

	
	String nam = "Name";
	
	//VERIFY COLLEAGUES PAGE OPEN UP 
	@FindBy(how=How.XPATH,using="//th[contains(text(),'Profile Info')]")
	@CacheLookup 
	WebElement profileinfo;
	
	
	//COLLEAGUES IMAGE ICON 
	//@FindBy(how=How.CSS,using="#row_680 > td.infouser > span.user > a > img")
	@FindBy(how=How.CSS,using=".user > a:nth-child(1) > img:nth-child(1)")
	@CacheLookup 
	WebElement collimgicon;
	
	//COLLEAGUES PROFILE SUBTAB TITLE
	@FindBy(how=How.XPATH,using="//div//h1[@class='inline']")
	@CacheLookup 
	WebElement collprofiletitle;
	
	//SELECT ACTIONS  
 //	@FindBy(how=How.CSS,using="#ddlAction_680")
//	@CacheLookup 
//	WebElement Selectaactions;
	
	//SELECT ACTION DROPDOWN
	
	@FindBy(how=How.XPATH,using="//select[@class='form-control height34']")
	@CacheLookup
	WebElement selectaction;
	
	//SEND REFERRALS PAGE TITLE 
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Send Referral')]")
	@CacheLookup 
	WebElement SendReferralspagetitle;
	
	//CONFIRMATION MESSAGE ON CLICK DELETE BUTTON 
	@FindBy(how=How.XPATH,using="//p[contains(text(),'Are you sure you want to remove?')]")
	@CacheLookup 
	WebElement delconfirmationmessge;
	
	//YES BUTTON 
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Yes')]")
	@CacheLookup 
	WebElement yesbtn;
	
   //SUCCESS MESSAGE AFTER YES BUTTON 
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Colleague removed successfully')]")
	@CacheLookup 
	WebElement successmsgyesbtn;
	
	//SEARCH FIELD ON COLLEAGUES PAGE 
	//@FindBy(how=How.CSS,using="#txtSearchColleagues")
	@FindBy(how=How.XPATH,using="//*[@id=\"txtSearchColleagues\"]")
	@CacheLookup 
	WebElement Searchfieldcolle;
	 
	
	
	//APPEARS COLLEAGUES NAME AFTER SEARCH 
	@FindBy(how=How.CSS,using=".left > a:nth-child(1)")
	@CacheLookup 
	WebElement appearscollname;
	
	//MESSAGE AFTER NON EXISTING COLLLEAGE NAME 
	@FindBy(how=How.XPATH,using="//td[contains(text(),'No record found!')]")
	@CacheLookup 
	WebElement msgsfternonexcoll;
	
	//VERTICAL HEMBURGER ELLISPE BUTTON 
	@FindBy(how=How.CSS,using=".fa-ellipsis-v")
	@CacheLookup 
	WebElement hemburgerbtn;
	
	//ADD COLLEAGES BUTTON 
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Add Colleague')]")
	@CacheLookup 
	WebElement addcolleaguesbtn;
	
	//SEARCH COLLEAGUES PAGE TITLE; 
	@FindBy(how=How.XPATH,using="(//h1[contains(text(),'Search Colleagues')])[2]")
//	@FindBy(how=How.CLASS_NAME,using="inline")
	@CacheLookup 
	WebElement searchcolleagues;
	
	//CLICK ON EXISTING ANY COLLEAGUES NAME 
	@FindBy(how=How.CSS,using="#row_48277 > div.text-box > div.colleague-info > a > p > strong")
	@CacheLookup 
	WebElement existingcolleaguesname;
	
	//NAME SEARCH FIELD ON SEARCH COLLEAGUES PAGE 
	@FindBy(how=How.CSS,using="#txtDoctorName")
	@CacheLookup 
	WebElement namesearchfieled;
	
	//EMAIL SEARCH FIELD ON SEARCH COLLEAGUES PAGE 
	@FindBy(how=How.CSS,using="#txtEmail")
	@CacheLookup 
	WebElement emailsearchfield;
	
	//SUBMIT BUTTON ON SEARCH COLLEAGUES PAGE 
	//@FindBy(how=How.CSS,using="#main > div > div > div > div > div:nth-child(4) > div > div > a.btn.btn-default.btn2")
	@FindBy(how=How.CLASS_NAME,using="icon-search")
	@CacheLookup 
	WebElement searchbtn;
	
	//SUBMIT BUTTON ON SEARCH COLLEAGUES PAGE 
	@FindBy(how=How.CLASS_NAME,using="ico-edit4")
	@CacheLookup  
	WebElement submtbtn;
	
	
	//CANCEL BUTTON ON SEARCH COLLEAGUES PAGE 
	@FindBy(how=How.CSS,using="#main > div > div > div > div > div:nth-child(4) > div > div > a.btn.btn-default.btn1")
	@CacheLookup 
	WebElement cancelbtn;
	
	//AFTER APPEARS COLLEAGUES NAME ON SUBMIT 
	@FindBy(how=How.XPATH,using="//*[@id=\"row_49213\"]/div[2]/div[1]/a/p/strong")
	@CacheLookup 
	WebElement nameapeears;
	
	//ADD COLLEAGUES BUTTON ON APPEAR COLLEAGUE AFTER SEARCH
	@FindBy(how=How.CSS,using="#row_49213 > div.text-box > div.btn-group.btn-holder > a")
	@CacheLookup 
	WebElement addcolleaguebtn;
	
	//SUCCESS MESSAGE AFTER CLICK ON ADD COLLEAGUES BTN 
	//@FindBy(how=How.XPATH,using="//span[contains(text(),'Successfully added as colleague')]")
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement successmsgaddcolleagebtn;
	
	//INVITE BY EMAIL ICON BUTTON 
	@FindBy(how=How.LINK_TEXT,using="Invite by Email")
	@CacheLookup
	WebElement inviatebyemailicon; 
	
	//INVITE COLLEAGE PAGE TITLE 
	@FindBy(how=How.XPATH,using="(//h1[contains(text(),'Invite Colleague')])[2]")
	@CacheLookup 
	WebElement invitecolleaguepagetitle;
	
	//ADD COLLEAGUES BUTTON IN SEARCH COLLEAGUES PAGE 
	@FindBy(how=How.CLASS_NAME,using="add_dentist_icon")
	@CacheLookup 
	WebElement addcollbtninsearchcolleg;
	
	//NO RECORDS FOUND  
	@FindBy(how=How.XPATH,using="//td[contains(text(),'No record found!')]")
	@CacheLookup 
	WebElement Norecordfoundmsg ;
	
	//VALIDATE NAME TEXT IN NAMEFIELD ON SEARCH-COLLEAGUES PAGE 
	@FindBy(how=How.XPATH,using="//input[@placeholder='Name']")
	@CacheLookup 
	WebElement ValidateNametextinfield ;
	
	//VALIDATE NAME TEXT IN NAMEFIELD ON SEARCH-COLLEAGUES PAGE 
	@FindBy(how=How.XPATH,using="//input[@placeholder='Email']")
	@CacheLookup 
	WebElement ValidateEmailtextinfield ;
	
	
//INITIALIZE ALL OBJECTS--------------------  
	
	
	
	public Colleaguespage(){
		
		PageFactory.initElements(driver, this);
			
	}
//*********ACTIONS**********---------------------------------------	
	
	 //COLLEAGUES PAGE TITLE
	public String pagetitle(){
			
		 return	driver.getTitle();
				
	}
	
	//PROFILE INFO TEXT IN COLLEAGUES PAGE
	public WebElement verifycolleaguespage(){
		
		
		return profileinfo;
		
	}
	
	//ANY ADDED COLLEAGUES IMG ICON
	public WebElement anyaddedcolleagues(){
		
	//	collimgicon.click();
		return collimgicon ;
		
	}
	//SEARCH FIELD COLLEAGUES
	public void searchfieldcolleagues() throws InterruptedException  {
		
		Searchfieldcolle.sendKeys(prop.getProperty("Addedcolleagename4"));
		Thread.sleep(3000);
		searchbtn.click();
	}
    
	public void searchfieldcolleagues1() throws InterruptedException{
		
		driver.findElement(By.xpath("//*[@id=\"txtSearchColleagues\"]")).sendKeys(prop.getProperty("Addedcolleagename4"));
		Thread.sleep(2000);
		driver.findElement(By.className("icon-search")).click();
	}
	
	//VALLIDATE ADDED COLLEAGUE NAME 
	public WebElement validateaddedcolleaguename(){
		
	  //	 driver.findElement(By.xpath("//a[contains(text(),'"+prop.getProperty("ValidateAddedColleaguesName")+"')]")).getText();
		WebElement text = driver.findElement(By.xpath("//a[contains(text(),'"+prop.getProperty("ValidateAddedColleaguesName")+"')]")) ;
		 return text ;
	}
	
	//COLLEAGUE PROFILE TITLE   
	public WebElement colleagueprofiletitle(){
		
		//collprofiletitle.getText();
		return collprofiletitle;
		
		
	}
	//SELECT ACTION 
	public void selectoption() throws InterruptedException{
		
		Select drop = new Select(selectaction);
		drop.selectByVisibleText("Send Referral");
		Thread.sleep(8000); 
		
		
	}
	//SEND REFERRAL PAGE TITLE 
    public WebElement sendreferralpagetitle(){
    //	SendReferralspagetitle.getText();
       return SendReferralspagetitle;
    	
    }
	//DELETE OPTION IN SELECTACTION 
    public void selectdeleteoption() throws InterruptedException{
    	
    	Select drop = new Select(selectaction);
		drop.selectByVisibleText("Delete");
		Thread.sleep(4000); 
    	
    }
   //ARE YOU SURE YOU WANT TO REMOVE POPUP TITLE
    public WebElement areyousureyouwanttoremove(){
       //	delconfirmationmessge.getText();
         return	delconfirmationmessge;
    		
    }
    //CLICK ON YES BUTTON  
    public WebElement yesbutton(){
    
     //	yesbtn.click();
    	return yesbtn;
    	
    }
    public WebElement colleaguesremovedsuccesfullyafterclickonyesbutton(){
    	
    	WebElement text = driver.findElement(By.xpath("//span[contains(text(),'Colleague removed successfully')]"));
    	
    	return text ;
    			
    }
	public WebElement hemburgerbtn(){
		
	//	hemburgerbtn.click();
		return hemburgerbtn ;
		
	} 
	public WebElement addcolleaguesbtn(){
		
	//	addcolleaguesbtn.click(); 
		
		return addcolleaguesbtn ;
		
	} 
	
	//SEARCH COLLEAGUES PAGE TITLE 
	public WebElement searchcolleagues(){
		
		//searchcolleagues.getText();
	 return searchcolleagues;
		
	}
	//COLLEAGUES NAME FIELD ON SEARCH COLLEAGUES PAGE 
	public WebElement namefieldonsearchcolleaguespage(){
		
	//	namesearchfieled.sendKeys(prop.getProperty("Addedcolleagename4"));
		return namesearchfieled ;
		
	}
	
     public WebElement namefieldonsearchcolleaguespage1(){
		
	//	namesearchfieled.sendKeys(prop.getProperty("ColleaguesPageColleagueName"));
		return namesearchfieled ;
		
	}
	
	public WebElement submitbutton1(){
		
	  WebElement sbtn =	driver.findElement(By.className("ico-edit4"));
	  return sbtn ;
		
	}
	
	//CLICK ON COLLEAGUES NAME 
	public void clickoncolleaguesname(){
		
	//	driver.findElement(By.linkText(prop.getProperty("ColleagNameAppearsOnSearchCollPage"))).click();
		
		try{
		    WebDriverWait wait=new WebDriverWait(driver, 40);

		       wait.until(ExpectedConditions.visibilityOfElementLocated(
		          
		    		By.linkText(prop.getProperty("ColleagNameAppearsOnSearchCollPage")))
		       ).click();

		    }
		    catch(Throwable t){
		        System.out.println("The execption is: " + t);
		    }
		    finally {
		        System.out.println("If no exception tell me now");
		    }
		
		
	}
	
	
	
	//SUBMIT BUTTON ON SEARCHCOLLEAGUES PAGE 
	public WebElement submitbutton(){
		
	//	submtbtn.click();
		return submtbtn;
		
	}
	//ADD COLLEAGUES BUTTON APPEARING AFTER SEARCHING COLLEAGUES ON SEARCH COLLEAGUES PAGE 
	public WebElement addcolleaguesbtnaftersearchcolleagues(){
		
	//	addcollbtninsearchcolleg.click();
		return addcollbtninsearchcolleg;
		
	}
	//SUCCESS MESSAGE AFTER ADDING COLLEAGUES
	public WebElement SuccessMessageAfteraddingcolleagues(){
		
	//	successmsgaddcolleagebtn.getText();
		return successmsgaddcolleagebtn;
		
	}
	// 
	//ENTERING NOT EXISTING COLLEAGUES IN SEARCH-FIELD  
	public void NoexistingcolleaguesSearchfield () throws InterruptedException{
		
		Searchfieldcolle.sendKeys(prop.getProperty("Non-existingcolleagename"));
		Thread.sleep(2000);
		searchbtn.click();
		
	}
    
	public WebElement NoRecordFoundInformationMessage(){
		 
	  return Norecordfoundmsg;
		
	}
	
	//EMAIL FIELD ON SEARCH COLLEAGUES PAGE   
	public WebElement emailfieldonsearchcolleaguespage(){
		
	//	emailsearchfield.sendKeys(prop.getProperty("ColleaguesPageColleagueEmailId"));
		return emailsearchfield;
		
	}
	
	//EMAIL ID APPEARS AFTER CLICKING SUBMIT BUTTON ON SEARCH COLLEAGUES PAGE   
	
	public WebElement emailidappearsafterclickingonsubmitbutton(){
		
	// driver.findElement(By.xpath("//a[contains(text(),'"+prop.getProperty("ColleaguesPageColleagueEmailId")+"')]")).getText();
	 WebElement text = driver.findElement(By.xpath("//a[contains(text(),'"+prop.getProperty("ColleaguesPageColleagueEmailId")+"')]")) ; 
	 return text ;
		
		
	}
	
	//CANCEL BUTTON ON SEARCH COLLEAGUES PAGE   
	public WebElement cancelbuttononsearchcolleaguespage(){
		
	//	cancelbtn.click();
		return cancelbtn;
		
	}
	
	//VALIDATE NAME FIELD ON SEARCH COLLEAGUES PAGE  
	public boolean validatenamefieldonsearchcolleaguespage(){
		
	   if ( namesearchfieled.getAttribute("Value") != "")
		   
	    //	return ValidateNametextinfield.getText();
	     return false;
	   
	     else
	     
	    	 System.out.println("True");
	    return true;
	     
	}
	
	//VALIDATE EMAIL FIELD ON SEARCH COLLEAGUES PAGE 
	public boolean validateemailfieldonsearchcolleaguespage(){
		
		if ( namesearchfieled.getAttribute("Value") != "")
			   
		    //	return ValidateNametextinfield.getText();
		     return false;
		   
		     else
		     
		    	 System.out.println("True");
		    return true;
		
	}
	
	//INVITE-BY-EMAIL-BUTTON
	public WebElement invitebyemailButton(){
		
	//	inviatebyemailicon.click();
		return inviatebyemailicon ;
	
	}
	
	//INVITE COLLEAGUES PAGE TITLE TEXT 
	public WebElement invitecolleaguespagetitle(){
		
	// invitecolleaguepagetitle.getText();
		return invitecolleaguepagetitle ;
		
	}
	
	//Colleagues PAGE LINK  
	
	public WebElement colleaguespagelink(){
		
		WebElement click =driver.findElement(By.linkText("Colleagues")); 
		return click ;
		
	}
	
	
	
	
	
	
}

package com.ocr.qa.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;

public class Conversationspage extends TestBase {

	
	
//PAGE ALL ELEMENTS------------------------	
	
	//CLICK ON MESSAGE ON REFERRALS PAGE 
	@FindBy(how=How.XPATH,using="(//td[contains(@data-th,'Message')])[1]")
	@CacheLookup 
	WebElement ClickMessageOnRefferals ;
	
	//REFERRAL TO NAME ON CONVERSATION PAGE 
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Yen Wang')]")
    @CacheLookup
    WebElement ReferralsToName ;
	
	//PATIENT FORM TITLE 
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Patient Forms')]")
	@CacheLookup
	WebElement TitlePatientForms ;
	
	//OFFICE COMMUNICATION SECTION 
	//ENTER MESSAGE 
	@FindBy(how=How.CSS,using="#msgcontant")
	@CacheLookup
	WebElement EnterMessageOC;
	
	//SEND MESSAGE ICON 
	@FindBy(how=How.XPATH,using="(//i[@class='fa fa-paper-plane-o'])[1]")
	@CacheLookup
	WebElement SendMessIconOC ;
	
	//ATTACHEMENT ICON 
//	@FindBy(how=How.XPATH,using="(//i[@class='fa fa-paperclip'])[1]")
	@FindBy(how=How.XPATH,using="//*[@id=\"group\"]/div[2]/div/div[2]/a[1]/i")
	@CacheLookup
	WebElement AttachementIconOC ;
	
	//CHOOSE FILE BUTTON UNDER ATTACHEMENT POPUOP 
	@FindBy(how=How.XPATH,using="//*[@id=\"uploadingFile\"]")
	@CacheLookup
	WebElement ChooseFileBtnUnderOcPopup ;
	
	
	//TEXT MESSENGER SECTION 
	//ENTER MESSAGE 
	@FindBy(how=How.CSS,using="#bodysendmsg")
	@CacheLookup
	WebElement EnterMessageTM;
	
	//SEND MESSAGE ICON 
	@FindBy(how=How.XPATH,using="(//i[@class='fa fa-paper-plane-o'])[2]")
	@CacheLookup
	WebElement SendMessIconTM ;
	
	
	//TEXT MESSENGER ICON 
	@FindBy(how=How.XPATH,using="//i[@class='fa fa-expand text-right']")
	@CacheLookup 
	WebElement textmessengicon;
	
	//TEXT MESSENFER POPUP TITLE 
	@FindBy(how=How.XPATH,using="(//h4[contains(text(),'Text Messenger')])[1]")
	@CacheLookup 
	WebElement textmessengerpopuptitle;
	
	
	
//INITIALIZE ALL OBJECTS--------------------  
	
public Conversationspage(){
				
	PageFactory.initElements(driver, this);
					
}
		
//ACTIONS-------------------------------------	

public WebElement mesageonrefferalpage(){
	
return	ClickMessageOnRefferals;
	
}

//REFERRAL TO NAME 

public WebElement referralsToName(){
	
	// driver.findElement(By.xpath("//a[contains(text(),'"+prop.getProperty("ReferralRecivedDentist")+"')]")).getText();
	 WebElement text = driver.findElement(By.xpath("//a[contains(text(),'"+prop.getProperty("ReferralRecivedDentist")+"')]"));
	 return  text; 
	 
}

public WebElement ClickOnReferralsRecivedColleagueName(){
	
//	driver.findElement(By.linkText(prop.getProperty("ReferralRecivedDentist"))).click();
	WebElement click = driver.findElement(By.linkText(prop.getProperty("ReferralRecivedDentist")));
    return click;
	
}
	
//PATIENT NAME IN PATIENT INFO  

public WebElement patientNameinPatientinfo(){
	
//  driver.findElement(By.cssSelector("#wizard > div.user_profile > div.portfoilo.mrgn-btm-20 > div.content > a")).getText();
	WebElement text = driver.findElement(By.cssSelector("#wizard > div.user_profile > div.portfoilo.mrgn-btm-20 > div.content > a"));
   	return  text;
	
}

//CLICK ON PATIENT NAME 

public WebElement ClickOnPatientNameinPatientinfo(){
	
//	driver.findElement(By.linkText(prop.getProperty("ReferredPatientName"))).click();
	WebElement click = driver.findElement(By.linkText("Patient7"));
	return click;
	
}
	
//PATIENT FORM TITLE 

public WebElement Patientformtitle(){
	
	return TitlePatientForms;
	
}
	
//TYPE MESSAGE UNDER OFFICE COMUNICATION SECTION ON CONVERSATION PAGE    

public void typemessageunderoc() throws InterruptedException{
	
//	EnterMessageOC.sendKeys("Hello");
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(EnterMessageOC))
	.sendKeys("Hello");
	Thread.sleep(2000);
    WebDriverWait wait1 = new WebDriverWait(driver, 60);
    wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(SendMessIconOC))
	.click();
//	SendMessIconOC.click();
	
} 

//TYPE BLANK MESSAGE UNDER OFFICE COMUNICATION SECTION ON CONVERSATION PAGE

public void typeblankmessageoc() throws InterruptedException{
	
 //	EnterMessageOC.sendKeys("");
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(EnterMessageOC))
	.sendKeys("");
	Thread.sleep(2000);
    WebDriverWait wait1 = new WebDriverWait(driver, 60);
    wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(SendMessIconOC))
	.click();
	
//	SendMessIconOC.click();
	
}



//ATTACHEMENT ICON UNDER OFFICE COMUNICATION SECTION 

public WebElement Attachementiconunderoffccomunictionsection(){
//	AttachementIconOC.click();
	return AttachementIconOC ;
	
}

//ATTACHEMENT POPUP TITLE 

public WebElement attachementpopuptitle(){
	
  // 	 driver.findElement(By.xpath("//h4[contains(text(),'Attachments')]")).getText();
   	WebElement title =  driver.findElement(By.xpath("//h4[contains(text(),'Attachments')]"));
	return  title;
}

//CHOOSE FILE UNDER ATTACHEMENT SECTION 

public WebElement choosefileunderOC (){
	
//	ChooseFileBtnUnderOcPopup.click(); 
	return ChooseFileBtnUnderOcPopup;
	
}

//TYPE MESSAGE UNDER TEXT MESSENGER ON CONVERSATION PAGE 

public void typemessageundertextmessenger() throws InterruptedException{
	
	EnterMessageTM.sendKeys("HII");
	Thread.sleep(2000);
	SendMessIconTM.click();
	
}

//TYPE BLANK MESSAGE UNDER TEXT MESSENGER SECTION ON CONVERSATION PAGE 

public void typeblankmessageTm() throws InterruptedException{
	
	EnterMessageTM.sendKeys("");
	Thread.sleep(2000);
	SendMessIconTM.click();
	
}



//TEXT MESSENGER ICON 

public WebElement textmessengericon(){
	
	// textmessengicon.click();
	return textmessengicon;
	
}

//VALIDATE TEXT MESSENGER POPUP TITLE 

public WebElement validatetextmessengertitle(){
	
	  // textmessengerpopuptitle.getText();
	  return textmessengerpopuptitle;
	
}

//VALIDATE LATEST FILE DOWNLOADED ON THE PAGE 

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

//INVITED PATIENT RECIVED MESSAGE IN YOPMAIL 
public void verifyPatientmail() throws InterruptedException{
	WebDriverWait wait=new WebDriverWait(driver, 30);
	driver.get("http://www.yopmail.com/");
	
	
	WebElement Searchfield = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login"))); 
	Searchfield.click();
	
	Searchfield.clear();
	Thread.sleep(2000);
	Searchfield.sendKeys(prop.getProperty("PageSendReferralAddEmailforConversationPage")); 
	

	WebElement Checkinboxbutton = wait.until(ExpectedConditions.elementToBeClickable(By.className("sbut")));
	Checkinboxbutton.click();
	Thread.sleep(5000);
	

}

//INVITED DENTIST RECIVED MESSAGE IN YOPMAIL 
public void verifyDentistmail() throws InterruptedException{
	WebDriverWait wait=new WebDriverWait(driver, 30);
	driver.get("http://www.yopmail.com/");
	
	
	WebElement Searchfield = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login"))); 
	Searchfield.click();
	
	Searchfield.clear();
	Thread.sleep(2000);
	Searchfield.sendKeys(prop.getProperty("PageSendReferralDentistAddEmailforConversationPage")); 
//	Searchfield.sendKeys("levinautomation@yopmail.com"); 

	WebElement Checkinboxbutton = wait.until(ExpectedConditions.elementToBeClickable(By.className("sbut")));
	Checkinboxbutton.click();
	Thread.sleep(5000);
	

}

//INVITED COLLEAGUE RECIVED MESSAGE IN YOPMAIL 
public void verifyColleaguemail() throws InterruptedException{
	WebDriverWait wait=new WebDriverWait(driver, 30);
	driver.get("http://www.yopmail.com/");
	
	
	WebElement Searchfield = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login"))); 
	Searchfield.click();
	
	Searchfield.clear();
	Thread.sleep(2000);
	Searchfield.sendKeys(prop.getProperty("PageSendReferralColleagueAddEmailforConversationPage")); 
	

	WebElement Checkinboxbutton = wait.until(ExpectedConditions.elementToBeClickable(By.className("sbut")));
	Checkinboxbutton.click();
	Thread.sleep(5000);
	

}




}



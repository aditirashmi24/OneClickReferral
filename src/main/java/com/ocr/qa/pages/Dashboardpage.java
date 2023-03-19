package com.ocr.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
public class Dashboardpage extends TestBase {

	
	
	//************P A G E F A C T R O Y*****************
	
	
	
	//Imagelogo
		@FindBy(how=How.XPATH,using="//img[@class='img-responsive center-block']")
		@CacheLookup 
		WebElement imagelogo;
		
    //Dashboardlogo
		@FindBy(how=How.CSS,using=".img-responsive")
		@CacheLookup 
		WebElement dashboardlogo;
		
	//UserName
	   @FindBy(how=How.CSS,using=".dropdown-toggle > span:nth-child(1)") 
	   @CacheLookup 
	 WebElement usernamelabel;
	
	//PATIENTS LABEL
		@FindBy(how=How.XPATH,using="//a[text()=' Patients']")                        
		@CacheLookup 
		WebElement patientlabel;    
	
    //REFERRALS LABEL
		@FindBy(how=How.XPATH,using="//a[text()=' Referrals']")                        
		@CacheLookup 
		WebElement referralslabel;  	
		
	//REFERRALS LABEL
		@FindBy(how=How.XPATH,using="//a[text()=' Colleagues']")                        
		@CacheLookup 
		WebElement  colleagueslabel; 	
		
		
		
	//ReferralsLink
 //	@FindBy(how=How.CSS,using="li.top-bar:nth-child(1) > a:nth-child(1)")
 //	@FindBy(how=How.LINK_TEXT,using="Referrals")
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Referrals')]")
	@CacheLookup 
	WebElement referralslink;
	
	//Colleagueslink
//	@FindBy(how=How.CSS,using="li.icons:nth-child(3) > a:nth-child(1)")
//	@FindBy(how=How.LINK_TEXT,using="Colleagues")
	@FindBy(how=How.XPATH,using="(//a[contains(text(),' Colleagues')])[3]")
	@CacheLookup
	WebElement colleagueslink;
	
	//Patientslink
//	@FindBy(how=How.CSS,using="li.top-bar:nth-child(2) > a:nth-child(1)")
//	@FindBy(how=How.LINK_TEXT,using="Patients")
//	@FindBy(how=How.LINK_TEXT,using="Patients")
	@FindBy(how=How.XPATH,using="(//a[contains(text(),' Patients')])[2]")
	@CacheLookup 
	WebElement patientslink; 
	
	//Sendreferrallink
//	@FindBy(how=How.CSS,using=".referral")
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Send Referral')])[1]")
	@CacheLookup   
	WebElement sendreferralsbtn; 
	
	//Arrowbutton
//	@FindBy(how=How.CSS,using=".icon-down_arrow_top")
//	@FindBy(how=How.XPATH,using="//i[@class='icon-down_arrow_top' ]//parent::a[@class='dropdown-toggle']//ancestor::div[@id='top-section']")
	@FindBy(how=How.XPATH,using=".//div[@class='top-section']//following::div//ul//li//i[@class='icon-down_arrow_top']")
	@CacheLookup
	WebElement arrowbtn;  
	
	//Editprofilebutton
	@FindBy(how=How.CSS,using=".dropdown-user > li:nth-child(1) > a:nth-child(1)")
	@CacheLookup 
	WebElement Editprofilebtn; 
	
	//Setting
	@FindBy(how=How.CSS,using=".dropdown-user > li:nth-child(2) > a:nth-child(1)")
	@CacheLookup 
	WebElement setting; 
	
	//TeamMembers 
	@FindBy(how=How.CSS,using="#wizard > div.wizard-inner > ul > li:nth-child(3) > a")
	@CacheLookup 
	WebElement teammemebrs; 
	
	//ReferralForm  
	@FindBy(how=How.LINK_TEXT,using="Referral Form")
	@CacheLookup 
	WebElement Referralform; 
	
	//PatientForm  
	@FindBy(how=How.LINK_TEXT,using="Patient Form")
	@CacheLookup 
	WebElement Patientform;  
	
	//Integrations 
	@FindBy(how=How.LINK_TEXT,using="Integrations")
	@CacheLookup 
	WebElement Integrations; 
	
	//SMS Configuration   
	@FindBy(how=How.LINK_TEXT,using="SMS Configuration")
	@CacheLookup 
	WebElement SMSConfiguration; 
	
	
	
	
	//INITIALZATION OF ALL OBJECTS--------
	
	public Dashboardpage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	//ACTION------  
	
	//CLICK ON LOGO FOR DASHBOARD PAGE
	public WebElement clickonlogo() throws InterruptedException{

	   return	imagelogo ;
		
	}
	
	
	
	//VALIDATION ON IMAGE LOGO
	public boolean validatepagelogo(){
		
		return dashboardlogo.isDisplayed();
			
	}
	
	//VALIDATION ON USERNAME 
	
	public boolean validateusername(){
		
		return usernamelabel.isDisplayed();
		
	}
	
   //VERIFY PATIENT LABEL
	
	public boolean verifypatientsLabel(){
			
			
		return patientlabel.isDisplayed();
			
	}
   //VERIFY REFERRALS LABEL
	
	 public boolean verifyreferralsLabel(){
					
					
			return referralslabel.isDisplayed();
					
	}
	//VERIFY COLLEAGUES LABEL
		
	 public boolean verifycolleaguesLabel(){
					
					
			return colleagueslabel.isDisplayed();
					
	}
	
	//PATIENTS PAGE
	
	public Patientspage clickonpatientslink(){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(patientslink))
		.click();
		
		
		return new Patientspage();
		
	}
	
	//COLLEAGUES PAGE 
	
	public Colleaguespage clickoncolleagueslink(){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(colleagueslink))
		.click();
		
		
		return new Colleaguespage();
		
	}
	
	//REFERRALS PAGE 
	
	public Referralspage clickonreferrallink(){
		
	
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(referralslink))
		.click();
		
		
		return new Referralspage();
		
	}
	
	//SEND REFFERAL PAGE
	
	public SendReferralpage clickonsendreferralbtn(){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(sendreferralsbtn))
		.click();
		
		return new SendReferralpage();
		
	}
	
	//PROFILE PAGE 
	
	public Profilepage clickoneditprofilebtn(){
		
		
		
		//ArrowButton 
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(arrowbtn))
		.click();
	
	    //EditprofileButton 
	    WebDriverWait wait1 = new WebDriverWait(driver, 60);
	    wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Editprofilebtn))
		.click();
		
		return new Profilepage();
	}
	
	//SETTING PAGE 
	
	public SecuritySettingsPage clickonsettingbtn() throws InterruptedException{
		
		//ArrowButton 
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(arrowbtn))
		.click();
	//	Thread.sleep(1000);
	/*	try {
			WebDriverWait wait1 = new WebDriverWait(driver,60);
		    System.out.println("Waiting for frame");
		    wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@style,'border') and contains(@class,'drift-widget-slider')]")));
		    System.out.println("Frame Found and Switched"); 
		    Actions act = new Actions(driver); 
		    act.moveToElement(driver.findElement(By.xpath("//button[@id='widgetButton']"))).perform();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//button[@id='widgetButton']")).click();
		    System.out.println("Open Chat Box"); 
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"widgetCloseButton\"]")).click();
		    System.out.println("Closing the bot");
			}    
			
		
			catch(Exception ex) {
				
				System.out.println("Exception"+ex);
			}  
			
			finally {
		    driver.switchTo().parentFrame();
			}
	    System.out.println("hello");*/
		//SeettingButton
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(setting)).click();
		
		return new SecuritySettingsPage();
		
	}
	
	//TEAM MEMBERS PAGE  
	 public  TeamMembersPage clickonsettingandTeamMembersbtn(){
		 
		
		//TeamMemebrsBtn 
			WebDriverWait wait1 = new WebDriverWait(driver, 60);
			wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(teammemebrs))
			.click();
		 
		  return new  TeamMembersPage();
		 
		 
		 
	 }
	
	//REFERAL FORM PAGE 
	 public ReferalFormPage clickonsettingandReferalFormbtn(){
		 
		 
		//TeamMemebrsBtn 
			WebDriverWait wait1 = new WebDriverWait(driver, 60);
			wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Referralform))
			.click();
		 
		  return new ReferalFormPage();
		 
		 
	 }
	 
	//PATIENT FORM PAGE 
		 public PatientFormPage clickonsettingandPatientFormbtn(){
			 
			 
			//TeamMemebrsBtn 
				WebDriverWait wait1 = new WebDriverWait(driver, 60);
				wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Patientform))
				.click();
			 
			  return new PatientFormPage();
			 
			 
		 } 
		 
		 
	//PATIENT FORM PAGE 
		public Integrationspage clickonsettingandIntegrationspagebtn(){
			 
		//TeamMemebrsBtn 
			   WebDriverWait wait1 = new WebDriverWait(driver, 60);
			   wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Integrations))
			  .click();
			 
			  return new Integrationspage();
			 
			 
		 }
	 
	//SMS Configuration Page  
		public SMSConfigurationPage clickonSMSConfigurationTab(){
			
			WebDriverWait wait1 = new WebDriverWait(driver, 60);
			   wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(SMSConfiguration))
			  .click();
			 
			  return new SMSConfigurationPage();
			
			
			
		}
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

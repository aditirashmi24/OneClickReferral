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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;

public class Patientspage extends TestBase {
   
	
	
	
	//PATIENTS FIRSTNAME TITLE
	@FindBy(how=How.XPATH,using="//span[@class='heading' and text()='First Name']")
	@CacheLookup 
	WebElement patientFirstname;
	
	//SEARCH PATIENTS SEARCHFIELD 
	@FindBy(how=How.CSS,using="#txtSearchPatients")
	@CacheLookup 
	WebElement  searchfield; 
	
	//SEARCH ICON ON SEARCHFIELD 
	@FindBy(how=How.CLASS_NAME,using="icon-search")
	@CacheLookup 
	WebElement Searchicon;
	
	
	//AFTER SEARCH PATIENTS NAME EXIST ='
	//@FindBy(how=How.CSS,using="#row_726527 > td:nth-child(2) > a:nth-child(1)")
	//@FindBy(how=How.CSS,using="#row_726600 > td:nth-child(2)")
	@FindBy(how=How.LINK_TEXT,using="mark")
	@CacheLookup 
	WebElement Appearpatnme;
	
	//PATIENTS NAME ON PATIENTS PAGE  
	//@FindBy(how=How.XPATH,using="(//a[text()='mark']//parent::td[@data-th='First Name'])[1]") 
	@FindBy(how=How.LINK_TEXT,using="mark")
	@CacheLookup 
	WebElement Patientsappear;
	
	//PATIENT HISTORY PAGE TITLE
	@FindBy(how=How.CSS,using="h1.inline")
	@CacheLookup
	WebElement Patienthistorytitle;
	
	//BACK BUTTON ON PATIENT HISTORY PAGE 
	@FindBy(how=How.XPATH,using="//a//i[@class='fa fa-arrow-left' or @text='Back']")
	@CacheLookup
	WebElement backbtn;

	//INSURANCE NOT VERIFED ICON  
	//@FindBy(how=How.CSS,using="#row_726287 > td:nth-child(8) > img:nth-child(1)")
	@FindBy(how=How.XPATH,using="(//img[@title='Insurance not verified'])[1]")
	@CacheLookup
	WebElement invicon;
	
	//SELECT PATIENT FORM OPTION
	@FindBy(how=How.XPATH,using="(//div//select[@class='form-control height34'])[1]")
	@CacheLookup 
	WebElement selectoptn;
	
	//SELECT PATIENT FORM OPTION
	//@FindBy(how=How.CSS,using="#ddlPatient_727244")
	@FindBy(how=How.XPATH,using="//select[@class='form-control height34']")
	@CacheLookup 
	WebElement selectdeloptn;
	
	
	//SUCCESS MESSAGE AFTER SEND FORM
	@FindBy(how=How.CSS,using="div > div > span.message")
	@CacheLookup 
	WebElement succesmessage;
	
	//CONFIRMATION MESSAGE 
	@FindBy(how=How.XPATH,using="//p[text()='Are you sure you want to Delete Patient?' and @class='mrgn-btm-0']")
	@CacheLookup 
	WebElement confirmmessage; 
	
	//YES BUTTON
	@FindBy(how=How.CSS,using="#btn_yes")
	@CacheLookup 
	WebElement yesbtn;   
	
	//SUCCESS MESSAGE AFTER DELETEING PATIENT
	@FindBy(how=How.XPATH,using="//p[text()='Patient removed successfully' and @class='mrgn-btm-0']")
	@CacheLookup 
	WebElement delsuccessmsg;
	
	//OK BUTTON TO CONFIRM SUCCESS MESSAGE 
	@FindBy(how=How.CSS,using="#btn_no")
	@CacheLookup 
	WebElement okbtn;  
	
	
	//DELETE BUTTON FOR REFERRED BY PATIENT
	@FindBy(how=How.CSS,using="#ddlPatient_726543 > option:nth-child(2)")
	@CacheLookup 
	WebElement rfyesbtn;
	
	//VALIDATION MESSAGE WHEN DELETE REFERREDBY/TO PATIENT 
	@FindBy(how=How.XPATH,using="//span[contains(text(),'This patient is associated with another dentist.')]")
	@CacheLookup 
	WebElement vald;
	
	//EDIT PROFILE PAGE TITLE 
	@FindBy(how=How.CSS,using="div.col:nth-child(3) > h1:nth-child(1)")
	@CacheLookup
	WebElement eptitle;
	
	//BACK BUTTON ON EDIT PROFILE PAGE  
	@FindBy(how=How.CSS,using="div.col:nth-child(3) > div:nth-child(2) > a:nth-child(1)")
	@CacheLookup 
	WebElement backbtnep;
	
	//VERTICAL ELIPSE ICON ON PATIENTS PAGE 
	@FindBy(how=How.CSS,using=".fa-ellipsis-v")
	@CacheLookup 
	WebElement verellbtn;
	
	//ADD PATIENT BUTTON 
	@FindBy(how=How.LINK_TEXT,using="Add Patient")
	@CacheLookup 
	WebElement addbtn;     
	
	//FirstName in SearchField on Add-patient page 
	
	@FindBy(how=How.XPATH,using="//input[contains(@name,'FirstName')]")
	@CacheLookup 
	WebElement ENTRFIRSTNAME;
	
	//LastName in SearchField on Add-patient page
	
	@FindBy(how=How.XPATH,using="//input[contains(@name,'LastName')]")
	@CacheLookup 
	WebElement ENTRLASTNAME;
	
	//Add New : Phone Number in SearchField on Add-patient page 
	
	@FindBy(how=How.XPATH,using="//input[@id='Phone']")
	@CacheLookup 
	WebElement PHONENO;
	//Gender in SelectField on Add-patient page
	
   // @FindBy(how=How.XPATH,using="//input[contains(@name,'LastName')]")
    //@FindBy(how=How.XPATH,using="//option[contains(text(),'Select Gender')]")
    @FindBy(how=How.CSS,using="#Gender")
	@CacheLookup 
    WebElement SELECTGENDER;
	
   //Click on 'Save' button on Add-patient page
	
    @FindBy(how=How.XPATH,using="//a[contains(text(),'Save')]")
	@CacheLookup 
    WebElement Savebutton;
    
    
	//VALIDATE ON ADD PATIENT PAGE TITLE
	
	//@FindBy(how=How.XPATH,using="//h1[contains(text(),'Add Patient')]")
	@FindBy(how=How.XPATH,using="//*[@id=\"main\"]/div[2]/div/div/div/div/div[3]/h1")
	@CacheLookup 
	WebElement addpatienttitle;
	
	//VERIFY EDIT PATIENT PAGE OPENS UP
	
	@FindBy(how=How.CSS,using="div.col:nth-child(3) > h1:nth-child(1)")
	@CacheLookup 
	WebElement editpatient;
	
    //EDIT PATIENT 
	
	//@FindBy(how=How.XPATH,using="//h1[contains(text(),'Edit Patient')]")
	@FindBy(how=How.XPATH,using="//*[@id=\"main\"]/div[2]/div/div/div/div/div[3]/h1")
	@CacheLookup 
	WebElement editpatientpagetitle;
	
	//BACK BUTTON ON EDIT PATENT PAGE 
	
	//@FindBy(how=How.CLASS_NAME,using="btn btn-primary") 
	@FindBy(how=How.XPATH,using="//*[@id=\"main\"]/div[2]/div/div/div/div/div[3]/div/a/i") 
	//@FindBy(how=How.CLASS_NAME,using="fa fa-arrow-left") 
	//@FindBy(how=How.XPATH,using="(//a[@class='btn btn-primary']//preceding-sibling::i[@class='fa fa-arrow-left'])[1]")
	@CacheLookup 
	WebElement backbtnoneditpage;
	
	//PATIENTS LABEL 
	
    @FindBy(how=How.XPATH,using="//a[text()=' Patients']")                        
    @CacheLookup 
	WebElement patientlabel; 
	
	//FirstName on Patients page   
    
    @FindBy(how=How.XPATH,using="//span[contains(text(),'First Name')]")                        
    @CacheLookup 
	WebElement ClickableFirstName; 
    
    //After click on FirstName  
    
    @FindBy(how=How.XPATH,using="(//td[contains(@data-th,'First Name')])[1]")                        
    @CacheLookup 
	WebElement SortingBy_1_ClickFirstName; 
    
    //After again click on FirstName  
    
    @FindBy(how=How.XPATH,using="(//td[contains(@data-th,'First Name')])[1]")                        
    @CacheLookup 
	WebElement SortingBy_Z_ClickFirstName; 
    
    
    //LastName on Patients page   
    
    @FindBy(how=How.XPATH,using="//span[contains(text(),'Last Name')]")                        
    @CacheLookup 
	WebElement ClickableLastName;
    
   //After click on LastName  
    
    @FindBy(how=How.XPATH,using="(//td[contains(@data-th,'Last Name')])[1]")                        
    @CacheLookup 
	WebElement SortingBy_1_ClickLastName; 
    
    //After again click on LastName  
    
    @FindBy(how=How.XPATH,using="(//td[contains(@data-th,'Last Name')])[1]")                        
    @CacheLookup 
	WebElement SortingBy_Z_ClickLastName; 
    
//**********ACTION************---------------	
	
	public Patientspage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	//	VERIFY PATIENT PAGE OPENS UP
	public String verifypatientspage (){
		
		//return patientFirstname.getText();
		  return driver.getTitle();
	}
	
	//ENTER EXISTING DETAILS IN SEARCH-FIELD  
	public void existingpatientdetails(String pat) throws InterruptedException{
	
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(searchfield))
		  .sendKeys(pat);
		
		Thread.sleep(2000);
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		 wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(Searchicon))
		 .click();
		
		Thread.sleep(3000);
	}
	
	
	
	//VERIFY EXISTING DETAILS AFTER SEARCH
	
	public WebElement verifyafterexistingpatientdetails(){
		
	 // driver.findElement(By.linkText(prop.getProperty("AppearPatientname"))).getText();
	WebElement text =driver.findElement(By.linkText(prop.getProperty("AppearPatientname"))); 
	return text;
     	
	}
	
//*******VERIFY PATIENT HISTORY PAGE OPEN UP ON Clicking PATIENT NAME 
	
	public void patientfirstnameappears(String name) throws InterruptedException{
		
	      
		driver.findElement(By.xpath("(//a[text()='"+name+"']//parent::td[@data-th='First Name'])[1]")).click();
		//Patientsappear.click();
		driver.findElement(By.linkText(name)).click();
	}
	
	//PATIENT HISTORY TITLE
	public WebElement verifypatienthistorytitle(){
		
		// Patienthistorytitle.getText();
	   return Patienthistorytitle;
		
		
	}
	
	//VERIFY PATIENTS PAGE OPENS UP ON CLICKING BACK BUTTON
	public WebElement verifypatientspagebutton (){
	
		//  backbtn.click();
		return backbtn;
		
	}
	//VERIFY THAT INVICON IS NOT CLICKABLE 
	public boolean verifythainviconnotclickable () {
		
	 
	 try 
	 {
	 WebDriverWait wait = new WebDriverWait(driver, 10);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@title='Insurance not verified'])[1]"))) ; 
    
     return false;
	 }    
	 catch(Exception NOTCLICKABLE)
	 { 
		 return true;
	 }
     
    }
     //VERIFY SEND PATIRNT FORM
	public void selectpatientformoptn() throws InterruptedException{
		
		
		Select drop = new Select(selectoptn);
		drop.selectByVisibleText("Send Patient Form");
		Thread.sleep(4000); 
		
	}
	
	//SUCCESS MESSAGE AFTER SEND FORM  
	public WebElement verifysuccessmessage (){
		
	//	succesmessage.getText();
		return succesmessage;
		
	}
	
	//VERIFY CONFIRMATION MESSAGE ON DELETE BUTTON 
	public void selectdeleteoption () throws InterruptedException{
		
		Select drop = new Select(selectoptn);
	    drop.selectByVisibleText("Delete");
		Thread.sleep(4000);
		
	}
	
	//Select delete option for new created customer
	public void newcusselectdeleteoption() throws InterruptedException{
		
		Select drop = new Select(selectdeloptn);
	    drop.selectByVisibleText("Delete");
		Thread.sleep(6000);
		
		
	}
	
	
	//CONFIRMATION MESSAGE   
	public WebElement verifyconfirmationmessage(){
	      
	//	 confirmmessage.getText();
		return confirmmessage;
		
	}
	
	//YES BUTTON 
	public WebElement yesbutton(){
		
	//	yesbtn.click();
		
		return yesbtn;
		
	/*	try{
		    WebDriverWait wait=new WebDriverWait(driver, 60);

		       wait.until(ExpectedConditions.visibilityOfElementLocated(
		    		By.cssSelector("#btn_yes"))   
		       ).click();

		    }
		    catch(Throwable t){
		        System.out.println("The execption is: " + t);
		    }
		    finally {
		        System.out.println("If no exception tell me now");
		    }
    	
		*/
		
		
	} 
	public WebElement deletesuccesmessage(){
		
		delsuccessmsg.getText();
		return delsuccessmsg;
	
		
	}
	public WebElement okbtn () {
		
	   return okbtn;
		
	}
	
	//VALIDATION MESSAGE ON DELETING REFERRED BY PATIENT  
	
	public WebElement validreferredpatientmsg(){
	//	vald.getText();
		return vald;
		
		
	}
	
	//VERIFY CONFIRMATION MESSAGE ON EDIT BUTTON 
		public void selecteditoption () throws InterruptedException{
			
			Select drop = new Select(selectoptn);
		    drop.selectByVisibleText("Edit Patient");
			Thread.sleep(4000);
			
		}
	
	    public WebElement editpatientpagetitle(){
	    //	editpatientpagetitle.getText();
	    	
	    	return editpatientpagetitle;
	    	
	    }
	    
	   public void backbtnoneditpage() throws InterruptedException{
		   
		   Select drop = new Select(selectoptn);
		    drop.selectByVisibleText("Edit Patient");
			Thread.sleep(3000);
		   backbtnoneditpage.click();
		   
	   }
	
	   public WebElement patentpagelevel(){
		//   patientlabel.getText()
		   return patientlabel;
		   
	   }
	
	//VERIFY ADD PATIENT PAGE OPENS UP ON CLICKING ADDPATIENT BUTTON
	
	
	   public void verticalelipseandaddbtn() throws InterruptedException{
		   
	
		   WebDriverWait wait1 = new WebDriverWait(driver, 60);
		   wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf( addbtn))
		   .click();
		  
	   }
	   
	   public void fillmandatoryfields() throws InterruptedException{
		   
		   ENTRFIRSTNAME.sendKeys("David");
		   ENTRLASTNAME.sendKeys("BEHKAM"); 
		   Thread.sleep(2000);
		   Select sel = new Select(SELECTGENDER); 
		   Thread.sleep(2000);
		   sel.selectByVisibleText("Male");  
		   Thread.sleep(2000);
		   Actions actions = new Actions(driver);
		   actions.moveToElement(Savebutton).perform();
		   Savebutton.click();
		   Thread.sleep(12000);
		   WebElement plabel = driver.findElement(By.linkText("Patients"));
		  //CLICK ON PATIENT PAGE LABEL
		   WebDriverWait wait = new WebDriverWait(driver, 60);
		   wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(plabel))
		   .click();
		   
	
		   
	   }
	   
	   public void AddPatientFirstNameOnSortingOrder() throws InterruptedException{
		   
		   ENTRFIRSTNAME.sendKeys("1");
		   ENTRLASTNAME.sendKeys("1"); 
		  //Add New
		   PHONENO.sendKeys("1111111111");
		   Thread.sleep(2000);
		   Select sel = new Select(SELECTGENDER); 
		   Thread.sleep(2000);
		   sel.selectByVisibleText("Male");  
		   Thread.sleep(2000);
		   Actions actions = new Actions(driver);
		   actions.moveToElement(Savebutton).perform();
		   Savebutton.click();
		   Thread.sleep(10000);
		   try {
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
				Thread.sleep(1000);
		   patientlabel.click();
		
		  
	   }
	   
	   
	   public void  AlphabeticallytAddPatientFirstNameOnSortingOrder() throws InterruptedException{
		   
		//   ENTRFIRSTNAME.sendKeys("Z"); 
		   driver.findElement(By.xpath("//input[contains(@name,'FirstName')]")).sendKeys("Zzzz");
		   Thread.sleep(2000);
	//	   ENTRLASTNAME.sendKeys("Z"); 
		   driver.findElement(By.xpath("//input[contains(@name,'LastName')]")).sendKeys("Zzzz");
		   Thread.sleep(2000);
	        Select sel = new Select(driver.findElement(By.cssSelector("#Gender"))); 
		   Thread.sleep(2000);
		   sel.selectByVisibleText("Male");  
		   Thread.sleep(2000);
		   Actions actions = new Actions(driver);
		   actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Save')]"))).perform();
		//   Savebutton.click();
		   driver.findElement(By.xpath("//a[contains(text(),'Save')]")).click();
		   Thread.sleep(10000);
		   
		//   patientlabel.click() ;
		   driver.findElement(By.xpath("//a[text()=' Patients']")).click();
		   
		   
	   }
	   
	  
	   public WebElement addpatientpagetitle (){
		   
		 //  addpatienttitle.getText();
		   return addpatienttitle;
		   
	   }
	   
	   //SORTING NAME ON CLCIKING FIRST NAME AND LAST NAME
	   
	   public WebElement FirstNamesortingBy1() throws InterruptedException{
		   
		   //SortingBy_1_ClickFirstName.getText()
		   return SortingBy_1_ClickFirstName;
		        
	   }
	   public WebElement FirstNameClick(){
		   
		//   ClickableFirstName.click();
		   return ClickableFirstName;
	   }
	   
	   
       public WebElement FirstNamesortingByZ() throws InterruptedException{
		   
    	   // SortingBy_Z_ClickFirstName.getText();
		   return SortingBy_Z_ClickFirstName;
		      
	   }
	   
	   //Sorting By lastname 
       
       public WebElement LastNameByInt(){
    	   
         //SortingBy_1_ClickLastName.getText()
    	   
    	   return SortingBy_1_ClickLastName;
       }
     
	   public WebElement LastNameclick(){
		   
		   return ClickableLastName;
		
		//  ClickableLastName.click();
		  
	   }
       
       public WebElement LastNamesortingByZ(){
		   
       // SortingBy_Z_ClickLastName.getText()
		   
		   return SortingBy_Z_ClickLastName;
		      
	   }
	   
       
	
	
}

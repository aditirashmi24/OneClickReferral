package com.ocr.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;

import junit.framework.Assert;

public class InviteColleaguespage  extends TestBase {
     
	
	
	//SEARCH COLLEAGUES ICON  
    @FindBy(how=How.LINK_TEXT,using="Search Colleague") 
    @CacheLookup 
    WebElement SearchColleaguesIcon;   
    
  //SEARCH COLLEAGUES PAGE TITLE; 
  	@FindBy(how=How.XPATH,using="(//h1[contains(text(),'Search Colleagues')])[2]")
  	@CacheLookup 
  	WebElement searchcolleagues;
    
    
    //COLLEAGUE ICON 
    @FindBy(how=How.LINK_TEXT,using="Colleague")
	@CacheLookup
	WebElement ColleagueIcon; 
    
    //SEND INVITES BUTTON  
    @FindBy(how=How.ID,using="Sendinvitebtn")
	@CacheLookup  
	WebElement SendButton ;
	
    //Click here to download example template file. 
    @FindBy(how=How.LINK_TEXT,using="Click here to download example template file.")
	@CacheLookup 
	WebElement Clickheretodownloadexampletemplatefilelink;
	
    //UPLOAD FILES BUTTON 
    //@FindBy(how=How.CSS,using="#patientExcelUpload")
    @FindBy(how=How.XPATH,using="//*[@id=\"uploadFiles\"]/div")
    @CacheLookup 
    WebElement UploadFiles; 
    
    //DELETE BUTTON FOR UPLOADED FILES 
    @FindBy(how=How.LINK_TEXT,using="Delete")
    @CacheLookup 
    WebElement Deletebtn;
    
    //VALIDATION MESSAGE APPEARS AFTER UPLOADING INVALID FORMAT FILE 
    @FindBy(how=How.XPATH,using="//p[contains(text(),'Upload .xlsx or .xls file')]")
    @CacheLookup  
    WebElement valdmsgafterupldinvalidfile;
    
    //OK BUTTON ON POPUP WINDOW 
    @FindBy(how=How.CSS,using="#btn_no")
    @CacheLookup
    WebElement okbtnonpopup;
    
    //DELETE BUTTON ON UPLOADED FILE 
    @FindBy(how=How.CLASS_NAME,using="ico-delete")
    @CacheLookup 
    WebElement deletebtn;
    
    //YES BUTTON ON "Are you sure you want to remove?" POPUP
    @FindBy(how=How.ID,using="btn_yes_cd")
    @CacheLookup 
    WebElement yesbtnondelpopup;
    
  //  @FindBy(how=How.XPATH,using="//span[contains(text(),'Attachment deleted successfully')]")
    @FindBy(how=How.CLASS_NAME,using="message")
    @CacheLookup
    WebElement successmsg;
    
    // 
   // @FindBy(how=How.CLASS_NAME,using="select2-selection select2-selection--multiple")
    @FindBy(how=How.ID,using="dvInviteColleagues")
    @CacheLookup 
    WebElement emailsearchfield;
    
    
    //USER IS ALREADY YOUR COLLEAGUE MESSAGE
    @FindBy(how=How.XPATH,using="//td[contains(text(),'This user is already your colleague.')]")
    @CacheLookup 
    WebElement alreadyyourcolleaguesmessage; 
    
    //INVITED SUCCESSFULLY MESSAGE  
    @FindBy(how=How.XPATH,using="//td[contains(text(),'Invited Successfully')]")
    @CacheLookup 
    WebElement Invitedsuccessfully; 
    
    //This user does not exist in our system. Message 
    @FindBy(how=How.XPATH,using="//td[contains(text(),'This user does not exist in our system.')]")
    @CacheLookup 
    WebElement doesnotexistmessage; 
    
    //INITIALIZE ALL OBJECTS--------------------------------------
    
    
    public InviteColleaguespage(){
    	
 
    	PageFactory.initElements(driver, this);
		
    }
  
    //----**************ACTIONS*************----------------------     
    
    //SEARCH COLLEAGUES ICON 
    public WebElement SearchColleaguesIcon(){
    	
        return	SearchColleaguesIcon;
    	
    }
    //SEARCH COLLEAGUES PAGE TITLE 
    public WebElement SearchColleaguesTitle(){
    	
    	// searchcolleagues.getText();
    	return searchcolleagues ;
    }
  
    
    //COLLEAGUES ICON  
    public WebElement ColleaguesIcon(){
    	
      return ColleagueIcon;
	
    	
    } 
    
    public WebElement ColleaguesIcon1(){
    	
         return	driver.findElement(By.linkText("Colleague"));
    	
    } 
 
    
    //COLLEAGUES PAGE TITLE  
    public String ColleguesPageTitle(){
    	
    	return driver.getTitle();
    	
    }
    
    
    //SENDD INVITES BUTTON 
    public WebElement SendInvitesButton(){
    	
        return 	SendButton;
		
    }
    public WebElement SendInvitesButton1(){
    	
       WebElement click =  driver.findElement(By.id("Sendinvitebtn")) ;
        return click ;
         
    }
    //VALIDATION MESSAGE AFTER CLICKING ON SUBMIT BUTTON WITHOUT UPLOADING FILE OR EMAIL 
    public WebElement ValidationMessageAfterClickOnSendInvitesButton(){
	
   //	driver.findElement(By.xpath("//span[contains(text(),'Please enter email or upload excel file.')]")).getText();
     WebElement text = driver.findElement(By.xpath("//span[contains(text(),'Please enter email or upload excel file.')]"));
      return text ;
     
    }
    
  
    //CLICK HERE TO DOWNLOAD EXAMPLE TEMPLETE FILE LINK
    
    public WebElement Clickheretodownloadexampletemplatefilelink(){
    	
    //	Clickheretodownloadexampletemplatefilelink.click();
    	return Clickheretodownloadexampletemplatefilelink ;
    	
    }
    
    //UPLOAD FILES BUTTON 
    
    public WebElement UploadFilesBtn(){
    	
         Actions action = new Actions (driver);
		 action.moveToElement(UploadFiles).perform();
         
		 return UploadFiles; 
    } 
    
    public WebElement UploadFilesBtn1(){
    	
        Actions action = new Actions (driver);
		 action.moveToElement(UploadFiles).perform();
        
		 return UploadFiles; 
   } 
    
    //DELETE BUTTON FOR FOR UPLOADED FILES  
    
    public WebElement Deletebutton(){
    	
     return	Deletebtn;
    	
    	
    }
    
    //IS FILE DOWNLOADED    
    public Boolean isFileDownloaded_Ext(String dirPath,String ext){
    	
    	boolean flag = false; 
    	
    	File dir = new File(dirPath);
    	
    	File[] files = dir.listFiles();
    	
    	if(files == null || files.length ==0){
    		
    		flag = false;
    	}
    	
    	for(int i=1; i < files.length; i++){
    		
    		if(files[i].getName().contains(ext))
    		
    		     flag = true;
    		
    	}
    	
    	return flag;
    	
    }
    
    //VALIDATION MESSAGE ON UPLOADING INVALID FILE 
    public WebElement  valdmsgafteruploadinginvalidfile(){
    //	valdmsgafterupldinvalidfile.getText()
      return valdmsgafterupldinvalidfile;
    //  return driver.findElement(By.xpath("//p[contains(text(),'Upload .xlsx or .xls file')]")).getText();
             
    }
    
    //OK BUTTON APPEAR ON VALIDATION MESSAGE POPUP BOX 
    
    public WebElement okbtn(){
    	
    	return okbtnonpopup;
    }
    
    public WebElement deletebtn(){
    	
      //	deletebtn.click();
      return deletebtn ;	
    	
    }
    public WebElement yesbtnondelpopup(){
    	
        return	yesbtnondelpopup;
    	
    }
    
    public WebElement deletefilesuccessmsg(){
    	
    	return  successmsg;
    	
    }    
    
    public WebElement searchfieldoninvitecolleaguepage() throws InterruptedException{
    	
    //	driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(prop.getProperty("Anycolleageemail")); 
    	WebElement searchfield = driver.findElement(By.cssSelector(".select2-search__field")); 
    	return searchfield ;
    	
    }
    public WebElement searchfieldoninvitecolleaguepage1(){
    	
    	WebElement Srchfield =  driver.findElement(By.cssSelector(".select2-search__field")); 
    	return Srchfield;  
    	
    //	  driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(prop.getProperty("Anycolleageemail3"));
    	
    }
    
    public WebElement searchfieldoninvitecolleaguepage2(){
    	
       WebElement Srchfield =	driver.findElement(By.cssSelector(".select2-search__field"));
     //  driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(prop.getProperty("Anycolleageemail2")); 
       return Srchfield;
    	
    	
    }
    //NON-EXISTING USER EMAIL ID    
    public WebElement nonexistinguseremailid(){
    	
    	WebElement nonemail = driver.findElement(By.cssSelector(".select2-search__field"));
    	 
   // 	driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(prop.getProperty("Nonexistingemail"));
    	return nonemail ;
    	
    }
   
    
    public WebElement autopopulatedeappearedeamil(){
    	
       WebElement text = driver.findElement(By.cssSelector("#select2-ddlEmail-results > li"));
    	return text ;
    }
    
    //APPEARED EMAIL ON INVITE EMAIL PAGE
    
    public String afterselectaultopopultaedemail(){
    	
    	return driver.findElement(By.xpath("(//li[@class='select2-selection__choice'])[1]")).getAttribute("title");
    	
    }
    
    //SEND INVITES BUTTON ON COLLEAGUE PAGE 
    
    public WebElement  Sendinvitesbuttononcolleaguespage(){
    	
      WebElement btn = driver.findElement(By.xpath("//*[@id=\"Sendinvitebtn\"]"));
    	return btn ;
    }
    
    
    
    //USER IS ALREADY YOUR COLLEAGUE MESSAGE
    
    public WebElement userisalreadyyourcolleaguesmessage(){
    	
    	 alreadyyourcolleaguesmessage.getText();
    	
    	return alreadyyourcolleaguesmessage;
    	
    }
   
    //INVITED SUCCESFULLY MESSAGE 
    
    public WebElement invitedsuccesfullymessage(){
    	
    	return Invitedsuccessfully;
    
    } 
    
    public WebElement invitedsuccesfullymessage1(){
    	
      WebElement elm = driver.findElement(By.xpath("(//td[contains(text(),'Invited Successfully')])[1]"));
      return elm;
      
    
    } 
    
    
    //IS MESSAGE APPEARED AFTER CLICK ON SEND INVITES BUTTON 
    
    
    //SEARCH FIELD ON COLLEAGUE PAGE 
    
   public WebElement searchfieldoncolleaguepage(){
	   
	//   driver.findElement(By.xpath("//*[@id=\"txtSearchColleagues\"]")).sendKeys(prop.getProperty("Addedcolleagname5"));
	   WebElement text =  driver.findElement(By.xpath("//*[@id=\"txtSearchColleagues\"]"));
	   
	   return text ;
   }
   
   public void searchfieldoncolleaguepage2(String serchcolleague){
	   
	   driver.findElement(By.xpath("//*[@id=\"txtSearchColleagues\"]")).sendKeys(serchcolleague);
	   
   }
   
   
   public WebElement searchbtn(){
	   
	   
	      WebElement serch = driver.findElement(By.className("icon-search")) ;
	   
	      return serch ;
	      
	   
	 
	 //  driver.findElement(By.className("icon-search")).click();
	   
   }
   
   //Does not exist message  
   public WebElement Valdoesnotexistmessage(){
	   
	   return doesnotexistmessage;
	   
   }
   
    public WebElement Valdoesnotexistmessage1(){ 
    	
    	//gettext();
	   
	   WebElement text = driver.findElement(By.xpath("//td[contains(text(),'This user does not exist in our system.')]"));
	   return text ;
   }
   
   //LOGED IN USER EMAIL ID      
    public WebElement Logedinuseremailid(){
    	
    //	driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(prop.getProperty("loggedinuseremailid"));
       WebElement emailid = driver.findElement(By.cssSelector(".select2-search__field")) ; 
       return emailid ;
    	
    }
    
    public WebElement autopopulated_logedinuser_appearedeamilid(){
    	
        WebElement emailid =	driver.findElement(By.cssSelector("#select2-ddlEmail-results > li"));
    	return emailid ;
    	
    }
    //VALIDATE LOGED IN  USER EMAIL ID 
    
    public WebElement validateappearedlogedinuseremailid(){
    	
    	WebElement val = driver.findElement(By.xpath("//td[contains(text(),'This Email id Is yours, so you cannot invite yourself.')]"));
    	
    	return val;
    	
    }
    
    //TEAM-MEMBER EMAIL ID
    public WebElement TeamMemberemailid(){
    	
        WebElement 	teammbr = driver.findElement(By.cssSelector(".select2-search__field"));
     //   driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(prop.getProperty("TeamMemberemailid")); 
        return teammbr ;
        
    }
    
    //STAFF-MEMBER EMAIL ID
    public WebElement  StaffMemberemailid(){
    	
    //	driver.findElement(By.cssSelector(".select2-search__field")).sendKeys(prop.getProperty("StaffMemberemailid"));
    	
    	WebElement staffmmberemailid = driver.findElement(By.cssSelector(".select2-search__field")) ; 
    	return staffmmberemailid ; 
    	
    }  
    
    //VALIDATE STAFF-MEMBER EMAIL ID 
    
    public WebElement validatmsgappearedonstaffmemberemailid(){
    	
    	
    // driver.findElement(By.xpath("//td[contains(text(),'This is a Staff Member, so cannot be added as a Colleague.')]")).getText();
    	
    	WebElement text =driver.findElement(By.xpath("//td[contains(text(),'This is a Staff Member, so cannot be added as a Colleague.')]"));
    	
    	return text ;
    	
    }
    
    //HEMBURGER ICON ON COLLEAGUES PAGE 
    
    public WebElement Hemburgericononcolleaguepage(){
    	
    	
        WebElement Hemburger = driver.findElement(By.cssSelector(".fa-ellipsis-v"));
    	return Hemburger ;
    	
    }
    //ADDCOLLEAGUE BUTTON ON COLLEAGUES PAGE 
    
    public WebElement AddcolleaguebuttonOncolleaguepage(){
    	
        WebElement Addcollegbtn = driver.findElement(By.xpath("//a[contains(text(),'Add Colleague')]"));
    	return Addcollegbtn ;
    }
    
    //INVITE BY EMAIL ICON ON COLLEAGUES PAGE  
    
    public WebElement InvitecolleaguesiconOncollegauespage(){
    	
       WebElement Invitecollicon = driver.findElement(By.linkText("Invite by Email"));
      return Invitecollicon ;
    	
    	
    	
    }
    //SELECT DELETE OPTION IN COLLEAGUES PAGE  
    //DELETE OPTION IN SELECTACTION 
    public void selectdeleteoption1() throws InterruptedException{
    	
    	Select drop = new Select(driver.findElement(By.xpath("//select[@class='form-control height34']")));
		drop.selectByVisibleText("Delete");
		Thread.sleep(4000); 
		
    }
    
    //YES BUTTON WHEN DELETE COLLEAGUE ON COLLEAGUE PAGE  
  //CLICK ON YES BUTTON  
    public WebElement yesbutton1(){
         
    	WebElement click = driver.findElement(By.xpath("//button[contains(text(),'Yes')]")) ;  
    	
    	return click ;
    	
    
   // 	driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
    	
    }
    
    //---***VERIFY EMAIL---****
    
  /*  public static boolean verifyMail(String userName, String password, String message) {
		Folder folder = null;
		Store store = null;
		System.out.println("***READING MAILBOX...");
		try {
			
			prop.put("mail.store.protocol", "imaps");
			Session session = Session.getInstance(prop);
			store = session.getStore("imaps");
			store.connect("imap.gmail.com", userName, password);
			folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			Message[] messages = folder.getMessages();
			System.out.println("No of Messages : " + folder.getMessageCount());
			System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
			for (int i = 0; i < messages.length; i++) {
				System.out.println("Reading MESSAGE # " + (i + 1) + "...");
				Message msg = messages[i];
				String strMailSubject = "", strMailBody = "";
				// Getting mail subject
				Object subject = msg.getSubject();
				// Getting mail body
				Object content = msg.getContent();
				// Casting objects of mail subject and body into String
				strMailSubject = (String) subject;
				//---- This is what you want to do------
				if (strMailSubject.contains(message)) {
					System.out.println(strMailSubject);
					break;
				}
			}
			return true;
		} catch (MessagingException messagingException) {
			messagingException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			if (folder != null) {
				try {
					folder.close(true);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (store != null) {
				try {
					store.close();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;     	
    	//-----*********************OR***************---    
    	
    	
try{
			
			Properties props = new Properties();
			//set email protocol to IMAP
			props.put("mail.store.protocol", "imaps");
			//set up the session
			Session session = Session.getInstance(props);
			Store store = session.getStore("imaps");
			//Connect to your email account
			store.connect("imap.gmail.com",userName, "password");
			//Get reference to your INBOX
			Folder folder = store.getFolder("INBOX");
			//Open the folder in READ MODE only
			folder.open(Folder.READ_ONLY);
			//Get all the messages in INBOX into Message array
			Message[] messages = folder.getMessages();
			
			//Loop through all the messages in your INBOX
			for(int i=0;i<messages.length-1;i++){
				
				//Get reference to message#i in your INBOX
				Message msg = messages[i];
				
				//Fetch the subject and content into string variables
				String mailSubject = (String)msg.getSubject();
				String mailContent = (String)msg.getContent();
				
					
				//print the subject and content on console
				System.out.println(mailSubject);
				System.out.println(mailContent);
				
			}
			
		}catch(MessagingException ME){
			ME.printStackTrace();
			
		}catch(Exception E){
			E.printStackTrace();
			
		}
		
		
	}
    	*/
        public WebElement enterperonalnoteininInviteColleaguespage(){
        	
      //  	driver.findElement(By.xpath("//*[@id=\"txtMessage\"]")).sendKeys(prop.getProperty("enterperonalnoteininInviteColleaguespage"));	
        	WebElement text = driver.findElement(By.xpath("//*[@id=\"txtMessage\"]"));
        		//	.sendKeys(prop.getProperty("enterperonalnoteininInviteColleaguespage"));
        	return text ;
        }
    
         //ADDED YOU AS A COLLEAGUE ON RECORDLINC
        public String YopmailTitleAddedAsYouColleagueMessage() throws InterruptedException{
        	//driver.findElement(By.cssSelector("#m1 > div > a > span.lms")).click();
        	driver.findElement(By.xpath("(//Span[contains(text(),'Levin Q added you as a colleague on RecordLinc')])[1]")).click();
        	Thread.sleep(2000);
        	return driver.findElement(By.xpath("(//Span[contains(text(),'Levin Q added you as a colleague on RecordLinc')])[1]")).getText();
            // return driver.findElement(By.cssSelector("#m1 > div > a > span.lms")).getText();	
        
        }
        
         
        
   
    	public void verifymail() throws InterruptedException{
    		WebDriverWait wait=new WebDriverWait(driver, 30);
    		driver.get("http://www.yopmail.com/");
    		
    		
    		//WebElement element = driver.findElement(By.linkText("www.yopmail.com"));  
	    //	((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", element);
    		
    		
			WebElement Searchfield = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login"))); 
			Searchfield.click();
			
    		Searchfield.sendKeys(prop.getProperty("Anycolleageemail3")); 
    		
    		
  
    		WebElement Checkinboxbutton = wait.until(ExpectedConditions.elementToBeClickable(By.className("sbut")));
    		Checkinboxbutton.click();
    		Thread.sleep(5000);
    		
    	//	WebElement msg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Levin Q added you as a colleague on RecordLinc')]")));
    	    
    		//return msg.getText(); 
    	    
    		//
    		//return text ;
    		//return driver.findElement(By.className("f16")).getText();
    	}
       
    	//Invited user email
    	
    	public boolean inviteduserreciveemail(String collemail){
    		
    		
  		  Folder folder = null ;
  		
  		  Store store = null;
  		
  		
  		  System.out.println("***READING MAILBOX...");
  			try {
  				
  				prop.put("mail.store.protocol", "yopmail");
  				Session session = Session.getInstance(prop);
  				store = session.getStore("yopmail");
  				store.connect("http://www.yopmail.com/",collemail);
  				folder = store.getFolder("INBOX");
  				folder.open(Folder.READ_ONLY);
  				Message[] messages = folder.getMessages();
  				System.out.println("No of Messages : " + folder.getMessageCount());
  				System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
  				for (int i = 0; i < messages.length; i++) {
  					System.out.println("Reading MESSAGE # " + (i + 1) + "...");
  					Message msg = messages[i];
  					String strMailSubject = "Hi dentist Vivek", strMailBody = "Hi dentist Vivek";
  					// Getting mail subject
  					Object subject = msg.getSubject();
  					// Getting mail body
  					Object content = msg.getContent();
  					// Casting objects of mail subject and body into String
  					strMailSubject = (String) subject;
  					//---- This is what you want to do------
  					if (strMailSubject.contains(prop.getProperty("enterperonalnoteininInviteColleaguespage"))) {
  						System.out.println(strMailSubject);
  						break;
  					}
  				}
  				return true;
  			} catch (MessagingException messagingException) {
  				messagingException.printStackTrace();
  			} catch (IOException ioException) {
  				ioException.printStackTrace();
  			} finally {
  				if (folder != null) {
  					try {
  						folder.close(true);
  					} catch (MessagingException e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}
  				}
  				if (store != null) {
  					try {
  						store.close();
  					} catch (MessagingException e) {
  						// TODO Auto-generated catch block
  						e.printStackTrace();
  					}
  				}
  			}
  			return false;
  		
  		
  	}

    	
    	
    	public void waitForElementTextEqualsString(WebElement element, String expectedString) {
    		WebDriverWait wait=new WebDriverWait(driver, 30);
    		
    		
    	   	waitForElementTextEqualsString(element, expectedString);
    		
   
    		}
    	
    	public WebElement ValMsgAfterclickonBothEmailandUploadfile(){
    		
    		
    		WebElement text = driver.findElement(By.xpath("//span[contains(text(),'Please enter either email or upload excel file.')]"));  
    		
    		return text ;
    		
            	
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
    	
    	
    	
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


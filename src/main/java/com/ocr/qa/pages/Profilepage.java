package com.ocr.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ocr.qa.base.TestBase;

public class Profilepage extends TestBase {

	//***** P A G E - F A C T O R Y ***** 
	
	
	//ADD IMAGE ICON 
	@FindBy(how=How.XPATH,using="//*[@id=\"wizard\"]/div[2]/div[1]/div[2]/a/div/img")
	@CacheLookup
	WebElement ImageICON;  
    
	//UPLOAD PROFILE PICTURE POPUP TITLE 
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Upload Profile Picture')]")
//	@FindBy(how=How.CSS,using="#addLogo > div > div > div > h3")
	@CacheLookup
	WebElement Popuptitle ;
	
	//SAVE BUTTON   
	@FindBy(how=How.CSS,using="#btnSave > i")
	@CacheLookup
	WebElement savebtn; 
	
	//VALIDATION MESSAGE  
	@FindBy(how=How.XPATH,using="//span[@type='text' and @class='alert-danger']")
	@CacheLookup
	WebElement valdnmssg;
	
	//CHOOSE FILE 
   //@FindBy(how=How.CSS,using="#fuImage")
	@FindBy(how=How.XPATH,using="//*[@id=\"frmProfileImage\"]/div[1]/div[2]/div/ul")
	@CacheLookup
	WebElement choosefilebtn;
	
	//VALIDATION MESSAGE ON CHOOSING INVALID FILE 
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement valdinvalidfile;
	
	//SUCCESS MESSAGE ON CHOOSING VALID FILE 
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement successmsgvalidfile;
	
	//REMOVE BUTTON ON UPLOAD PROFILE PICTURE POPUP 
	@FindBy(how=How.CSS,using="#btnRemoveImage")
	@CacheLookup 
	WebElement removebtn ;
	
	//CONFIRMATION MESSAGE AFTER CLICK ON REMOVE BUTTON 
	@FindBy(how=How.XPATH,using="//p[contains(text(),'Are you sure you want to remove?')]")
	@CacheLookup 
	WebElement confirmsg ;
	
	//YES BUTTON ON CONFIRMATION 
	@FindBy(how=How.CSS,using="#btnyes")
	@CacheLookup 
	WebElement yesbtn ;
	
	//VALIDATION MESSAGE AFTER REMOVE FILE 
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement rfilevaldmsg;
	
	//EDIT BUTTON ON PROFILE PAGE 
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Edit') and @class='btn btn-default btn1 btn_editpersonal_info'])[1]")
	@CacheLookup 
	WebElement editbtn;
	
	//EDIT PERSONAL INFORMATION POPUP TITLE 
	@FindBy(how=How.XPATH,using="(//h3[contains(text(),'Edit Personal Information')])[1]")
	@CacheLookup 
	WebElement editprsninftitle;
	
	//FIRST NAME ON EDIT PERSONAL INFORMATION POPUP 
	@FindBy(how=How.XPATH,using="//*[@id=\"FirstName\"]")
	@CacheLookup 
	WebElement firstnameoneditpopup;
	
	//LAST NAME ON EDIT PERSONAL INFORMATION POPUP 
	@FindBy(how=How.XPATH,using="//*[@id=\"LastName\"]")
	@CacheLookup 
	WebElement lastnameoneditpopup;
	
	//VALIDATION MESSAGE APPEARS ON FIRST NAME  
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement valdmsgonfirstname;
	
	//VALIDATION MESSAGE APPEARS ENTER FIRST NAME WITH CHARACTERS AND NUMBER 
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement valdmsgonfirstnamewithNumber;
	
	//SAVE BUTTON UNDER EDIT PERSONAL INFORMATION POPUP 
	@FindBy(how=How.XPATH,using="//*[@id=\"personal_information\"]/div/div/div[3]/div/button[2]")
	@CacheLookup 
	WebElement savebtnunderEditpersonalinfpopup;
	
	//SELECT SPECALITY 
	@FindBy(how=How.XPATH,using="//*[@id=\"personal_information\"]/div/div/div[2]/div/div/div[6]/div/span/span[1]/span/ul")
	@CacheLookup 
	WebElement selectspecality;
	
	//VALIDATION MESSAGE AFTER UPDATE PERSONAL INFORMATION 
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement valdmsgafterupdatepersonalinfo;
	
	//ADD BUTTON UNDER LOCATION SECTION
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Add') and @class='btn btn-default btn1 '])[1]")
	@CacheLookup 
	WebElement AddbtnUnderLocation;
	
	//VALIDATE ADD ADDITIONAL ADDRESS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//h3[contains(text(),'Add Additional Address')]")
	@CacheLookup 
	WebElement Addadditionaladdresspopuptitle;
	
	//LOCATION FIELD UNDER ADD ADDITIONAL ADDRESS POPUP
	@FindBy(how=How.CSS,using="#Location")
	@CacheLookup
	WebElement Locationfield;
	
	//SAVE BUTTON UNDER ADD ADDITIONAL ADDRESS POPUP 
	@FindBy(how=How.CSS,using="#btn_address")
	@CacheLookup
	WebElement SaveBtn;
	
	//VALIDATION MESSAGE APPEARS ON LEAVING LOCATION MANDATORY FIELD BLANK UNDER ADD ADDITIONAL ADDRESS POPUP  
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement valdmsgafterleavingmanblank;
	
	//VALIDATION MESSAGE ON INVALID ZIP CODE 
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement valdmsgonZIPcode;
	
	//MAKE PRIMARY ADDRESS 
	@FindBy(how=How.XPATH,using="//*[@id=\"addional-address\"]/div/div/div[2]/div/div/div[15]/span")
	@CacheLookup 
	WebElement primaryaddrsscheckbox;
	
	//SUCCESS MESSAGE AFTER ADDING DETAILS UNDER ADD ADDITIONAL ADDRESS POPUP 
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement succmsg;
	
	//EDIT ICON UNDER LOCATION 
	@FindBy(how=How.XPATH,using="(//i[@class='ico-edit'])[1]")
	@CacheLookup 
	WebElement editiconunderlocation;
	
	//EDIT ICON UNDER SECONDARY LOCATION
//	@FindBy(how=How.XPATH,using="(//i[@class='ico-edit'])[3]")
	@FindBy(how=How.XPATH,using="(//i[@class='ico-edit']//ancestor::div[@class='info-box3'])[last()]")
	@CacheLookup 
	WebElement editiconunderSECONDARYlocation;
	
	//EDIT PRIMARRY ADDRESS POPUP  
	@FindBy(how=How.XPATH,using="(//h3[contains(text(),'Edit Primary Address')])[1]")
	@CacheLookup 
	WebElement editprimaryaddresspopuptitle;
	
	//REMOVE BUTTON UNDER EDIT PRIMARY ADDRESS POPUP 
//	@FindBy(how=How.CSS,using="#addional-address > div > div > div.modal-footer.bdr-top-no > div > button:nth-child(2)")
	@FindBy(how=How.XPATH,using="(//button[text()= 'Remove' and @type= 'button' ])[1]")
	@CacheLookup
	WebElement RemoveBtnEPAP;
	
	//YES BUTTON ON CONFIRMATION MESSAGE  
	@FindBy(how=How.XPATH,using="//a[@type='button' and @id='btnyes']")
	@CacheLookup
	WebElement Yesbtn;
	
	//VALIDATION MESAGGE AFTER CLICKING ON YES BUTTON UNDER EDIT PRIMARY ADDRESS POPUP  
	@FindBy(how=How.CLASS_NAME,using="message")
	@CacheLookup 
	WebElement ValdmsgafterClickYesBtnOnEditprimaryaddrspopup;
	
	//ADD BUTTON UNDER WEBSITE POPUP SECTION
  //  @FindBy(how=How.XPATH,using="(//a[contains(text(),'Add') and @class='btn btn-default btn1'])[1]")
    @FindBy(how=How.XPATH,using="//*[@id=\"wizard\"]/div[2]/div[5]/div[1]/div/div/div/a")
	@CacheLookup 
	WebElement AddbtnUnderWebsitePopup;
	
  //SAVE BUTTON UNDER WEBSITE POPUP SECTION 
  	@FindBy(how=How.CSS,using="#btn-website-up")
  	@CacheLookup
  	WebElement SaveBtnwebsitepopup;
      
   //SEND URL UNDER WEBSITE POPUP SECTION 
  	@FindBy(how=How.XPATH,using="//*[@id=\"txtNewWebsiteurls\"]")
	@CacheLookup 
	WebElement SendURLUnderWebsitePopup;
  	
   //EDIT WEBSITE ICON
  	@FindBy(how=How.XPATH,using="(//i[@class='ico-edit']//preceding::a[@href='#edit-primary-website-url' ])[last()]")
	@CacheLookup 
	WebElement EditWebsiteIcon;
  	
  //REMOVE BUTTON UNDER EDIT SECONDARY WEBSITE URL POPUP
  	@FindBy(how=How.XPATH,using="//*[@id=\"edit-primary-website-url\"]/div/div/div[3]/div/button[2]")
	@CacheLookup 
	WebElement RemoveBtnUndrSecWebURL;
  	
  //YES BUTTON AFTER CLICK ON REMOVE BUTTON UNDER EDIT SECONDARY WEBSITE URL POPUP 
  	@FindBy(how=How.XPATH,using="//*[@id=\"btnyes\"]")
	@CacheLookup 
	WebElement YESbtnUNDERRemoveBtnUndrSecWebURL;
  	
  //PRIMARY WEBSITE URL POPUP  EDIT ICON 	
  	@FindBy(how=How.XPATH,using="(//i[@class='ico-edit']//preceding::a[@href='#edit-primary-website-url' ])[1]")
	@CacheLookup 
	WebElement PrimaryWebsiteUrlEditIcon;
  	
  //EDIT ICON IN SOCIAL MEDIA SECTION 
  	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Edit') and @class='btn btn-default btn1'])[1]")
	@CacheLookup 
	WebElement EditIconInSocialMedia;
  	
  //FACEBOOK TEXT FIELD UNDER SOCIAL MEDIA SECTION  
  	@FindBy(how=How.CSS,using="#FacebookUrl")
	@CacheLookup 
	WebElement FacebookUrlFieldInSocialMedia;
  	
  //TWITTER TEXT FIELD UNDER SOCIAL MEDIA SECTION  
  	@FindBy(how=How.CSS,using="#TwitterUrl")
	@CacheLookup 
	WebElement TwitterUrlFieldInSocialMedia;
  	
  //INSTAGRAM TEXT FIELD UNDER SOCIAL MEDIA SECTION  
  	@FindBy(how=How.CSS,using="#InstagramUrl")
	@CacheLookup 
	WebElement InstagramUrlFieldInSocialMedia;
  	
  //LINKEDIN TEXT FIELD UNDER SOCIAL MEDIA SECTION  
  	@FindBy(how=How.CSS,using="#LinkedinUrl")
	@CacheLookup 
	WebElement LinkedINUrlFieldInSocialMedia;  
  	
  //GOOGLEPLUS TEXT FIELD UNDER SOCIAL MEDIA SECTION  
  	@FindBy(how=How.CSS,using="#GoogleplusUrl")
	@CacheLookup 
	WebElement GooglePlusUrlFieldInSocialMedia;  
  	
  //PINTEREST TEXT FIELD UNDER SOCIAL MEDIA SECTION  
  	@FindBy(how=How.CSS,using="#PinterestUrl")
	@CacheLookup 
	WebElement PintrestUrlFieldInSocialMedia;  	
  	 
  //PINTEREST TEXT FIELD UNDER SOCIAL MEDIA SECTION  
  	@FindBy(how=How.CSS,using="#YoutubeUrl")
	@CacheLookup 
	WebElement YoutubeUrlFieldInSocialMedia;  	
  
  //BLOG TEXT FIELD UNDER SOCIAL MEDIA SECTION  
  	@FindBy(how=How.CSS,using="#BlogUrl")
	@CacheLookup 
	WebElement BlogUrlFieldInSocialMedia;    
  	
  //YELP TEXT FIELD UNDER SOCIAL MEDIA SECTION  
  	@FindBy(how=How.CSS,using="#YelpUrl")
	@CacheLookup 
	WebElement YelpUrlFieldInSocialMedia;   
  	
  //SAVE BUTTON UNDER SOCIAL MEDIA SECTION 
  	@FindBy(how=How.CSS,using="#btn-save-social-media")
  	@CacheLookup
  	WebElement SaveBtnUnderSocialMediaSection;
  	
  //FACEBOOK ICON UNDER SOCIAL MEDIA SECTION 
  	@FindBy(how=How.XPATH,using="//i[@class='fa fa-facebook']")
	@CacheLookup 
	WebElement FacebookIconUnderSocialMediaSection;
  	
  //EDIT BUTTON UNDER DECCRIPTION SECTION
  	@FindBy(how=How.XPATH,using="//*[@id=\"descriptionAddEdit\"]")
  	@CacheLookup
  	WebElement EditButtonUnderDescriptionSection;
  	
  //TEXT FIELD UNDER DECCRIPTION SECTION 
  	@FindBy(how=How.CSS,using="#txtdescription")
  	@CacheLookup
  	WebElement TextFieldUnderDescriptionSection ;
  
   //SAVE BUTTON UNDER DECCRIPTION SECTION 
  	@FindBy(how=How.CSS,using="#btn-description")
  	@CacheLookup
  	WebElement SaveButtonUnderDescriptionSection ;
  	
    //REMOVE BUTTON UNDER DECCRIPTION SECTION 
  	@FindBy(how=How.CSS,using="#btn-des-removed")
  	@CacheLookup
  	WebElement RemoveButtonUnderDescriptionSection ;	
  	
    //YES BUTTON UNDER DECCRIPTION SECTION 
  	@FindBy(how=How.CSS,using="#btnyes")
  	@CacheLookup
  	WebElement YesButtonAfterRemoveUnderDescriptionSection ;
  	
  	//ADD BUTTON UNDER EDUCATION AND TRANING SECTION 
  	@FindBy(how=How.XPATH,using="(//a[@class='btn btn-default btn1'])[4]")
  	@CacheLookup
  	WebElement AddButtonAfterUnderEducationAndTrainingSection ;
  	
  	
    //INSITUTION ATTENDED TEXTFIELD UNDER EDUCATION AND TRANING SECTION 
  	@FindBy(how=How.XPATH,using="//*[@id=\"add-education-training-info\"]/div/div/div[2]/div/div[1]/span/span[1]/span")
  	@CacheLookup
  	WebElement InsitutionAttendedUnderEducationAndTrainingSection ;
  	
    //INSITUTION ATTENDED SEARCH-DROPDOWN FIELD UNDER EDUCATION AND TRANING SECTION 
  	@FindBy(how=How.XPATH,using="/html/body/span/span/span[1]/input")
  	@CacheLookup
  	WebElement SearchDropdownFieldUnderAddEducationTraningInforationSection ;
  	
  	//CLICK ON APPEARED SELECTED NAME IN SEARCH-DROPDOWN FIELD UNDER EDUCATION AND TRANING SECTION 
  	@FindBy(how=How.XPATH,using="//*[@id=\"select2-Institute-results\"]/li[1]")
  	@CacheLookup
  	WebElement ClickOnAppearedDropdownFieldUnderAddEducationTraningInforationSection ;
  	
  	
    //SAVE BUTTON UNDER ADD EDUCATION/TRANING INFORMATIION SECTION
  	@FindBy(how=How.XPATH,using="//*[@id=\"btn-saveEducation\"]")
  	@CacheLookup
  	WebElement SaveButtonUnderAddEducationTraningInforationSection ;
  	
    //ADDED INSITUTION ATTENDED EDIT ICON IN INSITUTION ATTENDED SECTION UNDER EDUCATION AND TRANING SECTION 
  	@FindBy(how=How.XPATH,using="(//a[@href='#edit-education-training-info'])[last()]")
  	@CacheLookup
  	WebElement AddedInsitutionAttendedNameUnderAddEducationTraningInforationSection ;
  	
  //REMOVE BUTTON UNDER EDIT EDUCATION/TRANING INFORMATION POPUP   
  	@FindBy(how=How.XPATH,using="(//button[contains(text(),'Remove')])[3]")
  	@CacheLookup
  	WebElement RemoveButtonUnderEditEducationTraningInforationSectionPopup ;
  	
  	
  	
	//INITIALIZE ALL OBJECTS------------------------------ 
	public Profilepage(){
			
		PageFactory.initElements(driver,this);
			
	}
		
	//CREATE A METHODS  
	
	//PROFILE IMAGE ICON
	public WebElement clickonImageicon(){
		
	   return ImageICON;
		
	}
	
	//VALIDATE UPLOAD PROFILE PICTURE POPUP TITLE 
	public WebElement Uploadprofilepicturetitle (){
		
		return Popuptitle;
			//	.getText();
	}
	//SAVE BUTTON ON POPUP PAGE  
	public WebElement savebutton(){
		
		WebElement element = savebtn;

		   Actions actions = new Actions(driver);
		   actions.moveToElement(element);
		   actions.perform();
		 
		 
		 return element;
		
	}
	
	//VALIDATION MESSAGE ON CLICKING SAVE BUTTON 
	public WebElement validmsg(){
		
		return valdnmssg ;
			//	.getText();
		
	}
	
	//CHOOSE FILE BUTTON 
	public WebElement choosefilebtn(){
			
		return choosefilebtn	;	
		
	 /*     WebElement element = choosefilebtn;

		   Actions actions = new Actions(driver);
		   actions.moveToElement(element);
		   actions.perform();
		 
		 
		 return element	;	*/
	    		
	}
	
	//VALIDATION MESSAGE ON CHOOSING INVALID FILE 
	
	public WebElement valdoninvalidfile(){
		
		return valdinvalidfile ;
			//	.getText();
	}
	
    //SUCCESS MESSAGE ON CHOOSING VALID FILE 
	
	public WebElement successmsgvalidfile(){
		
		return successmsgvalidfile ;
			//	.getText();
		
	}
	
	//REMOVE BUTTON ON UPLOAD PROFILE PICTURE POPUP 
	
	public WebElement removebtn(){
		
	    WebElement element = removebtn;

		   Actions actions = new Actions(driver);
		   actions.moveToElement(element);
		   actions.perform();
		 
		 return element ;
		
	}
	
	//CONFIRMATION MESSAGE APPEARS AFTER CLICKING ON REMOVE BUTTON 
	
	public WebElement RconfiramtionMessage(){
		
		return confirmsg;
		//		.getText();
		
	}
	
	//YES BUTTON ON CONFIRMATION MESSAGE 
	
	public WebElement Yesbutton(){
		
		return yesbtn;
	   //	.click();
		
	}
	
	//VALIDATION MESSAGE AFTER REMOVE FILE 
	
	public WebElement Successmessageafterremovefile(){
		
		return rfilevaldmsg ;
		//		.getText();
		
	}
		
     //EDIT BUTTON ON PROFILE PAGE 
	
	public WebElement Editbutton(){
		
	   WebElement element = editbtn;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	    return element ;
		
	}
	 
	//EDIT PERSONAL INFORMATION POPUP  
	
	public WebElement EditpersonalinformationPopupTitle() {
		
		return editprsninftitle ;
		//		.getText();
		
	}
		
	//FIRST NAME ON EDIT PERSONAL INFORMATION POPUP 
	
	public WebElement FirstNameOnEditpopup(){
		
	   return firstnameoneditpopup ;
		//  .clear();
		
	}
	
	//ENTER FIRST NAME WITH CHARACTERS AND NUMBER 
	
	public WebElement EnterFirstNameWithCharacterAndNumber(){
		
		return firstnameoneditpopup ;
	//	.sendKeys("jon12345");
		
	}
	
	//VALIDATION MESSAGE APPERAS PLEASE ENTER FIRST NAME  
	
	public WebElement ValidMessageOnFirstName(){
		
		return valdmsgonfirstname ;
		//		.getText();
		
	}
	
	//VALIDATION MESSAGE APPEARS ENTER FIRST NAME WITH CHARACTERS AND NUMBER 
    public WebElement ValidFirstNamewithCharacterandNumb(){
    	
    	return valdmsgonfirstnamewithNumber ;
    	    //		.getText();
    	
    }
	
    //SAVE BUTTON ON EDIT PERSONAL INFORMATION POPUP 
	
	public WebElement SavebtnUnderEditPersonalInfPopup(){
		
	   WebElement element = savebtnunderEditpersonalinfpopup;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	    return element ;
		
	}
		
	//ENTER FIRST NAME DETAILS 	
		
     public WebElement EnterFirstName(){
		
	   return firstnameoneditpopup ;
			//   .sendKeys("Levin");
		
	}	
	
	//ENTER LAST NAME DETAILS 
     
     public WebElement EnterLastName(){
    	 
    	return lastnameoneditpopup ;
    		//	.sendKeys("Q");
    	 
     }
	
	//CLEAR LAST NAME FIELD 
     
     public WebElement ClearLastName(){
    	 
    	return lastnameoneditpopup ;
    	  //  .clear();
     }
	
     //VALIDATION MESSAGE AFTER UPDATE PERSONAL INFORMATION 
     
     public WebElement valdmsgafterupdatepersonalinfo(){
    	 
    	 return valdmsgafterupdatepersonalinfo;
    		//	 .getText();
     }
     
     //ADD BUTTON UNDER LOCATION 
     
     public WebElement addbuttonunderlocation(){
    	 
    	return AddbtnUnderLocation ;
    	  //  .click(); 
     }
     
     //VALIDATE ADD ADDITIONAL ADDRESS POPUP TITLE
     
     public WebElement addadditionaladdresspopuptitle(){
    	 
    	 return Addadditionaladdresspopuptitle;
    		//	 .getText()
     }
     
     //CLEAR LOCATION FIELD UNDER ADD ADDITIONAL ADDRESS POPUP 
     
     public WebElement Clearlocationfieldunderaddaditionaladdresspopup(){
    	 
    	return Locationfield;
    	//  .clear();
    	 
     }
     
     //LOCATION FIELD UNDER ADD ADDITIONAL ADDRESS POPUP 
     
     public WebElement locationfieldunderaddaditionaladdresspopup(){
    	 
    	return Locationfield;
    	  //  .sendKeys("Sydeney");
    	 
     }
     
    //SAVE BUTTON UNDER ADD ADDITIONAL ADDRESS POPUP  
     
     public WebElement savebuttonunderaddaditionaladdresspopup(){
    	 
    	return SaveBtn; 
    	 //  .click();
   
     }
     
   //VALIDATION MESSAGE APPEARS ON LEAVING MANDATORY FIELD BLANK UNDER ADD ADDITIONAL ADDRESS POPUP  
     
     public WebElement validationmessageafterleavingmandatoryfieldblank(){
    	 
    	 return valdmsgafterleavingmanblank; 
    	 // .getText();
    	 
     }
     
     //ENTER LOCATION UNDER ADD ADDITIONAL ADDRESS POPUP  
     
     
    public WebElement enterlocationunderaddadditionaladdresspopup(){
    	
       WebElement elm =	driver.findElement(By.xpath("//*[@id=\"Location\"]")) ;
       return elm ;
    	 //.sendKeys("Denamrk");
       
    }
     
     
    //ENTER STREET ADDRESS UNDER ADD ADDITIONAL ADDRESS POPUP  
     
   public WebElement enterstreetAddressunderaddadditionaladdresspopup(){
	   
	    WebElement elm =  driver.findElement(By.xpath("//*[@id=\"ExactAddress\"]"));
	    return elm;
	    // .sendKeys("Street-121");
	   
   }
     
    //CITY UNDER ADD ADDITIONAL ADDRESS POPUP  
   
   public WebElement entercityAddressunderaddadditionaladdresspopup(){
	   
	  WebElement elm= driver.findElement(By.xpath("//*[@id=\"City\"]")); 
	   return elm;
		//	  .sendKeys("Denmark");
	   
   }
     
  //SELECT COUNTRY UNDER ADD ADDITIONAL ADDRESS POPUP      
     
  public void selectcountryunderaddadditionaladdresspopup(){
	  
	  Select sc = new Select(driver.findElement(By.xpath("//*[@id=\"Country\"]")));
	  sc.selectByVisibleText("Australia");
	  
  }
   
  //SELECT COUNTRY UNDER ADD ADDITIONAL ADDRESS POPUP      
  
  public void selectstateunderaddadditionaladdresspopup(){
	  
	  Select sc = new Select(driver.findElement(By.xpath("//*[@id=\"State\"]")));
	  sc.selectByVisibleText("Utah");
	  
  }
   
  //ZIP CODE UNDER ADD ADDITIONAL ADDRESS POPUP
  
  public WebElement Zipcodeunderaddadditionaladdresspopup(){
	  
	 WebElement elm = driver.findElement(By.xpath("//*[@id=\"Zipcode\"]"));
	 return elm;
	 // .sendKeys("12345");
	  
	 
  }
  
  //EMAIL UNDER ADD ADDITIONAL ADDRESS POPUP 
  
  public WebElement Emailunderaddadditionaladdresspopup(){
	  
	 WebElement elm = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
	  return elm;
		// .sendKeys("ocr@mail.com");
	  
  }
  
  //TIME ZONE UNDER ADD ADDITIONAL ADDRESS POPUP 
  
  public void SelectTimezoneunderaddadditionaladdresspopup(){
	  
	  Select sc = new Select(driver.findElement(By.xpath("//*[@id=\"TimeZoneId\"]")));
	  sc.selectByVisibleText("(GMT) Casablanca");
	  
  }
  
  //SAVE BUTTON UNDER ADD ADDITIONAL ADDRESS POPUP 
  
  public WebElement SaveButtonunderaddadditionaladdresspopup(){
	  
	WebElement elm =  driver.findElement(By.xpath("//*[@id=\"btn_address\"]")); 
	   
	  Actions actions = new Actions(driver);
	  actions.moveToElement(elm);
	  actions.perform();
	
	  return elm ;
	  //.click();
	  
  }
  
  //INVALID ZIP CODE VALIDATION MESSAGE  
  
  public WebElement validationmessageoninvalidZIPcode(){
	  
	return valdmsgonZIPcode ;
	  
  }
  
  //MAKE PRIMARY ADDRESS 
  
  public WebElement primaryaddress() {
	 
	  WebElement element = primaryaddrsscheckbox;
	     
	  Actions actions = new Actions(driver);
	  actions.moveToElement(element);
	  actions.perform();
	  
	  return element;
	  
  }
  
  //SUCCESS MESSAGE AFTER ADDING DETAILS UNDER ADD ADDITIONAL ADDRESS POPUP 
  
  public WebElement successmessageafteradddetailsunderaddadditionaladdresspopup(){
	  
	  //succmsg.getText();
	  return succmsg;
	  
  }
  
  //EDIT ICON UNDER LOCATION 
  
  public WebElement editiconunderlocation(){
	  
	  WebElement element = editiconunderlocation;
	    
	  
	  return element;
	  
  }
  
  //EDIT PRIMARY ADDRESS POPUP TITLE  
  
  public WebElement editprimaryaddresspopuptitle(){
	  
	  return editprimaryaddresspopuptitle;
	  
  }
  
  //REMOVE BUTTON UNDER EDIT PRIMARY ADDRESS POPUP 
  
  public WebElement Removebuttonundereditprimaryaddresspopup(){
	  
	
	  
	  Actions actions = new Actions(driver);
	   actions.moveToElement(RemoveBtnEPAP);
	   actions.perform();
	  
	  return RemoveBtnEPAP;
	  
	  
  }
  
 // CONFIRMATION MESSAGE APPEARS AFTER CLICKING ON REMOVE BUTTON 
  
  public WebElement YesBtnonconfirmationmessage(){
	
	  WebElement element = Yesbtn;
	     
	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	  return element;
	  
  }
 //VALIDATION MESAGGE AFTER CLICKING ON YES BUTTON UNDER EDIT PRIMARY ADDRESS POPUP 
  
  public WebElement ValdMsgOnClickingYesBtnOnEditPrimaryAddressPopup(){

	  
	  WebElement element = ValdmsgafterClickYesBtnOnEditprimaryaddrspopup;
	     
	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	  return element;
	  
  }
  
 //EDIT ICON UNDER SECONDARY LOCATION 
  
 public WebElement editiconunderSECONDARYlocation(){
	  
     
	   Actions actions = new Actions(driver);
	   actions.moveToElement(editiconunderSECONDARYlocation);
	   actions.perform();
	
	  return editiconunderSECONDARYlocation;
	  
  }
 
 //ADD BUTTON UNDER WEBSITE SECTION POPUP  
 
 
 public WebElement addbuttonunderWebsitepopup() throws InterruptedException{
	 
	   WebElement element = AddbtnUnderWebsitePopup;
	  
	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	   
	   
	  return element;
	
 }
 
//SAVE BUTTON UNDER WEBSITE SECTION POPUP 
 
 public WebElement SaveButtonunderWEBSITEPOPUP(){
	  
	return SaveBtnwebsitepopup;
  
 }
 
//SEND  URL UNDER WEBSITE SECTION POPUP  
 
 public WebElement SendUrlunderwebsitesection(){
	 
	 return SendURLUnderWebsitePopup;
	 
 }

 //EDIT WEBSITE ICON UNDER WEBSITE SECTION POPUP 
 
 public WebElement EditIconUnderWebsiteSection() throws InterruptedException{
	 
	   WebElement element = EditWebsiteIcon;
	      
	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
		  
	   return element; 
		  
 }
 
 //REMOVE BUTTON UNDER EDIT SECONDARY WEBSITE URL POPUP
 
 public WebElement RemoveBtnUndrSecWebURL(){
	 
	   WebElement element = RemoveBtnUndrSecWebURL;
     
	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	    return element;
	 
 }
 
 //YES BUTTON AFTER CLICK ON REMOVE BUTTON UNDER EDIT SECONDARY WEBSITE URL POPUP
 
 public WebElement YesBtnUndrRemoveBtnUndrSecWebURL(){
	
	 return YESbtnUNDERRemoveBtnUndrSecWebURL;
	 
 }
 
 //PRIMARY WEBSITE URL POPUP  EDIT ICON    
 
 public WebElement PrimaryWebsiteURL_EditIcon(){
	 
	 WebElement element = PrimaryWebsiteUrlEditIcon;
     
	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
 }
 
 //EDIT ICON IN SOCIAL MEDIA SECTION 
 
 public WebElement SocialMediaSection_EditIcon(){
	 
	 WebElement element = EditIconInSocialMedia;
     
	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
 }
 
 //FACEBOOK TEXT FIELD UNDER SOCIAL MEDIA SECTION  
 
public WebElement FbUrlFieldSocialMediaSection(){
	 
	 WebElement element = FacebookUrlFieldInSocialMedia;
     
	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
 }
 
//TWITTER TEXT FIELD UNDER SOCIAL MEDIA SECTION  

public WebElement TwitterUrlFieldSocialMediaSection(){
	 
	 WebElement element = TwitterUrlFieldInSocialMedia;
   
	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
}
 
//INSTAGRAM TEXT FIELD UNDER SOCIAL MEDIA SECTION  

public WebElement InstagramUrlFieldSocialMediaSection(){
	 
	 WebElement element = InstagramUrlFieldInSocialMedia;
 
	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
}

//LINKED IN TEXT FIELD UNDER SOCIAL MEDIA SECTION  

public WebElement LinkedINUrlFieldSocialMediaSection(){
	 
	 WebElement element = LinkedINUrlFieldInSocialMedia;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
}

//GOOGLE PLUS TEXT FIELD UNDER SOCIAL MEDIA SECTION  

public WebElement GooglePlusUrlFieldSocialMediaSection(){
	 
	 WebElement element = GooglePlusUrlFieldInSocialMedia;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
}

//PINTEREST PLUS TEXT FIELD UNDER SOCIAL MEDIA SECTION  

public WebElement PinterestUrlFieldSocialMediaSection(){
	 
	 WebElement element = PintrestUrlFieldInSocialMedia;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
}

//YOUTUBE TEXT FIELD UNDER SOCIAL MEDIA SECTION  

public WebElement YoutubeUrlFieldSocialMediaSection(){
	 
	 WebElement element = YoutubeUrlFieldInSocialMedia;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
}
 
//BLOG TEXT FIELD UNDER SOCIAL MEDIA SECTION  

public WebElement BlogUrlFieldSocialMediaSection(){
	 
	 WebElement element = BlogUrlFieldInSocialMedia;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
}

//YELP TEXT FIELD UNDER SOCIAL MEDIA SECTION  

public WebElement YelpUrlFieldSocialMediaSection(){
	 
	 WebElement element = YelpUrlFieldInSocialMedia;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
}

//SAVE BUTTON UNDER SOCIAL MEDIA SECTION  

public WebElement SaveButtonUnderSocialMediaSection(){
	 
	 WebElement element = SaveBtnUnderSocialMediaSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 
	 return element ;
	 
}

//FACEBOOK ICON UNDER SOCIAL MEDIA SECTION  

public WebElement FacebookIconUnderSocialMediaSection(){
	
	WebElement element = FacebookIconUnderSocialMediaSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;	
}
//EDIT BUTTON UNDER DECCRIPTION SECTION

public WebElement EditButtonUnderDescriptionSection(){
	
	WebElement element = EditButtonUnderDescriptionSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;	
}

//ADD BUTTON UNDER DECCRIPTION SECTION

public WebElement AddButtonUnderDescriptionSection(){
	
	WebElement element = EditButtonUnderDescriptionSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;	
}
//TEXT FIELD UNDER DECCRIPTION SECTION 

public WebElement TextFieldUnderDescriptionSection(){
	
	WebElement element = TextFieldUnderDescriptionSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;	
}

//SAVE BUTTON UNDER DECCRIPTION SECTION 

public WebElement SaveButtonUnderDescriptionSection(){
	
	WebElement element = SaveButtonUnderDescriptionSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;	
}

//REMOVE BUTTON UNDER DECCRIPTION SECTION 

public WebElement RemoveButtonUnderDescriptionSection(){
	
	WebElement element = RemoveButtonUnderDescriptionSection;

	 
	 return element ;	
}

//YES BUTTON AFTER CLICKING ON REMOVE BUTTON 

public WebElement YesButtonappearsafterclickingonRemoveUnderDescriptionSection(){
	
	WebElement element = YesButtonAfterRemoveUnderDescriptionSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;	
}

//ADD BUTTON UNDER EDUCATION AND TRANING SECTION  

public WebElement AddButtonUnderEducationAndTrainingSection(){
	
	WebElement element = AddButtonAfterUnderEducationAndTrainingSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;	
}

//CLICK ON INSTITUTION ATTENDED TEXT-FIELD UNDER EDUCATION AND TRANING SECTION  

  public WebElement ClickOnInstitutionAttendedTextFieldUnderEducationAndTrainingSection(){
	
	  WebElement element = InsitutionAttendedUnderEducationAndTrainingSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;
  }
//INSITUTION ATTENDED SEARCH-FIELD UNDER EDUCATION AND TRANING SECTION 
  
  public WebElement EnterCharacterOnInstitutionAttendedTextFieldUnderEducationAndTrainingSection(){
		
	  WebElement element = InsitutionAttendedUnderEducationAndTrainingSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;
  }
  
  
	 
  public WebElement EnterCharacterinInstitutionAttendedSearchFieldUnderEducationAndTrainingSection(){	 
	 
	  WebElement element = SearchDropdownFieldUnderAddEducationTraningInforationSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;
	 
	
 }  
  
  public WebElement ClickOnAppearedNameinInstitutionAttendedSearchFieldUnderEducationAndTrainingSection(){	 
		 
	  WebElement element = ClickOnAppearedDropdownFieldUnderAddEducationTraningInforationSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;
	 
	
 }  
  
  public WebElement InsitutionAttendedNameinInstitutionAttendedSectionUnderEducationAndTrainingSection(){	 
		 
	  WebElement element = ClickOnAppearedDropdownFieldUnderAddEducationTraningInforationSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;
	 
	
 }  
  
//SAVE BUTTON UNDER ADD EDUCATION/TRANING INFORMATIION SECTION
  
  public WebElement SaveButtonUnderAddEducationTraningInforationSection(){
	  
	  WebElement element = SaveButtonUnderAddEducationTraningInforationSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
	 
	 return element ;
	  
	 
  }
  
//ADDED NAME APPEARED IN INSITUTION ATTENDED SUB-SECTION UNDER EDUCATION AND TRANING SECTION 
  
   public WebElement AddedNameUnderAddEducationTraningInforationSection(){
	  
	  WebElement element = AddedInsitutionAttendedNameUnderAddEducationTraningInforationSection;

	   Actions actions = new Actions(driver);
	   actions.moveToElement(element );
	   actions.perform();
	 
	 return element ;
	  
	 
  }

//REMOVE BUTTON UNDER EDIT EDUCATION/TRANING INFORMATION POPUP 
   
   public WebElement RemoveButtonUnderEditEducationTraningInforationSectionPopup(){
		  
		  WebElement element = RemoveButtonUnderEditEducationTraningInforationSectionPopup;

		   Actions actions = new Actions(driver);
	   actions.moveToElement(element);
	   actions.perform();
		 
		   
		   
		   
		   
		 return element ;
		  
		 
	  }











}


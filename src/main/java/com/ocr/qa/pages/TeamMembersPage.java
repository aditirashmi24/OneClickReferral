package com.ocr.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;

public class TeamMembersPage extends TestBase {

	//******************PAGE FACTORY*******************------------------------
	//VERTIVAL ELIPSE BUTTON ON TEAM MEMBERS PAGE
	@FindBy(how=How.XPATH,using="//i[@class='fa fa-ellipsis-v']")
	@CacheLookup 
	WebElement VerticalElipse;
	
	//ADD MEMEBER BUTTON ON TEAM MEMBERS PAGE 
	@FindBy(how=How.XPATH,using="//a[@class='btn btn-default btn1' or @text='Add Member']")
	@CacheLookup 
	WebElement AddMember;
	
	//ADD TEAM/STAFFMEMEBERS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//h3[contains(text(),'Add team/staff member')]")
	@CacheLookup 
	WebElement AddMemberStaffMemberPopupTitle;
	
	//FIRST NAME TEXTFIELD UNDER ADD TEAM/STAFFMEMEBERS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//*[@id=\"FirstName\"]")
	@CacheLookup 
	WebElement FirstName;
	
	//LAST NAME TEXTFIELD UNDER ADD TEAM/STAFFMEMEBERS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//*[@id=\"LastName\"]")
	@CacheLookup 
	WebElement LastName;
	
	//EMAIL TEXTFIELD UNDER ADD TEAM/STAFFMEMEBERS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//*[@id=\"Email\"]")
	@CacheLookup 
	WebElement email;
	
	//SPEACILITY DROPDOWN UNDER ADD TEAM/STAFFMEMEBERS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//*[@id=\"Specialty\"]")
	@CacheLookup 
	WebElement speaciality;
	
	//LOCATION DROPDOWN UNDER ADD TEAM/STAFFMEMEBERS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//*[@id=\"Location\"]")
	@CacheLookup 
	WebElement location;
		
	//STAFFMEMBER UNDER ADD TEAM/STAFFMEMEBERS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//*[@id=\"chkProviderStaff\"]")
	@CacheLookup 
	WebElement StaffMemberCheckbox;
	
	//CANCEL BUTTON UNDER ADD TEAM/STAFFMEMEBERS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Cancel')]")
	@CacheLookup 
	WebElement CancelButton;
	
	//SAVE BUTTON UNDER ADD TEAM/STAFFMEMEBERS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Save')]")
	@CacheLookup 
	WebElement SaveButton;
	
	//EDIT ICON UNDER TEAM MEMBERS POPUP
	@FindBy(how=How.XPATH,using="(//i[@class='ico-edit'])[1]")
	@CacheLookup 
	WebElement EditIconUnderTeamMemeber;
	
	//DELETE ICON UNDER TEAM MEMBERS POPUP
	@FindBy(how=How.XPATH,using="(//i[@class='ico-delete'])[1]")
	@CacheLookup 
	WebElement DeleteIconUnderTeamMemeber;
	
	
	//EDIT TEAM STAFF MEMBERS POPUP TITLE  
	@FindBy(how=How.XPATH,using="//h3[contains(text(),'Edit team/staff member')]")
	@CacheLookup 
	WebElement EditTeamStaffMembersPopupTitle;
	
	//FIRST NAME TEXTFIELD UNDER EDIT TEAM STAFF MEMBERS POPUP 
	@FindBy(how=How.XPATH,using="//*[@id=\"FirstName\"]")
	@CacheLookup 
	WebElement FirstNameTextFieldUnderETSM;
     
	//LAST NAME TEXTFIELD UNDER EDIT TEAM STAFF MEMBERS POPUP
	@FindBy(how=How.XPATH,using="//*[@id=\"LastName\"]")
	@CacheLookup 
	WebElement LastNameTextFieldUnderETSM; 
	
	//STAFFMEMBER UNDER EDIT TEAM STAFF MEMBERS POPUP 
	@FindBy(how=How.XPATH,using="//*[@id=\"chkProviderStaff\"]")
	@CacheLookup 
	WebElement StaffMemberCheckboxUnderETSM;
	
	//CANCEL BUTTON UNDER EDIT TEAM/STAFFMEMEBERS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Cancel')]")
	@CacheLookup 
	WebElement CancelButtonUnderETSM;
		
	//SAVE BUTTON UNDER EDIT TEAM/STAFFMEMEBERS POPUP TITLE 
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Save')]")
	@CacheLookup 
	WebElement SaveButtonUnderETSM;
	
	//LAST NAME TITLE ON TEAMMEMBERS PAGE  
	@FindBy(how=How.CSS,using="#wizard > div.tab-pane > div:nth-child(2) > div > table > thead > tr > th:nth-child(2) > span")
	@CacheLookup 
	WebElement LastNameTitleOnTeamMembersPage;
	
	//FIRST NAME TITLE ON TEAMMEMBERS PAGE  
	@FindBy(how=How.CSS,using="#wizard > div.tab-pane > div:nth-child(2) > div > table > thead > tr > th:nth-child(3) > span")
	@CacheLookup 
	WebElement FirstNameTitleOnTeamMembersPage;
	
	//SEARCH FIELD ON TEAMMEMBERS PAGE 
	@FindBy(how=How.XPATH,using="//*[@id=\"txtSearchTeam\"]")
	@CacheLookup 
	WebElement SearchFieldOnTeamMembersPage;
	
	//INITIALIZE ALL OBJECTS------------------------------ 
     public TeamMembersPage(){
					
		PageFactory.initElements(driver,this);
					
	}
	
    //VERTICAL ELIPSE BUTTON ON TEAMMEMBER PAGE 
	public WebElement VerticalElipseButton(){
		
		return VerticalElipse; 
			
	}
	
	//ADD MEMBER BUTTON ON TEAM MEMBERS PAGE 
	public WebElement AddMemberButton(){
			
		return AddMember; 
				
	}
	
	//ADD MEMBER STAFF MEMBER POPUP TITLE 
	public WebElement AddTeamStaffMemberTitle(){
		
		return AddMemberStaffMemberPopupTitle; 
				
	}
	
    	
	//FIRST NAME TEXTFIELD UNDER ADD MEMBER STAFF MEMBER POPUP TITLE 
	public WebElement FirstNameTextFieldUnderAddTeamStaffMemberPopup(){
			
			return FirstName; 
					
	}
	
	//LAST NAME TEXTFIELD UNDER ADD MEMBER STAFF MEMBER POPUP TITLE 
	public WebElement LastNameTextFieldUnderAddTeamStaffMemberPopup(){
				
			return LastName; 
						
	}
	
	//EMAIL TEXTFIELD UNDER ADD MEMBER STAFF MEMBER POPUP TITLE 
	public WebElement EmailTextFieldUnderAddTeamStaffMemberPopup(){
					
			return email; 
							
	}
	
	//SPECIALITY SELECT FIELD UNDER ADD MEMBER STAFF MEMBER POPUP  
	public WebElement SpecialitySelectFieldUnderAddTeamStaffMemberPopup(){
						
			return speaciality;
								
	}

	
	//LOCAATION SELECT FIELD UNDER ADD MEMBER STAFF MEMBER POPUP  
	public WebElement  LocationSelectFieldUnderAddTeamStaffMemberPopup(){
								
		return location;
										
	}
	
	//STAFF MEMBER CHECKBOX UNDER ADD MEMBER STAFF MEMBER POPUP  
	public WebElement StaffMemberCheckboxUnderAddTeamStaffMemberPopup(){
									
			return StaffMemberCheckbox;
											
	}
	
	//CANCEL BUTTON UNDER ADD MEMBER STAFF MEMBER POPUP  
	public WebElement CancelButtonUnderAddTeamStaffMemberPopup(){
										
			return CancelButton;
												
	}
	
	//SAVE BUTTON UNDER ADD MEMBER STAFF MEMBER POPUP  
	public WebElement SaveButtonUnderAddTeamStaffMemberPopup(){
											
			return SaveButton;
													
	}
	//EDIT ICON UNDER TEAM MEMBERS PAGE 
	public WebElement EditIconUnderTeamMembersPage(){
		
		    return EditIconUnderTeamMemeber; 
		    
	}
	//DELETE ICON UNDER TEAM MEMBERS PAGE
	public WebElement DeleteIconUnderTeamMembersPage(){
		
	    return DeleteIconUnderTeamMemeber; 
	    
     }
	//EDIT TEAM/STAFF MEMBER POPUP TITLE 
	public WebElement editteamstaffmemberpopuptitle(){
		
		return EditTeamStaffMembersPopupTitle;
		
	}
	
	//EMAIL IS NONEDITABLE UNDER EDIT TEAMSTAFFMEMBER POPUP 
	public boolean EmailIsNonEditableUnderEditTeamStaffMemberPopup(){
		
		try{  
			WebDriverWait wait = new WebDriverWait(driver, 10); 
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Email\"]")));
			return true;
		}
		catch(Exception ex){
			
			return false;
		}
				
	}
	
	//FIRST NAME TEXTFIELD UNDER ADD MEMBER STAFF MEMBER POPUP TITLE 
	public WebElement FirstNameTextFieldUnderEditTeamStaffMemberPopup(){
				
			return FirstName; 
						
	}
		
	//LAST NAME TEXTFIELD UNDER ADD MEMBER STAFF MEMBER POPUP TITLE 
	public WebElement LastNameTextFieldUnderEditTeamStaffMemberPopup(){
					
			return LastName; 
							
	}
	
	//STAFF MEMBER CHECKBOX UNDER ADD MEMBER STAFF MEMBER POPUP  
	public WebElement StaffMemberCheckboxUnderEditTeamStaffMemberPopup(){
										
			return StaffMemberCheckboxUnderETSM;
												
	}
	
	//CANCEL BUTTON UNDER ADD MEMBER STAFF MEMBER POPUP  
	public WebElement CancelButtonUnderEditTeamStaffMemberPopup(){
											
			return CancelButton;
													
	}
		
	//SAVE BUTTON UNDER ADD MEMBER STAFF MEMBER POPUP  
	public WebElement SaveButtonUnderEditTeamStaffMemberPopup(){
												
			return SaveButton;
														
	}
	//LAST NAME TITLE ON TEAMMEMBERS PAGE  
	public WebElement LastNameTittleOnTeamMembersPage(){
		
		return LastNameTitleOnTeamMembersPage;
													
    }
	
	//FIRST NAME TITLE ON TEAMMEMBERS PAGE  
	public WebElement FirstNameTittleOnTeamMembersPage(){
			
		return FirstNameTitleOnTeamMembersPage;
														
	}
	
	//SEARCH FIELD ON TEAM MEMBERS PAGE   
	public WebElement SearchFieldOnTeamMemberspage(){
		
		
		return SearchFieldOnTeamMembersPage;
		
		
		
	}
	
	
	
	
	
}

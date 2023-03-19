package com.ocr.qa.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;

public class SendReferralpage extends TestBase {

	// ******************PAGE FACTORY*******************------------------------

	String PatFirstName = prop.getProperty("PageSendReferralAddPatientFirstName");
	String PatLstName = prop.getProperty("PageSendReferralAddPatientLastName");
	String PatPhoneNumber = prop.getProperty("PageSendReferralAddPatientPhoneNumber");

	// IMAGE LOGO
	@FindBy(how = How.CSS, using = "#btnLink > img")
	@CacheLookup
	WebElement ImageLogo;

	// SEND REFERRAL TITLE ON PAGE
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Send Referral')]")
	@CacheLookup
	WebElement SendrefTitleonpage;

	// SEND FROM DROPDOWN
	@FindBy(how = How.CSS, using = "#teamMember")
	@CacheLookup
	WebElement SendFrom;

	// SEND TO DROPDOWN
	@FindBy(how = How.CSS, using = "#ddlColleague")
	@CacheLookup
	WebElement SendTo;

	// LOCATION DROPDOWN
	@FindBy(how = How.CSS, using = "#ddlLocation")
	@CacheLookup
	WebElement Location;

	// ADD PATIENT SECTION
	// FIRSTNAME TEXTFIELD
	@FindBy(how = How.CSS, using = "#txtFirstName")
	@CacheLookup
	WebElement FirstnameAddP;

	// LASTNAME TEXTFIELD
	@FindBy(how = How.CSS, using = "#txtLastName")
	@CacheLookup
	WebElement LastnameAddP;

	// PHONE-NUMBER TEXTFIELD
	@FindBy(how = How.CSS, using = "#phone")
	@CacheLookup
	WebElement PhonenumberAddP;

	// PHONE-NUMBER TEXTFIELD
	@FindBy(how = How.CSS, using = "#txtEmail")
	@CacheLookup
	WebElement EmailAddP;

	// SEND REFERRAL BUTTON ON REFERRAL PAGE
	// @FindBy(how=How.CSS,using="#savnbtn")
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"savnbtn\\\"]")
	@CacheLookup
	WebElement SendReferrlaBtnOnSendReferralP;

	// ATTACH FILES BUTTON ON REFERRAL PAGE
	// @FindBy(how=How.CSS,using="#upfile")
	// @FindBy(how=How.CLASS_NAME,using="attach-file-btn")
	@FindBy(how = How.XPATH, using = "//*[@id=\"upfile\"]")
	@CacheLookup
	WebElement AttachFilesBtnOnSendReferralP;

	// FIRST NAME APPEARED ON SELECT PATIENT SECTION
	@FindBy(how = How.XPATH, using = "//td[@data-th='First Name' and contains(text(),'Aaron')]")
	@CacheLookup
	WebElement AppearedFirstname;

	// LAST NAME APPEARED ON SELECT PATIENTSECTION
	@FindBy(how = How.XPATH, using = "//td[@data-th='Last Name' and contains(text(),'122')]")
	@CacheLookup
	WebElement AppearedLastname;

	// PHONE NUMBER APPEARED ON SELECT PATIENTSECTION
	@FindBy(how = How.XPATH, using = "(//td[@data-th='Phone' ])[1]")
	@CacheLookup
	WebElement AppearedPhonenumber;

	// CONTACT INFO SECTION
	@FindBy(how = How.CSS, using = "#Gender")
	@CacheLookup
	WebElement Gender;

	// ADDRESS
	@FindBy(how = How.CSS, using = "#contactInfo_Address")
	@CacheLookup
	WebElement Address;

	// SERVICE IN SEND REFFERAL PAGE
	@FindBy(how = How.XPATH, using = "(//label[@for='Extractions' and @class='Extract-Slide'])[1]")
	@CacheLookup
	WebElement Extractions;

	// DENTAL INSURANCE SERVICE ON SEND REFERRAL
	// PAGE----------*********----------------
	// PRIMARY INSURANCE COMPANY NAME

	@FindBy(how = How.NAME, using = "_insuranceCoverage.PrimaryInsuranceCompany")
	@CacheLookup
	WebElement PrimInsuCompName;

	// Primary Insurance Company Phone
	@FindBy(how = How.NAME, using = "_insuranceCoverage.PrimaryInsurancePhone")
	@CacheLookup
	WebElement PrimInsuCompPhone;

	// Primary Name of Insured
	@FindBy(how = How.NAME, using = "_insuranceCoverage.PrimaryNameOfInsured")
	@CacheLookup
	WebElement PrimNameOfInsured;

	// Attached uploaded file
	// @FindBy(how=How.CSS,using="#documentsContainer > div > div")
	@FindBy(how = How.ID, using = "documentsContainer")
	@CacheLookup
	WebElement UploadedAttachfile;

	// CLICK ON DENTAL INSURANCE SECTION
	// @FindBy(how=How.XPATH,using="//a[contains(text(),'Dental Insurance')]")
	@FindBy(how = How.LINK_TEXT, using = "Dental Insurance")
	@CacheLookup
	WebElement ClickOnDentalInsurance;

	// CLICK ON DENTAL HISTORY SECTION
	// @FindBy(how=How.XPATH,using="//a[contains(text(),'Dental History')]")
	@FindBy(how = How.LINK_TEXT, using = "Dental History")
	@CacheLookup
	WebElement ClickOnDentalHistory;

	public String SendreferralPageTitle() {

		return driver.getTitle();

	}

	public void SendFrom() throws InterruptedException {

		WebElement elm = driver.findElement(By.xpath("//*[@id=\"teamMember\"]"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elm));

		Select drop = new Select(elm);
		drop.selectByVisibleText("Levin Q");
		Thread.sleep(4000);

	}

	// Validation on SendFrom Name
	public WebElement valsendfrom() {

		WebElement elm = driver.findElement(By.xpath("//option[contains(text(),'Levin Q')]"));
		return elm;

	}

	public void SendTo() throws InterruptedException {

		WebElement elm = driver.findElement(By.xpath("//*[@id=\"ddlColleague\"]"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elm));

		Select drop = new Select(elm);
		drop.selectByVisibleText("tom jerry(dental)");
		Thread.sleep(4000);

	}

	// Validation on SendTo Name
	public WebElement valsendto() {

		WebElement elm = driver.findElement(By.xpath("//option[contains(text(),'tom jerry(dental)')]"));
		return elm;

	}

	// SELECT LOCATION
	public void Location() throws InterruptedException {

		Select drop = new Select(driver.findElement(By.xpath("//*[@id=\"ddlLocation\"]")));
		drop.selectByVisibleText("Gas pump");
		Thread.sleep(4000);

	}

	// Validation on Location
	public WebElement refferedreciveddentistLocation() {

		WebElement elm = driver.findElement(By.xpath("(//option[contains(text(),'Gas pump')])[1]"));
		return elm;

	}

	// Patient name as selected and appeared in add patient section
	public String ApearedPatientfirstnameinAddpatientsection() {

		// return driver.findElement(By.xpath("//*[@id=\"txtFirstName\"]")).getText();

		// return driver.findElement(By.cssSelector("#txtFirstName")).getText();
		return driver.findElement(By.id("txtFirstName")).getAttribute("value");

	}

	// SELECTED PHONE NUMBER APPEARED IN add patient section
	public String ApearedPatientphonenumberinAddpatientsection() {

		return driver.findElement(By.id("phone")).getAttribute("value");

	}

	// SELECTED PATIENT GENDER APPEARED IN ADD-PATIENT SECTION
	public String ApearedPatinetGenderinAddpatientsection() {

		return driver.findElement(By.id("Gender")).getAttribute("value");

	}

	// ADD PATIENT

	public void AddpatientFirstName() {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(FirstnameAddP))
				.sendKeys(prop.getProperty("ExistingPatientname"));

	}

	public void AddpatientLastName() {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(LastnameAddP))
				.sendKeys(prop.getProperty("PageSendReferralAddPatientLastName"));

	}

	public void AddpatientPhoneNumber() {

		// PhonenumberAddP.sendKeys(prop.getProperty("PageSendReferralAddPatientPhoneNumber"));

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(PhonenumberAddP))
				.sendKeys(prop.getProperty("PageSendReferralAddPatientPhoneNumber"));

	}

	public void AddpatientEmailonConversationPage() {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(EmailAddP))
				.sendKeys(prop.getProperty("PageSendReferralAddEmailforConversationPage"));

	}

	public WebElement ExistingPatientDetails() {

		WebElement pdetails = driver.findElement(By.cssSelector("#Search_FirstName"));

		return pdetails;

		// sendKeys(prop.getProperty("ExistingPatientname"));
	}

	// EXISTING PATIENT DETAIL USE FOR CONVERSATION PAGE

	public void ExistingPatientDetailsForConversationPage() {

		WebElement ExisPatientDetails = driver.findElement(By.cssSelector("#Search_FirstName"));

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(ExisPatientDetails))
				.sendKeys(prop.getProperty("ExistingPatientnameforConversationPage"));
	}

	// SELECT PATIENT SECTION

	public String PatientFirstNameAppearsinSelectPatientSection() {

		return driver.findElement(By.xpath("//td[@data-th='First Name' and contains(text(),'" + PatFirstName + "')]"))
				.getText();

	}
	// CLICK ON PATIENT NAME APPEARS IN SELECT PATIENT SECTION

	public void Clickonselectedpatientname() {

		driver.findElement(By.xpath(
				"//td[@data-th='First Name' and contains(text(),'" + prop.getProperty("ExistingPatientname") + "')]"))
				.click();

	}

	public String PatientLastNameAppearsinSelectPatientSection() {

		return driver.findElement(By.xpath("//td[@data-th='Last Name' and contains(text(),'" + PatLstName + "')]"))
				.getText();

	}

	public String PatientPhoneNoAppearsinSelectPatientSection() {

		return driver.findElement(By.xpath("(//td[@data-th='Phone' ])[1]")).getText();

	}

	// SEND REFERRAL BUTTON ON SEND REFERRAL PAGE

	public WebElement SendReferralbutton() {

		// SendReferrlaBtnOnSendReferralP.click();
		WebElement sbtn = driver.findElement(By.cssSelector("#savnbtn"));

		Actions actions = new Actions(driver);
		actions.moveToElement(sbtn);
		actions.click(sbtn).perform();
		;

		return sbtn;

	}

	// VALIDATION MESSAGE ON FIRSTNAME BLANK FIELD

	public String valfirstnameonaddpatientsection() {

		// return driver.findElement(By.xpath("//span[@for='txtFirstName' and
		// contains(text(),'First name is required.')]")).getText();

		return driver
				.findElement(By.xpath("//span[@for='txtFirstName' and contains(text(),'First name is required.')]"))
				.getText();
	}

	public String valphonenumberonaddpatientsection() {

		return driver.findElement(By.xpath("//span[@for='phone' and contains(text(),'Phone number is required.')]"))
				.getText();

	}

	public String valpatientgenderonaddpatientsection() {

		return driver.findElement(By.xpath("//span[@id='spGender' and contains(text(),'Please select gender.')]"))
				.getText();

	}

	// SERVICES ON SEND REFERRAL PAGE
	// ORAL
	// SURGERY--------------------------------------------***-------------------
	public void OralsugerryExtractionService() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("(//label[@for='Extractions'])[1]")));

	}

	// VALIDATION ON ORAL SURGERY
	public String ValidationafterclickOralsugerryExtractionService() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_1_1_0']")).getAttribute("placeholder");

		return txt;
	}

	// Periodontics----------------------------------------***----------------------

	public void PeriodonticsScallingAndrootplaning() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='Scaling and Root Planning']")));

		// driver.findElement(By.xpath("//label[@for='Scaling and Root
		// Planning']")).click();

	}

	// VALIDATION ON PERIODONTICS
	public String ValidationafterClickPeriodonticsScallingandrootplaningService() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_2_16_0']")).getAttribute("placeholder");

		return txt;

	}

	// Orthodontics-----------------------------------------***-------------------

	public void OrthodonticscConsulation() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='Consultation']")));

		// driver.findElement(By.xpath("//label[@for='Consultation']")).click();

	}

	// VALIDATION ON Orthodontice
	public String ValidationOrthodonticscConsulationService() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_3_45_0']")).getAttribute("placeholder");

		return txt;

	}

	// Prosthodontics----------------------------------------***--------------

	public void ProsthodonticsBridge() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='Bridge (fixed partial denture)']")));

		// driver.findElement(By.xpath("//label[@for='Bridge (fixed partial
		// denture)']")).click();

	}

	// VALIDATION ON Prosthodontics
	public String ValidationProsthodonticsBridgeService() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_11_118_0']")).getAttribute("placeholder");

		return txt;

	}

	// Endodontics---------------------------------------------***-------------------

	public void EndodonticsDiagnosticConsultation() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='Diagnostic Consultation']")));

		// driver.findElement(By.xpath("//label[@for='Diagnostic
		// Consultation']")).click();

	}

	// VALIDATION ON ENDODONTICS

	public String ValiadationEndodonticsDiagnosticConsultation() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_4_49_0']")).getAttribute("placeholder");

		return txt;

	}

	// Pediatrics-----------------------------------------------***-----------------------

	public void PediatricsCariesorDecay() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='Caries or Decay']")));

		// driver.findElement(By.xpath("//label[@for='Caries or Decay']")).click();

	}

	// VALIDATION ON PEDIATRICS

	public String ValiadationPediatricsCariesorDecay() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_5_56_0']")).getAttribute("placeholder");

		return txt;

	}

	// Implants------------------------------------------------***---------------

	public void Implantsother() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("(//label[@for='Other'])[6]")));

		// driver.findElement(By.xpath("(//label[@for='Other'])[6]")).click();

	}

	// VALIDATION ON Implantsother

	public String ValiadationImplantsother() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_12_132_0']")).getAttribute("placeholder");

		return txt;

	}

	// GeneralDentistry-----------------------------------***------------------------

	public void GeneralDentistryother() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("(//label[@for='Other'])[7]")));

		// driver.findElement(By.xpath("(//label[@for='Other'])[7]")).click();

	}

	// VALIDATION ON Implantsother

	public String ValiadationGeneralDentistryother() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_13_133_0']")).getAttribute("placeholder");

		return txt;

	}

	// DentalLab--------------------------------------------***-----------------------

	public void Dentallabother() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("(//label[@for='Other'])[8]")));

		// driver.findElement(By.xpath("(//label[@for='Other'])[8]")).click();

	}

	// VALIDATION ON DentalLabother

	public String ValiadationDentallabother() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_6_72_0']")).getAttribute("placeholder");

		return txt;

	}

	// RADIOLOGY----------------------------------------------***----------------------

	public void Radiologyother() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("(//label[@for='Other'])[9]")));

		// driver.findElement(By.xpath("(//label[@for='Other'])[9]")).click();

	}

	// VALIDATION ON Radiologyother

	public String ValiadationRadiologyother() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_7_73_0']")).getAttribute("placeholder");

		return txt;

	}

	// TreatmentPerformed------------------------------------***--------------------------

	public void TreatmentPerformedRootcanalinitiated() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='Root canal initiated']")));

		// driver.findElement(By.xpath("//label[@for='Root canal initiated']")).click();

	}

	// VALIDATION ON TreatmentPerformed

	public String ValiadationTreatmentPerformedRootcanalinitiated() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_9_108_0']")).getAttribute("placeholder");

		return txt;

	}

	// Pediatric
	// Dentistry-------------------------------------***-----------------------

	public void PediatricDentistryconsultationtreatment() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='Pediatric dentistry consultation/treatment']")));

		// driver.findElement(By.xpath("//label[@for='Pediatric dentistry
		// consultation/treatment']")).click();

	}

	// VALIDATION ON PediatricDentistry

	public String ValiadationOnPediatricDentistryconsultationtreatment() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_10_110_0']")).getAttribute("placeholder");

		return txt;

	}
	// OTHER-------------------------------------------------***----------------------------

	public void Otherother() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("(//label[@for='Other'])[10]")));

		// driver.findElement(By.xpath("(//label[@for='Other'])[10]")).click();

	}

	// VALIDATION ON Other

	public String ValiadationOnOtherother() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_8_74_0']")).getAttribute("placeholder");

		return txt;

	}

	// Cosmetic Plastic
	// Surgery---------------------------------***-------------------------

	public void CosmeticPlasticSurgeryBotoxDysportXeomin() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='Botox/Dysport/Xeomin']")));

		// driver.findElement(By.xpath("//label[@for='Botox/Dysport/Xeomin']")).click();

	}

	// VALIDATION ON Other

	public String ValiadationCosmeticPlasticSurgeryBotoxDysportXeomin() {

		String txt = driver.findElement(By.xpath("//textarea[@name='sub_14_142_0']")).getAttribute("placeholder");

		return txt;

	}

	// CHECK BOX UNDER MEDICAL HISTORY
	// SECTION-------------*****________********___________

	// Are you under a physicians care right now?

	public void Areyouunderaphysicianscarerightnow() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='MrdQue1']")));

		// driver.findElement(By.xpath("//label[@for='MrdQue1']")).click();
	}

	public boolean ValidateAreyouunderaphysicianscarerightnow() {

		return driver.findElement(By.id("MrdQue1")).isSelected();

	}

	// Have you ever been hospitalized or had a major operation?

	public void Haveyoueverbeenhospitalizedorhadamajoroperation() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='MrdQue2']")));

		// driver.findElement(By.xpath("//label[@for='MrdQue2']")).click();

	}

	public boolean ValiadateHaveyoueverbeenhospitalizedorhadamajoroperation() {

		return driver.findElement(By.id("MrdQue2")).isSelected();

	}

	// Have you ever had a serious head or neck injury?

	public void Haveyoueverhadaseriousheadorneckinjury() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='MrdQue3']")));

		// driver.findElement(By.xpath("//label[@for='MrdQue3']")).click();

	}

	public boolean ValiadateHaveyoueverhadaseriousheadorneckinjury() {

		return driver.findElement(By.id("MrdQue3")).isSelected();

	}

	// Are taking any medications, pills, or drugs?

	public void Aretakinganymedicationspillsordrugs() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='MrdQue4']")));

		// driver.findElement(By.xpath("//label[@for='MrdQue4']")).click();

	}

	public boolean ValiadateAretakinganymedicationspillsordrugs() {

		return driver.findElement(By.id("MrdQue4")).isSelected();

	}

	// Do you take, or have you taken, Phen-Fen or Redux?

	public void DoyoutakeorhaveyoutakenPhenFenorRedux() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='MrdQue5']")));

		// driver.findElement(By.xpath("//label[@for='MrdQue5']")).click();

	}

	public boolean ValiadateDoyoutakeorhaveyoutakenPhenFenorRedux() {

		return driver.findElement(By.id("MrdQue5")).isSelected();

	}

	// Have you ever taken Fosamax, Boniva, Actonel or any other medications
	// containing biphosphonates?

	public void HaveyouevertakenFosamaxBonivaActoneloranyothermedicationscontainingbiphosphonates() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='MrdQue6']")));

		// driver.findElement(By.xpath("//label[@for='MrdQue6']")).click();

	}

	public boolean ValiadateHaveyouevertakenFosamaxBonivaActoneloranyothermedicationscontainingbiphosphonates() {

		return driver.findElement(By.id("MrdQue6")).isSelected();

	}

	// Are you on a special diet?

	public void Areyouonaspecialdiet() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='MrdQuediet7']")));

		// driver.findElement(By.xpath("//label[@for='MrdQuediet7']")).click();

	}

	public boolean ValiadateAreyouonaspecialdiet() {

		return driver.findElement(By.id("MrdQuediet7")).isSelected();

	}

	// Do you use tobacco?

	public void Doyouusetobacco() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='Mrdotobacco8']")));

		// driver.findElement(By.xpath("//label[@for='Mrdotobacco8']")).click();

	}

	public boolean ValiadateDoyouusetobacco() {

		return driver.findElement(By.id("Mrdotobacco8")).isSelected();

	}

	// Do you use controlled substances?

	public void Doyouusecontrolledsubstances() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='Mrdosubstances']")));

		// driver.findElement(By.xpath("//label[@for='Mrdosubstances']")).click();

	}

	public boolean ValiadateDoyouusecontrolledsubstances() {

		return driver.findElement(By.id("Mrdosubstances")).isSelected();

	}

	// Are you pregnant/Trying to get pregnant(women)?

	public void AreyoupregnantTryingtogetpregnantwomen() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//label[@for='Mrdopregnant']")));

		// driver.findElement(By.xpath("//label[@for='Mrdopregnant']")).click();

	}

	public boolean ValiadateAreyoupregnantTryingtogetpregnantwomen() {

		return driver.findElement(By.id("Mrdopregnant")).isSelected();

	}

	// Taking oral contraceptives(women)?

	public void Takingoralcontraceptiveswomen() {

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//label[@for='Mrdocontraceptives']")));

	//	driver.findElement(By.xpath("//label[@for='Mrdocontraceptives']")).click();

	}

	public boolean ValiadateTakingoralcontraceptiveswomen() {

		return driver.findElement(By.id("Mrdocontraceptives")).isSelected();

	}

	// Nursing women

	public void Nursingwomen() {

		driver.findElement(By.xpath("//label[@for='MrdoNursing']")).click();

	}

	public boolean ValiadateNursingwomen() {

		return driver.findElement(By.id("MrdoNursing")).isSelected();

	}

	// Have tonsils or have adenoids been removed?

	public void Havetonsilsorhaveadenoidsbeenremoved() {

		driver.findElement(By.xpath("//label[@for='Mrdotonsils']")).click();

	}

	public boolean ValiadateHavetonsilsorhaveadenoidsbeenremoved() {

		return driver.findElement(By.id("Mrdotonsils")).isSelected();

	}

	// List any serious illness not listed above

	public void Listanyseriousillnessnotlistedabove() {

		driver.findElement(By.xpath("//label[@for='Mrdillness']")).click();

	}

	public boolean ValiadateListanyseriousillnessnotlistedabove() {

		return driver.findElement(By.id("Mrdillness")).isSelected();

	}

	// Additional Information

	public void AdditionalInformation() {

		driver.findElement(By.xpath("//label[@for='MrdComments']")).click();

	}

	public boolean ValiadateAdditionalInformation() {

		return driver.findElement(By.id("MrdComments")).isSelected();

	}

	// Dental Insurance Section

	// PrimaryInsuranceCompany Filed

	public void PrimaryInsuranceCompany() throws InterruptedException {

		driver.findElement(By.name("_insuranceCoverage.PrimaryInsuranceCompany")).clear();
		driver.findElement(By.name("_insuranceCoverage.PrimaryInsuranceCompany"))
				.sendKeys(prop.getProperty("PrimaryInsuranceCompanyName"));
		// PrimInsuCompName.clear();
		// Thread.sleep(2000);
		// PrimInsuCompName.sendKeys("NUtentcomp");

	}

	//
	public void PrimaryInsuranceCompanyPhone() throws InterruptedException {

		driver.findElement(By.name("_insuranceCoverage.PrimaryInsurancePhone")).clear();
		driver.findElement(By.name("_insuranceCoverage.PrimaryInsurancePhone"))
				.sendKeys(prop.getProperty("PrimaryInsuranceCompanyPhone"));
		// PrimInsuCompPhone.clear();
		// Thread.sleep(2000);
		// PrimInsuCompPhone.sendKeys("1324567894");

	}

	public void PrimaryNameofInsured() throws InterruptedException {

		driver.findElement(By.name("_insuranceCoverage.PrimaryNameOfInsured")).clear();
		driver.findElement(By.name("_insuranceCoverage.PrimaryNameOfInsured"))
				.sendKeys(prop.getProperty("PrimaryNameofInsured"));
		// PrimNameOfInsured.clear();
		// Thread.sleep(2000);
		// PrimNameOfInsured.sendKeys("KelAaron");

	}

	// ---***-----DENTAL HISTORY SECTION------------------

	// Previous dentist name
	public void PreviousDentistName() {

		driver.findElement(By.name("_dentalhistory.txtQue5")).clear();
		driver.findElement(By.name("_dentalhistory.txtQue5")).sendKeys(prop.getProperty("PreviousDentistName"));

	}

	// When was the last time you had your teeth cleaned?

	public void Whenwasthelasttimeyouhadyourteethcleaned() {

		driver.findElement(By.name("_dentalhistory.txtQue6")).clear();
		driver.findElement(By.name("_dentalhistory.txtQue6"))
				.sendKeys(prop.getProperty("Whenwasthelasttimeyouhadyourteethcleaned"));

	}

	// Do you make regular visits to the dentist? CHECKBOX

	public void Doyoumakeregularvisitstothedentist() {

		driver.findElement(By.xpath("//label[@for='rdQue7a']")).click();

	}

	// Validate Do you make regular visits to the dentist? CHECKBOX

	public boolean ValidateDoyoumakeregularvisitstothedentist() {

		return driver.findElement(By.xpath("//label[@for='rdQue7a']")).isSelected();

	}

	// HowOften

	public void HowOften() {

		driver.findElement(By.name("_dentalhistory.txtQue7")).sendKeys("Within Month");

	}

	// Validation success message appears after clicking on Send Referral button

	public String patinetreffersuccessfullymessage() {

		return driver.findElement(By.xpath("//div[contains(text(),'Patient Referral Sent Successfully!')]")).getText();

	}
	// Patient Name Appears on Conversation page

	public void patientnameonconversationpage() {

		driver.findElement(By.linkText(prop.getProperty("ExistingPatientFullname"))).click();

	}

	// ATTACH FILE
	// SECTION--------------------------------------------------------------------------------

	// ATTACH FILES BUTTON

	public void AttachFilesButton() {

		// AttachFilesBtnOnSendReferralP.click();

		// Actions actions = new Actions(driver);
		// actions.moveToElement(AttachFilesBtnOnSendReferralP).perform();
		// AttachFilesBtnOnSendReferralP.click();

		driver.findElement(By.xpath("//*[@id=\"upfile\"]")).click();

	}

	// VALID FILE AFTER DOWNLOADED
	// IS FILE DOWNLOADED

	// INVALID FILE UPLODAD

	public WebElement BinFormateInValidfile() throws InterruptedException, IOException {

		WebElement click = driver.findElement(By.xpath("//*[@id=\"upfile\"]"));
		return click;

	}

	public String ValidateInValidfile() {

		return driver.findElement(By.xpath("//*[contains(text(),'Invalid file type.') ]")).getText();

	}

	public WebElement DllFormateInValidfile() throws Exception {

		WebElement click = driver.findElement(By.xpath("//*[@id=\"upfile\"]"));
		return click;

	}

	// Download icon on attached file
	public void downloadicononattachedfile() {

		// driver.findElement(By.className("btn btn-sm btn-default aDownload")).click();
		driver.findElement(By.xpath("//*[@id=\"documentsContainer\"]/div/div/div[3]/a[1]")).click();

	}

	// Downloaded file after click on download icon
	// IS FILE DOWNLOADED
	public Boolean isFileDownloaded_Ext(String dirPath, String ext) {

		boolean flag = false;

		File dir = new File(dirPath);

		File[] files = dir.listFiles();

		if (files == null || files.length == 0) {

			flag = false;
		}

		for (int i = 1; i < files.length; i++) {

			if (files[i].getName().contains(ext))

				flag = true;

		}

		return flag;

	}

	// DELETE ICON APPEARS ON ATTACHED FILE
	public void DeleteIconOnAttachedfile() {

		driver.findElement(By.xpath("//*[@id=\"documentsContainer\"]/div/div/div[3]/a[2]")).click();

	}

	public String ValidateNoattachementtextmsg() {

		return driver.findElement(By.xpath("//span[contains(text(),'Attach the file here.')]")).getText();

	}

	// DASHBOARD LINK ON THE HEADER OF SEND REFERRAL PAGE

	public WebElement DashboardLinkonHeaderofSendReferralpage() {

		WebElement click = driver.findElement(By.linkText("DASHBOARD"));
		return click;

	}

	// DEMO LINK ON THE HEADER OF SEND REFERRAL PAGE

	public WebElement DemoLinkonHeaderofSendReferralpage() {

		WebElement click = driver.findElement(By.linkText("DEMO"));
		return click;

	}

	// SIGNOUT LINK ON THE HEADER OF SEND REFERRAL PAGE

	public WebElement SignoutLinkonHeaderofSendReferralpage() {

		WebElement click = driver.findElement(By.linkText("SIGN OUT"));
		return click;

	}

	// Terms & Conditions LINK ON THE FOOTER OF SEND REFERRAL PAGE

	public WebElement TermsandConditionLiinkonFooterofSendReferralpage() {

		WebElement click = driver.findElement(By.linkText("Terms & Conditions"));
		return click;

	}
	// PRIVACY POLICY LINK ON THE FOOTER OF SEND REFERRAL PAGE

	public WebElement PrivacyPolicyLiinkonFooterofSendReferralpage() {

		WebElement click = driver.findElement(By.linkText("Privacy Policy"));
		return click;

	}

	// CONTACT US LINK ON THE FOOTER OF SEND REFERRAL PAGE

	public WebElement ContactUsLiinkonFooterofSendReferralpage() {

		WebElement click = driver.findElement(By.linkText("Contact Us"));
		return click;

	}

	// SIGNOUT LINK ON THE FOOTER OF SEND REFERRAL PAGE

	public WebElement SignoutLiinkonFooterofSendReferralpage() {

		WebElement click = driver.findElement(By.linkText("Sign Out"));
		return click;

	}

	// LOGIN LINK ON THE FOOTER OF SEND REFERRAL PAGE

	public void LoginLinkonFooterofSendReferralpage() {

		driver.findElement(By.linkText("Login")).click();

	}

	// DEMO LINK ON THE FOOTER OF SEND REFERRAL PAGE

	public WebElement DemoLiinkonFooterofSendReferralpage() {

		WebElement click = driver.findElement(By.linkText("Demo"));
		return click;
	}

	// SIGN UP LINK ON THE FOOTER OF SEND REFERRAL PAGE

	public WebElement SignUpLiinkonFooterofSendReferralpage() {

		WebElement click = driver.findElement(By.linkText("Sign Up"));
		return click;

	}

	// ABOUT US LINK ON THE FOOTER OF SEND REFERRAL PAGE

	public WebElement AboutUsLinkonFooterofSendReferralpage() {

		WebElement click = driver.findElement(By.linkText("About Us"));
		return click;

	}

	// CLICK ON DENTAL INSURANCE SECTION

	public WebElement ClickOnDentalInsuranceSection() {

		return driver.findElement(By.linkText("Dental Insurance"));

	}

	// CLICK ON DENTAL HISTORY SECTION
	public void ClickOnDentalHistorySection() {

		// ClickOnDentalHistory.click();
		driver.findElement(By.linkText("Dental History")).click();
	}

	// RETURN LATEST DOWNLOADED FILE

	public File getLatestFilefromDir(String dirpath) {

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

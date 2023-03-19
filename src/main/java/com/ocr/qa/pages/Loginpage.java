package com.ocr.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ocr.qa.base.TestBase;

public class Loginpage extends TestBase {

//***** P A G E - F A C T O R Y *****
	
	//PAGE TITLE
	@FindBy(how=How.XPATH,using="//h1[contains(@class,'mb-2')]")
	@CacheLookup 
	WebElement pagetitle; 
	
	//LOGINPAGE-IMAGE-LOGO
	//@FindBy(how=How.XPATH,using="//img[@class='mb-2'][@alt='One Click Referral Logo']")
	 @FindBy(how=How.CSS,using="#btnLink > img")
	@CacheLookup 
	WebElement loginlogo;
	
	//USERNAME
	//@FindBy(how=How.XPATH,using="(//input[@id='Username'])[1]")
	@FindBy(how=How.XPATH,using=".//div//input[@id='Username' and @placeholder='Enter your username']")
//	@FindBy(how=How.CSS,using="#Username") 
	@CacheLookup
	WebElement username;
	
	//PASSWORD
	@FindBy(how=How.XPATH,using=".//div//input[@id='Password' and @placeholder='Enter your password']")
	@CacheLookup
	WebElement password; 
	
	//SUBMIT BUTTON
	@FindBy(how=How.XPATH,using="//span[text()='Sign in']")
	@CacheLookup
	WebElement submit;
	
	//FORGET-PASSW-LINK
	@FindBy(how=How.LINK_TEXT,using="Forgot password?")
	@CacheLookup
	WebElement forget_passw_link; 
	
  //INITIALIZING THE OBJECTS -------
	public Loginpage(){
		
		PageFactory.initElements(driver,this);	
	}
	
  //ACTION-------
	
	//VALIDATION ON PAGE TITLE
	public String validatepagetitle(){
		
		return pagetitle.getText();
	}
	
	//VALIDATION ON LOGO IMAGE
	public boolean validateimglogo(){
		
		return loginlogo.isDisplayed();	
	}
	
	//FORGET PASSWORD LINK  
	public void forgetpassword(){
		
		forget_passw_link.click();
		
	}
	
	//USER-LOGIN 
	//AFTER LOGIN RETURN DASHBOARDPAGE
	public Dashboardpage login(String un,String pw) throws InterruptedException{
		
		try{
		    
			 driver.switchTo().alert().accept();
             driver.switchTo().defaultContent();
			 
		    }
	
		    catch(NoAlertPresentException Ex){
		        System.out.println("The execption is: " + Ex);
		        
		    }
		    finally {
		        System.out.println("If no exception tell me now");
		        
               
             //   WebElement user = driver.findElement(By.xpath("//*[@id=\"Username\"]"));
                Thread.sleep(1000);
				//ENTER USERNAME
                WebDriverWait wait = new WebDriverWait(driver,30);
                WebElement username =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div//input[@id='Username' and @placeholder='Enter your username']")));
                username.sendKeys(un);
                
			//	WebDriverWait wait = new WebDriverWait(driver, 60);
			//  wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(username))
			//	.sendKeys(un);
				
				Thread.sleep(1000);
				
				//ENTER PASSWORD
				
				 WebDriverWait wait1 = new WebDriverWait(driver,30);
	             WebElement password =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div//input[@id='Password' and @placeholder='Enter your password']")));
	             password.sendKeys(pw);
				
				
			//	WebDriverWait wait1 = new WebDriverWait(driver, 60);
			//    wait1.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(password))
			//	.sendKeys(pw);
			 
			    Thread.sleep(1000);
				//Submit button 
			    
			    WebDriverWait wait2 = new WebDriverWait(driver,30);
	            WebElement submit =  wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Sign in']")));
	            submit.click();
			    
			    
			//	WebDriverWait wait2 = new WebDriverWait(driver, 60);
			 //   wait2.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(submit))
			//	.click();
				    
	 
		    }    
		
		
		
		return new Dashboardpage();  
		   
	}
	
	
	
	public void ExplicitWait(WebElement elementToBeLoaded){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elementToBeLoaded))
		.click();
		
	}
	
    public String ExplicitWaitGetText(WebElement elementToBeLoaded){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elementToBeLoaded))
	    .getText();
		
	}
	
    public void ExplicitWaitClear(WebElement elementToBeLoaded){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elementToBeLoaded))
		.clear();
		
	}
	
    public void ExplicitWaitSendKeys(WebElement elementToBeLoaded,String sendkey){
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elementToBeLoaded))
		.sendKeys(sendkey);
		
	}
	
	public void CloseChatPopup(){
		
		driver.switchTo().frame("drift-widget");
		   try{ WebElement dismiss = driver.findElement(By.xpath("//button[@title='Dismiss']"));
		        
		        Actions action = new Actions (driver);
			    action.moveToElement(dismiss).perform();
			    Thread.sleep(3000);
			    action.click(dismiss).perform();
		        Thread.sleep(3000);
		      
			}
			catch(Exception ex){
				
				System.out.println(ex);
				
			}
			
		   finally{
		    	   
			   driver.switchTo().parentFrame();
			   
		    }
			
	}
	
	
}

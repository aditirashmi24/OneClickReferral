package com.ocr.qa.utility;

import com.ocr.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long  PAGE_LOAD_TIMEOUT = 20 ;
	public static long IMPLICIT_WAIT = 10;
	
	public void switchtoFrame(){
		
		driver.switchTo().frame("");
	}
	
	
	

	
	
}

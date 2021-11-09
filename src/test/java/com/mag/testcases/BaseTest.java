package com.mag.testcases;

import org.testng.annotations.AfterSuite;

import com.mag.base.Page;

public class BaseTest {
	
	
	@AfterSuite
	public void tearDown() {
		 Page.quit();	
	}
	

}
 
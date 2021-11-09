package com.mag.pages.crm;

import org.openqa.selenium.By;

import com.mag.base.Page;

public class CRMDefaultPage extends Page{
	
	public void veifyPageTitle() {
		System.out.println(driver.getTitle());
	}
	
	public CRMHomePage goToAccessZoho() {
		click("accezzzoho_XPATH");
		return new CRMHomePage();
	}

}

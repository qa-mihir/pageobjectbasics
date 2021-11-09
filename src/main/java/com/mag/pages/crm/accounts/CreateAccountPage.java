package com.mag.pages.crm.accounts;

import org.openqa.selenium.By;

import com.mag.base.Page;

public class CreateAccountPage extends Page{
	
	public void createAccount(String accountName) {
		type("accountname_ID",accountName);
	}

}

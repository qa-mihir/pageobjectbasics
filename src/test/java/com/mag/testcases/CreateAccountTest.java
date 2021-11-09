package com.mag.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mag.base.Page;
import com.mag.pages.ZohoAppPage;
import com.mag.pages.crm.CRMDefaultPage;
import com.mag.pages.crm.accounts.AccountsPage;
import com.mag.pages.crm.accounts.CreateAccountPage;
import com.mag.utilities.Utilities;

public class CreateAccountTest {
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data){
		
		ZohoAppPage zp = new ZohoAppPage();
		CRMDefaultPage crmdp = zp.goToCRM();
		crmdp.goToAccessZoho();
		AccountsPage account = Page.menu.goToAccounts();
		CreateAccountPage ca = account.goToCreateAccounts();
		ca.createAccount(data.get("accountname"));
			
	}

}

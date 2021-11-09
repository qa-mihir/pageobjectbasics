package com.mag.pages.crm;

import org.openqa.selenium.By;

import com.mag.base.Page;
import com.mag.pages.crm.accounts.AccountsPage;

public class CRMHomePage extends Page {

	public void verifyCRMHome() {
		driver.getTitle();
	}

	public void goToLeads() {
		click("leads_LINKTEXT");
	}

	public void goToContacts() {
		click("contacts_LINKTEXT");
	}

	public AccountsPage goToAccounts() {
		click("accounts_LINKTEXT");
		return new AccountsPage();
	}

	public void goToDeals() {
		click("deals_LINKTEXT");
	}

	public void goToTasks() {
		click("tasks_LINKTEXT");
	}

	public void goToMarketplace() {
		click("marketplace_LINKTEXT");
	}

	public void goTosearchModules() {
		click("searchmodules_XPATH");
	}

}

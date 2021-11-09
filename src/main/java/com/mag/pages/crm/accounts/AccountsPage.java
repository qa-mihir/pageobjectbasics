package com.mag.pages.crm.accounts;

import org.openqa.selenium.By;

import com.mag.base.Page;
import com.mag.base.TopMenu;

public class AccountsPage extends Page {

	public CreateAccountPage goToCreateAccounts() {
		click("createaccount_XPATH");
		return new CreateAccountPage();
	}

	public ImportAccountPage goToImportAccounts() {
		click("importaccounts1_XPATH");
		click("importaccounts2_LINKTEXT");
		return new ImportAccountPage();
	}

	public ImportNotesPage goToImportNotes() {
		click("importnotes1_XPATH");
		click("importnotes2_LINKTEXT");
		return new ImportNotesPage();
	}

}

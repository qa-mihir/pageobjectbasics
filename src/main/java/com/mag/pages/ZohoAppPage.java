package com.mag.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.mag.base.Page;
import com.mag.pages.crm.CRMDefaultPage;
import com.mag.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page {

	public CRMDefaultPage goToCRM() {
		clickOnLink("block_XPATH", 0);
		return new CRMDefaultPage();
	}

	public void goToMail() {
		clickOnLink("block_XPATH", 1);
	}

	public void goToDesk() {
		clickOnLink("block_XPATH", 2);
	}

	public void goToAssist() {
		clickOnLink("block_XPATH", 3);
	}

	public void goToBooks() {
		clickOnLink("block_XPATH", 4);
	}

	public void goToAnalytics() {
		clickOnLink("block_XPATH", 5);
	}

	public void goToCreator() {
		clickOnLink("block_XPATH", 6);
	}

	public void goToSocial() {
		clickOnLink("block_XPATH", 7);
	}

}

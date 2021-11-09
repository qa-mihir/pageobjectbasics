package com.mag.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mag.base.Page;

public class HomePage extends Page {

	public void goToProducts() {
		click("products_XPATH");
	}

	public void goToEnterprise() {
		click("enterprise_LINKTEXT");
	}

	public void goToSupport() {
		click("support_LINKTEXT");
	}

	public void goToCustomers() {
		click("customers_LINKTEXT");
	}

	public void goToSignUp() {
		click("signuplink_XPATH");
	}

	public LoginPage goToLogin() {
		click("loginlink_XPATH");
		return new LoginPage();
	}

	public void goToCRM() {
		clickOnLink("rightmenu_XPATH", 0);
	}

	public void goToMail() {
		clickOnLink("rightmenu_XPATH", 1);
	}

	public void goToDesk() {
		clickOnLink("rightmenu_XPATH", 2);
	}

	public void goToAssist() {
		clickOnLink("rightmenu_XPATH", 3);
	}

	public void goToAnalytics() {
		clickOnLink("rightmenu_XPATH", 4);
	}

	public void goToExploreBtn() {
		click("exlporebtn_XPATH");
	}

	public void validateFooterLinks() {

	}

	public void goToTryZohoOne() {
		driver.findElement(By.linkText("Try zoho one")).click();
	}

}

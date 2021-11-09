package com.mag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mag.base.Page;

public class LoginPage extends Page {

	public ZohoAppPage doLogin(String username, String password) {

		type("loginid_ID", username);
		click("nextbtn_ID");
		type("password_ID", password);
		click("nextbtn_ID");

		return new ZohoAppPage();

	}

	public void loginUsingGoogle() {

	}

	public void loginUsingMS() {

	}

	public void loginUsingLinkedIn() {

	}

	public void loginUsingFacebook() {

	}

	public String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void goToSignUp() {
		click("signup_LINKTEXT");
	}

}

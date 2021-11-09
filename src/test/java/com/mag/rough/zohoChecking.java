package com.mag.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mag.base.HomeTopMenuPage;
import com.mag.base.Page;
import com.mag.base.TopMenu;
import com.mag.pages.HomePage;
import com.mag.pages.LoginPage;
import com.mag.pages.ZohoAppPage;
import com.mag.pages.crm.CRMDefaultPage;
import com.mag.pages.crm.CRMHomePage;
import com.mag.pages.crm.accounts.AccountsPage;
import com.mag.pages.crm.accounts.CreateAccountPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class zohoChecking {

	public static void main(String[] args) throws InterruptedException {


		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();
		ZohoAppPage zp = lp.doLogin("folor.automation@gmail.com", "Devilhunter69");
		CRMDefaultPage crmdp = zp.goToCRM();
		crmdp.goToAccessZoho();
		AccountsPage account = Page.menu.goToAccounts();
		CreateAccountPage ca = account.goToCreateAccounts();
		ca.createAccount("Firstname");
		Page.menu.signOut();
		
		
		
	}

}
 
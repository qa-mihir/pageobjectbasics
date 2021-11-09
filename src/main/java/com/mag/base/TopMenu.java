package com.mag.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mag.pages.crm.accounts.AccountsPage;

public class TopMenu{
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> menuNav() {
		List<WebElement> menu = driver.findElements(By.xpath("//div[@class='lyteMenuItems']/div/a"));
		return menu;
	}

	public void goToHome() {
		menuNav().get(0).click();
	}

	public void goToLeads() {
		menuNav().get(1).click();
	}

	public void goToContacts() {
		menuNav().get(2).click();
	}

	public AccountsPage goToAccounts() {
		menuNav().get(3).click();
		return new AccountsPage();
	}

	public void goToDeals() {
		menuNav().get(4).click();
	}
 
	public void goToTasks() {
		menuNav().get(5).click();
	}

	public void goToMarketplace() {
		menuNav().get(6).click();
	}
	
	public void signOut() {
		driver.findElement(By.id("dropclk")).click();
		driver.findElement(By.xpath("//lyte-yield[text()='Sign Out']")).click();	
	}

}

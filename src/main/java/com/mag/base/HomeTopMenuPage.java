package com.mag.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeTopMenuPage {
	
	WebDriver driver;
	
	public HomeTopMenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> headerLinks(){
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='zgh-nav active']/ul/li"));
		return links;	
	}
	
	public void goToProducts() {
		headerLinks().get(0).click();
	}
	
	public void goToEnterprise() {
		headerLinks().get(1).click();
	}
	
	public void goToSupport() {
		headerLinks().get(2).click();
	}
	
	public void goToCustomers() {
		headerLinks().get(3).click();
	}
	
	public void goToAdditional() {
		headerLinks().get(4).click();
	}
	
	public void signOut() {
		driver.findElement(By.xpath("//div[@class='head-sign-in zh_innr_nav']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}

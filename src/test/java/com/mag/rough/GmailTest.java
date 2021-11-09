package com.mag.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailTest {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(); 
		driver.get("https://www.google.com/intl/en-GB/gmail/about/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("//div[@data-identifier='focustaylor99@gmail.com']")).click();
		driver.findElement(By.name("password")).sendKeys("Devilhunter69!");
		driver.findElement(By.xpath("//td/div[@aria-label='Updates']")).click();
		driver.findElement(By.xpath("(//span[@name='Zoho Team'])[2]")).click();
		
		
		//span[text()='Zoho Team']

	}

}

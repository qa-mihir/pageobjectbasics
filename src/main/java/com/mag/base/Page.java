package com.mag.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mag.listeners.ExtentListeners;
import com.mag.utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\mag\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static String browser;
	public static TopMenu menu;
	public static ExtentTest test;

	/*
	 * Logs Properties - OR, Congif
	 * 
	 */

	public Page(ExtentTest test) {
		this.test = test;
	}

	public Page() {
		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\mag\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded!!!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\mag\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Jenkins browser filter configuration
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
				browser = System.getenv("browser");
			} else {
				browser = config.getProperty("browser");
			}

			config.setProperty("browser", browser);

			if (config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.debug("Firefox launched !!!");
			} else if (config.getProperty("browser").equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				driver = new ChromeDriver(options);
				log.debug("Chrome launched !!!");
			}

			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to: " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
			menu = new TopMenu(driver);

		}

	}

	public static void click(String locator) {

		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_NAME")) {
			driver.findElement(By.name(OR.getProperty(locator))).click();
		}
		log.debug("Clicking on an Element: " + locator);
		test.log(Status.INFO, "Clicking on: " + locator);

	}

	public static void type(String locator, String value) {

		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_NAME")) {
			driver.findElement(By.name(OR.getProperty(locator))).sendKeys(value);
		}
		log.debug("TYping in an Element: " + locator + " and entered values as" + value);
		test.log(Status.INFO, "Typing in: " + locator + " entered value: " + value);

	}

	public static WebElement dropdown;

	public static void select(String locator, String value) {
		if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		} else if (locator.endsWith("_LINKTEXT")) {
			dropdown = driver.findElement(By.linkText(OR.getProperty(locator)));
		} else if (locator.endsWith("_NAME")) {
			dropdown = driver.findElement(By.name(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		log.debug("selecting a value: " + value);
		test.log(Status.INFO, "Selecting from dropdown: " + locator + " value as " + value);

	}

	public static void clickOnLink(String locator, int i) {
		List<WebElement> block;
		String methodName=null;
		if (locator.endsWith("_XPATH")) {
			block = driver.findElements(By.xpath(OR.getProperty(locator)));
			methodName = block.get(i).getText();
			block.get(i).click();			
		} else if (locator.endsWith("_CSS")) {
			driver.findElements(By.cssSelector(OR.getProperty(locator))).get(i).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElements(By.id(OR.getProperty(locator))).get(i).click();
		} else if (locator.endsWith("_LINKTEXT")) {
			driver.findElements(By.linkText(OR.getProperty(locator))).get(i).click();
		} else if (locator.endsWith("_NAME")) {
			driver.findElements(By.name(OR.getProperty(locator))).get(i).click();
		}
		
		log.debug("Clicking on an element: " + methodName);
		test.log(Status.INFO, "Clicking on: " + methodName);
	}

	public static void quit() {
		driver.quit();
	}

	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {

			return false;
		}

	}

}

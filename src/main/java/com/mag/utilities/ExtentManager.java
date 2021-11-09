package com.mag.utilities;


import java.io.File;
import java.io.IOException;

import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mag.base.Page;


public class ExtentManager extends Page {

	private static ExtentReports extent;
	public static String screenshotPath;
	public static String screenshotName;

	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Focus");
		extent.setSystemInfo("Organization", "Automation inc");
		extent.setSystemInfo("Build no", "Focus-1234");

		return extent;
	}

	public static void captureScreenshot() {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		try {
			FileUtils.copyFile(scrFile,
					new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

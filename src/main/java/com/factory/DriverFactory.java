package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initializeDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions op = new ChromeOptions();
			// op.addArguments("headless");
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
			// WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(op));
		} else if (browser.equalsIgnoreCase("firefox")) {
			// WebDriverManager.firefoxdriver().setup();

			tlDriver.set(new FirefoxDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

}

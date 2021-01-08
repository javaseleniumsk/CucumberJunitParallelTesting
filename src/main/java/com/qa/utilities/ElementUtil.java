package com.qa.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pages.LoginPage;

public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public boolean webDriverWaitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOf((element)));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean waitForPageToLoad(int timeOut) {
		int loopCount = 0;
		do {
			loopCount++;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String text = (String) js.executeScript("return document.readyState");
			if (text.equalsIgnoreCase("complete")) {
				return true;
			}
		} while (loopCount < timeOut);
		return false;

	}

	public void elementIsDisplayed(LoginPage button) {
		boolean buttonExists = false;
		int count = 0;
		do {
			try {
				buttonExists = button.signInButtonDisplayed();
				if (buttonExists)
					break;

			} catch (Exception e) {

			}
		} while (count < 10);
		Assert.assertTrue(buttonExists);
	}

}

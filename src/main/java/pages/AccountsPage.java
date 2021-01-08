package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;
	private By signOut = By.cssSelector("[class='logout']");
	private By myCreditSlips = By.xpath("//span[text()='My credit slips']");
	private By orderHistory = By.xpath("//span[text()='Order history and details']");
	private By myAddresses = By.xpath("//span[text()='My addresses']");
	private By myPersonalInfo = By.xpath("//span[text()='My personal information']");
	private By myWishList = By.xpath("//span[text()='My wishlists']");
	private By myAccountTabs = By.xpath("//*[@class='col-xs-12 col-sm-6 col-lg-4']/descendant::span");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public List<WebElement> myAccountTabs() {

		return driver.findElements(myAccountTabs);
	}

	public WebElement signOut() {
		return driver.findElement(signOut);
	}

	public boolean signOutIsDisplayed() {
		return driver.findElement(signOut).isDisplayed();
	}

	public boolean myCreditSlipsIsDisplayed() {
		return driver.findElement(myCreditSlips).isDisplayed();
	}

}

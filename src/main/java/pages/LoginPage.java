package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	private By signIn = By.cssSelector("a[class='login']");
	private By email = By.id("email");
	private By password = By.id("passwd");
	private By forgotPassword = By.xpath("//a[contains(.,'Forgot your password')]");
	private By signInButton = By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement signInButton() {
		return driver.findElement(signInButton);
	}

	public void setEmail(String emailID) {
		driver.findElement(email).sendKeys(emailID);
	}

	public void setPassword(String sPassword) {
		driver.findElement(password).sendKeys(sPassword);
	}

	public void signInClick() {
		driver.findElement(signIn).click();
	}

	public void signInButtonClick() {
		driver.findElement(signInButton).click();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean forgotPasswordExists() {
		return driver.findElement(forgotPassword).isDisplayed();
	}

	public boolean signInButtonDisplayed() {
		return driver.findElement(signInButton).isDisplayed();
	}

	public AccountsPage login(String user, String pass) {
		driver.findElement(email).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);

	}
}

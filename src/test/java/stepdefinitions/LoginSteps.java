package stepdefinitions;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.qa.utilities.ElementUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

	private String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ElementUtil util;

	@Given("user is in login page {string}")
	public void user_is_in_login_page(String url) {
		DriverFactory.getDriver().get(url);
	}

	@Given("has clicked on signin button")
	public void has_clicked_on_signin_button() throws InterruptedException {
		util = new ElementUtil(DriverFactory.getDriver());
		loginPage.signInClick();
		util.elementIsDisplayed(loginPage);
		// Assert.assertTrue(util.webDriverWaitForElement(loginPage.signInButton()));
		// util.waitForPageToLoad(10);
	}

	@When("the user captures the title of the page")
	public void the_user_captures_the_title_of_the_page() {
		title = loginPage.getTitle();
	}

	@Then("{string} should be the title")
	public void should_be_the_title(String expectedTitle) {
		Assert.assertTrue(title.equalsIgnoreCase(expectedTitle));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.forgotPasswordExists());
	}

	@When("user enter username {string}")
	public void user_enter_username(String emailID) {
		loginPage.setEmail(emailID);
	}

	@When("enters password {string}")
	public void enters_password(String sPassword) {
		loginPage.setPassword(sPassword);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		loginPage.signInButtonClick();
	}

}

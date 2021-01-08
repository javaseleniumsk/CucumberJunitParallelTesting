package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.factory.DriverFactory;
import com.qa.utilities.ElementUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AccountsPage;
import pages.LoginPage;

public class AccountsSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accPage;
	private ElementUtil util = new ElementUtil(DriverFactory.getDriver());
	private List<String> tabNames;

	@Given("the user is logged into the application {string}")
	public void the_user_is_logged_into_the_application(String url, DataTable users) {
		DriverFactory.getDriver().get(url);
		String user, pass;
		List<Map<String, String>> loginCred = users.asMaps();
		user = loginCred.get(0).get("username");
		pass = loginCred.get(0).get("password");
		System.out.println(user + " " + pass);
		loginPage.signInClick();
		util.elementIsDisplayed(loginPage);
		accPage = loginPage.login(user, pass);
	}

	@Given("user is in accounts page")
	public void user_is_in_accounts_page() {
		Assert.assertEquals("My account - My Store", accPage.getTitle());
	}

	@Then("verify signout button is displayed")
	public void verify_signout_button_is_displayed() {
		Assert.assertTrue(accPage.signOutIsDisplayed());

	}

	@Then("user gets the account tabs")
	public void user_gets_the_account_tabs(DataTable dataTable) {
		List<String> expTabNames = dataTable.asList();
		List<WebElement> tabs = accPage.myAccountTabs();
		tabNames = new ArrayList<String>();
		for (WebElement tab : tabs) {
			tabNames.add(tab.getText());
		}
		System.out.println(tabNames);
		System.out.println(expTabNames);
		Assert.assertTrue(expTabNames.equals(tabNames));
	}

	@Then("Account section should have <{int}> tabs")
	public void account_section_should_have_tabs(Integer tab) {
		Integer size = tabNames.size();
		System.out.println("Actual size:" + size);
		System.out.println("Expected Size:" + tab);
		Assert.assertTrue(tab == size);
	}

}

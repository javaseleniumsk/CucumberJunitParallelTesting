package AppHooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.qa.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private WebDriver driver;
	private DriverFactory driverFactory;
	private ConfigReader reader;
	private Properties prop;

	@Before(order = 0)
	public void getProperty() {
		reader = new ConfigReader();
		prop = reader.getProp();

	}

	@Before(order = 1)
	public void launchBrowser() {
		driverFactory = new DriverFactory();
		driver = driverFactory.initializeDriver(prop.getProperty("browser"));
	}

	@After(order = 1)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 0)
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			// capture screenshot
			String screenShot = scenario.getName().replaceAll(" ", "_");
			byte[] path = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(path, "image/png", screenShot);

		}
	}

}

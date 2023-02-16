package stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Base;

public class Hooks {

	@Before
	public void browserLaunch() {
		Base.browsers("chrome");
		Base.url("https://www.accessibility.com/digital-lawsuits/page/1");
	}
	
	@AfterStep
	public void screenshot(Scenario scenario) {
		TakesScreenshot ts = (TakesScreenshot)Base.driver;
		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", "passed");
	}

	@AfterStep
	public void failedScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot)Base.driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "failed");
		}
	}

	@After
	public void tearDown() {
		Base.quit();
	}
}

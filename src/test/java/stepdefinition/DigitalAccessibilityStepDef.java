package stepdefinition;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.DigitalAccessibilityPage;
import utilities.Base;

public class DigitalAccessibilityStepDef extends Base{
	
	DigitalAccessibilityPage digitalAccessPage;
	List<WebElement> listOfNames;

	@Given("On Digital Accessibility Lawsuits scroll down on recent Lawsuits")
	public void on_digital_accessibility_lawsuits_scroll_down_on_recent_lawsuits() {
	    digitalAccessPage = new DigitalAccessibilityPage(driver);
	    commonWait(20);
	    scrollByElement(digitalAccessPage.getRecentLawsuits());
		
	}
	@When("locating the Plaintiff and Defendant in recent lawsuits")
	public void locating_the_plaintiff_and_defendant_in_recent_lawsuits() {
	   listOfNames = digitalAccessPage.getPlaintiffAndDefendantNames();
	}
	@Then("get the name from the palintiff and defendant")
	public void get_the_name_from_the_palintiff_and_defendant() {
	    for(WebElement names : listOfNames) {
	    	System.out.println(retreiveText(names));
	    }
	}
}

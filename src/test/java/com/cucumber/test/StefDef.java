package com.cucumber.test;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPageFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StefDef {
	WebDriver driver;
	SeleniumPageFactory pf;

	@Given("open any browser")
	public void open_any_browser() {
		driver = DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);

	}

	@Given("go to application URL")
	public void go_to_application_URL() {
		driver.navigate().to(Constants.URL);

		ScreenShot.getScreenShot(driver, "Homepage");

		// explicit wait=WebDriver wait
	   pf = new SeleniumPageFactory(driver);

	}

	@When("click signin button")
	public void click_signin_button() {
		// click sign in
		HighLighter.getColor(driver, pf.getSigninBtn().get(0));
		pf.getSigninBtn().get(0).click();
		ScreenShot.getScreenShot(driver, "Login Page");

	}

	@When("put email")
	public void put_email() {
		HighLighter.getColor(driver, pf.getEmail(), "red");
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);

	}

	@When("put password")
	public void put_password() {
		HighLighter.getColor(driver, pf.getPassword(), "red");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.passWord);

	}

	@When("click second signin button")
	public void click_second_signin_button() {
		HighLighter.getColor(driver, pf.getSecondSigninBtn());
		pf.getSecondSigninBtn().click();
		ScreenShot.getScreenShot(driver, "Login Validation");

	}

	@Then("validate login was succesful")
	public void validate_login_was_succesful() {
		boolean status = pf.getWelcome().get(0).isDisplayed();
		// Assertion = Hard & soft
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);// condition =true or false

		sa.assertAll();// validation

	}

}
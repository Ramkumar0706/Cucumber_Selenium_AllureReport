package com.allBirds.qa.stepDefinitions;

import com.allBirds.qa.base.TestBase;
import com.allBirds.qa.pages.HomePage;
import com.allBirds.qa.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStep extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	@Given("the user is on the Login Page")
	public void the_user_is_on_the_login_page() {
		init();  // Initializes the browser and opens the URL
		homePage=new HomePage();
		
	}

	@When("the user enters valid login credentials")
	public void the_user_enters_valid_login_credentials() {
		loginPage = homePage.viewAccount();
		homePage = loginPage.login("ramkumar908040@gmail.com", "Ramkumar@07062002");
		driver.navigate().to("https://www.allbirds.com/");
	}

	@When("the user enters invalid login credentials")
	public void the_user_enters_invalid_login_credentials() {
		loginPage = homePage.viewAccount();
		loginPage.login("ramkumar908040@gmail.com", "Ramkumar@0706");
		driver.navigate().to("https://www.allbirds.com/");
	}

	@Then("the user should be redirected to the Home Page")
	public void the_user_should_be_redirected_to_the_home_page() {
		String actualTitle = homePage.validateHomePageTitle();
		Assert.assertEquals("Home - AllBirds", actualTitle);
	}

	@Then("an error message should be displayed for invalid login")
	public void an_error_message_should_be_displayed_for_invalid_login() {
		homePage.viewAccount();
		loginPage.login("ramkumar908040@gmail.com", "Ramkumar@0706");
		boolean isErrorMessageDisplayed = loginPage.validateErrorMessageForInvalidLogin();
		Assert.assertTrue("Error message should be displayed for incorrect login.", isErrorMessageDisplayed);
	}

	@Then("the title of the Login Page should be validated")
	public void the_title_of_the_login_page_should_be_validated() {
		homePage.viewAccount();
		String actualTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals("Login - AllBirds", actualTitle);
	}

	@Then("the email and password fields should be enabled")
	public void the_email_and_password_fields_should_be_enabled() {
		homePage.viewAccount();
		boolean areFieldsEnabled = loginPage.validateEmailAndPasswordFields();
		Assert.assertTrue("Email and password fields should be enabled.", areFieldsEnabled);
	}

	@Then("the Sign-in button should be enabled")
	public void the_sign_in_button_should_be_enabled() {
		homePage.viewAccount();
		boolean isSignInButtonEnabled = loginPage.validateSignInButton();
		Assert.assertTrue("Sign-in button should be enabled.", isSignInButtonEnabled);
	}

	@Then("the Log out button should be displayed after successful login")
	public void the_log_out_button_should_be_displayed_after_successful_login() {
		//homePage.viewAccount();
		boolean isLogOutButtonDisplayed = loginPage.validateLogOutButton();
		Assert.assertTrue("Log out button should be displayed after successful login.", isLogOutButtonDisplayed);
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			logger.info("Browser closed after the test.");
		}
	}
}

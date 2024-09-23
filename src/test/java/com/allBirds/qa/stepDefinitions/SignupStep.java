package com.allBirds.qa.stepDefinitions;

import com.allBirds.qa.base.TestBase;
import com.allBirds.qa.pages.HomePage;
import com.allBirds.qa.pages.LoginPage;
import com.allBirds.qa.pages.SignupPage;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SignupStep extends TestBase {
    SignupPage signupPage;
    HomePage homePage;

    @Given("the user is on the Signup Page")
    public void the_user_is_on_the_signup_page() {
        init();
        homePage=new HomePage();
    }

    @When("the user enters valid details in the Signup form")
    public void the_user_enters_valid_details_in_the_signup_form() {
       
       
          SignupPage signupPage = homePage.register();
        homePage = signupPage.signUp("Ram", "Kumar", "ramkumar908040@gmail.com", "Ramkumar@0706", "Ramkumar@0706");
        driver.navigate().to("https://www.allbirds.com/");
    }

    @Then("the user is redirected to the Home Page")
    public void the_user_is_redirected_to_the_home_page() {
        String title = homePage.validateHomePageTitle();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), title);
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed after the test.");
        }
    }
}

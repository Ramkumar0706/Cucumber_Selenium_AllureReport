package com.allBirds.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.allBirds.qa.base.TestBase;

public class SignupPage extends TestBase {

    public static Logger logger = Logger.getLogger(SignupPage.class);

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "CreatePassword")
    WebElement password;

    @FindBy(id = "CustomerPasswordConfirmation")
    WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"create_customer\"]/input[8]")
    WebElement register;

    public SignupPage() {
        PageFactory.initElements(driver, this);
        logger.info("SignupPage elements initialized.");
    }

    public HomePage signUp(String firstName, String lastName, String email, String password, String confirmPassword) {
        logger.info("Filling in signup details: FirstName=" + firstName + ", LastName=" + lastName + ", Email=" + email);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        logger.info("Submitting signup form.");
        register.click();
        return new HomePage();
    }
    
    public boolean validateSignUpButton() {
        logger.info("Validating that the Register button is displayed and enabled.");
        return register.isDisplayed() && register.isEnabled();
    }

    public boolean validateFields() {
        logger.info("Validating that the signup fields are displayed and enabled.");
        return firstName.isDisplayed() && lastName.isDisplayed() && email.isDisplayed() && password.isDisplayed() && confirmPassword.isDisplayed();
    }

    public String validateSignupPageTitle() {
        String title = driver.getTitle();
        logger.info("Signup page title: " + title);
        return title;
    }
}

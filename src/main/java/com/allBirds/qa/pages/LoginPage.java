package com.allBirds.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.allBirds.qa.base.TestBase;

public class LoginPage extends TestBase {

    public static Logger logger = Logger.getLogger(LoginPage.class);

    @FindBy(name = "customer[email]")
    WebElement email;

    @FindBy(name = "customer[password]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/input[5]")
    WebElement signIn;
    
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div/ul/li")
    WebElement errorMessage;
    
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/a")
    WebElement logOut;

    public LoginPage() {
        PageFactory.initElements(TestBase.driver, this);
        logger.info("LoginPage elements initialized.");
    }

    public HomePage login(String email, String password) {
        logger.info("Attempting login with email: " + email);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        signIn.click();
        logger.info("Login form submitted.");
        return new HomePage();
    }
    
    public String validateLoginPageTitle() {
        String actualTitle = driver.getTitle();
        logger.info("Validating login page title:  "+", Actual - " + actualTitle);
        return actualTitle;
    }
    
    public boolean validateEmailAndPasswordFields() {
        logger.info("Validating email and password fields are enabled.");
        return email.isDisplayed()&&password.isDisplayed();
    }
    
    public boolean validateSignInButton() {
        logger.info("Validating that the Sign-in button is displayed and enabled.");
        return signIn.isDisplayed() && signIn.isEnabled();
    }

    public boolean validateErrorMessageForInvalidLogin() {
        logger.info("Validating the error message for incorrect login credentials.");
        return errorMessage.isDisplayed();
    }
    
    public boolean validateLogOutButton() {
        logger.info("Validating the error message for incorrect login credentials.");
        return logOut.isDisplayed();
    }
    
    
}

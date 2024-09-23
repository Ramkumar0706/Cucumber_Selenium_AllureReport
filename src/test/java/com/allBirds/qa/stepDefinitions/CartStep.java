package com.allBirds.qa.stepDefinitions;

import com.allBirds.qa.base.TestBase;
import com.allBirds.qa.pages.CartPage;
import com.allBirds.qa.pages.CollectionsPage;
import com.allBirds.qa.pages.HomePage;
import com.allBirds.qa.pages.LoginPage;
import com.allBirds.qa.pages.ProductPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.junit.Assert;

public class CartStep extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    CollectionsPage collectionsPage;
    ProductPage productPage;
    CartPage cartPage;

    @Before
    public void setUp() {
        init();
        homePage = new HomePage();
        cartPage = new CartPage();
    }

    @Given("the user is on the Home Page")
    public void the_user_is_on_the_home_page() {
        driver.navigate().to("https://www.allbirds.com/");
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        loginPage = homePage.viewAccount();
        homePage = loginPage.login(data.getProperty("email"), data.getProperty("password"));
    }

    @When("the user adds {string} to the cart")
    public void the_user_adds_to_the_cart(String productName) {
        collectionsPage = homePage.viewMensProduct(productName);
        productPage = collectionsPage.productPage();
        homePage = productPage.selectProduct();
        driver.switchTo().defaultContent();
        homePage.viewCart();
    }
    @Given("the user navigates to the cart")
    public void the_user_navigates_to_the_cart() {
        homePage.viewCart();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

package com.allBirds.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.allBirds.qa.base.TestBase;

public class SearchPage extends TestBase {

    public static Logger logger = Logger.getLogger(SearchPage.class);

    @FindBy(id = "SearchBarMinimal__input")
    WebElement search;

    @FindBy(xpath = "//*[@id=\"SearchBarMinimal__input\"]")
    WebElement searchResults;

    public SearchPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void searchContent(String searchName) {
        logger.info("Searching for content: " + searchName);
        search.sendKeys(searchName);
        }

    public boolean validateSearchResults() {
        logger.info("Validating search results are displayed.");
        return searchResults.isDisplayed();
    }

    public boolean validateSearchField() {
        logger.info("Validating that the search field is displayed and enabled.");
        System.out.println(search.isDisplayed()+" "+search.isEnabled());
        return search.isDisplayed() && search.isEnabled();
    }

    public String validateSearchPageTitle() {
        String title = driver.getTitle();
        logger.info("Search page title: " + title);
        return title;
    }
}

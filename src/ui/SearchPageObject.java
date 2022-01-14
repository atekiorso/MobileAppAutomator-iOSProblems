package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public abstract class SearchPageObject extends CorePageObject {
    protected static String
            SEARCH_INPUT_FIELD,
            CANCEL_SEARCH_BUTTON,
            SEARCH_RESULTS_CONTAINER,
            SEARCH_RESULT_TITLE,
            RESULT_BY_TITLE_AND_DESCRIPTION_TEMPLATE,
            RESULTS_TITLES;

    public SearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void sendKeysToSearchInputField(String searchText) {
        this.waitForElementAndSendKeys(SEARCH_INPUT_FIELD, searchText);
    }

    public void clickCancelSearchButton() {
        this.waitForElementAndClick(CANCEL_SEARCH_BUTTON);
    }

    public void clickArticleTitleInSearchResults(String title) {
        final String searchResultXpath = getArticleTitleInSearchResultsXpath(title);
        waitForElementAndClick(searchResultXpath);
    }

    public void waitForResultsPresent() {
        this.waitForElementPresent(SEARCH_RESULTS_CONTAINER);
    }

    public void waitForResultsNotPresent() {
        this.waitForElementNotPresent(SEARCH_RESULTS_CONTAINER);
    }

    public void waitForElementByTitleAndDescription(String title, String description) {
        final String resultXpath = getArticleTitleInSearchResultsXpath(title, description);
        this.waitForElementPresent(resultXpath, LONG_WAITING_TIMEOUT_IN_SECONDS);
    }

    public List<WebElement> getResultsTitles() {
        return this.getElements(RESULTS_TITLES);
    }

    /* TEMPLATES METHODS */
    private String getArticleTitleInSearchResultsXpath(String title) {
        return this.replaceSubstringInTemplate(SEARCH_RESULT_TITLE, title);
    }

    private String getArticleTitleInSearchResultsXpath(String title, String description) {
        List<String> replacements = Arrays.asList(title, description);
        return this.replaceSubstringsInTemplate(RESULT_BY_TITLE_AND_DESCRIPTION_TEMPLATE, replacements);
    }
    /* TEMPLATES METHODS */
}

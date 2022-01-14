package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public abstract class ArticlePageObject extends CorePageObject {
    public static String
            // Android and iOS
            ARTICLE_TITLE,
            BACK_BUTTON,
            SAVE_TO_READING_LIST_BUTTON,
            // Android only
            GOT_IT_BUTTON,
            // iOS only
            ADD_TO_READING_LIST_BUTTON;

    public ArticlePageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void clickSaveToReadingListButton() {
        this.waitForElementAndClick(SAVE_TO_READING_LIST_BUTTON, LONG_WAITING_TIMEOUT_IN_SECONDS);
    }

    public void clickBackButton() {
        this.waitForElementAndClick(BACK_BUTTON);
    }

    public String getArticleTitleTextAndroid() {
        WebElement articleTitle = this.waitForElementPresent(ARTICLE_TITLE);
        return articleTitle.getText();
    }

    public String getArticleTitleTextIos(String articleTitleText) {
        final String articleTitleLocator;

        articleTitleLocator = getArticleTitleLocatorFromTemplate(articleTitleText);
        WebElement articleTitle = this.waitForElementPresent(articleTitleLocator);

        return articleTitle.getText();
    }

    public void clickGotItButtonAndroid() {
        this.waitForElementAndClick(GOT_IT_BUTTON, LONG_WAITING_TIMEOUT_IN_SECONDS);
    }

    public void clickAddToReadingListButtonIos(String articleTitle) {
        final String addToReadingListButtonXpath = getAddToReadingListButtonLocatorFromTemplate(articleTitle);
        this.waitForElementAndClick(addToReadingListButtonXpath, LONG_WAITING_TIMEOUT_IN_SECONDS);
    }

    /* TEMPLATES METHODS */
    private String getArticleTitleLocatorFromTemplate(String articleTitleText) {
        return this.replaceSubstringInTemplate(ARTICLE_TITLE, articleTitleText);
    }

    private String getAddToReadingListButtonLocatorFromTemplate(String articleTitleText) {
        return this.replaceSubstringInTemplate(ADD_TO_READING_LIST_BUTTON, articleTitleText);
    }
    /* TEMPLATES METHODS */
}

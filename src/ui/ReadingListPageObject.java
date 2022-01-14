package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public abstract class ReadingListPageObject extends CorePageObject {
    public static String
            // Android and iOS
            CREATE_NEW_BUTTON,
            READING_LIST_NAME_FIELD,
            CONFIRM_CREATION_BUTTON = "id:android:id/button1",
            // Android only
            GOT_IT_BUTTON = "id:org.wikipedia:id/onboarding_button",
            // iOS only
            MY_LISTS_BUTTON = "accessibility_id:My lists",
            EXISTING_READING_LIST_TEMPLATE = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/item_title'][@text='{" +
                    REPLACEABLE_TEMPLATE_SUBSTRING + "}']",
            ARTICLE_IN_READING_LIST_TEMPLATE = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{" +
                    REPLACEABLE_TEMPLATE_SUBSTRING + "}']/..";

    public ReadingListPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void clickGotItButtonAndroid() {
        this.waitForElementAndClick(GOT_IT_BUTTON);
    }

    public void clickCreateNewButton() {
        this.waitForElementAndClick(CREATE_NEW_BUTTON);
    }

    public void sendKeysToReadingListNameInputField(String readingListName) {
        this.waitForElementAndSendKeys(READING_LIST_NAME_FIELD, readingListName);
    }

    public void clickConfirmCreationButton() {
        this.waitForElementAndClick(CONFIRM_CREATION_BUTTON);
    }

    public void addArticleToNewReadingList(String readingListName) {
        this.waitForElementAndClick(CREATE_NEW_BUTTON);

        enterReadingListName(readingListName);
        clickInputReadingListOkButton();
    }

    public void clickExistingReadingList(String readingListName) {
        final String existingReadingListLocator = getExistingReadingListLocator(readingListName);
        this.waitForElementAndClick(existingReadingListLocator);
    }

    public void removeArticleFromReadingList(String readingListName, String articleTitle) {
        openReadingList(readingListName);
        final String articleInReadingListXpath = getArticleInReadingListXpath(articleTitle);
        this.waitForElementAndSwipeLeft(articleInReadingListXpath);
    }

    public void openMyLists() {
        this.waitForElementAndClick(MY_LISTS_BUTTON);
    }

    public void openReadingList(String readingListName) {
        final String readingListXpath = getExistingReadingListLocator(readingListName);
        this.waitForElementAndClick(readingListXpath);
    }

    public void openArticleFromCurrentReadingList(String articleTitle) {
        final String articleXpath = getArticleInReadingListXpath(articleTitle);
        this.waitForElementAndClick(articleXpath);
    }

    public boolean isArticlePresentInCurrentReadingList(String articleTitle) {
        final String articleXpath = getArticleInReadingListXpath(articleTitle);
        return this.isElementPresent(articleXpath);
    }

    private void enterReadingListName(String readingListName) {
        this.waitForElementAndSendKeys(READING_LIST_NAME_FIELD, readingListName);
    }

    private void clickInputReadingListOkButton() {
        this.waitForElementAndClick(CONFIRM_CREATION_BUTTON);
    }

    private String getExistingReadingListLocator(String readingListName) {
        return this.replaceSubstringInTemplate(EXISTING_READING_LIST_TEMPLATE, readingListName);
    }

    /* TEMPLATES METHODS */
    private String getArticleInReadingListXpath(String articleTitle) {
        return this.replaceSubstringInTemplate(ARTICLE_IN_READING_LIST_TEMPLATE, articleTitle);
    }
    /* TEMPLATES METHODS */
}

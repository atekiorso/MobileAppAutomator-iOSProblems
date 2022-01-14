package ui.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        ARTICLE_TITLE = "id:org.wikipedia:id/view_page_title_text";
        SAVE_TO_READING_LIST_BUTTON = "accessibility_id:Add this article to a reading list";
        GOT_IT_BUTTON = "id:org.wikipedia:id/onboarding_button";
        BACK_BUTTON = "accessibility_id:Navigate up";
    }

    public AndroidArticlePageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}

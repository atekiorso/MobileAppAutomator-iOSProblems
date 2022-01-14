package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.ArticlePageObject;

public class IosArticlePageObject extends ArticlePageObject {
    static {
        ARTICLE_TITLE = "id:{SUBSTRING}";
        SAVE_TO_READING_LIST_BUTTON = "id:Save for later";
        ADD_TO_READING_LIST_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Add “{SUBSTRING}” to a reading list?']";
        //ADD_TO_READING_LIST_BUTTON = "xpath://*[contains(@name, 'to a reading list?')]";
        //ADD_TO_READING_LIST_BUTTON = "id:Add “{SUBSTRING}” to a reading list?";
        BACK_BUTTON = "id:Search";
    }

    public IosArticlePageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}

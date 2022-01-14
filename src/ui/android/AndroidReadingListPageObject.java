package ui.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.ReadingListPageObject;

public class AndroidReadingListPageObject extends ReadingListPageObject {
    static {
        CREATE_NEW_BUTTON = "id:org.wikipedia:id/create_button";
        READING_LIST_NAME_FIELD = "id:org.wikipedia:id/text_input";
        CONFIRM_CREATION_BUTTON = "id:android:id/button1";
        GOT_IT_BUTTON = "id:org.wikipedia:id/onboarding_button";
        EXISTING_READING_LIST_TEMPLATE = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/item_title'][@text='{SUBSTRING}']";
        ARTICLE_IN_READING_LIST_TEMPLATE = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{SUBSTRING}']/..";
    }

    public AndroidReadingListPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}

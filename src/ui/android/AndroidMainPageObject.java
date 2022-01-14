package ui.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.MainPageObject;

public class AndroidMainPageObject extends MainPageObject {
    static {
        SEARCH_CONTAINER = "id:org.wikipedia:id/search_container";
    }

    public AndroidMainPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}

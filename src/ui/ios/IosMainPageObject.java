package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.MainPageObject;

public class IosMainPageObject extends MainPageObject {
    static {
        SEARCH_CONTAINER = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia' and not(following-sibling::*)]";
    }

    public IosMainPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}

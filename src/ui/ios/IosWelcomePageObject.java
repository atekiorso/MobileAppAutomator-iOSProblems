package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.WelcomePageObject;

public class IosWelcomePageObject extends WelcomePageObject {
    static {
        SKIP_BUTTON = "xpath://XCUIElementTypeButton[@name='Skip']";
    }

    public IosWelcomePageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}

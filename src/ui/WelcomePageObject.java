package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public abstract class WelcomePageObject extends CorePageObject{
    protected static String SKIP_BUTTON;

    public WelcomePageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void clickSkipButton() {
        this.waitForElementAndClick(SKIP_BUTTON);
    }
}

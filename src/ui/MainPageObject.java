package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public abstract class MainPageObject extends CorePageObject {
    protected static String SEARCH_CONTAINER;

    public MainPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void clickSearchContainer() {
        this.waitForElementAndClick(SEARCH_CONTAINER);
    }
}

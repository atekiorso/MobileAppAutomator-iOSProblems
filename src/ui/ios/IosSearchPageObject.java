package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.SearchPageObject;

public class IosSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INPUT_FIELD = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia' and (following-sibling::XCUIElementTypeButton[@name='Cancel'])]";
        CANCEL_SEARCH_BUTTON = "";
        SEARCH_RESULTS_CONTAINER = "";
        SEARCH_RESULT_TITLE = "id:{" + REPLACEABLE_TEMPLATE_SUBSTRING + "}";
    }

    public IosSearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }
}

package ui.factories;

import io.appium.java_client.AppiumDriver;
import libs.Platform;
import org.openqa.selenium.WebElement;
import ui.SearchPageObject;
import ui.android.AndroidSearchPageObject;
import ui.ios.IosSearchPageObject;

public class SearchPageObjectFactory {
    public static SearchPageObject get(AppiumDriver<WebElement> driver) throws Exception {
        SearchPageObject searchPageObject;
        final String platformNameFromEnv = Platform.getInstance().getPlatformNameFromEnv();

        switch (platformNameFromEnv) {
            case Platform.ENV_PLATFORM_ANDROID:
                searchPageObject = new AndroidSearchPageObject(driver);
                break;
            case Platform.ENV_PLATFORM_IOS:
                searchPageObject = new IosSearchPageObject(driver);
                break;
            default:
                searchPageObject = null;
                break;
        }

        return searchPageObject;
    }
}

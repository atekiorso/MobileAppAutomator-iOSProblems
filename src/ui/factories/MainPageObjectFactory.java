package ui.factories;

import io.appium.java_client.AppiumDriver;
import libs.Platform;
import org.openqa.selenium.WebElement;
import ui.MainPageObject;
import ui.android.AndroidMainPageObject;
import ui.ios.IosMainPageObject;

public class MainPageObjectFactory {
    public static MainPageObject get(AppiumDriver<WebElement> driver) throws Exception {
        MainPageObject mainPageObject;
        String platformNameFromEnv = Platform.getInstance().getPlatformNameFromEnv();

        switch (platformNameFromEnv) {
            case Platform.ENV_PLATFORM_ANDROID:
                mainPageObject = new AndroidMainPageObject(driver);
                break;
            case Platform.ENV_PLATFORM_IOS:
                mainPageObject = new IosMainPageObject(driver);
                break;
            default:
                mainPageObject = null;
                break;
        }

        return mainPageObject;
    }
}

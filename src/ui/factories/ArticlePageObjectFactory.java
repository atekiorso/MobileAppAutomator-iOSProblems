package ui.factories;

import io.appium.java_client.AppiumDriver;
import libs.Platform;
import org.openqa.selenium.WebElement;
import ui.ArticlePageObject;
import ui.android.AndroidArticlePageObject;
import ui.ios.IosArticlePageObject;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(AppiumDriver<WebElement> driver) {
        final String platformNameFromEnv = Platform.getInstance().getPlatformNameFromEnv();
        ArticlePageObject articlePageObject;

        switch (platformNameFromEnv) {
            case Platform.ENV_PLATFORM_ANDROID:
                articlePageObject = new AndroidArticlePageObject(driver);
                break;
            case Platform.ENV_PLATFORM_IOS:
                articlePageObject = new IosArticlePageObject(driver);
                break;
            default:
                articlePageObject = null;
                break;
        }

        return articlePageObject;
    }
}

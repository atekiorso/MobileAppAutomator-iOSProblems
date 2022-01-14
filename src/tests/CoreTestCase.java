package tests;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import libs.Platform;
import org.openqa.selenium.WebElement;

public class CoreTestCase extends TestCase {
    protected AppiumDriver<WebElement> driver;
    protected Platform platform;

    protected void setUp() throws Exception {
        driver = Platform.getInstance().getDriverByPlatformFromEnv();
    }

    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

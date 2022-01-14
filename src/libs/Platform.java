package libs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {
    private static Platform instance;
    private static final String
            APPIUM_URL = "http://127.0.0.1:4723/wd/hub",
            ENV_PLATFORM_NAME = "PLATFORM_NAME";
    public static final String
            ENV_PLATFORM_ANDROID = "android",
            ENV_PLATFORM_IOS = "ios";

    private Platform() {}

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }

        return instance;
    }

    public AppiumDriver<WebElement> getDriverByPlatformFromEnv() throws Exception {
        final String platformNameFromEnv = getPlatformNameFromEnv();
        AppiumDriver<WebElement> driver;

        switch (platformNameFromEnv) {
            case ENV_PLATFORM_ANDROID:
                driver = getAndroidDriver();
                break;
            case ENV_PLATFORM_IOS:
                driver = getIOSDriver();
                break;
            default:
                throw new IllegalArgumentException("Из переменной окружения '" + ENV_PLATFORM_NAME + "' не удалось определить тестируемую платформу: '" +
                        platformNameFromEnv + "'");
        }

        return driver;
    }

    private AndroidDriver<WebElement> getAndroidDriver() throws Exception {
        return new AndroidDriver<>(new URL(APPIUM_URL), getAndroidCapabilities());
    }

    private IOSDriver<WebElement> getIOSDriver() throws Exception {
        return new IOSDriver<>(new URL(APPIUM_URL), getIOSCapabilities());
    }

    private DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "and80");
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wikipedia");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".main.MainActivity");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/admin/IdeaProjects/MobileAppAutomator/MobileAppAutomator-Ex11/apks/org.wikipedia.apk");

        return capabilities;
    }

    private DesiredCapabilities getIOSCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/admin/IdeaProjects/MobileAppAutomator/MobileAppAutomator-Ex11/apks/wikipedia.app");

        return capabilities;
    }

    public boolean isAndroid() {
        return isPlatform(ENV_PLATFORM_ANDROID);
    }

    public boolean isIOS() {
        return isPlatform(ENV_PLATFORM_IOS);
    }

    private boolean isPlatform(String platformName) {
        String platformNameFromEnv = getPlatformNameFromEnv();
        return platformName.equals(platformNameFromEnv);
    }

    public String getPlatformNameFromEnv() {
        return System.getenv(ENV_PLATFORM_NAME);
    }
}

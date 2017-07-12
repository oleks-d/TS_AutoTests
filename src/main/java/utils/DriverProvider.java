package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;  //імпортуємо необхідні бібліотеки
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

/**
 * Created by odiachuk on 13.12.16.
 */
public class DriverProvider {

    static String OS_EXTENTION = (System.getProperty("os.name").toLowerCase().contains("win")) ? ".exe" : "_mac";
    static String FIREFOX_PATH = "drivers/geckodriver" + OS_EXTENTION;
    static String CHROME_PATH = "drivers/chromedriver" + OS_EXTENTION;

    //private static WebDriver instance;
    public static ThreadLocal<WebDriver> instance = new ThreadLocal<WebDriver>();

    static String BROWSER_NAME = "unknown";

    static public FirefoxDriver getFirefox() {

        System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);

        DesiredCapabilities caps = DesiredCapabilities.firefox();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        return new FirefoxDriver(caps);

    }

    static public ChromeDriver getChrome(){

        System.setProperty("webdriver.chrome.driver", CHROME_PATH);

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.OFF);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        return new ChromeDriver(caps);

    }

    public static WebDriver getDriver() {
        //if (instance == null)
        if (instance.get() == null)
            if (FileIO.getConfigProperty("Driver").equals("ff")) {
                BROWSER_NAME = "Firefox";
                //instance = getFirefox();
                instance.set(getFirefox());
            }
            else{
                BROWSER_NAME = "Chrome";
                //instance = getChrome();
                instance.set(getChrome());
            }

        //return instance;
        return instance.get();
    }

    public static void closeDriver(){
        //instance.quit();
        instance.get().quit();
        //instance = null;
        instance.set(null);
    }

    public static String getCurrentBrowserName() {
        return BROWSER_NAME;
    }
}

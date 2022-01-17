package uk.mercedes.tests.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import uk.mercedes.tests.helpers.Config;

public class Driver {

    public static WebDriver driver;
    private static Config config = new Config();

    public static WebDriver getDriver() {
        if (driver != null) return driver;
        driver = getInstance();
        return driver;
    }

    private static WebDriver getInstance() {
        String browser = config.properties.getProperty("DEFAULT_BROWSER");
        String geckoDriverPath = config.properties.getProperty("GECKO_DRIVER_PATH");
        String chromeDriverPath = config.properties.getProperty("CHROME_DRIVER_PATH");
        String parBrowser = System.getProperty("browser");

        browser = parBrowser != null ? parBrowser.toLowerCase() : browser;
        try {
            switch (browser.trim().toLowerCase()) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", geckoDriverPath);
                    return new FirefoxDriver();
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    return new ChromeDriver();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}

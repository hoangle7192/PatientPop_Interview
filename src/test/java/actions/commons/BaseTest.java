package actions.commons;

import commons.BrowserList;
import commons.EnvironmentList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    public String getEnvironmentTest(String environmentName) {
        String url = null;
        EnvironmentList urlName = EnvironmentList.valueOf(environmentName.toUpperCase());
        if (urlName == EnvironmentList.STAGING) {
            url = GlobalConstants.STAGING;
        } else if (urlName == EnvironmentList.DEV) {
            url = GlobalConstants.DEV;
        } else if (urlName == EnvironmentList.TEST) {
            url = GlobalConstants.TEST;
        }
        return url;
    }

    public WebDriver getBrowserDriver(String browserName, String environmentName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        switch (browser) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                options.addExtensions(new File(GlobalConstants.ADBLOCK_EXTENSION_OF_CHROME));
                driver = new ChromeDriver(options);
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxoptions = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                profile.addExtension(new File(GlobalConstants.ADBLOCK_EXTENSION_OF_FIREFOX));
                driver = new FirefoxDriver(firefoxoptions);
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case H_CHROME -> {
                WebDriverManager.chromedriver().setup();
                options.addArguments("--headless");
                options.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(options);
            }
            default -> throw new IllegalArgumentException("This Browser Is Not Support");
        }
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getEnvironmentTest(environmentName));
        return driver;
    }

    public WebDriver getDriverInstance() {
        return this.driver;
    }

    public void quitDriver() {
        driver.quit();
    }

    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(999999);
    }
}

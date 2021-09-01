package managers;

import dataProvider.ConfigFile_BardBG_Reader;
import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    ConfigFile_BardBG_Reader configFileReader;

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfig_BardBG_Reader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfig_BardBG_Reader().getEnvironment();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver()
                        .browserVersion(configFileReader.getBrowserVersion()).setup();
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER:
                driver = new InternetExplorerDriver();
                break;
        }

        if (FileReaderManager.getInstance().getConfig_BardBG_Reader().getBrowserWindowSize())
            driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(FileReaderManager.getInstance().getConfig_BardBG_Reader().getImplicitlyWait(),
                        TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}

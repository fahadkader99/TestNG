package automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;

    public WebDriver initializeDriver() {

        Properties prop = new Properties();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/test/resources/config/data.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            // initialize firefox driver
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("opera")) {
            // initialize opera driver
            driver = new OperaDriver();
        }

        // Implicit timeout - applies all the test cases
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        return driver;

    }
}

package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverUtils {

    public  WebDriver driver;

    public  WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        prop.load(new FileReader("src/test/resources/config/login.properties"));



        String browserName = prop.getProperty("browser");


        if (browserName.equals("chrome")){
            // execute chrome
            System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
            driver = new ChromeDriver();

        }else if (browserName.equals("firefox")){

            System.setProperty("webdriver.gecko.driver","src/test/resources/driver/geckodriver");
            driver = new FirefoxDriver();

        }else if (browserName.equals("edge")){

            System.setProperty("webdriver.edge.driver","src/test/resources/driver/msedgedriver");
            driver = new EdgeDriver();

        }else if (browserName.equals("safari")){

            System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
            driver = new SafariDriver();
        }

        driver.get(DataReader.getProperty("app.url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));



        return driver;

    }

}

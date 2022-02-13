package com.automation.utils;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverUtils {

    static WebDriver driver;

    public static void createDriver(){
        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/test/resources/config/data.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        driver.get(PropertyReader.getProperty("app.url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

    }

    public static WebDriver getDriver(){
        return  driver;
    }



}

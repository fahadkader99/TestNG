package com.automation.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static String getProperty(String key){

        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/test/resources/config/data.properties"));
        } catch (IOException e) {
            System.out.println("Exception found on Property:::: "+ e);
        }

        return prop.getProperty(key);
    }
}

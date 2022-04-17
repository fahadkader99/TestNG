package test.java.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Property_Reader {


    public static String getProperty(String key){

        Properties properties = new Properties();

        try {
            properties.load(new FileReader("src/test/resources/config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }
}

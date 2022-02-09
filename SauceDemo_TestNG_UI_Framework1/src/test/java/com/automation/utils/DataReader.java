package com.automation.utils;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataReader {

    public static String getProperty(String key){

        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/test/resources/config/login.properties"));
        }catch (IOException  e){
            System.out.println(" >> Exception found on property: "+ e);
        }
        return prop.getProperty(key);

    }
}

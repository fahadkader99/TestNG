/*
1. Setup    - open the browser and application
2. Login
3. close
 */

import org.testng.annotations.Test;

public class FirstTestCase {

    @Test(priority = 3)           // based on @Test, testNG recognize as test method
    void setUp(){
        // usually selenium codes are written here.
        System.out.println("Opening browser");
    }
    @Test(priority = 1)
    void firstTest(){
        System.out.println("Test 1: Checking the connection");
    }
    @Test(priority = 2)
    void secondTest(){
        System.out.println("Test 2: SSH connection is secure");
    }

    @Test(priority = 4)
    void logIn(){
        System.out.println("This is login test");
    }

    @Test(priority = 5)
    void tearDown(){
        System.out.println("Closing the browser ..!");
    }

}

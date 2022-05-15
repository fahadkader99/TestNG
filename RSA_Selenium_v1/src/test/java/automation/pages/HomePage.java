package automation.pages;

import automation.tests.Base;
import org.testng.annotations.Test;

public class HomePage extends Base {

    @Test
    public void basePageNavigation(){

        driver = initializeDriver();
        driver.get("http://qaclickacademy.com");
    }
}

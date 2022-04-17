package test.java.tests;

import org.testng.annotations.Test;

public class Script_1 extends Base_Test{


    @Test
    public void logIn_Test(){
        loginPage.doLogin();
        loginPage.click_logOnBtn();
        homePage.validate_all_links();
        homePage.user_click_logoutBtn();
    }


}

package test.java.tests;

import org.testng.annotations.Test;

public class Script_1 extends Base_Test{


    @Test(priority = 1)
    public void logIn_Test() throws Exception{
        logger = extent.createTest("Login-in Test");

        loginPage.doLogin();
        loginPage.click_logOnBtn();
        homePage.navigate_to_homePage();
        homePage.validate_all_links();
        homePage.user_click_logoutBtn();
    }


}

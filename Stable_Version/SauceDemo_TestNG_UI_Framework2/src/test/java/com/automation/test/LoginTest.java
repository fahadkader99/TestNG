package com.automation.test;

import org.testng.annotations.Test;

public class LoginTest extends Base_Test{

    @Test
    public void verifyUserCanLogIn(){
        logInPage.doLogin();

        homePage.verifyUserAtHomePage();
    }
}

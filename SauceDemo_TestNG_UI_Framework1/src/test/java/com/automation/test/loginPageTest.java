package com.automation.test;

import org.testng.annotations.Test;

public class loginPageTest extends BaseTest{

    @Test
    public void verifyUserCanLogIn(){

        loginPage.doLogin();

        homePage.verifyUserAtHomePage();

    }


}

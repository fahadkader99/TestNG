package com.automation.test;

import org.testng.annotations.Test;

public class HomepageTest extends BaseTest{

    @Test
    public void userCanLogOutFromHomePage(){

        loginPage.doLogin();

        homePage.verifyUserAtHomePage();

        homePage.clickOnBurgerMenu();

        homePage.clickLogOutBtn();

        loginPage.verifyUserAtLoginPage();

    }

}

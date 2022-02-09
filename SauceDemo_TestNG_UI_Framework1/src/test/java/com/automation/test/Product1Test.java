package com.automation.test;

import org.testng.annotations.Test;

public class Product1Test extends BaseTest{

    @Test
    public void verifyProductDetailPage(){

        loginPage.doLogin();

        homePage.verifyUserAtHomePage();

        homePage.clickOnBackPack();

        productPage1.verifyProduct1DetailPage();

        productPage1.clickAddToCartButtonProduct1();

        productPage1.clickOnCartIcon1();


    }
}

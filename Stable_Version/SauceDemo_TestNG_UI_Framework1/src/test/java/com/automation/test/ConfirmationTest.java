package com.automation.test;

import org.testng.annotations.Test;

public class ConfirmationTest extends BaseTest{

    @Test
    public void verifyOrderConfirmationTest(){
        loginPage.doLogin();

        homePage.verifyUserAtHomePage();

        homePage.clickOnBackPack();

        productPage1.verifyProduct1DetailPage();

        productPage1.clickAddToCartButtonProduct1();

        productPage1.clickOnCartIcon1();

        cartPage.verifyUserOnCartPage();

        cartPage.clickOnCheckoutButton();

        checkoutPage.fillOutCheckoutDetail();

        checkoutPage.clickContinueButton();

        overviewPage.verifyOverViewPage();

        overviewPage.clickFinishButton();

        confirmationPage.verifyOrderConfirmationPage();

        confirmationPage.printOderCompleteMessage();

    }


}

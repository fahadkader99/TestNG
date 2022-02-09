package com.automation.test;

import org.testng.annotations.Test;

public class TshirtTest extends Base_Test{

    @Test
    public void verifyUserIsAtT_ShirtDetailPage(){
        logInPage.doLogin();

        homePage.verifyUserAtHomePage();

        homePage.clickOnItemBikeLight();

        bikeLightPage.verifyUserAtBikeLightProductPage();

        bikeLightPage.clickAddToCartButtonBikeLight();

        bikeLightPage.clickOnCartIcon_bikeLight();

        cartPage.verifyUserIsAtCartPage();

        cartPage.userClickOnContinueShoppingButton();

        homePage.clickOnItemT_shirt();

        tshirtPage.verifyUserIsAtT_shirtPage();

        tshirtPage.clickOnAddToCartButtonT_shirt();

        tshirtPage.userClickOnCartIcon_tShirt();
    }
}

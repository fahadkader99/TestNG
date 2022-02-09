package com.automation.test;

import org.testng.annotations.Test;

public class CheckoutTest extends Base_Test{

    @Test
    public void verifyUserIsAbleToFillOutCheckOutPage(){
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

        cartPage.verifyUserIsAtCartPage();

        cartPage.clickOnCheckOutButton();

        checkoutPage.fillOutCheckoutDetail();

        checkoutPage.clickContinueButton();

    }

}

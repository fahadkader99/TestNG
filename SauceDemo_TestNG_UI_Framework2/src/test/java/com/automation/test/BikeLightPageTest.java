package com.automation.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class BikeLightPageTest extends Base_Test{
    //public static Logger Log = LogManager.getLogger(base.class.getName());

    @Test
    public void verifyUserIsAbleToClickOnBikeLightItem(){
        logInPage.doLogin();

        homePage.verifyUserAtHomePage();

        homePage.clickOnItemBikeLight();

        bikeLightPage.verifyUserAtBikeLightProductPage();

        bikeLightPage.clickAddToCartButtonBikeLight();

        bikeLightPage.clickOnCartIcon_bikeLight();
    }
}

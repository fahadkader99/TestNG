package com.automation.test;

import com.automation.pages.*;
import com.automation.utils.DataReader;
import com.automation.utils.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.imageio.IIOException;
import java.io.IOException;

public class BaseTest extends DriverUtils {

    LoginPage loginPage;
    HomePage homePage;
    ProductPage1 productPage1;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;
    ConfirmationPage confirmationPage;

    @BeforeMethod
    public void startUp() throws IOException {
        driver = initializeDriver();

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productPage1 = new ProductPage1(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
        confirmationPage = new ConfirmationPage(driver);




    }

    @AfterMethod
    public void closeUp() throws IOException {
        driver.close();
    }

}

package test.java.tests;

import org.testng.annotations.Test;
import test.java.pages.HomePage;

public class Script_3 extends Base_Test{


    @Test(priority = 3)
    public void validate_event_Was_created_successfully() throws Exception{
        logger = extent.createTest("Validate Event Test");

        loginPage.doLogin();
        loginPage.click_logOnBtn();

        homePage.navigate_to_homePage();
        homePage.getEventNumber();
        homePage.click_search_compliance();

        editCompliancePage.search_event();
        editCompliancePage.click_searchBtn();
        editCompliancePage.click_event();
        editCompliancePage.verifyFields();

        eventPage.logout();

    }
}

package test.java.tests;

import org.testng.annotations.Test;

public class Script_4 extends Base_Test{

    @Test(priority = 4)
    public void delete_events_test() throws Exception{
        logger = extent.createTest("Delete Event Test");

        loginPage.doLogin();
        loginPage.click_logOnBtn();

        homePage.navigate_to_homePage();
        homePage.getEventNumber();
        homePage.click_search_compliance();

        editCompliancePage.search_event();
        editCompliancePage.click_searchBtn();
        editCompliancePage.click_event();
        editCompliancePage.click_delete();

        eventPage.logout();


    }
}

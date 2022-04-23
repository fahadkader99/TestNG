package test.java.tests;

import org.testng.annotations.Test;

public class Script_2 extends Base_Test{


    @Test(priority = 2)
    public void create_new_compliance_event() throws Exception {
        logger = extent.createTest("Create Event Test");

        loginPage.doLogin();
        loginPage.click_logOnBtn();

        homePage.navigate_to_homePage();
        homePage.click_add_compliance_link();

        eventPage.selectDates();
        eventPage.select_dropDowns();
        eventPage.send_even_summary();
        eventPage.send_event_description();

        eventPage.workFlow_selection();
        eventPage.eventDetails_selection();

        eventPage.click_saveAndClose();
        eventPage.logout();




    }




}

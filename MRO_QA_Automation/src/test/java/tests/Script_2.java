package test.java.tests;

import org.testng.annotations.Test;

public class Script_2 extends Base_Test{


    @Test
    public void create_new_compliance_event() throws Exception {
        loginPage.doLogin();
        loginPage.click_logOnBtn();

        homePage.navigate_to_homePage();
        homePage.click_add_compliance_link();

        eventPage.selectDates();
        eventPage.select_dropDowns();
        eventPage.send_even_summary();
        eventPage.send_event_description();


    }




}

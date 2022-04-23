package test.java.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;
import test.java.tests.Base_Test;

import test.java.utils.Property_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class EventPage extends Base_Page{


    @FindBy(xpath = "//span[@class='k-select']")
    private WebElement eventDate;

    @FindBy(xpath = "//td[@role='gridcell']/a[@title='Friday, April 15, 2022']")
    private WebElement april15Event;

    @FindBy(xpath = "(//span[@class='k-icon k-i-calendar'])[2]")
    private WebElement discoveryDate;

    @FindBy(xpath = "(//a[@class='k-link' and @title='Friday, April 22, 2022'])[2]")
    private WebElement april15Discovery;

    @FindBy(id = "OrganizationId")
    private WebElement organization;

    @FindBy(xpath = "(//select[@class='form-control'])[2]")
    private WebElement department;

    @FindBy(xpath = "(//select[@class='form-control'])[3]")
    private WebElement source;

    @FindBy(xpath = "(//select[@class='form-control'])[4]")
    private WebElement category;

    @FindBy(xpath = "(//select[@class='form-control'])[5]")
    private WebElement subCategory;

    @FindBy(xpath = "//input[@id='EventSummary']")
    private WebElement eventSummaryBox;

    @FindBy(xpath = "//textarea[@id='EventDescription']")
    private WebElement eventDescriptionBox;

    @FindBy(id = "StatusId")
    private WebElement statusTab;

    @FindBy(id = "PHERelated")
    private WebElement publicHealth;

    @FindBy(id = "SpecialProject")
    private WebElement specialProject;

    @FindBy(id = "HotLineNumber")
    private WebElement hotLine;

    @FindBy(id = "LegalReview")
    private WebElement legalReview;

    @FindBy(id = "AttorneyPriviledge")
    private WebElement attorneyClient;

    @FindBy(id = "AttorneyInvolved")
    private WebElement attorneyInvolved;

    @FindBy(xpath = "//input[@type='submit' and @name='SaveAndClose']")
    private WebElement saveClose;

    @FindBy(id = "OwnerId")
    private WebElement owner;

    @FindBy(xpath = "//div[@role='listbox']")
    private WebElement assignedTo;

    @FindBy(xpath = "(//li[@class='k-item'])[2]")
    private WebElement assignedTo2;

    @FindBy(xpath = "(//span[@class='k-icon k-i-calendar'])[3]")
    private WebElement dueDateTab;

    @FindBy(xpath = "//a[@title='Saturday, April 30, 2022']")
    private WebElement dueDateApril30;

    @FindBy(xpath = "//div/a[@id='AccountDropdown']")
    private WebElement userDropDown;

    @FindBy(xpath = "//a[@href='/Auth/Account/logoff']")
    private WebElement logOutBtn;







    public void selectDates(){
        Base_Test.logger.info("Selecting Event date");
        eventDate.click();
        april15Event.click();

        Base_Test.logger.info("Selecting Discovery date");
        discoveryDate.click();
        april15Discovery.click();


    }

    public void select_dropDowns(){
        Base_Test.logger.info("Clicking organization dropdown from Edit event page");
        organization.click();
        Select org = new Select(organization);
        org.selectByVisibleText("Evergreen Hospital");

        Base_Test.logger.info("Clicking department dropdown from Edit event page");
        department.click();
        Select dept = new Select(department);
        dept.selectByIndex(0);                      // change If don't work

        Base_Test.logger.info("Clicking source dropdown from Edit event page");
        source.click();
        Select src = new Select(source);
        src.selectByValue("27");

        Base_Test.logger.info("Clicking category dropdown from Edit event page");
        category.click();
        Select cat = new Select(category);
        cat.selectByIndex(3);

        Base_Test.logger.info("Clicking sub-category dropdown from Edit event page");
        subCategory.click();
        Select sub = new Select(subCategory);
        sub.selectByIndex(0);

    }
    public void send_even_summary() throws Exception{

        File file = new File("src/test/resources/data/summary.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        Base_Test.logger.info("Sending text to event summary from data file");
        String text;
        while ((text=reader.readLine())!=null){
            eventSummaryBox.sendKeys(text);
        }

    }

    public void send_event_description() throws Exception{
        File file1 = new File("src/test/resources/data/description.txt");
        FileReader fr1 = new FileReader(file1);
        BufferedReader reader = new BufferedReader(fr1);

        Base_Test.logger.info("Sending text to event description from data file");
        String text1;
        while ((text1= reader.readLine())!=null){
            eventDescriptionBox.sendKeys(text1);
        }
    }

    public void workFlow_selection(){


        // Need to fill up all or event is not saving: [extra steps || out of requirements]

        Base_Test.logger.info("Owner selected from Workflow section");
        owner.click();
        Select select1 = new Select(owner);
        select1.selectByVisibleText("CompMngAdmin test");

        Base_Test.logger.info("Two assignee selected selected from Workflow section");
        assignedTo.click();
        assignedTo2.click();

        // hard coded
        Actions actions = new Actions(driver);
        actions.moveToElement(statusTab).click().perform();


        //statusTab.click();                      // this is as per requirement - status: Open
        Base_Test.logger.info("Status dropdown selected - Open ");
        Select select = new Select(statusTab);
        select.selectByValue("1");

        Base_Test.logger.info("Selecting due date");
        dueDateTab.click();
        dueDateApril30.click();



    }

    public void eventDetails_selection(){

        // Does the requirement says fill-up all or not. Not clear about the requirements

        Base_Test.logger.info("Public Health dropdown selected from Event Details");
        publicHealth.click();
        Select select = new Select(publicHealth);
        select.selectByValue("True");

        Base_Test.logger.info("Special project dropdown selected from Event Details");
        specialProject.click();
        Select select1 = new Select(specialProject);
        select1.selectByValue("True");

        Base_Test.logger.info("Hotline number entered form property file");
        hotLine.sendKeys(Property_Reader.getProperty("hotline"));

        Base_Test.logger.info("Legal review dropdown selected");
        legalReview.click();
        Select select2 = new Select(legalReview);
        select2.selectByValue("True");

        Base_Test.logger.info("Attorney client selected from the dropdown");
        attorneyClient.click();
        Select select3 = new Select(attorneyClient);
        select3.selectByVisibleText("Yes");

        Base_Test.logger.info("Attorney involved name is sent from property file");
        attorneyInvolved.sendKeys(Property_Reader.getProperty("attorney"));

    }

    public void click_saveAndClose(){
        Base_Test.logger.info("User clicked save and Close button");
        saveClose.click();


    }

    public void logout(){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {          // --------------> No idea how to handle this Alert thing!
            e.printStackTrace();
        }
        Base_Test.logger.info("User logged out successfully");
        System.out.println("--> Logging out from: "+driver.getTitle());
        Actions actions = new Actions(driver);
        actions.moveToElement(userDropDown).click().moveToElement(logOutBtn).click().build().perform();
    }



}

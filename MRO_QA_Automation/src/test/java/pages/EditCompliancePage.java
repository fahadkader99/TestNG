package test.java.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.tests.Base_Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class EditCompliancePage extends Base_Page{

    @FindBy(xpath = "//input[@id='EventNumber']")
    private WebElement searchEvenBox;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchBtn;

    @FindBy(xpath = "//td[@role='gridcell']/a")
    private WebElement eventNum;

    @FindBy(xpath = "//input[@name='EventDate']")
    private WebElement eventDate;

    @FindBy(xpath = "//input[@name='DiscoveryDate']")
    private WebElement discoveryDate;

    @FindBy(xpath = "//select[@id='OrganizationId']")
    private WebElement organization;

    @FindBy(xpath = "//select[@id='CategoryId']")
    private WebElement categoryID;

    @FindBy(xpath = "//input[@id='EventSummary']")
    private WebElement eventSummery;

    @FindBy(xpath = "//textarea[@id='EventDescription']")
    private WebElement eventDescription;

    @FindBy(xpath = "//select[@id='StatusId']")
    private WebElement status;

    @FindBy(id = "AttorneyInvolved")
    private WebElement attorneyBox;

    @FindBy(xpath = "//input[@type='submit' and @name='SaveAndClose' ]")
    private WebElement saveClose;

    @FindBy(xpath = "//a[@id='DeleteEventButton']")
    private WebElement deleteEvent;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    private WebElement deleteConfirmed;






    public void search_event() throws Exception{
        // read the text from a file

        File file = new File("src/test/resources/data/event.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String text;
        while ((text=reader.readLine())!=null){
            searchEvenBox.sendKeys(text);
        }

    }
    public void click_searchBtn(){
        Base_Test.logger.info("Clicking Search Button");
        searchBtn.click();
    }
    public void click_event(){
        Base_Test.logger.info("Clicking Event Button");
        eventNum.click();
    }

    public void verifyFields(){
        Base_Test.logger.info("Validating event date");
        System.out.println(eventDate.isDisplayed());

        Base_Test.logger.info("Validating discovery date");
        System.out.println(discoveryDate.isDisplayed());

        Base_Test.logger.info("Validating organization is selected or not");
        System.out.println(organization.isDisplayed());

        Base_Test.logger.info("Validating category ID is selected");
        System.out.println(categoryID.isDisplayed());

        Base_Test.logger.info("Validating event summery is displayed");
        System.out.println(eventSummery.isDisplayed());

        Base_Test.logger.info("Validating event description is");
        System.out.println(eventDescription.isDisplayed());

        Base_Test.logger.info("Validating event status is displayed");
        System.out.println(status.isDisplayed());

        Base_Test.logger.info("Validating attorney box is selected");
        System.out.println(attorneyBox.isDisplayed());

    }

    public void click_saveAndClose(){
        Base_Test.logger.info("Clicking save and close button from edit event page");
        saveClose.click();
    }
    public void click_delete() throws Exception{
        Base_Test.logger.info("Clicking delete Event Button");
        deleteEvent.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-danger']")));
        Base_Test.logger.info(" Delete Confirmed");
        deleteConfirmed.click();
        Thread.sleep(6000);
    }



}

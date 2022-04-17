package test.java.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import test.java.utils.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class EventPage extends Base_Page{

    public Select select;

    @FindBy(xpath = "//span[@class='k-select']")
    private WebElement eventDate;

    @FindBy(xpath = "//td[@role='gridcell']/a[@title='Friday, April 15, 2022']")
    private WebElement april15Event;

    @FindBy(xpath = "(//span[@class='k-icon k-i-calendar'])[2]")
    private WebElement discoveryDate;

    @FindBy(xpath = "(//a[@class='k-link' and @title='Friday, April 15, 2022'])[2]")
    private WebElement april15Discovery;

    @FindBy(xpath = "//select[@class='form-control']")
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




    public void selectDates(){
        eventDate.click();
        april15Event.click();

        discoveryDate.click();
        april15Discovery.click();


    }

    public void select_dropDowns(){
        Select org = new Select(organization);
        org.selectByVisibleText("Cobius Demo1 Hospital ");

        Select dept = new Select(department);
        dept.selectByIndex(0);                      // change if don't work

        Select src = new Select(source);
        src.selectByValue("27");

        Select cat = new Select(category);
        cat.selectByIndex(3);

        Select sub = new Select(subCategory);
        sub.selectByIndex(0);

    }
    public void send_even_summary() throws Exception{

        File file = new File("src/test/resources/data/summary.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String text;
        while ((text=reader.readLine())!=null){
            eventSummaryBox.sendKeys(text, Keys.TAB);
        }

    }

    public void send_event_description() throws Exception{
        File file = new File("src/test/resources/data/description.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String text;
        while ((text= reader.readLine())!=null){
            eventSummaryBox.sendKeys(text);
        }
    }


}

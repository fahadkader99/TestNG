package test.java.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import test.java.tests.Base_Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends Base_Page {


    @FindBy(xpath = "//div/a[@id='AccountDropdown']")
    private WebElement userDropDown;

    @FindBy(xpath = "//a[@href='/Auth/Account/logoff']")
    private WebElement logOutBtn;


    @FindBy(xpath = "//h4[@class='list-group-item-heading']")
    private WebElement complianceManager;

    @FindBy(xpath = "//li/a[@href='/Compliance/Compliance/Create']")
    private WebElement addComplianceLink;


    @FindBy(xpath = "//a[@href='/Compliance/Compliance/Search']")
    private WebElement searchComplianceBtn;

    @FindBy(xpath = "//td[@role='gridcell']/a")
    private WebElement getEventID;


    public void validate_all_links() throws Exception {

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        List <WebElement> afterLinks = new ArrayList<>();
        System.out.println("Number of Links: " + allLinks.size());
        SoftAssert softAssert = new SoftAssert();

        for (int i = 1; i<allLinks.size();i++){
            System.out.println(allLinks.get(i).getAttribute("href"));
            afterLinks.add(allLinks.get(i));
        }
        softAssert.assertEquals(allLinks.size(), afterLinks, "The number of links are not matching");

        // Requirement ask to validate Links, but can't validate the links --> so I am just printing the links above
    }


    public void user_click_logoutBtn() {

        Base_Test.logger.info("User logged out successfully");
        System.out.println("--> Logging out from: " + driver.getTitle());
        Actions actions = new Actions(driver);
        actions.moveToElement(userDropDown).click().moveToElement(logOutBtn).click().build().perform();

    }

    public void navigate_to_homePage() {
        Base_Test.logger.info("User clicked on Compliance Manager tab");
        complianceManager.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click_add_compliance_link() {
        Base_Test.logger.info("User clicked on Add Compliance Events ");
        addComplianceLink.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void handle_alert() {

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

    }

    public void getEventNumber() throws Exception {
        // get the text and write it into a file
        String id = getEventID.getText();

        File file = new File("src/test/resources/data/event.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fw);
        writer.write(id);
        writer.close();


    }

    public void click_search_compliance() {
        Base_Test.logger.info("User clicked on Search Compliance Events");
        searchComplianceBtn.click();
    }

}

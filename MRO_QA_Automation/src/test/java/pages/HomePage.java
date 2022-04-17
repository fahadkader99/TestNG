package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends Base_Page{


    @FindBy(id = "AccountDropdown")
    private WebElement userDropDown;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[3]")
    private WebElement logOutBtn;

    @FindBy(tagName = "a")
    private List<WebElement> allLinks;

    @FindBy(xpath = "//h4[@class='list-group-item-heading']")
    private WebElement complianceManager;

    @FindBy(xpath = "//li/a[contains(text(),' Add Compliance Event')]")
    private WebElement addComplianceLink;








    public void validate_all_links(){

        System.out.println("Number of Links: "+ allLinks.size());

        for (int i=0; i<allLinks.size(); i++){
            System.out.println(allLinks.get(i).getAttribute("href"));
            System.out.println(allLinks.get(i).getText());
        }
    }



    public void user_click_logoutBtn(){
        userDropDown.click();
        logOutBtn.click();
    }

    public void navigate_to_homePage(){
        complianceManager.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(complianceManager));
    }

    public void click_add_compliance_link(){
        addComplianceLink.click();
    }

}

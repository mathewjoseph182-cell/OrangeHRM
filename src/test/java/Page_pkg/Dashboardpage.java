package Page_pkg;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboardpage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboardHeading;

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminTab;

    public Dashboardpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean verifyDashboard() {
        return wait.until(ExpectedConditions.visibilityOf(dashboardHeading)).isDisplayed();
    }

    public void clickAdminTab() {
        wait.until(ExpectedConditions.elementToBeClickable(adminTab)).click();
    }
}

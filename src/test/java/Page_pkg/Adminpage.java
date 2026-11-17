package Page_pkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adminpage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    WebElement usernameSearchBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchBtn;

    @FindBy(className = "oxd-userdropdown-tab")
    WebElement profileDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutBtn;

    public Adminpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void searchAdminUser(String user) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(usernameSearchBox)).sendKeys(user);
        searchBtn.click();
        Thread.sleep(2000); // Gives the search table 2 seconds to load before taking the screenshot
    }

    public void takeScreenshot() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("./Screenshots/AdminSearch.png"));
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(profileDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
    }
}
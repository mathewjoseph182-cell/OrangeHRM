package Test_pkg;

import java.io.IOException;
import org.testng.annotations.Test;
import Base_pkg.BaseClass;
import Page_pkg.Adminpage;

public class AdminTest extends BaseClass {

    @Test
    public void verifyAdminSearchAndLogout() throws IOException, InterruptedException {
        Adminpage ap = new Adminpage(driver);
        ap.searchAdminUser("Admin");
        ap.takeScreenshot();
        ap.logout();
    }
}
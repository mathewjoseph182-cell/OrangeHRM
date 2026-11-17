package Test_pkg;

import org.testng.annotations.Test;
import Base_pkg.BaseClass;
import Page_pkg.Loginpage;

public class LoginTest extends BaseClass {

    @Test
    public void verifyLogin() {
        Loginpage lp = new Loginpage(driver);
        lp.setValues("Admin", "admin123");
        lp.clickLogin();
    }
}
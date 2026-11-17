package Test_pkg;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base_pkg.BaseClass;
import Page_pkg.Dashboardpage;

public class DashboardTest extends BaseClass {

    @Test
    public void verifyDashboardAndNavigate() {
        Dashboardpage dp = new Dashboardpage(driver);
        Assert.assertTrue(dp.verifyDashboard(), "Dashboard is not displayed!");
        dp.clickAdminTab();
    }
}

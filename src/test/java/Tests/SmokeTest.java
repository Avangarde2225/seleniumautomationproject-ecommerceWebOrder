package Tests;

import Pages.loginPage;
import Utilities.browserUtilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SmokeTest extends abstractBaseTest{

    @Test(dataProvider = "smokeTestData")
    public void smokeTest(String component, String expectedPageSubTitle) {
        extentTest = extentReports.createTest("Verify " + component);

        loginPage loginPage = new loginPage();
        loginPage.login();
        loginPage.navigateTo(component);
        browserUtilities.wait(2);
        assertEquals(loginPage.getPageSubtitleText(), expectedPageSubTitle);

        extentTest.pass(component + " verified!");
    }

    @DataProvider(parallel = false) // to execute all tests in parallel
    public Object[][] smokeTestData() {
        return new Object[][]{
                {"View all orders", "List of All Orders"},
                {"View all products", "List of Products"},
                {"Order", "Order"}
        };
    }
}

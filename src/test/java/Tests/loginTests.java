package Tests;

import Pages.loginPage;
import org.testng.annotations.Test;

import static Tests.abstractBaseTest.extentReports;
import static org.testng.AssertJUnit.assertEquals;

public class loginTests extends abstractBaseTest{
    @Test
    public void login(){
        extentTest = extentReports.createTest("Verify page logo");

        loginPage loginPage = new loginPage();
        loginPage.login();
        assertEquals(loginPage.getPageLogoText(), "Web Orders");

        extentTest.pass("Logo verified!");
    }
}

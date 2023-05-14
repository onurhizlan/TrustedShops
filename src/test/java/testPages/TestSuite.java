package testPages;

import baseTest.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void closeBrowser2() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Parameters({"browser"})
    public void trustedShopsCustomerPage() throws InterruptedException {
        mp.pageTitle();
        mp.checkGrade();
        mp.gradeInformation();
        mp.twoStarsReviews();
        mp.sumOfAllStars();

    }

}

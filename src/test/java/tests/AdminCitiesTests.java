package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyAdminCitiesPageUrl(){
        nav.clickOnToolbarLinks(2);

        login.clearAndTypeEmail(email);
        login.clearAndTypePassword(password);
        login.clickOnLoginButton();

        nav.clickOnAdminButton();
        nav.clickOnCitiesButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "User should be redirected to Cities page.");
    }
}

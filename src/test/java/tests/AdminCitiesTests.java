package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest{

    @Test(priority = - 1, retryAnalyzer = RetryAnalyzer.class)
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

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyInputTypesForCreateEditNewCity(){

        nav.clickOnAdminButton();
        nav.clickOnCitiesButton();

        cities.clickOnNewItemButton();
        cities.waitUntilNewEditDialogIsVisible();

        Assert.assertEquals(cities.getNewItemInput().getAttribute("type"), "text",
                "Input type should be password.");

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyIfCreateNewCityIsWorking(){
        String city = "New Orleans";

        nav.clickOnAdminButton();
        nav.clickOnCitiesButton();

        cities.clickOnNewItemButton();
        cities.waitUntilNewEditDialogIsVisible();

        cities.clearAndTypeNewCity(city);
        cities.clickOnSaveButton();
        popUp.waitUntilSavedPopupIsVisible();
        Assert.assertTrue(popUp.getSavedPopupMessage().getText().contains("Saved successfully"),
                "New city should be created.");
    }
}

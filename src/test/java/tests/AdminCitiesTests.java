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

    @Test(priority = 0, retryAnalyzer = RetryAnalyzer.class)
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

    @Test (priority = 1)
    public void verifyIfEditCityIsWorking(){
        String oldCity = "New Orleans";
        String newCity = "London";


        nav.clickOnAdminButton();
        nav.clickOnCitiesButton();

        cities.clearAndTypeSearch(oldCity);

        cities.waitRowNumber(1);
        cities.clickOnEditButton(1);

        cities.waitUntilNewEditDialogIsVisible();

        cities.clearAndTypeNewCity(newCity);
        cities.clickOnSaveButton();

        popUp.waitUntilSavedPopupIsVisible();

        Assert.assertTrue(popUp.getSavedPopupMessage().getText().contains("Saved successfully"),
                "City should be edited.");


    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void verifyIfSearchCityIsWorking(){
        String editedCity = "London";

        nav.clickOnAdminButton();
        nav.clickOnCitiesButton();

        cities.clearAndTypeSearch(editedCity);
        cities.waitRowNumber(1);

        Assert.assertEquals(cities.getTableElement(1,2).getText(), editedCity,
                "Edited city name should be in table.");
    }

    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void verifyIfDeleteCityIsWorking(){
        String editedCity = "London";

        nav.clickOnAdminButton();
        nav.clickOnCitiesButton();

        cities.clearAndTypeSearch(editedCity);
        cities.waitRowNumber(1);

        Assert.assertEquals(cities.getTableElement(1,2).getText(), editedCity,
                "Edited city name should be in table.");

        cities.clickOnDeleteButton(1);
        cities.waitUntilDeleteDialogIsVisible();
        cities.confirmDelete();

        popUp.waitUntilSavedPopupIsVisible();

        Assert.assertTrue(popUp.getSavedPopupMessage().getText().contains("Deleted successfully"),
                "City should be deleted.");

    }




}

package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class LoginTests extends BasicTest{


    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyUrl(){

        nav.clickOnLanguageButton();
        nav.selectLanguage(0);
        nav.clickOnToolbarLinks(2);

        wait
                .withMessage("User should be redirected to Login page.")
                .until(ExpectedConditions.urlToBe(baseUrl + "/login"));

    }

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyInputTypes(){
        nav.clickOnToolbarLinks(2);

        Assert.assertEquals(login.getEmailInput().getAttribute("type"), "email",
                "Input type should be email.");

        Assert.assertEquals(login.getPasswordInput().getAttribute("type"), "password",
                "Input type should be password.");
    }


    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyErrorIsDisplayedWhenUserDoesNotExist(){
        String wrongEmail = "non-existing-user@gmal.com";
        String wrongPassword = "password123";

        nav.clickOnToolbarLinks(2);
        login.clearAndTypeEmail(wrongEmail);
        login.clearAndTypePassword(wrongPassword);
        login.clickOnLoginButton();

        popUp.waitUntilPopUpIsVisible();
        Assert.assertTrue(popUp.getPopUpText().contains("User does not exists"),
                "User does not exists error message should be visible.");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "User should stay on Login page.");
    }

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyErrorIsDisplayedWhenPasswordIsWrong(){
        String wrongPassword = "password123";

        nav.clickOnToolbarLinks(2);
        login.clearAndTypeEmail(email);
        login.clearAndTypePassword(wrongPassword);
        login.clickOnLoginButton();

        popUp.waitUntilPopUpIsVisible();
        Assert.assertTrue(popUp.getPopUpText().contains("Wrong password"),
                "Wrong password error message should be visible.");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "User should stay on Login page.");

    }

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifySuccessfulLogin(){

        nav.clickOnToolbarLinks(2);
        login.clearAndTypeEmail(email);
        login.clearAndTypePassword(password);
        login.clickOnLoginButton();

        wait
                .withMessage("User should be redirected to Home page.")
                .until(ExpectedConditions.urlToBe(baseUrl + "/home"));

    }


}

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



}

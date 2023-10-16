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



}

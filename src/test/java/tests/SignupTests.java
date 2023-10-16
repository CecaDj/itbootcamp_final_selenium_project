package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class SignupTests extends BasicTest{

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyUrl(){
        nav.clickOnToolbarLinks(3);
        wait
                .withMessage("User should be redirected to Signup page.")
                .until(ExpectedConditions.urlToBe(baseUrl + "/signup"));
    }

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyInputTypes(){

        nav.clickOnToolbarLinks(3);

        Assert.assertEquals(signup.getEmailInput().getAttribute("type"), "email",
                "Input type should be email.");

        Assert.assertEquals(signup.getPasswordInput().getAttribute("type"), "password",
                "Input type should be password.");

        Assert.assertEquals(signup.getConfirmPasswordInput().getAttribute("type"), "password",
                "Input type should be password.");


    }

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyErrorIsDisplayedWhenUserAlreadyExists(){
        String name = "Another User";

        nav.clickOnToolbarLinks(3);

        wait
                .withMessage("User should be redirected to Signup page.")
                .until(ExpectedConditions.urlToBe(baseUrl + "/signup"));

        signup.clearAndTypeName(name);
        signup.clearAndTypeEmail(email);
        signup.clearAndTypePassword(password);
        signup.clearAndTypeConfirmPassword(password);
        signup.clickOnSignupButton();

        popUp.waitUntilPopUpIsVisible();
        Assert.assertTrue(popUp.getPopUpText().contains("E-mail already exists"),
                "E-mail already exists error message should be visible.");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup",
                "User should stay on Signup page.");
    }

}

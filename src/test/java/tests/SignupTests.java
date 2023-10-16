package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
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

}

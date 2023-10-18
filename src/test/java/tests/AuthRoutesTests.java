package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class AuthRoutesTests extends BasicTest{

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyForbiddenVisitsToHomeUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/home");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "User should be redirected to Login page.");
    }

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyForbiddenVisitsToProfileUrlIfNotAuthenticated(){

        driver.get(baseUrl + "/profile");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "User should be redirected to Login page.");

    }

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyForbiddenVisitsToAdminCitiesUrlIfNotAuthenticated(){

        driver.get(baseUrl + "/admin/cities");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "User should be redirected to Login page.");
    }


}

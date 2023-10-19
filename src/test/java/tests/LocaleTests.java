package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class LocaleTests extends BasicTest{

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyIfSetLocaleToEsIsWorking(){

        nav.clickOnLanguageButton();
        nav.selectLanguage(1);

        Assert.assertTrue(home.getHeader().getText().contains("Página de aterrizaje"),
                "Page language should be changed to ES.");
    }



}

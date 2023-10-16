package tests;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MessagePopUpPage;
import pages.NavPage;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;
    protected NavPage nav;
    protected LoginPage login;
    protected MessagePopUpPage popUp;


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        baseUrl = "https://vue-demo.daniel-avellaneda.com";

        nav = new NavPage(driver,wait);
        login = new LoginPage(driver,wait);
        popUp = new MessagePopUpPage(driver, wait);
    }

    @BeforeMethod
    public void homePage(){
        driver.get(baseUrl);
    }

    @AfterMethod
    public void screenshot(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {

            File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Files.copy(f,new File("screenshots/" + result.getName() + ".jpg"));
        }
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

}

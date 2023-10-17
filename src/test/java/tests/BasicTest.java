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
import pages.*;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;
    protected String email;
    protected String password;
    protected NavPage nav;
    protected LoginPage login;
    protected MessagePopUpPage popUp;
    protected SignupPage signup;
    protected CitiesPage cities;


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        baseUrl = "https://vue-demo.daniel-avellaneda.com";

        email = "admin@admin.com";
        password = "12345";

        nav = new NavPage(driver,wait);
        login = new LoginPage(driver,wait);
        popUp = new MessagePopUpPage(driver, wait);
        signup = new SignupPage(driver,wait);
        cities = new CitiesPage(driver,wait);
    }

    @BeforeMethod
    public void homePage(){
        driver.get(baseUrl);
    }

    @AfterMethod
    public void screenshot(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {

            File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
            String strDate = formatter.format(date);

            Files.copy(f,new File("screenshots/" + result.getName() + strDate + ".jpg"));
        }
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

}

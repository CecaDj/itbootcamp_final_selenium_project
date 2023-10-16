package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput(){
       return driver.findElement(By.id("email"));
    }

    public void clearAndTypeEmail(String input){
        getEmailInput().clear();
        getEmailInput().sendKeys(input);
    }

    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }

    public void clearAndTypePassword(String input){
        getPasswordInput().clear();
        getPasswordInput().sendKeys(input);
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector(".flex > button"));
    }

    public void clickOnLoginButton(){
        getLoginButton().click();
    }


}

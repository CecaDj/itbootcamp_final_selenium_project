package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage{

    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }

    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }

    public WebElement getConfirmPasswordInput(){
        return driver.findElement(By.id("confirmPassword"));
    }

    public void clearAndTypeName(String input){
        getNameInput().clear();
        getNameInput().sendKeys(input);
    }

    public void clearAndTypeEmail(String input){
        getEmailInput().clear();
        getEmailInput().sendKeys(input);
    }

    public void clearAndTypePassword(String input){
        getPasswordInput().clear();
        getPasswordInput().sendKeys(input);
    }

    public void clearAndTypeConfirmPassword(String input){
        getConfirmPasswordInput().clear();
        getConfirmPasswordInput().sendKeys(input);
    }

    public WebElement getSignupButton(){
        return driver.findElement(By.className("v-btn--is-elevated"));
    }

    public void clickOnSignupButton(){
        getSignupButton().click();
    }





}

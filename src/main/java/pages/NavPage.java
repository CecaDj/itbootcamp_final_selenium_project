package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NavPage extends BasicPage{

    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public List<WebElement> getToolbarLinks(){
        return driver.findElements(By.cssSelector(".v-toolbar__items > a"));
    }

    public void clickOnToolbarLinks(int index){
        getToolbarLinks().get(index).click();
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.cssSelector(".v-toolbar__items > button"));
    }

    public void clickOnLanguageButton(){
        getLanguageButton().click();
    }

    public List<WebElement> getLanguageList(){
        return driver.findElements(By.cssSelector(".v-menu__content .v-list-item"));
    }

    public void selectLanguage(int index) {
        getLanguageList().get(index).click();
    }

    public WebElement getLogoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }

    public void clickOnLogoutButton(){
        getLogoutButton().click();
    }

}

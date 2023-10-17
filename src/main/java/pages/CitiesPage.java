package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage{

    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnNewItemButton(){
        driver.findElement(By.className("btnNewItem")).click();
    }

    public void waitUntilNewEditDialogIsVisible(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".dlgNewEditItem .v-card"))));
    }

    public WebElement getNewItemInput(){
        return driver.findElement(By.id("name"));
    }


}

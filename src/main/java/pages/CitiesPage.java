package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    public void clearAndTypeNewCity(String newCity){
        getNewItemInput().sendKeys(Keys.CONTROL + "a");
        getNewItemInput().sendKeys(Keys.DELETE);
        getNewItemInput().sendKeys(newCity);
    }

    public void clickOnSaveButton(){
        driver.findElement(By.className("btnSave")).click();
    }

    public void clearAndTypeSearch(String input){
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys(input);
    }


    public void waitRowNumber(int rows){

        wait
                .withMessage("Number of rows should be valid.")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody > tr"), rows));
    }

    public void clickOnEditButton(int row){
        driver.findElement(By.cssSelector("tr:nth-child(" + row + ") #edit")).click();
    }

    public WebElement getTableElement(int row, int column){
        return driver.findElement(By.cssSelector("tr:nth-child(" + row + " ) td:nth-child(" + column + ")"));
    }

}

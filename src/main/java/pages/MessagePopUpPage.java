package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MessagePopUpPage extends BasicPage{

    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitUntilPopUpIsVisible(){
        wait
                .withMessage("Pop up should be visible.")
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("v-snack__content"))));
    }

    public List<WebElement> getPopUpErrorList(){
        return driver.findElements(By.cssSelector(".v-snack__content li"));
    }

    public String getPopUpText(){
        for (int i = 0; i < getPopUpErrorList().size(); i++) {
            return getPopUpErrorList().get(i).getText();
        }
        return null;
    }
}

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

    public WebElement getDialog(){
        return driver.findElement(By.cssSelector(".v-dialog--active .v-card"));
    }
    public void waitUntilDialogIsVisible(){
        wait
                .withMessage("Dialog should be visible.")
                .until(ExpectedConditions.visibilityOf(getDialog()));
    }


    public String getDialogHeadline(){
        return getDialog().findElement(By.cssSelector("div.v-card__title")).getText();
    }

    public void clickOnDialogCloseButton(){
        driver.findElement(By.className("btnClose")).click();
    }

    public WebElement getSavedPopupMessage(){
      return driver.findElement(By.cssSelector("div:nth-child(3) .v-snack__content"));
    }

    public void waitUntilSavedPopupIsVisible(){
        wait
                .withMessage("Popup message should be visible.")
                .until(ExpectedConditions.visibilityOf(getSavedPopupMessage()));
    }

}

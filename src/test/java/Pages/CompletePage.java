package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletePage {

    WebDriver driver;

    WebElement pageH2;
    WebElement backHomeButton;

    public CompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPageH2() {
        return driver.findElement(By.className("complete-header"));
    }

    public WebElement getBackHomeButton() {
        return driver.findElement(By.id("back-to-products"));
    }

}

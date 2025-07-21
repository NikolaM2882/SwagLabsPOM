package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourInfomationPage {

    WebDriver driver;

    WebElement firtsNamefield;
    WebElement lastNameFiled;
    WebElement zipCodeField;
    WebElement continueButton;


    public YourInfomationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFirtsNamefield() {
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastNameFiled() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getZipCodeField() {
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("continue"));
    }

    /// ///////////

    public void inputFirstName(String tekst){
        getFirtsNamefield().sendKeys(tekst);
    }

    public void inputLastName(String tekst){
        getLastNameFiled().sendKeys(tekst);
    }

    public void inputZipCode(String tekst){
        getZipCodeField().sendKeys(tekst);
    }



}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    WebDriver driver ;

    WebElement userNamefield;
    WebElement passwordFiled;
    WebElement loginButton;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUserNamefield() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordFiled() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    /// ///////////

    public void inputUserName (String text){
        getUserNamefield().sendKeys(text);
    }

    public void inputPassword (String text){
        getPasswordFiled().sendKeys(text);
    }

    public void clickOnLoginButton(){
        getLoginButton().click();
    }

}

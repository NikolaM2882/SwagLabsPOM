package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FinishOrderTest extends BaseTest {

    @BeforeMethod
    public  void pageSetUP(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-password-manager-reauthentication");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetectionEnabled");
        options.addArguments("--password-store=basic");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        landingPage = new LandingPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        yourInfomationPage = new YourInfomationPage(driver);
        overviewPage = new OverviewPage(driver);
        completePage = new CompletePage(driver);
    }


    ///  Verify that user can go through the whole buying process
    @Test
    public void userShouldBeAbleToFinishThePurchase(){

        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        productsPage.getAddToCartButton().click();
        productsPage.getShoppingCart().click();
        cartPage.getCheckoutButtonButton().click();
        yourInfomationPage.inputFirstName("Petar");
        yourInfomationPage.inputLastName("Petrovic");
        yourInfomationPage.inputZipCode("Zetska 11, 18000");
        yourInfomationPage.getContinueButton().click();
        overviewPage.getFinishButton().click();
        Assert.assertTrue(completePage.getPageH2().isDisplayed());
        completePage.getBackHomeButton().click();

        Assert.assertTrue(productsPage.getProductsHeader().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");



    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}

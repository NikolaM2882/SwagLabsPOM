package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InformationFormTests extends BaseTest {

    @BeforeMethod
    public void pageSetup(){

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

    }


    ///  Verify user can fill out input form
    @Test
    public void userCanFillOutInputForm(){
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



        Assert.assertTrue(overviewPage.getPageHeader().getText().equals("Checkout: Overview"));
    }

    /// Verify that use cant submit form with blank data
    @Test
    public void userCantFillOutInputFormWithBlankData(){
        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        productsPage.getAddToCartButton().click();
        productsPage.getShoppingCart().click();
        cartPage.getCheckoutButtonButton().click();
        yourInfomationPage.getFirtsNamefield().clear();
        yourInfomationPage.getLastNameFiled().clear();
        yourInfomationPage.getZipCodeField().clear();
        yourInfomationPage.getContinueButton().click();

        Assert.assertTrue(yourInfomationPage.getErrorMessage().isDisplayed());
        Assert.assertTrue(yourInfomationPage.getFirtsNamefield().isDisplayed());
    }

    ///  Verify user cant submit form with blank name
    @Test
    public void userCantFillOutInputFormWithBlnkFirstName(){
        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        productsPage.getAddToCartButton().click();
        productsPage.getShoppingCart().click();
        cartPage.getCheckoutButtonButton().click();
        yourInfomationPage.getFirtsNamefield().clear();
        yourInfomationPage.inputLastName("Petrovic");
        yourInfomationPage.getZipCodeField().clear();
        yourInfomationPage.getContinueButton().click();

        Assert.assertTrue(yourInfomationPage.getErrorMessage().isDisplayed());
        Assert.assertTrue(yourInfomationPage.getFirtsNamefield().isDisplayed());
    }


    ///  Verfiy user cant submit form with blank last name
    @Test
    public void userCantFillOutInputFormWithBlnkLastName(){
        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        productsPage.getAddToCartButton().click();
        productsPage.getShoppingCart().click();
        cartPage.getCheckoutButtonButton().click();
        yourInfomationPage.inputFirstName("Petar");
        yourInfomationPage.getLastNameFiled().clear();
        yourInfomationPage.getZipCodeField().clear();
        yourInfomationPage.getContinueButton().click();

        Assert.assertTrue(yourInfomationPage.getErrorMessage().isDisplayed());
        Assert.assertTrue(yourInfomationPage.getFirtsNamefield().isDisplayed());
    }


    ///  Verify user cant submit form with blank zipcode
    @Test
    public void userCantFillOutInputFormWithBlankZipcode(){
        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        productsPage.getAddToCartButton().click();
        productsPage.getShoppingCart().click();
        cartPage.getCheckoutButtonButton().click();
        yourInfomationPage.inputFirstName("Petar");
        yourInfomationPage.inputLastName("Petrovic");
        yourInfomationPage.getZipCodeField().clear();
        yourInfomationPage.getContinueButton().click();



        Assert.assertTrue(yourInfomationPage.getErrorMessage().isDisplayed());
        Assert.assertTrue(yourInfomationPage.getFirtsNamefield().isDisplayed());
    }










    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }




}

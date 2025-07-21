package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.LandingPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddToCartTests extends BaseTest {

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


    }


    // Veirfy that user can add an item to the cart
    @Test
    public void userCanAddAnItemToCart(){
        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        String productName = driver.findElement(By.cssSelector("div.inventory_item_name")).getText();
        System.out.println(productName);
        productsPage.getAddToCartButton().click();
        productsPage.getShoppingCart().click();

        Assert.assertTrue(cartPage.getProductTitle().getText().equals(productName));
        Assert.assertTrue(cartPage.getItemPrice().isDisplayed());

    }


    /// verify that a user can remove an item from the cart
    @Test
    public void userCanRemoveAnItemFromCart(){
        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        String productName = driver.findElement(By.cssSelector("div.inventory_item_name")).getText();
        System.out.println(productName);
        productsPage.getAddToCartButton().click();
        productsPage.getShoppingCart().click();
        cartPage.getRemoveItemButton().click();

       boolean bul = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='inventory_item_name']")));
       Assert.assertTrue(bul);
    }

    // verify that user can add an remove itme from the cart
    /*
    @Test
    public void userCanAddAndRemoveAnItemFromProductsPage(){
        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        productsPage.getAddToCartButton().click();
        productsPage.getRemoveFromCartBackpac().click();

        boolean bul = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("shopping_cart_badge")));
        Assert.assertTrue(bul);


    }

     */

    /// Verify that user can add multiple items to the cart
    @Test
    public void userCanAddMultipleItemsToCart(){
        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        List<WebElement> productsOnPage = driver.findElements(By.cssSelector("div.inventory_item_name"));
        List<String> productNames = new ArrayList<>();
        for (WebElement nekiProdukt : productsOnPage){
            productNames.add(nekiProdukt.getText());
        }
        productsPage.getAddToCartButton().click();
        productsPage.getAddToCartBikeLight().click();
        productsPage.getAddToTshirt().click();
        productsPage.getShoppingCart().click();


        Assert.assertTrue(cartPage.getItemPrices().size() == 3);
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(productNames.get(i), cartPage.getProductTitles().get(i).getText());
        }




    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }






}

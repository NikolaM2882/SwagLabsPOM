package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.LandingPage;
import Pages.ProductsPage;
import Pages.SingleProductPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.HdrDocumentImpl;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiscTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
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
        singleProductPage = new SingleProductPage(driver);

    }

    ///  Verify that user can view product details
    @Test
    public void userShouldBeAbleToViewProductDetails(){

        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        String text = productsPage.getAllProductPrices().get(0).getText();
        productsPage.getAllProductTitles().get(0).click();

        Assert.assertTrue(singleProductPage.getItemPicture().isDisplayed());
        Assert.assertTrue(singleProductPage.getItemPrice().isDisplayed());
        Assert.assertEquals(singleProductPage.getItemPrice().getText(), text);





    }


    ///  Verify that user can sort products from a to z
    @Test
    public  void userShouldBeAbleToFilterProductsAtoZ() throws InterruptedException {
        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        Select sortOpcija = new Select(productsPage.getSortSelect());
        sortOpcija.selectByValue("az");
        Thread.sleep(2000);

        List<String> reciZaFilter = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (WebElement nekiElement : productsPage.getAllProductTitles()) {
            String imeProizvoda = nekiElement.getText();

            String delovi[] = imeProizvoda.split("Sauce Labs\\s+");
            if (delovi.length > 1) {
                String recZaFilter = delovi[1].split(" ")[0];
                reciZaFilter.add(recZaFilter);
            }

            List<String> sortiraneReci = new ArrayList<>(reciZaFilter);
            Collections.sort(sortiraneReci);

            Assert.assertEquals(reciZaFilter, sortiraneReci);


        }

    }

    ///  Verify that user can sort products from z to a
    @Test
    public  void userShouldBeAbleToFilterProdutsZtoA() throws InterruptedException {
        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        Select sortOpcija = new Select(productsPage.getSortSelect());
        sortOpcija.selectByValue("za");
        Thread.sleep(2000);

        List<String> reciZaFilter = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (WebElement nekiElement : productsPage.getAllProductTitles()) {
            String imeProizvoda = nekiElement.getText();

            String delovi[] = imeProizvoda.split("Sauce Labs\\s+");
            if (delovi.length > 1) {
                String recZaFilter = delovi[1].split(" ")[0];
                reciZaFilter.add(recZaFilter);
            }

            List<String> obrnuteReci = new ArrayList<>(reciZaFilter);
            Collections.sort(obrnuteReci, Collections.reverseOrder());

            Assert.assertEquals(reciZaFilter, obrnuteReci);


        }

    }

    ///  Verify that user cant proceed to checkout with no cart items
    @Test
    public void userShouldntBeAbletoProceedToCheckoutWithNoCartItems(){
        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();
        productsPage.getShoppingCart().click();
        cartPage.getCheckoutButtonButton().click();

        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html"));
        Assert.assertTrue(cartPage.getCheckoutButtonButton().isDisplayed());

    }





    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}

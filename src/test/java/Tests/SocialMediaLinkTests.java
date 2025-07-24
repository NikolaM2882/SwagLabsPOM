package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.LandingPage;
import Pages.ProductsPage;
import Pages.SingleProductPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SocialMediaLinkTests extends BaseTest {

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


    @Test
    public void userCanClickOnFacebookButtonI()  {

        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();

        productsPage.getFacebookButton().click();

        Set<String> naslovi = driver.getWindowHandles();
        List<String> tabovi = new ArrayList<>(naslovi);

        driver.switchTo().window(tabovi.get(1));

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs");

    }

    @Test
    public void userCanClickOnXButtonI()  {

        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();

        productsPage.getXButton().click();

        Set<String> naslovi = driver.getWindowHandles();
        List<String> tabovi = new ArrayList<>(naslovi);

        driver.switchTo().window(tabovi.get(1));


        Assert.assertEquals(driver.getCurrentUrl(), "https://x.com/saucelabs");

    }


    @Test
    public void userCanClickOnLinkedinButtonI()  {

        landingPage.inputUserName("standard_user");
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();

        productsPage.getLinkedinButton().click();

        Set<String> naslovi = driver.getWindowHandles();
        List<String> tabovi = new ArrayList<>(naslovi);

        driver.switchTo().window(tabovi.get(1));


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/");

    }



    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}

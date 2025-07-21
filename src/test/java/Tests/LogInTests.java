package Tests;

import Base.BaseTest;
import Base.ExcelReader;
import Pages.LandingPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class LogInTests extends BaseTest {


    @BeforeMethod
    public void pageSetUP() throws IOException {

    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    driver.manage().window().maximize();
    driver.navigate().to("https://www.saucedemo.com/");

    landingPage = new LandingPage(driver);
    productsPage = new ProductsPage(driver);
    excelReader = new ExcelReader("C:\\Users\\Nikola\\Documents\\ITbootcamp\\Projects\\SwagLabsSeleniumPom\\tabela.xlsx");
    }


    // Verify that user can log in and log out using data from excel sheet
    @Test
    public void listOfUsersCanLoginAndLogout() throws InterruptedException {

        for (int i = 0; i <= excelReader.getLastRow("Sheet1"); i++) {
            String userName = excelReader.getStringData("Sheet1", 0, 0);
            String password = excelReader.getStringData("Sheet1", 0, 1);

            landingPage.inputUserName(userName);
            landingPage.inputPassword(password);
            landingPage.clickOnLoginButton();

            Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));

            productsPage.getBurgerButton().click();
            wait.until(ExpectedConditions.visibilityOf(productsPage.getLogoutLink()));
            productsPage.getLogoutLink().click();

            Assert.assertTrue(landingPage.getLoginButton().isDisplayed());
            // wait.until(ExpectedConditions.visibilityOf(productsPage.getProductsHeader()));
            //  Assert.assertTrue(productsPage.getProductsHeader().isDisplayed());


        }
    }


    // Verify that user can't login with blank data
        @Test
        public void userCantLoginWithBlankData(){
            landingPage.getUserNamefield().clear();
            landingPage.getPasswordFiled().clear();
            landingPage.clickOnLoginButton();

            Assert.assertTrue(landingPage.getLoginButton().isDisplayed());
            Assert.assertTrue(landingPage.getUserNamefield().isDisplayed());


        }


     // Verify yhat use can't log in with blank username
    @Test
    public void userCantLoginWithBlankUserName(){
        landingPage.getUserNamefield().clear();
        landingPage.inputPassword("secret_sauce");
        landingPage.clickOnLoginButton();

        Assert.assertTrue(landingPage.getLoginButton().isDisplayed());
        Assert.assertTrue(landingPage.getUserNamefield().isDisplayed());


    }

    // Verfiy user can't login with blank password
    @Test
    public void userCantLoginWithBlankPassword(){
        landingPage.inputUserName("standard_user");
        landingPage.getPasswordFiled().clear();
        landingPage.clickOnLoginButton();

        Assert.assertTrue(landingPage.getLoginButton().isDisplayed());
        Assert.assertTrue(landingPage.getUserNamefield().isDisplayed());


    }





    @AfterMethod
    public void closeBrowser(){
       driver.quit();
    }




}


package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

    WebDriver driver;

    WebElement productsHeader;
    WebElement burgerButton;
    WebElement logoutLink;
    WebElement addToCartButton;


    WebElement addToCartBikeLight;
    WebElement addToTshirt;
    WebElement shoppingCart;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProductsHeader() {
       // return driver.findElement(By.id("shopping_cart_container"));
        return driver.findElement(By.cssSelector("span[class='title']"));
    }

    public WebElement getBurgerButton() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement getLogoutLink() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getRemoveFromCartBackpac() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }



    public WebElement getAddToTshirt() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
    }

    public WebElement getAddToCartBikeLight() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
    }

    public WebElement getShoppingCart() {
        return driver.findElement(By.id("shopping_cart_container"));
    }

    public  WebElement getShoppingCartBadge(){
        return driver.findElement(By.className("shopping_cart_badge"));
    }

    public List<WebElement> getAllProductTitles(){
        return driver.findElements(By.className("inventory_item_name"));
    }

    public List<WebElement> getAllProductPrices(){
        return driver.findElements(By.className("inventory_item_price"));
    }

    /// ////

    public void clickOnBurger(){
        getBurgerButton().click();
    }

    public void clickOnLogutLink(){
        getLogoutLink().click();

    }


}

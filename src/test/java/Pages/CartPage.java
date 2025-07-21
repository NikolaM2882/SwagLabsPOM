package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    WebDriver driver;

    WebElement productTitle;
    WebElement itemPrice;
    WebElement removeItemButton;
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProductTitle() {
        return driver.findElement(By.cssSelector("div[class='inventory_item_name']"));

    }

    public List<WebElement> getProductTitles(){
        return driver.findElements(By.cssSelector("div[class='inventory_item_name']"));

    }

    public WebElement getItemPrice() {
        return driver.findElement(By.cssSelector("div[class='inventory_item_price']"));
    }

    public List<WebElement> getItemPrices() {
        return driver.findElements(By.cssSelector("div[class='inventory_item_price']"));
    }

    public WebElement getRemoveItemButton() {
        return driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
    }

    public WebElement getCheckoutButtonButton() {
        return driver.findElement(By.id("checkout"));
    }
}

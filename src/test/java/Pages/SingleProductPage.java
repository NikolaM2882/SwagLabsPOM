package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SingleProductPage {

    WebDriver driver;

    WebElement itemPicture;
    WebElement itemPrice;

    public SingleProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getItemPicture() {
        return driver.findElement(By.className("inventory_details_img"));
    }

    public WebElement getItemPrice() {
        return driver.findElement(By.className("inventory_details_price"));
    }
}

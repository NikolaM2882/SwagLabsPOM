package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage {

    WebDriver driver;

    WebElement summaryInfo;
    WebElement pageHeader;
    WebElement finishButton;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPageHeader() {
        return driver.findElement(By.cssSelector("span[data-test='title']"));
    }

    public WebElement getSummaryInfo() {
        return driver.findElement(By.className("summary_info"));
    }

    public WebElement getFinishButton() {
        return driver.findElement(By.id("finish"));
    }


}

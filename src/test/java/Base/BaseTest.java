package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class BaseTest {


    public WebDriver driver;
    public WebDriverWait wait;

    public LandingPage landingPage;
    public ExcelReader excelReader;
    public ProductsPage productsPage;
    public CartPage cartPage;
    public YourInfomationPage yourInfomationPage;
    public OverviewPage overviewPage;
    public CompletePage completePage;
    public SingleProductPage singleProductPage;


    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();


    }

}

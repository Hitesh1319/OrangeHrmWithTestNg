package OrangeHrm.Test;

import OrangeHrm.Pages.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
    public static WebDriver driver;
    protected static PageFactory pageFactory;

    @Parameters("browserName")
    @BeforeClass
    public static void setup(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();
            pageFactory = new PageFactory(driver);
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();
            pageFactory = new PageFactory(driver);
        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();
            pageFactory = new PageFactory(driver);
        }
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    public static void verification(String locator, String expected) {
        String actual = driver.findElement(By.xpath(locator)).getText();
        Assert.isTrue(actual.equals(expected), "Expected result does not match with actual result");
    }

}

package OrangeHrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By userName = By.xpath("//input[@name='username']");
    By password = By.name("password");
    By submit = By.xpath("//button");
    By pimHeading = By.xpath("//h6");

    String itemName = "//div[@class='cart_item_label']/a/div[contains(text(),'%s')]";

    public LoginPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        driver.findElement(userName).sendKeys("Admin");
        driver.findElement(password).sendKeys("admin123");
        driver.findElement(submit).click();
    }

    public void verifyLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pimHeading));
        String actual = driver.findElement(pimHeading).getText();
        Assert.assertEquals(actual, "PIM", "Page Heading do not match Login fail");
    }
}

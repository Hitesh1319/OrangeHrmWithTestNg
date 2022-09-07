package OrangeHrm.Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Random;

public class AddUser {
    WebDriver driver;
    By userRole= By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    By userRoleDrop= By.xpath("//*[contains(text(),'Admin')]");
    By status=By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    By statusDrop=By.xpath("//*[contains(text(),'Disabled')]");
    By employeeName=By.xpath("//input[@placeholder='Type for hints...']");
    By username =By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By password=By.xpath("(//input[@type='password'])[1]");
    By comfirmPassword=By.xpath("(//input[@type='password'])[2]");
    By save=By.xpath("//div[@class='oxd-form-actions']//button[@type='submit']");
    Random random = new Random();
    int randomNum = random.nextInt(1000);
    String userName1="Username"+randomNum;
    By searchUserNameInput = By.xpath("(//input[contains(@class,'oxd-input')])[2]");
    By searchButton = By.xpath("//div[@class='oxd-form-actions']/button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    public AddUser(WebDriver driver){
        this.driver=driver;
    }
    public void addUser() throws InterruptedException {
        driver.findElement(userRole).click();
        driver.findElement(userRoleDrop).click();
        driver.findElement(status).click();
        driver.findElement(statusDrop).click();
        driver.findElement(employeeName).sendKeys("Sania");
        driver.findElement(By.xpath("//*[contains(text(),'Sania')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(username).sendKeys(userName1);
        driver.findElement(password).sendKeys("Password@1");
        driver.findElement(comfirmPassword).sendKeys("Password@1");
        Thread.sleep(5000);
        driver.findElement(save).click();
        Thread.sleep(5000);
    }
    public void verifyAddedUser() throws InterruptedException {
        driver.findElement(searchUserNameInput).sendKeys(userName1);
        driver.findElement(userRole).click();
        driver.findElement(userRoleDrop).click();
        driver.findElement(searchButton).click();
        Thread.sleep(3000);
        boolean isAdminDisplayed = driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", userName1))).isDisplayed();
        Assert.isTrue(isAdminDisplayed, "User is not added");
    }
}

package OrangeHrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class AddUser {
    WebDriver driver;
    WebDriverWait wait;
    By userRole = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    By userRoleDrop = By.xpath("//*[contains(text(),'Admin')]");
    By status = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    By statusDrop = By.xpath("//*[contains(text(),'Disabled')]");
    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By username = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By password = By.xpath("(//input[@type='password'])[1]");
    By comfirmPassword = By.xpath("(//input[@type='password'])[2]");
    By save = By.xpath("//div[@class='oxd-form-actions']//button[@type='submit']");
    By searchUserNameInput = By.xpath("(//input[contains(@class,'oxd-input')])[2]");
    By searchButton = By.xpath("//div[@class='oxd-form-actions']/button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    By containName = By.xpath("//*[contains(text(),'Sania')]");
    By error = By.xpath("(//span[contains(@class,'oxd-input-field-error-message')])[1]");
    By verifyAdminPage = By.xpath("(//h6[contains(@class,'oxd-text--h6')])[2]");
    By deleteUser= By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[1]");

    Random random = new Random();
    int randomNum = random.nextInt(1000);
    String userName1 = "Username" + randomNum;

    public AddUser(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addUser() {
        driver.findElement(userRole).click();
        driver.findElement(userRoleDrop).click();
        driver.findElement(status).click();
        driver.findElement(statusDrop).click();
        driver.findElement(employeeName).sendKeys("Sania");
        wait.until(ExpectedConditions.visibilityOfElementLocated(containName));
        driver.findElement(containName).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).sendKeys(userName1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        driver.findElement(password).sendKeys("Password@1");
        driver.findElement(comfirmPassword).sendKeys("Password@1");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(error));
        driver.findElement(save).sendKeys(Keys.ENTER);
    }

    public void verifyAddedUser() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(verifyAdminPage,"User Management"));
        driver.findElement(searchUserNameInput).sendKeys(userName1);
        driver.findElement(userRole).click();
        driver.findElement(userRoleDrop).click();
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
    }
}

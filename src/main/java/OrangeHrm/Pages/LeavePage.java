package OrangeHrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeavePage {
    WebDriver driver;
    WebDriverWait wait;
    By applyLink = By.linkText("Apply");
    By leaveType =By.xpath("//div[@class='oxd-select-text oxd-select-text--active']");
    By leaveTypeDrop =By.xpath("//*[contains(text(),'CAN')]");
    By fromDate =By.xpath("(//input[@placeholder='yyyy-mm-dd'])[1]");
    By comments = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
    By applyButton =By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    public LeavePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void leave()  {
        wait.until(ExpectedConditions.elementToBeClickable(applyLink));
        driver.findElement(applyLink).click();
        wait.until(ExpectedConditions.elementToBeClickable(leaveType));
        driver.findElement(leaveType).click();
        wait.until(ExpectedConditions.elementToBeClickable(leaveTypeDrop));
        driver.findElement(leaveTypeDrop).click();
        driver.findElement(fromDate).sendKeys("2022-09-08");
        driver.findElement(comments).sendKeys("I am applying for leave");
        wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        driver.findElement(applyButton).click();
//        String actual = driver.findElement().getText();
//        Assert.assertEquals(actual, "PIM", "Page Heading do not match Login fail");
    }
}

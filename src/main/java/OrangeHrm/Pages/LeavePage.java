package OrangeHrm.Pages;

import net.jodah.failsafe.internal.util.Assert;
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
    By myLeave = new By.ByLinkText("MyLeave");
    By fromDateSearch =By.xpath("//input[@class='oxd-input oxd-input--active oxd-input--error']");
    By searchButton = By.xpath("//button[@type='submit']");
    public LeavePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void clickOnLeave(){
        driver.findElement(applyLink).click();
        wait.until(ExpectedConditions.elementToBeClickable(leaveType));
        String actual = driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab --visited']")).getText();
        Assert.isTrue(actual.equals("Apply"), "Expected result does not match with actual result");
    }
    public void leave()  {
        driver.findElement(leaveType).click();
        wait.until(ExpectedConditions.elementToBeClickable(leaveTypeDrop));
        driver.findElement(leaveTypeDrop).click();
        driver.findElement(fromDate).sendKeys("2022-09-08");
        driver.findElement(comments).sendKeys("I am applying for leave");
        wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        driver.findElement(applyButton).click();
        driver.findElement(myLeave).click();
    }
    public void myLeave(){
        driver.findElement(fromDateSearch).sendKeys("2022-09-08");
        driver.findElement(searchButton).click();
    }
}

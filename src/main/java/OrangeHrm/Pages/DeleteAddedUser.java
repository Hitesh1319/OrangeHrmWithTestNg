package OrangeHrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAddedUser {
    WebDriver driver;
    public DeleteAddedUser(WebDriver driver){
        this.driver = driver;
    }
    By delete=By.xpath("//i[@class='oxd-icon bi-trash']");
    public void deleteAddedUser() throws InterruptedException {
        driver.findElement(delete).click();
        //wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
//        Alert alert =driver.switchTo().alert();
     //   driver.switchTo().alert().accept();
        //driver.findElement(By.xpath("//button[@Class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
    }
}

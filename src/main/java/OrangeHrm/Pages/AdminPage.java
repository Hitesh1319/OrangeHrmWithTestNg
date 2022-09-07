package OrangeHrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
    WebDriver driver;
    By add = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary' ][1]");
    public AdminPage(WebDriver driver){
        this.driver=driver;
    }
    public void admin(){
        driver.findElement(add).click();
    }
}

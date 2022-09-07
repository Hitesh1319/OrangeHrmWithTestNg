package OrangeHrm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
    WebDriver driver;

    By admin= new By.ByLinkText("Admin");
    By leave= new By.ByLinkText("Leave");
    public MenuPage(WebDriver driver){
        this.driver=driver;
    }
    public void menu(){
        driver.findElement(admin).click();
    }
    public void leave(){driver.findElement(leave).click();}
}

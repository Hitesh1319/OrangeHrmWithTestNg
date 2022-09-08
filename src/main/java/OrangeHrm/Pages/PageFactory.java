package OrangeHrm.Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    static WebDriver driver;
    private LoginPage loginPage;
    private AdminPage adminPage;
    private MenuPage menuPage;
    private AddUser addUser;
    private DeleteAddedUser deleteAddedUser;
    private LeavePage leavePage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public AdminPage getAdminPage() {
        if (adminPage == null) {
            adminPage = new AdminPage(driver);
        }
        return adminPage;
    }

    public MenuPage getMenuPage() {
        if (menuPage == null) {
            menuPage = new MenuPage(driver);
        }
        return menuPage;
    }

    public AddUser getAddUser() {
        if (addUser == null) {
            addUser = new AddUser(driver);
        }
        return addUser;
    }

    public DeleteAddedUser getDeleteAddedUser() {
        if (deleteAddedUser == null) {
            deleteAddedUser = new DeleteAddedUser(driver);
        }
        return deleteAddedUser;
    }

    public LeavePage getLeavePage() {
        if (leavePage == null) {
            leavePage = new LeavePage(driver);
        }
        return leavePage;
    }
}

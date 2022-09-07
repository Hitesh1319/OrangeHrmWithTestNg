package OrangeHrm.Test;


import org.testng.annotations.Test;

public class AddUserTest extends BaseClass {

    @Test
   public void addUserTest() throws InterruptedException {
        pageFactory.getLoginPage().login();
        pageFactory.getLoginPage().verifyLogin();
//        pageFactory.getMenuPage().menu();
//        pageFactory.getAdminPage().admin();
//        pageFactory.getAddUser().addUser();
//        pageFactory.getAddUser().verifyAddedUser();
//        pageFactory.getDeleteAddedUser().deleteAddedUser();
    }
}

package OrangeHrm.Test;

import org.testng.annotations.Test;

public class VerifyingByAddingUserAndDeleteSameUser extends BaseClass{
    @Test
    public void deleteSameUser() throws InterruptedException {
        pageFactory.getLoginPage().login();
        pageFactory.getMenuPage().menu();
        pageFactory.getAdminPage().admin();
        pageFactory.getAddUser().addUser();
        pageFactory.getAddUser().verifyAddedUser();
        pageFactory.getDeleteAddedUser().deleteAddedUser();
    }
}


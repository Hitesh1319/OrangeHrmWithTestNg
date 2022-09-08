package OrangeHrm.Test;

import org.testng.annotations.Test;

public class VerifyThatUserIsAbleToApplyLeave extends BaseClass {
    @Test
    public void leaveTest() {
        pageFactory.getLoginPage().login();
        pageFactory.getMenuPage().leave();
        pageFactory.getLeavePage().clickOnLeave();
        pageFactory.getLeavePage().applyLeave();
    }
}

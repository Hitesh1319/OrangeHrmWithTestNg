package OrangeHrm.Test;

import org.testng.annotations.Test;

public class VerifyThatUserIsAbleToSearchAndViewHisLeave extends BaseClass{
   @Test
    public void myLeave(){
       pageFactory.getLoginPage().login();
       pageFactory.getMenuPage().leave();
       pageFactory.getMenuPage().myLeave();
       pageFactory.getLeavePage().clickOnLeave();
       pageFactory.getLeavePage().myLeave();
    }
}

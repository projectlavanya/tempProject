package com.Testcases;

import com.pageactions.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AutomationPracticeWebsiteTestcase {
    HomePage homepage;
    @Test
    public void testsignin() throws InterruptedException {
        homepage=new HomePage(); //homePage_or= PageFactory.initElements(driver,HomePage_OR.class);
        homepage.signIN();
        Thread.sleep(3000);

    }
    @Test(dependsOnMethods = "testsignin")
    public void testCreateAccount() throws InterruptedException {
        Thread.sleep(3000);
       homepage.createAccount();
       homepage.EnterDetailsToCreatAcc();
    }

    @Test(dependsOnMethods = "testsignin")
    public void LogIN() throws InterruptedException {
      homepage.EnterLogIn();
    }
}

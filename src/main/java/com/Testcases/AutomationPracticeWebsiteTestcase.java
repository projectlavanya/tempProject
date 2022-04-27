package com.Testcases;

import com.pageactions.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AutomationPracticeWebsiteTestcase {
    HomePage homepage;
    @Test(priority=1)
    public void testsignin() throws InterruptedException {
        System.out.println("testsignin");
        homepage=new HomePage(); //homePage_or= PageFactory.initElements(driver,HomePage_OR.class);
        homepage.signIN();
        Thread.sleep(3000);

    }
    @Test(dependsOnMethods = "testsignin")
    public void testCreateAccount() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("testCreateAccount");
       homepage.createAccount();
       homepage.EnterDetailsToCreatAcc();
    }

    @Test(dependsOnMethods = "testCreateAccount")
    public void LogIN() throws InterruptedException {
        System.out.println("LogIN");
      homepage.EnterLogIn();
    }
}

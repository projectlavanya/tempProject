package com.pageactions;

import com.genericmethods.GenericMethods;
import com.pageobject.HomePage_OR;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.tools.StandardJavaFileManager;

public class HomePage extends GenericMethods {
    HomePage_OR homePage_or;
    public HomePage(){
        homePage_or= PageFactory.initElements(driver,HomePage_OR.class);
    }
    public void signIN(){
        System.out.println("signIN");
        HomePage_OR.Sign_in.click();

    }
    public void createAccount() throws InterruptedException {
        System.out.println("createAccount");
        HomePage_OR.CreateAccount.click();
        Thread.sleep(3000);
        System.out.println(HomePage_OR.EmptyAccountError.getText());
        System.out.println("Enter email to create account");
        HomePage_OR.EnterEmail.sendKeys("Friendsfor12@gmail.com");
        HomePage_OR.CreateAccount.click();
        Thread.sleep(3000);
    }

    public void EnterDetailsToCreatAcc() throws InterruptedException {
        System.out.println("Enter ur details to create account");
        HomePage_OR.Gender.click();
        HomePage_OR.CustomerFirstname.sendKeys("Rahul");
        HomePage_OR.CustomerLasttname.sendKeys("Santh");
        HomePage_OR.Password.sendKeys("123456");
        HomePage_OR.EnterAddress.sendKeys("123 Maryrich ln");
        HomePage_OR.EnterCity.sendKeys("San Diego");
        Select State  = new Select( HomePage_OR.SelectState);
        State.selectByVisibleText("Arizona");
        HomePage_OR.EnterPostcode.sendKeys("92132");
        Select Country  = new Select( HomePage_OR.EnterCountry);
        Country.selectByVisibleText("United States");
        HomePage_OR.EnterPhonemobile.sendKeys("123456789");
        HomePage_OR.EnterAdditionalinfo.sendKeys("market");
        HomePage_OR.SubmitAccount.click();
        Thread.sleep(2000);

    }

    public void EnterLogIn() throws InterruptedException {
        Thread.sleep(2000);
        HomePage_OR.EmailID.sendKeys("Friendsfor12@gmail.com");
        HomePage_OR.Emailpassword.sendKeys("123456");
        HomePage_OR.SubmitLogIN.click();
        Thread.sleep(3000);
        HomePage_OR.ReturnHomepage.click();
            Thread.sleep(2000);

    }
}

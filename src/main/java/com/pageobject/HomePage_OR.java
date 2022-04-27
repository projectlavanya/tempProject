package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_OR {
    @FindBy(xpath="//a[normalize-space(text())='Sign in']")
    public static WebElement Sign_in;
    @FindBy(id="SubmitCreate")
    public static WebElement CreateAccount;
    @FindBy(id="create_account_error")
    public static WebElement EmptyAccountError;
    @FindBy( name="email_create")
    public static WebElement EnterEmail;
    @FindBy( name="id_gender")
    public static WebElement Gender;
        @FindBy( name="email_create")
    public static WebElement CreaterEmail;
        @FindBy(id="customer_firstname")
    public static WebElement CustomerFirstname;
    @FindBy(id="customer_lastname")
    public static WebElement CustomerLasttname;
    @FindBy(id= "passwd")
    public static WebElement Password;
     @FindBy(name="address1")
    public static WebElement EnterAddress;
    @FindBy(id="city")
    public static WebElement EnterCity;
    @FindBy(id="id_state")
    public static WebElement SelectState;
    @FindBy(id="postcode")
    public static WebElement EnterPostcode;
    @FindBy(id="id_country")
    public static WebElement EnterCountry;
    @FindBy(id="phone_mobile")
    public static WebElement EnterPhonemobile;
    @FindBy(id="alias")
    public static WebElement EnterAdditionalinfo;
    @FindBy(id="submitAccount")
    public static WebElement SubmitAccount;

    @FindBy(xpath="//a[normalize-space(text())='Sign out']")
    public static WebElement LogOut;
    @FindBy(id="email")
    public static WebElement EmailID;
    @FindBy(id="passwd")
    public static WebElement Emailpassword;
    @FindBy(id="SubmitLogin")
    public static WebElement SubmitLogIN;
    @FindBy(xpath="//a[@title='Home']")
    public static WebElement ReturnHomepage;

}

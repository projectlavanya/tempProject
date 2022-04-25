package com.Testcases;

import com.fileUtils.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;

public class RegisterUser extends FileUtils {
    WebDriver driver;
    @Test(priority=1)
    public void launchBrowser(String Urlpath) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Urlpath);
        Thread.sleep(7000);
        driver.manage().window().maximize();
        System.out.println("Browser Launched");
    }
    @Test(priority=2)
    public void NewUserRegistration() throws IOException, ParseException, InterruptedException {

        // 2. extract user data in to JSONArray
        String file = "C:\\Users\\18587\\IdeaProjects\\Lavanya_Api_testing\\src\\test\\resources\\Testdata\\Mytestdata.json";
        JSONObject jsonObject = getJsonobjFromJsonfile(file);
        JSONArray userArray = (JSONArray) jsonObject.get("UserRegDetails");
        System.out.println(userArray.size());

        String Urlpath = "https://demo.nopcommerce.com/";
        launchBrowser(Urlpath);

       // Iterator<JSONObject> iterator = userArray.iterator();


          //  while(iterator.hasNext()) {
           for(int i=0;i<userArray.size();i++) {

               driver.findElement(By.linkText("Register")).click();
               Thread.sleep(5000);
               //4. extract individual user details for registration
               JSONObject user = (JSONObject) userArray.get(i);
               //System.out.println(user.get("First Name"));
               String firstName = String.valueOf(user.get("First Name"));
               //System.out.println(user.get("Last Name"));
               String LastName = String.valueOf(user.get("Last Name"));

               String email = String.valueOf(user.get("Email"));

               String pwd = String.valueOf(user.get("Password"));
               String cnfpwd = String.valueOf(user.get("Confirm password"));

               //5. enter User registration
               driver.findElement(By.id("FirstName")).sendKeys(firstName);
               driver.findElement(By.id("LastName")).sendKeys(LastName);
               driver.findElement(By.id("Email")).sendKeys(email);
               driver.findElement(By.id("Password")).sendKeys(pwd);
               driver.findElement(By.id("ConfirmPassword")).sendKeys(cnfpwd);
               Thread.sleep(3000);
               driver.findElement(By.id("register-button")).click();
               if(email.isEmpty()||email.isBlank()) {
                  WebElement e1 = driver.findElement(By.xpath("//span[@id='Email-error']"));
                  System.out.println(e1.getText());
                   String email1 = "rgggg21112443@yahoo.com";
                   driver.findElement(By.id("Email")).sendKeys(email1);
                   driver.findElement(By.id("register-button")).click();
               }
               System.out.println("Registration Successful");
               Thread.sleep(1000);
               //WebElement e = driver.findElement(By.xpath("//h1[text()='Register']/parent::div/following-sibling::div/child::div"));
               //System.out.println(e.getText());
               driver.findElement(By.linkText("Log out")).click();
               Thread.sleep(3000);
           }

        driver.close();
        driver.quit();
    }
}

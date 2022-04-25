package com.Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserLaunch {

    @Test
    public void browserlaunch() throws InterruptedException {
        /*WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        String actualURL="https://demo.nopcommerce.com/";
        driver.get(actualURL);
        Thread.sleep(7000);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        String ExpectedURL=driver.getCurrentUrl();
        System.out.println(ExpectedURL);
        Assert.assertEquals(actualURL,ExpectedURL);
        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(5000);
        driver.close();
        driver.quit();*/
    }
}

package com.Testcases;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Amazontrail {
    @Test
    public void browserlaunch() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String actualURL = "https://www.amazon.com";
        driver.get(actualURL);
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        String ExpectedURL = driver.getCurrentUrl();
        System.out.println(ExpectedURL);
        driver.findElement(By.id("twotabsearchtextbox")).click();
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        System.out.println("Hello world!");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("charger");
        Thread.sleep(3000);
        driver.findElement(By.id("nav-search-bar-form")).submit();
        driver.findElement(By.id("a-autoid-0-announce")).click();
        System.out.println("Hello world!");
        driver.findElement(By.id("s-result-sort-select_2")).click();
        List<WebElement> resultsList = driver.findElements(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
        int size = resultsList.size();
        System.out.println("Size of list = " + size);
        resultsList.get(2).click();

        //Will click on Next link until we reach the last page and keep on saving price in list

        driver.close();
        driver.quit();
    }
}
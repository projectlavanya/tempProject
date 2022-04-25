package com.Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonIphoneTesing {
    @Test
    public void SearchAmzForIphone() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String actualURL = "https://www.amazon.com/";
        driver.get(actualURL);
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);

        String ExpectedURL = driver.getCurrentUrl();
        System.out.println(ExpectedURL);
        Assert.assertEquals(actualURL, ExpectedURL);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
        Thread.sleep(2000);
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(1000);
       //driver.findElements(By.xpath("//*[@id=\\\"search\\\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
        List<WebElement> listOfinstanceElements = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println(listOfinstanceElements.size());

        String path = "//div[contains(@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 AdHolder sg-col s-widget-spacing-small sg-col-12-of-16')]";
        List<WebElement> item = driver.findElements(By.xpath(path));
        for(int i=0; i<  item.size(); i++){
            WebElement ele = item.get(i);
            Object obj = ele.findElements(By.xpath("'.//span[@class=\"a-price-whole\"]"));
            System.out.println (obj.toString());
        }


        driver.close();
        driver.quit();
    }
}

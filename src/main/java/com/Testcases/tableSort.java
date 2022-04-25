package com.Testcases;

import com.Model.WebTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.ArrayList;
import java.util.List;
public class tableSort {


  @Test
    public void redifTable() throws InterruptedException {
        List<WebTable> tableData = new ArrayList<>();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String actualURL = "https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose";
        driver.get(actualURL);
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        List<WebElement> tableRows = driver.findElements(By.xpath("//div[@id='leftcontainer']/table/tbody/tr"));
        for(int r=0;r<= tableRows.size()-525;r++){
            String colXpath="//div[@id='leftcontainer']/table/tbody/tr["+(r+1)+"]/td";
            List<WebElement> tableCols = driver.findElements(By.xpath(colXpath));

            //reading every row and each column value
            String company = tableCols.get(0).getText();
            String group = tableCols.get(1).getText();
            String prevClose = tableCols.get(2).getText();
            String curPrice = tableCols.get(3).getText();
            String change = tableCols.get(4).getText();

            //write column data in to webTable object using constructor
            WebTable tab = new WebTable(company, group, prevClose, curPrice, change);
            // add wnew WebTable column data to the table
            boolean add = tableData.add(tab);

        }
      System.out.println("Test End Data Table ready");
      System.out.println(tableData);
      System.out.println("Test End Data Table print");
      Thread.sleep(1000);
      driver.close();
      driver.quit();

    }
}

package com.Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Locale;

public class PracticeAutomation {
   WebDriver driver;
    @BeforeSuite
    public void activateBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        String actualURL="http://automationpractice.com/index.php";
        driver.get(actualURL);
        Thread.sleep(5000);
        driver.manage().window().maximize();
    }
    @Test
    public void accountcheck() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space(text())='Sign in']")).click();
        Thread.sleep(7000);
        String createAccountsubmit = "SubmitCreate";
        driver.findElement(By.name(createAccountsubmit)).click();
        Thread.sleep(2000);
        WebElement e1 = driver.findElement(By.id("create_account_error"));
        System.out.println(e1.getText());
        Thread.sleep(3000);
        driver.findElement(By.name("email_create")).sendKeys("Friendsfor@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(3000);
        System.out.println("Enter Details to create an account");
        WebElement Radio= driver.findElement(By.name("id_gender"));
        Radio.click();
        driver.findElement(By.id("customer_firstname")).sendKeys("donty");
        driver.findElement(By.id("customer_lastname")).sendKeys("Morbi");
        driver.findElement(By.id("passwd")).sendKeys("123456");
      /*  driver.findElement(By.id("(//*[@id=uniform-days]/child::select")).click();
        WebElement DAY=driver.findElement(By.id("(//*[@id=uniform-days]/child::select"));
        Select Daysinyear = new Select(DAY);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)",DAY);
        Daysinyear.selectByVisibleText("27");



        Select monthsinyear = new Select( driver.findElement(By.id("months")));
        monthsinyear.selectByVisibleText("Aug");
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByVisibleText("1999");*/
        System.out.println("Address Details");
        driver.findElement(By.name("address1")).sendKeys("1234");
        driver.findElement(By.id("city")).sendKeys("SD");
        Select State= new Select(driver.findElement(By.id("id_state")));
        State.selectByVisibleText("Arizona");
        driver.findElement(By.id("postcode")).sendKeys("92131");
        Select Country  = new Select(driver.findElement(By.id("id_country")));
        Country.selectByVisibleText("United States");
        driver.findElement(By.id("phone_mobile")).sendKeys("123456789");
        driver.findElement(By.id("alias")).sendKeys("market");

        driver.findElement(By.id("submitAccount")).click();
        Thread.sleep(3000);
        Assert.assertTrue("dontt Morrii",true);
        driver.findElement(By.xpath("//a[normalize-space(text())='Sign out']")).click();
        Thread.sleep(3000);



    }
    @Test
    public void SignIn() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space(text())='Sign in']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("Friendsfor@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("123456");
        Thread.sleep(3000);
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='Home']")).click();

    }
    @Test
    public void Information() throws InterruptedException {
        //driver.findElement(By.xpath("//a[normalize-space(text())='Sign in']")).click();
        String events[]={"specials", "new products","best sellers"};

        for(int i=0;i<events.length;i++){

            String InfoSubLink = events[i];

            switch(InfoSubLink.toLowerCase()){
                case "specials":
                    driver.findElement(By.xpath("//a[normalize-space(text())='Specials']")).click();
                    Thread.sleep(2000);
                    System.out.println("Back to homepage");
                    driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();


                    break;
                case "new products":
                    driver.findElement(By.xpath("//a[normalize-space(text())='New products']")).click();
                    System.out.println("Back to homepage");
                    driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();

                    break;
                case "best sellers":
                    driver.findElement(By.xpath("//a[normalize-space(text())='Best sellers']")).click();
                    System.out.println("Back to homepage");
                    driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
                    break;
                case "our stores":
                    driver.findElement(By.xpath("//a[normalize-space(text())='Our stores']")).click();
                    System.out.println("Back to homepage");
                    driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
                    break;
                case "contact us":
                    driver.findElement(By.xpath("//a[normalize-space(text())='Contact us']")).click();
                    System.out.println("Back to homepage");
                    driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
                    break;
                case "terms and conditions of use":
                    driver.findElement(By.xpath("//a[normalize-space(text())='Terms and conditions of use']")).click();
                    System.out.println("Back to homepage");
                    driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
                    break;
                case "about us":
                    driver.findElement(By.xpath("//a[normalize-space(text())='About us']")).click();
                    System.out.println("Back to homepage");
                    driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
                    break;
                case "sitemap":
                    driver.findElement(By.xpath("//a[normalize-space(text())='Sitemap']")).click();
                    System.out.println("Back to homepage");
                    driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();


                    break;
            }//switch

        }//for(i=
    }

    @AfterSuite
    public void teardown(){

        driver.close();
        driver.quit();

    }
}

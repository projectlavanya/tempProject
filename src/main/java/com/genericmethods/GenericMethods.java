package com.genericmethods;

import com.ApiUtils.HTTPMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
public class GenericMethods {
    public static WebDriver driver;
    Logger logger = Logger.getLogger(HTTPMethods.class.getName());
@Step("Launching Browser {0} with the url {1}")
    public static void browserlaunch(String browserType, String url) {
        switch (browserType.toLowerCase()) {
            case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
            case "ff":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.get(url);
        driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, SECONDS);

        }

@Step("Closing browser session")
    public void closeBrowser(){
    driver.close();
    driver.quit();
    }
    @Step("click the element {1} on the page {0}")
    public boolean clickElement(String pagename, String elementname, WebElement element)
    {
        boolean status=true;
        try{
            Actions action=new Actions(driver);
            action.moveToElement(element).click(element).build().perform();
            }catch(Exception e){
            status = false;
        }return status;
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] getScreenshot() {
        TakesScreenshot sht=(TakesScreenshot)driver;
        return sht.getScreenshotAs(OutputType.BYTES);
    }

}

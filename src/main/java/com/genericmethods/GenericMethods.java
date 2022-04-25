package com.genericmethods;

import com.ApiUtils.HTTPMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

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
        }

@Step("Closing browser session")
    public void closeBrowser(){
    driver.close();
    driver.quit();
    }
}

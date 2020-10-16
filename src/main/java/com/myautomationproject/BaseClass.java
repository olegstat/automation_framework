package com.myautomationproject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;
    public String homePageUrl;
    public Properties prop;

    public WebDriver initWebDriver() throws IOException {
        String browserName = getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", ".//src//main//resources//webdrivers//chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            //firefox driver code
        }else if(browserName.equalsIgnoreCase("ie")){
            //IE driver code
        }else {
            System.out.println("No browser detected");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }

    public String getHomePageUrl() throws IOException {
        homePageUrl = getProperty("homePageUrl");
        return homePageUrl;

    }

    public String getTitle(String lang) throws IOException {
        String title = null;
        if(lang.equalsIgnoreCase("ro")){
            title = getProperty("titleRo");
        }else if(lang.equalsIgnoreCase("ru")){
            title = getProperty("titleRu");
        }
        return title;
    }

    private String getProperty(String propertyName) throws IOException {
        prop = new Properties();
        FileInputStream propFile = new FileInputStream(".//src//main//resources//data.properties");
        prop.load(propFile);
        String property = prop.getProperty(propertyName);
        return property;
    }

    public void takeScreenShot(String testName, WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"//reports//"+testName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
    }
}

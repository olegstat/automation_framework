package com.myautomationproject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
            String browserName = "";
        if(System.getProperty("browser")==null){
            browserName = getProperty("browser");
        }else{
            browserName = System.getProperty("browser");
        }

        if (browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".//src//main//resources//webdrivers//chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            if(browserName.contains("headless")){
                options.addArguments("headless");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".//src//main//resources//webdrivers//geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", ".//src//main//resources//webdrivers//IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        if (lang.equalsIgnoreCase("ro")) {
            title = getProperty("titleRo");
        } else if (lang.equalsIgnoreCase("ru")) {
            title = getProperty("titleRu");
        }
        return title;
    }

    public String getProperty(String propertyName) throws IOException {
        prop = new Properties();
        FileInputStream propFile = new FileInputStream(".//src//main//resources//dataset.xml");
        prop.loadFromXML(propFile);
        String property = prop.getProperty(propertyName);
        return property;
    }

    public String takeScreenShot(String testName, WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "//reports//" + testName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
}

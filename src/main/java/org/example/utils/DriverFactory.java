package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maxim\\Desktop\\chromedriver-win64\\chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", "C:\\Users\\ZelenskayaOlga\\Downloads\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
            return new FirefoxDriver();
        }
        return null;
    }
}

package org.example.utils;

import org.example.enums.Capability;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;
    static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    public synchronized static WebDriver getDriver() {
        if (localDriver.get() == null) {
            driver = DriverFactory.createDriver(PropertyReader.getConfigProperty(Capability.BROWSER));
            EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator();
            driver = decorator.decorate(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            localDriver.set(driver);
            return driver;
        } else {
            return localDriver.get();
        }
    }
    public static void quitDriver() {
        localDriver.get().quit();
        localDriver.set(null);
    }
}

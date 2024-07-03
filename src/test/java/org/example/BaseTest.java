package org.example;

import org.example.listeners.TestListeners;
import org.example.pages.HomePage;
import org.example.utils.ConfProperties;
import org.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListeners.class)
public class BaseTest {
    public static HomePage homePage;
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
        driver = DriverManager.getDriver();
        //открываем сайт МЕГАТОП
        driver.get(ConfProperties.getProperty("homepage"));
        //подтверждаем город, в котором находимся
        homePage.clickDaBtn();
        //соглашаемся с принятием файлов cookie
        homePage.clickCookieBtn();
    }

//    @AfterMethod
//    public void closeSession(){
//        DriverManager.quitDriver();
//    }
}

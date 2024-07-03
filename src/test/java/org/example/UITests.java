package org.example;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.ProductPage;
import org.example.pages.ProfilePage;
import org.example.utils.ConfProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITests extends BaseTest{
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static ProductPage productPage;
    // Тест 1
    // Описание:
    //1. Пользователь открывает главную страницу;
    //2. Пользователь открывает страницу аутентификации;
    //3. Пользователь производит ввод валидных логина и пароля;
    //4. Пользователь удостоверяется в успешной аутентификации — об этом свидетельствует приветствие по имени пользователя;
    //5. Пользователь осуществляет выход из аккаунта путем нажатия на "Выйти".

    @Test
    public void validPhoneAndPasswordTest() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        productPage = new ProductPage();
        //нажимаем кнопку входа в аккаунт
        homePage.clickProfileBtn();
        //вводим номер телефона
        loginPage.inputPhoneNumber(ConfProperties.getProperty("phone"));
        //вводим пароль
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемое приветствие
        String user = profilePage.getUserName();
        //сравниваем ожидаемый и фактический результат
        Assert.assertEquals("ПРИВЕТ, МАКСИМ", user);
        profilePage.clickLogoutBtn();
    }
    // Тест 2
    // Описание:
    //1. Пользователь открывает главную страницу;
    //2. Пользователь нажимает на кнопку "Поиск";
    //3. Пользователь вводит код товара и нажимает Enter;

    @Test
    public void searchProductTest() throws InterruptedException {
        homePage = new HomePage();
        productPage = new ProductPage();
        //нажимаем на кнопку поиска
        homePage.clickSearchBtn();
        Thread.sleep(1000);
        //ввод значения для поиска товара
        homePage.putValue(ConfProperties.getProperty("value"));
        Thread.sleep(1000);
        //получаем title результата поиска
        String result = productPage.getSearchResult();
        //сравниваем ожидаемый и фактический результат
        Assert.assertEquals("ПОИСК ПО ЗАПРОСУ '108329606'", result);
    }
}

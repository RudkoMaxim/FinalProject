package org.example;

import org.example.pages.*;
import org.example.utils.ConfProperties;
import org.example.utils.ScreenShotUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITests extends BaseTest{
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static ProductPage productPage;
    public static SalePage salePage;
    public static CartPage cartPage;


    // Тест 1
    // Описание:
    //1. Пользователь открывает главную страницу;
    //2. Пользователь открывает страницу аутентификации;
    //3. Пользователь производит ввод валидных номера телефона и пароля;
    //4. Пользователь удостоверяется в успешной аутентификации — об этом свидетельствует приветствие по имени пользователя;
    //5. Пользователь осуществляет выход из аккаунта путем нажатия на "Выйти".
    @Test
    public void validPhoneAndPasswordTest() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        productPage = new ProductPage();
        salePage = new SalePage();
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
        //делаем screenshot
        ScreenShotUtils.takeScreenshot(driver);
    }
    // Тест 2
    // Описание:
    //1. Пользователь открывает главную страницу;
    //2. Пользователь нажимает на кнопку "Поиск";
    //3. Пользователь вводит код товара и нажимает Enter;
    @Test
    public void searchProductTest() {
        homePage = new HomePage();
        productPage = new ProductPage();
        //нажимаем на кнопку поиска
        homePage.clickSearchBtn();
        //ввод значения для поиска товара
        homePage.putValue(ConfProperties.getProperty("value"));
        //получаем title результата поиска
        String result = productPage.getSearchResult();
        //делаем screenshot
        ScreenShotUtils.takeScreenshot(driver);
        //сравниваем ожидаемый и фактический результат
        Assert.assertEquals("ПОИСК ПО ЗАПРОСУ '108329606'", result);
    }
    @Test
    public void addToCartTest(){
        homePage = new HomePage();
        salePage = new SalePage();
        cartPage = new CartPage();
        //нажимаем на кнопку "Распродажа"
        homePage.clickSaleBtn();
        //нажимаем на кнопку добавления товара к корзину
        salePage.clickAddBtn();
        //нажимаем на кнопку выбора размера
        salePage.clickSizeSelectionBtn();
        //нажимаем на кнопку "Добавить в корзину"
        salePage.clickAddToCartBtn();
        //поиск наименования товара, добавленного в корзину
        cartPage.getProductTitleOnCart();
        //нажатие на кнопку закрытия корзины
        cartPage.clickCloseCartBtn();
        //поиск наименования товара на странице, который ранее был добавлен в корзину
        salePage.getProductTitleOnPage();
        Assert.assertEquals("getProductTitleOnCart", "getProductTitleOnPage");
    }
    // Тест 4
    // Описание:
    //1. Пользователь открывает главную страницу;
    //2. Пользователь открывает страницу аутентификации;
    //3. Пользователь производит ввод валидного номера телефона и невалидного пароля;
    //4. Пользователь получает ошибку;
    @Test
    public void validPhoneAndInValidPasswordTest() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        productPage = new ProductPage();
        salePage = new SalePage();
        //нажимаем кнопку входа в аккаунт
        homePage.clickProfileBtn();
        //вводим номер телефона
        loginPage.inputPhoneNumber(ConfProperties.getProperty("phone"));
        //вводим пароль
        loginPage.inputPassword(ConfProperties.getProperty("invalidPassword"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем ошибку
        String error = profilePage.getErrorText();
        //делаем screenshot
        ScreenShotUtils.takeScreenshot(driver);
        //сравниваем текст ошибки на экране и ожидаемый
        Assert.assertEquals("Вы ввели неверный номер телефона и/или пароль", error);
    }
}

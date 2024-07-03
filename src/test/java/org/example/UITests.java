package org.example;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.ProfilePage;
import org.example.utils.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITests extends BaseTest{
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    // Тест 1
    // Описание:
    //1. Пользователь открывает страницу аутентификации;
    //2. Пользователь производит ввод валидных логина и пароля;
    //3. Пользователь удостоверяется в успешной аутентификации — об этом свидетельствует имя пользователя по центру окна;
    //4. Пользователь осуществляет выход из аккаунта путем нажатия на имя пользователя в верхнем правом углу окна с последующим нажатием на кнопку «Выйти…».

    @Test
    public void validPhoneAndPasswordTest() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        homePage.clickDaBtn();
        homePage.clickCookieBtn();
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

}

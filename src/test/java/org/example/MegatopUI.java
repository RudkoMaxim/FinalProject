package org.example;

import org.example.pages.BasePage;
import org.testng.annotations.Test;

public class MegatopUI {
    // Тест 1
    // Проверка авторизации
    @Test
    public void testLogin() throws InterruptedException {
        BasePage basePage = new BasePage();
        basePage.openUrl();
        basePage.clickDaBtn();  // Кликаем на кнопку "Да" при выборе города
        Thread.sleep(1000);
        basePage.clickCookieBtn(); // Кликаем на кнопку согласия с cookie
        Thread.sleep(1000);
        basePage.clickProfileBtn();
    }
}

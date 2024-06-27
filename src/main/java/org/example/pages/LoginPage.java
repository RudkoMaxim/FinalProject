package org.example.pages;

import org.example.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//form[@class='v-form']//input[contains(@id, 'input-29') and @type='text']")  // инпут ввода номера телефона
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//form//input[contains(@id, 'input-') and @type='password']")  // инпут ввода пароля
    private WebElement passwordInput;

    @FindBy(xpath = "//*[contains(text(), 'Войти')] [1]")  // кнопка Войти
    private WebElement loginBtn;

}


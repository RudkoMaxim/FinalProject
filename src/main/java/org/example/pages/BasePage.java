package org.example.pages;

import org.example.utils.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    @FindBy(xpath = "//*[@class = 'btn-gray v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default'][1]")  // кнопка подтверждения города
    private WebElement daBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[7]/div[3]/button[2]/span")   // кнопка согласия с cookie
    private WebElement cookieBtn;

    @FindBy(xpath = "//*[contains(text(), 'Профиль')] [1]")    // кнопка входа в профиль
    private WebElement profileBtn;

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void openUrl() {DriverManager.getDriver().get("https://megatop.by/");} // открываем URL

    public void clickDaBtn() {
        daBtn.click();
    } // Нажатие кнопки "ДА", подтверждаем город

    public void clickCookieBtn() {cookieBtn.click();} // Нажатие на кнопку согласия с cookie

    public void clickProfileBtn() {
        profileBtn.click();
    } // Нажатие на кнопку входа в профиль
}

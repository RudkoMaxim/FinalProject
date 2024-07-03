package org.example.pages;

import org.example.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    /**
     * определение локатора кнопки подтверждения населенного пункта
     */
    @FindBy(xpath = "//*[@class = 'btn-gray v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default'][1]")  // кнопка подтверждения города
    private WebElement daBtn;
    /**
     * определение локатора кнопки согласия с cookie
     */
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[7]/div[3]/button[2]/span")   // кнопка согласия с cookie
    private WebElement cookieBtn;
    /**
     * определение локатора кнопки перехода на страницу логина
     */
    @FindBy(xpath = "//*[contains(text(), 'Профиль')] [1]")    // кнопка входа в профиль
    private WebElement profileBtn;

//    public void openUrl() {DriverManager.getDriver().get("https://megatop.by/");} // открываем URL
    /**
     * метод для осуществления нажатия кнопки "ДА", подтверждения верно определенного населенного пункта
     */
    public void clickDaBtn() {
        daBtn.click();
    } // Нажатие кнопки "ДА", подтверждаем город
    /**
     * метод для осуществления нажатия кнопки согласия с cookie
     */
    public void clickCookieBtn() {cookieBtn.click();} // Нажатие на кнопку согласия с cookie
    /**
     * метод для осуществления нажатия кнопки перехода к странице авторизации
     */
    public void clickProfileBtn() {
        profileBtn.click();
    } // Нажатие на кнопку входа в профиль
}

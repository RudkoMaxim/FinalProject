package org.example.pages;

import org.example.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public ProfilePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    /**
     * определение локатора приветствия в профиле пользователя
     */
    @FindBy(xpath = "//*[@class = 'text-uppercase profile__title col col-12']")
    private WebElement profileTitle;
    /**
     * определение локатора кнопки выхода из профиля пользователя
     */
    @FindBy(xpath = "//*[contains(text(), 'Выйти')]")
    private WebElement logoutBtn;
    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getUserName() {
            return profileTitle.getText();
    }
    /**
     * * метод для осуществления нажатия кнопки выхода из профиля пользователя
     */
    public void clickLogoutBtn(){
        logoutBtn.click();
        }
}
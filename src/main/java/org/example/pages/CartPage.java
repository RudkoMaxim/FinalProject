package org.example.pages;

import org.example.utils.DriverManager;
import org.example.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    /**
     * определение локатора наименования товара в корзине
     */
    @FindBy(xpath = "//div[@class = 'product__title']")
    private WebElement productTitleOnCart;
    /**
     * определение локатора кнопки закрыть корзину
     */
    @FindBy(xpath = "//div[@class = 'v-responsive__content'][1]")
    private WebElement closeCartBtn;


    /**
     * метод для осуществления поиска наименования товара в корзине
     */
    public String getProductTitleOnCart() {
        Waiters.waitForSeconds(1);
        return productTitleOnCart.getText();
    }
    /**
     * метод для осуществления нажатия по кнопке "Закрыть корзину"
     */
    public void clickCloseCartBtn(){
        Waiters.waitForSeconds(1);
        closeCartBtn.click();
    }
}

package pages;

import basesClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    private final String ALLO_LOGO = "//a[@class='v-logo']";
    private final String SEARCH_FIELD = "//input[@id='search-form__input']";
    private final String SEARCH_BTN = "//button[@class='search-form__submit-button']";
    private final String BUYER_DROPDOWN_MENU = "//a[@class='mh-button mh-button--open']";
    private final String DELIVERY_AND_PAY = "//a[contains(text(),'Доставка і оплата')][@class='mh-button']";
    private final String PAGE_TITLE = "//h2[@class='sp-page-title sp-h2 page-header']";
    private final String PLACE_ORDER = "//h3[@class='sub-block-header'][contains(text(),'Як оформити замовлення?')]";

    public WebElement alloLogo(){
        return visibilityOfElementByXpath(ALLO_LOGO);
    }
    public WebElement searchField(){
        return visibilityOfElementByXpath(SEARCH_FIELD);
    }
    public WebElement searchBtn(){
        return visibilityOfElementByXpath(SEARCH_BTN);
    }
    public WebElement buyerDropDown(){
        return visibilityOfElementByXpath(BUYER_DROPDOWN_MENU);
    }
    public WebElement deliveryAndPay(){
        return visibilityOfElementByXpath(DELIVERY_AND_PAY);
    }
    public WebElement pageTitle(){
        return visibilityOfElementByXpath(PAGE_TITLE);
    }
    public WebElement placeOrder(){
        return visibilityOfElementByXpath(PLACE_ORDER);
    }

}

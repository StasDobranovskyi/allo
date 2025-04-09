package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.SplittableRandom;

public class CatalogPage extends BasePage {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    private final String FIRST_ITEM_FEN = "//div[@data-product-id='12798167']";
    private final String PRODUCT_NAME = "//a[@title='Навушники Apple AirPods 3 with Lightning Charging Case (MPNY3TY/A)']";
    private final String FIRST_PRODUCT_LINK = "(//a[contains(@class, 'product-card__title')][1])";
    private final String VIEW_MODEL_BTN = "//button[@class='view-mode__button' and @title='Таблиця']";
    private final String NAMES_SEARCHED_PRODUCTS = "//div[@class='product-card__content']/a[@class='product-card__title']";
    private final String NUMBERS_COMMENT = "//span[@class='review-button__text review-button__text--count']";

    public WebElement firstItemFen(){
        return visibilityOfElementByXpath(FIRST_ITEM_FEN);
    }

    public WebElement productName(){
        return visibilityOfElementByXpath(PRODUCT_NAME);
    }

    public WebElement firstProductLink(){
        return visibilityOfElementByXpath(FIRST_PRODUCT_LINK);
    }

    public WebElement viewModelBtn(){
        return visibilityOfElementByXpath(VIEW_MODEL_BTN);
    }

    public List<WebElement> nameSearchedProducts(){
        return visibilityOfElementLocatorByXpath(NAMES_SEARCHED_PRODUCTS);
    }

    public List<WebElement> numberComments(){
        return visibilityOfElementLocatorByXpath(NUMBERS_COMMENT);
    }

}

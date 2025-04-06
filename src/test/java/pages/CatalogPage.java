package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage extends BasePage {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    private final String FIRST_ITEM_FEN = "//div[@data-product-id='12798167']";
    private final String PRODUCT_NAME = "//a[@title='Навушники Apple AirPods 3 with Lightning Charging Case (MPNY3TY/A)']";
    private final String FIRSTPRODUCTLINK = "(//a[contains(@class, 'product-card__title')][1])";

    public WebElement firstItemFen(){
        return visibilityOfElementByXpath(FIRST_ITEM_FEN);
    }
    public WebElement productName(){
        return visibilityOfElementByXpath(PRODUCT_NAME);
    }
    public WebElement firstProductLink(){
        return visibilityOfElementByXpath(FIRSTPRODUCTLINK);
    }


}

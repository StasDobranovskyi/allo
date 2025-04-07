package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemsPage extends BasePage {

    public ItemsPage(WebDriver driver) {
        super(driver);
    }

    private final String PRODUCT_TITLE = "//h1[@itemprop='name']";

    public WebElement productTitle(){
        return visibilityOfElementByXpath(PRODUCT_TITLE);
    }

}

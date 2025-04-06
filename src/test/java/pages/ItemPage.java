package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    private final String PRODUCT_TITLE = "//h1[@itemprop='name']";

    public WebElement productTitle(){
        return visibilityOfElementByXpath(PRODUCT_TITLE);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}

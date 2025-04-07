package pages;

import basesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryAndPayPage extends BasePage {

    public DeliveryAndPayPage(WebDriver driver) {
        super(driver);
    }

    private final String PAGE_TITLE = "//h2[@class='sp-page-title sp-h2 page-header']";
    private final String PLACE_ORDER = "//h3[@class='sub-block-header'][contains(text(),'Як оформити замовлення?')]";


    public WebElement pageTitle(){
        return visibilityOfElementByXpath(PAGE_TITLE);
    }

    public WebElement placeOrder(){
        return visibilityOfElementByXpath(PLACE_ORDER);
    }
}

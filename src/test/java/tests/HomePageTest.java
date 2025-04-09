package tests;

import basesClass.TestInit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.DeliveryAndPayPage;
import pages.HomePage;
import pages.ItemsPage;

import static basesClass.BasePage.getCurrentUrl;
import static basesClass.BasePage.openUrl;

public class HomePageTest extends TestInit {

    public String alloUrl = "https://allo.ua";

    @Test
    public void checkLogoDisplayed() {

        HomePage homePage = new HomePage(driver);
        openUrl(alloUrl);

        Assert.assertTrue(homePage.alloLogo().isDisplayed());

    }

    @Test
    public void searchFen() {

        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);

        String expItemFen = "Фен";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.searchField().isDisplayed());

        homePage.searchField().sendKeys(expItemFen);

        homePage.searchBtn().click();

        Assert.assertTrue(catalogPage.firstItemFen().getText().contains(expItemFen));

    }

    @Test
    public void searchAirPods(){

        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        ItemsPage itemPage = new ItemsPage(driver);

        String expPartNameAirPods = "AirPods 3";
        String expPartUrl = "naushniki-apple-airpods-3";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.alloLogo().isDisplayed());

        homePage.searchField().sendKeys(expPartNameAirPods);
        homePage.searchBtn().click();

        String expFirstProductName = catalogPage.productName().getText();
        Assert.assertTrue(expFirstProductName.contains(expPartNameAirPods));

        catalogPage.firstProductLink().click();

        String actualName = itemPage.productTitle().getText();

        Assert.assertTrue(getCurrentUrl().contains(expPartUrl));

        Assert.assertEquals(actualName, expFirstProductName, "Назва товару на сторінці не співпадає!");

    }

    @Test
    public void checkBuyAndDelivery() {

        HomePage homePage = new HomePage(driver);
        DeliveryAndPayPage deliveryAndPayPage = new DeliveryAndPayPage(driver);

        String expOrderMsgText = "Як оформити замовлення?";
        String expDeliveryAndPayText = "Доставка і оплата";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.buyerDropDownMenu().isDisplayed());
        homePage.buyerDropDownMenu().click();

        Assert.assertTrue(homePage.deliveryAndPayBtn().isDisplayed());
        homePage.deliveryAndPayBtn().click();

        Assert.assertEquals(deliveryAndPayPage.pageTitle().getText(), expDeliveryAndPayText);

        Assert.assertTrue(deliveryAndPayPage.placeOrder().isDisplayed(), "Елемент не знайдено");
        Assert.assertEquals(deliveryAndPayPage.placeOrder().getText(), expOrderMsgText);

    }

    @Test
    public void checkResultSearchField(){

        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);

        String samsungTV = "Телевізор Samsung";
        String expNameTV = "Samsung";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.alloLogo().isDisplayed());

        homePage.searchField().sendKeys(samsungTV);
        homePage.searchBtn().click();

        Assert.assertTrue(catalogPage.viewModelBtn().isDisplayed());

        for (WebElement element : catalogPage.nameSearchedProducts()){
            Assert.assertTrue(element.getText().contains(expNameTV));
        }

    }
    @Test
    public void checkResultComment(){

        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);

        String samsungTV = "Телевізор Samsung";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.alloLogo().isDisplayed());

        homePage.searchField().sendKeys(samsungTV);
        homePage.searchBtn().click();

        Assert.assertTrue(catalogPage.viewModelBtn().isDisplayed());

        for (WebElement element : catalogPage.numberComments()){
            String numberComments = element.getText();
            System.out.println("Кількість коментарів " + numberComments);
            int number = Integer.parseInt(numberComments);
            if (number > 27){
                System.out.println(number);
            }
        }

    }

}

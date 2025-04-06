package tests;

import basesClass.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.HomePage;
import pages.ItemPage;

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

        String Item = "Фен";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.searchField().isDisplayed());

        homePage.searchField().sendKeys(Item);

        homePage.searchBtn().click();

        Assert.assertTrue(catalogPage.firstItemFen().getText().contains(Item));

    }

    @Test
    public void searchAirPods(){

        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        ItemPage itemPage = new ItemPage(driver);

        String Tovar1 = "AirPods 3";
        String expectedUrlPart = "naushniki-apple-airpods-3";


        openUrl(alloUrl);

        homePage.alloLogo();
        Assert.assertTrue(homePage.alloLogo().isDisplayed());

        homePage.searchField().sendKeys(Tovar1);

        homePage.searchBtn().click();

        Assert.assertTrue(catalogPage.productName().getText().contains(Tovar1));

        catalogPage.firstProductLink().click();

        String productPageName = itemPage.productTitle().getText();

        String url = getCurrentUrl();
        Assert.assertTrue(url.contains(expectedUrlPart));

        Assert.assertEquals(productPageName, itemPage.productTitle().getText(), "Назва товару на сторінці не співпадає!");

    }

    @Test
    public void checkBuyAndDelivery() {

        HomePage homePage = new HomePage(driver);

        String OrderMsg = "Як оформити замовлення?";
        String Delivery_And_Pay = "Доставка і оплата";

        openUrl(alloUrl);

        Assert.assertTrue(homePage.buyerDropDown().isDisplayed());
        homePage.buyerDropDown().click();

        Assert.assertTrue(homePage.deliveryAndPay().isDisplayed());
        homePage.deliveryAndPay().click();

        Assert.assertEquals(homePage.pageTitle().getText(),Delivery_And_Pay);

        Assert.assertTrue(homePage.placeOrder().isDisplayed(), "Елемент не знайдено");
        Assert.assertEquals(homePage.placeOrder().getText(),OrderMsg);

    }

}

//Ще один рядок))
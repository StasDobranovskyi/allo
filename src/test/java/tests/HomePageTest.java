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

        homePage.alloLogo();

        Assert.assertTrue(homePage.alloLogo().isDisplayed());

    }

    @Test
    public void searchFen() {

        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.searchField().isDisplayed());

        homePage.searchField().sendKeys("Фен");

        homePage.searchBtn().click();

        Assert.assertTrue(catalogPage.firstItemFen().getText().contains("Фен"));

    }

    @Test
    public void searchAirPods(){

        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        ItemPage itemPage = new ItemPage(driver);

        openUrl(alloUrl);

        homePage.alloLogo();

        homePage.searchField().sendKeys("AirPods 3");
        homePage.searchBtn().click();

        Assert.assertTrue(catalogPage.productName().getText().contains("AirPods 3"));

        catalogPage.firstProductLink().click();

        String productPageName = itemPage.productTitle().getText();

        Assert.assertTrue(itemPage.getCurrentUrl().contains("naushniki-apple-airpods-3"));
        Assert.assertEquals(productPageName, itemPage.productTitle().getText(), "Назва товару на сторінці не співпадає!");

    }

    @Test
    public void checkBuyAndDelivery() {

        HomePage homePage = new HomePage(driver);

        openUrl(alloUrl);

        homePage.buyerDropDown().click();
        Assert.assertTrue(homePage.buyerDropDown().isDisplayed());
        Assert.assertTrue(homePage.deliveryAndPay().isDisplayed());
        homePage.deliveryAndPay().click();

        Assert.assertEquals(homePage.pageTitle().getText(), "Доставка і оплата");

        Assert.assertTrue(homePage.placeOrder().isDisplayed(), "Елемент не знайдено");
        Assert.assertEquals(homePage.placeOrder().getText(), "Як оформити замовлення?");

    }

}

//Ще один рядок))
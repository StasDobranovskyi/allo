import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {

    @Test
    public void checkLogoDisplayed() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://allo.ua");

        WebElement logo = driver.findElement(By.xpath("//a[@class='v-logo']"));
        Assert.assertTrue(logo.isDisplayed());

        driver.quit();

    }

    @Test
    public void searchFen() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://allo.ua");

        WebElement searchField = driver.findElement(By.xpath("//input[@id='search-form__input']"));
        Assert.assertTrue(searchField.isDisplayed());

        searchField.sendKeys("Фен");

        WebElement searchBtn = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));
        searchBtn.click();

        Thread.sleep(5000);
        WebElement firstItem = driver.findElement(By.xpath("//div[@data-product-id='12798167']"));
        String productName = firstItem.getText();
        Assert.assertTrue(productName.contains("Фен"));

        driver.quit();

    }

    @Test
    public void searchAirPods()throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://allo.ua");

        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='v-logo']")));
        Assert.assertTrue(logo.isDisplayed());

        WebElement searchField = driver.findElement(By.xpath("//input[@id='search-form__input']"));
        Assert.assertTrue(searchField.isDisplayed());

        searchField.sendKeys("AirPods 3");

        Thread.sleep(2000);
        WebElement searchBtn = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));
        searchBtn.click();

        Thread.sleep(5000);
        String productName = driver.findElement(By.xpath("(//a[contains(@class, 'product-card__title')])[1]")).getText();
        Assert.assertTrue(productName.contains("AirPods 3"), "Назва товару не містить 'AirPods 3'");

        WebElement firstProductLink = driver.findElement(By.xpath("(//a[contains(@class, 'product-card__title')])[1]"));
        firstProductLink.click();

        Thread.sleep(3000);
        WebElement productTitle = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String productPageName = productTitle.getText();

        Assert.assertTrue(driver.getCurrentUrl().contains("naushniki-apple-airpods-3"));
        Assert.assertEquals(productPageName, productName, "Назва товару на сторінці не співпадає!");

        driver.quit();

    }

    @Test
    public void checkBuyAndDelivery() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://allo.ua");

        WebElement buyerDropDown = driver.findElement(By.xpath("//a[@class='mh-button mh-button--open']"));
        Assert.assertTrue(buyerDropDown.isDisplayed());
        buyerDropDown.click();
        Thread.sleep(2000);

        WebElement deliveryAndPay = driver.findElement(By.xpath("//a[contains(text(),'Доставка і оплата')][@class='mh-button']"));
        Assert.assertTrue(deliveryAndPay.isDisplayed());
        deliveryAndPay.click();

        WebElement pageTitle = driver.findElement(By.xpath("//h2[@class='sp-page-title sp-h2 page-header']"));
        Assert.assertEquals(pageTitle.getText(), "Доставка і оплата");

        WebElement placeOrder = driver.findElement(By.xpath("//h3[@class='sub-block-header'][contains(text(),'Як оформити замовлення?')]"));
        Assert.assertTrue(placeOrder.isDisplayed(), "Елемент не знайдено");
        Assert.assertEquals(placeOrder.getText(), "Як оформити замовлення?");

        driver.quit();

    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


import static java.lang.Thread.sleep;

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
    public void searchAirPods() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://allo.ua");

        // Очікуємо появу логотипу
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='v-logo']")));
        Assert.assertTrue(logo.isDisplayed());

        // Очікуємо поле пошуку
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search-form__input']")));
        Assert.assertTrue(searchField.isDisplayed());

        // Вводимо пошуковий запит
        searchField.sendKeys("AirPods 3");

        // Клікаємо кнопку пошуку
        WebElement searchBtn = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));
        searchBtn.click();

        // Очікуємо оновлення результатів та знаходимо перший товар
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='products-layout__item without-options-1']")));

        // Отримуємо текст елемента прямо перед кліком
        String productName = driver.findElement(By.xpath("(//a[contains(@class, 'product-card__title')])[1]")).getText();
        Assert.assertTrue(productName.contains("AirPods 3"), "Назва товару не містить 'AirPods 3'");

        // Клікаємо
        WebElement firstProductLink = driver.findElement(By.xpath("(//a[contains(@class, 'product-card__title')])[1]"));
        String productUrl = firstProductLink.getAttribute("href");

        firstProductLink.click();

        // Чекаємо, поки URL зміниться (переходимо на сторінку товару)
        wait.until(ExpectedConditions.urlToBe(productUrl));

        // Чекаємо завантаження сторінки товару
        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@itemprop='name']")));
        String productPageName = productTitle.getText();

        // Перевіряємо, що URL правильний
        Assert.assertTrue(driver.getCurrentUrl().contains("naushniki-apple-airpods-3"), "Перехід на сторінку товару не відбувся!");

        // Перевіряємо, що назви збігаються
        Assert.assertEquals(productPageName, productName, "Назва товару на сторінці не співпадає!");

        // Закриваємо браузер
        driver.quit();
    }

    @Test
    public void checkBuyAndDelivery() throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://allo.ua");

        WebElement buyerDropDown = driver.findElement(By.xpath("//a[@class='mh-button mh-button--open']"));
        Assert.assertTrue(buyerDropDown.isDisplayed());
        buyerDropDown.click();
        Thread.sleep(2000);
        Assert.assertTrue(buyerDropDown.isDisplayed(), "Меню не відкрилось!");

        WebElement deliveryAndPay = driver.findElement(By.xpath("//a[contains(text(),'Доставка і оплата')][@class='mh-button']"));
        Assert.assertTrue(deliveryAndPay.isDisplayed());
        deliveryAndPay.click();

        WebElement pageTitle = driver.findElement(By.xpath("//h2[@class='sp-page-title sp-h2 page-header']"));
        Assert.assertEquals(pageTitle.getText(),"Доставка і оплата");

        WebElement placeOrder = driver.findElement(By.xpath("//h3[@class='sub-block-header']"));
        Assert.assertTrue(placeOrder.isDisplayed(),"Текст не знайдено");
        Assert.assertEquals(placeOrder.getText(),"Як оформити замовлення?");






        driver.quit();

    }

}

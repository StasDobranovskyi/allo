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



}

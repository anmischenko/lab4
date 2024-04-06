import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

public class PlaySong {

    WebDriver driver = new ChromeDriver();

    @Before
    public void precondition() {

        driver.get("https://music.yandex.ru/");

        WebElement close = driver.findElement(By.xpath("//div[@class='pay-promo-close-btn js-close']"));
        close.click();
    }

    @Test
    public void testPlaySong() throws InterruptedException {

        WebElement chart = driver.findElement(By.xpath("//a[@class='typo-nav d-tabs__link page-main__title-chart']"));
        chart.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement firstSong = driver.findElement(By.xpath("//div[@class='lightlist__cont']//div[@data-id='1']//div[@class='d-track__overflowable-wrapper deco-typo-secondary']"));
        firstSong.click();

        WebElement play = driver.findElement(By.xpath("//div[@class='sidebar__controls']//span[@class='d-button-play__wrap']//button"));
        play.click();

    }

    @Test
    public void testAuth() throws InterruptedException {
        String emailStr = "autotestmusik@gmail.com";
        String passwordStr = "autotestmusik1234";
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://music.yandex.ru/");

        WebElement close = driver.findElement(By.xpath("//div[@class='pay-promo-close-btn js-close']"));
        close.click();

        WebElement login = driver.findElement(By.xpath("//span[@class='button__label']"));
        login.click();

        // Получаем все открытые вкладки
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        // Переключаемся на новую вкладку
        driver.switchTo().window(tabs.get(1));

        WebElement email = driver.findElement(By.xpath("//input[@id='passp-field-login']"));
        email.sendKeys(emailStr);

        WebElement emailButton = driver.findElement(By.xpath("//button[@id='passp:sign-in']"));
        emailButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement password = driver.findElement(By.xpath("//input[@id='passp-field-passwd']"));
        password.sendKeys(passwordStr);

        WebElement passwordButton = driver.findElement(By.xpath("//button[@id='passp:sign-in']"));
        passwordButton.click();

        driver.switchTo().window(tabs2.get(0));

        driver.navigate().refresh();
        driver.navigate().refresh();
    }

    @After
    public void postcondition() {
        driver.quit();
    }
}

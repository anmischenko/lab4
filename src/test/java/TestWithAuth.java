import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

public class TestWithAuth {

    WebDriver driver = new ChromeDriver();

    @Before
    public void precondition() {
        driver.manage().window().maximize();

        driver.get("https://music.yandex.ru/");

        WebElement close = driver.findElement(By.xpath("//div[@class='pay-promo-close-btn js-close']"));
        close.click();

        String emailStr = "autotestmusik@gmail.com";
        String passwordStr = "autotestmusik1234";

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

    @Test
    public void testLikeSong() {
        WebElement search = driver.findElement(By.xpath("//button[@class='d-button deco-button deco-button-flat d-button_type_flat d-button_w-icon d-button_w-icon-centered d-search__button']"));
        search.click();

        WebElement searchField = driver.findElement(By.xpath("//input[@class='d-input__field deco-input d-input__field_size-S deco-input_suggest']"));
        searchField.sendKeys("Liaze - 2003");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@class='d-button deco-button deco-button-flat d-button_type_flat d-button_w-icon d-button_w-icon-centered suggest-button suggest-button_left']"));
        buttonSearch.click();
    }

    @Test
    public void testChangeTheme() {
        WebElement profile = driver.findElement(By.xpath("//div[@class='user__userpic user__userpic_size_L user__userpic_plus_rainbow user__userpic_space']"));
        profile.click();

        WebElement settings = driver.findElement(By.xpath("//a[@class='d-link deco-link multi-auth__item typo-main multi-auth__settings deco-popup-menu__item d-link_no-hover-color deco-link_no-hover-color']"));
        settings.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement toggler = driver.findElement(By.xpath("//div[@class='page-settings__line deco-border page-settings__dark-theme-toggler']//div[@class='d-toggler__view deco-toggler-view']//div[@class='d-toggler__border deco-toggler-border']"));
        toggler.click();
    }

    @Test
    public void testSearchSong() {
        WebElement search = driver.findElement(By.xpath("//button[@class='d-button deco-button deco-button-flat d-button_type_flat d-button_w-icon d-button_w-icon-centered d-search__button']"));
        search.click();

        WebElement searchField = driver.findElement(By.xpath("//input[@class='d-input__field deco-input d-input__field_size-S deco-input_suggest']"));
        searchField.sendKeys("Liaze - 2003");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@class='d-button deco-button deco-button-flat d-button_type_flat d-button_w-icon d-button_w-icon-centered suggest-button suggest-button_left']"));
        buttonSearch.click();
    }


}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class Authorization {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите email:");
//        String emailStr = scanner.nextLine();
//        System.out.println("Введите password:");
//        String passwordStr = scanner.nextLine();
        String emailStr = "autotestmusik@gmail.com";
        String passwordStr = "autotestmusik1234";
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://music.yandex.ru/");

        driver.manage().window().maximize();

        WebElement close = driver.findElement(By.xpath("//div[@class='pay-promo-close-btn js-close']"));
        close.click();

        WebElement login = driver.findElement(By.xpath("//span[@class='button__label']"));
        login.click();

        // Получаем все открытые вкладки
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

        // Переключаемся на новую вкладку
        driver.switchTo().window(tabs.get(1));

        WebElement email = driver.findElement(By.xpath("//input[@id='passp-field-login']"));
        email.sendKeys(emailStr);

        WebElement emailButton = driver.findElement(By.xpath("//button[@id='passp:sign-in']"));
        emailButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement password = driver.findElement(By.xpath("//input[@id='passp-field-passwd']"));
        password.sendKeys(passwordStr);

        WebElement passwordButton = driver.findElement(By.xpath("//button[@id='passp:sign-in']"));
        passwordButton.click();

        driver.switchTo().window(tabs2.get(0));

        driver.navigate().refresh();
        driver.navigate().refresh();

        // Тест добавления трека в коллекцию

//        WebElement close2 = driver.findElement(By.xpath("//button[@class='d-button deco-button deco-button-transparent d-button_rounded d-button_w-icon d-button_w-icon-centered fullscreen-popup__close js-close test-fullscreen-close']"));
//        close2.click();

        WebElement search = driver.findElement(By.xpath("//button[@class='d-button deco-button deco-button-flat d-button_type_flat d-button_w-icon d-button_w-icon-centered d-search__button']"));
        search.click();

        WebElement searchField = driver.findElement(By.xpath("//input[@class='d-input__field deco-input d-input__field_size-S deco-input_suggest']"));
        searchField.sendKeys("Liaze - 2003");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[@class='d-button deco-button deco-button-flat d-button_type_flat d-button_w-icon d-button_w-icon-centered suggest-button suggest-button_left']"));
        buttonSearch.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement firstSong = driver.findElement(By.xpath("//div[@class='serp-snippet__tracks']"));
        firstSong.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);

        WebElement favourite = driver.findElement(By.xpath("//div[@class='sidebar__controls']//span[@class='d-like']//button"));
        favourite.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);

        WebElement like = driver.findElement(By.xpath("//a[@data-name='my']"));
        like.click();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Thread.sleep(2000);
//
//        WebElement tracks = driver.findElement(By.xpath("//div[@data-tab-id='tracks']//a"));
//        tracks.click();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        WebElement dislike = driver.findElement(By.xpath("//div[@data-id='1']//button[@class='d-button deco-button deco-button-flat d-button_type_flat d-button_size_S d-button_w-icon d-button_w-icon-centered d-track__delete d-track__hover-hidden']"));
//        dislike.click();
//
//        driver.quit();

    }
}

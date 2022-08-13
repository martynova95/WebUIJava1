package com.geekbrains.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class TweekTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String TWEEK_BASE_URL = "https://tweek.so/ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(TWEEK_BASE_URL);
    }


    @Test

    void loginTweek() {
        driver.findElement(By.xpath("//button[text()='Войти']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gfdsa12345@yandex.ru");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//form//button[.='Войти']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='М']")));
        driver.findElement(By.xpath("//div[text()='М']")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//div[.='My calendar']")).isDisplayed(), true);
    }

    @Test
    void addCalendar() {
        driver.findElement(By.xpath("//button[text()='Войти']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gfdsa12345@yandex.ru");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//form//button[.='Войти']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='М']")));
        driver.findElement(By.xpath("//div[text()='М']")).click();
        driver.findElement(By.xpath("//span[text()='Новый календарь']")).click();

        String postTitle = "test" + new Random().nextInt(1000);
        driver.findElement(By.xpath("//input[@placeholder = 'Имя']")).sendKeys(postTitle);
        driver.findElement(By.xpath("//button[text()='Создать']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='T']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//div[text()='T']")).isDisplayed(), true);
    }

    @Test
    void dragAndDropNote() {
        driver.findElement(By.xpath("//button[text()='Войти']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gfdsa12345@yandex.ru");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//form//button[.='Войти']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='М']")));
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Сходить в магазин");
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
        actions.dragAndDrop(driver.findElement(By.xpath("//span[text()='Сходить в магазин']/parent::div")), driver.findElement(By.xpath("(//input[@type='text'])[2]")))
                .build()
                .perform();
        //Assertions.assertEquals(driver.findElement(By.xpath("//span[text()='Сходить в магазин']")).getText(), "Сходить в магазин");

    }
}

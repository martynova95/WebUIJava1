package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class TweekTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://tweek.so/ru");
        driver.findElement(By.xpath("//button[text()='Войти']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gfdsa12345@yandex.ru");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/form/div[4]/div[2]/button")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='М']")));
        driver.findElement(By.xpath("//div[text()='М']")).click();
        driver.findElement(By.xpath("//span[text()='Новый календарь']")).click();

        String postTitle = "test" + new Random().nextInt(1000);
        driver.findElement(By.xpath("//input[@placeholder = 'Имя']")).sendKeys(postTitle);
        driver.findElement(By.xpath("//button[text()='Создать']")).click();

        //не смогла найти куку для авторизации. Их там всего 4, попробовала все, ни одна не подошла.
//        driver.get("https://tweek.so/ru");
//        Cookie cookie = new Cookie("_gid", "GA1.2.1788718067.1659868045");
//
//        driver.manage().addCookie(cookie);
//        driver.navigate().refresh();
        String a = "";
        driver.quit();
    }
}

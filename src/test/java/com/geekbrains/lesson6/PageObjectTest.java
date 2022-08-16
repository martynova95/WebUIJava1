package com.geekbrains.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://tweek.so/ru");
    }

    @Test
    void loginTest() {
        new MainPage(driver).clickSingInButton()
                .login("gfdsa12345@yandex.ru", "123456")
                .clickProfileButton()
                .checkMyProfile();
    }

    @AfterEach
    void killBrowser() {
        driver.quit();
    }
}

package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement singInButton;

    public LoginPage clickSingInButton() {
        singInButton.click();
        return new LoginPage(driver);

    }
}

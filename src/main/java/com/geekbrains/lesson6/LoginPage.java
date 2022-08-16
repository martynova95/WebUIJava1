package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//form//button[.='Войти']")
    private WebElement singInButton;

    public MainMenuBlock login(String login, String password) {
        emailField.sendKeys(login);
        passwordField.sendKeys(password);
        singInButton.click();
        return new MainMenuBlock(driver);
    }
}

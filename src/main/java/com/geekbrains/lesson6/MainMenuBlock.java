package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainMenuBlock extends BasePage{

    public MainMenuBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='М']")
    private WebElement profileButton;

    public SuccessLogin clickProfileButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='М']")));
        profileButton.click();
        return new SuccessLogin(driver);
    }
}

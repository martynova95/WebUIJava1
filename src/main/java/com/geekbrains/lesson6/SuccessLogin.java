package com.geekbrains.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessLogin extends BasePage{

    public SuccessLogin(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[.='My calendar']")
    private WebElement myCalendar;

    public SuccessLogin checkMyProfile() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='My calendar']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//div[.='My calendar']")).isDisplayed(), true);
        return this;
    }
}

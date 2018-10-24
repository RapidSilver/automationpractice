package ru.kirill.automation.practice.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActions {
    WebDriver driver;
    WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void typeInField(By by, String msg) {
        WebElement element = driver.findElement(by);
        element.click();
        element.clear();
        element.sendKeys(msg);
    }

    public void selectElement(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}

package ru.kirill.automation.practice.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseActions {
    private static String HOME_PAGE_URL = "http://automationpractice.com/";
    private static By SIGN_IN_MENU = By.cssSelector("a.login");
    private static By LOGOUT_BTN = By.cssSelector("a.logout");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void home() {
        driver.get(HOME_PAGE_URL);
    }

    public void goToAuthPage() {
        driver.findElement(SIGN_IN_MENU).click();
    }

    public void logout() {
        driver.findElement(LOGOUT_BTN).click();
    }
}

package ru.kirill.automation.practice.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BaseActions {
    private static final By EMAIL_FIELD = By.cssSelector("#email");
    private static final By PASSWORD_FIELD = By.cssSelector("#passwd");
    private static final By SUBMIT_LOGIN_BTN = By.cssSelector("#SubmitLogin");

    private static final By ALERT_DANGER = By.cssSelector(".alert.alert-danger");
    private static final By ALERT_DANGER_CONTAINER_TEXT = By.cssSelector(".alert.alert-danger > ol > li");

    private static final By REGISTRATION_EMAIL_FIELD = By.cssSelector("#email_create");
    private static final By REGISTRATION_CREATE_BTN = By.cssSelector("#SubmitCreate");

    public AuthPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void fillSignInFormAndConfirm(String email, String password) {
        typeInField(EMAIL_FIELD, email);
        typeInField(PASSWORD_FIELD, password);
        driver.findElement(SUBMIT_LOGIN_BTN).click();
    }

    public boolean isAlertPresent() {
        return isElementPresent(ALERT_DANGER);
    }

    public String getAlertContainerText() {
        return driver.findElement(ALERT_DANGER_CONTAINER_TEXT).getText();
    }

    public void fillRegistrationEmailAndConfirm(String email) {
        typeInField(REGISTRATION_EMAIL_FIELD, email);
        driver.findElement(REGISTRATION_CREATE_BTN).click();
    }
}

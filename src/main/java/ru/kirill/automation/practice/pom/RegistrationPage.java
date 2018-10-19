package ru.kirill.automation.practice.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BaseActions {
    private static final By REGISTRATION_SUBMIT_BTN = By.cssSelector("#submitAccount");
    private static final By ALERT_DANGER = By.cssSelector(".alert.alert-danger");

    // Title
    private static final By GENDER_MALE_RBTN = By.cssSelector("#id_gender1");
    private static final By GENDER_FEMALE_RBTN = By.cssSelector("#id_gender2");
    private static final By FIELD_FIRST_NAME = By.cssSelector("#customer_firstname");
    private static final By FIELD_LAST_NAME = By.cssSelector("#customer_lastname");
    private static final By FIELD_EMAIL = By.cssSelector("#email");
    private static final By FIELD_PASSWORD = By.cssSelector("#passwd");
    private static final By SELECT_BIRTH_DAY = By.cssSelector("#days");
    private static final By SELECT_BIRTH_MONTH = By.cssSelector("#months");
    private static final By SELECT_BIRTH_YEAR = By.cssSelector("#years");
    private static final By CHECKBOX_NEWSLETTER = By.cssSelector("#newsletter");
    private static final By CHECKBOX_OFFERS = By.cssSelector("#optin");

    // Address
    private static final By FIELD_FIRST_NAME_ADDRESS = By.cssSelector("#firstname");
    private static final By FIELD_LAST_NAME_ADDRESS = By.cssSelector("#lastname");
    private static final By FIELD_COMPANY = By.cssSelector("#company");
    private static final By FIELD_ADDRESS_LINE_1 = By.cssSelector("#address1");
    private static final By FIELD_ADDRESS_LINE_2 = By.cssSelector("#address2");
    private static final By FIELD_CITY = By.cssSelector("#city");
    private static final By SELECT_STATE = By.cssSelector("#id_state");
    private static final By FIELD_POSTAL_CODE = By.cssSelector("#postcode");
    private static final By SELECT_COUTRY = By.cssSelector("#id_country");
    private static final By TEXT_AREA_ADD_INF = By.cssSelector("#other");
    private static final By FIELD_PHONE = By.cssSelector("#phone");
    private static final By FIELD_MOBILE_PHONE = By.cssSelector("#phone_mobile");
    private static final By FIELD_ALIAS = By.cssSelector("#alias");

    private static final String ALIAS = "My address";
    private static final String COUTRY = "21";

    public enum Gender {MALE, FEMALE}

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isAlertPresent() {
        return isElementPresent(ALERT_DANGER);
    }

    public void submitRegistration() {
        driver.findElement(REGISTRATION_SUBMIT_BTN).click();
    }

    public void selectGender(Gender gender) {
        if (gender == Gender.MALE) {
            driver.findElement(GENDER_MALE_RBTN).click();
        } else {
            driver.findElement(GENDER_FEMALE_RBTN).click();
        }
    }

    public void typePersonalInfo(Gender gender,
                                 String firstName,
                                 String lastName,
                                 String email,
                                 String password,
                                 String birthDay,
                                 String birthMonth,
                                 String birthYear,
                                 Boolean newsletter,
                                 Boolean offers,
                                 String company,
                                 String addressLine1,
                                 String addressLine2,
                                 String city,
                                 String state,
                                 String postalCode,
                                 String information,
                                 String phone,
                                 String mobilePhone) {
        selectGender(gender);
        typeInField(FIELD_FIRST_NAME, firstName);
        typeInField(FIELD_LAST_NAME, lastName);
        typeInField(FIELD_EMAIL, email);
        typeInField(FIELD_PASSWORD, password);
        selectElement(SELECT_BIRTH_DAY, birthDay);
        selectElement(SELECT_BIRTH_MONTH, birthMonth);
        selectElement(SELECT_BIRTH_YEAR, birthYear);
        if (newsletter) driver.findElement(CHECKBOX_NEWSLETTER).click();
        if (offers) driver.findElement(CHECKBOX_OFFERS).click();
        typeInField(FIELD_FIRST_NAME_ADDRESS, firstName);
        typeInField(FIELD_LAST_NAME_ADDRESS, lastName);
        typeInField(FIELD_COMPANY, company);
        typeInField(FIELD_ADDRESS_LINE_1, addressLine1);
        typeInField(FIELD_ADDRESS_LINE_2, addressLine2);
        typeInField(FIELD_ADDRESS_LINE_2, addressLine2);
        typeInField(FIELD_CITY, city);
        selectElement(SELECT_STATE, state);
        typeInField(FIELD_POSTAL_CODE, postalCode);
        selectElement(SELECT_COUTRY, COUTRY);
        typeInField(TEXT_AREA_ADD_INF, information);
        typeInField(FIELD_PHONE, phone);
        typeInField(FIELD_MOBILE_PHONE, mobilePhone);
        typeInField(FIELD_ALIAS, ALIAS);
    }
}

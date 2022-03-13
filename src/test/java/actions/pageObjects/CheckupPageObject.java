package actions.pageObjects;

import actions.commons.BasePage;
import actions.commons.PageGenerateManager;
import interfaces.pageUIs.CheckupPageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CheckupPageObject extends BasePage {
    WebDriver driver;

    public CheckupPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToDynamicFieldInput(String fieldName, String enterValue) {
        waitForElementVisible(driver, CheckupPageUI.DYNAMIC_FIELD_NAME, fieldName);
        sendKeyToElement(driver, CheckupPageUI.DYNAMIC_FIELD_NAME, enterValue, fieldName);
    }

    public void selectOptionFromDropDown(String fieldName) {
        pressKeyToElement(driver, CheckupPageUI.DYNAMIC_FIELD_NAME, Keys.ARROW_DOWN, fieldName);
        pressKeyToElement(driver, CheckupPageUI.DYNAMIC_FIELD_NAME, Keys.ENTER, fieldName);
    }

    public ResultsPageObject clickToCompareNowButton() {
        waitForElementClickable(driver, CheckupPageUI.COMPARE_NOW_BUTTON);
        clickToElement(driver, CheckupPageUI.COMPARE_NOW_BUTTON);
        return PageGenerateManager.getResultsPage(driver);
    }
}

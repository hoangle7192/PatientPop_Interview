package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUIs.ResultsPageUI;
import org.openqa.selenium.WebDriver;

public class ResultsPageObject extends BasePage {
    WebDriver driver;

    public ResultsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getCompetitorsSectionScore() {
        waitForElementVisible(driver, ResultsPageUI.COMPETITORS_SECTION_SCORE);
        return getElementText(driver, ResultsPageUI.COMPETITORS_SECTION_SCORE);
    }

    public String getDynamicSectionScore(String sectionName) {
        waitForElementVisible(driver, ResultsPageUI.DYNAMIC_SECTION_SCORE, sectionName);
        return getElementText(driver, ResultsPageUI.DYNAMIC_SECTION_SCORE, sectionName);
    }

    public void clickToCompetitorsNextButton() {
        waitForElementClickable(driver, ResultsPageUI.COMPETITORS_NEXT_BUTTON);
        clickToElement(driver, ResultsPageUI.COMPETITORS_NEXT_BUTTON);
    }

    public void clickToDynamicNextButton(String sectionName) {
        waitForElementClickable(driver, ResultsPageUI.DYNAMIC_NEXT_BUTTON, sectionName);
        clickToElement(driver, ResultsPageUI.DYNAMIC_NEXT_BUTTON, sectionName);
    }

    public String getDynamicOverallSectionScore(String sectionName) {
        waitForElementVisible(driver, ResultsPageUI.DYNAMIC_OVERALL_SECTION_SCORE, sectionName);
        return getElementText(driver, ResultsPageUI.DYNAMIC_OVERALL_SECTION_SCORE, sectionName);
    }

    public String getOverallWebsiteScore() {
        waitForElementVisible(driver, ResultsPageUI.OVERALL_WEBSITE_SCORE);
        return getElementText(driver, ResultsPageUI.OVERALL_WEBSITE_SCORE);
    }
}

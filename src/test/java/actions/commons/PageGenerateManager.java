package actions.commons;

import actions.pageObjects.CheckupPageObject;
import actions.pageObjects.ResultsPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerateManager {

    public static CheckupPageObject getCheckupPage(WebDriver driver) {
        return new CheckupPageObject(driver);
    }
    public static ResultsPageObject getResultsPage(WebDriver driver) {
        return new ResultsPageObject(driver);
    }
}

package testcase;

import actions.commons.BaseTest;
import actions.commons.PageGenerateManager;
import actions.pageObjects.CheckupPageObject;
import actions.pageObjects.ResultsPageObject;
import actions.reportConfigs.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class PatientPop_Automate extends BaseTest {
    WebDriver driver;
    CheckupPageObject checkupPage;
    ResultsPageObject resultsPage;

    String practiceName, specialty;
    String competitorsScore, googleRankScore, webPresenceScore, webScore, reputationScore;

    @Parameters({"browser", "env"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName, environmentName);
        checkupPage = PageGenerateManager.getCheckupPage(driver);
    }

    @Test
    public void Section_A1(Method method) {
        practiceName = "Shamsah Amersi";
        specialty = "Obstetrician and Gynecologist (OBGYN)";

        ExtentTestManager.startTest(method.getName(), "Section_A1");

        ExtentTestManager.getTest().log(Status.INFO, "Step01: Enter To PracticeName TextBox");
        checkupPage.enterToDynamicFieldInput("practicename", practiceName);
        checkupPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Step02: Select Option From DropDown Of PracticeName");
        checkupPage.selectOptionFromDropDown("practicename");

        /* Requirement 3: Verify that the fields are auto populated after selecting: TODO*/

        ExtentTestManager.getTest().log(Status.INFO, "Step03: Select Value Of Specialty DropDown");
        checkupPage.enterToDynamicFieldInput("specialty", specialty);
        checkupPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO, "Step04: Select Option From DropDown Of Specialty");
        checkupPage.selectOptionFromDropDown("specialty");

        ExtentTestManager.getTest().log(Status.INFO, "Step05: Click To CompareNow Button");
        resultsPage = checkupPage.clickToCompareNowButton();

        /* Requirement 5: After the page is done loading, familiarize yourself with the different sections of the page: TODO*/

        ExtentTestManager.getTest().log(Status.INFO, "Step06: Get Competitors Section Score");
        competitorsScore = resultsPage.getCompetitorsSectionScore();
        System.out.println(competitorsScore);

        ExtentTestManager.getTest().log(Status.INFO, "Step07: Click To Next Button");
        resultsPage.clickToCompetitorsNextButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step08: Get Google rank Section Score");
        googleRankScore = resultsPage.getDynamicSectionScore("Google rank");

        ExtentTestManager.getTest().log(Status.INFO, "Step09: Click To Next Button");
        resultsPage.clickToDynamicNextButton("Google rank");

        ExtentTestManager.getTest().log(Status.INFO, "Step10: Get Web presence Section Score");
        webPresenceScore = resultsPage.getDynamicSectionScore("Web presence");

        ExtentTestManager.getTest().log(Status.INFO, "Step11: Click To Next Button");
        resultsPage.clickToDynamicNextButton("Web presence");

        ExtentTestManager.getTest().log(Status.INFO, "Step12: Get Website Section Score");
        webScore = resultsPage.getDynamicSectionScore("Website");

        ExtentTestManager.getTest().log(Status.INFO, "Step13: Click To Next Button");
        resultsPage.clickToDynamicNextButton("Website");

        ExtentTestManager.getTest().log(Status.INFO, "Step14: Get Reputation Score");
        reputationScore = resultsPage.getDynamicSectionScore("Reputation");

        ExtentTestManager.getTest().log(Status.INFO, "Step15: Click To Next Button");
        resultsPage.clickToDynamicNextButton("Reputation");

        ExtentTestManager.getTest().log(Status.INFO, "Step16: Verify GoogleRank Section Score With Score Display At Overall");
        Assert.assertEquals(resultsPage.getDynamicOverallSectionScore("google_rank"), googleRankScore);

        ExtentTestManager.getTest().log(Status.INFO, "Step17: Verify WebPresence Section Score With Score Display At Overall");
        Assert.assertEquals(resultsPage.getDynamicOverallSectionScore("website_presence"), webPresenceScore);

        ExtentTestManager.getTest().log(Status.INFO, "Step18: Verify WebSite Section Score With Score Display At Overall");
        Assert.assertEquals(resultsPage.getOverallWebsiteScore(), webScore);

        ExtentTestManager.getTest().log(Status.INFO, "Step19: Verify Reputation Section Score With Score Display At Overall");
        Assert.assertEquals(resultsPage.getDynamicOverallSectionScore("reputation"), reputationScore);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitDriver();
    }
}

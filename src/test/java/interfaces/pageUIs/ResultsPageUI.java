package interfaces.pageUIs;

public class ResultsPageUI {
    public static final String COMPETITORS_SECTION_SCORE = "xpath=//h2[contains(.,'Competitors')]/ancestor::section[contains(@class,'hero-overall')]//li[@class='row your-practice']//*[name()='svg']//*[name()='text' and contains(@class,'score-value')]";
    public static final String DYNAMIC_SECTION_SCORE = "xpath=//h2[contains(.,'%s')]/ancestor::section[contains(@class,'hide-print')]//li[@class='row your-practice']//*[name()='svg']//*[name()='text' and contains(@class,'score-value')]";
    public static final String COMPETITORS_NEXT_BUTTON = "xpath=//h2[contains(.,'Competitors')]/ancestor::section[contains(@class,'result overall')]//span[contains(.,'Next')]";
    public static final String DYNAMIC_NEXT_BUTTON = "xpath=//h2[contains(.,'%s')]/ancestor::section[contains(@class,'hide-print')]//span[contains(.,'Next')]";
    public static final String DYNAMIC_OVERALL_SECTION_SCORE = "xpath=//div[@class='summary-desktop']/child::div[contains(@class,'%s')]/child::div[@class='score-item-value']//*[name()='svg']//*[name()='text' and contains(@class,'score-value')]";
    public static final String OVERALL_WEBSITE_SCORE = "xpath=//div[@class='summary-desktop']/child::div[@class='score-item summary-website']/child::div[@class='score-item-value']//*[name()='svg']//*[name()='text' and contains(@class,'score-value')]";
}

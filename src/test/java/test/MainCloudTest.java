package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CloudGooglePage;
import pages.GoogleCloudPlatformPricingCalculatorPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MainCloudTest {
    private static final String SEARCH_PHRASE = "Google Cloud Platform Pricing Calculator";

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserRun() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test(description = "Open google cloud page")
    public void scenarioWithGoogleCloudTest() {
        new CloudGooglePage(this.driver)
                .openPage("https://cloud.google.com/")
                .typeInSearch(SEARCH_PHRASE)
                .clickInSearchResult()
                .clickOnEqualByText(SEARCH_PHRASE)
        ;
    }

    @Test(description = "Open google cloud pricing calculator page")
    public void scenarioWithGoogleCloudCalculatorTest() {
        new GoogleCloudPlatformPricingCalculatorPage(driver)
                .openPage("https://cloud.google.com/products/calculator");
    }


    @Test(description = "try ope tab")
    public void scenarioWithOpeningTab() throws IOException, UnsupportedFlavorException {
        new CloudGooglePage(this.driver)
                .openPage("https://cloud.google.com/")
                .openNewTab("https://temp-mail.org/ru/")
                .getTempMAilAddress();
    }

    @Test(description = "try open tab")
    public void scenarioWithOpeningTabTenMinutesMAil() throws IOException, UnsupportedFlavorException {
        new CloudGooglePage(this.driver)
                .openPage("https://cloud.google.com/")
                .openNewTabTenMinutes("https://10minutemail.com/")
                .copyFieldWithEmail();
    }

    @Test(description = "try open new tab")
    public void scenarioWithOpeningTabTempMail() throws InterruptedException {
        new CloudGooglePage(this.driver)
                .openPage("https://cloud.google.com/")
                .openNewTabTempMailOrgTest("https://temp-mail.org/")
                .getAddress();
    }
 /*   @AfterMethod(alwaysRun = true)
    public void afterTestCompleted() {
        driver.quit();
        driver = null;
    }*/
}

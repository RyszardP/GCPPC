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
import org.testng.ITestResult;

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
    public void scenarioWithGoogleCloudTest() throws InterruptedException {
        new CloudGooglePage(this.driver)
                .openPage("https://cloud.google.com/")
                .typeInSearch(SEARCH_PHRASE)
                .clickInSearchResult()
                .clickOnEqualByText(SEARCH_PHRASE)
                //   .clickOnComputeEngine()
                .typeNumberOfInstances(4)
                .selectOSSoftware();
    }

    @Test(description = "Open google cloud pricing calculator page")
    public void scenarioWithGoogleCloudCalculatorTest() {
        new GoogleCloudPlatformPricingCalculatorPage(driver)
                .openPage("https://cloud.google.com/products/calculator")
                .selectComputeEngine()
                .typeNumberOfInstances(4)
                .selectOSSoftware()
                .selectMachineClass()
                .selectSeries()
                .selectInstance()
                .selectCheckBoxGPU(1, "NVIDIA Tesla V100")
                .selectSSD("1x375 GB")
                .selectLocation("Frankfurt (europe-west3)")
                .selectCommittedUsage("1 Year")
                .clickAddToEstimate()

        ;
    }


    @Test(description = "try open tab")
    public void scenarioWithOpeningTab() throws IOException, UnsupportedFlavorException {
        new GoogleCloudPlatformPricingCalculatorPage(this.driver)
                .openPage("https://cloud.google.com/products/calculator")
                .selectComputeEngine()
                .typeNumberOfInstances(4)
                .selectCommittedUsage("1 Year")
             .clickAddToEstimate()
        ;
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

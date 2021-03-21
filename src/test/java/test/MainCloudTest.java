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
import pages.TempMailOrgPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MainCloudTest {
    private static final String SEARCH_PHRASE = "Google Cloud Platform Pricing Calculator";
    private static final int NUMBER_OF_INSTANCES = 4;
    private static final String OPERATING_SYSTEM = "Free";
    private static final String MACHINE_ClASS = "Regular";
    private static final String SERIES = "N1";
    private static final String INSTANCE_TYPE = "n1-standard-8";
    private static final int NUMBER_OF_GPU = 1;
    private static final String GPU_TYPE = "NVIDIA Tesla V100";
    private static final String SSD = "1x375 GB";
    private static final String LOCATION = "Frankfurt (europe-west3)";
    private static final String COMMITTED_USAGE = "1 Year";
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserRun() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test(description = "Open google cloud page")
    public void scenarioWithGoogleCloudTest() {
        GoogleCloudPlatformPricingCalculatorPage cloudGooglePage = new CloudGooglePage(driver)
                .openPage("https://cloud.google.com/")
                .typeInSearch(SEARCH_PHRASE)
                .clickInSearchResult()
                .clickOnEqualByText(SEARCH_PHRASE)
                .selectComputeEngine()
                .typeNumberOfInstances(NUMBER_OF_INSTANCES)
                .selectOSSoftware(OPERATING_SYSTEM)
                .selectMachineClass(MACHINE_ClASS)
                .selectSeries(SERIES)
                .selectInstance(INSTANCE_TYPE)
                .selectCheckBoxGPU(NUMBER_OF_GPU, GPU_TYPE)
                .selectSSD(SSD)
                .selectLocation(LOCATION)
                .selectCommittedUsage(COMMITTED_USAGE)
                .clickAddToEstimate()
                .createNewTab()
                .switchTab();

        TempMailOrgPage tempMailOrgPage = new TempMailOrgPage(driver)
                .openPage("https://temp-mail.org/")
                .getAddress()
                .switchTabToCalculate();
    }

    @Test(description = "Open google cloud pricing calculator page")
    public void scenarioWithGoogleCloudCalculatorTest() {
        GoogleCloudPlatformPricingCalculatorPage cloudGooglePage = new GoogleCloudPlatformPricingCalculatorPage(driver)
                .openPage("https://cloud.google.com/products/calculator")
                .selectComputeEngine()
                .typeNumberOfInstances(NUMBER_OF_INSTANCES)
                .selectOSSoftware(OPERATING_SYSTEM)
                .selectMachineClass(MACHINE_ClASS)
                .selectSeries(SERIES)
                .selectInstance(INSTANCE_TYPE)
                .selectCheckBoxGPU(NUMBER_OF_GPU, GPU_TYPE)
                .selectSSD(SSD)
                .selectLocation(LOCATION)
                .selectCommittedUsage(COMMITTED_USAGE)
                .clickAddToEstimate()
                .createNewTab()
                .switchTab()

                ;


        TempMailOrgPage tempMailOrgPage = new TempMailOrgPage(driver)
                .openPage("https://temp-mail.org/")
                .getAddress()
                .switchTabToCalculate();

        cloudGooglePage
                .switchToFrameCalculator()
                .emailEstimate()
                .sendEmail()
                .switchTab();

        tempMailOrgPage
                .clickToMailWithSubject("Google Cloud Platform Price Estimate");


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


/*  @AfterMethod(alwaysRun = true)
    public void afterTestCompleted() {
        driver.quit();
        driver = null;
    }*/


}

package pages;

import model.CalculationPageModel;
import model.TenMinutesPageModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GoogleCloudPlatformPricingCalculatorPage extends AbstractPage {

    public static ArrayList<String> tabs;
    public static Double estimatedMonthlyCostInGoogleCalculator;
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//div[@title='Compute Engine' and @class='hexagon']/../../..")
    WebElement computeEngineButton;

    @FindBy(xpath = "//div[@title='Compute Engine']/parent::*[@role='tab']")
    WebElement computeEngineSectionParent;

    @FindBy(xpath = "//div[@title='Cloud Storage' and @class='hexagon']/../../..")
    WebElement cloudStorageButton;

    @FindBy(xpath = "//label[text()='Number of instances']")
    WebElement gKESection;

    @FindBy(xpath = "//input[contains(@ng-model, 'quantity')]")
    WebElement numberOfInstancesField;

    @FindBy(xpath = "//md-select-value/span/div[contains(text(),'Free')]/../../..")
    WebElement operatingSystemDropMenu;

    @FindBy(xpath = "//md-select-value/span/div[contains(text(),'Regular')]/../../..")
    WebElement vMClassDropDownMenu;

    @FindBy(xpath = "//*[contains(text(),'Series')]/following-sibling::md-select")
    WebElement seriesDropDownMenu;

    @FindBy(xpath = "//*[contains(text(),'Machine type')]/following-sibling::md-select")
    WebElement instanceTypeDropDown;


    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div[8]/div/md-input-container/md-checkbox")
    WebElement addGpuCheckBox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    WebElement gpuQuantityDropDown;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    WebElement gpuTypeDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    WebElement localSSDDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location' and contains(@ng-model,'computeServer')]")
    WebElement locationDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage' and contains(@ng-change,'onCudChange')]")
    WebElement committedUsageDropDown;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate'] [not(contains(@disabled,'disabled'))]")
    WebElement addToEstimateButton;

    @FindBy(xpath = "//button[@aria-label='Email Estimate'] [not(contains(@disabled,'disabled'))]")
    WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailFieldInEstimate;

    @FindBy(xpath = "//button[@aria-label='Send Email'] [not(contains(@disabled,'disabled'))]")
    WebElement sendEmailButtonInEstimate;

    @FindBy(xpath = "//b[contains(@class,'ng-binding')and contains(text(),'Total')]")
    WebElement totalEstimatedCostInCalculator;

    @FindBy(xpath = "//iframe")
    private WebElement frame;


    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudPlatformPricingCalculatorPage openPage() {
        driver.get(PAGE_URL);
        logger.info("Calculator page opened");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectComputeEngine() {
        new WebDriverWait(driver, 10).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 10);
        driver.switchTo().frame(0);
        while (computeEngineButton.getAttribute("aria-selected").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(computeEngineButton))
                    .click();
        }
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickOnCloudStorage() {
        new WebDriverWait(driver, 10).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 10);
        driver.switchTo().frame(0);
        while (cloudStorageButton.getAttribute("aria-selected").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(cloudStorageButton))
                    .click();
        }
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage typeNumberOfInstances(Integer quantity) {
        numberOfInstancesField.sendKeys(quantity.toString());
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage typeNumberOfInstancesWithUtil(CalculationPageModel pageModel) {
        numberOfInstancesField.sendKeys(pageModel.getNumberOfInstances());
        logger.info("Type instances number");
        return this;
    }


    public GoogleCloudPlatformPricingCalculatorPage selectOSSoftware(String oS) {
        while (operatingSystemDropMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(visibilityOf(operatingSystemDropMenu))
                    .click();
        }
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + oS + "')]/..")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectOSSoftwareWithUtil(CalculationPageModel pageModel) {
        while (operatingSystemDropMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(visibilityOf(operatingSystemDropMenu))
                    .click();
        }
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + pageModel.getOperationSystem() + "')]/..")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectMachineClass(String machineClass) {
        while (vMClassDropDownMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(vMClassDropDownMenu))
                    .click();
        }
        driver.findElement(By.xpath("//div[contains(@class,'md-active')]//md-option[contains(.,'"
                + machineClass + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectMachineClassWithUtil(CalculationPageModel pageModel) {
        while (vMClassDropDownMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(vMClassDropDownMenu))
                    .click();
        }
        driver.findElement(By.xpath("//div[contains(@class,'md-active')]//md-option[contains(.,'"
                + pageModel.getMachineClass() + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectSeries(String series) {
        while (seriesDropDownMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(seriesDropDownMenu))
                    .click();
        }
        driver.findElement(By.xpath("//div[contains(@class, 'md-active')]//md-option[contains(.,'" + series + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectSeriesWithUtil(CalculationPageModel pageModel) {
        while (seriesDropDownMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(seriesDropDownMenu))
                    .click();
        }
        driver.findElement(By.xpath("//div[contains(@class, 'md-active')]//md-option[contains(.,'" +
                pageModel.getSeries() + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectInstance(String typeOfMachine) {
        while (instanceTypeDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(visibilityOf(instanceTypeDropDown))
                    .click();
        }
        driver.findElement(By.xpath("//div[contains(@class, 'md-active')]//md-option[contains(.,'" +
                typeOfMachine + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectInstanceWithUtil(CalculationPageModel pageModel) {
        while (instanceTypeDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(visibilityOf(instanceTypeDropDown))
                    .click();
        }
        driver.findElement(By.xpath("//div[contains(@class, 'md-active')]//md-option[contains(.,'" +
                pageModel.getInstanceType() + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectCheckBoxGPU(Integer numberOfGPUs, String gpuType) {
        if (addGpuCheckBox.getAttribute("aria-disabled").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(visibilityOf(addGpuCheckBox))
                    .click();
        }
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(gpuQuantityDropDown)).click();

        driver.findElement(By.xpath("//md-option[contains(@ng-disabled, " +
                "'GPU')]/div[contains(text(),'" + numberOfGPUs + "')]")).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(gpuTypeDropDown)).click();
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + gpuType + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectCheckBoxGPUWithUtil(CalculationPageModel pageModel) {
        if (addGpuCheckBox.getAttribute("aria-disabled").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(visibilityOf(addGpuCheckBox))
                    .click();
        }
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(gpuQuantityDropDown)).click();
        driver.findElement(By.xpath("//md-option[contains(@ng-disabled, " +
                "'GPU')]/div[contains(text(),'" + pageModel.getNumberOfGPU() + "')]")).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(gpuTypeDropDown)).click();
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + pageModel.getGpuType() + "')]")).click();
        return this;
    }


    public GoogleCloudPlatformPricingCalculatorPage selectSSD(String localSSD) {
        while (localSSDDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(localSSDDropDown))
                    .click();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", localSSDDropDown);
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + localSSD + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectSSDWithUtil(CalculationPageModel pageModel) {
        while (localSSDDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(localSSDDropDown))
                    .click();
        }
     //   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", localSSDDropDown);
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + pageModel.getSsd() + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectLocation(String location) {
        while (locationDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            locationDropDown.click();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationDropDown);
        driver.findElement(By.xpath("//div[@aria-hidden = 'false']//div[contains(text(),'" +
                location + "')]"))
                .click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectLocationWithUtil(CalculationPageModel pageModel) {
        while (locationDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            locationDropDown.click();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationDropDown);
        driver.findElement(By.xpath("//div[@aria-hidden = 'false']//div[contains(text(),'" +
                pageModel.getLocation() + "')]"))
                .click();
        return this;
    }


    public GoogleCloudPlatformPricingCalculatorPage selectCommittedUsage(String usage) {
        while (committedUsageDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(committedUsageDropDown))
                    .click();
        }
        driver.findElement(By.xpath("//div[contains(@class,'md-active')]//div[contains(text(), '" + usage + "')]")).click();
        return this;
    }


    public GoogleCloudPlatformPricingCalculatorPage selectCommittedUsageWithUtil(CalculationPageModel pageModel) {
        while (committedUsageDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(visibilityOf(committedUsageDropDown))
                    .click();
        }
        driver.findElement(By.xpath("//div[contains(@class,'md-active')]//div[contains(text(), '" +
                pageModel.getCommittedUsage() + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickAddToEstimate() {
        addToEstimateButton.submit();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage switchTab() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage switchToFrameCalculator() {
        new WebDriverWait(driver, 10).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 15);
        driver.switchTo().frame(0);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickToEmailEstimate() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage sendEmail() {
        new WebDriverWait(driver, 15).until(visibilityOf(
                emailFieldInEstimate)).sendKeys(TempMailOrgPage.emailAddress);

        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(sendEmailButtonInEstimate)).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage sendTenMinutesEmail(TenMinutesPageModel pageModel) {
        new WebDriverWait(driver, 15).until(visibilityOf(
                emailFieldInEstimate)).sendKeys(pageModel.getEmailAddress());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationDropDown);
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(sendEmailButtonInEstimate)).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage getEstimatedCost() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions
                        .textMatches(By.xpath("//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]"),
                                Pattern.compile("USD")));
        String string = totalEstimatedCostInCalculator
                .getText()
                .replace("1 month", "")
                .replaceAll("[^0-9.]", "");
        estimatedMonthlyCostInGoogleCalculator = Double.parseDouble(string);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage getEstimatedCostString() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(totalEstimatedCostInCalculator));
        return this;
    }
}

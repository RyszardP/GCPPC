package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class GoogleCloudPlatformPricingCalculatorPage extends AbstractPage {

    public static ArrayList<String> tabs;


    @FindBy(xpath = "//div[@title='Compute Engine' and @class='hexagon']/../../..")
    WebElement computeEngineButton;

    @FindBy(xpath = "//div[@title='Compute Engine']/parent::*[@role='tab']")
    WebElement computeEngineSectionParent;

    @FindBy(xpath = "//div[@title='Cloud Storage' and @class='hexagon']/../../..")
    WebElement cloudStorageButton;

    @FindBy(xpath = "//label[text()='Number of instances']")
    WebElement gKESection;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    WebElement mainIframe;

    @FindBy(xpath = "//input[contains(@ng-model,'listingCtrl.computeServer.quantity')]")
    WebElement numberOfInstancesField;

    @FindBy(xpath = "//md-select-value/span/div[contains(text(),'Free')]/../../..")
    WebElement operatingSystemDropMenu;

    @FindBy(xpath = "//md-option/div[contains(text(),'Free')]")
    WebElement operatingFreeInSystemDropMenu;

    @FindBy(xpath = "//md-select-value/span/div[contains(text(),'Regular')]/../../..")
    WebElement vMClassDropDownMenu;

    @FindBy(xpath = "//md-option[@id='select_option_80'and @value='regular']")
    WebElement regularFieldInDropDownMenu;

    @FindBy(xpath = "//*[contains(text(),'Series')]/following-sibling::md-select")
    WebElement seriesDropDownMenu;

    @FindBy(xpath = "//md-option[@id='select_option_190']")
    WebElement seriesN1InDropDownMenu;

    @FindBy(xpath = "//*[contains(text(),'Machine type')]/following-sibling::md-select")
    WebElement instanceTypeDropDown;

    @FindBy(xpath = "//md-option[@id='select_option_362']")
    WebElement instanceTypeInDropDownMenu;

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

    @FindBy(xpath = "//md-select[@placeholder='Committed usage'  and contains(@ng-change,'onCudChange')]")
    WebElement committedUsageDropDown;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate'] [not(contains(@disabled,'disabled'))]")
    WebElement addToEstimateButton;


    @FindBy(xpath = "//iframe")
    private WebElement frame;


    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudPlatformPricingCalculatorPage openPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectComputeEngine() {
        new WebDriverWait(driver, 10).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 10);
        driver.switchTo().frame(0);
        while (computeEngineButton.getAttribute("aria-selected").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(computeEngineButton))
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
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(cloudStorageButton))
                    .click();
        }
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage typeNumberOfInstances(Integer quantity) {
        numberOfInstancesField.sendKeys(quantity.toString());
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectOSSoftware() {
        while (operatingSystemDropMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(operatingSystemDropMenu))
                    .click();
        }
        operatingFreeInSystemDropMenu.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectMachineClass() {
        while (vMClassDropDownMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(vMClassDropDownMenu))
                    .click();
        }
        regularFieldInDropDownMenu.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectSeries() {
        while (seriesDropDownMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(seriesDropDownMenu))
                    .click();
        }
        seriesN1InDropDownMenu.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectInstance() {
        while (instanceTypeDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(instanceTypeDropDown))
                    .click();
        }
        instanceTypeInDropDownMenu.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectCheckBoxGPU(Integer numberOfGPUs, String gpuType) {
        if (addGpuCheckBox.getAttribute("aria-disabled").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(addGpuCheckBox))
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


    public GoogleCloudPlatformPricingCalculatorPage selectSSD(String localSSD) {
        while (localSSDDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(localSSDDropDown))
                    .click();
        }
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + localSSD + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectLocation(String location) {
        while (locationDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(locationDropDown))
                    .click();
        }
        driver.findElement(By.xpath("//div[@aria-hidden = 'false']//div[contains(text(),'" + location + "')]/.."))
                .click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectCommittedUsage(String usage) {
        while (committedUsageDropDown.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            committedUsageDropDown.click();
        }
        driver.findElement(By.xpath("//div[contains(@class,'md-active')]//div[contains(text(), '" + usage + "')]")).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickAddToEstimate() {
        addToEstimateButton.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage switchTab(){
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

}

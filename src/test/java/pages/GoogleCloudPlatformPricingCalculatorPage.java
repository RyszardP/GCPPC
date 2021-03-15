package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class GoogleCloudPlatformPricingCalculatorPage extends AbstractPage {

    public static ArrayList<String> tabs;

    private final String FRAME_XPATH = "/html/body/section/section/main/devsite-content/article/div[2]/article/devsite-iframe/iframe";

    @FindBy(xpath = "//div[text()='Compute Engine']")
    WebElement computeEngineSection;

    @FindBy(xpath = "//div[@title='Compute Engine']/parent::*[@role='tab']")
    WebElement computeEngineSectionParent;

    @FindBy(xpath = "//label[text()='Number of instances']")
    WebElement gKESection;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    WebElement mainIframe;

    @FindBy(xpath = "//input[@id='input_65']")
    WebElement numberOfInstancesField;


    ////form[@name='ComputeEngineForm']//following-sibling::*[3]
    //*md-tab-item[@class='md-tab ng-scope ng-isolate-scope md-ink-ripple md-active']

    //div[@title='Compute Engine']/following-sibling::*md-tab-item[@class='md-tab ng-scope ng-isolate-scope md-ink-ripple md-active']


    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPlatformPricingCalculatorPage openPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickOnComputeEngine() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(FRAME_XPATH)));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(gKESection)).click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage typeNumberOfInstances(Integer quantity){
        driver.switchTo().frame(0);
        numberOfInstancesField.sendKeys(quantity.toString());
        return this;

    }


}

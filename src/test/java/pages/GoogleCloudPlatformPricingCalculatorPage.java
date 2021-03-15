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

    private final String FRAME_XPATH = "/html/body/section/section/main/devsite-content/article/div[2]/article/devsite-iframe/iframe";

    @FindBy(xpath = "//div[@title='Compute Engine' and @class='hexagon']")
    WebElement computeEngineSection;

    @FindBy(xpath = "//div[@title='Compute Engine']/parent::*[@role='tab']")
    WebElement computeEngineSectionParent;

    @FindBy(xpath = "//label[text()='Number of instances']")
    WebElement gKESection;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    WebElement mainIframe;

    @FindBy(xpath = "//input[contains(@ng-model,'listingCtrl.computeServer.quantity')]")
    WebElement numberOfInstancesField;

    @FindBy(xpath = "//md-select-value/span/div[contains(text(),'Free')]/../../..")
    WebElement operatingSystemDropMenu;

    @FindBy(xpath = "//div[@class='md-text' and contains (text(),'Free')]")
    WebElement operatingSystemDropMenuFirstItem;

    @FindBy(xpath = "//input[@id='input-0']")
    WebElement searchField;

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

    public GoogleCloudPlatformPricingCalculatorPage clickOnComputeEngine() {
        new WebDriverWait(driver, 10).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        computeEngineSection.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage typeNumberOfInstances(Integer quantity) {
        new WebDriverWait(driver, 10).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 10);
        driver.switchTo().frame(0);
        numberOfInstancesField.sendKeys(quantity.toString());
        return this;
    }

   public GoogleCloudPlatformPricingCalculatorPage selectOSSoftware(){
       while (operatingSystemDropMenu.getAttribute("aria-expanded" ).equalsIgnoreCase("false")){
           new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(operatingSystemDropMenu))
                   .click();
       }
       webElementWaitToBeClickableAndClick(operatingSystemDropMenuFirstItem);
     //   operatingSystemDropMenuFirstItem.click();
        return this;
    }



    public GoogleCloudPlatformPricingCalculatorPage typeToSearch(String text) {
        new WebDriverWait(driver, 10).until(elementToBeClickable(frame));
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 10);
        driver.switchTo().frame(0);
        searchField.sendKeys(text);
        return this;
    }

    protected void webElementWaitToBeClickableAndClick(WebElement clickableWebElement) {
        new WebDriverWait(driver, 15)
                .until(elementToBeClickable(clickableWebElement)).click();
    }

}

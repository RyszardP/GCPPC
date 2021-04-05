package pages;

import components.SearchResultItem;
import components.SearchResultItemComponent;
import model.GoogleCloudPageModel;
import model.SearchResultPageModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL = "https://cloud.google.com/s/results?q";
    static final String XPATH_TO_LINK = "//a[@class='gs-title']";

    private List<WebElement> findElements(By bySelector) {
        return driver.findElements(bySelector);
    }

    @FindBy(xpath = "//div[@class='gs-title']")
    private WebElement foundResultsLocator;

    @FindBy(xpath = "//div[@class='gsc-webResult gsc-result']")
    private WebElement searchResultItem;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchResultPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Search page opened");
        return this;
    }

    public SearchResultPage getFirstResult(SearchResultPageModel resultPageModel) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable((WebElement) foundResultsLocator));
        List<WebElement> findElements = driver.findElements(By.xpath(XPATH_TO_LINK));
        logger.info("Search performed");
        return new SearchResultPage(driver);
    }

    public GoogleCloudPlatformPricingCalculatorPage clickOnEqualByText(String text) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(foundResultsLocator));
        List<WebElement> findElements = driver.findElements(By.xpath(XPATH_TO_LINK));

        for (int i = 0; i < findElements.size(); i++) {
            if (findElements.get(i).getText().contains(text)) {
                findElements.get(i).click();
                break;
            }
        }
        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }

    public GoogleCloudPlatformPricingCalculatorPage clickOnFirstResult() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='gs-title'][1]")));
        WebElement findElement = driver.findElement(By.xpath("//a[@class='gs-title'][1]"));
        findElement.click();
        logger.info("first result");
        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }
}

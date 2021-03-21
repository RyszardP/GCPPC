package pages;

import components.SearchResultItem;
import components.SearchResultItemComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {

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


    public SearchResultPage openPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickOnEqualByText(String text) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable((WebElement) foundResultsLocator));
        List<WebElement> findElements = driver.findElements(By.xpath(XPATH_TO_LINK));

        for (int i = 0; i < findElements.size(); i++) {
            if (findElements.get(i).getText().contains(text)) {
                findElements.get(i).click();
                break;
            }
        }
        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }

  /*  public List<SearchResultItem> searchResultsItems() {
        return searchResultItemComponents().stream()
                .map(SearchResultItemComponent::convertToSearchResultItem)
                .collect(Collectors.toList());
    }

    public List<SearchResultItem> searchResultsItemsWithText(String searchPhrase) {
        return searchResultsItems().stream()
                .filter(item -> item.getTitle().contains(searchPhrase) || item.getDescription().contains(searchPhrase))
                .collect(Collectors.toList());
    }

    private List<SearchResultItemComponent> searchResultItemComponents() {
        return findElements((By) searchResultItem).stream()
                .map(SearchResultItemComponent::new)
                .collect(Collectors.toList());
    }*/


}

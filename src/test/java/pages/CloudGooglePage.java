package pages;

import model.GoogleCloudPageModel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CloudGooglePage extends AbstractPage {

    final private String CLOUD_URL = "https://cloud.google.com/";
    final private String CALCULATOR_LINK = "Google Cloud Platform Pricing Calculator";
    private String searchTextLink;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(xpath = "//input[contains(@class, 'devsite-search-field')]")
    WebElement searchButton;

    @FindBy(className = "devsite-search-results")
    WebElement searchResults;

    public CloudGooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public CloudGooglePage openPage() {
        driver.navigate().to(CLOUD_URL);
        return this;
    }

    public CloudGooglePage typeInSearch(String string) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchField));
        searchTextLink = string;
        searchButton.click();
        searchField.sendKeys(string);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }

    public SearchResultPage typeInSearch(GoogleCloudPageModel cloudPageModel) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(cloudPageModel.getSearch());
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public TempMailOrgPage openNewTabTempMailOrgTest(String url) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(url);
        return new TempMailOrgPage(driver);
    }

    public SearchResultPage clickInSearchResult() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchField));
        return new SearchResultPage(driver);
    }


}

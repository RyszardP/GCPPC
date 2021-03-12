package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    final private String CALCULATOR_LINK = "Google Cloud Platform Pricing Calculator";
    private String containsPart = " and contains(.,'%s')";

    @FindBy(xpath = "//*[@class='gs-title']")
    private List<WebElement> foundResultsLocator;


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }


    public SearchResultPage openPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage clickOnFirst() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable((WebElement) foundResultsLocator));
        List<WebElement> findElements = driver.findElements(By.xpath("//a[@class='gs-title']"));

            for (int i=0;i<findElements.size();i++)
            {
                if (findElements.get(i).getText().contains(CALCULATOR_LINK))
                {
                    findElements.get(i).click();
                    break;
                }
            }

        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }


}

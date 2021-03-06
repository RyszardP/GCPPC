package pages;

import model.TempMailIoPageModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class TempMailIoPage extends AbstractPage {
    public static String emailAddress;
    public static Double estimatedMonthlyCostInEMailIo;
    private final Logger logger = LogManager.getRootLogger();

    private final String PAGE_URL = "https://temp-mail.io/";

    public TempMailIoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TempMailIoPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("email page opened");
        return this;
    }

    @FindBy(xpath = "//h2[contains(text(),'Estimated')]")
    WebElement estimatedMonthlyCost;

    public TempMailIoPage getAddress(TempMailIoPageModel pageModel) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .attributeContains(driver.findElement(By.id("email")), "value", "@"));
        emailAddress = driver.findElement(By.id("email")).getAttribute("value");
        logger.info("get address ");
        pageModel.setEmailAddress(emailAddress);
        System.out.println(emailAddress);
        System.out.println(pageModel.getEmailAddress() + "get address from pageModel");
        return this;
    }

    public TempMailIoPage switchTabToCalculate() {
        driver.switchTo().window(GoogleCloudPlatformPricingCalculatorPage.tabs.get(0));
        return this;
    }

    public TempMailIoPage clickToMailWithSubject() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        new WebDriverWait(driver, 90).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//a[contains(@class, 'viewLink title-subject') and contains(text(),'Google')]"))).click();
        return this;
    }


    public TempMailIoPage getEstimatedMonthlyCostInEmail(TempMailIoPageModel pageModel) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .textMatches(By.xpath("//h2[contains(text(),'Estimated')]"), Pattern.compile("USD")));
        String string = estimatedMonthlyCost
                .getText()
                .replaceAll("[^0-9.]", "");
        estimatedMonthlyCostInEMailIo = Double.parseDouble(string);
        pageModel.setEstimatedMonthlyCost(String.valueOf(estimatedMonthlyCost));
        return this;
    }
}

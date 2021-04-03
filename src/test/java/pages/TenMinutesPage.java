package pages;

import model.TempMailIoPageModel;
import model.TenMinutesPageModel;
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

public class TenMinutesPage extends AbstractPage {
    public static String emailAddress;
    public static Double estimatedMonthlyCostInEMail;
    private final String PAGE_URL = "https://10minutemail.com/";
    private final Logger logger = LogManager.getRootLogger();

    public TenMinutesPage(WebDriver driver) {
        super(driver);
    }

    public TenMinutesPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    @FindBy(xpath = "//h2[contains(text(),'Estimated')]")
    WebElement estimatedMonthlyCost;

    public TenMinutesPage getAddress(TenMinutesPageModel pageModel) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .attributeContains(driver.findElement(By.id("mail_address")), "value", "@"));
        emailAddress = driver.findElement(By.id("mail_address")).getAttribute("value");
        logger.info("get address ");
        pageModel.setEmailAddress(emailAddress);
        System.out.println(emailAddress);
        System.out.println(pageModel.getEmailAddress() + "get address from pageModel");
        return this;
    }

    public TenMinutesPage switchTabToCalculate() {
        driver.switchTo().window(GoogleCloudPlatformPricingCalculatorPage.tabs.get(0));
        return this;
    }

    public TenMinutesPage clickToMailWithSubject() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        new WebDriverWait(driver, 90).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//span[contains(text(),'Google')]"))).click();
        return this;
    }

    public TenMinutesPage getEstimatedMonthlyCostInEmail(TenMinutesPageModel pageModel) {

        new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .textMatches(By.xpath("//h2[contains(text(),'Estimated')]"), Pattern.compile("USD")));
        String string = estimatedMonthlyCost
                .getText()
                .replaceAll("[^0-9.]", "");

        estimatedMonthlyCostInEMail = Double.parseDouble(string);
        System.out.println(estimatedMonthlyCost);
        pageModel.setEstimatedMonthlyCost(String.valueOf(estimatedMonthlyCost));

        return this;
    }

}

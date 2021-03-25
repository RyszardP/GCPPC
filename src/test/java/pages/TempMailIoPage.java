package pages;

import model.TempMailIoPageModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public TempMailIoPage getAddress(TempMailIoPageModel pageModel) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .attributeContains(driver.findElement(By.id("email")), "value", "@"));
        emailAddress = driver.findElement(By.id("email")).getAttribute("value");
        logger.info("get address ");
        pageModel.setEmailAddress(emailAddress);
        System.out.println(emailAddress);
        System.out.println(pageModel.getEmailAddress()+ "get address from pageModel");
        return this;
    }

    public TempMailIoPage switchTabToCalculate() {
        driver.switchTo().window(GoogleCloudPlatformPricingCalculatorPage.tabs.get(0));
        return this;
    }
}

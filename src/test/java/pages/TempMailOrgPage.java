package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


public class TempMailOrgPage extends AbstractPage {
    public static String emailAddress;
    public static Double estimatedMonthlyCostInEMail;

    public TempMailOrgPage(WebDriver driver) {
        super(driver);
    }


    public TempMailOrgPage openPage(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    @FindBy(xpath = "//input[@id='mail']")
    WebElement mailField;


    @FindBy(xpath = "//span[@class='inboxSubject' and contains(text(),'Google')]")
    WebElement mailSubject;

    @FindBy(xpath = "//h2[contains(text(),'Estimated')]")
    WebElement estimatedMonthlyCost;


    public TempMailOrgPage getAddress() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .attributeContains(driver.findElement(By.id("mail")), "value", "@"));
        emailAddress = driver.findElement(By.id("mail")).getAttribute("value");
        // System.out.println(driver.findElement(By.id("mail")).getAttribute("value"));
        return this;
    }

    public TempMailOrgPage switchTabToCalculate() {
        driver.switchTo().window(GoogleCloudPlatformPricingCalculatorPage.tabs.get(0));
        return this;
    }

    //*[@id="tm-body"]/main/div[1]/div/div[2]/div[2]/div/div[1]/div/div[4]/ul/li[2]/div[2]/span/a
    //contains(text(),'Google')]


    public TempMailOrgPage clickToMailWithSubject(String subject) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        new WebDriverWait(driver, 90).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//a[contains(@class, 'viewLink title-subject') and contains(text(),'Google')]"))).click();
        return this;
    }


    public TempMailOrgPage getEstimatedMonthlyCostInEmail() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .textMatches(By.xpath("//h2[contains(text(),'Estimated')]"), Pattern.compile("USD")));
        String string = estimatedMonthlyCost
                .getText()
                .replaceAll("[^0-9.]", "");
        estimatedMonthlyCostInEMail = Double.parseDouble(string);
        System.out.println(estimatedMonthlyCostInEMail);
        return this;
    }
}

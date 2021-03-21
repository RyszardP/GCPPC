package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;


public class TempMailOrgPage extends AbstractPage {
    static String emailAddress;


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
         new WebDriverWait(driver, 90).until(ExpectedConditions.elementToBeClickable
                 (By.xpath("//span[contains(@class, 'inboxSubject') and contains(text(),'" + subject + "')]"))).click();

      //  new WebDriverWait(driver, 20);
     //  JavascriptExecutor js = (JavascriptExecutor) driver;
      //  js.executeScript("arguments[0].scrollIntoView();", "//span[contains(@class, 'inboxSubject') and contains(text(),'" + subject + "')]");
      //  mailSubject.click();
        return this;
    }

}

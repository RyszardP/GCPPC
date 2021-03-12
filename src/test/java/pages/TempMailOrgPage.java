package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CustomCondition;

import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes;
import java.util.regex.Pattern;

public class TempMailOrgPage extends AbstractPage {
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    Pattern pattern = Pattern.compile(regex);


    public TempMailOrgPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TempMailOrgPage openPage(String url) {
        new WebDriverWait(driver, 20).withMessage("javascript didn't load")
                .until(CustomCondition.jQueryAJAXsCompleted());
        return this;
    }

    @FindBy(xpath = "//input[@id='mail']")
    WebElement mailField;

    public TempMailOrgPage getAddress() throws InterruptedException {
        //  String mail = mailField.getText();
        // System.out.println(mail);
        // Thread.sleep(5000);
       /* new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));*/

       new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(mailField, regex));
     //  new WebDriverWait(driver, 10).until(ExpectedConditions.textMatches((By) mailField,pattern));

        //  new WebDriverWait(driver, 20);

        System.out.println(mailField.getAttribute("value"));

        return this;
    }
}

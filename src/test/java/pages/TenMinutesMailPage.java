package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.CustomCondition;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TenMinutesMailPage extends AbstractPage {

    public static final String TEN_MINUTE_EMAIL = "https://10minutemail.com/";
    static String emailAddress;

    private static WebDriverWait driverWait;

    public TenMinutesMailPage(WebDriver driver) {
        super(driver);

    }

    public TenMinutesMailPage openPage(String url) {
        new WebDriverWait(driver, 15).withMessage("javascript didn't load")
                .until(CustomCondition.jQueryAJAXsCompleted());
        return this;
    }

    @FindBy(xpath = "//input[@id='mail_address']")
    WebElement copyButton;

    @FindBy(xpath = "//div[@id='copy_address']")
    WebElement fieldWithTempEmail;

    public TenMinutesMailPage copyFieldWithEmail() throws IOException, UnsupportedFlavorException {
    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fieldWithTempEmail));
        emailAddress = fieldWithTempEmail.getAttribute("value");

        System.out.println("1-----");
        System.out.println(emailAddress);
        System.out.println("2-----");


        String secondAttempt = fieldWithTempEmail.getText();

        System.out.println(secondAttempt);


      /* String theString = fieldWithTempEmail.getText();

        StringSelection selection = new StringSelection(theString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);

        System.out.println(clipboard);

        String my_clipboard = String.valueOf(Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor));

        System.out.println(my_clipboard);*/

       // fieldWithTempEmail.getText();

     //   Actions actions = new Actions(driver);
      //  actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "C")).build().perform();

      //  String my_clipboard = String.valueOf(Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor));

      //  System.out.println(my_clipboard);
        return this;
    }

    public TenMinutesMailPage switchTab(){
        driver.switchTo().window(GoogleCloudPlatformPricingCalculatorPage.tabs.get(0));
        return this;
    }
}

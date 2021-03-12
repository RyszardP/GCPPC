package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.datatransfer.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TempMailPage extends AbstractPage {

    protected String emailAddress;
    public String clipBoardString;
    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    public TempMailPage(WebDriver driver) {
        super(driver);
    }

    public TempMailPage openPage(String url) {
        return null;
    }

    @FindBy(xpath = "//input[@id='mail']")
    WebElement fieldWithTempEmail;


    @FindBy(xpath = "//button[@class='btn-rds icon-btn bg-theme click-to-copy copyIconGreenBtn']")
    WebElement copyButton;

    public TempMailPage getTempMAilAddress() throws IOException, UnsupportedFlavorException {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        copyButton.click();

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        String x = (String) contents.getTransferData(DataFlavor.stringFlavor);



        System.out.println(x);


        return this;
    }

}

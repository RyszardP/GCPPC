package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public abstract class AbstractTabPage  {
    protected WebDriver driver;

    protected AbstractTabPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected AbstractTabPage openTabPage(String url){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(url);
        return this;
    }


}

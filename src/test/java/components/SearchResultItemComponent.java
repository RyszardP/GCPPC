package components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultItemComponent extends WebComponent {

    private static final By TITLE_SELECTOR = By.xpath("//div[@class='gs-title']");
    private static final By DESCRIPTION_SELECTOR = By.cssSelector(".gs-snippet");
    ////div[@class='gs-bidi-start-align gs-snippet']


    public SearchResultItemComponent(WebElement rootElement) {
        super(rootElement);
    }

    public SearchResultItem convertToSearchResultItem() {
        return new SearchResultItem(
                retrieveTitle(),
                retrieveDescription()
        );
    }

    private String retrieveTitle() {
        return findElement(TITLE_SELECTOR).getText().toLowerCase();
    }

    private String retrieveDescription() {
        return findElement(DESCRIPTION_SELECTOR).getText().toLowerCase();
    }
}

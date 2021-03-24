package test;

import model.CalculationPageModel;
import model.GoogleCloudPageModel;
import model.SearchResultPageModel;
import org.testng.annotations.Test;
import pages.CloudGooglePage;
import pages.GoogleCloudPlatformPricingCalculatorPage;
import pages.SearchResultPage;
import service.CalculationPageCreator;
import service.GoogleCloudPageCreator;
import service.SearchResultPageCreator;
import test.CommonConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CloudsWithUtilsTest extends CommonConditions {

    @Test
    public void openCloudPage() {
        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        CalculationPageModel calculatorPage = CalculationPageCreator.withCredentialsFromProperty();
        GoogleCloudPlatformPricingCalculatorPage googlePage = new CloudGooglePage(driver)
                .openPage()
                .typeInSearch(cloudPageModel)
                .clickOnFirstResult()
                .selectComputeEngine()
                .typeNumberOfInstances(calculatorPage);

        //     .clickOnFirstResult(calculatorPage);
        //    .selectComputeEngine();


    }
}

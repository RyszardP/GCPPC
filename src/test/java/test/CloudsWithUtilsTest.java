package test;

import model.CalculationPageModel;
import model.GoogleCloudPageModel;
import model.SearchResultPageModel;
import model.TempMailIoPageModel;
import org.testng.annotations.Test;
import pages.CloudGooglePage;
import pages.GoogleCloudPlatformPricingCalculatorPage;
import pages.SearchResultPage;
import pages.TempMailIoPage;
import service.CalculationPageCreator;
import service.GoogleCloudPageCreator;
import service.SearchResultPageCreator;
import service.TempMailIoPageCreator;
import test.CommonConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CloudsWithUtilsTest extends CommonConditions {

    @Test
    public void openCloudPage() {
        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        CalculationPageModel calculatorPage = CalculationPageCreator.withCredentialsFromProperty();
        TempMailIoPageModel mailIoPageModel = TempMailIoPageCreator.withResultFromProperty();
        GoogleCloudPlatformPricingCalculatorPage googlePage = new CloudGooglePage(driver)
                .openPage()
                .typeInSearch(cloudPageModel)
                .clickOnFirstResult()
                .selectComputeEngine()
                .typeNumberOfInstancesWithUtil(calculatorPage)
                .selectOSSoftwareWithUtil(calculatorPage)
                .selectMachineClassWithUtil(calculatorPage)
                .selectSeriesWithUtil(calculatorPage)
                .selectInstanceWithUtil(calculatorPage)
                .selectCheckBoxGPUWithUtil(calculatorPage)
                .selectSSDWithUtil(calculatorPage)
                .selectLocationWithUtil(calculatorPage)
                .selectCommittedUsageWithUtil(calculatorPage)
                .clickAddToEstimate()
                .clickToEmailEstimate()
                .createNewTab()
                .switchTab();

        TempMailIoPage tempMailIoPage = new TempMailIoPage(driver)
                .openPage()
                .getAddress(mailIoPageModel);

        //     .clickOnFirstResult(calculatorPage);
        //    .selectComputeEngine();


    }
}

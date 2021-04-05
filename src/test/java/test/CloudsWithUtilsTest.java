package test;

import model.*;
import org.testng.annotations.Test;
import pages.*;
import service.*;
import test.CommonConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CloudsWithUtilsTest extends CommonConditions {

    @Test
    public void openCloudPage() {
        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        CalculationPageModel calculatorPage = CalculationPageCreator.withCredentialsFromProperty();
        TenMinutesPageModel tenMinutesPageModel = TenMinutesPageCreator.withResultFromProperty();
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

        TenMinutesPage tenMinutesPage = new TenMinutesPage(driver)
                .openPage()
                .getAddress(tenMinutesPageModel)
                .switchTabToCalculate();

        googlePage
               .switchToFrameCalculator()
                .inputTenMinutesEmailInEstimate(tenMinutesPageModel)
                .clickSendEmailButton()
                .switchTab();

        tenMinutesPage
                .clickToMailWithSubject()
             //   .getEstimatedMonthlyCostInEmail(tenMinutesPageModel)
                .getMessageFromTemporaryEmailService(tenMinutesPageModel)
                .switchTabToCalculate();

        googlePage
                .switchToFrameCalculator()
                .getEstimatedCost();



    }
}

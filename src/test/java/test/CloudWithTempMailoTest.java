package test;

import model.CalculationPageModel;
import model.GoogleCloudPageModel;
import model.TempMailoPageModel;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CloudGooglePage;
import pages.GoogleCloudPlatformPricingCalculatorPage;
import pages.TempMailoPage;
import service.CalculationPageCreator;
import service.GoogleCloudPageCreator;
import service.TempMailoPageCreator;

import java.util.concurrent.TimeUnit;

public class CloudWithTempMailoTest extends CommonConditions {

    @Test
    public void openAndCheck() throws InterruptedException {
        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        CalculationPageModel calculatorPageModel = CalculationPageCreator.withCredentialsFromProperty();
        TempMailoPageModel tempMailoPageModel = TempMailoPageCreator.withResultFromProperty();
        GoogleCloudPlatformPricingCalculatorPage googlePage = new CloudGooglePage(driver)
                .openPage()
                .typeInSearch(cloudPageModel)
                .clickOnFirstResult()
                .selectComputeEngine()
                .typeNumberOfInstancesWithUtil(calculatorPageModel)
                .selectOSSoftwareWithUtil(calculatorPageModel)
                .selectMachineClassWithUtil(calculatorPageModel)
                .selectSeriesWithUtil(calculatorPageModel)
                .selectInstanceWithUtil(calculatorPageModel)
                .selectCheckBoxGPUWithUtil(calculatorPageModel)
                .selectSSDWithUtil(calculatorPageModel)
                .selectLocationWithUtil(calculatorPageModel)
                .selectCommittedUsageWithUtil(calculatorPageModel)
                .clickAddToEstimate()
                .clickToEmailEstimate()
                .createNewTab()
                .switchTab();




       /* TempMailoPage tempMailoPage = new TempMailoPage(driver)
                .openPage()
                .getAddress(tempMailoPageModel)
                .switchTabToCalculate();

        googlePage
                .switchToFrameCalculator()
                .inputTempMailoInEstimate(tempMailoPageModel)
                .clickSendEmailButton()
                .switchTab();*/

    }
}

package test;

import model.GoogleCloudPageModel;
import org.testng.annotations.Test;
import pages.CloudGooglePage;
import pages.SearchResultPage;
import service.GoogleCloudPageCreator;
import test.CommonConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CloudsWithUtilsTest extends CommonConditions {

    @Test
    public void openClodPage(){
        GoogleCloudPageModel cloudPageModel = GoogleCloudPageCreator.withSearchFromProperty();
        String foundedSearch = new CloudGooglePage(driver)
                .openPage()
                .typeInSearch(cloudPageModel)
                .getFirstResult();
           assertThat(foundedSearch, is(equalTo(cloudPageModel.getSearch())));
    }
}

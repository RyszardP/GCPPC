package service;

import model.GoogleCloudPageModel;

public class GoogleCloudPageCreator {
    public static final String TESTDATA_SEARCH = "testdata.cloud_page.search";

    public static GoogleCloudPageModel withSearchFromProperty(){
        return new GoogleCloudPageModel(TestDataReader.getTestData(TESTDATA_SEARCH));
    }
}

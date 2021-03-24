package service;

import model.SearchResultPageModel;

public class SearchResultPageCreator {
    public static final String TESTDATA_SEARCH_RESULT = "testdata.cloud_page.search_result";

    public static SearchResultPageModel withResultFromProperty() {
        return new SearchResultPageModel(TestDataReader.getTestData(TESTDATA_SEARCH_RESULT));
    }
}

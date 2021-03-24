package service;

import model.CalculationPageModel;

public class CalculationPageCreator {
    public static final String TESTDATA_NUMBER_OF_INSTANCE = "testdata.calculation_page.number_of_instance";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.calculation_page.operating_system";

    public static CalculationPageModel withCredentialsFromProperty(){
        return new CalculationPageModel(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCE),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM));
    }
}

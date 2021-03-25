package service;

import model.CalculationPageModel;

public class CalculationPageCreator {
    public static final String TESTDATA_NUMBER_OF_INSTANCE = "testdata.calculation_page.number_of_instance";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.calculation_page.operating_system";
    public static final String TESTDATA_MACHINE_CLASS = "testdata.calculation_page.machine_class";
    public static final String TESTDATA_SERIES = "testdata.calculation_page.series";
    public static final String TESTDATA_INSTANCE_TYPE = "testdata.calculation_page.instance_type";
    public static final String TESTDATA_NUMBER_OF_GPU = "testdata.calculation_page.number_of_gpu";
    public static final String TESTDATA_GPU_TYPE = "testdata.calculation_page.gpu_type";
    public static final String TESTDATA_SSD = "testdata.calculation_page.ssd";
    public static final String TESTDATA_LOCATION = "testdata.calculation_page.location";
    public static final String TESTDATA_COMMITTED_USAGE = "testdata.calculation_page.committed_usage";

    public static CalculationPageModel withCredentialsFromProperty() {
        return new CalculationPageModel(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCE),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_MACHINE_CLASS),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_INSTANCE_TYPE),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPU),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_SSD),
                TestDataReader.getTestData(TESTDATA_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));


    }


}

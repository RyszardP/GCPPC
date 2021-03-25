package model;

import java.util.Objects;

public class CalculationPageModel {
    private String numberOfInstances;
    private String operationSystem;
    private String machineClass;
    private String series;
    private String instanceType;
    private String numberOfGPU;
    private String gpuType;
    private String ssd;
    private String location;
    private String committedUsage;

    public CalculationPageModel(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public CalculationPageModel(String numberOfInstances, String operationSystem) {
        this.numberOfInstances = numberOfInstances;
        this.operationSystem = operationSystem;
    }

    public CalculationPageModel(String numberOfInstances, String operationSystem, String machineClass) {
        this.numberOfInstances = numberOfInstances;
        this.operationSystem = operationSystem;
        this.machineClass = machineClass;
    }

    public CalculationPageModel(String numberOfInstances, String operationSystem, String machineClass, String series,
                                String instanceType, String numberOfGPU, String gpuType, String ssd, String location,
                                String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operationSystem = operationSystem;
        this.machineClass = machineClass;
        this.series = series;
        this.instanceType = instanceType;
        this.numberOfGPU = numberOfGPU;
        this.gpuType = gpuType;
        this.ssd = ssd;
        this.location = location;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(String numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "CalculationPageModel{" +
                "numberOfInstances=" + numberOfInstances +
                ", operationSystem='" + operationSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", series='" + series + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", numberOfGPU=" + numberOfGPU +
                ", gpuType='" + gpuType + '\'' +
                ", ssd='" + ssd + '\'' +
                ", location='" + location + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationPageModel that = (CalculationPageModel) o;
        return numberOfInstances == that.numberOfInstances &&
                numberOfGPU == that.numberOfGPU &&
                Objects.equals(operationSystem, that.operationSystem) &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(series, that.series) &&
                Objects.equals(instanceType, that.instanceType) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(ssd, that.ssd) &&
                Objects.equals(location, that.location) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operationSystem, machineClass, series, instanceType, numberOfGPU,
                gpuType, ssd, location, committedUsage);
    }


}

package model;

import java.util.Objects;

public class TempMailoPageModel {

    private String emailAddress;
    private String estimatedMonthlyCost;

    public TempMailoPageModel(String emailAddress, String estimatedMonthlyCost) {
        this.emailAddress = emailAddress;
        this.estimatedMonthlyCost = estimatedMonthlyCost;
    }

    public TempMailoPageModel() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEstimatedMonthlyCost() {
        return estimatedMonthlyCost;
    }

    public void setEstimatedMonthlyCost(String estimatedMonthlyCost) {
        this.estimatedMonthlyCost = estimatedMonthlyCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TempMailoPageModel that = (TempMailoPageModel) o;
        return Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(estimatedMonthlyCost, that.estimatedMonthlyCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress, estimatedMonthlyCost);
    }

    @Override
    public String toString() {
        return "TempMailoPageModel{" +
                "emailAddress='" + emailAddress + '\'' +
                ", estimatedMonthlyCost='" + estimatedMonthlyCost + '\'' +
                '}';
    }
}

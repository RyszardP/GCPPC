package model;

import java.util.Objects;

public class GoogleCloudPageModel {
    private String search;

    public GoogleCloudPageModel(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoogleCloudPageModel that = (GoogleCloudPageModel) o;
        return Objects.equals(search, that.search);
    }

    @Override
    public int hashCode() {
        return Objects.hash(search);
    }

    @Override
    public String toString() {
        return "GoogleCloudPageModel{" +
                "search='" + search + '\'' +
                '}';
    }
}

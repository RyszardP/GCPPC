package model;

import java.util.Objects;

public class SearchResultPageModel {

    private String searchResult;

    public SearchResultPageModel(String searchResult) {
        this.searchResult = searchResult;
    }

    public String getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(String searchResult) {
        this.searchResult = searchResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResultPageModel that = (SearchResultPageModel) o;
        return Objects.equals(searchResult, that.searchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchResult);
    }
}

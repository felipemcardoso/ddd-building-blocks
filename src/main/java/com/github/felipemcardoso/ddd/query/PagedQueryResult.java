package com.github.felipemcardoso.ddd.query;

import java.util.List;

public class PagedQueryResult<T extends QueryModel> {

    private List<T> result;

    private int totalItems;

    public PagedQueryResult(List<T> result, int totalItems) {
        this.result = result;
        this.totalItems = totalItems;
    }

    public List<T> getResult() {
        return result;
    }

    public int getTotalItems() {
        return totalItems;
    }
}

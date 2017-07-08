package com.github.felipemcardoso.ddd.query;

import javax.ws.rs.QueryParam;

public class PaginationContext {

    @QueryParam("limit")
    private int limit;

    @QueryParam("offset")
    private int offset;

    public PaginationContext() {
    }

    public PaginationContext(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }
}

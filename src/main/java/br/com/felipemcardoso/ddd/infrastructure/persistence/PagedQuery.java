package br.com.felipemcardoso.ddd.infrastructure.persistence;

import br.com.felipemcardoso.ddd.query.PaginationContext;
import br.com.felipemcardoso.ddd.query.QueryModel;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.List;

public abstract class PagedQuery {

    private String schema;

    private String profile;

    private String id;

    private final PaginationContext paginationContext;

    public PagedQuery(PaginationContext paginationContext, String schema, String profile, String id) {
        this.paginationContext = paginationContext;
        this.schema = schema;
        this.profile = profile;
        this.id = id;
    }

    protected String table(String name, String alias) {
        return table(name) + " " + alias;
    }

    protected String table(String name) {
        return schema + "." + name;
    }

    protected String profile() {
        return profile;
    }

    protected String id() {
        return id;
    }

    public PaginationContext getPaginationContext() {
        return paginationContext;
    }

    public abstract PreparedStatementSetter parameterSetter();

    public String decoratedSql() {
        String decorated = sql();

        if (paginationContext.getLimit() != 0) {
            decorated += " LIMIT " + paginationContext.getLimit();
        }

        decorated += " OFFSET " + paginationContext.getOffset();

        return decorated;
    }

    public abstract String sql();

    public abstract <T extends QueryModel> ResultSetExtractor<List<T>> extractor();
}

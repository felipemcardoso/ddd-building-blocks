package br.com.felipemcardoso.ddd.infrastructure.persistence;

import br.com.felipemcardoso.ddd.query.PagedQueryResult;
import br.com.felipemcardoso.ddd.query.QueryModel;
import br.com.felipemcardoso.ddd.security.ProfileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SegboxJdbcDaoSupport extends JdbcDaoSupport {

    @Autowired
    private SchemaHelper schemaHelper;

    @Autowired
    private ProfileHelper profileHelper;

    public SegboxJdbcDaoSupport(DataSource dataSource) {
        setDataSource(dataSource);
    }

    protected String sequence(String name) {
        return "nextval('" + schemaHelper.schema() + "." + name + "')";
    }

    protected String table(String name) {
        return schemaHelper.schema() + "." + name;
    }

    protected String table(String name, String alias) {
        return table(name) + " " + alias;
    }

    protected String schema() {
        return schemaHelper.schema();
    }

    protected String profile() {
        return profileHelper.getProfile();
    }

    protected String id() {
        return profileHelper.getId();
    }

    protected <T extends QueryModel> PagedQueryResult<T> executePagedQuery(PagedQuery pagedQuery) {

        String sqlCount = "select count(*) as total from (%s) resultado";

        sqlCount = String.format(sqlCount, pagedQuery.sql());

        int totalItems = getJdbcTemplate().query(sqlCount, pagedQuery.parameterSetter(),
                new ResultSetExtractor<Integer>() {

                    @Override
                    public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        if (resultSet.next()) {
                            return resultSet.getInt("total");
                        } else {
                            return 0;
                        }
                    }
                });

        List<T> data = getJdbcTemplate().query(pagedQuery.decoratedSql(), pagedQuery.parameterSetter(),
                pagedQuery.extractor());

        return new PagedQueryResult<T>(data, totalItems);
    }
}

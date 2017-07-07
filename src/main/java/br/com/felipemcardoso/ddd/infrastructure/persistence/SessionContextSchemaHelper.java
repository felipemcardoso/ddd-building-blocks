package br.com.felipemcardoso.ddd.infrastructure.persistence;

import br.com.felipemcardoso.ddd.security.SessionContext;

public class SessionContextSchemaHelper implements SchemaHelper {

    @Override
    public String schema() {
        return SessionContext.descriptor().getToken().getSchema();
    }
}

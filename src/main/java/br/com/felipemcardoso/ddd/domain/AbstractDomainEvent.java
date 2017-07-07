package br.com.felipemcardoso.ddd.domain;

import br.com.felipemcardoso.ddd.security.SessionContext;

import java.util.Date;
import java.util.UUID;

/**
 * Abstração para um evento do domínio
 */
public abstract class AbstractDomainEvent implements DomainEvent {

    private Date occurredOn;

    private UUID id;

    private String name;

    private String schema;

    public AbstractDomainEvent() {
        this.occurredOn = new Date();
        this.id = UUID.randomUUID();
        this.name = getClass().getName();

        if (SessionContext.descriptor() != null) {
            this.schema = SessionContext.descriptor().getToken().getAssinante();
        }
    }

    @Override
    public Date getOccurredOn() {
        return this.occurredOn;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSchema() {
        return this.schema;
    }
}

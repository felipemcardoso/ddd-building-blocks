package com.github.felipemcardoso.ddd.domain;

import java.util.Date;
import java.util.UUID;

public abstract class AbstractDomainEvent implements DomainEvent {

    private Date occurredOn;

    private UUID id;

    private String name;

    public AbstractDomainEvent() {
        this.occurredOn = new Date();
        this.id = UUID.randomUUID();
        this.name = getClass().getName();
    }

    public Date getOccurredOn() {
        return this.occurredOn;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}

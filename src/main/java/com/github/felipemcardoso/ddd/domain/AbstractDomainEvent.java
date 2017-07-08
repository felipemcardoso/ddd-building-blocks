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
}

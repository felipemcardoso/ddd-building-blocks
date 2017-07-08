package com.github.felipemcardoso.ddd.domain;

import com.github.felipemcardoso.ddd.infrastructure.EventBus;

public abstract class AbstractService {

    private final EventBus eventBus;

    public AbstractService(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void postEvent(DomainEvent event) {
        eventBus.post(event);
    }
}

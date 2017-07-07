package br.com.felipemcardoso.ddd.domain;

import br.com.felipemcardoso.ddd.infrastructure.EventBus;

/**
 * Created by felipe on 4/2/15.
 */
public abstract class AbstractService {

    private final EventBus eventBus;

    public AbstractService(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void postEvent(DomainEvent event) {
        eventBus.post(event);
    }
}

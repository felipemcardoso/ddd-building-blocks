package com.github.felipemcardoso.ddd.infrastructure.handler;

import com.github.felipemcardoso.ddd.domain.DomainEvent;

public interface DomainEventHandler<T extends DomainEvent> {

    void handle(T event);
}

package br.com.felipemcardoso.ddd.infrastructure.handler;

import br.com.felipemcardoso.ddd.domain.DomainEvent;

/**
 * Created by Felipe on 4/25/15.
 */
public interface DomainEventHandler<T extends DomainEvent> {

    void handle(T event);
}

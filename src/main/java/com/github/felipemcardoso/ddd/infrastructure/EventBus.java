package com.github.felipemcardoso.ddd.infrastructure;

import com.github.felipemcardoso.ddd.domain.DomainEvent;

public interface EventBus {

    void post(DomainEvent event);
}

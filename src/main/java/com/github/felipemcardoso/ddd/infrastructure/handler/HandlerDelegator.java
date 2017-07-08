package com.github.felipemcardoso.ddd.infrastructure.handler;

import com.github.felipemcardoso.ddd.domain.Event;

public interface HandlerDelegator {

    void delegate(Event event);

}

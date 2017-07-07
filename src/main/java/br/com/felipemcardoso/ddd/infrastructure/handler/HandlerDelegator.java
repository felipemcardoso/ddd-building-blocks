package br.com.felipemcardoso.ddd.infrastructure.handler;

import br.com.felipemcardoso.ddd.domain.Event;

/**
 * Created by Felipe on 4/24/15.
 */
public interface HandlerDelegator {

    void delegate(Event event);

}

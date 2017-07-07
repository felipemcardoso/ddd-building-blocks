package br.com.felipemcardoso.ddd.infrastructure;

import br.com.felipemcardoso.ddd.domain.DomainEvent;

/**
 * Interface para o barramento de mensagens .
 */
public interface EventBus {

    void post(DomainEvent event);
}

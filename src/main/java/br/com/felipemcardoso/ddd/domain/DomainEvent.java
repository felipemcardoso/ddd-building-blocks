package br.com.felipemcardoso.ddd.domain;

import java.util.Date;
import java.util.UUID;

/**
 * Interface para um evento do domínio
 *
 * @author Felipe
 */
public interface DomainEvent {

    Date getOccurredOn();

    UUID getId();

    String getName();

    String getSchema();
}

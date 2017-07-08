package com.github.felipemcardoso.ddd.domain;

/**
 * Abstração para um Value Object que pode ser persistido fora da entidade que o detém.
 *
 * @author Felipe
 */
public abstract class IdentifiedValueObject<K extends KeyIdentity> extends IdentifiedDomainObject<K> {

    public IdentifiedValueObject() {
    }

    public IdentifiedValueObject(K key) {
        super(key);
    }

}

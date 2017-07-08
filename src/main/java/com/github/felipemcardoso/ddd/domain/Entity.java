package com.github.felipemcardoso.ddd.domain;


/**
 * @author felipe
 */
public abstract class Entity<K extends KeyIdentity> extends IdentifiedDomainObject<K> {

    public Entity() {
    }

    public Entity(K key) {
        super(key);
    }
}

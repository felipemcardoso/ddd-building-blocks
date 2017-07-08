package com.github.felipemcardoso.ddd.domain;

import java.util.Objects;

public abstract class CompositeKeyIdentity<T, K extends KeyIdentity<?>> extends KeyIdentity<T> {

    private K key2;

    public CompositeKeyIdentity(T value, K key2) {
        super(value);

        if (key2 == null) {
            throw new IllegalArgumentException("Identificador não pode ser nulo.");
        }

        this.key2 = key2;
    }

    public K getKey2() {
        return key2;
    }

    @Override
    public boolean equals(Object obj) {
        boolean firstKeyEquals = super.equals(obj);

        if (!firstKeyEquals) {
            return false;
        }

        if (!(obj instanceof CompositeKeyIdentity)) {
            return false;
        }

        CompositeKeyIdentity other = (CompositeKeyIdentity) obj;

        if (key2.getClass().getName().equals(other.key2.getClass().getName())) {
            return key2.equals(other.key2);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();

        KeyIdentity k = key2;

        while (k instanceof CompositeKeyIdentity) {
            CompositeKeyIdentity tempKey = (CompositeKeyIdentity) k;

            hash = 29 * hash + Objects.hashCode(tempKey.value());

            k = tempKey.key2;
        }

        hash = 29 * hash + Objects.hashCode(k.value());

        return hash;
    }
}

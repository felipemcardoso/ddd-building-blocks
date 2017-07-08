package com.github.felipemcardoso.ddd.domain;

import java.util.Objects;

/**
 * Classe que abstrai um atributo-chave (i.e. identificador) de um objeto.
 *
 * @param <T> tido do atributo-chave.
 * @author felipe
 */
public abstract class KeyIdentity<T> {

    private T value;

    public KeyIdentity(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Identificador não pode ser nulo.");
        }
        this.value = value;
    }

    public T value() {
        return value;
    }


    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof KeyIdentity && Objects.equals(value, ((KeyIdentity) obj).value());

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

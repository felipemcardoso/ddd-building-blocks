package br.com.felipemcardoso.ddd.domain;

import java.util.Objects;

/**
 * * Abstração que representa um objeto do domínio com identificador.
 *
 * @param <K> tipo identificador do objeto.
 *            <p>
 *            Created by Felipe on 4/1/15.
 */
public abstract class IdentifiedDomainObject<K extends KeyIdentity> implements DomainObject {

    private K key;

    private PersistenceStatus state = PersistenceStatus.UNBOUND;

    public IdentifiedDomainObject() {
    }

    public IdentifiedDomainObject(K key) {
        setKey(key);
    }

    /**
     * @return o objeto do tipo KeyIdentity, que representa o atributo-chave do Entity
     */
    public K getKey() {
        return key;
    }

    /**
     * @param id identificador
     */
    public void setKey(K id) {

        if (id == null) {
            throw new IllegalArgumentException("Identificador não pode ser nulo.");
        }

        key = id;
        state = PersistenceStatus.BOUND;

        onBound();
    }

    protected void onBound() {
    }

    public boolean isBound() {
        return this.state.equals(PersistenceStatus.BOUND);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        IdentifiedDomainObject other = (IdentifiedDomainObject) obj;

        if (isBound() && other.isBound()) {
            return Objects.equals(this.getKey(), other.getKey());
        } else {
            return this == other;
        }
    }

    @Override
    public int hashCode() {
        if (isBound()) {
            return 23 * 7 + this.getKey().hashCode();
        } else {
            return System.identityHashCode(this);
        }
    }
}

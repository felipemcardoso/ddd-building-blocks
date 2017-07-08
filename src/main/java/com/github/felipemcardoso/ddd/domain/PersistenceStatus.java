package com.github.felipemcardoso.ddd.domain;

/**
 * Enum que representa os possíveis estados de um objeto do modelo.
 * UNBOUND: é um objeto que não está associado a um objeto do banco de dados.
 * BOUND: é um objeto que está associado a um objeto do banco de dados.
 *
 * @author felipe
 */
enum PersistenceStatus {
    UNBOUND, BOUND
}

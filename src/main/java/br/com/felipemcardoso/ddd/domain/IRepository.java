package br.com.felipemcardoso.ddd.domain;

/**
 * Interface que representa o contrato de implementação de um Repositório do DDD
 * <p>
 * Created by felipe on 3/31/15.
 */
public interface IRepository<T extends Entity, K extends KeyIdentity> {

    T load(K id);
}

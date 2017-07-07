package br.com.felipemcardoso.ddd.domain;

/**
 * Interface para classes que podem receber validações para garantir as invariâncias da classe.
 * <p>
 * Created by felipe on 7/2/14.
 */
public interface Validable {

    void validate(ValidationNotificationHandler handler);
}

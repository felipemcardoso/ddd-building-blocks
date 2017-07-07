package br.com.felipemcardoso.ddd.domain;


import br.com.felipemcardoso.ddd.exception.BusinessException;

import java.util.List;

/**
 * Notificador para exceções de negócio.
 * <p>
 * Created by felipe on 7/2/14.
 */
public interface ValidationNotificationHandler {

    void handleError(List<BusinessException> errors);
}
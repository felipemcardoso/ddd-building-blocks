package com.github.felipemcardoso.ddd.domain;


import com.github.felipemcardoso.ddd.exception.BusinessException;

import java.util.List;

/**
 * Notificador para exceções de negócio.
 * <p>
 * Created by felipe on 7/2/14.
 */
public interface ValidationNotificationHandler {

    void handleError(List<BusinessException> errors);
}
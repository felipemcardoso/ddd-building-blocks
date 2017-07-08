package com.github.felipemcardoso.ddd.domain;


import com.github.felipemcardoso.ddd.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstração para um validador de Entity. Recebe como parâmetro um Entity e um ValidationNotificationHandler.
 * Realiza a validação do objeto. Caso ocorra erros de validação, notifica o responsável por tratá-lo, via handler.
 * <p>
 * Created by felipe on 7/2/14.
 */
public abstract class Validator<T extends Entity> {

    protected T entity;

    protected List<BusinessException> errors;

    protected ValidationNotificationHandler handler;

    public Validator(T entity, ValidationNotificationHandler handler) {
        this.entity = entity;
        this.handler = handler;
        this.errors = new ArrayList<>();

        performValidation();
    }

    private void performValidation() {
        validate();

        if (!errors.isEmpty()) {
            handler.handleError(errors);
        }
    }

    protected T getEntity() {
        return entity;
    }

    public abstract void validate();

}
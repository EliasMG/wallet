package com.wallet.core.exceptions;

import com.wallet.core.validation.Error;

import java.util.List;

public class DomainException extends RuntimeException {
    protected final List<Error> errors;

    protected DomainException(final String message, final List<Error> errors) {
        super(message, null, true, false);
        this.errors = errors;
    }

    public static DomainException with(final List<Error> errors) {
        return new DomainException("", errors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}

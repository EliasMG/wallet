package com.wallet.core.cliente;

import com.wallet.core.validation.Error;
import com.wallet.core.validation.ValidationHandler;
import com.wallet.core.validation.Validator;

public class ClienteValidator extends Validator {
    private final Cliente cliente;
    public ClienteValidator(final Cliente cliente, final ValidationHandler handler) {
        super(handler);
        this.cliente = cliente;
    }

    @Override
    public void validate() {
        if (this.cliente.getName() == null) {
            this.validationHandler().append(new Error("'name' should not be null"));
        }
    }
}

package com.wallet.core.cliente;

import com.wallet.core.exceptions.DomainException;
import com.wallet.core.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void givenAValidParams_whenCallNewCliente_thenInstantiateACliente() {
        final var expectedName = "John Doe";
        final var expectedEmail = "john@doe.com";

        final var actualCliente = Cliente.newCliente(expectedName, expectedEmail);

        Assertions.assertNotNull(actualCliente);
        Assertions.assertNotNull(actualCliente.getId());
        Assertions.assertEquals(expectedName, actualCliente.getName());
        Assertions.assertEquals(expectedEmail, actualCliente.getEmail());
        Assertions.assertNotNull(actualCliente.getCreatedAt());
        Assertions.assertNotNull(actualCliente.getUpdatedAt());
    }

    @Test
    public void givenAnInvalidNullName_whenCallNewClienteAnValidate_thenShouldReceveError() {
        final String expectedName = null;
        final var expectedEmail = "john@doe.com";

        final var expectedErrorMessage = "'name' should not be null";
        final var expectedErrorCount = 1;

        final var actualCliente = Cliente.newCliente(expectedName, expectedEmail);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCliente.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }
}
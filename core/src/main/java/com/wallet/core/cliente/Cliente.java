package com.wallet.core.cliente;

import com.wallet.core.AggregateRoot;
import com.wallet.core.Entity;
import com.wallet.core.validation.ValidationHandler;

import java.time.Instant;
import java.util.UUID;

public class Cliente extends AggregateRoot<ClienteID> {
    private String name;
    private String email;
    private Instant createdAt;
    private Instant updatedAt;

    private Cliente(
            final ClienteID id,
            final String name,
            final String email,
            final Instant createdAt,
            final Instant updatedAt
    ) {
        super(id);
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Cliente newCliente(final String name, final String email) {
        final var id = ClienteID.unique();
        final var now = Instant.now();
        return new Cliente(id, name, email, now, now);
    }

    @Override
    public void validate(ValidationHandler handler) {
        new ClienteValidator(this, handler).validate();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}

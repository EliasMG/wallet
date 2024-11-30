package com.wallet.core.cliente;

import com.wallet.core.Identifier;
import com.wallet.core.utils.IdUtils;

import java.util.Objects;

public class ClienteID extends Identifier {
    private final String value;

    private ClienteID(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static ClienteID unique() {
        return ClienteID.from(IdUtils.uuid());
    }

    public static ClienteID from(final String anId) {
        return new ClienteID(anId);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ClienteID that = (ClienteID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}

package com.github.felipemcardoso.ddd.domain;

import java.util.UUID;

public class EventId extends KeyIdentity<UUID> {

    public EventId(UUID value) {
        super(value);
    }
}

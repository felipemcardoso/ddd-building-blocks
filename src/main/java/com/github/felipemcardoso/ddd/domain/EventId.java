package com.github.felipemcardoso.ddd.domain;

import java.util.UUID;

/**
 * Created by Felipe on 4/21/15.
 */
public class EventId extends KeyIdentity<UUID> {

    public EventId(UUID value) {
        super(value);
    }
}

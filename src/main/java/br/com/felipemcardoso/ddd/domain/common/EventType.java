package br.com.felipemcardoso.ddd.domain.common;

import br.com.felipemcardoso.ddd.util.StringUtils;

/**
 * Created by Felipe on 4/21/15.
 */
public enum EventType {

    PUBLICADO("P"), CONSUMIDO("C");

    private final String id;

    private EventType(String id) {
        this.id = id;
    }

    public static EventType fromValue(String id) {
        for (EventType e : EventType.values()) {
            if (e.getId().equals(id)) {
                return e;
            }
        }

        return null;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return StringUtils.initCap(super.toString());
    }
}

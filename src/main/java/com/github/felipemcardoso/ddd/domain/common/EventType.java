package com.github.felipemcardoso.ddd.domain.common;

public enum EventType {

    PUBLISHED("P"), CONSUMED("C");

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


}

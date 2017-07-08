package com.github.felipemcardoso.ddd.domain.common;

/**
 * Enum com os valores S e N, correspondendo a Sim e Não, respectivamente.
 *
 * @author felipe
 */

public enum YesNo {

    SIM("S"), NAO("N");

    private final String id;

    private YesNo(String id) {
        this.id = id;
    }

    public static YesNo fromValue(String id) {
        for (YesNo e : YesNo.values()) {
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

package br.com.felipemcardoso.ddd.domain.common;

import br.com.felipemcardoso.ddd.util.StringUtils;

/**
 * Enum com os valores S e N, correspondendo a Sim e Não, respectivamente.
 *
 * @author felipe
 */

public enum SimNao {

    SIM("S"), NAO("N");

    private final String id;

    private SimNao(String id) {
        this.id = id;
    }

    public static SimNao fromValue(String id) {
        for (SimNao e : SimNao.values()) {
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

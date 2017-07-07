package br.com.felipemcardoso.ddd.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author felipe
 */
public class CollectionUtils {

    public static List toList(Set set) {
        List result = new ArrayList();
        result.addAll(set);

        return result;
    }

    public static Set toSet(List list) {
        Set result = new LinkedHashSet();

        for (Object object : list) {
            result.add(object);
        }

        return result;
    }

    /**
     * Retorna a uma lista de inteiros separados por vírgula
     *
     * @param list lista a ser convertida
     * @return lista na forma de String
     */
    public static String toStringList(List<Long> list) {
        Assert.notNull(list, "Lista não pode ser nula");

        StringBuilder result = new StringBuilder();

        for (Long i : list) {
            result.append(i).append(",");
        }

        if (!list.isEmpty()) {
            result.deleteCharAt(result.lastIndexOf(","));
        }

        return result.toString();
    }

    public static List clone(List list) {
        return list;
    }

}

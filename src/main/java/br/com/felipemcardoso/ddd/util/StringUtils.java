package br.com.felipemcardoso.ddd.util;

/**
 * Classe utilitária como métodos relacionados a strings.
 *
 * @author felipe
 */
public class StringUtils {

    /**
     * Altera as primeiras letras de casa palavra para caixa alta. Por exemplo: source = "framework serigy" seria
     * alterado para "Framework Serigy";
     *
     * @param source String a ser alterada.
     * @return String alterada.
     */
    public static String initCap(String source) {

        if (source != null && source.length() > 0) {

            source = source.toLowerCase();

            StringBuilder result = new StringBuilder();
            String[] names = source.split(" ");
            String space = "";

            for (String name : names) {
                char[] charArray = name.toCharArray();

                if (charArray.length > 0) {
                    charArray[0] = Character.toUpperCase(charArray[0]);

                    result.append(space);
                    result.append(charArray);

                    space = " ";
                }
            }

            return result.toString();
        } else {
            return "";
        }
    }

    public static boolean hasText(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public static boolean isInteger(String valor) {
        try {
            Integer.valueOf(valor);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static String RPad(String str, Integer length, char car) {
        if (str != null) {

            if (length > str.length()) {
                return str + String.format("%" + (length - str.length()) + "s", "").replace(" ", String.valueOf(car));
            }
            return str;
        }
        return "";
    }

    public static String LPad(String str, Integer length, char car) {
        if (str != null) {

            if (length > str.length()) {
                return String.format("%" + (length - str.length()) + "s", "").replace(" ", String.valueOf(car)) + str;
            }
            return str;
        }
        return "";
    }

    public static Integer parseInt(String valor) {
        try {
            return Integer.valueOf(valor);

        } catch (Exception e) {
            return null;
        }
    }
    
    public static Double parseDouble(String valor) {
        try {
            return Double.valueOf(valor);

        } catch (Exception e) {
            return null;
        }
    }
    
    
}

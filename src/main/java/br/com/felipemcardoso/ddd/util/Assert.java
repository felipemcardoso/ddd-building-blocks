package br.com.felipemcardoso.ddd.util;


import br.com.felipemcardoso.ddd.domain.Entity;

import java.util.List;

/**
 * Classe com diversas assertivas que podem ser utilizadas para programação defensiva.
 *
 * @author felipe
 */
public class Assert {

    /**
     * Verifica se o objeto passado como parâmetro <b>não</b> é nulo. Caso seja nulo, lança uma
     * NullPointerException.
     *
     * @param object  o objeto a ser verificado.
     * @param message mensagem que será lançada com a exceção.
     */
    public static void notNull(Object object, String message) {

        if (object == null) {
            throw new NullPointerException(message);
        }
    }

    /**
     * Verifica se o objeto passado como parâmetro <b>não</b> é nulo. Caso seja nulo, lança uma
     * NullPointerException.
     *
     * @param object o objeto a ser verificado.
     * @param klass  nome da classe do objeto.
     */
    public static void notNull(Object object, Class klass) {

        if (object == null) {
            throw new NullPointerException("Objeto da classe " + klass.toString() + " não pode ser nulo.");
        }
    }

    /**
     * Verifica se a lista passada como parâmetro <b>não</b> está vazia. Caso seja nulo, lança uma
     * IllegalArgumentException.
     *
     * @param list    a lista a ser verificado.
     * @param message mensagem que será lançada com a exceção.
     */
    public static void notEmpty(List list, String message) {

        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNull(Object object) {
        isNull(object, "Objeto da classe " + object.getClass() + " deve ser nulo");
    }


    public static void isNull(Object object, String message) {

        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Verifica se o objeto do domínio e sua chave são diferentes de null.
     *
     * @param domainObject Objeto do domínio
     * @param message      mensagem que será lançada com a exceção.
     */
    public static void isValid(Entity domainObject, String message) {

        if (domainObject == null || domainObject.getKey() == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Verifica se o objeto do domínio e sua chave são diferentes de null.
     *
     * @param domainObject Objeto do domínio
     */
    public static void isValid(Entity domainObject, Class klass) {

        if (domainObject == null || domainObject.getKey() == null) {
            throw new IllegalArgumentException("Objeto da classe " + klass.getName() + " inválido");
        }
    }

    /**
     * Verifica se a condição é verdadeira.
     *
     * @param condition mensagem que será lançada com a exceção.
     */
    public static void isTrue(boolean condition) {
        if (!condition) {
            throw new IllegalArgumentException("Condicional com valor falso");
        }
    }

    /**
     * Verifica se a condição é verdadeira.
     *
     * @param condition condição
     * @param message   mensagem
     */
    public static void isTrue(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Verifica se a String é diferente de null e da string vaiza.
     *
     * @param input   - String a ser verificada.
     * @param message - Mensagem da exceção lançada caso a string se nula ou vazia.
     */
    public static void isNotEmpytString(String input, String message) {
        if (input == null || input.trim().equals("")) {
            throw new IllegalArgumentException(message);
        }
    }
}

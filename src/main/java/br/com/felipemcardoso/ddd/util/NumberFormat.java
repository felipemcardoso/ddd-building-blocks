package br.com.felipemcardoso.ddd.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Classe utilitária que formata números como string de acordo com o padrão de formatação passado como parâmetro
 *
 * @author Daniel
 */
public class NumberFormat {

    /**
     * Formata um valor numérico em BigDecimal para o padrão passado como parâmetro. <br/> Ex.: "<b>0000000.0000</b>" (11
     * dígitos sendo 4 para a parte decimal, obrigatoriamente.<br/> Ao utilizar o caractere "<b>#</b>" para representar
     * os dígitos, os mesmos não são obrigatórios, mas sim um limite máximo.
     *
     * @param value  valor
     * @param format formato
     * @return número formatado como string
     */
    public static String format(BigDecimal value, String format) {
        if (value != null && format != null) {
            return new DecimalFormat(format, new DecimalFormatSymbols(Locale.US)).format(value);
        }
        return null;
    }
}

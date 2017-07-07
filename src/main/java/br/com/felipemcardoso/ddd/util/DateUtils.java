package br.com.felipemcardoso.ddd.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static Date parse(String date) {
        return toDate(LocalDate.from(dtf.parse(date)));
    }

    public static String format(Date date) {
        return dtf.format(toLocalDate(date));
    }

    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    public static Date getDayDate() {

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }


    /**
     * Método que retorna um objeto Date com hora, minutos e segundos.
     *
     * @param date   data
     * @param hour   hora
     * @param minute minuto
     * @param second segundo
     * @return data completa
     */
    public static Date getDateWithTime(Date date, int hour, int minute, int second) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);

        return c.getTime();
    }

    /**
     * Método que retorna um objeto Date com hora, minutos e segundos.
     *
     * @param date data
     * @return data completa
     */
    public static Date getDateWithoutTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    public static Date getFimDoDia(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);

        return c.getTime();
    }

    public static Date adicionarDias(Date date, int dias) {
        Calendar result = Calendar.getInstance();

        result.setTime(date);
        result.set(Calendar.HOUR_OF_DAY, 0);
        result.set(Calendar.MINUTE, 0);
        result.set(Calendar.SECOND, 0);

        result.add(Calendar.DATE, dias);

        return result.getTime();
    }

    public static Date gerarDataVencimento(Date date, Integer numeroParcela) {
        Calendar vencimento = Calendar.getInstance();

        vencimento.setTime(date);
        vencimento.set(Calendar.HOUR_OF_DAY, 0);
        vencimento.set(Calendar.MINUTE, 0);
        vencimento.set(Calendar.SECOND, 0);

        for (int i = 0; i < numeroParcela; i++) {
            vencimento.roll(Calendar.MONTH, true);

            if (vencimento.get(Calendar.MONTH) == 0) {
                vencimento.roll(Calendar.YEAR, true);
            }
        }

        return vencimento.getTime();
    }

}

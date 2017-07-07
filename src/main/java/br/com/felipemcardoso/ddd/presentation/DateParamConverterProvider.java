package br.com.felipemcardoso.ddd.presentation;

import br.com.felipemcardoso.ddd.SegboxConstant;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

@Provider
public class DateParamConverterProvider implements ParamConverterProvider {

	@Override
	public ParamConverter<Date> getConverter(Class rawType, Type genericType, Annotation[] annotations) {

		if (rawType != Date.class) {
			return null;
		}

		return new ParamConverter<Date>() {

			@Override
			public Date fromString(String value) {
				if (value ==  null || value.trim().equals("")) {
					return null;
				}
					
				
				SimpleDateFormat formatter = new SimpleDateFormat(AppJsonMapper.DATE_FORMAT);
				try {
					return formatter.parse(value);
				} catch (Exception ex) {
					throw new WebApplicationException(SegboxConstant.GENERIC_EXCEPTION, 400);
				}
			}

			@Override
			public String toString(Date date) {
				return new SimpleDateFormat(AppJsonMapper.DATE_FORMAT).format(date);
			}
		};
	}
}

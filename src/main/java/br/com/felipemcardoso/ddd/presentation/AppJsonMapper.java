package br.com.felipemcardoso.ddd.presentation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Provider
@Produces(JsonType.APPLICATION_JSON_UTF8)
public class AppJsonMapper implements ContextResolver<ObjectMapper> {

	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	private final ObjectMapper mapper;

	public AppJsonMapper() {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		mapper = new ObjectMapper();
		mapper.setDateFormat(dateFormat);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		SimpleModule module = new SimpleModule();
		module.addSerializer(java.util.Date.class, new DateSerializer(false, dateFormat));
		module.addDeserializer(java.util.Date.class, new CustomJsonDateDeserializer());
		mapper.registerModule(module);
	}

	@Override
	public ObjectMapper getContext(Class<?> objectType) {
		return mapper;
	}
	
	private static class CustomJsonDateDeserializer extends JsonDeserializer<Date> {
		
		@Override
		public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
				throws IOException {

			SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
			String date = jsonparser.getText();
			try {
				return format.parse(date);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}

		}

	}
}
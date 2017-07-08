package com.github.felipemcardoso.ddd.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.felipemcardoso.ddd.domain.common.EventType;
import com.github.felipemcardoso.ddd.domain.common.YesNo;
import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;

public class Event extends Entity<EventId> {

    private Date data;

    private EventType type;

    private YesNo published;

    private String json;

    public Event(EventId key, Date data, EventType type, YesNo publicado, String json) {
        super(key);
        this.data = data;
        this.type = type;
        this.published = publicado;
        this.json = json;
    }

    public static Event create(DomainEvent event) {

        ObjectMapper mapper = new ObjectMapper();

        String json;

        try {

            json = mapper.writeValueAsString(event);

        } catch (JsonProcessingException jpe) {

            throw new RuntimeException(jpe);

        }

        EventId eventId = new EventId(event.getId());

        Date data = event.getOccurredOn();

        return new Event(eventId, data, EventType.PUBLISHED, YesNo.NAO, json);
    }

    public static Event create(String json) {

        JSONObject jsonObject = new JSONObject(json);

        String id = jsonObject.getString("id");

        Date data = new Date(jsonObject.getLong("occurredOn"));

        EventId eventId = new EventId(UUID.fromString(id));

        return new Event(eventId, data, EventType.CONSUMED, YesNo.NAO, json);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getJson() {
        return json;
    }

    public YesNo getPublished() {
        return published;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public boolean isPublicado() {
        return getType() != null && getType().equals(EventType.PUBLISHED);
    }

    public boolean isConsumido() {
        return getType() != null && getType().equals(EventType.CONSUMED);
    }
}

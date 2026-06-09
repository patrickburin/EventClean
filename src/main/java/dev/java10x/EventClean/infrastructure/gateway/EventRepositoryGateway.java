package dev.java10x.EventClean.infrastructure.gateway;
import org.springframework.stereotype.Component;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.infrastructure.mapper.EventEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import dev.java10x.EventClean.infrastructure.persistence.EventRepository;

@Component
public class EventRepositoryGateway implements EventGateway{

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    public EventRepositoryGateway(EventRepository eventRepository, EventEntityMapper entityMapper) {
        this.eventRepository = eventRepository;
        this.eventEntityMapper = entityMapper;
    }

    @Override
    public Event createEvent(Event event) {
        EventEntity entity = eventEntityMapper.toEntity(event);
        EventEntity newEvent = eventRepository.save(entity);
        return eventEntityMapper.toDto(newEvent);
    }

}

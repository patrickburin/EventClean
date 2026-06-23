package dev.java10x.EventClean.infrastructure.gateway;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<Event> searchEvents() {
        return eventRepository.findAll()
                .stream()
                .map(eventEntityMapper::toDto)
                .toList();
    }

    @Override
    public boolean existIdentifyer(String identifyer) {
        return eventRepository.findAll()
                .stream()
                .anyMatch(event -> event.getIdentify().equalsIgnoreCase(identifyer));
    }

    @Override
    public Optional<Event> findEventByIdentifyer(String identifyer) {
        return eventRepository.findByIdentify(identifyer);
    }

}

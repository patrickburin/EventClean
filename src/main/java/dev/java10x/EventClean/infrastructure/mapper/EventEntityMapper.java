package dev.java10x.EventClean.infrastructure.mapper;

import org.springframework.stereotype.Component;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;

@Component
public class EventEntityMapper {

    public EventEntity toEntity(Event event) {
        return new EventEntity(
            event.id(),
            event.name(),
            event.description(),
            event.identify(),
            event.startDate(),
            event.endDate(),
            event.local(),
            event.capacity(),
            event.organizer(),
            event.type()
        );
    }

    public Event toDto(EventEntity eventEntity) {
        return new Event(
            eventEntity.getId(),
            eventEntity.getName(),
            eventEntity.getDescription(),
            eventEntity.getIdentify(),
            eventEntity.getStartDate(),
            eventEntity.getEndDate(),
            eventEntity.getLocal(),
            eventEntity.getCapacity(),
            eventEntity.getOrganizer(),
            eventEntity.getType()
        );
    }

}

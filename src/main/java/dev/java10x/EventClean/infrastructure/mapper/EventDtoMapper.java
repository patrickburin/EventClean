package dev.java10x.EventClean.infrastructure.mapper;


import org.springframework.stereotype.Component;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.infrastructure.dtos.EventDto;

@Component
public class EventDtoMapper {

    public EventDto toDto(Event event) {
        return new EventDto(event.id(),
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

    public Event toEntity(EventDto eventDto) {
        return new Event(eventDto.id(),
                         eventDto.name(),
                         eventDto.description(),
                         eventDto.identify(),
                         eventDto.startDate(),
                         eventDto.endDate(),
                         eventDto.local(),
                         eventDto.capacity(),
                         eventDto.organizer(),
                         eventDto.type()
                        );
    }

}

package dev.java10x.EventClean.infrastructure.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.usecase.CreateEventUseCase;
import dev.java10x.EventClean.infrastructure.dtos.EventDto;
import dev.java10x.EventClean.infrastructure.mapper.EventDtoMapper;


@RestController
@RequestMapping("api/v1/")
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final EventDtoMapper eventDtoMapper;

    public EventController(CreateEventUseCase createEventUseCase, EventDtoMapper eventDtoMapper) {
        this.createEventUseCase = createEventUseCase;
        this.eventDtoMapper = eventDtoMapper;
    }

    @PostMapping("create-event")
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        Event newEvent = createEventUseCase.execute(eventDtoMapper.toEntity(eventDto));

        return eventDtoMapper.toDto(newEvent);
    }

    @GetMapping
    public String listEvent() {
        return "show an event";
    }

}

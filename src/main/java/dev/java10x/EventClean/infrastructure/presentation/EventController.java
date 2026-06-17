package dev.java10x.EventClean.infrastructure.presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.usecase.CreateEventUseCase;
import dev.java10x.EventClean.core.usecase.SearchEventsUseCase;
import dev.java10x.EventClean.infrastructure.dtos.EventDto;
import dev.java10x.EventClean.infrastructure.mapper.EventDtoMapper;


@RestController
@RequestMapping("api/v1/")
public class EventController {

    private final CreateEventUseCase createEventUseCase;
    private final EventDtoMapper eventDtoMapper;
    private final SearchEventsUseCase searchEventUseCase;

    public EventController(CreateEventUseCase createEventUseCase, EventDtoMapper eventDtoMapper, SearchEventsUseCase searchEventUseCase) {
        this.createEventUseCase = createEventUseCase;
        this.eventDtoMapper = eventDtoMapper;
        this.searchEventUseCase = searchEventUseCase;
    }

    @PostMapping("create-event")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto eventDto) {
        Event newEvent = createEventUseCase.execute(eventDtoMapper.toEntity(eventDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Successfully registered event");
        response.put("Datas saved with success: ", eventDtoMapper.toDto(newEvent));
        return ResponseEntity.ok(response);
    }

    @GetMapping("find-events")
    public List<EventDto> searchEvents() {
        return searchEventUseCase.execute()
                .stream()
                .map(eventDtoMapper::toDto)
                .collect(Collectors.toList());
    }

}

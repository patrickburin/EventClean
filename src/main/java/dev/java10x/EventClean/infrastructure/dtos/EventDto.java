package dev.java10x.EventClean.infrastructure.dtos;

import java.time.LocalDateTime;

import dev.java10x.EventClean.core.enums.EventType;

public record EventDto(Long id,
                       String name,
                       String description,
                       String identify,
                       LocalDateTime startDate,
                       LocalDateTime endDate,
                       String local,
                       Integer capacity,
                       String organizer,
                       EventType type) {}

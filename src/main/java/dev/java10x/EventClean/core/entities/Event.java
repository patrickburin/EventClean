package dev.java10x.EventClean.core.entities;

import java.time.LocalDateTime;

import dev.java10x.EventClean.core.enums.EventType;

public record Event(Long id,
                    String name,
                    String description,
                    String identify,
                    LocalDateTime startDate,
                    LocalDateTime endDate,
                    String local,
                    Integer capacity,
                    String organizer,
                    EventType type
) {}

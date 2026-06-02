package dev.java10x.EventClean.infrastructure.persistence;

import java.time.LocalDateTime;

import dev.java10x.EventClean.core.enums.EventType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String identify;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String local;
    private String organizer;
    private EventType type;

}

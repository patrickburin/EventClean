package dev.java10x.EventClean.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.java10x.EventClean.core.entities.Event;

public interface EventRepository extends JpaRepository<EventEntity, Long>{

    Optional<Event> findByIdentify(String identifyer);
}

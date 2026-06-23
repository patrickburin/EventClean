package dev.java10x.EventClean.core.gateway;

import java.util.List;
import java.util.Optional;

import dev.java10x.EventClean.core.entities.Event;

public interface EventGateway {

    Optional<Event> findEventByIdentifyer(String identifyer);
    Event createEvent(Event event);
    List<Event> searchEvents();
    boolean existIdentifyer(String identifyer);

}

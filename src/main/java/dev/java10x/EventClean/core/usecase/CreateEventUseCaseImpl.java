package dev.java10x.EventClean.core.usecase;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.infrastructure.exception.DuplicateEventException;

public class CreateEventUseCaseImpl implements CreateEventUseCase {

    private final EventGateway eventGateway;

    public CreateEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {

        if(eventGateway.existIdentifyer(event.identify())) {
            throw new DuplicateEventException("The identifyer: " + event.identify() + " already exists.");
        }

        return eventGateway.createEvent(event);
    }

}

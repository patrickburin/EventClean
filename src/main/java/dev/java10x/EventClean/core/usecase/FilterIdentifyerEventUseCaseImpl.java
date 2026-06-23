package dev.java10x.EventClean.core.usecase;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.infrastructure.exception.NotFoundEventException;

public class FilterIdentifyerEventUseCaseImpl implements FilterIdentifyerEventUseCase{

    private final EventGateway eventGateway;

    public FilterIdentifyerEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identifyer) {
        return eventGateway.findEventByIdentifyer(identifyer)
                .orElseThrow(() -> new NotFoundEventException("Event with identifyer: " + identifyer + " not found."));
    }

    

}

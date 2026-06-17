package dev.java10x.EventClean.core.usecase;

import java.util.List;
import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.gateway.EventGateway;

public class SearchEventsUseCaseImpl implements SearchEventsUseCase {

    private final EventGateway eventGateway;

    public SearchEventsUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.searchEvents();
    }

}

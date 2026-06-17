package dev.java10x.EventClean.core.usecase;

import java.util.List;
import dev.java10x.EventClean.core.entities.Event;

public interface SearchEventsUseCase {

    public List<Event> execute();

}

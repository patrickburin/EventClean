package dev.java10x.EventClean.core.usecase;

import dev.java10x.EventClean.core.entities.Event;

public interface FilterIdentifyerEventUseCase {

    public Event execute(String identifyer);
}

package dev.java10x.EventClean.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.core.usecase.CreateEventUseCase;
import dev.java10x.EventClean.core.usecase.CreateEventUseCaseImpl;
import dev.java10x.EventClean.core.usecase.SearchEventsUseCase;
import dev.java10x.EventClean.core.usecase.SearchEventsUseCaseImpl;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUseCase createEventUseCase(EventGateway eventGateway) {
        return new CreateEventUseCaseImpl(eventGateway);
    }

    @Bean
    public SearchEventsUseCase searchEventsUseCase(EventGateway eventGateway) {
        return new SearchEventsUseCaseImpl(eventGateway);
    }

}

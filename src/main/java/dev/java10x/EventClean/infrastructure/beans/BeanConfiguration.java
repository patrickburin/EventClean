package dev.java10x.EventClean.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.java10x.EventClean.core.gateway.EventGateway;
import dev.java10x.EventClean.core.usecase.CreateEventUseCase;
import dev.java10x.EventClean.core.usecase.CreateEventUseCaseImpl;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUseCase createEventUseCase(EventGateway eventGateway) {
        return new CreateEventUseCaseImpl(eventGateway);
    }

}

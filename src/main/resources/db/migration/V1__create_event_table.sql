-- V1_create-event-table.sql

CREATE TABLE Events (

    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    identify VARCHAR(255) NOT NULL UNIQUE,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    local VARCHAR(255) NOT NULL,
    capacity INTEGER NOT NULL,
    organizer VARCHAR(255) NOT NULL,
    type VARCHAR(255)
);
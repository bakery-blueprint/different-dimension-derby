package com.github.bakery.ddd.event_sourcing;

public class Event {
    private EventId id;
    private EventType eventType;
    private EntityType entityType;
    private EntityId entityId;
    private String eventDataJson;
}

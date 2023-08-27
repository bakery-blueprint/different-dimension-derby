package com.github.bakery.ddd.event_sourcing;

public class Snapshot {
    private EventId eventId;
    private EntityType entityType;
    private EntityId entityId;
    private String snapshotDataJson;
}

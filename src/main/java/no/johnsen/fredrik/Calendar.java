package no.johnsen.fredrik;

import java.util.*;
class Calendar {
    private Storage storage;
    public Calendar(Storage eventStorage) {
        this.storage = eventStorage;
    }
    public List<Event> getEvents() {
        return this.storage.fetchEvents();
    }
    public void addEvent(Event event) {
        this.storage.save(event);
    }

    public void deleteEvent (Event event) {
        this.storage.delete(event);
    }
    public String toString() {
        String temp = "";
        for( Event event : this.getEvents() ) {
            temp += event.toString();
        }
        return temp;
    }
}
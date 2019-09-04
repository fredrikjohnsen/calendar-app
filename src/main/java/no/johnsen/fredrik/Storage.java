package no.johnsen.fredrik;

import java.util.*;
interface Storage {
    public List<Event> fetchEvents();
    public void save(Event event);
    public void delete(Event event);
}
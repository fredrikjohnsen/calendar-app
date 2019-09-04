package no.johnsen.fredrik;

import java.io.Serializable;
class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    private String startTime;
    private String endTime;
    private String title;
    private String description;

    public Event(String startTime, String endTime, String title, String description ) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.description = description;
    }
    public String toString() {
        String[] show = {this.title, this.startTime, this.endTime, this.description};
        return String.join("\n",show );
    }
}
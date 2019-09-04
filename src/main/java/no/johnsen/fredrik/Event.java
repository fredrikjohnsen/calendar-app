package no.johnsen.fredrik;

import java.io.Serializable;
import java.util.regex.*;  

class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    private String startTime;
    private String endTime;
    private String title;
    private String description;

    public Event(String startTime, String endTime, String title, String description ) {
        Pattern t = Pattern.compile("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}$");
        if (!(t.matcher(startTime).matches() && t.matcher(startTime).matches())) {
            throw new IllegalArgumentException("Wrong date format");
        }
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.description = description;
    }

    public String toString() {
        String[] show = { this.startTime, this.endTime, this.title, this.description };
        return String.join("\t", show );
    }
    public String[] toStringArray() {
        String[] show = {this.startTime, this.endTime, this.title, this.description };
        return show;
    }
}
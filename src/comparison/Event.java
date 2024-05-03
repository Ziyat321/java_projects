package comparison;

import java.time.LocalTime;

public class Event {

    private String name;
    private LocalTime start;
    private int duration;

    public Event(String name, LocalTime start, int duration) {
        this.name = name;
        this.start = start;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return name + "\t\t" + start + "-" + start.plusMinutes(duration);
    }

    public String getName() {
        return name;
    }

    public LocalTime getStart() {
        return start;
    }

    public int getDuration() {
        return duration;
    }
}

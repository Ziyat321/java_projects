package comparison;

import java.util.List;

public class EventOutOfScheduleException extends RuntimeException{

    private List<Event> eventList;

    public EventOutOfScheduleException(Event event){
        super("Событие " + event.getName() + " невозможно добавить в расписание.");
    }

    public EventOutOfScheduleException(List<Event> eventList){
        this.eventList = eventList;
    }

    public List<Event> getEventList() {
        return eventList;
    }
}

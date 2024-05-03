package comparison;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventsSyllabus {


    private List<Event> events;

    public EventsSyllabus() {
        this.events = new ArrayList<Event>();
    }

    public void addEvent(Event e) {
        /*LocalTime start = e.getStart();
        LocalTime end = start.plusMinutes(e.getDuration());*/
        //boolean contains = false;
      /*  for (Event event : events) {
            LocalTime start1 = event.getStart();
            LocalTime end1 = start1.plusMinutes(event.getDuration());
            if((start.compareTo(start1) >= 0 && start.compareTo(end1) < 0) ||
                    (end.compareTo(start1) > 0 && end.compareTo(end1) <= 0) ) {
                contains = true;
                break;
            }
        }
        if(!contains) events.add(e);
        sortEvents();*/
        if (events.size() == 0) {
            events.add(e);
        } else {
            /*boolean added = false;
            for (int i = 0; i < events.size() - 1; i++) {
                LocalTime endCurrent = events.get(i).getStart().plusMinutes(events.get(i).getDuration());
                LocalTime startNext = events.get(i + 1).getStart();
                if (start.compareTo(endCurrent) >= 0 && end.compareTo(startNext) <= 0) {
                    events.add(i + 1, e);
                    added = true;
                    break;
                }
            }  // проверка на вклинение между, начиная от первого до между предпоследним и последним

            if (!added) {
                Event first = events.get(0);
                LocalTime startFirst = first.getStart();
                if (end.compareTo(startFirst) <= 0) {
                    events.add(0, e);
                    added = true;
                }

                Event last = events.get(events.size() - 1);
                LocalTime endLast = last.getStart().plusMinutes(last.getDuration());
                if (start.compareTo(endLast) >= 0) {
                    events.add(events.size(), e);
                    added = true;
                }  // допроверка, должен ли он встать в самое начало или в самый конец
            }*/

            int i = indexOfEventToPut(e);
            if (i == -1) throw new EventOutOfScheduleException(e);
            else events.add(i, e);
        }
    }

    public void checkFreeTimeFor(Event... events) {
        if (this.events.size() > 0) {
            List<Event> extraEvents = new ArrayList<>();
            for (Event event : events) {
                int i = indexOfEventToPut(event);
                if (i == -1) extraEvents.add(event);
            }
            if (extraEvents.size() > 0) throw new EventOutOfScheduleException(extraEvents);
        }
    }

    private int indexOfEventToPut(Event e){
        LocalTime start = e.getStart();
        LocalTime end = start.plusMinutes(e.getDuration());

        for (int i = 0; i < events.size() - 1; i++) {
            LocalTime endCurrent = events.get(i).getStart().plusMinutes(events.get(i).getDuration());
            LocalTime startNext = events.get(i + 1).getStart();
            if (start.compareTo(endCurrent) >= 0 && end.compareTo(startNext) <= 0) {
                return i+1;
            }
        }  // проверка на вклинение между, начиная от первого и второго до между предпоследним и последним

        Event first = this.events.get(0);
        LocalTime startFirst = first.getStart();
        if (end.compareTo(startFirst) <= 0) {
            return 0;
        }

        Event last = this.events.get(this.events.size() - 1);
        LocalTime endLast = last.getStart().plusMinutes(last.getDuration());
        if (start.compareTo(endLast) >= 0) {
            return events.size();
        }  // допроверка, должен ли он встать в самое начало или в самый конец

        return -1;
    }

    public Event nearestEvent(LocalTime time) {
        Event first = events.get(0);
        Event last = events.get(events.size()-1);
        if (time.compareTo(first.getStart()) <= 0) return first;
        if (time.compareTo(last.getStart()) >= 0) return last;
        for (int i = 1; i < events.size(); i++) {
            if (time.compareTo(events.get(i).getStart()) <= 0) {
                Event nextEvent = events.get(i);
                Event prevEvent = events.get(i-1);
                LocalTime next = nextEvent.getStart();
                LocalTime prev = prevEvent.getStart();
                Duration durationNext = Duration.between(time, next);
                Duration durationPrev = Duration.between(prev, time);
                if (durationNext.toMinutes() < durationPrev.toMinutes()) return nextEvent;
                else return prevEvent;
            }
        }
        return null;
    }


    public Event[] longestThree(){
        int size = events.size();
        if(size < 3) {
            Event[] events1 = new Event[size];
            for (int i = 0; i < size; i++) {
                events1[i] = events.get(i);
            }
            return events1;
        } else {

            Event[] events1 = new Event[]{events.get(0), events.get(1), events.get(2)};
            int first = events1[0].getDuration();
            int second = events1[1].getDuration();
            int third = events1[2].getDuration();
            int minDuration = first;
            int minPos = 0;
            if(second < first && second < third) {
                minDuration = second;
                minPos = 1;
            }
            if(third < first && third < second) {
                minDuration = third;
                minPos = 2;
            }
            for (int i = 3; i < size; i++) {
                Event e = events.get(i);
                if(e.getDuration() > minDuration) {
                    if(minPos == 0){
                        events1[0] = events1[1];
                        events1[1] = events1[2];
                        events1[2] = e;
                    } else if (minPos == 1) {
                        events1[1] = events1[2];
                        events1[2] = e;
                    } else {
                        events1[2] = e;
                    }
                }
                first = events1[0].getDuration();
                second = events1[1].getDuration();
                third = events1[2].getDuration();
                minDuration = first;
                minPos = 0;
                if(second < first && second < third) {
                    minDuration = second;
                    minPos = 1;
                }
                if(third < first && third < second) {
                    minDuration = third;
                    minPos = 2;
                }
            }
            return events1;
        }
    }


    public void printEvent() {
        int maxLength = events.get(0).getName().length();
        for (Event event : events) {
            int currentLength = event.getName().length();
            if (currentLength > maxLength) maxLength = currentLength;
        }

        for (Event event : events) {
            System.out.print(event.getName());
            int currentLength = event.getName().length();
            for (int i = 0; i <= maxLength - currentLength; i++) {
                System.out.print(" ");
            }
            System.out.print("\t\t");
            System.out.println(event.getStart() + "-" + event.getStart().plusMinutes(event.getDuration()));
        }
    }

    public List<Event> getEvents() {
        return events;
    }
}

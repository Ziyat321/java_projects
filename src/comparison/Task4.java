package comparison;

import org.w3c.dom.events.EventException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Task4 {


    public static void main(String[] args) {
        Event e1 = new Event("Birthday", LocalTime.of(12, 30), 40); // 12:30 - 13:10
        Event e2 = new Event("Football", LocalTime.of(13, 00), 30); // 13:00 - 13:30
        Event e3 = new Event("Olympiad", LocalTime.of(11, 00), 60); // 11:00 - 12:00
        Event e4 = new Event("Lecture", LocalTime.of(13, 20), 40); // 13:20 - 14:00
        Event e5 = new Event("Lunch", LocalTime.of(12,10), 20); //12:10 - 12:30
        Event e6 = new Event("Breakfast", LocalTime.of(10,00), 60); // 10:00 - 11:00

        Event[] events = new Event[]{e1, e2, e3, e4, e5, e6};
        EventsSyllabus syllabus = new EventsSyllabus();

        for (Event event : events) {
            try{
                syllabus.addEvent(event);
            } catch (EventOutOfScheduleException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        syllabus.printEvent();
        System.out.println();

        System.out.println(syllabus.nearestEvent(LocalTime.of(14,35)));
        System.out.println();

        for (Event event : syllabus.longestThree()) {
            System.out.println(event);
        }

        System.out.println();
        
        try{
            syllabus.checkFreeTimeFor(events);
        } catch (EventOutOfScheduleException e){
            for (Event event : e.getEventList()) {
                System.out.println("Событие " + event.getName() + " невозможно добавить в расписание.");
            }
        }


    }


}

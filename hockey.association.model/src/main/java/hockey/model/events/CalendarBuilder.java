package hockey.model.events;

import java.util.Collection;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;

public class CalendarBuilder {

    public static String build(Collection<Event> events) {
        Calendar calendar = new Calendar();
        calendar.getProperties().add(new ProdId("-//Hockey Association//iCal4j 1.0//EN"));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(CalScale.GREGORIAN);

        if (events != null) {
            for (Event event : events) {
                addEvent(calendar, event);
            }
        }

        return calendar.toString();
    }

    private static void addEvent(Calendar calendar, Event event) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(java.util.Calendar.MONTH, java.util.Calendar.DECEMBER);
        cal.set(java.util.Calendar.DAY_OF_MONTH, 25);
        VEvent christmas = new VEvent(new Date(cal.getTime()), "Christmas Day");

        calendar.getComponents().add(christmas);
    }
}

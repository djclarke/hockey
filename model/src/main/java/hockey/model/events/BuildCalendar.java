package hockey.model.events;

import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;

public class BuildCalendar {

    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        calendar.getProperties().add(new ProdId("-//Hockey Association//iCal4j 1.0//EN"));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(CalScale.GREGORIAN);

        System.out.println(calendar); 
    }
}

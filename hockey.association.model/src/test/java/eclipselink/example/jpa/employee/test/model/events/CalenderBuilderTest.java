/*******************************************************************************
 * Copyright (c) 2014  All rights reserved.
 ******************************************************************************/
package eclipselink.example.jpa.employee.test.model.events;

//import hockey.model.events.CalendarBuilder;
import hockey.model.events.Event;
import hockey.model.events.Game;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class CalenderBuilderTest {

    @Test
    public void create() {
        List<Event> events = new ArrayList<Event>();
        Game game = new Game();
        events.add(game);
        
        String ics = hockey.model.events.CalendarBuilder.build(events);
        
        Assert.assertNotNull(ics);
        
        System.out.print(ics);
    }

    
    @Test
    public void loadADS() throws IOException, ParserException {
       InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("ADS.ics");

        CalendarBuilder builder = new CalendarBuilder();

        Calendar calendar = builder.build(in);
        
        calendar.toString();
    }

}

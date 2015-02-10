package hockey.model.events;

import hockey.model.BaseEntity;
import hockey.model.Person;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Attendance extends BaseEntity {

    private Event event;

    private Map<Person, PersonAttendance> personAttends = new HashMap<>();

    private boolean expected = true;

    private Person expectedSetBy = null;

    private Calendar expectedSetAt = null;

    private boolean actual = true;

    private Person actualSetBy = null;

    private Calendar actualSetAt = null;

    protected Attendance(Event event, Map<Person, PersonAttendance> personAttends) {
        super();
        this.event = event;
        this.personAttends = personAttends;
    }

    public Event getEvent() {
        return event;
    }

    public Map<Person, PersonAttendance> getPersonAttends() {
        return personAttends;
    }

    public boolean isExpected() {
        return this.expected;
    }

    public Person getExpectedSetBy() {
        return expectedSetBy;
    }

    public Calendar getExpectedSetAt() {
        return expectedSetAt;
    }

    public void setExpected(boolean expected, Person person, Calendar at) {
        this.expected = expected;
        this.expectedSetBy = person;
        this.expectedSetAt = at;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    public Person getActualSetBy() {
        return actualSetBy;
    }

    public Calendar getActualSetAt() {
        return actualSetAt;
    }
}

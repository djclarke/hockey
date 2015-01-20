package hockey.model.events;

import java.util.Calendar;

import hockey.model.BaseEntity;

public abstract class Event extends BaseEntity {
    
    private String name;
    
    /**
     * Start time of the event
     */
    private Calendar date;
    
    /**
     * Duration of the event in minutes
     */
    private int duration = 60;
    
    private boolean fullDay = false;
    
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isFullDay() {
        return fullDay;
    }

    public void setFullDay(boolean fullDay) {
        this.fullDay = fullDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}

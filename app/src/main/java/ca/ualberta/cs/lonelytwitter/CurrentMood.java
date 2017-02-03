package ca.ualberta.cs.lonelytwitter;

/**
 * Created by htruong1 on 1/19/17.
 */
/**
 * Abstract class that is meant to fetch moods and return them
 */

import java.util.Date;

/**
 * Class is used to get current dates and moods and returns them for use
 */
public abstract class CurrentMood {
    private Date date;
    protected String mood;

    public CurrentMood(String mood){
        this.mood = mood;
        this.date = new Date();
    }
    public CurrentMood(Date date, String mood){
        this.mood = mood;
        this.date = date;
    }
    public Date getDate(){
        return date;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public abstract String printMood();
}

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by htruong1 on 1/19/17.
 */

/**
 * This public class returns the string "I'm Sad" when called
 */
public class SadMood extends CurrentMood {
    /**
     * returns the string "I'm sad"
     * @param date
     * @param mood
     */
    public SadMood(Date date, String mood) {
        super(date, mood);
    }

    public SadMood(String mood) {
        super(mood);
    }
    public String printMood(){
        return "I'm sad";
    }
}

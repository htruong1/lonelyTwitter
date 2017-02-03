package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
/**
 * Created by htruong1 on 1/19/17.
 */

/**
 * Class that gets the current date and adds ! to the mood
 */
public class HappyMood extends CurrentMood {
    /**
     * Returns the string mood with ! at the end
     * @param date
     * @param mood
     */
    public HappyMood(Date date, String mood) {
        super(date, mood);
    }

    public HappyMood(String mood) {
        super(mood);
    }

    public String printMood() {
        return this.mood + "!";
    }
}


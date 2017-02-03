package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by htruong1 on 1/19/17.
 *  The type Lonely twitter activity
 */

/**
 * A class that inherits from CurrentMood. This class returns the string "I am depressed"
 */

/**
 * Returns the string "I am depressed"
 */
public class DepressingMood extends CurrentMood{
    /**
     * public class that returns "I am depressed"
     * @param date
     * @param mood
     */
    public DepressingMood(Date date, String mood) {
        super(date, mood);
    }

    public DepressingMood(String mood) {
        super(mood);
    }

    public String printMood(){
        return "I am depressed";


    }
}
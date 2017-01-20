package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by htruong1 on 1/19/17.
 */

public class DepressingMood extends CurrentMood{
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
package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by htruong1 on 1/19/17.
 */

public class SadMood extends CurrentMood {
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

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
/**
 * Created by htruong1 on 1/19/17.
 */

public class HappyMood extends CurrentMood {
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


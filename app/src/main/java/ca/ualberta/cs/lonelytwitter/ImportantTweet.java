package ca.ualberta.cs.lonelytwitter;

import java.util.Date;



/**
 * Created by htruong1 on 1/19/17.
 */

/**
 * A class extending from Tweet that determines if a tweet is important by returning
 * a boolena value true
 */


public class ImportantTweet extends Tweet {
    /**
     * Returns boolean value true for important tweet
     * @param message
     */
    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }
    @Override
    public Boolean isImportant(){
        return true;
    }
}

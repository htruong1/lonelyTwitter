package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by htruong1 on 1/19/17.
 */

/**
 * Normal Tweet class extending from tweet. Sets the boolean value false and returns
 * false signaling that it is not important
 */
public class NormalTweet extends Tweet {
    /**
     * returns the boolean value false signifyign importanceo f tweet
     * @param message
     */
    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(Date date, String message) {
        super(date, message);
    }
    @Override
    public Boolean isImportant(){
        return false;
    }
}

package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
/**
 * Created by htruong1 on 1/19/17.
 */

/**
 * A tweet class that uses the TweeTooLongException if the length is too long,
 * gets the tweet and gets importance of tweets (true or false is returned from its children
 * class
 */
public abstract class Tweet implements Tweetable{
    /**
     * Abstract class that sends out the string and shows it
     */
    private Date date;
    private String message;
    private ArrayList<CurrentMood> moodList;
    public Tweet(String message) {
        this.message = message;
        this.date = new Date(); /*new instance */
    }

    public Tweet(Date date, String message) {
        this.message = message;
        this.date = date;
    }


    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140) {
            throw new TweetTooLongException();

        }

        this.message = message;
    }
    public abstract Boolean isImportant();
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }

}
package ca.ualberta.cs.lonelytwitter;

/**
 * Created by htruong1 on 1/19/17.
 */

/**
 * Public interface that gets the string and if the string
 * is too long, it throws the exception
 */
public interface Tweetable {
    public String getMessage();
    public void setMessage(String string) throws TweetTooLongException;






}

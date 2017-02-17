package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.R.id.list;

/**
 * Created by watts1 on 1/28/16.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private List orderList = tweets;
    public void add(Tweet tweet) {
        if (hasTweet(tweet) == false) {
            tweets.add(tweet);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean hasTweet(Tweet tweet){

        return tweets.contains(tweet); //returns a boolean value because it is a retrn value
    }

    public void delete(Tweet tweet){

        tweets.remove(tweet);
    }

    public Tweet getTweet(int index){

        return tweets.get(index);
    }
    public Integer getCount(){
        return tweets.size();
    }
    public List tweetOrder(){
        Collections.sort(orderList); //TA suggested the use of CollectionsSort.
        return orderList;
    }



}

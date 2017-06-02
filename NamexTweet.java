/**
 * @(#)NamexTweet.java
 *
 * NamexTweet application
 *
 * @author 
 * @version 1.00 2017/5/9
 */
import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "vfXV1eHncxuL3iliFUl432Mrf";
    private final static String CONSUMER_KEY_SECRET = "1NCD78bMfOj3nmRATYVLiADNGcYZjs9LgyY3uw78EydowoWQdt";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("malam");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "QX2a08zjev1r1QMHah4NX9p6K20eUfPJVvyl2yQDc2Kr5";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "861892601309315072-SmSJlLG3mqwxkhfceWfiWJa4p8az47N";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
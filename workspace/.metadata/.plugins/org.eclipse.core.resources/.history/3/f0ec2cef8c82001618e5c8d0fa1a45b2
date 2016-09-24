
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterApp {

	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub

		ConfigurationBuilder cb =  new ConfigurationBuilder();
		
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey("consume key")
			.setOAuthConsumerSecret("secret")
			.setOAuthAccessToken("access token")
			.setOAuthAccessTokenSecret("toekn secret");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter4j.Twitter twitter = tf.getInstance();
		
		//FOR FETCHING HOMETIMELINE TWEETS
		//List<Status> status = twitter.getHomeTimeline();
		/*for(Status s : status){
			
			//System.out.println(s.getUser().getName()+"--->"+s.getText()+"=="+s.getGeoLocation());
			System.out.println(s.getUser().getName()+"--->"+s.getText()+"=="+s.getPlace());
		}
		*/
		
		// FOR SEARCHING TWEETS
		QueryResult result = twitter.search(new Query("India"));
		System.out.println(result.getCount());
		List<Status> status = result.getTweets();
		for(Status s : status){
			
			System.out.println(s.getUser().getName()+"---"+s.getText()+"=="+s.getGeoLocation());
		}
	}

}

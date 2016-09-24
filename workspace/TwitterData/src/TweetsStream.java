import java.util.List;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetsStream {

	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub

		ConfigurationBuilder cb =  new ConfigurationBuilder();
		
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey("consumer key")
			.setOAuthConsumerSecret("consume secret ")
			.setOAuthAccessToken("access token")
			.setOAuthAccessTokenSecret("access token secret");
		
		TwitterStream tstream = new TwitterStreamFactory(cb.build()).getInstance();
		StatusListener listener = new StatusListener(){
	        public void onStatus(Status status) {
	        	
	        	if(status.getGeoLocation()!=null)
	        		System.out.println(status.getUser().getName() + " : " + status.getText()+": "+status.getGeoLocation());
	        }
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }
			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}
	    };
	    tstream.addListener(listener);
	    // sample() method internally creates a thread which manipulates TwitterStream and calls these adequate listener methods continuously.
	    tstream.sample();
	}

}

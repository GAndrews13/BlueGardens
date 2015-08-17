package com.netbuilder.controller;

import java.util.ArrayList;

import com.netbuilder.model.twitterMessage;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuth2Token;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class twitterMessageController {
	//Variables
	private Twitter twitter;
	private final String consumerKey="kKiMToNxsfZbnE6o2sDI3vxhd"; 
	private final String consumerSecret="4eETlLoTsEwNQxrjYLqxHaBUvRcjurARmhJRwXoRtnq6d2x6Hn";
	private final String accessToken ="3427813097-P1pz8l2voYGL2VOvrNkr2SKEoX18rDaOnQlXpep";
	private final String accessSecret="yO6rPLryFIYHOtyy0gpcXdJqlu1FFm8rP1d7sQOj4xh5c";
	private final AccessToken accessTokenComplete = new AccessToken("3427813097-P1pz8l2voYGL2VOvrNkr2SKEoX18rDaOnQlXpep","O6rPLryFIYHOtyy0gpcXdJqlu1FFm8rP1d7sQOj4xh5c");
	private final String username = "NB_Gardens";
	private final String password = "netbuilder";
	//End Of Variables
	
	/**
	 * Creates and initalises the required variables for the twitter Message Controller
	 */
	public twitterMessageController()
	{	
		ConfigurationBuilder cb = new ConfigurationBuilder();
		/*
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey(consumerKey);
		cb.setOAuthConsumerSecret(consumerSecret);
		cb.setOAuthAccessToken(accessToken);
		cb.setOAuthAccessTokenSecret(accessSecret);
		*/
		cb.setDebugEnabled(true)
        .setOAuthConsumerKey(consumerKey)
        .setOAuthConsumerSecret(consumerSecret)
        .setOAuthAccessToken(accessToken)
        .setOAuthAccessTokenSecret(accessSecret);
		cb.setUser(username);
		cb.setPassword(password);
		cb.setHttpProxyPort(8080);
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance(); 
		twitter.setOAuthAccessToken(accessTokenComplete);
		
		try
		{	
		}
		catch (Exception e)
		{
			loggingHandle.errorLog(e, "TMC-TMCE01");
		}
	}
	
	/**
	 * Costs a tweet containing the message posted
	 * @param inMessage The actual content of the tweet
	 */
	public void postTweet(String inMessage)
	{
		try
		{
			Status status = twitter.updateStatus(inMessage);
			loggingHandle.log("TMC-PT01", "Tweet Posted:" + inMessage);
		}
		catch (Exception e)
		{
			loggingHandle.errorLog(e, "TMC-PTE01");
		}
	}

	/**
	 * returns all tweets containing the hastag "#NBGardens"
	 * @return a list of twitter messages that contain the nbgardens hashtag
	 */
	public ArrayList<twitterMessage> searchTweets()
	{
		ArrayList<twitterMessage> returnList = new ArrayList<twitterMessage>();
		Query query = new Query("#NBGardens");
		try
		{
			QueryResult result = twitter.search(query);
			
			for(Status status : result.getTweets())
			{
				twitterMessage tm =new twitterMessage(status.getUser(),status.getText()); 
				returnList.add(tm);
				System.out.println(tm);
			}
		}
		catch (Exception e)
		{
			loggingHandle.errorLog(e, "TMC-STE01");
		}
		return returnList;
	}
	
	/**
	 * returns all tweets containing the hastag defined (WARNING: automatically contains the #)
	 * @return a list of twitter messages that contain the defined hastag
	 */
	public ArrayList<twitterMessage> searchTweets(String inHashtag)
	{
		ArrayList<twitterMessage> returnList = new ArrayList<twitterMessage>();
		twitter = TwitterFactory.getSingleton();
		//Checks if the user has already put in the #, if not adds it
		if(!inHashtag.startsWith("#"))
		{
			inHashtag = "#"+inHashtag;
		}
		Query query = new Query(inHashtag);
		try
		{
			QueryResult result = twitter.search(query);
			
			for(Status status : result.getTweets())
			{
				twitterMessage tm =new twitterMessage(status.getUser(),status.getText()); 
				returnList.add(tm);
				System.out.println(tm);
			}
		}
		catch (Exception e)
		{
			loggingHandle.errorLog(e, "TMC-STE01");
		}
		return returnList;
	}
}

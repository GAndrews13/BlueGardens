package com.netbuilder.controller;

import java.util.ArrayList;

import com.netbuilder.model.twitterMessage;

import twitter4j.*;

public class twitterMessageController {
	
	public void postTweet(String inMessage)
	{
		try
		{
			Twitter twitter = TwitterFactory.getSingleton();
			Status status = twitter.updateStatus(inMessage);
			loggingHandle.log("TMC-PT01", "Tweet Posted:" + inMessage);
		}
		catch (Exception e)
		{
			loggingHandle.errorLog(e, "TMC-PTE01");
		}
	}

	public ArrayList<twitterMessage> searchTweets()
	{
		ArrayList<twitterMessage> returnList = new ArrayList<twitterMessage>();
		Twitter twitter = TwitterFactory.getSingleton();
		Query query = new Query("NBGardens");
		try
		{
			QueryResult result = twitter.search(query);
			
			for(Status status : result.getTweets())
			{
				returnList.add(new twitterMessage(status.getUser(),status.getText()));
			}
		}
		catch (Exception e)
		{
			loggingHandle.errorLog(e, "TMC-STE01");
		}
		return returnList;
	}
}
